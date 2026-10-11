import java.util.*;

public class Stack4 {
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
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);        
        reverseAStack(s);
        printAStack(s); //3,2,1 ko 1,2,3


    }
}
