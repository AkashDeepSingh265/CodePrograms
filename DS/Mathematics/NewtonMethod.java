package Mathematics;

/* Find cube root of 9 using fixed point iteration with Newton method
 */
public class NewtonMethod {
  
  /* = cube root of n using fixed point iteration with Newton method
   * and an initial guess of x
   */
  public static double myCubeRoot(double n, double x) {
    double xnew;         //Next guess of cube root by Newton method
    double err= 1;       //Relative difference between x and xnew;
                         //  assumed a value to start loop
    
    final double tol= 0.0000001;  //CONSTANT error tolerance
    
    while (err > tol) {
      xnew= x - (Math.pow(x,3) - n)/(3*x*x);
      err= Math.abs((xnew-x)/x);
      x= xnew;
    }
    
    return x;
  } //end method myCubeRoot

  /* Demonstrate myCubeRoot method
   */
  public static void main(String[] args) {
    
    System.out.print("Test 1:  ");
    double num= 9;    //Number to find cube root of
    double guess= 3;  //First guess of n's cube root
    double cr = myCubeRoot(num, guess);
    System.out.println("Cube root of " + num + " is " + cr);
    
    //Try a 4 more values using a for-loop and random nubmers
    for(int k=1; k<=4; k++) {
      System.out.print("Test " + k + ":  ");
      num= Math.random();  //give a random value in [0,1)
      num*=10;             //shorthand for num=num*10
      guess= Math.random()*4;
      cr= myCubeRoot(num, guess);
      System.out.println("Cube root of " + num + " is " + cr);
    }
  } //end method main
  
} //end class CubeRoot
