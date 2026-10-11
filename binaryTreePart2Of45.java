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
        int selfHeight=leftHeight+rightHeight+1;
        return Math.max(selfHeight,Math.max(leftHeight,rightHeight));
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
        System.out.println(Diameter(root));

    }
}
