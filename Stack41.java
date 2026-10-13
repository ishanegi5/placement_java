import java.util.*;

public class Stack41 {
    //arrayList implementation wala class 
    static public  class StackUsingArrayList{
        static ArrayList<Integer> list=new ArrayList<>();
        static boolean isEmpty(){
            return list.size()==0;
        }
        static int push(int val){
            list.add(val);
            return 0;
        }
        static int pop(){
            if(isEmpty()){
                return -1;
            }
            int val=list.get(list.size()-1);
            list.remove(list.size()-1);
            return val;
        }
        static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    //LinkedList implementation wala class:
    static public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head=null;
    static Node tail=null;
    static public class LinkedListImplementationForStack{
        static boolean isEmpty(){
            return head==null;
        }
        static int push(int val){
            Node newNode=new Node(val);
            if(head==null){
                head=tail=newNode;
                return 0;
            }
            newNode.next=head;
            head=newNode;
            return 0;            
        }
        static int pop(){
            if(head==null){
                return -1;
            }
            int val=head.data;
            head=head.next;
            return val;
        }
        static int peek(){
            if(head==null){
                return -1;
            }
            return head.data;
        }
    }

    public static int pushAtBottom(Stack<Integer> s,int val){
        if(s.isEmpty()){
            return s.push(val);
        }
        int top=s.pop();
        pushAtBottom(s, val);
        s.push(top);
        return 0;
    }

    public static String reverseString(Stack<Character> s,String revString){
        if(s.isEmpty()){
            return revString;
        }
        char top=s.pop();
        revString+=top;
        return reverseString(s,revString);        
    }

    public static void reverseAStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverseAStack(s);
        pushAtBottom(s, top);
    }
    public static void printAStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static int[] stockSpan(int stocks[],int span[],int ind){
        Stack<Integer> s=new Stack<>();
        s.push(0); //index of first element of stock
        span[0]=1;     //first element k liye humesha span[i]=1 mante h aese he last element ya
        //koe bhi element ager equal ho aur wo last ho stack m toh +1 add hota h
        //jo example humne liye h wo iss baat ko cover krdega dry run krke dekhenge    
        for(int i=1;i<stocks.length;i++){
            int currentElement=stocks[i];
            while(!s.isEmpty() && stocks[s.peek()]<=currentElement){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }
            else{
                span[i]=i-s.peek(); //current index-previous greater element ka index                
            }
            s.push(i);
        }
        System.out.println(s.peek());
        return span;
    }


    public static int[] greaterElement(int arr[],int ans[]){
        Stack <Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=arr[s.peek()];
            }
            s.push(i);
        }
        return ans;
    }
    public static void main(){
        /*
        1)memory khud se jo stack rakhti h in built usse implicit stack kehete h like in recursion
        2)jo hum banate h usse explicit stack kehete h aj banayenge 
        eg: pile of books,coins,stones etc 

        isme 3 operations h:
        1)push
        2)pop
        3)peak
        sub TC:O(1) visulaize it like a bucket top se push,pop and peek sub hota h
        it follows LIFO last in first out jo last mai gaya wo pehele bahar ayega
        
        isko implement array,arrayList,LinkedList subse ho skta 
        but best LinkedList h kyuki head se he push pop and peek easy h

        Note: amazon aur kuch aur companies ne linkedlist se stack kaise bnate h pucha hua h 

        */

        //ArrayList wali implementation
        // StackUsingArrayList s=new StackUsingArrayList();
        // System.out.println(s.peek());
        // s.push(5);
        // s.push(9);
        // s.push(12);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());            
        // }

        //LinkedList wali implementation
        // LinkedListImplementationForStack lls=new LinkedListImplementationForStack();
        // lls.push(3);
        // lls.push(65);
        // lls.push(98);
        // System.out.println(lls.peek());
        // while(!lls.isEmpty()){
        //     System.out.println(lls.pop());
        // }

        // java collection frame work mai bhi yeh kaam sub possible h bs ek 2 lines chahiye:
        //import java.util.*;
        //Stack<Integer> s=new Stack<>(); -> isme push pop peek sub h
        //interview mai jub tk na bole tb tk issi ko use krna built in h jaldi use hoga isliye
        // Stack<Integer> s=new Stack<>();
        // s.push(7);
        // s.push(9);
        // s.push(100);
        // System.out.println(s.peek());
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }


        //push at the bottom
        // Stack<Integer> s=new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s,6);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }


        //reverse a string using stack
        // Stack<Character> s=new Stack<>();
        // s.push('i');
        // s.push('s');
        // s.push('h');
        // s.push('a');
        // System.out.println(reverseString(s,"")); 
        //isse loop lagake bhi kr skte the


        //reverse a stack
        // Stack<Integer> s=new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);        
        // reverseAStack(s);
        // printAStack(s); //3,2,1 ko 1,2,3


        //ab stock span problem -> yeh placement,interview subme puch skte h
        //microsoft,samsung,amazon mai pucha gaya h
        // peechle prices jub abhi se jyada the ka span batana h bs one note pr google se image
        //se batati hu acheys se yeh
        // int stocksPrice[]={100,80,60,70,60,85,100};
        // int []span=new int[stocksPrice.length];
        // stockSpan(stocksPrice,span,0);
        // for(int i=0;i<stocksPrice.length;i++){
        //     System.out.print(span[i]+" ");
        // }


        //Next greater element
        //Note: isme TC: O(n) he hogi 2 loops h fir bhi kyuki stack mai her element
        //2 he baar ander jaara h ya stack se bahar jara h so 2n hua wo + outer loop n baar 
        //run krega so TC: O(2n+n)=O(3n)=O(n)
        int arr[]={6,8,0,1,3};
        int ans[]=new int[arr.length];
        greaterElement(arr,ans);
        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }

    }
}
