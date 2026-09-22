import java.util.Arrays;
import java.util.Collections;
public class sorting_descending_27{
    public static void bubble_sorting(int arr[]){
        int swap=0; //yeh likha h taki ager na ho ek bhi swap toh mtlab already sorted he tha array toh tc 
        for(int i=0;i<arr.length-1;i++){ //kyuki first element sorted hoga already
            
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]<arr[j+1]){ //bs yeh less than mai bdla baki sub same he h
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap++;
                }
                
            }
            if(swap==0){
                return;
            }
        }
        
    }

    public static void selection_sort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[minPos]){ // bs less than bna sign
                    // int temp=arr[j]; //yeh standard selection sort ka tarika h ki swap her pass(outer loop) mai bs 1 he baar ho
                    // arr[j]=arr[i];
                    // arr[i]=temp;
                    minPos=j; //hum bs minimum element ka index kya h dhundhre h yaha 
                }
            }
            /*  yaha ab har i ki value k liye swap hoga but km se km bs n baar hoga ab swap
                ager hum inner loop k ander kiye hote swap toh usse swapping based selection sort algo bolte na ki standard
                algo for selection sort
            */
            int temp=arr[minPos];  
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }

    public static void InsertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){            
            int curr=arr[i];
            int prev=i-1;
            //shift +insert hota h isme ->one note se
            while(prev>=0 && arr[prev]<curr){  // less than bnega bs
                arr[prev+1]=arr[prev];
                prev--;

            }
            arr[prev+1]=curr;
            
        }
    }


    public static void count_sort(int arr[]){
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mx){
                mx=arr[i];
            }
        }
        int freq[]=new int[mx+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]+=1;
        }        
        int i=arr.length-1;
        int j=0;
        int element=0;
        // freq={0,2,1,2,2,1}
        while(i>=0){ //0,1<8,3<8,4<8,6<8,7<8   ,8<8 X exit       
            boolean inside=false;
            while(freq[j]>0){ //1->2 ,1->1,0>0 X exit ,,2->1,0>0X exit,,2>0 ,1>0,, 2>0,1>0,, 1>0
                arr[i]=element; //0->1 ,1->1 ,,2->2,, 3->3,4->3 ,, 5->4,6->4 ,,7->5
                freq[j]-=1; //1 ,0 ,,0,, 1,0,, 1,0,, 0
                i--; //1,2,, 3,, 4,5,, 6,7 ,,8
                inside=true;
            }
            j++; //1,2,3,4,5,6
            
            element++;//0,1,2,3,4,5,6
            //{1,1,2,3,3,4,4,5}

            
                
        }
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" "); 
        }

    }

    // public static void printArr(Integer arr[]){
    //     for(int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]+" "); 
    //     }

    // }

    public static void main(){
        int arr[]={3,6,2,1,8,7,4,5,3,1};

        // bubble sort
        bubble_sorting(arr); //TC: O(n^2), SC: O(1)
        printArr(arr);



        //selection sort
        // selection_sort(arr);
        // printArr(arr);


        //insertion sort
        // InsertionSort(arr); //isme TC: best case mai O(n) and worst mai O(n^2)
        // printArr(arr);


        //ab subse uper iss file mai import java.util.Arrays; hai built-in sort function ko arrays class se use krne k liye
        //TC: O(nlog(n)) hoti h 
        // Arrays.sort(arr);
        // printArr(arr);
        //2nd method sort ko use krne ka is
        // printArr(arr);
        // System.out.println();
        // Arrays.sort(arr,0,3); //ending index non inclusive h
        // printArr(arr);
        //3rd method ->reverse using collections framework in java ->uper se import krenge usse bhi
        // Integer arr[]={5,6,3,7,8,5,2}; //int->primitive(basic type) so we use "object type Integer" here
        // //arr is now an object of Integer class
        // printArr(arr);
        // System.out.println();
        // // Arrays.sort(arr,Collections.reverseOrder()); //isse bhi starting and ending index k sath de skte
        // //like:
        // Arrays.sort(arr,2,5,Collections.reverseOrder());
        // printArr(arr);



        //count sort-> for small range array it is used jaha number chote ho array k ander
        //count sort is for positive integer having arrays mainly
        //ager kabhi negative numbers ho toh unhe positive bnate hue ek alag se array mai sort krke descending order mai likhna h
        //fir unhe yeh positive wale bachey hue sorted array k sath jo ascending mai hua hoga  sort uske sath jodh dena
        //negative sign lagake firse
        //aase mai pura sorted array hume mil jayega
        //3,4,5,1,3,1,4,2
        // int arr[]={3,6,2,1,8,7,4,5,3,1}; //  ->{1,1,2,3,3,4,4,5} 
        // count_sort(arr);
        // printArr(arr);

        
    }
}

