package iot.client;

import java.io.IOException;
import java.text.ParseException;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class MyClient {

	public static void main(String[] args) {
		
		System.out.print("PIPPO\n");
		
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/hello");
				
		CoapResponse response = client.get();

		System.out.print(response.getResponseText()+"\n");
			
		response = client.post("10", MediaTypeRegistry.TEXT_PLAIN);
		
		System.out.print(response.getResponseText()+"\n");
		
		Request request = new Request(CoAP.Code.GET);
		
		request.setOptions((new OptionSet()).setAccept(MediaTypeRegistry.APPLICATION_JSON));
		
		response = client.advanced(request);
		
		System.out.print(response.getResponseText()+"\n");
		
		try {
			JSONObject genreJsonObject = (JSONObject) JSONValue.parseWithException(response.getResponseText());
		
			System.out.println(genreJsonObject.get("value"));
					
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}

	}

}
