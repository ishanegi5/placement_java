import java.util.*;
public class loops_21 {
    public static void main(){
        // while loop
        // printing a statement:
        // int i=0;
        // while(i<10){
        //     System.out.println("Iesha Negi");
        //     i++;
        // }
        

        //printing numbers:
        // int i=1;
        // while(i<11){
        //     System.out.println(i);
        //     i++;
        // }



        //question: user se input lo koe number and waha tk loop se print kro numbers ko 1 se start krke

        //sum till n from 1
        // int sum=0;
        // int i=1;
        // Scanner sc=new Scanner(System.in);
        // System.out.println("enter n: ");
        // int n=sc.nextInt();
        // while(i<=n){
        //     sum+=i;
        //     i++;
        // }
        // System.out.println("sum= "+sum);



        //for loop
            //initialization;condition;updation
        // for(int i=1;i<=10;i++){
        //     System.out.println(i);
        // }


        //reverse-> printing
        // int n=543651;
        // int i;
        // while(n!=0){
        //     i=n%10;
        //     System.out.print(i); //156345
        //     n=n/10;
        // }

        //reverse storing
        // int rev=0;
        // int n=67852;
        // while(n!=0){
        //     int last_digit=n%10; //2,5,8,7,6
        //     rev=(rev*10)+last_digit; //20+5=25 *10=250+8=258*10=2580+7=2587*10=25870+6=25876
        //     n=n/10; //6785 ,678,67,6,0
        // }
        // System.out.println(rev);



        //do-while- at least 1 baar chalta he h chahe condition false kyu na ho
        // int i=1;
        // do{
        //     System.out.println("Iesha Negi");
        //     i++;
        // }while(i<=-1);


        //break
        // int i=1;
        // while(i<5){
        //     if(i==3){
        //         break;
        //     }
        //     System.out.println(i);
        //     i++;
            
        // }
        // System.out.println("Out!");


        //continue
        // int i=1;
        // while(i<=5){
        //     if(i==4){
        //         continue;
                
        //     }
        //     System.out.println(i);
        //     i++;
        // }
        // System.out.println("Out!");


        //isPrime
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // boolean isPrime=true;
        // int i=2;
        // if(n<=1){
        //     System.out.println("Not prime");
        //     return;
        // }
        //12->2,3,4,5,...11 ->
        /*
        
        12=
        1X12
        2X6
        3X4
        4X3
        6X2
        12X1
        
        
        */
       //square root 4=2
        // while(i<=Math.sqrt(n)){   

        //     if(n%i==0){
        //         isPrime=false;
        //         break;
        //     }
        //     i++;
        // }
        // if(isPrime){
        //     System.out.println("Prime");
        // }else{
        //     System.out.println("Not Prime");
        // }



        //set of even and odd integer
        // int choice=1;
        // int even=0;
        // int odd=0;
        // Scanner sc=new Scanner(System.in);
        // while(choice==1){
        //     System.out.print("enter n: ");
        //     int n=sc.nextInt();
        //     if(n%2==0){
        //         even+=1;
        //     }
        //     else{
        //         odd+=1;
        //     }
        //     System.out.println("enter choice: ");
        //     choice=sc.nextInt();
            


        // }
        // System.out.println("even "+even);
        // System.out.println("odd: "+odd);



        //factorial
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // int prod=1;
        // while(n>1){
        //     prod*=n;
        //     n--;
        // }
        // System.out.println(prod); 
        //0!,1!=1



        //table of a number n
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // for(int i=1;i<=10;i++){
        //     System.out.println(n+" X "+i+" = "+n*i);
        // }




        //scope
        // for(int i=1;i<=5;i++){
        //     System.out.println("hi");
        // }
        // System.out.println(i);

        /*

        loops.java:171: error: cannot find symbol
        System.out.println(i);
                           ^
        symbol:   variable i
        location: class loops
        1 error

        */


        //how many times maggie will be printed?
        // for(int i=1;i<10;i++){
        //     System.out.println("maggie");
        //     i+=3;
        // }
        //maggie ->1+3=4+1=5
        //maggie ->5+3=8+1=9
        //maggie->9+3=12+1=13

    }
}
