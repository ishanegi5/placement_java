import java.util.*;
public class two_dimens_28 {
    public static void search(int matrix[][],int key){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    System.out.println("("+i+","+j+")");
                    return;
                }
            }
        }
    }

    public static void search_max(int matrix[][]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]>max){
                    max=matrix[i][j];                    
                }
            }
        }
        System.out.println("max: "+max);
    }

    public static void search_min(int matrix[][]){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<min){
                    min=matrix[i][j];                    
                }
            }
        }
        System.out.println("min: "+min);
    }


    public static void spiralMatrix(int matrix[][]){
        int starting_row=0;
        int starting_col=0;
        int ending_row=matrix.length-1;
        int ending_col=matrix[0].length-1;
        while(starting_row<=ending_row && starting_col<=ending_col){
            //top
            for(int j=starting_col;j<=ending_col;j++){
                System.out.print(matrix[starting_row][j]+" ");                
            }
            
            //right
            for(int i=starting_row+1;i<=ending_row;i++){
                System.out.print(matrix[i][ending_col]+" ");
            }

            //bottom
            for(int j=ending_col-1;j>=starting_col;j--){
                if(ending_row==starting_row){ //jo element top k code se print ho jaye waha fir nahi jana h
                    return;
                }
                System.out.print(matrix[ending_row][j]+" ");
            }

            //left
            for(int i=ending_row-1;i>=starting_row+1;i--){
                if(starting_col==ending_col){ //jo element right k code se print ho jaye waha fir nahi jana h
                    return;
                }
                System.out.print(matrix[i][starting_col]+" ");
            }

            //updation
            starting_row++;
            starting_col++;
            ending_row--;
            ending_col--;
        }
    }


    public static int diagonal_sum(int matrix[][]){
        int sum=0;
        // for(int i=0;i<matrix.length;i++){  //TC: O(n^2)
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(i==j){
        //             sum+=matrix[i][j];
        //         }
        //         else if((i+j)==matrix.length-1){
        //             sum+=matrix[i][j];
        //         }
        //     }
        // }


        for(int i=0;i<matrix.length;i++){  //TC: O(n)
            sum+=matrix[i][i];
            if(matrix.length-1-i!=i){
                sum+=matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }


    public static void staircase_search(int matrix[][],int key){
        int i=0;
        int j=matrix.length-1;
        while(i<=matrix[0].length-1 && j>=0){
            if(matrix[i][j]==key){
                System.out.println("Found: ("+i+","+j+")");
                return;
            }
            if(key<matrix[i][j]){
                j-=1;
            }
            else{
                i+=1;
            }
        }
        System.out.println("Not found");
    }

    public static void staircase_search_last_row_method(int matrix[][],int key){
        int i=matrix.length-1;
        int j=0;
        while(i>=0 && j<=matrix[0].length-1){
            if(matrix[i][j]==key){
                System.out.println("Found: ("+i+","+j+")");
                return;
            }
            if(key<matrix[i][j]){
                i-=1;
            }
            else{
                j+=1;
            }
        }
        System.out.println("Not found");
    }


    public static void print_number_of_five_in_two_d(int matrix[][]){
        int count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==5)
                    count++;
            }
        }
        System.out.println("count of 5 is: "+count);
    }

    public static void third_row_sum(int matrix[][],int row){
        int sum=0;
        for(int j=0;j<matrix[0].length;j++){
            sum+=matrix[row-1][j]; //-1 kiya kyuki user ko ni pata hoga ki indexing 0 se start hoti h
        }
        System.out.println("sum: "+sum);
    }


    public static void transpose(int matrix[][]){
        int row=matrix[0].length;
        int column=matrix.length;
        int t_matrix[][]=new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                t_matrix[i][j]=matrix[j][i];
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(t_matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(){
        //2D-> for tables
        //3D-> images(R,G,B)->3 matrix
        //4D-> video (R,G,B,time)

        //one note pr bnake dekhati hu 2D array ko
        // int matrix[][]=new int[2][3];
        // Scanner sc=new Scanner(System.in);
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         matrix[i][j]=sc.nextInt();
        //     }
        // }
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        //searching an element
        // int key=8;
        // search(matrix,key);
        // search_max(matrix);
        // search_min(matrix);



        //2D arrays are stored in (row major form(row wise),column major(column wise) form or linear fashion) in memory
        //java stores 2 D array in linear fashion like in an array(memory address of all the arrays jo 
        // ki kisi bhi location m store ho jate h) is written ->2 D array contiguous memeory location mai store
        //ho bhi skta aur nhi bhi
        // int matrix[][]={{2,13,14},
        //                 {6,70,80},
        //                 {50,300,350}};
        // spiralMatrix(matrix);


        //sum of diagonal elements of a matrix
        // System.out.println(diagonal_sum(matrix));


        //searching sorted array mai :
        //1)linear searching
        //2)binary searching
        //3)row wise searching
        //4)column wise searching
        //5) staircase searching
        // staircase_search(matrix,6); //start krna h 0th row k last element se top mai ya last row k left k element se
        //TC: O(n+m) ->n: rows, m: columns ->whichever is bigger it will be our answer O(n) or O(m)
        //mtlab koe row matrix ya column matrix di ho toh asa he hoga wo dominate krega uss hisab se n ya m respectively.

        //staircase_search_last_row_method
        // staircase_search_last_row_method(matrix,14); //TC: O(n+m) same and space complexity is: O(1) because of i and j.

        //practice:
        //1)print_number_of_five_in_two_d:
        // int [][]matrix={{3,5,6,2},{5,7,4,5},{6,3,25,6}};
        // print_number_of_five_in_two_d(matrix);

        //2) sum of numbers in 3rd row of nums matrix
        int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
        // third_row_sum(nums,3);

        //3) transpose of a matrix- one note pr batati hu transpose kya hota
        transpose(nums);

    }
}
