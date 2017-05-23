package Inheritance;

import java.util.ArrayList;
import java.util.List;



class NaturalNumber {

    private int i;

    public NaturalNumber(int i) { this.i = i; }
    public int getNaturalNO(){
    	return this.i;
    }
    // ...
}

public class EvenNumber extends NaturalNumber {

    public EvenNumber(int i) { super(i); }
    
    public static void main(String args[]){
    	List<EvenNumber> le = new ArrayList<EvenNumber>();
    	le.add(new EvenNumber(2));
    	le.add(new EvenNumber(4));
    	le.add(new EvenNumber(6));
    	le.add(new EvenNumber(8));
    	
    	List<? extends NaturalNumber> ln = le;
    	ln.add(null);
    	//List<Integer> in = List<EvenNumber>ln;
    	for(NaturalNumber n : ln){
    		System.out.println(n.getNaturalNO());
    	}
    	
    	//EvenNumber even = new EvenNumber(2);
    	//NaturalNumber n = even;
    	//n.getNaturalNO();
    	//ln.add(new EvenNumber(1));
    }
    
}