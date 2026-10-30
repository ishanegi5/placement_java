import java.util.*;
public class hashing48 {
  public static int MaxInArr(int arr[],HashMap<Integer,Integer> hm){
      for(int i=0;i<arr.length;i++){
          // if(hm.containsKey(arr[i])){
          //     hm.put(arr[i],hm.get(arr[i])+1);
          // }
          // else{
          //   hm.put(arr[i],1);
          // }
          hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
      }
      // Set <Integer> keys=hm.keySet();  //no need to store keys in a set
      for(int k:/*keys */ hm.keySet()){ 
        if(hm.get(k)>arr.length/3){
          return k;
        }
      }
      return -1;
  }
    public static boolean Anagram(String a,String b,HashMap<Character,Integer>hm){
      for(int i=0;i<a.length();i++){
        hm.put(a.charAt(i),hm.getOrDefault(a.charAt(i),0)+1);
      }
      for(int j=0;j<b.length();j++){
        if(hm.get(b.charAt(j))!=null){
          if(hm.get(b.charAt(j))==1){
            hm.remove(b.charAt(j));
          }
          else{
            hm.put(b.charAt(j),hm.getOrDefault(b.charAt(j),0)-1);
          }
        }
        else{
          return false;
        }
      }
      return hm.isEmpty();
    }
    public static int countDistinctElements(int []num,HashSet<Integer>set){
      for(int i=0;i<num.length;i++){
        set.add(num[i]);
      }
      return set.size();
    }

    public static int largestSubarray(int []arr){
      HashMap<Integer,Integer>map=new HashMap<>();
      int sum=0;
      int len=0;
      for(int i=0;i<arr.length;i++){
        sum+=arr[i];
        if(map.containsKey(sum)){
          len=Integer.max(len,i-map.get(sum));
          
        }
        else{
          map.put(sum,i);
        }
      }
      return len;
    }

