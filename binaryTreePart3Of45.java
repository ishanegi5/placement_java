import java.util.*;
class Tree{
    int val;
    Tree left;
    Tree right;
    Tree(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
public class binaryTreePart3Of45 {
    public static void kThLevelIterative(Tree root,int k){
        if(root==null){
            return;
        }
        Queue<Tree> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int level=1; //level counter
        while(!q.isEmpty()){
            Tree curr=q.remove();
            if(curr==null){
                level+=1;
                if(q.isEmpty() ){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(level==k){
                    System.out.print(curr.val+" ");
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static void KThLevelRecurssive(Tree root,int level,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.val+" ");
            return;
        }
        KThLevelRecurssive(root.left, level+1, k); //ek level tree mai nichey jana mtlab +1
        KThLevelRecurssive(root.right, level+1, k); //ek leveltree mai nichey jana matlab +1 same
    }

    public static int lca(Tree root,int n1,int n2){
        ArrayList<Integer> l1=new ArrayList<>();
        ArrayList<Integer> l2=new ArrayList<>();

        getPath(l1,root,n1);
        getPath(l2,root,n2);
        for(int i=0;i<l1.size();i++){
            System.out.print(l1.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<l1.size();i++){
            System.out.print(l2.get(i)+" ");
        }
        int ind=0;
        for(int i=l1.size()-1;i>=0;i++){
            if(l1.get(i)==l2.get(i)){
                ind=i;
                break;
            }
        }
        return ind;
    }

    public static boolean getPath(ArrayList<Integer> lst,Tree root,int n){
        if(root==null){
            return false;
        }
        lst.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==n){
                return true;
            }
        }
        boolean lft=getPath(lst, root.left, n);
        boolean rgt=getPath(lst, root.right, n);
        lst.remove(lst.size()-1);
        return lft||rgt;
    }
    public static void main(){
        //kth level of a tree
        /*
        1) iterative way se krenge 
        2)recursively krenge
        */

        Tree root=new Tree(1);
        root.left=new Tree(2);
        root.right=new Tree(3);
        root.left.left=new Tree(4);
        root.left.right=new Tree(5);
        root.right.left=new Tree(6);
        root.right.right=new Tree(7);

        //iterative method:
        // kThLevelIterative(root,3); //TC: O(n)

        // KThLevelRecurssive(root,1,3);


        //lowest common ancestor
        System.out.println(lca(root,4,5));
    }
}
