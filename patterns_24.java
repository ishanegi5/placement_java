public class patterns_24 {

    //inverted_half_pyramid_with_num
    public static void inverted_half_pyramid_with_num(int rows,int columns){
        for(int i=0;i<rows;i++){
            for(int j=1;j<=columns-i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }


    public static void floyeds_triangle(int r,int c){
        int n=1;
        for(int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
                System.out.print(n+" ");
                n++;
            }
            System.out.println();
        }
    }





    public static void zero_one_triangle(int r,int c){
        int last_digit=0;
        int prev_row=0;
        for(int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
                // if(j==1 &&prev_row==0){
                //     prev_row=1;
                //     last_digit=1;
                //     System.out.print(prev_row+" ");
                //     continue;
                // }
                // else if(j==1 && prev_row==1){
                //     prev_row=0;
                //     last_digit=0;
                //     System.out.print(prev_row+" ");
                //     continue;
                // }
                // if(last_digit==0){
                //         last_digit=1;
                //         System.out.print(last_digit+" ");

                // }
                // else{
                //     last_digit=0;
                //     System.out.print(last_digit+" ");
                // }     

                //easy approch: 4 lines
                if((i+j)%2==0){
                    System.out.print(1+" ");
                }
                else{
                    System.out.print(0+" ");
                }
                
            }
            System.out.println();
        }
    }



    public static void butterfly_pattern(int r,int c){
        for(int i=1;i<=r/2;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=c-2*i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();

        }
        for(int i=r/2;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=c-2*i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();

        }
    }



    public static void rhombus(int r,int c){
        for(int i=0;i<r;i++){
            for(int j=1;j<r-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=r;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void hollow_rhombus(int r,int c){
        for(int i=0;i<r;i++){
            for(int j=1;j<r-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=r;j++){
                if(i==0 || i==r-1 || j==1 || j==r){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
    }

    public static void diamond(int r,int c){
        int n=1;
        for(int i=0;i<r;i++){
            for(int j=1;j<=r-i-1;j++){
                System.out.print(" ");
            }
            for(int k=0;k<(i+n);k++){
                System.out.print("*");
            }
            n++;
            System.out.println();

            
        }
        n-=2;
        for(int i=r;i>=0;i--){
            for(int j=1;j<=r-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<(i+n);k++){
                System.out.print("*");
            }
            n--;
            System.out.println();

            
        }
    }
    public static void main(){

        /*
          12345
          1234
          123
          12
          1
        
        
        
        */
        // inverted_half_pyramid_with_num(5,5);



        /*
           1 
           2 3 
           4 5 6 
           7 8 9 10 
           11 12 13 14 15 
        
        
        
        */
        // floyeds_triangle(5,5);
        /*
            1 
            0 1 
            1 0 1 
            0 1 0 1 
            1 0 1 0 1 
        */
        // zero_one_triangle(5,5);


        /*
          *      *
          **    **
          ***  ***
          ********
          ********
          ***  ***
          **    **
          *      *
        
        
        
        */
       butterfly_pattern(8,8);

    /*
    
            *****
           *****
          *****
         *****
        *****
    
    
    */
    // rhombus(5,5);

    /*
        *****
       *   *
      *   *
     *   *
    *****
    
    
    */
//    hollow_rhombus(5,5);

/*

   *
  ***
 *****
*******
*******
 *****
  ***
   *

*/

        // diamond(4,4);


    }
}
