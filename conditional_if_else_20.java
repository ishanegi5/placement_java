import java.util.*;
public class conditional_if_else_20 {
    public static void main(){
        // int age=20;
        // if(age>=18){
        //     System.out.println("Adult");
        //     System.out.println("hi");
        // }
        // else{
        //     System.out.println("not an adult");
        // }



        // if(age>=18){
        //     System.out.println("Adult");
        // }
        // if(age>=13 && age<=19){
        //     System.out.println("teenager");
        // }
        // else{
        //     System.out.println("not an adult");
        // }
        


        // u can write without curly braces if only one statement is to be there in if else
        // largest of 2 numbers:
        // int a=5;
        // int b=2;
        // if(a>b){
        //     System.out.println("A is bigger");
        // }
        // else{
        //     System.out.println("B is bigger");
        // }



        //even or odd:
        // int x=8;
        // if(x%2==0){
        //     System.out.println("Even");
        // }
        // else{
        //     System.out.println("odd");
        // }


        //elseif statement
        // int age=2;
        // if(age>=18){
        //     System.out.println("adult");
        // }
        // else if(age>=13 && age<18){
        //     System.out.println("teenager");
        // }
        // else{
        //     System.out.println("child");
        // }



        //tax:
        // int tax;
        // int income=800000;
        // if(income<=500000){
        //     tax=0;
        // }
        // else if(income>500000 && income<100000){
        //     tax=(int)(income*0.2);
        // }
        // else{
        //     tax=(int)(income*0.3);
        // }
        // System.out.println("your tax: "+tax);



        //largest of 3 numbers:
        // int A=0;
        // int B=1;
        // int C=3;
        // if(A>B && A>C){
        //     System.out.println("A is largest");
        // }
        // else if(B>C){
        //     System.out.println("B is largest");
        // }
        // else{
        //     System.out.println("C is largest");
        // }


        //ternary operator
        // int marks=77;
        //boolean var=(5>3)?true:false;
        // String result=(marks>=33)?"pass":"fail";
        // System.out.println(result);
        
        Scanner sc=new Scanner(System.in);
        System.out.print("enter a= ");
        int a=sc.nextInt();
        System.out.print("enter b= ");
        int b=sc.nextInt();
        System.out.println("enetr the operation u wanna do(+,-,/,*,%): ");
        char operation=sc.next().charAt(0);
        switch(operation){
            case '+':
                System.out.println(a+b);
                break;
            case '-':
                System.out.println(a-b);
                break;
            case '*':
                System.out.println(a*b);
                break;
            case '/':
                float d=(float)(a/b);
                System.out.println(d);
                break;
            case '%':
                System.out.println(a%b);
                break;
            default:
                System.out.println("choose correct operation");

            
            //leap year finding:
            /*
            
            divisible by 4->not divisible by 100->leap year
            divisible by 4->divisible by 100->divisible by 400 ->leap year

            
            */
        //    int year=sc.nextInt();
        //    boolean x=year%4==0;
        //    boolean y=year%100!=0;
        //    boolean z=(year%100==0) && (year%400==0);
        //    if(x && (y||z)){
        //         System.out.println("Leap year");
        //    }
        //    else{
        //         System.out.println("not leap year");
        //    }


        }




}

