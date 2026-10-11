public class LinkedList38 {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head; //head ek he hota h isliye isse static bnadiya and pure program m use ho ske toh public bhi banaya
    public static Node tail; //tail ek he hota h isliye isse static bnadiya and pure program m use ho ske toh public bhi banaya
    public static int size;

    public void addFirst(int data){ //it is not static kyuki main fucntion static h aur ek static function ek non-static 
                                        // ko call krskta
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
        return;
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){ //tail==null-> yeh likh skte ho but by convention asa mana jata ki head he null toh khali h linked list
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        return;
    }

    public void print(){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void addMiddle(int index,int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        if(index==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(i==index-1){
                break;
            }
            i++;
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;

    }

    public void removeFirst(){
        if(head==null){
            return;
        }
        else if(size==1){
            head=tail=null;
            size--;
            return;
        }
        head=head.next;
        size--;
    }

    public void removeLast(){
        if(head==null){
            return;
        }
        else if(size==1){
            head=tail=null;
            size--;
            return;
        }
        Node temp=head;
        int i=0;
        while(i!=size-2){ //0,1,2,3==3
            temp=temp.next; //10,50,30
            i++; //1,2,3
        }
        temp.next=null; 
        size--;
        tail=temp;
    }

    public void searchKey(int key){
        if(head==null){
            System.out.println("ll is empty.");
            return;
        }
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                System.out.println(temp.data+" found at index: "+i);
                return;
            }
            temp=temp.next;
            i++;
        }
        System.out.println("not found");
    }
    
    
    public int recursiveSearchKey(int key,Node temp){
        if(temp.data==key){
            return 0;
        }
        if(temp.next==null){
            return -1;
        }
        int ind=recursiveSearchKey(key, temp.next);
        if(ind==-1){
            return -1;
        }
        return ind+1;
    }

    public void reverseLinkedList(){
        Node prev=null;
        Node curr=tail=head; //yahi first node ko tail bhi bnadiya
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;            
        }
        head=prev; //yaha update kr diya head ko 
    }


    public void nThNodeRemoval(int nThPosition){
        int traverseTill=size-nThPosition+1;
        int i=1;
        Node temp=head;
        if(traverseTill==size){
            head=head.next; //remove First wala he h same 
            return;
        }
        while(i<traverseTill-1){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        size--;
        
    }

    public Node slowFast(){
        Node slow=head;
        Node fast =head;
        while(fast!=null && fast.next!=null){
            slow=slow.next; //+1
            fast=fast.next.next; //+2
        }
        return slow;
    }

    public boolean palindromeCheck(){
        if(head==null || head.next==null){ //0 size ya 1 size k liye already palindrome h
            return true;
        }
        Node mid=slowFast();
        Node temporaryHead=mid;        
        Node prev=null;
        Node curr=mid=temporaryHead;
        Node next;
        Node temp=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        temporaryHead=prev;

        while(temporaryHead!=null){
            if(temporaryHead.data!=temp.data){
                return false;
            }
            temp=temp.next;
            temporaryHead=temporaryHead.next;
        }
        return true;
    }
    public static void main(){
        //Linked Lists (Part 1)
        /*
        it is a linear type of data structure
        one note pr samjhaungi 
        isme nodes hoti h jo ek dusre se connected hoti h:
        ek node k ander: 1) data 
                         2) next(address hota h) (it is a reference variable that points to an object-> (node)) 
                         
                        *last node mai jo next hota h wo null ki taraf point krta h
        */
        // LinkedList38 ll=new LinkedList38();
        //add at first position
        // ll.addFirst(10); //TC: O(1)
        // ll.addFirst(20);

        //add from last position
        // ll.addLast(30);
        // ll.addLast(40);

        //print linked list
        // ll.print(); //TC: O(n)


        //add somewhere in the middle 
        // ll.addMiddle(2,50); //TC: O(n)
        // ll.print();
        // ll.addMiddle(0, 8);
        // ll.print();

        //printing size of the linked listw
        // System.out.println(ll.size);

        //remove first node
        // ll.removeFirst();
        // ll.print();

        //remove last node
        // ll.removeLast();
        // ll.print();
        //remove last node
        // ll.removeLast();
        // ll.print();

        //search key
        // ll.searchKey(10);
        // ll.searchKey(5);

        //recursive search
        // System.out.println(ll.recursiveSearchKey(10,head)); //TC: O(n) , SC: O(n)
        // System.out.println(ll.recursiveSearchKey(30,head));
        // System.out.println(ll.recursiveSearchKey(50,head));

        //reverse linked list
        // ll.addFirst(34);
        // ll.addFirst(56);
        // ll.addFirst(43);
        // ll.addFirst(23);
        // ll.print();
        // ll.reverseLinkedList(); //isme humesha 3 variables and 4 steps lagenge iteration m
        // ll.print();


        //amazon,adobe,flipkart,Qualcom ka sawal:
        //nth node from last jo hogi usse remove krna h
        // ll.nThNodeRemoval(5);
        // ll.print();



        //palindrome check yeh hume 2 concepts sikhadega:
        //1)slow fast concept -> seperate method bnaya h iske liye maine
        //2)reverse half linkedList
        //check if 1st half==2nd half

        LinkedList38 ll2=new LinkedList38();
        // palindrome wale nodes:
        // ll2.addFirst(1);
        // ll2.addFirst(2);
        // ll2.addFirst(2);
        // ll2.addFirst(1);

        //not palindrome wale nodes:
        // ll2.addFirst(4);
        // ll2.addFirst(6);
        // ll2.addFirst(5);
        // ll2.addFirst(6);
        // ll2.addFirst(4);

        //3 length k liye check:
        ll2.addFirst(5);
        ll2.addFirst(1);
        ll2.addFirst(5);
        ll2.print();
        System.out.println(ll2.palindromeCheck());
    }
}
