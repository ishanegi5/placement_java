public class patterns_22 {
    public static void main(){
        int n=5;
        /*

        *
        **
        ***
        ****
        *****        
        
        */
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }


        /*
        
        *****
        ****
        ***
        **
        *
        
        */


        // for(int i=0;i<n;i++){
        //     for(int j=n;j>i;j--){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }


        /*
        
        1
        12
        123
        1234
        12345

        */

        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }


        /*
        
        A
        BC
        DEF
        GHIJ
        KLMNO
        
        */
       int a=65;

        for(int i=0;i<=n;i++){
            for(int j=1;j<=i;j++){
                
                char ch=(char)a;
                System.out.print(ch);
                a++;
            }
            System.out.println();
        }

        //Note: char ch='A';  --> ch++; inside loop 
    }
}
