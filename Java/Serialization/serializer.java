package Serialization;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

class Foo {
    Foo(String str) { }
}

class Bar extends Foo {
    Bar(String str) {
        // Here I am explicitly calling the superclass 
        // constructor - since constructors are not inherited
        // you must chain them like this.
    	//System.out.println("test");
        super(str);
    }
}

public class serializer {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		HashMap<String, String> testMap = new HashMap<String, String>();
		testMap.put("akash", "deep");
		testMap.put("akash1", "deep1");
		FileOutputStream fo = new FileOutputStream(new File("map.ser"));
		ObjectOutputStream ooS = new ObjectOutputStream(fo);
		ooS.writeObject(testMap);
		FileInputStream fi = new FileInputStream(new File("map.ser"));
		ObjectInputStream oIS = new ObjectInputStream(fi);
		Map hashMap = (Map) oIS.readObject();
		System.out.println(hashMap.toString());
	}
}
