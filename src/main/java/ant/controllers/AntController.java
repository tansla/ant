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

        private static String url = "http://176.12.100.246:7777/hello";


    public static IncomingDTO helloRequest(@RequestBody OutcomingDTO request){
        System.out.println(request.toString());
        restTemplate = new RestTemplate();

        ResponseEntity<IncomingDTO> response =
                restTemplate.postForEntity(url,request, IncomingDTO.class);
   //       IncomingDTO result = restTemplate.postForObject(url, request,IncomingDTO.class);

        IncomingDTO result = response.getBody();
        System.out.println(result.toString());


        return result;
    }

}
