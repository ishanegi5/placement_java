import java.util.*;

public class BinaryTrees44 {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTreeClass{
        static int index=-1;
        static Node PreOrder(int []node){
            index++;
            if(node[index]==-1){
                return null;
            }
            Node newNode=new Node(node[index]);
            newNode.left=PreOrder(node);
            newNode.right=PreOrder(node);
            return newNode;
        }
        static void preOrderPrint(Node root){
            if(root==null){
                // System.out.print("-1 "); --> yeh tb likhna ager same sub print krwana h toh
                //input ki terha 
                return;
            }
            System.out.print(root.data+" ");
            preOrderPrint(root.left);
            preOrderPrint(root.right);            
        }

        static void inOrderPrint(Node root){
            if(root==null){
                return;
            }
            inOrderPrint(root.left);
            System.out.print(root.data+" ");
            inOrderPrint(root.right);
        }

        static void postOrderPrint(Node root){
            if(root==null){
                return;
            }
            postOrderPrint(root.left);
            postOrderPrint(root.right);
            System.out.print(root.data+" ");
        }

        static void levelOrderTraversal(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }

                }
            }
        }

        static int heightOfTree(Node root){
            if(root==null){
                return 0;
            }
            int left=heightOfTree(root.left);
            int right=heightOfTree(root.right);
            int height=Integer.max(left,right)+1;
            return height;
        }
        static int totalNodes=0;
        static int countNodes(Node root){
            if(root==null){
                return 0;
            }
            int left=countNodes(root.left);
            int right=countNodes(root.right);
            totalNodes=left+right+1; //iska dry run one note pr batati hu
            return totalNodes;
        }

        static int sumOfNodes(Node root){
            if(root==null){
                return 0;
            }
            int left=sumOfNodes(root.left);
            int right=sumOfNodes(root.right);
            return left+right+root.data;
        }
    }

    
    public static void main(){
        //trees ko hum binary tree ko padhenge khud he samjh jayenge
        /*
        binary tree ek hierarchichal data structure h
        like family tree google image se batati 
        so iss type ki info ko save krne k liye we use tree data structure 

        ab mai apko:
        1)root node
        2)branch
        3)leaf node smjhati hu

        binary tree: jisme at max 2 he children ho bs 2 se km ho skte h but jyada ni
        
        level hota h ek jiska mtlab h root node ko level 1 kehete h uske neechey 1 uske neechey 2
        and so on..

        har node ka apna ek left aur right sub tree hota h

        leaf node ka khudka subtree null hota h mai apko one note mai batati hu


        ab yeh batao one note pr:
        a. Children of 4:
        b. No. of Leaves : 
        c. Parent of 6 :
        d. Level of 2 :
        e. Subtrees of 1 & 2 :
        f. Ancestors of 8 :


        Build Tree Preorder: -> one note pr bata dungi isme root left then right jaate h
        1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1
        */

        //now brild tree using preorder sequence:
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTreeClass btc=new BinaryTreeClass();
        Node root=btc.PreOrder(node);
        System.out.println(root.data); //TC: O(n)

        //printing the preorder 
        btc.preOrderPrint(root); //sub nodes pr ek he baar gye h toh time complexity O(n)


        //inorder : left root right
        //one note pr batati hu
        System.out.println();
        btc.inOrderPrint(root);


        //post order : left right root 
        System.out.println();
        btc.postOrderPrint(root);

        //level order traversal
        System.out.println();
        btc.levelOrderTraversal(root);


        //height of a tree
        /*
        height ko: 1) node k hisab se
                   2) edge k hisab se
                   ho skta h 
                   one note pr batati hu

                   edge k liye= node wala k according-1
                   
        */
       System.out.println(btc.heightOfTree(root));

        //count of a tree nodes
        System.out.println(btc.countNodes(root));


        //sum of nodes
        System.out.println(btc.sumOfNodes(root));

        //note: yaha subka SC: inorder ,post,preorder subka O(H) hai -> call stack kitna bharega 
        //max height k jitna (yahi height of a tree jitna)

    }
}
