// import java.util.*; -> sub lajao h * ka matlab yaha jaise ki class bhi interfaces bhi aur sub he cheeze mtlab
import java.util.ArrayList; //isse bs ArrayList class ki he cheeze aati h
import java.util.Collections;
public class ArrayList37{

     public static void swapInList(ArrayList<Integer> list1,int ind1,int ind2){
          int temp=list1.get(ind1);
          list1.set(ind1,list1.get(ind2));
          list1.set(ind2,temp);
          System.out.println(list1);
     }

     public static void bruteForceTrappedWater(ArrayList<Integer> height){
          int minHeight;
          int maxWater=0;
          for(int i=0;i<height.size()-1;i++){
               for(int j=+1;j<height.size();j++){
                    //min height
                    minHeight=Integer.min(height.get(i),height.get(j));
                    int width=j-i;
                    int water=minHeight*width;
                    maxWater=Integer.max(maxWater,water);
               }          
          }
          System.out.println(maxWater);
     }


     public static void optimalApproachTrappedWater(ArrayList<Integer> height){
          int maxWater=0;
          int lp=0;
          int rp=height.size()-1;
          while(lp<rp){
               int h=Integer.min(height.get(lp),height.get(rp));
               int width=rp-lp;
               int water=h*width;
               maxWater=Integer.max(maxWater,water);
               if(height.get(lp)<height.get(rp)){
                    lp++;
               }
               else{
                    rp--;
               }
          }
          System.out.println(maxWater);
     }


     public static boolean bruteForcePairSum(ArrayList<Integer> list,int target){
          for(int i=0;i<list.size();i++){
               for(int j=i+1;j<list.size();j++){
                    if(list.get(i)+list.get(j)==target){
                         return true;
                    }
               }
          }
          return false;
     }


     public static boolean twoPointerPairSumApproch(ArrayList<Integer> list,int target){
          int i=0;
          int j=list.size()-1;
          while(i<j){
               if(list.get(i)+list.get(j)==target){
                    return true;
               }
               if(list.get(i)+list.get(j)<target){
                    i++;
               }
               else{
                    j--;
               }
          }
          return false;
     }


