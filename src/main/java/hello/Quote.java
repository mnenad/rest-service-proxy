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
public class Quote {

    private String type;
    private Value value;
	public String getType() {
		return type;
	}
	public Value getValue() {
		return value;
	}
	
}
