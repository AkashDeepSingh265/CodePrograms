package SingleTon;

public class SingleTonClass {

	private static SingleTonClass instance = new SingleTonClass();
	private SingleTonClass(){}
	
	public static SingleTonClass getInstance(){
		return instance;
	}
	public void showMessage(){
		System.out.println("Hi!!!!");
	}
}
