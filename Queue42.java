import java.util.*;
public class Queue42 {
    static int []q;
    static int rear;
    static int size;
    static int front; //this is only needed for circular queue baki iska koe use ni normal queue m

    Queue42(int n){
        rear=-1;
        this.q=new int [n];
        size=n;
    }

    public static boolean isEmpty(){
        return rear==-1;
    }
    public static void add(int data){
        if(rear==size-1){
            System.out.println("Queue is full"); 
            return;           
        }
        rear=rear+1;
        q[rear]=data; 
             
    }
    public static int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        for(int i=0;i<rear;i++){
            q[i]=q[i+1];
        }
        rear--;
        

        int data=q[0];        
        return data;
    }
    public static int peek(){
        if(rear==-1){
            System.out.println("Queue is empty");
            return -1;
        }
        int data=q[0];
        return data;
    }

    Queue42(int size,String s){
        rear=-1;
        this.q=new int [size];
        this.size=size;
        front=-1;
    }

    public static boolean isEmptyCQ(){
        return front==-1 && rear==-1;
    }
    public static boolean isFullCQ(){
        return (rear+1)%size==front;
    }
    public static void addCQ(int data){
        if(isFullCQ()){
            System.out.println("Queue is full"); 
            return;           
        }
        if(front==-1){
            front=(front+1)%size;
        }
        rear=(rear+1)%size;
        q[rear]=data; 
             
    }
    public static int removeCQ(){
        if(isEmptyCQ()){
            System.out.println("Queue is empty");
            return -1;
        }
        int data=q[front]; 
        
        if(front==rear){
            front=rear=-1;
        }  
        else{
            front=(front+1)%size;
        }             
        return data;
    }
    public static int peekCQ(){
        if(isEmptyCQ()){
            System.out.println("Queue is empty");
            return -1;
        }
        int data=q[front];
        return data;
    }

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    //constructor for this LL implementation for queue:
    Queue42(){

    }
    static Node head=null;
    static Node tail=null;
    public static boolean isEmptyLL(){
        return tail==null;
    }
    public static void addLL(int val){
        Node newNode=new Node(val);
        if(tail==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public static int removeLL(){
        if(isEmptyLL()){
            System.out.println("Queue is empty");
            return -1;
        }
        int data=head.data;
        if(head==tail){
            head=tail=null;
            return data;
        }
        head=head.next;
        return data;
    }
    public static int peekLL(){
        if(isEmptyLL()){
            System.out.println("Queue is empty");
            return -1;
        }
        
        return head.data;
    }
    static Stack<Integer> s1=new Stack<>();
    static Stack<Integer> s2=new Stack<>();
    public static boolean QUsingSisEmpty(){
        return s1.isEmpty();
    }
    public static void QUsingSadd(int data){
        s1.push(data);
    }
    public static int QUsingSremove(){
        if(QUsingSisEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        while(!QUsingSisEmpty()){
            s2.push(s1.pop());
        }
        int data=s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return data;
    }
    public static int QUsingSpeek(){
        if(QUsingSisEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        while(!QUsingSisEmpty()){
            s2.push(s1.pop());
        }
        int data=s2.peek();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return data;
    }

    static Queue <Integer> q1=new LinkedList<>();
    static Queue<Integer> q2=new LinkedList<>();
    public static boolean SUsingQisEmpty(){
        return q1.isEmpty();
    }
    public static void SUsingQadd(int data){
        while(!SUsingQisEmpty()){
            q2.add(SUsingQPeek());
            SUsingQremove();
        }
        q1.add(data);
        while(!q2.isEmpty()){
            q1.add(q2.peek());
            q2.remove();
        }
    }
    public static int SUsingQremove(){
        if(q1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return q1.remove();
    }
    public static int SUsingQPeek(){
        if(q1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return q1.peek();
    }

    public static void printNonRepeating(String inputStr){
        Queue<Character>q=new LinkedList<>();
        int freq[]=new int[26];
        for(int i=0;i<inputStr.length();i++){
            char ch=inputStr.charAt(i);
            freq[ch-'a']++;
            q.add(ch);
            while(!q.isEmpty() && freq[q.peek()-'a']!=1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1 ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
    }
    public static void interleaf(Queue<Integer>q){
        Queue<Integer> firstHalf=new LinkedList<>();
        int size=q.size()/2;
        for(int i=0;i<size;i++){
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void reversal(Queue<Integer>q){
        Stack<Integer> s=new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    static class MyQueue{
        static Deque <Integer> d=new LinkedList<>();
        public static boolean isEmpty(){
            return d.isEmpty();
        }
        public static void add(int data){
            d.addLast(data);
        }
        public static int remove(){
            if(d.isEmpty()){
                return -1;
            }
            return d.removeFirst();
        }
        public static int peek(){
            if(d.isEmpty()){
                return -1;
            }
            return d.getFirst();
        }
    }
    static class MyStack{
        static Deque <Integer> d=new LinkedList<>();
        public static boolean isEmpty(){
            return d.isEmpty();
        }
        public static void push(int data){
            d.addLast(data);
        }
        public static int pop(){
            return d.removeLast();
        }
        public static int peek(){
            return d.getLast();
        }
    }
    public static void main(){
        /*
        FIFO hota h isme
        front se insertion and rear se deletion  ya vice versa but ek side se bs ek he kaam hota

        operations:
        1)enqueue->(add krna element ko)
        2)dequeue->(delete krna element ko)
        3)peek ->(front se dekhna element ko) 

        Note: deque bhi hota h isme dono side se insertion and deletion possible h
        aur sub operations O(1) TC k h 


        implementation:
        1)array
        2)linkedList
        3)stack

        */
    //    Queue42 q=new Queue42(5);
    //    q.add(1); //TC:O(1)
    //    q.add(2);
    //    q.add(3);
    //    System.out.println(q.peek()+" ");
    //    while(!q.isEmpty()){
    //         System.out.print(q.peek()+" ");
    //         q.remove(); //TC:O(n) ->shifting 
    //    }


    //circular queue: formula : front=(front+1)%size
    //    Queue42 q=new Queue42(3,"circular queue wala constructor call hoga");
    //    q.addCQ(1); //TC:O(1)
    //    q.addCQ(2);
    //    q.addCQ(3);
    //    System.out.println(q.removeCQ());
    //    q.addCQ(4);
    //    System.out.println(q.removeCQ());
    //    q.addCQ(5);
    //    while(!q.isEmptyCQ()){
    //         System.out.println(q.peekCQ());
    //         q.removeCQ(); //TC:O(1) ->shifting nahi h yaha isliye
    //    }


        //queue using Linked list banayenge ab isme bhi sub O(1) TC ka he h
        // Queue42 q=new Queue42();
        // q.addLL(1);
        // q.addLL(2);
        // q.addLL(3);
        // while(!isEmptyLL()){
        //     System.out.println(q.peekLL());
        //     q.removeLL();
        // }

        //built-in JCF ka
        // Queue<Integer> q=new Queue<>(); asa ni likhte kabhi kyuki queue ek interface hota h
        //Remember: interface ki koe class ni hoti

        // Queue<Integer> q=new LinkedList<>(); //ArrayDeque ->caching ka difference hota h
        //baki jyada puchte ni isse but hum sathme padhenge isse
        // ab isme
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        //Note: yaha kya hora h Queue usme TC:O(1) h subki and sathme yeh same operations
        //  with same function name hum ArrayDeque se bhi kr skte h LinkedList ki jagha sub same h
        //jo difference hum gpt se padhenge uske alawa kuch bhi nahi h 


        //queue using 2 stacks microsoft and google asked it
        /*
        we have 2 stacks and hum s1 mai 1 rakhte h and agli baar 2 add krne k liye s1 mai 
        hum pehele s2 mai push krenge s1 ka sub  data and then s1 mai new data dalke s2 se 
        push krenge wapis jo data maujud tha

        //    iski 2 ways h implementation k:
        1) Push inO(n):add in O(n) and remove and peek in O(1) --> ap yeh krna 
        2)Pop in O(n):add in O(1) and remove and peek in O(n) --> maine yeh kiya 
        */
    
        // QUsingSadd(1);
        // QUsingSadd(2);
        // QUsingSadd(3);
        // QUsingSremove();
        // while(!QUsingSisEmpty()){
        //     System.out.println(QUsingSpeek());
        //     QUsingSremove();
        // }


        //Stack using 2 queue: isme bhi same 2 ways h hum ab push: O(n) wala krte h
        // SUsingQadd(1);
        // SUsingQadd(2);
        // SUsingQadd(3);
        // System.out.println(SUsingQremove());
        // while(!SUsingQisEmpty()){
        //     System.out.println(SUsingQPeek());
        //     SUsingQremove();
        // }

        // print non repeating characters in a stream of characters
        //note: jyadater stream of characters ager bolte h usme queue k use k baare m 
        // we should think but not always
        // String inputStr="aabccxb";
        // printNonRepeating(inputStr); //TC:O(n)


        //Interleave 2 Halves of a Queue (even length)
        /*
        1 2 3 4 5 6 7 8 9 10 (question)
        1 6 2 7 3 8 4 9 5 10 (answer)

        string ko half mai divide kiya fir 1st ko 1st se 2nd ko 2nd se jodha type hora yaha
        */
    //    Queue<Integer> q=new LinkedList<>();
    //    q.add(1);
    //    q.add(2);
    //    q.add(3);
    //    q.add(4);
    //    q.add(5);
    //    q.add(6);
    //    q.add(7);
    //    q.add(8);
    //    q.add(9);
    //    q.add(10);
    //    interleaf(q);
    //    while(!q.isEmpty()){
    //         System.out.print(q.remove()+" ");
    //    }



    //queue reversal
        // Queue<Integer> q=new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // reversal(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.remove()+" ");
        // }

        //Deque-> double ended queue
        /*
        addFirst()
        addLast()
        removeFirst()
        removeLast()
        getFirst()
        getLast()
        sub possible isme
        
        */
    //    Deque <Integer>d=new LinkedList<>();//yaha bhi Deque ek interface h 
    //    d.addFirst(1);
    //    d.addFirst(2);
    //    d.addLast(3);
    //    d.addLast(5);
    //    System.out.println(d);
    //    d.removeFirst();
    //    System.out.println(d);
    //    d.removeLast();       
    //    System.out.println(d);
    //    System.out.println(d.getFirst());
    //    System.out.println(d.getLast());

    //stack and queue using Deque
    // MyQueue q=new MyQueue();
    // q.add(1);
    // q.add(2);
    // q.add(3);
    // while(!q.isEmpty()){
    //     System.out.print(q.peek()+" ");
    //     q.remove();
    // }

    //ab stack ki class bnake usme stack using deque bhi krskte h
        //usme bhi sub O(1) TC hoga

    MyStack s=new MyStack();
    s.push(1);
    s.push(2);
    s.push(3);
    while(!s.isEmpty()){
        System.out.print(s.peek()+" ");
        s.pop();
    }
    }
}
