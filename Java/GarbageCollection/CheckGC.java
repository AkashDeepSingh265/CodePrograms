package GarbageCollection;

public class CheckGC {

	public static void main(String[] args){
		Runtime rt = Runtime.getRuntime();
		rt.gc();
		System.out.println("Total JVM Memory :"+rt.totalMemory());
		System.out.println("Total Free memory :"+rt.freeMemory());
		Integer it = null;
		for(int i = 0 ; i < 10000;i++){
			it = new Integer(i);
		}
		System.out.println("Total Free memory After object creations :"+rt.freeMemory());
		rt.gc();
		System.out.println("Total Free memory After garbage collection:"+rt.freeMemory());
	}
}
