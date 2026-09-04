import java.util.*;
public class array_25 {
    public static void update(int marks[]){
        for(int i=0;i<marks.length;i++){
            marks[i]+=1;
        }
    }

    public static String linear_search(String menu[],String order){
        for(int i=0;i<menu.length;i++){
            if(menu[i].equals(order)){
                return "yes";
            }
        }
        return "no";
    }

    public static void largest(int arr[]){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
            if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println("Max in array is: "+max);
        System.out.println("Min in array is: "+min);
    }


    public static int binary_search(int arr[],int key){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]<key){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }



    public static void reverse(int arr[]){
        int temp;
        int start=0;
        int end=arr.length-1;
        while(start<end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }



    public static void pair(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+","+arr[j]+")");
            }
            System.out.println();
        }
        System.out.println("total pairs: "+(arr.length*(arr.length-1))/2);
    }


    public static void subarrays(int arr[]){
        int total_subarrays=0;
        for(int i=0;i<arr.length;i++){
            int start=i;
            System.out.println(arr[i]);
            total_subarrays++;
            for(int j=i+1;j<arr.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(arr[k]+" ");

                }
                total_subarrays++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("total subarrays: "+total_subarrays); //(n*(n+1))/2->sum of n natural numbers
        /*
        Note: You can tell if a given series is an arithmetic progression (AP) 
        series by checking if the difference between any two consecutive terms is a 
        constant number, and it is a sum of n natural numbers if it specifically starts 
        at 1 and increases by 1 each time (1 + 2 + 3 + .... + n)

        eg:
        Example for AP: 2 + 5 + 8 + 11

        o 5-2=3

        o 8-5=3

        o 11-8 =3

        o Result: The difference is a constant 3, so it is an AP series with a first term (a) of 2
                and a common difference (d) of 3.

        


        · Sum Formula: Sn =

        · Example: 1+2+3+4+5

            o Starts at 1.

            o 2-1=1,3 - 2 = 1 (common difference is 1).

            o Result: It is a sum of n natural numbers (here, n = 5).

        */
    }



    public static void sum_of_subarray(int arr[]){
        int total_subarrays=0;
        for(int i=0;i<arr.length;i++){
            int start=i;
            System.out.println(arr[i]);
            total_subarrays++;
            for(int j=i+1;j<arr.length;j++){
                int end=j;
                int sum=0;
                for(int k=start;k<=end;k++){
                    System.out.print(arr[k]+" ");
                    sum+=arr[k];

                }
                System.out.print("-> sum: "+sum);
                total_subarrays++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("total subarrays: "+total_subarrays); //(n*(n+1))/2->sum of n natural numbers
        
    }



    public static void min_and_max_of_subarray(int arr[]){
        int total_subarrays=0;
        for(int i=0;i<arr.length;i++){
            int start=i;
            System.out.println(arr[i]);
            total_subarrays++;
            for(int j=i+1;j<arr.length;j++){
                int end=j;
                int min=arr[i];
                int max=arr[i];
                for(int k=start;k<=end;k++){
                    System.out.print(arr[k]+" ");
                    if(min>arr[k]){
                        min=arr[k];
                    }
                    if(max<arr[k]){
                        max=arr[k];
                    }

                }
                System.out.print("-> min: "+min+" ,max: "+max);
                total_subarrays++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("total subarrays: "+total_subarrays); //(n*(n+1))/2->sum of n natural numbers
        
    }


    //brute force
    public static void max_sum_in_subarrays(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                System.out.println(sum);
                if(max<sum){
                    max=sum;
                }
                
                
            }
            
        }
        System.out.println("max sum: "+max);
    }

    // prefix_array
    public static void prefix_sum(int arr[]){
        int prefix_arr[]=new int[arr.length];
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            prefix_arr[i]=sum;
            System.out.print(prefix_arr[i]+" ");
            // for(int j=0;j<arr.length;j++){

            // }
        }
        int max_sum=Integer.MIN_VALUE;
        int cal;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int curr_sum=(i==0)?prefix_arr[j]:prefix_arr[j]-prefix_arr[i-1];
                if(curr_sum>max_sum){
                    max_sum=curr_sum;
                }
            }
            
            
        }
        System.out.println("sum: "+max_sum);
    }


    public static void kadane_method(int arr[]){
        int sum=0;
        int max_sum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int check=arr[i]+sum;
            if(check>0){
                sum+=arr[i];
            }
            else{
                sum=0;
            }
            max_sum=Integer.max(sum,max_sum);
        }
        
        System.out.println("Max sum: "+max_sum);
    }


    public static void for_neg_kadane_method(int arr[]){
        boolean neg_present=true;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

            if(arr[i]>0){
                neg_present=false;
                break;
            }
        }
        if(neg_present){
            for(int i=0;i<arr.length;i++){
                if(max<arr[i]){
                    max=arr[i];
                }
            }
            System.out.println("Max: "+max);
        }
        else{
            int sum=0;
            for(int i=0;i<arr.length;i++){
                int check=sum+arr[i];
                if(check>0){
                    sum=check;
                }
                else{
                    sum=0;
                }
                max=Integer.max(sum,max);
            }
            System.out.println("Max: "+max);
        }
    }

    public static void trapping_rainwater(int arr[]){
        int left_max_arr[]=new int[arr.length];
        left_max_arr[0]=arr[0];
        System.out.print(left_max_arr[0]+" ");
        for(int i=1;i<arr.length;i++){
            left_max_arr[i]=Integer.max(left_max_arr[i-1],arr[i]);
            System.out.print(left_max_arr[i]+" ");
        }
        System.out.println();
        
        int right_max_arr[]=new int[arr.length];
        right_max_arr[arr.length-1]=arr[arr.length-1];
        System.out.print(right_max_arr[arr.length-1]+" ");
        for(int i=arr.length-2;i>=0;i--){
            right_max_arr[i]=Integer.max(right_max_arr[i+1],arr[i]);
            System.out.print(right_max_arr[i]+" ");
        }
        System.out.println();
        int trapped_water=0;
        for(int i=0;i<arr.length;i++){
            int water_level=Integer.min(left_max_arr[i],right_max_arr[i]);
            trapped_water+=water_level-arr[i];
        }
        System.out.println("trapped water: "+trapped_water);
    } 

    public static void buy_sell(int arr[]){
        int buy=arr[0];
        int sell;
        int mx=0;
        for(int i=1;i<arr.length;i++){
            sell=arr[i];
            if(buy<sell){
                int profit=sell-buy;
                mx=Integer.max(mx,profit);
            }
            else{
                buy=sell;
            }
        }
        System.out.println("Max profit: "+mx);
    }


    public static boolean number_occurance_I(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean number_occurance_II(int arr[]){
        HashSet <Integer> set=new HashSet <>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                return true;
            }
            else{
                set.add(arr[i]);
            }
        }
        return false;
    }


    public static void sum_zero_triplets(int arr[]){
        boolean inside=false;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        inside=true;
                        System.out.print("("+arr[i]+","+arr[j]+","+arr[k]+") ");
                    }
                }
            }
        }
        if(inside){
            return;
        }
        else{
            System.out.println("()");
        }
    }


    public static int search(int arr[],int target){
        int min=minimum(arr);
        int index;
        if(arr[min]<=target && arr[arr.length-1]>=target){
            index=search(arr,target,min,arr.length-1);
        }
        else{
            index=search(arr,target,0,min);

        }
        return index;

    }

    public static int search(int arr[],int target,int left,int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }

    public static int minimum(int arr[]){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]<=arr[left] && arr[right]>=arr[mid]){
                System.out.println("inside: "+mid);
                return mid;
            }
            else if(arr[mid]>arr[left] && arr[right]<arr[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        System.out.println("left: "+left);
        return left;
    }


    public static int trap(int[] height){
        int n = height.length; 
        int res = 0, l = 0, r = n - 1; 
        int rMax = height[r], lMax = height[l]; 
        while (l < r) 
        { 
            if (lMax < rMax) { 
                l++; 
                lMax = Math.max(lMax, height[l]); 
                res += lMax - height[l]; 
            } 
            else { 
                r--; 
                rMax = Math.max(rMax, height[r]); 
                res += rMax - height[r]; 
            } 
        } 
        return res; 
    }

    public static void triplets_sum_zero(int arr[]){
        HashSet<String> s=new HashSet<>();
        
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                for(int k=j+1;k<arr.length;k++){
                    int total=arr[i]+arr[j]+arr[k];
                    int triplet[]={arr[i],arr[j],arr[k]};
                    int sorted_triplet[]=sorting_triplets(triplet);
                    String triplet_string=sorted_triplet[0]+","+sorted_triplet[1]+","+sorted_triplet[2];
                    
                    if(total==0 && !(s.contains(triplet_string))){
                        
                        System.out.print("("+arr[i]+","+arr[j]+","+arr[k]+") ");  
                        s.add(triplet_string);

                        
                        
                    }
                        
                    
                    
                }
            }
        }
        
        
    }

    public static int [] sorting_triplets(int triplet[]){
        for(int i=0;i<triplet.length-1;i++){
            for(int j=i+1;j<triplet.length;j++){
                if(triplet[i]>triplet[j]){
                    int temp=triplet[i];
                    triplet[i]=triplet[j];
                    triplet[j]=temp;
                }
            }
        }
        return triplet;
    }
    


    public static void main(){
        //list of elements of he same type stored in contigous memory location
        //by default 0 is stored in an array
        int marks[]=new int[5];
        // int ages[]={2,5,7,3};
        // String fruits[]={"mango","apple","orange"};
        // System.out.println(fruits[0]);
        // fruits[0]="mosumi";
        // System.out.println(fruits[0]);


        Scanner sc=new Scanner(System.in);
 
        // int manduu[]=new int[3];
        // manduu[0]=sc.nextInt();
        // manduu[1]=sc.nextInt();
        // manduu[2]=sc.nextInt();
        // System.out.print(manduu[0]+" ");
        // System.out.print(manduu[1]+" ");
        // System.out.print(manduu[2]+" ");


        marks[0]=97;
        marks[1]=98;
        marks[2]=96;
        // System.out.println("maths: "+marks[0]);
        // System.out.println("physics: "+marks[1]);
        // System.out.println("chemistry: "+marks[2]);
        // System.out.println("Percentage: "+(marks[0]+marks[1]+marks[2])/3+"%");
        // System.out.println("length of marks: "+marks.length); //dot ek operator h isse class object k sath future m padhenge

        //pass by reference is there in array
        // update(marks);
        // for(int i=0;i<marks.length;i++){
        //     System.out.print(marks[i]+" ");
        // }

        //linear search
        // String menu[]={"chole bhature","momo","chowmein","chocolate","milk cake"};
        // String order="momo";
        // String response=linear_search(menu,order);
        // if(response=="no"){
        //     System.out.println("not available");
        // }
        // else{
        //     System.out.println("available");
        // }



        //largest value and smallest value in array
        // int arr[]={23,7,40,3};
        // largest(arr);



        //binary search-> array must be sorted -one note pr i will explain
        //isko one note pr samjhati hu draw krke i will pause the video
        // System.out.println("key is present at index: "+binary_search(arr,9));



        //reversing an array -one note pr i will explain
        // reverse(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }


        //pair in arr- one note pr i will explain
        // int numbers[]={2,5,8,9};
        // pair(numbers);




        //subarrays->one note pr i will explain
        // int arr[]={1,-1,6,-1,3};
        // subarrays(arr);


        //sum of each sub array-> 
        // sum_of_subarray(arr);


        //min and max in sub array
        // min_and_max_of_subarray(arr);


        //max sum in all subarrays
        // max_sum_in_subarrays(arr);


        //prefic sum method
        // prefix_sum(arr);


        //kadane's algo
        // kadane_method(arr);


        //if all numbers are negative and we have to use kadane's algo
        // int arr[]={-4,6,-7,2,1};
        // for_neg_kadane_method(arr);



        //trapping rainwater
        // int arr[]={4, 2, 0, 3, 2, 5};
        // trapping_rainwater(arr);


        //buying and selling stocks- descending mai profit=0 rakhna kyuki buy krne ka time 
        // he nahi milega toh profit he ni milega
        // int arr[]={7, 6, 4,  3, 1};
        // buy_sell(arr);


        //at least more than ones occurence of any number 
        // int arr[]={1,2,3,4,1};
        // System.out.println(number_occurance_I(arr));


        //method 2- HashSet
        // System.out.println(number_occurance_II(arr));


        //triplets
        // int arr[]={-1, 0,  1, 2, -1, -4};
        // sum_zero_triplets(arr);




        /*
        ### Question: Search in a Rotated Sorted Array

        You are given an integer array `nums` that was originally sorted in **ascending order** with no duplicate values.

        The array may have been **rotated** at some position. For example:

        Original array:
        `[1, 2, 3, 4, 5, 6, 7]`

        After rotation:
        `[4, 5, 6, 7, 1, 2, 3]`

        You are also given an integer `target`.

        Your task is to **find the index of the target element** in the rotated array.

        * If the target is present, return its **index**.
        * If the target is not present, return **-1**.
        * Your solution must have a time complexity of **O(log n)**.

        **Example:**

        Input:
        `nums = [6, 7, 8, 1, 2, 3, 4, 5]`
        `target = 3`

        Output:
        `5`

        Because `3` is present at index `5`.

        **Try to solve this using Binary Search.**

          
          
        */
    //    int arr[]={4,6,7,0,1,2};
    //    int target=9;
    //    System.out.println(search(arr,target));


        //trapped_water-method 2 explain using one note 
        // int height []= {4, 2, 0, 3, 2, 5};
        // System.out.println(trap(height));



        //triplets sum=0
        int arr[]={-1, 0,  1, 2, -1, -4};
        triplets_sum_zero(arr);

        //iterations kitni hongi loops ki isme:
        //6-2=4-> 0<4 ->0,1,2,3
        //6-1=5->i+1=0+1=1<5->1,2,3,4
        //6->j+1->1+1=2-> 2<6 ->2,3,4,5







    }


}
