package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
/*
{
type: "success",
value: {
id: 1,
quote: "Working with Spring Boot is like pair-programming with the Spring developers."
}
}
*/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private Long id;
    private String quote;
	public Long getId() {
		return id;
	}
	public String getQuote() {
		return quote;
	}
	
	

}
