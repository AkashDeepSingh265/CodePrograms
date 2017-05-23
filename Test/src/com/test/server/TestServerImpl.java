package com.test.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TestServerImpl extends UnicastRemoteObject implements TestServer {

	

	protected TestServerImpl(int a) throws RemoteException {
		
		
	}

	@Override
	public void computeString(String str) {
		System.out.println("Server computing recieved String"+str);
	}

	@Override
	public void computeInteger(Integer in) {
		System.out.println("Server computing recieved Integer"+Integer.toString(in));
	}

}
