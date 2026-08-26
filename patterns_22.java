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
        // int a=65; //'A'=65
        // char ch='A';
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
                
        //         char ch=(char)a;
        //         System.out.print(ch);
        //         a++;
        //     }
        //     System.out.println();
        // }

        //Note: char ch='A';  --> ch++; inside loop 


        /*
        
        ****
        ****
        ****

        */

       

    //    for(int i=0;i<3;i++){
    //         for(int j=0;j<4;j++){
    //             System.err.print("*");
                
    //         }
    //         System.out.println();
    //    }

       /*

       ****
       *  *
       ****
       
       */
    //    for(int i=0;i<3;i++){
    //         for(int j=0;j<4;j++){
    //             if(j==0 ||j==3||i==0 ||i==2){
    //                 System.out.print("*");

    //             }
    //             else{
    //                 System.out.print(" ");
    //             }
                
    //         }
    //         System.out.println();
    //    }



    /*
    
        *
       **
      ***
     ****
    *****
    
    */
    // for(int i=1;i<=5;i++){
    //     for(int j=1;j<5-i+1;j++){
    //         System.out.print(" ");
    //     }
    //     for(int k=1;k<=i;k++){
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
//    for(int i=5;i>=1;i--){
//         for(int j=1;j<=5-i;j++){
//             System.out.print(" ");
//         }
//         for(int j=1;j<=i;j++){
//             System.err.print("*");
//         }
//         System.out.println();
//    }

    }
}
