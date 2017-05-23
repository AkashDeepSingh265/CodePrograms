package ExceptionHandling;

import java.lang.instrument.IllegalClassFormatException;

//Runtime Exceptions are not checked . But other exceptions are checked 
//Errors are also unchecked
public class ExceptionTest {

	//Here also we have to check exception 
	public void doStuff() throws IllegalClassFormatException{
		doMore();
		doMoreRuntime();
		doMoreError();
	}
	
	//Error are unchecked
	private void doMoreError() {
		throw new Error();
	}

	//Runtime Exception not checked 
	private void doMoreRuntime() {
		throw new ArrayIndexOutOfBoundsException();
		
	}
	
	//Other exceptions are checked 
	private void doMore() throws IllegalClassFormatException {
		throw new IllegalClassFormatException();
		
	}
	public static void main(String[] args){
		try{
			throw new Error();
		}catch(Throwable t){
			if(t instanceof Error){
				System.out.println("Fatal Error occured . Not able to recover the system ");
			}
		}
	}
}
