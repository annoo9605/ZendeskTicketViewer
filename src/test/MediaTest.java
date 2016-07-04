package test;

import static junit.framework.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class MediaTest {

//	JUnit Test the Media Type
	    @Test
	    public void
	     givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
	     throws ClientProtocolException, IOException{
	       // Given
	       String jsonMimeType = "application/json";
	       HttpUriRequest request = new HttpGet( "https://wooyoung.zendesk.com/api/v2/tickets.json" );
	       
	     
	       // When
	       HttpResponse response = HttpClientBuilder.create().build().execute( request );
	      
	     
	       // Then
	       String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	       assertEquals( jsonMimeType, mimeType );
	    }
	    
	
}
