public class trie_49{
    static class Node{
        Node children[]=new Node[26];
        boolean endOfWord=false; //by default false manke chalenge kyuki end sub words 
        // k liye diff hoga
        public Node(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
            
        }
    }
    public static Node root=new Node();

    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){   
            int index= word.charAt(i)-'a';        
            if(curr.children[index]==null){
                curr.children[index]=new Node();
            }
            curr=curr.children[index];
        }
        curr.endOfWord=true;
    }

    public static boolean search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr=curr.children[index];
        }
        return curr.endOfWord==true;
    }

    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){ //subst4ring mai end excluded hota h isliye <= condition use ki h
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){ //isme bs i likha h ka mtlab waha se last tk sub
                return true;
            }
        }
        return false;

    }
    static class Node2{
        Node2 children[]=new Node2[26];
        int freq;
        boolean eow=false;
        public Node2(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;
        }
    }
    public static Node2 root2=new Node2();
    public static void insert2(String word){
        Node2 curr=root2;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index]=new Node2();

            }
            else{
                curr.children[index].freq++;
            }
            curr=curr.children[index];
        }
    }
    public static void findPrefix(Node2 root,String ans){
        if(root==null){
            return;
        }
        if(root.freq==1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                findPrefix(root.children[i],ans+(char)(i+'a'));
            }
        }
    }
    public static void main(){
        //isko trai padhte h and yeh tree ka he ek data stucture  hota h.isko prefix 
        // tree bhi bolte h,retrieval tree and digital search tree bhi bolte h and
        //trie ka name retrieval se extracted h tries string se related sawal ko solve krne k
        //liye use hote h
        /*
        k-aray tree kehete isse like binary mtlab 2 children for ach node wala tree hota
        waise he k-aray mtlab k children wala tree hua
        ab kyuki isme k nodes ek he level pr hote toh height choti hoti iss tree ki 
        and TC bhi optimized milti h isme
        use case: prefix,suffix,word search in string ager krna to use trie
        words[ ] = "the", "a", "there", "their", "any", "thee" 
        iske liye apko trie one note pr banake batati hu :
        Note: root node isme enpty node hogi
        isme ager node array hoga wo 26 size ka hoga mostly but ager java characters k hisab
        se dekhe toh 256 size ka array bana skte h hum
        so ab hum trie ka basic construction dekhenge Node class banke and root node initialize krke 
        */
        //Insert in trie-microsoft and others have asked \
        // String words[]={"the","a","there","their","any","thee"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);//O(L) mtlab length of largest word
        // }


        
        //search a word in trie
        // System.out.println(search("thee"));
        // System.out.println(search("thor"));
        // System.out.println(search("any"));
        // System.out.println(search("an"));


        /*
        Word Break Problem-google

        Given an input string and a dictionary of words, find out if the 
        input string can be broken into a space-separated sequence of 
        dictionary words.

        words[ ] = { i, like, sam, samsung, mobile, ice}
        key = "ilikesamsung"

        output : true
        
        */
    //    String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
    //    String key = "ilikesamsung";
    //    for(int i=0;i<words.length;i++){
    //     insert(words[i]);
    //    }
    //    System.out.println(wordBreak(key)); //TC:O(L) L is key length



       /*Prefix Problem-microsoft and google mai aaya hua h yeh question
        Find shortest unique prefix for every word in a given list.
        Assume no word is prefix of another.

        arr[ ] = {"zebra", "dog", "duck", "dove")
        ans = {"z", "dog", "du", "dov"} 
        */
       String arr[ ] = {"zebra", "dog", "duck", "dove"};
       for(int i=0;i<arr.length;i++){
            insert2(arr[i]);
       }
       root2.freq=-1;
       findPrefix(root2,"");
       

    }
}