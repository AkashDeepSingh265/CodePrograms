package com.test.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TestServer extends Remote {
	public void computeString(String str) throws RemoteException;
	public void computeInteger(Integer in) throws RemoteException;

}
