import java.util.*;
public class BinarySearchTree46PArt2 {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static Node sortedBST(int []arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(arr[mid]);
        root.left=sortedBST(arr,start,mid-1);
        root.right=sortedBST(arr,mid+1,end);
        return root;
    }
    public static Node preorder(Node root){
        if(root==null){
            return null;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
        return root;
    }
    public static ArrayList<Integer> inorder(Node root,ArrayList<Integer> arr,int i){
        if(root==null){
            return null;
        }
        inorder(root.left,arr,i+1);
        arr.add(root.val);
        inorder(root.right, arr, i+1);
        return arr;
    }

    public static Node convertToBalancedBST(ArrayList<Integer> arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(arr.get(mid));
        root.left=convertToBalancedBST(arr,start,mid-1);
        root.right=convertToBalancedBST(arr, mid+1, end);
        return root;        
    }
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int max_size=0;
    public static Node largestNode=null;    
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.val,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.val,Math.max(leftInfo.max,rightInfo.max));
        if(root.val<=leftInfo.max || root.val>=rightInfo.min){
            return new Info(false,size,min,max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            max_size=Math.max(max_size,size);
            largestNode=root;
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static Node mergeBST(Node root1,Node root2){
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        inorder(arr1,root1);
        inorder(arr2,root2);
        int i=0;
        int j=0;
        ArrayList<Integer> finalArr=new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;                
            }
            else{
                finalArr.add(arr2.get(j));
                j++;
            }
            
        }
        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
            
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
            
        }
        Node root=createBST(finalArr,0,finalArr.size()-1);
        return root;
    }
    public static void inorder(ArrayList<Integer> arr,Node root){
        if(root==null){
            return;
        }
        inorder(arr,root.left);
        arr.add(root.val);
        inorder(arr,root.right);
    }
    public static Node createBST(ArrayList<Integer>arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBST(arr, start, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }
    public static void main(){
        //sorted array se BST banana:
        // int arr[]={3,5,6,8,10,11,12};
        // hum preorder use krenge verify krne ko apna tree 
        /*
                    8
                   / \
                  5   11
                 / \  / \
                3  6 10 12

            yeh banana h hume
        */
    //    Node root=sortedBST(arr,0,arr.length-1);
    //    preorder(root);


    //convert BST to Balanced BST 
    /*
            8                 
           / \
          6   10
         /     \
        5       11
       /         \
      3           12


        -->         8
                   / \
                  5   11
                 / \  / \
                3  6 10 12

    */

    //   Node root=new Node(8);
    //   root.left=new Node(6);
    //   root.left.left=new Node(5);
    //   root.left.left.left=new Node(3);
    //   root.right=new Node(10);
    //   root.right.right=new Node(11);
    //   root.right.right.right=new Node(12);
    //   ArrayList<Integer> arr=inorder(root,new ArrayList<Integer>(),0);
    //   for(int i=0;i<arr.size();i++){
    //         System.out.print(arr.get(i)+" ");
    //   }
    //   System.out.println();
    //   Node newRoot=convertToBalancedBST(arr,0,arr.size()-1);  //TC:O(n)
    //   preorder(newRoot);


      //Max BST in a BST
      //hum iska node bhi aur size bhi print krwayenge
    //   Node root = new Node(50);
    //   root. left = new Node(30);
    //   root. left. left = new Node(5);
    //   root. left.right = new Node(20);

    //   root.right = new Node(60);
    //   root.right.left = new Node(45) ;
    //   root.right.right = new Node(70);
    //   root.right.right. left = new Node(65);
    //   root.right.right.right = new Node(80);

      /*

/*
from this:
         50
       /   \
      30    60
     / \    / \
    5  20  45 70
              / \
             65  80



expected BST:      

            60
            /\
          45  70
              /\
             65 80


*/
        // Info ans=largestBST(root);
        // System.out.println("Largest BST size: "+max_size);
        // System.out.println("Largest BST node: ("+largestNode.val+")");
        // inorder(largestNode);


        //merge 2 BST
        /*
                2
               / \
              1   4
        
        
        */    
        // Node root1 = new Node(2);
        // root1. left = new Node(1);
        // root1.right = new Node(4);

    /*

            9
           / \
          3  12
*/

        // Node root2 = new Node(9);
        // root2. left = new Node(3);
        // root2.right = new Node(12);
        // //0(n+m) -> linear
        // Node root=mergeBST(root1,root2);
        // inorder(root);


        //AVL tree: self balancing tree hota h 
        //balance factor {-1,0,1} 
        //if more or less than these values then :
        //1) find ki case konsa h ll,lr,rr,rl mai se jaha new node insert hui h
        //2)rotations perform hoti h 
        //for ll-> right rotation
        //for rr-> left rotation
        //for lr-> left rotation then right rotation
        //for rl-> right rotation then left rotation
        //LL,LR,RL,RR sub rotations hoti h isme 
        //apko about AVL tree mai one note pr bataungi btw iska code interview 
        // mai krwaya ni jata kyuki hard hota h jldi krna isse long hota code kaafi 
        //but hume iske basics pata hona chahiye and code pata hona chahiye hum dekhlenge sathme
        //dono basic bhi and code bhi gpt se 
        /*
        question hote h iske: 1)rotation mai case kaise find krte h
                              2)aur ager rotation hori h toh batao diagram 
                                se bnake kaise hori h
        */


        /*
        A Red-Black Tree is a self-balancing binary search tree in which each node
        has an extra bit, which represents its color (red or black).
        (Every Red Black Tree is a binary search tree but all the Binary Search Trees
        need not to be Red Black trees.)

        //yeh bhi isme bhi content h but abhi mai bhi ni kr ri isse revision k time
        //  sathme bs dekhke jayenge kya kya basics h red black tree k and code ek baar 
        // dekh lenge 
        
        
        */
        
    }
}
