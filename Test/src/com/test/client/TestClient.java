package com.test.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.test.server.TestServer;
import com.test.server.TestServerImpl;

public class TestClient extends TestServerImpl {
		
	
	public TestClient(int a) throws RemoteException {
		super(0);
		System.out.println("inside test client");
		// TODO Auto-generated constructor stub
	}
	
	public int getInt(String a){
		return 1;
	}
	public static void main(String[] args){
		
		try {
			
			TestServer server = (TestServer) Naming.lookup("rmi://localhost:1099/testserver");
			server.computeString("AKash Deep Singh");
			server.computeInteger(new Integer(12));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
