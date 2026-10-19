import java.util.*;
public class GreedyAlgorithm43 {
    public static int activitySelection(int []start,int []end,ArrayList<Integer>ans){
        int lastTime=end[0];
        ans.add(0);
        int count=1; // kyuki first activity always selected he hogi
        for(int i=1;i<end.length;i++){
            if(start[i]>lastTime){
                count++;
                ans.add(i);
                lastTime=end[i];
            }
        }
        return count;
    }
    public static int activitySelectionWithoutSortedEndArray(int []start,int [] end,ArrayList<Integer>ans){
        int activities[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        Arrays.sort(activities,Comparator.comparingDouble(o-> o[2]));//objects compare krne k liye
        ans.add(activities[0][0]);
        int lastActivity=activities[0][2];
        int count=1; //first activity counted he h 
        for(int i=0;i<start.length;i++){
            if(lastActivity<activities[i][1]){
                ans.add(activities[i][0]);
                lastActivity=activities[i][2];
                count++;
            }
        }
        return count;
    }
    public static int fractionalKnapsack(int []weight,int []value,int capacity){
        double ratio[][]=new double[value.length][2];
        /*
        value jitni jyada hogi utna acha h aur weight jitna km hoga acha h tb ratio jyada ayega
        */
        for(int i=0;i<value.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1])); //ascending order milega
        int knapsackCapacity=capacity; 
        int finalValue=0;
        for(int i=ratio.length-1;i>=0;i--){
            int index=(int)ratio[i][0];
            if(weight[index]<=knapsackCapacity){
                knapsackCapacity-=weight[index]; //occupied space
                finalValue+=value[index]; //value for occupied space
            }
            else{
                finalValue+=knapsackCapacity*ratio[i][1]; //kitna value hoga ager fraction he le tb
                knapsackCapacity=0; //last h sub space full ho gaya toh end krenge loop
                break;
            }
        }
        return finalValue;
    }
    public static int minAbsDiff(int []A,int []B){
        Arrays.sort(A);
        Arrays.sort(B);
        int ans=0;
        for(int i=0;i<A.length;i++){
            ans+=Math.abs(A[i]-B[i]);
        }
        return ans;
    }
    public static int maxLenChainOfPairs(int [][]pairs){
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        int chainEnd=pairs[0][1];
        int chainLen=1;
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>=chainEnd){
                chainEnd=pairs[i][1];
                chainLen++;
            }
        }
        return chainLen;
    }
    public static int indianCoin(int []coins,int money,ArrayList<Integer> used){
        Arrays.sort(coins);
        int ans=0;        
        for(int i=coins.length-1;i>=0;i--){
            if(coins[i]<=money){
                while(coins[i]<=money){
                    money-=coins[i];
                    ans++;
                    used.add(coins[i]);
                }
                
            }
        }
        return ans;
    }
    static class Job{
        int id;
        int deadline;
        int profit;
        public Job(int i,int d,int p){
            this.id=i;
            this.deadline=d;
            this.profit=p;
        }

    }
    public static int jobSequencing(int [][]jobsInfo,ArrayList<Integer> ans){
        ArrayList<Job> jobs=new ArrayList<>();
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit); //descending ka code line
        int time=0;
        
        int count=0;
        for(int i=0;i<jobs.size();i++){
            if(time<jobs.get(i).deadline){
                time++; //kyuki question mai bola tha It is also given that every
                //  job takes a single unit of time
                ans.add(jobs.get(i).id);
                count++;
            }
        }
        return count;
    }
    public static int chocolaProblem(Integer []costHor,Integer []costVer){
        //max cost wale cuts pehele laga lenge jub min pieces ho bs taki final cost min aye bs
        Arrays.sort(costHor,Collections.reverseOrder());
        Arrays.sort(costVer,Collections.reverseOrder());
        int h=0;//costHor ka pointer index mai
        int v=0;//costVer ka pointer index
        int hp=1; //horizontal piece
        int vp=1;// vertical piece
        int finalCost=0;
        while(h<costHor.length && v<costVer.length){
            if(costHor[h]>costVer[v]){
                finalCost+=(costHor[h]*vp); //jitne vertical pieces honge subme costHor lagegi
                hp++; //cut horizontal h toh pieces bhi horizontal he badhayega
                h++; //pointer aage badhega horizontal cost ka
            }
            else{
                finalCost+=(costVer[v]*hp); //jitne horizontal pieces honge subme costVer lagegi
                vp++;//cut vertical h toh pieces bhi vertical he badhayega
                v++;//pointer aage badhega vertical cost ka
            }
        }
        //remaining horizontal costs niptane k liye 
        while(h<costHor.length){
            finalCost+=(costHor[h]*vp);
            h++;
            hp++;
        }
        //remaining vertical costs niptane k liye 
        while(v<costVer.length){
            finalCost+=(costVer[v]*hp);
            v++;
            vp++;
        }
        return finalCost;
    }
    public static void main(){
        //greedy approach
        //local optimal search krte krte globally optimal dhundhte h isme
        /*
        Pros:
        Simple & Easy
        Good enough TC

        Cons:
        A lot of time, global
        optimum is not achieved       
        
        */

        //activity selection: flipkart and others asked..
        //disjoint set,maximum meetings in a room sub mai yehi logic use hota h jo isme hoga abhi..
        // You are given n activities with their start and end times. 
        // Select the maximum number of activities
        // that can be performed by a single person, assuming that a person can only work on 
        // a single activity at a time. "Activities are sorted according to end time".

        // int start[] = {1, 3, 0, 5, 8, 5};
        // int end[] = {2, 4, 6, 7, 9, 9};
        // ArrayList<Integer> arr=new ArrayList<>();
        // System.out.println(activitySelection(start,end,arr));
        // for(int i=0;i<arr.size();i++){
        //     System.out.print("A"+arr.get(i)+" ");
        // }

        //in java comparator is an interface for sorting objects
        //lambda function kisi function ko short mai likha toh wo lambda function hua
        //ab inn baaton ka hum use krenge ager activity selection mai hume sorted na 
        //diya ko end array k basis pr question:

        // int start[] = {1, 3, 0, 5, 8, 5};
        // int end[] = {2, 4, 6, 7, 9, 9};
        // ArrayList<Integer> ans=new ArrayList<>();
        // System.out.println(activitySelectionWithoutSortedEndArray(start,end,ans));
        // for(int i=0;i<ans.size();i++){
        //     System.out.print("A"+ans.get(i)+" ");
        // }


        //Fractional knapsack
        // int weight[]={10,20,30};
        // int value[]={60,100,120};
        // int knapsackCapacity=50;
        // System.out.println(fractionalKnapsack(weight,value,knapsackCapacity));


        //minimum absoulte difference pairs //TC: O(nlog(n))
        // int A[] = {4,1,8,7};
        // int B[] = {2,3,6,5};
        // System.out.println(minAbsDiff(A,B)); //isme jawab isse km kabhi ni ayega 
        // baraber aur jyada aa skta bs


        //maximum length chain of pairs
        // int pairs [][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        // System.out.println(maxLenChainOfPairs(pairs));


        /*
        Note: sorting ager apply kr re hote h toh wo greedy algo hoti h
        */


        //indian coin-canonical system-jo greedy se solvable ho bs usse bolte
        // int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        // int money=1059;
        // ArrayList<Integer> used=new ArrayList<>();
        // System.out.println(indianCoin(coins,money,used));
        // System.out.println(used);


        /*
        Job Sequencing Problem

        Given an array of jobs where every job has a deadline and profit if the job is finished
        before the deadline. It is also given that every job takes a single unit of time, so the
        minimum possible deadline for any job is 1. Maximize the total profit if only one job can
        be scheduled at a time.        
        */

    //    int jobsInfo[][] ={{4, 20}, {1, 10}, {1, 40}, {1, 30}};
    //    ArrayList<Integer> ans=new ArrayList<>();
    //    System.out.println(jobSequencing(jobsInfo,ans));
    //    System.out.println(ans);//yeh job numbers dega jo max profit di hume 


    //chocola problem- microsoft,google,amazon asked this(hard level)
    //minimum cost to cut boards into squares bhi bolte isse
        // int n = 4, m =16;
        // Integer costVer[] = {2, 1, 3, 1, 4}; //m-1
        // Integer costHor[] = {4, 1, 2}; //n-1
        // System.out.println(chocolaProblem(costHor,costVer));


        /*
        A Comparator in Java is an interface that is used to order the objects of
        user-defined classes. A comparator object is capable of comparing two
        objects of the same class.
        Let’s take an example of a function that compares obj1 with obj2 :
        public int compare(Object obj1, Object obj2):
        There are 2 ways of implementing this sort method -
        a. We write a custom function on our own, where we define the sorting
        logic from scratch.
        b. Using the Comparator interface. (Better!)
        

        iske baare mai mai apko material se bataungi jo maine apne lecture ki pdf se padha
        sathme fir se apko bhi batati hu
        */

    }
}
