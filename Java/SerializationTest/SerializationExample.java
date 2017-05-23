package SerializationTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cat implements Serializable{
	int id;
	String name ;
	public Cat(int id,String name){
		this.id = id;
		this.name = name ;
	}
	public String toString(){
		return id+" " +name;
	}
}
public class SerializationExample {
	public static void main(String[] args){
		Cat c = new Cat(1,"TOM");
		Cat copyC = null;
		try {
			FileOutputStream fs = new FileOutputStream("C:\\Users\\Aakash\\Desktop\\catObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fs);
			oos.writeObject(c);
			oos.flush();
			oos.close();
			FileInputStream fis = new FileInputStream("C:\\Users\\Aakash\\Desktop\\catObject.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			copyC = (Cat) ois.readObject();
			ois.close();
			System.out.println(copyC);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
