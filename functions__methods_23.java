import java.util.*;
public class functions__methods_23{


    //bina parameter wala function
    public static void printHelloWorld(){
        System.out.println("Hello world");
        return;
    }


    //parameter wala function
    public static int calculateSum(int num1,int num2){
        int sum=num1+num2;
        return sum;
    }

    
    //swap
    public static void swap(int n1,int n2){
        System.out.println("n1= "+n1);
        System.out.println("n2= "+n2);
        int temp=n1;
        n1=n2;
        n2=temp;

        System.out.println("n1= "+n1);
        System.out.println("n2= "+n2);
    }


    //multiply
    public static int multiply(int n,int m){
        return n*m;
    }



    //factorial
    public static int factorial(int n){
        int f=1;
        for(int i=1;i<=n;i++){
            f*=i;
        }
        return f;
    }



    //binomial coefficient
    public static int binCoeff(int n,int r){
        int fac_n=factorial(n);
        int fac_r=factorial(r);
        int fac_nmr=factorial(n-r);
        return fac_n/(fac_r*fac_nmr);
    }

    //main function jaha se sub execution start hota h her program ka
    public static void main(){
        //function call() without parameters
        // printHelloWorld();

        //functions using parameters
        Scanner sc=new Scanner(System.in);
        // System.out.print("Enter a: ");
        // int a=sc.nextInt();
        // System.out.print("Enter b: ");
        // int b=sc.nextInt();
        // int sum=calculateSum(a,b); //scope alag h iss sum variable ka called function wale sum variable se 
        // System.out.println(sum);  //another method to call func 


        //parameters or formal parameters kya hota h?
        //actual parameters or arguments kya hota h?
        //function call se ..return tk ka pura process samjho!

        //java always calls by value->very important interview question
        /*
            swap mai two varibles ki value exchange krni h we take 1 temp named variable and 
            store a in it and then move value in b to a 
        */
        // swap(a,b);





        //product
        //System.out.println(multiply(10,50)); //direct values dene ka method
        System.out.print("Enter n: ");
        int n=sc.nextInt();
        System.out.print("Enter r: ");
        int r=sc.nextInt();
        //factorial
        // System.out.println(factorial(n));
        System.out.println(binCoeff(n,r));
    }
}