public class divide_and_conquer_34 {
    public static void printArr(String arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void MergeSort(int arr[],int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        MergeSort(arr,start,mid);
        MergeSort(arr,mid+1,end);
        Merge(arr,start,mid,end);
    }
    public static void Merge(int arr[],int start,int mid,int end){
        int i=start;
        int j=mid+1;
        int k=0;
        int temp[]=new int[end-start+1];//5 element mtlan 0se4 index tk so 4-0+1=5 =>0,1,2,3,4 =>total 5 index isliye yeh formula
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){  //descending order
                temp[k]=arr[j];
                j++;
            }else{
                temp[k]=arr[i];
                i++;
            }
            k++;
        }
        //left
        while(i<=mid){
            temp[k]=arr[i];
            k++;i++;
        }
        // right
        while(j<=end){
            temp[k]=arr[j];
            k++;j++;
        }

        for(int ind=0;ind<temp.length;ind++){
            arr[start++]=temp[ind];

        }
    }


    public static void quickSort(int arr[],int start,int end){
        if(start>=end){
            return;
        }
        int pivot_index=partition(arr,start,end);
        quickSort(arr,start,pivot_index-1);
        quickSort(arr,pivot_index+1,end);
    }

    public static int partition(int arr[],int start,int end){
        int pivot_element=arr[end];
        int i=start-1;
        for(int j=start;j<end;j++){
            if(arr[j]<=pivot_element){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=pivot_element;
        arr[end]=temp;
        return i;
    }

    public static int rotatedSortedArray(int arr[],int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>=arr[start]){
            if(target>=arr[start] && target<=arr[mid]){
                return rotatedSortedArray(arr, target, start, mid);
            }
            else{
                return rotatedSortedArray(arr, target, mid+1, end);
            }
        }
        else{
            if(target>=arr[mid] && target<=arr[end]){
                return rotatedSortedArray(arr, target, mid, end);
            }
            else{
                return rotatedSortedArray(arr, target, start, mid-1);
            }
        }
    }

    public static int rotatedSortedArrayUsingLoop(int arr[],int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>=arr[start]){
                if(target>=arr[start] && target<=arr[mid]){
                    end=mid;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(target>=arr[mid] && target<=arr[end]){
                    start=mid;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
        
    }


    public static void stringMergeSort(String arr[],int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        stringMergeSort(arr, start, mid);
        stringMergeSort(arr, mid+1, end);
        stringMerge(arr,start,mid,end);
    }

    public static void stringMerge(String arr[],int start,int mid,int end){
        String temp[]=new String[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if((arr[i]).compareTo(arr[j])<=0){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        for(i=0;i<temp.length;i++){
            arr[start++]=temp[i];
        }
    }
    public static int inversionCount(int arr[]){
        return mergeSort(arr,0,arr.length-1);
    }

    public static int mergeSort(int arr[],int start,int end){  
        int inverCount=0;           
        if(start==end){
            return 0;
        }
        int mid=start+(end-start)/2;
        inverCount= mergeSort(arr,start,mid);
        inverCount+= mergeSort(arr,mid+1,end);
        inverCount+=merge(arr,start,mid,end);
        return inverCount;
    }

    public static int merge(int arr[],int start,int mid,int end){
        int i=start;
        int j=mid+1;
        int k=0;
        int temp[]=new int[end-start+1];
        int inverCount=0;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                inverCount+=mid-i+1;
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }
        for(i=0;i<temp.length;i++){
            arr[start++]=temp[i];
        }
        return inverCount;
    }


    public static void main(){
        //divide and conquer-> baadi problem ko chooti problem mai todhna fir unn chooti problems ko pehele solve krna aur 
        //fir jodhna

        //Merge sort -> isme deepth first hota h left half ko pura todhna h fir sort krte krte jodhna h->one note pr samjhati hu
        // int arr[]={9,3,1,4,2};
        // MergeSort(arr,0,arr.length-1); //TC: O(nlog(n)) and SC: O(n)
        // printArr(arr);


        //Quick sort-> TC:O(nlog (n))->average case and worst case O(n^2) and SC:O(1)
        //isme pivot and partition use hota h yeh divide and conquer jaisa he hua ek terha se
        //pivot ko randomly,median,first ya last element ko liya ja skta h array k but majorly last element ko pivot liya jata h
        //partition mai pivot element se chote element on the left and bigger on the right
        //fir quickSort(left) and quickSort(right) -> aur aese kr krke humars pivot element jo bhi bnta rahega wo 
        // array m apni correct position pr pohoch jayega
        // quickSort(arr,0,arr.length-1);
        // printArr(arr);
        //remember worst case time complexity tb aata h jub humara pivot element ya toh smallest ya toh largest element ho:O(n^2)


        //search in rotated sorted array
        // int arr[]={4,5,6,7,8,0,1,2,3};
        // int target=3;
        // System.out.println(rotatedSortedArray(arr,target,0,arr.length-1));


        //using loops:
        // System.out.println(rotatedSortedArrayUsingLoop(arr,target,0,arr.length-1));


        //string sort using merge sort
        // String []arr = { "sun", "earth", "mars", "mercury" };
        // stringMergeSort(arr,0,arr.length-1);
        // printArr(arr);


        /*
        Given an array nums of size n, return the majority element. (MEDIUM)
        The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
        that the majority element always exists in the array.
        Sample Input 1 : nums = [3,2,3]
        Sample Output 1 : 3
        Sample Input 2 : nums = [2,2,1,1,1,2,2]
        Sample Output 2 : 2
        */
        //leetcode pr batati hu isse one note pr brute force bhio oprtimized bhi and then moore voting algo method bhi


        //inversion of an array batao
        /*
        Given an array of integers. Find the Inversion Count in the array. (HARD)
        Inversion Count: For an array, inversion count indicates how far (or close) the array is from
        being sorted. If the array is already sorted then the inversion count is 0. If an array is
        sorted in the reverse order then the inversion count is the maximum.
        Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
        Sample Input 1 : N = 5, arr[ ] = {2, 4, 1, 3, 5}
        Sample Output 1 : 3, because it has 3 inversions - (2, 1), (4, 1), (4, 3).itsishanegi@gmail.com
        Sample Input 2 : N = 5, arr[ ] = {2, 3, 4, 5, 6}
        Sample Output 2 : 0, because the array is already sorted
        Sample Input 3 : N = 3, arr[] = {5, 5, 5}
        Sample Output 3 : 0, because all the elements of the array are the same & already in a sorted
        manner.
        (Hint : A sorting algorithm will be used to solve this question.)
        Note - This question is important. Even if you are not able to come up with the approach,
        please understand the solution.
        */
       int arr[]={2, 4, 1, 3, 5};
       System.out.println(inversionCount(arr));
       //ab iska brute force batati hu one note pr fir uska code live likhte h sath mai:  O(n^2)
    

    }
}
