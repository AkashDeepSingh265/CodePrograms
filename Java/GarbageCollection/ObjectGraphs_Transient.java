package GarbageCollection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Collar {
	private int collarSize;
	
	public Collar(int size){
		this.collarSize = size;
	}
	public int getCollarSize(){
		return collarSize;
	}
}
class Dog implements Serializable{
	private transient Collar collar;
	private int dogweight;
	private String name;
	public Dog(Collar c , int weight , String name){
		this.collar = c;
		this.dogweight = weight;
		this.name = name;
	}
	public String toString(){
		return this.collar.getCollarSize() + " , " +this.dogweight +"," +this.name;
	}
}
public class ObjectGraphs_Transient {

	public static void main(String[] args){
		Collar c = new Collar(4);
		Dog d = new Dog(c,35,"tommy");
		Dog copyDog;
		try{
			FileOutputStream fs = new FileOutputStream("C:\\Users\\Aakash\\Desktop\\DogObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fs);
			oos.writeObject(d);
			System.out.println("Written object :" + d);
			oos.flush();
			oos.close();
			FileInputStream fis = new FileInputStream("C:\\Users\\Aakash\\Desktop\\DogObject.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			copyDog = (Dog) ois.readObject();
			System.out.println("readObject"+copyDog);
		}catch(Exception e){
			e.printStackTrace();
		}
		}
}
