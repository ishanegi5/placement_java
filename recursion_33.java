public class recursion_33 {
    public static int tilingProblem(int n){
        int totalWays=0;
        int vertically=0;
        int horizontally=0;
        if(n==0 || n==1){
            return 1;
        }
        
        vertically=tilingProblem(n-1);            
        horizontally=tilingProblem(n-2);
        
        totalWays+=vertically+horizontally;
        return totalWays;

    }

    public static int tilingProblemFour(int n){
        int vertical;
        int horizontal;
        int total=0;
        if(n<0){
            return 0;
        }
        if(n==0 || n==1){
            return 1;
        }
        vertical=tilingProblemFour(n-1);
        horizontal=tilingProblemFour(n-4);
        total+=vertical+horizontal;
        return total;
    }

    public static String removeDuplicates(String word,int i,boolean []map,StringBuilder result){
        
        if(i==word.length()){
            return result.toString();
        }
        if(map[word.charAt(i)-'a']!=true){
            map[word.charAt(i)-'a']=true;
            result.append(word.charAt(i));
        }
        
        return removeDuplicates(word, i+1, map,result);
        
        
    }


    public static int friendsPair(int n){
        if(n==1 ||n==2){
            return n;
        }
        int single=friendsPair(n-1);
        int pair=(n-1)*friendsPair(n-2); //yaha n-1 multiply hora h kyuki jo single hua h wo kisi k bhi sath pair bna skta h
        return single+pair;
    }

    public static void binaryStringProblem(int n,String lastPlace,String bStr){
        if(n==0){
            System.out.println(bStr);
            return;
        }
        if(lastPlace.equals("0")){
            binaryStringProblem(n-1, "1", bStr+"1");
            
        }
        binaryStringProblem(n-1, "0", bStr+"0");
        
    }

    public static void binaryStringProblemNoConsecutiveZeros(int n,String lastPlace,String bStr){
        if(n==0){
            System.out.println(bStr);
            return;
        }
        if(lastPlace.equals("1")){
            binaryStringProblemNoConsecutiveZeros(n-1, "0", bStr+"0");
            
        }
        binaryStringProblemNoConsecutiveZeros(n-1, "1", bStr+"1");
        
    }

    public static int lenOfStr(String word,int i){
        if(i==word.length()){
            return i;
        }
        return lenOfStr(word,i+1);
    }


    public static int substringSameStartEnd(String word,int i,int j,int count){
        if(i==word.length()){
            return count;
        }
        if(word.charAt(i)==word.charAt(j)){
            count+=1;
        }
        
        if(j<word.length()-1){
            return substringSameStartEnd(word,i,j+1,count);
        }
        return substringSameStartEnd(word,i+1,i+1,count);
                
                
    }


    public static void TOH(int n,char source,char destination,char helper){ //ispe lagake imagine kro recursive call wali lines ko
        if(n==0){
            return;
        }
        TOH(n-1,source,helper,destination); //mtlab isko aur-> yaha destination humara helper bna and vice versa
        System.out.println(source+" to "+destination);
        TOH(n-1,helper,destination,source); //isko-> yaha helper humara source bna and vice versa
    }

    public static void main(){
        //tile board h koe 4Xn ka usme tile lagani h 4X1 ki yaha n input m milega aur hume tarike dhundne h isse krne k saare
        //yeh amazon mai kafi baar pucha gaya h:
        // System.out.println(tilingProblem(5)); //2X1 tile
        // System.out.println(tilingProblemFour(5)); //4X1 tile

        //remove duplicates using recursion:
        //yeh google mai aaya h microsoft mai bhi aaya h
        // boolean [] map=new boolean[26];
        // StringBuilder result=new StringBuilder();
        // System.out.println(removeDuplicates("apnacollege",0,map,result)); //iska
        //stack analysis krenge one note pr


        //friends pair: ya toh single rehe skta h ya pair bnayega
        // System.out.println(friendsPair(6)); 

        //binary strings problem -> paytm mai aaya h sawal-> isme consecutive 1 ni aa skte
        // binaryStringProblem(3,"0","");

        //binary strings problem -> paytm mai aaya h sawal-> isme consecutive 0 ni aa skte
        // binaryStringProblemNoConsecutiveZeros(3,"1",""); //1 se start krenge kyuki 1 wo func mai laga he dega
        //but zero se start hone wale strings tb he cover honge jub lastPlace ko 1 se start kroge yaha argument m


        //write a program to find length of a string 
        // System.out.println(lenOfStr("Hello",0));


        //write a program to find number of substrings starting and ending with same letter
        System.out.println(substringSameStartEnd("abcab",0,0,0));


        // hanoi
        // TOH(2,'a','c','b'); //TC:O(2^n) , SC:O(n)

    }
}
