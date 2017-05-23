package com.test.client;

import java.rmi.RemoteException;


public class TestCl extends TestClient{
	
	private TestClient cl;
	
	@Override
	public int getInt(String a){
		return 3;
	}
	
	public TestCl() throws RemoteException {
		super(0);
		System.out.println("AKash deep singh");
		
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		
	}
}
