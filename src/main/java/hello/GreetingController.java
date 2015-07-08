package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/*http://localhost:8080/greeting?name=User
{
 "id": 1,
 "content": "Hello, User!"
}
 */
@RestController
public class GreetingController {
	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
	private static final String restURL1="http://gturnquist-quoters.cfapps.io/api/1";
	private static final String restURL2="http://gturnquist-quoters.cfapps.io/api/2";
	private static final String restURL3="http://gturnquist-quoters.cfapps.io/api/3";

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting[] greeting(@RequestParam(value="name", defaultValue="World") String name) {
      	RestTemplate restTemplate = new RestTemplate();
        Quote quote1 = restTemplate.getForObject(restURL1, Quote.class);
        Quote quote2 = restTemplate.getForObject(restURL2, Quote.class);
        
        Greeting[] greetingArray = new Greeting[3];
        
        log.info("###Quote 2###"+quote2.toString()+"###");
        log.info("***Quote 1***"+quote1.toString()+"***");
        
        greetingArray[0]=new Greeting(counter.incrementAndGet(),
        				String.format(template, name),
        				quote1.getValue().getId(),
        				quote1.getValue().getQuote());
        
        greetingArray[1]=new Greeting(counter.incrementAndGet(),
				String.format(template, name),
				quote2.getValue().getId(),
				quote2.getValue().getQuote());
                
        if (quote1.getValue().getId().intValue() < quote2.getValue().getId().intValue()){
        	Quote quote3 = restTemplate.getForObject(restURL3, Quote.class);
        	log.info("///Quote 3///"+quote3.toString()+"///");
        	greetingArray[2]=new Greeting(counter.incrementAndGet(),
    				String.format(template, name),
    				quote2.getValue().getId(),
    				quote2.getValue().getQuote());
        }
        return greetingArray;
    }
}
