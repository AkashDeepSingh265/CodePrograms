package SingleTon;

public class SingleTonClassDemo {

	public static void main(String[] args){
		SingleTonClass obj = SingleTonClass.getInstance();
		obj.showMessage();
	}
}
