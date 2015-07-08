package hello;
/*
{
 "id": 1,
 "content": "Hello, World!"
}
 */
public class Greeting {

    private final long id;
    private final String content;
    private final long quoteId;
    private final String quote;

    public Greeting(long id, String content, long quoteId, String quote) {
        this.id = id;
        this.content = content;
        this.quoteId=quoteId;
        this.quote=quote;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

	
	public long getQuoteId() {
		return quoteId;
	}
	
	public String getQuote() {
		return quote;
	}
}
