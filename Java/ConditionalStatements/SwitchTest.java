package ConditionalStatements;
// we can use String in switch case as of java 1.7 . Earlier that was not possible . 
public class SwitchTest {

	public static void testSwitch(){
		String s = "A";
		switch (s) {
		case "A":
			System.out.println("Inside case");
			break;

		default:
			System.out.println("Inside Default");
			break;
		}

	}
	public static void main(String[] args){
		SwitchTest.testSwitch();
	}
}
