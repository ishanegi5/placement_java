import java.util.*;
public class functions__methods_23{
    //FunctionsMethods -> pascals convention 


    //bina parameter wala function
    public static void printHelloWorld(){
        System.out.println("Hello world");
        return;
    }

    //sum
    public static int sum(int x,int y){
        return x+y;
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

    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        boolean isPrime=true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                isPrime=false;
                return isPrime;
            }
        }
        return isPrime;
    }


    //print prime numbers in a range
    public static void printPrime(int n){
        for(int i=2;i<=n;i++){
            boolean  status=isPrime(i);
            if(status==true){
                System.out.print(i+" ");

            }
        }
    }



    //binary to decimal function:
    public static void binToDec(int n){
        int copy =n;
        int pow=0;
        int decimal=0;
        while(n!=0){
            int remainder=n%10;
            decimal+=(remainder*Math.pow(2,pow));
            pow++;
            n=n/10;
        }
        System.out.println("decimal of binary number "+copy+" is: "+decimal);
    }



    //decimal to binary
    public static void decToBin(int n){
        int pow=0;
        int binary=0;
        int copy=n;
        while(n!=0){
            int last_digit=n%2;
            binary+=(last_digit*Math.pow(10,pow));
            pow++;
            n=n/2;
        }
        System.out.println("binary number of "+copy+" is: "+binary);
    }



    //function scope
    public static void funcName(){
        String name="Iesha negi";
        System.out.println("my name is: "+name);
    }




    //palindrome Check
    public static void palinCheck(int n){
        int copy=n;
        int rev=0;
        while(n!=0){
            int rem=n%10;            
            rev=rev*10+rem;            
            n/=10;
        }
        if(rev==copy){
            
            System.out.println("palindrome");
        }
        else{
            
            System.out.println("not palindrome");
        }
    }



    public static void sumOfDigit(int n){
        int sum=0;
        while(n!=0){
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        System.out.println("Sum: "+sum);
    }

    //main function jaha se sub execution start hota h her program ka
    public static void main(){


        //function call() without parameters
        // printHelloWorld(); //argument, parameter



        //functions using parameters
        Scanner sc=new Scanner(System.in);


        //sum
        // System.out.print("Enter a: ");
        // int a=sc.nextInt();
        // System.out.print("Enter b: ");
        // int b=sc.nextInt();
        // // System.out.println(sum(a,b));
        // int s=calculateSum(a,b); //scope alag h iss sum variable ka called function wale sum variable se 
        // System.out.println(s);  //another method to call func 





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


        // System.out.print("Enter n: ");
        // int n=sc.nextInt();
        //factorial
        // System.out.println(factorial(n));


        
        // System.out.print("Enter r: ");
        // int r=sc.nextInt();        
        // System.out.println(binCoeff(n,r)); //   n!/(r!*(n-r)!) ->n=5 and r=3 5*4*3!/3!*2!=5*4/2*1=5*2=10
        //observe parameters -> kabhi 2 kabhi 3 kabhi 1 according to needs



        //user defined-> like factorial,binCoeff,multiply,printHelloWorld ->yeh padhliya h humne
        //built-in-> like pow, sqrt, min, max, sort and so on..  ->yeh future mai padhenge



        //function overloading-> same name functions but having different parameters
        /*eg: multiply(int a,int b), multiply(float a,float b), multiply(double a,double b)
            isse we call same function but different input values ke hisab se 
            multiply naam ka wo parameter wala function chalega jisme uss type ke input ho eg:int,float ya double..
        */
       /* 
         Note: function overloading bs type of parameter and number of parameters ki wajha se ho paati h ager yeh dono 
         mai se ek bhi alag hoge toh he function overloading possible h 
         ager ap function ka type bdlo aur baki sub same rakho function ka naam and type and number of parameters
         toh yeh error dega and yeh koe function overloading nahi hoti eg:

         public static int sum(int a,int b){
            return a+b;
         }

         public static float sum(int a,int b){
            return a+b;
         }
         
         dono mai function ka type int or float h baki sub same he h 
         toh ager koe puchey kya yeh function overloading hori h uper inn dono functions mai?
         answer-> NO kyuki function overloading sirf parameters and number of parameters pr depend krta
         function k return type pr nahi aur yeh function dono humme error denge ulta try it isse aur 
         functions ki terha likho main function ke bahar jaise multiply,factorial wagerah k likhe h humne

         error: functions__methods_23.java:62: error: method sum(int,int) is already defined in class functions__methods_23
                    public static float sum(int a,int b){
                                        ^
                        1 error
       
       */

       /*
        but 
            public static int sum(int a,int b){
                return a+b;
            }

            public static float sum(float a,float b){
                return a+b;
            }

            ab yeh function overloading h kyuki ab prameters ka type bhi different h 
       
       */




        //prime
        // System.out.print("Enter n: ");
        // int n=sc.nextInt();
        // System.out.println(isPrime(n));




        //print all primes
        // System.out.print("Enter n: ");
        // int n=sc.nextInt();
        // printPrime(n);



        //binary to decimal
        // System.out.print("Enter binary number: ");
        // int b=sc.nextInt();
        // binToDec(b);




        //decimal to binary
        // System.out.print("enter decimal number: ");
        // int d=sc.nextInt();
        // decToBin(d);



        //function scope meaning
        // funcName();
        // System.out.println("My name is: "+name); //name yaha main function mai nahi h isliye error dega 
        //name varible ka scope funcName k ander he h bs wahi use hoga wo 


        //block scope meaning
        // int k=6;
        // {
        //     int h=9;
        //     System.out.println(h);
        // }
        //System.out.println(h); //it throws error
        // System.out.println(k);

        

        //questions for practice:
        //find average of 3 numbers using function concept
        //check if a number is even print yes or no using function 

        //palindrome check function
        // int n=sc.nextInt();
        // palinCheck(n);

        //sum of digits
        // sumOfDigit(252);

        /*
          Math.min(a, b): Returns the smaller of two values. It is overloaded to accept int, long, float, 
          or double.Math.max(a, b): Returns the larger of two values. 
          It also accepts int, long, float, or double.Math.sqrt(x): 
          Returns the correctly rounded positive square root of a double value as a 
          double.Math.pow(base, exponent): Returns the value of the first argument raised to 
          the power of the second argument as a double.Math.abs(x): Returns the absolute (positive) value 
          of a number. It works with int, long, float, or double.
        
        */
    //    System.out.println(Math.min(3,7));
    //    System.out.println(Math.max(3,7));
    //    System.out.println(Math.sqrt(3));
    //    System.out.println(Math.pow(3,3));
    //    System.out.println(Math.abs(-3));

       //Note: koe bhi numerator ya denominator mai float bnado then proper answer ayega: 5.3333335,6.6666665
    //    System.out.println((float)(3+5+8)/3); 
    //    System.out.println((7+5+8)/3f);


       //interview:
       //very important jo bhi interviewer question dega usse apko function se ander he likhna chahiye
       //kruki yeh wo notice krte h ki bacha function ka use janta h ki nahi ->reuseability k liye

       //palindrome wala question try kro sub ab
       //sqrt wala leetcode ka question

       //palindrome loop:
    //    for(int i=1;i<=5;i++){
    //         for(int j=1;j<=i;j++){
    //             System.out.print(j);
    //         }
    //         for(int j=i-1;j>=1;j--){
    //             System.out.print(j);
    //         }
    //         System.out.println();
    //    }

    //     for(int i=5;i>=1;i--){
    //         for(int j=5;j>=i;j--){
    //             System.out.print(j);
    //         }
    //         for(int j=i+1;j<=5;j++){
    //             System.out.print(j);
    //         }
    //         System.out.println();
    //    }

    //     for(int i=1;i<=5;i++){
    //         for(int j=i;j>=1;j--){
    //             System.out.print(j);
    //         }
    //         for(int j=2;j<=i;j++){
    //             System.out.print(j);
    //         }
    //         System.out.println();
    //    }



    //pascals triangle
    // int arr[][]=new int[5][5];

    // for(int i=0;i<5;i++){
    //     for(int j=0;j<=i;j++){
    //         if(j==0 || j==i){
    //             arr[i][j]=1;
    //             System.out.print(1+" ");
    //         }
    //         else{
    //             arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
    //             System.out.print(arr[i][j]+" ");
    //         }
            
            
    //     }
    //     System.out.println();
    }
    // for(int i=0;i<5;i++){
    //     for(int j=0;j<5;j++){
    //         System.out.print(arr[i][j]+" ");
    //     }
    //     System.out.println();
    // }
        
       



    }
