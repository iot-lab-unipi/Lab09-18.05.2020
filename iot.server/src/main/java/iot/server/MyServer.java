package iot.server;

import org.eclipse.californium.core.CoapServer;



public class MyServer extends CoapServer {

	public static void main(String[] args) {
		System.out.print("Running it!");
		MyServer server = new MyServer();
		server.add(new CoAPResourceExample("hello"));
		server.start();
	}

}
