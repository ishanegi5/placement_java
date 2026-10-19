import java.util.*;
public class binarySearchTree46 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node buildBST(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=buildBST(root.left,val);
        }
        else{
            root.right=buildBST(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data<key){
            return search(root.right, key);
        }
        else{
            return search(root.left,key);
        }
    }

    public static Node delete(Node root,int key){
        if(root==null){
            return null;
        }

        if(root.data>key){
            root.left=delete(root.left, key);
        }
        else if(root.data<key){
            root.right=delete(root.right, key);
        }
        else{
            //case 1:
            if(root.left==null && root.right==null){
                return null;
            }

            //case 2:
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            //case 3:
            else{
                Node inorderSuccessorNode=inorderSuccessor(root.right); //it gives leftmost node
                //from right subtree and uski value ko de dega iss node ki place pr jiske
                //left aur right dono he child h 
                root.data=inorderSuccessorNode.data;
                root.right=delete(root.right,inorderSuccessorNode.data);
            }
            
        }
        return root;
        
    }
    public static Node inorderSuccessor(Node root){
            while(root.left!=null){
                root=root.left;
            }
            return root;
    }

    public static Node printRange(Node root,int k1,int k2){
        if(root==null){
            return null;
        }
        if(root.data>=k1 && root.data<=k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printRange(root.right, k1, k2);
        }
        else if(root.data>k2){
            printRange(root.left, k1, k2);
        }
        else{
            printRange(root.right, k1, k2);
        }
        return root;
    }
    public static void rootToLeaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        rootToLeaf(root.left,path);
        rootToLeaf(root.right,path);
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static boolean isvalidBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        //koe bhi node subtree mai root ko max left mai aur min right m manke chalegi apne
        if((min!=null && min.data>=root.data) ||(max!=null && max.data<=root.data)){
            return false;
        }
        return isvalidBST(root.left, min, root) && isvalidBST(root.right, root, max);
    }

    public static Node MirrorBST(Node root){
        if(root==null){
            return null;
        }
        Node leftInverted=MirrorBST(root.left);
        Node rightInverted=MirrorBST(root.right);

        root.right=leftInverted;
        root.left=rightInverted;
        return root;
    }
    public static void main(){
        /*
        TC:O(h) his height of the tree
        search is easy in BST compared to binary tree

        What is a BST?

        *Binary Tree
        a. Left Subtree Nodes < Root

        b. Right Subtree Nodes > Root

        c. Left & Right Subtrees are also
        BST with no duplicates


        Special Property

        Inorder Traversal of BST gives a
        sorted sequence 


        //for searching in BST:
        worst case TC: O(n) for skewed trees(left or right)
        avg case: TC:O(log n)


        Strategy

        Most problems will be solved using recursion i.e. by
        dividing into subproblems & making recursive calls
        on subtrees.        
        */

        // int arr[]={2,5,8,1,4,3,7,0,6,9};
        // Node root=null;
        // for(int i=0;i<arr.length;i++){
        //     root=buildBST(root,arr[i]);
        // }
        
        // inorder(root);

        //search in BST:
        // System.out.println(search(root,60));


        //delete a node : Adobe asked //isko proper teeno cases k liye dry run krke dekhlo
        // inorder(root);
        // Node newRoot=delete(root,7);
        // System.out.println();
        // inorder(newRoot);
        // System.out.println();
        // newRoot=delete(newRoot,5);
        // inorder(newRoot);

        //print in range
        // printRange(root,2,5);


        //root to leaf
        // ArrayList<Integer> path=new ArrayList<>();
        // rootToLeaf(root,path);


        //valid BST: amazon,snapdeal
        //check if max value in left subtree < node
        // and min value in right subtree > node    
        int arr[]={2,3,6,9,7};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=buildBST(root,arr[i]);
        }    
        // System.out.println(isvalidBST(root,null,null));//root node k liye left,right null

        //mirror a BST
        inorder(root);
        System.out.println();
        MirrorBST(root);
        inorder(root);

        
    }
}