     public static boolean rotatedSortedPairSum(ArrayList<Integer> list,int target){
          int breakingPoint=0;
          for(int i=0;i<list.size()-1;i++){
               if(list.get(i)>list.get(i+1)){
                    breakingPoint=i;
               }
          }
          int lp=breakingPoint+1;
          int rp=breakingPoint;
          while(lp>rp){
               if(list.get(lp)+list.get(rp)==target){
                    return true;
               }
               if(list.get(lp)+list.get(rp)>target){
                    rp=(list.size()-rp-1)%list.size();
               }
               else{
                    lp=(lp+1)%list.size();
               }
          }
          return false;
     }
    public static void main(){
        //array list is in-built data structure and data is stored in linear fashion in it
        /*
             Array                    ArrayList

          1) fixed size            1)dynamic size

        2)primitive data types      2)primitive data types
           can be stored               can't be stored directly

        

        array list is a part of java collection framework-> will study ki yeh kya hota h?     
        */
       ArrayList<Integer> list1=new ArrayList<>(); 
       ArrayList<String> list2=new ArrayList<>();
       ArrayList<Boolean> list3=new ArrayList<>();
       //note: Integer,Float,Boolean,String sub classes hoti h primitive data types nahi 

       //operations:
       //1)add
       list1.add(1); //TC:O(1)
       list1.add(2);
       list1.add(3);
     //   System.out.println(list1);
     //   //iska ek aur tarik h kisi particular index pr element dalna
     //   list1.add(1,100); //TC:O(n)
     //   System.out.println(list1);

     //   //2) get a value at some index
     //   int val=list1.get(1);    //TC:O(1)
     //   System.out.println(val);

     //   //3)delete element at some index 
     //   list1.remove(1); //TC: O(n)-> traverse krke dhundta h kyuki fir resizing bhi hoti h isliye 
     //   System.out.println(list1);

     //   //4) set krna koe value change krke
     //   list1.set(1,5); //TC:O(n)
     //   System.out.println(list1);

     //   //5)contains element
     //   System.out.println(list1.contains(9));

     //   //size() -> method hai like length -> ek property hoti thi array m 
     //   System.out.println(list1.size());
     //   for(int i=0;i<list1.size();i++){
     //        System.out.print(list1.get(i)+" ");
     //   }
     //   System.out.println();

     //   //reverse:
     //   for(int i=list1.size()-1;i>=0;i--){
     //        System.out.print(list1.get(i)+" ");
     //   }

     //   //max element
     //   int max=Integer.MIN_VALUE;
     //   for(int i=0;i<list1.size();i++){
     //        // if(max<list1.get(i)){
     //        //     max=list1.get(i);
     //        // }
     //        max=Math.max(max,list1.get(i));
     //   }
     //   System.out.println("Max "+max);

     //swap
     // int ind1=0; 
     // int ind2=2;
     // swapInList(list1,ind1,ind2);

     //sort()
     list1.add(7);
     list1.add(4);
     // System.out.println(list1);
     // Collections.sort(list1); //iske like subse uper we write import java.util.Collections; ya simply-> import java.util.*;
     // System.out.println(list1);

     // reverse
     // Collections.sort(list1,Collections.reverseOrder()); //yaha Collections.reverseOrder()-> comparator h jo objects ko bhi sort
     //krdeta h -> detail m future m smjhenge iss baat ko leave it for now
     // System.out.println(list1);


     /*
     ArrayList implementation: fixed size array se start hota h fir jub (like logic kuch bhi ho skta h like:half filled
      ya full filled hone pr kuch krne ka array ka: like: double krne ka size ko ya 0.5 badhane ka ya 3X krne ka ya 0.2 
      badhane ka kuch bhi ho skta) ->one note pr batadungi ager jarurat lge
      */


      //multidimensional ArrayList
     //  ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
     //  ArrayList<Integer> listA=new ArrayList<>();
     //  listA.add(1);
     //  listA.add(2);
     //  mainList.add(listA);
     //  ArrayList<Integer> listB=new ArrayList<>();
     //  listB.add(3);
     //  listB.add(4);
     //  mainList.add(listB);
     //  System.out.println(mainList);

      //loop
     //  for(int i=0;i<mainList.size();i++){
     //      ArrayList<Integer> a=mainList.get(i);
     //      for(int j=0;j<a.size();j++){
     //           System.out.print(a.get(j)+" ");
     //      }
     //      System.out.println();
     //  }

      //Note mainList k ander index 0 and 1 pr listA and ListB ka reference stored h bs puri list ni toh uss reference pr jaake
      //tb uske ander ki list k elements ko print kr ra h
      //remember ki: jo listA and listB hai unka size same hona jaruri ni h ek ka 5 ek ka 3 ho skta h aur dono mainList k ander 
      //store ho skte



     //trapped water:
     ArrayList<Integer> height=new ArrayList<>();
     height.add(1);
     height.add(8);
     height.add(6);
     height.add(2);
     height.add(5);
     height.add(4);
     height.add(8);
     height.add(3);
     height.add(7);
     // bruteForceTrappedWater(height); //TC: O(n^2)

     //optimal approach:
     // optimalApproachTrappedWater(height); //TC: O(n) //two pointer approch

     //difference beteween trapped rainwater and container with most water-> in one note 
     

     //1 pair sum
     ArrayList<Integer> pairSumList=new ArrayList<>();
     pairSumList.add(1);
     pairSumList.add(2);
     pairSumList.add(3);
     pairSumList.add(4);
     pairSumList.add(5);

     // System.out.println(bruteForcePairSum(pairSumList,5)); 

     // System.out.println(twoPointerPairSumApproch(pairSumList,5));

     //rotated sorted array mai pair sum check krna:
     System.out.println(rotatedSortedPairSum(pairSumList,5)); //TC: O(n)

     //iske practice question sathme krenge maine nahi kiye abhi tk
     
    }
}