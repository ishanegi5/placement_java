public class backTracking_36{
    public static void changeArray(int arr[],int i,int val){
        if(i==arr.length){
            printArr(arr);
            return;
        }
        arr[i]=val;
        changeArray(arr,i+1,val+1);
        arr[i]-=2; //backtracking step
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void subsetOfString(String str,String ans,int i){
        if(i==str.length()){
            if(ans==""){
                System.out.println("null");
                return;
            }
            System.out.println(ans);
            return;
        }
        subsetOfString(str,ans+str.charAt(i),i+1);
        subsetOfString(str,ans,i+1);
    }

    public static void permutation(String word,String ans){
        if(word.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            String newStr=word.substring(0,i)+word.substring(i+1);
            permutation(newStr, ans+curr);

        }

    }

    public static boolean isSafe(char board[][],int row,int col){
        //remember hum bs uper ki left and right diagonal and vertical mai check krenge uske alawa nahi kyuki humari upproach he 
        //row wise chalri h fir hum down jaare h row mai +1 krke isliye neechey left,right diagonal aur vertical check ni kr re
        //left diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //vertically up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;

    }

    public static void nQueens(char board[][],int i){
        if(i==board.length){
            // printBoard(board);
            count++; //yeh bs count krne k liye h total solutions
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board,i,j)){
                board[i][j]='Q';
                nQueens(board,i+1);
                board[i][j]='X';
            }
            
        }
    }

    public static void printBoard(char board[][]){
        System.out.println("chess board:");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int count=0;
    public static boolean nQueensBool(char board[][],int i){
        if(i==board.length){
            return true;
        }
        for(int j=0;j<board.length;j++){ //yeh har row k har column pr jayega 
            if(isSafe(board,i,j)){
                board[i][j]='Q';
                if(nQueensBool(board,i+1)){
                    return true;
                }                
                board[i][j]='X';
            }
            
        }
        return false; //ager ek bhi restore krke bhi backtrack krke bhi solution ni mila toh false bolega
    }

    public static int gridWays(int matrix[][],int startRow,int startCol,int n){
        if(startRow==n-1 && startCol==n-1){
            return 1;
        }
        if(startRow==n || startCol==n){
            return 0;
        }
        int down=gridWays(matrix, startRow+1, startCol, n);
        int right=gridWays(matrix, startRow, startCol+1, n);
        return down+right;
        
    }


    public static boolean sudokuFunc(int sudoku[][],int row,int col){
        //base case
        if(row==9){
            return true;
        }
        int newRow=row;
        int newCol=col+1;
        if(col+1==9){
            newRow+=1;
            newCol=0;
        }
        if(sudoku[row][col]!=0){
            return sudokuFunc(sudoku, newRow, newCol);
        }

        //recursion
        for(int k=1;k<=9;k++){
            if(sudokuCheck(sudoku, row, col, k)){
                sudoku[row][col]=k;
                if(sudokuFunc(sudoku, newRow, newCol)){
                    return true;
                }
                sudoku[row][col]=0; //backtracking 
                
            }
        }
        // }
        
        // else{
        //     sudokuFunc(sudoku, newRow, newCol);
        // }
        
        return false;
        
    }

    public static boolean sudokuCheck(int sudoku[][],int row,int col,int num){
        //same col mai har row check
        for(int i=0;i<sudoku.length;i++){
            if(sudoku[i][col]==num){
                return false;
            }
        }

        //same row ka har col check
        for(int j=0;j<sudoku.length;j++){
            if(sudoku[row][j]==num){
                return false;
            }
        }

        //jis grid m abhi h wo check
        int gridRow=(row/3)*3;
        int gridCol=(col/3)*3;
        for(int i=gridRow;i<gridRow+3;i++){
            for(int j=gridCol;j<gridCol+3;j++){
                if(sudoku[i][j]==num){
                    return false;
                }
            }
        }        
        return true;

    }
    public static void printArr(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(){
        //backtracking-> maze (bhulbulaeya) mai galat raste jaate h toh wapis aate h same raste and fir new 
        // way dhundhte h end tk pohochne ko? usko kehete h backtracking
        /*
        Type:
        1)decision -> iske sath goal tk pohochna 
        2)optimal-> optimal shortest path dhundhke pohochna
        3)enumerates-> har tarike ko batana pohochne k 
        */

        //change array 1 se 5 tk jao fir -2 krte raho value ko array k ander har index ki. 
        // int arr[]=new int[5];       
        // changeArray(arr,0,1); //TC:O(n) and SC: O(n)
        // printArr(arr);

        //note: kafi questions krne k baad pata chalega backtracking is all about choices jitni 
        // choices hoti h utne possible solutions hote h
        // subsetOfString("abc","",0); //TC: O(n*(2^n)) and SC: O(n) -> 2^n h number of subsets k reason se and string
        //  length n h isliye n multiply hora h aur 2^n aya kyuki har leter k pass 2 choices h yes and no ki aye ya 
        // na aye subset mai


        //permutation(arrangements) of something
        //when we have n elements we have n! permuatations
        // permutation("abc",""); //dry run batati hu

        //n-queens-> n queens hongi humare pass hum unhe kis terha se rakh skte h ki wo attack na kr paye 
        //attack wo uper nichey left right and diagonals dono pr he kr skti h 
        //isme 3 types k sawal bnn skte -> 1)all solutions, 2)yes or no (koe solution h bhi ki ni), 3)count solutions 

        //rat in a maze gfg mai bataungi abhi nqueens se pehele:

        //ab nqueens start:
        // int n=3; //yaha pehele n=2 k liye try krna h hume yeh sawal aur isSafe function ko hatao uske liye uper nQueens func se
        // char board[][]=new char[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         board[i][j]='X';
        //     }
        // }
        // nQueens(board,0); //TC: O(n!)-> ek row m ek jagha queen rakhne k baad bs n-1 col he bachenge fir n-2 fir n-3 isliye

        // ab isme soutions ko count krna h toh
        // System.out.println("total number of solutions: "+count); //main func k uper h static int count variable =0


        //check if problem can be solved ager ho skti toh 1 solution print kro bs
        // if(nQueensBool(board, 0)){
        //     System.out.println("solution exists");
        //     printBoard(board);
        // }
        // else{
        //     System.out.println("no solution");
        // }

        //grid ways
        //bs down aur right ja skte matrix mai aur pohochna n,n pr h 0,0 se ya kahi se bhi aur ager hum n,n pr he ho toh 1 way
        //h target tk pohochne ka 
        // int matrix[][]=new int[3][3];
        // int r=0; //start row
        // int c=0; //start col
        // int n=3; //total
        // System.out.println(gridWays(matrix,r,c,n)); //TC: O(2^(n+m)) n-> rows and m-> columns
        //iska calculation krne ka linear TC ka tarika bhi h formula use krke:
        //((n-1)+(m-1))!/(n-1)!(m-1)!=> n=3,m=3 =((3-1)+(3-1))!/(3-1)!(3-1)! => (2+2)!/2!2! => 4!/2!2! => 4*3*2!/2!*2*1!=2*3=6ways


        //sudoku-> isme 9X9 ki matrix hoti h and uske grid hoti h 3X3 ki aur unn sub mai number 1 to 9 hote h
        //rule h ki same column mai ,same row mai aur same grid mai same number repeat ni hona chahiye
        //hum bs ek possible solution h ki ni yes or no print krwaenge aur solution print krwayenge bs
        int sudoku [] [] = { {0, 0,8, 0,0,0,0,0,0},
                            {4, 9, 0, 1, 5, 7, 0, 0, 2},
                            {0, 0, 3, 0, 0, 4, 1, 9, 0},
                            {1, 8, 5, 0, 6, 0, 0, 2, 0},
                            {0, 0, 0, 0, 2, 0, 0, 6, 0},
                            {9, 6, 0, 4, 0, 5, 3, 0, 0},
                            {0, 3, 0, 0, 7, 2, 0, 0, 4},
                            {0, 4, 9, 0, 3, 0, 0, 5, 7},
                            {8, 2, 7, 0, 0, 9, 0, 1, 3} };
        if(sudokuFunc(sudoku,0,0)){
            System.out.println("yes solution is possible");
            printArr(sudoku);
        }
        else{
            System.out.println("no solution");
        }


        //iske practice question sathme krenge maine nahi kiye abhi tk
    }
}