package Literalss;

// in java integer in octal form is represented by placing zero in front of number 
// hex form : 0x 
// floating point literals are by default double (64 bit ) . Either attach suffix f or add cast to it
// Integer literals are by default int 
public class LiteralTest {

	public static void main(String[] args){
		byte b = 23;
		//octal value
		int c = 010;
		System.out.println(c);
		//Hexadecimal Value 
		int d = 0xa0;
		System.out.println(d);
		
		float f = (float)123.456;
		float e = 111.111f;
		System.out.println(e);
		//as char is 16 bit unsigned number . the value 75535 cannot be contained in char . so we need to cast it . 
		char cc = (char)75535;
		char dd = (char)-98;
		System.out.println(cc);
		System.out.println(dd);
	}
}