    public static int subarrayEqualToK(int []arr,int k){
      int sum=0;
      int ans=0;
      HashMap<Integer,Integer>map=new HashMap<>();
      map.put(0,1); //yeh isliye likhna padhega kyuki jub sum==k hoga tb sum-k k liye 
      // ans mai +1 hona chahiye
      for(int i=0;i<arr.length;i++){
        sum+=arr[i];
        if(map.containsKey(sum-k)){
          ans+=map.get(sum-k);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
      }
      return ans;

    }
    public static void main(){
        /*
        hashing: isse hum kisi cheez ko hide krte h like isha: d5!^ asa kuch bnn jana
                 isse hum 2 data structures bana skte h:
                                        1)Map:
                                               1)HashMap
                                               2)LinkedHashMap
                                               3)TreeMap 
                                        2)Set:
                                                1)HashSet
                                                2)LinkedHashSet
                                                3)TreeSet        
        */
       //1)HashMap:
       /*isko table k form m bhi imagine kr skte h and nodes k form m bhi
       isme (key,value) pair hota h 
       key unique hoti h 
       value same bhi ho skti h different bhi
       TC:O(1) for insert,remove and search

       import kr lenge hashmap ko

       */
      //create
      // HashMap <String,Integer>hm=new HashMap<>();

      // //insertion
      // hm.put("Isha",21);
      // hm.put("Tanu",23);
      // hm.put("Ram",45);
    //   System.out.println(hm); //bs itna run kro tb dekho unordered hote h yeh 

      //get operation
    //   System.out.println(hm.get("Isha"));
    //   System.out.println(hm.get("sita")); //yeh null dega  kyuki key exist nhi krti

      //containKey()-> return boolean
    //   System.out.println(hm.containsKey("Isha")); //true
    //   System.out.println(hm.containsKey("sita")); //false

      //remove: ager value exists then return hogi wo otherwise null returns
    //   System.out.println(hm.remove("Isha")); //21
    //   System.out.println(hm.remove("sita")); //null

      //size: it counts keys only
    //   System.out.println(hm.size()); //2 

      //isEmpty(): boolean 
    //   System.out.println(hm.isEmpty());

      //clear(): sub delete ho jayega isse
    //   hm.clear();
    //   System.out.println(hm);


      //iterate 
    //   Set<String>name=hm.keySet();
    //   System.out.println(name);
    //   //now hum iss name set pr iterate krenge and value print krenge using for each loop
    //   for(String n:name){
    //     System.out.println("Key="+n+",Value="+hm.get(n));
    //   }
    // entrySet bhi use kr skte the sub same hota isme bhi TC bhi same reheti but code 2 line h bs
    //entrySet gives key value pair and easy
    // System.out.println(hm);
    // Set<Map.Entry<String,Integer>> es=hm.entrySet();
    // System.out.println(es);


    //implementation of HashMap in java: arrayList of linkedlist h internally
    // her index pr(bucket pr) node ya nodes hoti h kuch index khali bhi ho skte h beechme
    // arrayList k ander
    /*
    ab hashing mai multiple algo hoti h har language ki apni apni hum detail mai ni 
    jayenge uske but hum isse dekhenge 
    hash function hash code naam se java k ander already exist krta h
    hash func se bucket index nikalte h and waha pr operation krte h like put,get,clear etc..
    rehashing hoti h jub humare pass arrayList full hone lgti
    full mtlab ki threshold internally implement kiya jata h like
    k=2
    toh ek lamda hota jo calculate krta h ki lambda=n/N where n is LL nodes and N is arrayList size
    toh jaise he lambda ki value n increase hone k karan increase hone lge k=2 se jyada toh
    double krdo arrayList ko and ab jis index pr jo nodes thi jaruri ni ki rehashing k baad
    bhi same he ho sub ab badal bhi skta depends on internal hashing function logic(that's not our
    concern ki baat)

    bucket is hashMap.

    worst case mai HashMap ek he bucket index mai saare linkedList node add krta rahega 
    aur isse TC: O(n) ho jayegi n:number of nodes h

    Note: Uber mai pucha gaya h HashMap ki implementation: don't ignore this iski
    implementation kafi baadi h will do it later sathme 
    isme put,remove,containsKey,keySet,isEmpty,get saare functions implement krenge
    HashMap k liye class banayenge static and import wali line ko comment kr denge
    kyuki hum khudka banare HashMap 

    */


    //LinkedHashMap: isme sub operations hote h iski implementation ni puchte pr yeh puchte
    // ki isme kya implemented h internally and kya alag h so answer h: doubly linked list use 
    // hota h array k ander isme and order maintain reheta h jisme element jaate ussi m aate 
    // bahar pr hashmap mai asa kuch ni hota tha usme use bhi linkedlist hoti thi and 
    // unordered bhi tha wo.

    // LinkedHashMap<String,Integer> lhm=new LinkedHashMap<>();
    // lhm.put("India",100);
    // lhm.put("US",89);
    // lhm.put("Germany",45);
    // System.out.println(lhm);


    /*
    TreeMap: isme red-black Tree use hota h array k ander   
    and TC: insert remove ki log n hoti 
    isme key k basis pr sorting hoti h like ager string h toh first letter se number h toh ascending
    SC:O(n)
    */
  //  TreeMap<String,Integer>thm=new TreeMap<>();
  //  thm.put("India",100);
  //  thm.put("US",89);
  //  thm.put("Germany",45);
  //  System.out.println(thm);



      //Majorty element: jiski frequency > n/3 n is length of arr
      // int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
      // HashMap<Integer, Integer> hm=new HashMap<>();
      // System.out.println(MaxInArr(arr,hm)); //TC:O(n)


      //anagram
      // HashMap<Character,Integer>hm=new HashMap<>();
      // String a="rade";
      // String b="care";
      // System.out.println(Anagram(a,b,hm)); //TC:O(n) worst case mai pr: O(n^2) 



      /*
      HashSet:
    . no duplicates (unique)
    · unordered
    · NULL is allowed    
    Note: hashset is implemented using hashMap in java
    Linked Hash set: Linked Hash Map se
    Tree set: tree HashMap se

    inn saare types ki set mai key humari wo input ki hue value hui add function wali and value
    koe bhi dummy amount hui isliye hashMap mai bhi jo key hoti wo unique hoti h
      */
    //  HashSet<Integer>hs=new HashSet<>(); //O(1) all operation, null values are allowed
    //  hs.add(3);
    //  hs.add(2);
    //  hs.add(8);
    //  hs.add(9);
    //  hs.add(7);
    //  hs.add(2);
    //  hs.add(1);
    //  hs.add(null);
    //  System.out.println(hs);
    //  System.out.println(hs.contains(5));
    //  hs.remove(7);
    //  System.out.println(hs);
    //  System.out.println(hs.size());
    //  hs.clear();
    //  System.out.println(hs.isEmpty());


     //iterator: interface in java
    //  Iterator it=hs.iterator();
    //  while(it.hasNext()){
    //     System.out.println(it.next());
    //  }

     //enhanced/advanced for loop:
    //  for(Integer a:hs){
    //     System.out.println(a);
    //  }

     /*
     Linked HashMap:
     performace wise:HashMap>LinkedHashMap
                     HashSet>LinkedHashSet

                    isme Linked wale map and set dono bekar h performation m bs
                    pr TC:O(1) he reheti h performace bs doubly linked list k hisab se 
                    operation extra honge bs
            so order wise chahiye tabhi linked wala use krenge Map and set wrna normal wala he    
     */
      // LinkedHashSet<Integer> lhs=new LinkedHashSet<>();//null values allowed,TC:O(1)
      // lhs.add(3);
      // lhs.add(8);
      // lhs.add(7);
      // lhs.add(6);
      // lhs.add(1);
      // System.out.println(lhs); //isme sub same he rahega operation add remove baki sub ka


      //Tree set: yeh sort krke deta h,null values are not allowed,implemented using TreeMap
      //TC:O(log(n))
      // TreeSet<Integer> ts=new TreeSet<>();
      // ts.add(9);
      // ts.add(3);
      // ts.add(2);
      // System.out.println(ts);


      //Count Distinct elements
      // int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
      // HashSet<Integer> set = new HashSet<>();
      // System.out.println(countDistinctElements(num,set));//TC: O(n)



      //union and intersection
      // int arr1[]={7, 3, 9};
      // int arr2[] = {6, 3, 9, 2, 9, 4};
      // HashSet<Integer> set = new HashSet<>();

      // for(int i=0;i<arr1.length;i++){
      //   set.add(arr1[i]);
      // }
      // for(int i=0;i<arr2.length;i++){
      //   set.add(arr2[i]);
      // }
      // System.out.println("Union: "+set.size()+": "+set);
      // set.clear();
      // for(int i=0;i<arr1.length;i++){
      //   set.add(arr1[i]);
      // }
      // int count=0;
      // System.out.print("Intersection: ");
      // for(int i=0;i<arr2.length;i++){
      //   if(set.contains(arr2[i])){
      //     count++;
      //     set.remove(arr2[i]);
      //     System.out.print(arr2[i]+" ");
      //   }
      // }
      // System.out.println();
      // System.out.println("Intersection: "+count);


      //Find itenary(journey) for ticket:
      // HashMap<String, String> tickets = new HashMap<>();
      // tickets.put("Chennai", "Bengaluru");
      // tickets.put("Mumbai","Delhi");
      // tickets.put("Goa", "Chennai");
      // tickets.put("Delhi", "Goa");
      // HashMap<String,String> revMap=new HashMap<>();
      // for(String k:tickets.keySet()){
      //   revMap.put(tickets.get(k),k);
      // }
      // String start="";
      // for(String k:tickets.keySet()){
      //   if(!revMap.containsKey(k)){
      //     start=k;
      //   }
      // }
      // for(String k:tickets.keySet()){
      //   System.out.println(start+" to "+tickets.get(start));
      //   start=tickets.get(start); //TC:O(n)
      // }


      //largest subarray:
      // int arr[] = {15, -2, 2, -8, 1, 7, 10};
      // System.out.println(largestSubarray(arr)); //TC:O(n)


      //subarray sum equal to k
      int arr[]={10,2,-2,-20,10};
      int k=-10;
      System.out.println(subarrayEqualToK(arr,k));

    }
}
