package ant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JavaConfig {

    @Bean("bean")
    public RestTemplate rest2(){
        return new RestTemplate();
    }

}
