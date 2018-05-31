package sleuth.webmvc;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;
import java.util.Random;


@EnableAutoConfiguration
@RestController
public class Backend {

  private static Random r = new Random();


  @RequestMapping("/api") public String printDate()  throws java.lang.InterruptedException {
	TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
    return new Date().toString();
  }

  public static void main(String[] args) {
    SpringApplication.run(Backend.class,
        "--spring.application.name=backend",
        "--server.port=9000"
    );
  }
}
