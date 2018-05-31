package sleuth.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.TimeUnit;
import java.util.Random;

@EnableAutoConfiguration
@RestController
@CrossOrigin // So that javascript can be hosted elsewhere
public class Intermediate {

  private static Random r = new Random();

  @Autowired RestTemplate restTemplate;

  @RequestMapping("/api") public String callBackend() throws java.lang.InterruptedException {
    System.out.println("Intermediate Called!");
    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
    String s = restTemplate.getForObject("http://localhost:9000/api", String.class);
    System.out.println("Returned from Backend:"+s);
    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
    return s;
  }

  @Bean RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    r = new Random();
    SpringApplication.run(Intermediate.class,
        "--spring.application.name=intermediate",
        "--server.port=8082"
    );
  }
}
