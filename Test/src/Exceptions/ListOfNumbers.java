package Exceptions;

import java.io.*;
import java.util.Vector;

import com.practice.DataStructure;

public class ListOfNumbers implements Runnable {
    private Vector<Integer> victor;
    private static final int SIZE = 10;
    
    public ListOfNumbers () {
        victor = new Vector<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            victor.addElement(new Integer(i));
    }
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("C:\\Users\\Aakash\\Desktop\\OutFile.txt"));
        
            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + victor.elementAt(i));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public void copyFile(){
    	DataOutputStream out = null;
    	DataInputStream in = null ;
    	
    	try{
    		in = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\Aakash\\Desktop\\CopyOutFile.txt")));
    		out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Aakash\\Desktop\\CopyOutFile.txt")));
    		
    		out.writeUTF("Akash Deep");
    		out.writeDouble(180.22);
    		out.writeInt(123);
    		out.close();
    		
    		//System.out.println(in.readUTF());
    		System.out.println(in.read());
    		//System.out.println(in.readDouble());
    		//int i = in.readInt();
    		//String s = in.readUTF();
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    		
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
    }
    
    public static void main(String[] args){
    	
    	Thread t = new Thread();
    	t.run();
    	//new BufferedReader(new FileReader("abc.txt"));
    	//Console c = System.console();
    	//String val = c.readLine("Enter your name with dude ");
    	//c.readLine("You entered "+val);
    	
    	//c.readLine("Enter your name ");
    	
    	
    	
    	
    }
	@Override
	public void run() {
		copyFile();
		
	}
}