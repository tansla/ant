package ant.controllers;

import ant.dto.IncomingDTO;
import ant.dto.OutcomingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AntController {


        @Autowired
        private static RestTemplate restTemplate;

        private static String url = "http://176.12.100.246:7777/";


    public static IncomingDTO postRequest(@RequestBody OutcomingDTO request, boolean isHello){
        System.out.println(request.toString());
        restTemplate = new RestTemplate();
        String updatedURL =  url + (isHello ? "hello" : "try_to_move");
        ResponseEntity<IncomingDTO> response =
                restTemplate.postForEntity(updatedURL,request, IncomingDTO.class);
   //       IncomingDTO result = restTemplate.postForObject(url, request,IncomingDTO.class);

        IncomingDTO result = response.getBody();
      //  System.out.println(result.toString());


        return result;
    }


}
