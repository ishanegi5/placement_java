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
        ArrayList<List<Integer>> result1=new ArrayList<>();
        ArrayList<List<Integer>> result2=new ArrayList<>();
        result1=getPath(l1,result1,root,n1);//sirf leaf node pr nahi kahi bhi h target store hoga
        result2=getPath(l2,result2,root,n2);//sirf leaf node pr nahi kahi bhi h target store hoga
        if(result1.isEmpty() || result2.isEmpty()){
            return -1;
        }
        for(int i=0;i<result1.get(0).size();i++){
            System.out.print(result1.get(0).get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<result2.get(0).size();i++){
            System.out.print(result2.get(0).get(i)+" ");
        }
        System.out.println();
        int result=0;
        
        int minimumSize=Math.min(result1.get(0).size(),result2.get(0).size());
        for(int i=0;i<minimumSize;i++){
            if(result1.get(0).get(i)==result2.get(0).get(i)){
                result=result1.get(0).get(i);
            }
        }
        return result;
    }

    public static ArrayList<List<Integer>> getPath(ArrayList<Integer> lst,ArrayList<List<Integer>> result,Tree root,int n){
        if(root==null){
            return result;
        }
        lst.add(root.val);
        if(root.val==n){
            result.add(new ArrayList<>(lst));
            lst.remove(lst.size()-1);
            return result;
        }
        
        getPath(lst,result, root.left, n);
        getPath(lst,result, root.right, n);
        lst.remove(lst.size()-1);
        return result;
    }

    public static Tree lca2(Tree root,int n1,int n2){
        ArrayList<Integer> path1=new ArrayList<>();
        ArrayList<Integer> path2=new ArrayList<>();
        getPath2(root,path1,n1);
        getPath2(root,path2,n2);
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Tree lca2=new Tree(path1.get(i-1));
        return lca2;
    }

    public static boolean getPath2(Tree root,ArrayList<Integer> path,int n){
        if(root==null){
            return false;
        }
        path.add(root.val);
        if(root.val==n){
            return true;
        }
        boolean lft=getPath2(root.left,path,n);
        boolean rgt=getPath2(root.right,path,n);
        if(lft||rgt){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Tree lca3(Tree root,int n1,int n2){
        if(root==null || root.val==n1 || root.val==n2){
            return root;
        }
        Tree lftLca=lca3(root.left, n1, n2);
        Tree rgtLca=lca3(root.right,n1,n2);
        if(rgtLca==null){
            return lftLca;
        }
        else if(lftLca==null){
            return rgtLca;
        }
        return root; // if both are null wale case k liye 
    }

    public static int minPossibleDist(Tree root,int n1,int n2){
        Tree lca=lca3(root,n1,n2);
        int lftDist=DistFromLca(lca,n1);
        int rgtDist=DistFromLca(lca,n2);
        return lftDist+rgtDist;
    }

    public static int DistFromLca(Tree lca,int target){
        if(lca==null){
            return -1;
        }
        if(lca.val==target){
            return 0;
        }
        int lft=DistFromLca(lca.left, target);
        int rgt=DistFromLca(lca.right, target);
        if(lft==-1 && rgt==-1){
            return -1;
        }
        if(lft==-1){
            return rgt+1;
        }
        else{
            return lft+1;
        }
        
                
    }


    public static int kThAncestor(Tree root,int target,int kth){
        if(root==null){
            return -1;
        }
        if(root.val==target){
            return 0;
        }
        int lft=kThAncestor(root.left, target, kth);
        int rgt=kThAncestor(root.right, target, kth);
        if(lft==-1 && rgt==-1){
            return -1;
        }
        int maximum=Math.max(lft,rgt);
        if(maximum+1==kth){
            System.out.println(root.val);
        }
        return maximum+1;
    }

    public static int transformToSumTree(Tree root){
        if(root==null){
            return 0;
        }
        int lft=transformToSumTree(root.left);
        int rgt=transformToSumTree(root.right);   
        int data=root.val;
        int newleft=(root.left==null)?0:root.left.val;
        int newright=(root.right==null)?0:root.right.val;
        root.val=newleft+lft+rgt+newright;
        return data;
    }
    
    public static void preorderTraversal(Tree root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preorderTraversal(root.left);        
        preorderTraversal(root.right);
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
        // System.out.println();
        //my method 2D arraylist use krke 
        // System.out.println("Lowest common ancestor is: "+lca(root,4,5));

        //Teacher method:
        // System.out.println("Lowest common ancestor: "+lca2(root,6,7).val);//TC: O(n), SC:O(n)


        //approach 3 for lca:
        // System.out.println(lca3(root,7,6).val); //TC:O(n), SC: O(1)

        //minimum possible distance between nodes:
        // System.out.println(minPossibleDist(root,6,7));

        //kth ancestor
        // kThAncestor(root,6,1); // node jisme 6 value k uska 2nd ancestor return krega

        //transform To sum tree
        transformToSumTree(root);
        preorderTraversal(root);
    }
}
