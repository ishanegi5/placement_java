import java.util.*;
public class Strings_29 {
    public static void printChar(String name){
        for(int i=0;i<name.length();i++){
            System.out.print(name.charAt(i)+" ");
        }
    }

    public static boolean palindrome_str(String word){
        for(int i=0;i<word.length()/2;i++){
            if(word.charAt(i)!=word.charAt(word.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static float shortestPath(String dir){
        int x=0,y=0;
        for(int i=0;i<dir.length();i++){
            char letter=dir.charAt(i);
            if(letter=='N'){
                y++;
            }
            else if(letter=='S'){
                y--;
            }
            else if(letter=='E'){
                x++;
            }
            else{
                x--;
            }

        }
        int x_sqr=x*x;
        int y_sqr=y*y;

        return (float)Math.sqrt(x_sqr+y_sqr);
    }


    public static String substring(String sentence,int start,int end){
        String subs="";
        for(int i=start;i<end;i++){
            subs+=sentence.charAt(i);
        }
        return subs;
    }


    public static void largestString(String arr[]){
        String largest=arr[0];
        for(int i=1;i<arr.length;i++){
            if(largest.compareTo(arr[i])<0){
                largest=arr[i];
            }
        }
        System.out.println(largest);
    }


public static String UpperCaseConverter(String sentence){
    StringBuilder sb=new StringBuilder("");
    char ch=Character.toUpperCase(sentence.charAt(0));
    sb.append(ch);
    int i=1;
    while(i<sentence.length()){
        if(sentence.charAt(i)==' ' && i+1<sentence.length()){
            sb.append(' ');            
            sb.append(Character.toUpperCase(sentence.charAt(i+1)));
            i+=2;
            continue;
        }
        sb.append(sentence.charAt(i));
        i++;
    }
    return sb.toString();
}



    public static String stringCompession(String sc){
        StringBuilder sb=new StringBuilder("");
        char first_occurrence= ' ';
        Integer count=0;
        for(int i=0;i<sc.length();i++){
            if(first_occurrence!=sc.charAt(i)){
                first_occurrence=sc.charAt(i);
                if(count>1){
                    sb.append(count);
                }                
                sb.append(sc.charAt(i));
                count=1;
            }
            else{
                count++;
                if(i==sc.length()-1 && count>1){
                    sb.append(count);
                }
            }
        }
        
        return sb.toString();
    }


    public static void vowel_count(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
            }
        }
        System.out.println("Count of vowels: "+count);
    }


    public static String anagram(String s1,String s2){
        if(s1.length()!=s2.length()){
            return "not anagram";
        }
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        for(int i=0;i<s1.length();i++){
            boolean present=false;
            for(int j=0;j<s1.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    present=true;
                    break;
                }
            }
            if(!present){
                return "not anagram";
            }
        }
        return "anagram";
    }


    public static void main(){
        // char str1[]={'a','b','c','d'};
        // String str2="abcd";
        // String str3=new String("abcd");
        // System.out.println(str2);
        // System.out.println(str3);
        //strings are immutable 

        //I/O in string
        // Scanner sc=new Scanner(System.in);
        // String name1=sc.next(); //try ram singh 
        // System.out.println(name1); 
        // String name2=sc.nextLine(); //try ram singh 
        // System.out.println(name2);


        //length
        /*
        Note: length in array is a property
        while length() in String is a method(function) so we use () beside length */
        // String fullName="Iesha Negi";
        // System.out.println(fullName.length());


        //concatenation
        // String firstName="Iesha";
        // String lastName="Negi";
        // String fullName=firstName+" "+lastName;
        // System.out.println(fullName);


        //.charAt()-> method use 
        // System.out.println(fullName.charAt(3)); //indexing starts from 0
        //to print each character 
        // printChar(fullName);


        //palindrome
        // System.out.println(palindrome_str("racecar")); //racecar,noon,madam-> palindrome ,iesha->not palindrome
        //TC: O(n); SC: O(1)

        //shortest path "WNEENESENNN" ,"NS"-> isse 1 unit badhna h inn directions mai one note pr samjhati hu
        // String path="WNEENESENNN";
        // System.out.println(shortestPath(path));  //TC: O(n) , SC: O(1)

        //comparision
        /*
        == address ki quality check krta h objects k
        so we use .equals() for Strings
         */
        // String s1="tanu";
        // String s2="tanu";
        // String s3=new String("tanu");
        // //inme se sub equal h apke hisab se?
        // if(s1==s2){
        //     System.out.println("yes s1 and s2 equal");
        // }
        // else{
        //     System.out.println("no s1 and s2 not equal");
        // }

        // if(s1==s3){
        //     System.out.println("yes s1 and s3 equal");
        // }
        // else{
        //     System.out.println("no s1 and s3 not equal");
        // }
        /*
        == address ki quality check krta h objects k.. kyuki new keyword in s3 wo naya string create krta h chahe memory m same 
        name padha hua ho fir bhi ...but s2 s1 k create hone k baad yeh dkhta h ki kya tanu already memory m h ager h..
        ussi location mai s2 bhi point krne lgta h fir this happens in string concept
        so we use .equals() for Strings
         */
        // if(s1.equals(s3)){
        //     System.out.println("yes s1 and s3 equal");
        // }
        // else{
        //     System.out.println("no s1 and s3 not equal");
        // }
        /*ab .equals humare "tanu" ko "tanu" se s1 aur s3 k words ko compare kr ra h na ki address ko 
        s1 aur s3 k 
        */



        //substring-> string k ander ka koe bhi start,end tk continuous tukda ->one note pr
        // String greet="Hello world";
        // System.out.println(substring(greet,6,9));//self made func
        // System.out.println(greet.substring(4,9)); //built in function to do same in String class



        //print largest string
        /*
        compareTo -> method hume 0 deta h ager dono string same ho lexicographically(ASCII value) se
        -ve value deta h ager 2nd position wali string bigger ho 1st wali se 
        and +ve deta h ager 1st bigger ho 2nd se 
        */
        // String arr[]={"apple","mango","banana","Apple"}; //compares to A or a ko bhi compare kr pata h
        //apko ASCII chart batana h search krke lower and upper cases dono k liye
        // largestString(arr); //iski TC: O(n*x) x->her fruit ka naam ka size and n number of fruits
        // System.out.println(arr[0].compareToIgnoreCase("Apple")); //or yeh case ignore krdeta h



        //string builder
        //interning named concept was responsible for s1==s2 but s1!=s3 k hone k liye ->yeh uper smjha diya tha
        //ab usse string builder k concept se smjhenge
        //ek hota h stack aur ek hota h heap stack k ander s1 create hua aur heap mai tanu naam ka value bnake
        //  uski taraf point krne laga fir s2 name ka varible stack m create hua fir wo bhi same value 
        // tanu hone ki wajha se wahi point krne laga now... s3 bhi create hua new keyword k sath same tanu naam he
        //but iss baar naya create hua tanue naam heap mai aur stack m uska varible s3 naam se create hua 
        // and point krne laga uski taraf -> internal pooling concept h ki jub tk new ka use krke na bole programmer
        //tb tk purana he use kro ->one note pr smjhati hu

        //ab ager hum ek string bnaye aur usme roj choote choote changes krte rehe baadey bhut baar toh aese memeory 
        // mai baar baar new string bnegi and memory waste kregi so we avoid that and use string builder instead.
        
        // StringBuilder sb=new StringBuilder(""); //it takes  amortized(on an average) TC: O(1) 
        // for(char ch='a';ch<='z';ch++){
        //     sb.append(ch); 
        // }
        // System.out.println(sb); //TC: O(n) kyuki 26 ki jagha ager n manle toh!
        /*
        Bilkul, isi loop se samjho 👇

        StringBuilder sb = new StringBuilder();

        for(char ch='a'; ch<='z'; ch++){
            sb.append(ch);
        }

        Maan lo StringBuilder ke andar capacity 4 hai.

        Starting:
        [ _ _ _ _ ]

        append('a') → ek jagah fill:

        [ a _ _ _ ]     O(1)

        append('b'):

        [ a b _ _ ]     O(1)

        append('c'):

        [ a b c _ ]     O(1)

        append('d'):

        [ a b c d ]     O(1)

        Ab capacity full 😯

        append('e') karna hai, toh StringBuilder bigger array banayega aur purane characters copy karega:

        Old: [a b c d]
                ↓↓↓↓ copy
        New: [a b c d e _ _ _]

        Ye particular append('e') O(n) laga, kyunki purane characters copy hue.

        Lekin important baat:

        Har baar copy nahi hota!

        a → O(1)
        b → O(1)
        c → O(1)
        d → O(1)
        e → O(n)  ← resize + copy
        f → O(1)
        g → O(1)
        ...

        Toh kabhi-kabhi expensive operation hoti hai, lekin bahut saari append() 
        operations ko mila kar average cost O(1) per append padti hai.

        Isi ko amortized O(1) kehte hain.
        */

        /*
        NOTE:
        Ager humne yaha stringBuilder ki jagha string use kiya hota toh yeh possible name tha ki TC: O(n) ho pati
        stringBuilder memory efficient hota h
        string mai har baar copy krna aur concatenate krne mai bhut time lgta O(n^2).

        */

        /*
        There is a method named .toString() -> yeh sub Integer,Charater,Float class ko string m convert krta h
        but int,char aur float ko nahi kyuki wo class nahi hogi yeh primitive data types h aur uper wale classes h 

        // Java has primitive data types and their corresponding Wrapper Classes.

        // Primitive types:
        int, float, char, double, boolean, etc.

        // Wrapper Classes:
        Integer, Float, Character, Double, Boolean, etc.

        // Wrapper Classes are classes that represent primitive values as objects.
        // Methods can be called on objects, so methods like .toString() are available
        // with wrapper objects, but not directly with primitive values.

        Simple difference:
        int, float, char, double, boolean → primitive data types
        Integer, Float, Character, Double, Boolean → Wrapper Classes (ye classes hain jo 
        corresponding primitive value ko represent karti hain).

        // Wrapper Classes ki zarurat isliye hoti hai kyunki Java mein kuch situations
        // mein value ko OBJECT ke form mein chahiye hota hai.
        // Wrapper Classes methods bhi provide karti hain, jaise .toString().
        // Collections (ArrayList, HashMap) mein primitives directly use nahi hote,
        // isliye Integer, Double, Character jaise Wrapper Classes use karte hain.
        
        */
       /*
       StringBuilder mai hum sub almost saare wo methods use kr skte jaise string k ander krte they .length() , charAt()
       etc..
       
       */



       //to upper case convert each first letter of a word
    //    String sentence="i am ieSha neGi";
    //    System.out.println(UpperCaseConverter(sentence));


    

    //string compression h yeh ap isko string se krke dekhna maine stringbuilder se kr diya 
    //isme hume koe string kitne baar aari uske bagal mai likhna h a2b5c5d3 for "aabbbbbcccccddd"
    //but abcd for abcd kyuki count 1 he h subke liye toh compression ki jagha a1b1c1d1 likhke hume decompression 
    //nahi krna yaha ok?
    // String str_compression="aabbbbbcccccddd";
    // System.out.println(stringCompession(str_compression));
    //ek cheez aur ager hum iss sawal ko 2 loops lagake krte aur dono taraf i ko he increase krte toh bhi 
    // doo loops k bawajud bhi wo TC: O(n) he hoti humari ab sochke dekhna hint deti hu
    //for k ander while ko use kro aur tb iss question ko solve kro but dono k ander iterate krne k liye
    //i ko he i++ krte chalna tb uski TC: O(n) hogi 
    /*  Better example:
        int j = 0;

        for (int i = 0; i < n; i++) {

            while (j < n) {
                j++;
            }
        }
        TC = O(n) ✅
        for → n times
        while → total n times, NOT n times for every for iteration.
        Total operations ≈ n + n = 2n
        Constants ignore → O(n)

        Key idea: Nested loops automatically O(n²) nahi hote. while ki total iterations 
        agar poore program mein n hain, toh O(n) ho sakta hai. */

        //practice:
        //1) vowel occurence in a string give total count
        // vowel_count("tanu singh");

        //2) tell me the output of this
        // String name="iesha negi";
        // System.out.println(name.replace('i','a')); // replace kaam krte h bhut trike k string m
        //yeh usually new string mai required changes k hisab se changes krke hume output dere h 
        //yaad rakho strings immutable hoti h  
        //replace() ek new String return karta hai
        // 1. First occurrence replace
        // System.out.println("hello".replaceFirst("l", "x"));        // hexlo

        // 2. String ka part replace
        // System.out.println("hello world".replace("world", "Java")); // hello Java

        // 3. Character remove
        // System.out.println("banana".replace("a", ""));              // bnn

        // 4. Spaces replace
        // System.out.println("hello world".replace(" ", "_"));        // hello_world
        /*
        1. replace(char, char)
        String s = "banana";

        System.out.println(s.replace('a', 'o'));

        Output:

        bonono
        2. replace(CharSequence, CharSequence)
        String s = "I like Java";

        System.out.println(s.replace("Java", "Python"));

        Output:

        I like Python
        3. replaceAll(String regex, String replacement)

        regex ka use pattern ke according replace karne ke liye hota hai.

        String s = "abc123xyz456";

        System.out.println(s.replaceAll("[0-9]", "*"));

        Output:

        abc***xyz***
        4. replaceFirst(String regex, String replacement)

        Sirf first matching part replace karta hai.

        String s = "abc123xyz456";

        System.out.println(s.replaceFirst("[0-9]+", "*"));

        Output:

        abc*xyz456
        🧠 Yaad rakhna:
        replace()       → character/string replace
        replaceAll()    → regex ke according ALL matches
        replaceFirst()  → regex ka FIRST match

        Aur teeno original String ko change nahi karte, balki new String return karte hain. 
        */

        
        //3)anagram
        /*If two strings contain the same characters but in a different order,they can be said to be anagrams.
        Consider race and care.In this case, race's characters can be formed in to a care,or care's characters
        can be formed into race. */
        // System.out.println(anagram("rAce","CaRe"));



        //4) tell the output:
        /*
        public class Solution {

            public static void main(String args[]) {

                String str = "Iesha Negi";
                String str1 = "Java";
                String str2 = "Iesha Negi";

                System.out.println(
                    str.equals(str1) + " " + str.equals(str2)
                );
            }
        } 
        */

        //5) read and read about :
        /*

        a.intern( ) method in String
        b.StringBuffer


        read below:
        a. intern() method
            String s1 = new String("Java");
            String s2 = s1.intern();

            intern() String Pool mein same String ko search karta hai aur pool wala String reference return karta hai.
             Isse same content wali Strings ka common reference use ho sakta hai.

        b. StringBuffer

            StringBuffer ek mutable String class hai. Isme String ki value ko directly change kar sakte hain. 
            append(), insert(), delete() jaise methods use hote hain. Ye thread-safe hai, isliye multiple threads ke 
            saath safer hota hai.

        
        */


        //1)ab leetcode pr anagram ka bataungi 1,2,3 methods h solve krne k brute force,better,optimized
        //2)missing number
        //3)transpose matrix
        //4)search in a 2 D matrix I
        //5)search in a 2 D matrix II







    }
}
