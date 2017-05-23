package com.learning;

import java.rmi.RemoteException;
import java.util.Map;

import com.practice.annotations.InterfaceTest;
import com.test.client.TestClient;

public class LearningObjects extends TestClient   implements LearningInterface  {
	private int count;
	public LearningObjects(int count) throws RemoteException {
		super(count);
		this.count=count;
	}
	public boolean equals(LearningObjects obj){
		return this.count == obj.count;
	}
	@Override
	public void getType() {
		System.out.println("inside get type ");
		
	}
	public static void main(String[] args) {
		
		
	
		try {
			final TestClient tc = new LearningObjects(3);
			 final LearningObjects a = new LearningObjects(12);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//LearningObjects b = a;
		//System.out.println(a.equals(b));
	}
	@Override
	public int getInt() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
