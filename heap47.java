import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class heap47 {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override //O capital
        public int compareTo(Student s2){ //Note: func name: compareTo he rahega yaha
            return this.rank-s2.rank;
        }
    }
    static class Heap{
        static ArrayList<Integer> arr=new ArrayList<>();
        public static boolean isEmpty(){
            return arr.size()==0;
        }
        public static void add(int a){            
            arr.add(a);
            int childIndex=arr.size()-1;
            int parentIndex=(childIndex-1)/2;
            while(parentIndex>=0 && arr.get(childIndex)<arr.get(parentIndex)){ //min heap
                int temp=arr.get(childIndex);
                arr.set(childIndex,arr.get(parentIndex));
                arr.set(parentIndex,temp);
                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;
            }
            // System.out.println(arr);
        }
        public static int peek(){
            return arr.get(0);
        }
        public static int remove(){
            //data store krdo jo remove kr re
            int data=arr.get(0);
            //swap kro arr k last element se- yeh isliye krna h kyuki leaf node se delete krna easy
            //hota h arr mai bs last element pr wo data lejao jo delete krna bs fir hatado aage 
            // ki process se
            int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            arr.remove(arr.size()-1); //ab root wala number remove ho gaya
            //ab kyuki yeh sub krke pura tree min ya max jo bhi tha disturb ho gaya ab heapify krenge
            //isme 0 index se start krke check krenge left and right child mai se teeno m se jo small
            //wo root bnta jayega for every recursive call heapyfy k ander
            heapify(0); //index diya h isse, yeh private function hoga
            return data;
        }
        private static void heapify(int i){
            int left=(2*i)+1;
            int right=(2*i)+2;
            int minIndex=i; //manke chalre ki root pr jo h wo min he h
            
            if(left<arr.size() && arr.get(left)<arr.get(minIndex)){
                minIndex=left;
            }
            if(right<arr.size() && arr.get(right)<arr.get(minIndex)){
                minIndex=right;
            }
            if(minIndex!=i){
                //swap
                int temp=arr.get(minIndex);
                arr.set(minIndex,arr.get(i));
                arr.set(i,temp);
                heapify(minIndex);
            }
            
            
        }
    }
    public static void heapSort(int arr[]){
        //build maxHeap: for ascending order
        for(int i=(arr.length/2)-1;i>=0;i--){
            heapify(arr,i,arr.length);
        }
        //element at index 0 ko last mai lejao
        for(int i=arr.length-1;i>0;i--){
            //swap ki help se first largest element ko last mai le jao
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            //heap ka rules maintain kro max tha toh max rakho 
            heapify(arr,0,i);
        }
    }
    public static void heapify(int arr[],int i,int size){
        int left=(2*i)+1;
        int right=(2*i)+2;
        int maxIndex=i;
        if(left<size && arr[left]>arr[maxIndex]){
            maxIndex=left;
        }
        if(right<size && arr[right]>arr[maxIndex]){
            maxIndex=right;
        }
        if(maxIndex!=i){
            int temp=arr[i];
            arr[i]=arr[maxIndex];
            arr[maxIndex]=temp;
            heapify(arr,maxIndex,size);
        }
    }
    static class Points implements Comparable<Points>{
        int x;
        int y;
        int distSQ;
        int ind;
        public Points(int x,int y,int distSQ,int ind){
            this.x=x;
            this.y=y;
            this.distSQ=distSQ;
            this.ind=ind;
        }
        @Override 
        public int compareTo(Points p2){ //Note: isse static type ka ni bana skte
            return this.distSQ-p2.distSQ;
        }
    }
    static class Soldiers implements Comparable<Soldiers>{
        int count;
        int i;
        public Soldiers(int c,int i){
            this.count=c;
            this.i=i;
        }
        @Override 
        public int compareTo(Soldiers s2){
            if(this.count==s2.count){
                return this.i-s2.i;
            }
            return this.count-s2.count;
        }

    }
    static class Window implements Comparable<Window>{
        int val;
        int ind;
        public Window(int val,int ind){
            this.val=val;
            this.ind=ind;
        }
        @Override 
        public int compareTo(Window w2){
            return w2.val-this.val;
        }
    }
    public static void main(){
        //heap ki form mai priority queue ko java mai internally implement kiya 
        // jata h samjahne k liye we will do priority queue first
        //priority queue: kisi jyada rank wale ki priority km hogi km rank wale se like
        // rank 5 ki priority more than 500 wala student 
        //pq mai add aur remove krne mai O(log n) TC hota h and O(1) for peek
        // PriorityQueue <Integer> pq=new PriorityQueue<>(); //ager PriorityQueue<>() iske ander 
        // Comparator.reverseOrder() likhoge toh descending order mai priority hogi
        // pq.add(9); //O(log(n))
        // pq.add(1);
        // pq.add(7);
        // while(!pq.isEmpty()){
        //     System.out.print(pq.peek()+" "); //O(1)
        //     pq.remove(); //O(log(n))
        // }



        /*
        ab ager hume object k basis pr compare krna h toh priority queue mai kya hoga?
        uper comparable inheret krti hui student class dekho fir uska over ride kiya 
        hua method dekho jo usse comparable se mila h bs usse comparition k liye use krenge
        Note: comparable class jo humne inherit ki h usse use krke hum name k basis pr 
        ya roll number ya age ya marks k basis pr compare kr skte and assending ya descending
        mai sort kr skte ab uper dekho and yeh wapis padhna comment sub samjh aajayega
        
        */
    //    PriorityQueue <Student> pq1=new PriorityQueue<>();//yaha bhi Comparator.reverseOrder() likhskte
    //    pq1.add(new Student("Isha",5));
    //    pq1.add(new Student("tanu",3));
    //    pq1.add(new Student("Shiv",2));
    //    while(!pq1.isEmpty()){
    //         System.out.println(pq1.peek().name+"->"+pq1.peek().rank);
    //         pq1.remove();
    //    }


    //Heap: it's a type of a binary tree 
    /*
    binary tree ko array se implement krte h and uss binary tree ki implementation se priority 
    queues milta h

    2 type:
    Max heap:highest priority wala element root node hota h aur wo max hota google se image batati
    Min heap:highest priority wala element root node hota h aur wo min hota google se image batati

    Binary Tree:
        at most 2 children
    Complete Binary Tree:
        CBT is a BT in which all the levels are completely filled except
        possibly the last one, which is filled from the left to right.
    Heap Order Property:
        Children >= Parent (minHeap)
        Children <= Parent (maxHeap)

    
    Array se implement krte h isse kyuki class se Node ki insertion krne pr kafi TC lgti
    so to avoid that array wali implementation krte h hum bs ab isme left and right child
    k liye formula is there remember very important :
    left child=(2*i)+1
    right child=(2*i)+2
    yeh tb hoga ager array 0 se indexing khaali he ho

    ab kuch loh -1 fill kr dete index 0 pr array k ager asa hua then :
    left child=(2*i)
    right child=(2*i)+1

    child se parent pr jaane k liye:
    (i-1)/2
    */


        // Heap h=new Heap();
        // h.add(9);
        // h.add(2);
        // h.add(6);
        // h.add(1);
        // h.add(3);
        // System.out.println("Peek: "+h.peek());
        // //remove mai hume min element delete krna h jo arr k ander min heap mai 0 index pr hoga
        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }
        /*
        isme max heap mai bs > < inn sign mai changes honge sub functions mai aur baki yeh 
        add function log(n) and remove bhi log(n) time liya but peek constant time liya 
        ab yeh heap sort bhi bola ja skta h TC:O(nlog(n)) hui uski bs
        */

        //heap sort
        /*
        TC: O(nlog(n))
        ascending: max heap
        descending: min heap
        */
    //    int arr[]={2,5,4,1,3};
    //    heapSort(arr);
    //    for(int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]+" ");
    //    }
       /*
       Yahan do cheezein hoti hain:
        Loop: Approximately n times chalta hai → O(n).
        Heapify: Har iteration mein maximum height tak travel kar 
        sakta hai → O(log n).

        Aisa kyun? Heap ek Complete Binary Tree hota hai, jiski 
        height approximately log₂(n) hoti hai.

        Isliye:

        O(n)×O(logn)=O(nlogn)
       */


        //Nearby Cars

        /*We are given N points in a 2D plane which are locations of N cars.
        If we are at the origin, print the nearest K cars.
        */
    //    PriorityQueue<Points> pq=new PriorityQueue<>();
    //    int arr[][]={{3,3},{5,-1},{-2,4}};
    //    int k=2;
    //     for(int i=0;i<arr.length;i++){
    //         int distSQ=arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1];
    //         pq.add(new Points(arr[i][0],arr[i][1],distSQ,i));
    //     }
    //     for(int i=0;i<k;i++){
    //         System.out.println("C"+pq.remove().ind);
    //     }



    //connecting n ropes with min cost
        // int ropes[]={2,3,3,4,6};
        // PriorityQueue<Integer> pq=new PriorityQueue<>();
        // for(int i=0;i<ropes.length;i++){
        //     pq.add(ropes[i]);
        // }
        // int cost=0;
        // while(pq.size()>1){
        //     int min1=pq.remove();
        //     int min2=pq.remove();
        //     cost+=min1+min2;
        //     pq.add(min1+min2);
        // }
        // System.out.println("cost of rope: "+cost);




        /*
        Weakest Soldier
        We are given an mxn binary matrix of 1's (soldiers) and O's (civilians). 
        The soldiers are positioned in front of the civilians. That is, all the 1's 
        will appear to the left of all the O's in each row.

        A row i is weaker than a row j if one of the following is true:
        . The number of soldiers in row i is less than the number of soldiers in row j.
        . Both rows have the same number of soldiers and i < j.
        Find the K weakest rows.        
        */
    //    int army[][] = {{1, 0, 0, 0},
    //                     {1, 1, 1, 1},
    //                     {1, 0, 0, 0},
    //                     {1, 0, 0, 0}};
    //     int k=3;
    //    PriorityQueue<Soldiers> pq=new PriorityQueue<>();
    //    for(int i=0;i<army.length;i++){
    //         int count=0;
    //         for(int j=0;j<army[i].length;j++){
    //             if(army[i][j]==1){
    //                 count++;
    //             }
    //         }
    //         pq.add(new Soldiers(count,i));
    //    }
    //    for(int i=0;i<k;i++){
    //         System.out.println("S"+pq.remove().i);
    //    }



       //sliding window max in a window of length k:
        int arr[]={1, 3, -1, -3, 5, 3, 6, 7};
        int k=3; //window size for every iteration
        PriorityQueue<Window> pq=new PriorityQueue<>();
        int res[]=new int[arr.length-k+1];
        for(int i=0;i<k;i++){
            pq.add(new Window(arr[i],i));
        }
        res[0]=pq.peek().val;
        for(int i=k;i<arr.length;i++){
            while(pq.peek().ind<=i-k){
                pq.remove();
            }
            pq.add(new Window(arr[i],i));
            res[i-k+1]=pq.peek().val;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
