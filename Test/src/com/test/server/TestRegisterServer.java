package com.test.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestRegisterServer  {

	//private static char c;
	//private static byte a;
	
	public static void main(String[] args){
		byte a = 124;
		char c = 'd';
		int creditCardNumber = 1234_5678;
		byte abc = (byte)0b11010;
		String s = new String("abc");
		System.out.println(c);
		System.out.println(Integer.toHexString(abc));
		try {
			TestServerImpl server = new TestServerImpl(1);
			Naming.bind("rmi://localhost:1099/testserver", server);
			//System.out.println("Server is registered");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
