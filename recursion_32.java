import java.util.ArrayList;
import java.util.List;

public class recursion_32 {
    static int factorial(int a){ //5,4
        if(a==1){ //base case
            return 1; //1
        }
        return a*factorial(a-1); //5*factorial(4),4*factorial(3),3*factorial(2),2*factorial(1),1=1*2*3*4*5=120
    }

    static int decreasingOrder(int a){
        if(a==0){
            return 0;
        }
        System.out.print(a+" ");
        return decreasingOrder(a-1);
    }

    static void increasingOrder(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        increasingOrder(n-1);
        System.out.print(n+" ");
    }

    static int sumOfFirstNNaturalNumbers(int n){
        if(n==1){
            return 1;
        }
        return n + sumOfFirstNNaturalNumbers(n-1);
    }


    static int fibonacciNumber(int n){
        if(n==0 || n==1){
            
            return n;
        }
        
        return fibonacciNumber(n-1)+fibonacciNumber(n-2);
    
    }


    static boolean isSorted(int arr[],int start){
        if(start==arr.length-1){
            return true;
        }
        if(arr[start]<arr[start+1]){
            return isSorted(arr,start+1);
        }
        else{
            return false;
        }
        
        
        
    }

    static int firstOccuranceOfNumber(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccuranceOfNumber(arr,key,i+1);
    }


    
    static int lastOccurenceOfNumber(int arr[],int key,int i,int ans){
        if(i==arr.length){
            return ans;
        }
        if(arr[i]==key){
            ans=i;
        }
        return lastOccurenceOfNumber(arr,key,i+1,ans);
    }


    static int xPowerN(int x,int n){
        if(n==0){
            return 1;
        }
        return x*xPowerN(x,n-1);
    }





    static int optimizedXPowerN(int x,int n){
        if(n==0){
            return 1;
        }
        int half= optimizedXPowerN(x,n/2);
        if(n%2!=0){
            return x*half*half;
        }
        return half*half;
        
    }

    static int allOccurence(int arr[],int key,int i){
        if(i==arr.length){
            return 0;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
        }
        return allOccurence(arr, key, i+1);
    }


    static int numToString(int n,List<String> l){
        if(n==0){
            return 0;
        }
        int rem=n%10;
        numToString(n/10,l);
        System.out.print(l.get(rem)+" ");
        return 0;
    }



    public static void main(){
        /*
        recursion is a method of solving a computational problem where a solution depends on solutions to 
        smaller instance of the same problem
        */
    //    System.out.println(factorial(5)); //TC: O(n) and SC: O(n)-> calls saari stack m store hoti h isliye SC bhi O(n) h

    
    //    decreasingOrder(5);
       //ab mai apko one note pr call stack k kaam krne ka tarika main function se recursive wale function ki call k liye n=5
       //pr batati hu



       //stack overflow -> too many recursion calls,and huge memory consumption function k ander ke cheezo se like
       //  variable or array -> iska reason hota h base case nahi likhoge toh stack overflow he hoga yani memory fully used..
       //so to avoid it write a base case.



    //    increasingOrder(5); 
       //call stack pr one note m isko bhi bataungi and will also tell about call frame kya hota h-> her ek box stack k ander


    //    System.out.println(sumOfFirstNNaturalNumbers(5));



    //print nth fibonacci number 
    // System.out.print(fibonacciNumber(5)); //TC:O(2^n) and space : O(n)->inn dono ko bhi one note pr samjhaungi
    //mai apko saare recursion factions k liye one note r sub samjhaungi



    //is sorted or not
    int arr[]={2,4,6,3,5,9,3,5};
    // System.out.println(isSorted(arr,0)); //TC: O(n) and SC:O(n)



    //first occurance of a key
    // System.out.println(firstOccuranceOfNumber(arr,5,0));  //TC: O(n) and SC:O(n)


    //last occurence of an element in an array
    // System.out.println(lastOccurenceOfNumber(arr,5,0,-1));


    //power of x
    // System.out.println(xPowerN(2,10)); //TC:O(n) and SC:O(n)


    // System.out.println(optimizedXPowerN(2,5)); //TC:O(log(n)) and SC: O(log(n)) 
    //Optimized power of x check onenote for this dry run


    //all occurences print krni h 
    // allOccurence(arr,5,0);


    //string m likho number ko
    List<String> l= new ArrayList<>();
    l.add("zero");
    l.add("one");
    l.add("two");
    l.add("three");
    l.add("four");
    l.add("five");
    l.add("six");
    l.add("seven");
    l.add("eight");
    l.add("nine");

    numToString(2019,l);

    }
}
