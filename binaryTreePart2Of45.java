import java.util.*;

public class binaryTreePart2Of45 {
    static class BinaryTreeNode{
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    static int Diameter(BinaryTreeNode root){ //TC: O(n^2) kyuki her n node pr jaake uski 
    // height calculate krne mai time lagega n
        if(root==null){
            return 0;
        }
        int leftDiameter=Diameter(root.left);
        int leftHeight=height(root.left);
        int rightDiameter=Diameter(root.right);
        int rightHeight=height(root.right);
        int selfDiameter=leftHeight+rightHeight+1;
        return Math.max(selfDiameter,Math.max(leftDiameter,rightDiameter));
    }
    static int height(BinaryTreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        int finalHeight=Math.max(left,right)+1;
        return finalHeight;
    }

    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }

    public static Info diameter2(BinaryTreeNode root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo=diameter2(root.left);
        Info rightInfo=diameter2(root.right);
        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),1+leftInfo.ht+rightInfo.ht);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diam,ht);
    }

    static boolean subtreeOfAnotherTree(BinaryTreeNode root,BinaryTreeNode sTRoot){
        if(root==null){
            return false;
        }
        
        if(root.val==sTRoot.val){
            if(isIdentical(root,sTRoot)){
                return true;
            }
        }
        return subtreeOfAnotherTree(root.left, sTRoot) || subtreeOfAnotherTree(root.right, sTRoot);
        //Note: yeh ager left statement true dedegi toh turant return hoga true kyuki || use hora h
    }

    public static boolean isIdentical(BinaryTreeNode root,BinaryTreeNode sTRoot){
        if(sTRoot==null && root==null){
            return true;
        }
        if((root==null && sTRoot!=null) || (root!=null && sTRoot==null) || root.val!=sTRoot.val){
            return false;
        }
        boolean lft=isIdentical(root.left, sTRoot.left);
        boolean rgt=isIdentical(root.right, sTRoot.right);
        return lft&&rgt;
    }

    public static void topView(BinaryTreeNode root){
        Queue<InfoTopView> q=new LinkedList<>();
        HashMap<Integer,BinaryTreeNode> map=new HashMap<>();
        int min=0;
        int max=0;  
        q.add(new InfoTopView(root,0));
        q.add(null);
        while(!q.isEmpty()){
            InfoTopView curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.horizontalDistance)){
                    map.put(curr.horizontalDistance,curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new InfoTopView(curr.node.left,curr.horizontalDistance-1));
                    min=Math.min(min,curr.horizontalDistance-1);
                }
                if(curr.node.right!=null){
                    q.add(new InfoTopView(curr.node.right, curr.horizontalDistance+1));
                    max=Math.max(max,curr.horizontalDistance+1);
                }
            }
        }      
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).val+" ");
        }
    }

    static class InfoTopView{
        BinaryTreeNode node;
        int horizontalDistance;
        public InfoTopView(BinaryTreeNode node,int hd){
            this.node=node;
            this.horizontalDistance=hd;
        }
    } 
    
    public static void main(){
        /*
        diameter of a tree: no of nodes in the longest distance between 2 leaf nodes
        one note pr babati hu:
        ya toh left sub tree mai hogi diameter ya toh right sub tree mai ya fir wo root
        node se jayegi 

               1
              / \
             2   3
            /\   /\
           4  5  6 7  

           ab iski height batao :
           5 ayega answer 4,2,1,3,7 ya 5,2,1,3,7
        
        */
        BinaryTreeNode root=new BinaryTreeNode(1);
        root.left=new BinaryTreeNode(2);
        root.left.left=new BinaryTreeNode(4);
        root.left.right=new BinaryTreeNode(5);
        root.right=new BinaryTreeNode(3);
        root.right.left=new BinaryTreeNode(6);
        root.right.right=new BinaryTreeNode(7);
        // root.left.left.left=new BinaryTreeNode(8); //isse subtree of another k liye use krna
        // System.out.println(Diameter(root)); //TC: O(n^2)

        //now TC: O(n) approch:
        // System.out.println(diameter2(root).diam);
        

        /*
        Subtree of another Tree:
        Given the roots of two binary trees root and subRoot, return true if there 
        is a subtree of root
        with the same structure and node values of subRoot and false otherwise.

        isme non identical kb hota h:
        1)ager subtree mai jo data h kisi node pr wo main tree k data k not equal ho
        2)subtree mai null ho node but dusre full tree mai uss node pr value ho or vice versa
        3)main tree he pura non-identical ho 
        4)subtree he pura non-identical ho
        */

        BinaryTreeNode subtreeRoot=new BinaryTreeNode(2);
        subtreeRoot.left=new BinaryTreeNode(4);
        subtreeRoot.right=new BinaryTreeNode(5); //ager isse hataungi toh false ayega
        // subtreeRoot.left.left=new BinaryTreeNode(8); //isko lagake dekhna root m null aur yaha 8

        // System.out.println(subtreeOfAnotherTree(root,subtreeRoot));

        topView(root); //BFS(level order traversal use krta h and jo nodes top se dikh skte)
        //wo answer mai aate h nodes ka data answer hota h wohi mtlab

        //iske liye hum bottom view bhi krenge khud
    }
}
