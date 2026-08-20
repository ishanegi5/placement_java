import java.util.*;
public class type_conversion_11 {
    public static void main(){
        // int a=9;
        // long l=a;
        // System.out.println(l);

        /*
        
        1.type should be compatable like number number he hone chahiye like float and int numbers hote h 
        2.destination type>source type
        
        byte->short->int->long->float->double ->correct
        int->char->incorrect
        double->int->incorrect
        etc...

        */

        //error giving code:
        // long a=5;
        // int i=a;
        // System.out.println(i);

        
        //type conversion:
        Scanner sc=new Scanner(System.in);
        float a=sc.nextInt();
        System.out.println(a);
    }
}
