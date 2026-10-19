import java.util.*;
class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}

class DoublyLinkedList{
    int val;
    DoublyLinkedList next;
    DoublyLinkedList prev;
    DoublyLinkedList(int val){
        this.val=val;
        this.next=null;
        this.prev=null;
    }

    static DoublyLinkedList head=null;
    static DoublyLinkedList tail=null;
    static int size=0;
    public static void addLast(int val){
        DoublyLinkedList newNode=new DoublyLinkedList(val);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail; 
        tail=newNode;       
    }
    public static int removeLast(){
        if(head==null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(head==tail){
            int val=tail.val;
            head=tail=null;
            size--;
            return val;
        }
        int val=tail.val;
        DoublyLinkedList temp=tail;
        tail=tail.prev;
        temp.prev=null;
        tail.next=null;
        size--;
        return val;
    }

    public static void print(DoublyLinkedList head){
        DoublyLinkedList temp=head;
        while(temp!=null){
            System.out.print(temp.val+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
}

public class LinkedList39 {
    static Node head=null;
    public static boolean isCycle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(Node head){
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast.next!=null && fast!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        slow=head;
        Node prev=null;
        while(fast!=slow){
            prev=fast; //pointing to prev node  of node which is pointed by fast and slow
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;

    }
    public static Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=findMid(head);
        Node rightLinkedList=mid.next;
        mid.next=null;
        Node leftLinkedList=head;
        Node sortedLeft=mergeSort(rightLinkedList);
        Node sortedRight=mergeSort(leftLinkedList);
        Node mergedList=merge(sortedLeft,sortedRight);
        return mergedList;
    }
    public static Node findMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node lefthead,Node righthead){
        Node temp=new Node(-1);
        Node mergedList=temp;
        while(lefthead!=null && righthead!=null){
            if(lefthead.val<righthead.val){
                temp.next=lefthead;
                lefthead=lefthead.next;
            }
            else{
                temp.next=righthead;
                righthead=righthead.next;                
            }
            temp=temp.next;
        }
        while(lefthead!=null){
            temp.next=lefthead;
            lefthead=lefthead.next;
            temp=temp.next;
        }
        while(righthead!=null){
            temp.next=righthead;
            righthead=righthead.next;
            temp=temp.next;
        }
        return mergedList.next;
    }


    public static Node ZigZagLinkedList(Node head){
        Node temp=head;
        //find mid
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        Node rightHalf=mid.next;
        mid.next=null;

        //reverse 2nd half linked list
        Node curr=rightHalf;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;            
        }
        rightHalf=prev;

        //merge in zig zag fashion 1st ko last se 2nd ko 2nd last se and so on.
        Node nextL,nextR;
        while(head!=null && rightHalf!=null){
            nextL=head.next;
            head.next=rightHalf;
            nextR=rightHalf.next;
            rightHalf.next=nextL;

            //updation:
            head=nextL;
            rightHalf=nextR;
        }
        return temp;
    }
    
    public static void main(){
        //floyd's cycle finding algorithm -Linkedlist mai cycle detection krna
        // LinkedList<Integer> head=new LinkedList<>();
        // Node head=new Node(1);
        // Node temp=head.next=new Node(2);
        // head.next.next=new Node(3);
        // head.next.next.next=temp; //iss se cycle h isse comment krdenge toh false milega 
        // System.out.println(isCycle(head));


        //cycle removal:
        // System.out.println(isCycle(head));
        // removeCycle(head);
        // System.out.println(isCycle(head));

        //JCF- java collection framework used to implement inbuilt data structures in java:
        //it has: ArrayList,stack,queues,LinkedList,Hashset,HashMap etc.
        //ager interview mai bolenge tb scratch se bnana wrna use in-built wala he 


        //how to use it?
        // LinkedList<Integer> ll=new LinkedList<>();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addFirst(0);
        // System.out.println(ll); //yeh direct print krdega

        // ll.removeLast();
        // ll.removeFirst();
        // System.out.println(ll);

        //merge sort
        // Node head=new Node(18);
        // head.next=new Node(22);
        // head.next.next=new Node(3);
        // head.next.next.next=new Node(9);
        // Node temp=head;
        // Node newHead=mergeSort(head);
        // while(newHead!=null){
        //     System.out.print(newHead.val+" ");
        //     newHead=newHead.next;
        // }


        //zig zag linkedlist
        //merge in zig zag fashion 1st ko last se 2nd ko 2nd last se and so on.
        // Node head=new Node(18);
        // head.next=new Node(22);
        // head.next.next=new Node(3);
        // head.next.next.next=new Node(9);
        // head.next.next.next.next=new Node(34);
        // Node temp=ZigZagLinkedList(head);        
        // while(temp!=null){
        //     System.out.print(temp.val+" ");
        //     temp=temp.next;
        // }


        //Doubly linkedList:
        DoublyLinkedList dll=new DoublyLinkedList(1);
        DoublyLinkedList.addLast(2);
        DoublyLinkedList.addLast(5);
        DoublyLinkedList.addLast(9);
        DoublyLinkedList.print(dll);
        DoublyLinkedList.removeLast();
        DoublyLinkedList.print(dll);
    }
    
}
