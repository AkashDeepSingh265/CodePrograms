package StaticInheritance;

 
/*
This program was to show the usage of static member. Now, lets discuss on the topic of static member inheritance.
SO GUYS I WOULD LIKE TO TELL YOU THAT STATIC MEMBERS ARE NOT INHERITED. This undermentioned program is
to show the inheritance of static members.
*/
class A
{
    static int i = 10; //initially the value of i is 10
    static int j = 20; //lets use one more static member int j, just to see the value of it through class A, and B
    static 
    {
    /*
    This is static initialization block(SIB) of class A,
    SIB gets executed first in the order of top to bottom only one time
    when the class is loaded.
    */
        System.out.println("A-SIB");
    }
}
class B extends A
{
    static
    {
        i = 12;//trying to modify the i's value to 12
        System.out.println("B-SIB");
    }
}
class D extends A
{
    static int k = 15;
    static
    {
        System.out.println("D-SIB");
    }
}
public class C
{
    public static void main(String [] arhs)
    {
        System.out.println("D.k: " + D.k);
 /*here we are trying to access the static member k from class D,
                                            it will try to search this class and then that class
                                            will be loaded first i.e. SIB of class D will be loaded and SOP
                                            statement of class D will be printed first. When the class loading
                                            is done then the compiler will search for the static int k in class
                                            D and if found SOP statement will be executed with the value of k.
                                            */
                                            /*
                                            ONE GROUND RULE: as soon as the compiler see this statement the compiler will load
                                            class D into the memory, loading of class into memory is nothing but
                                            storing all the static members (i.e. static constant & SIBs) into the
                                            memory.
                                            */
 
         
        System.out.println("B.i: " + B.i);
/*Now, this is what we are talking about... we think that static int i's
                                            value is there in class B and when we write B.i it compiles and executes
                                            successfully BUT... there compiler is playing a major role at this statement...
                                            Try to understand now... we know that class B is the subclass of class A
                                            BUT when the compiler sees this statement it will first try to search
                                            the static int i inside class B and it is not found there, then since it is
                                            the subclass of A, the compiler will search in class A and it is found
                                            there. NOW, WHEN STATIC INT I IS FOUND IN CLASS A THE COMPILER WILL CHANGE
                                            THIS STATEMENT B.i TO A.i and the class B WILL NOT AT ALL BE LOADED INTO
                                            THE MEMORY BECAUSE STATIC I IS ONLY PRESENT IN CLASS A. But in the previous
                                            statement static int k is present inside class D so when we try to access k's value
                                            the class D will be loaded into memory i.e. SIB will be executed and then
                                            the SOP statement of the value of k. USING B.i IS NOT WRONG BUT COMPILER
                                            ASSUMES THAT THE PROGRAMMER HAS MADE A MISTAKE AND IT REPLACES THE CLASS NAME
                                            B.i TO A.i. Thus this show that static members are not inherited to the subclass.And
                                            therefore the vaue of i will NOT BE CHANGE TO 12 AS YOU CAN SEE IN THE SIB OF
                                            CLASS B, it will be 10 only..
                                            */
 
 
 
        System.out.println("A.j: " + A.j);//this statement will be executed as it is, compiler will not make
        System.out.println("A.i: " + A.i);//any modifications to these statements.                                
                                           
         
        System.out.println("B.j: " + B.j);//again compiler will modify this statement from B.j to A.j
         
    }
}

