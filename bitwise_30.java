public class bitwise_30{
    public static void EOCheck(int n){
        int bitmask=1;
        if((n & bitmask)==0){
            System.out.println("even");
            return;
        }
        System.out.println("odd");
    }

    public static void getIthBit(int n,int pos){
        int bitmask=1<<pos;
        if((n & bitmask)==0){
            System.out.println("0 was present");
            return;
        }
        System.out.println("1 was present");
    }

    public static int setIthBit(int n,int pos){
        int bitmask=1<<pos;
        return n|bitmask;
    }

    public static int clearIthBit(int n,int pos){
        int bitmask=1<<pos;
        int not_bitmask=~(bitmask);
        return n&not_bitmask;
    }

    public static int updateIthBit(int n,int pos,int update){
        // if(update==1){
        //     return setIthBit(n,pos);
        // }
        // else{
        //     return clearIthBit(n,pos);
        // }
        
        //2nd method
        n=clearIthBit(n, pos);
        int bitmask=update<<pos;
        return bitmask;
    }

    public static int clearIbits(int n,int pos){
        int bitmask=(~0)<<pos;
        return n&bitmask;
    }


    public static boolean checkTwoPower(int n){
        /*
        ager koe number 2 ki power walahota h like 4,8,16-> 2^2,2^3,2^4
        toh uska and krne pr +1 wale number k sath hume 0 milta --> this is a 
        property to remember and it's logical even.*/
        //->check one note for this image se smjho copy pen wali
        return (n & (n-1))==0;
    }


    public static int clearBitsInRange(int n,int i,int j){
        int a=(~0)<<j+1; //(~0)=0000=1111<<j->1111<<5=100000
        int b=(1<<i)-1; //(0001<<2)=> 00100=4-1=3=0011
        int bitmask=a|b;
        /*
        100000
        000011 (OR)
        ------
        100011
        ------*/
        return n&bitmask;  //001010
        //                  &100011
        //                ----------
        //                   000010 ->(2) in decimal
        //                ----------
    }


    public static int countSetBits(int n){
        int count=0;
        int copy_n=n;
        for(int i=0;i<Math.log(copy_n)+1;i++){ 
            //i<Math.log(copy_n)+1
            //n=16-> 10000 ->log(16)+1=4+1=5bits
            if((n&1)!=0){ //1->00001 iska kisi k bhi sath & krne pr ager not zero aye
                //mtlab wo LSB pr bhi 1 he tha wrna 0 tha ->one note pr samjhati
                count+=1;
                n=n>>1; //number ki bits ki ek ek krke right shift krte rahenge 
                //jub tk wo 0 na ho jaye total
                continue;
            }
            n=n>>1; //ager LSB pr 0 ho toh bhi shift hoke update hota rahe   
        }        
        return count;
    }

    public static int fastExponentiation(int a,int n){
        int ans=1;
        while(n!=0){ //5=101,010!=0->true,001!=0->true ,000!=0->false
            if((n&1)!=0){ //101&001=001->true, 010&001=000!=0->false, 001&001=001!=0->true
                ans*=a; //ans=1*3*81
            }
            a*=a;  //3*3=9,9*9=81,81*81=6561
            n=n>>1;  //010,001,000
        }
        return ans; //243
    }

    public static void swap(int a,int b){
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        a=a^b; //one note pr h explaination
        b=a^b;
        a=a^b;
        System.out.println("a: "+a);
        System.out.println("b: "+b);

    }

    public static int addOne(int n){
        return -(~n); //yaha yaad rakhna ki  ~x=-(x+1) so (x+1)=-(~x) isliye yeh formula baki one note pr batati value ka dry run
    }

    public static void UpperToLower(){
        for(char ch='A';ch<='Z';ch++){
            System.out.print((char)(ch|' ')+" ");
        }
    }

    public static void LowerToUpper(){
        for(char ch='a';ch<='z';ch++){
            System.out.println((char)(ch&'_'));
        }
    }

    public static int modularExponentiation(int base,int n,int mod){
        int result=1;
        while(n!=0){
            if(n%2!=0){
                result*=base;
            }
            base=(base*base)%mod;
            n/=2;

        }
        return result;
    }
    public static void main(){
        //bitwise AND operator use-> &
        // System.out.println(5&6); 
        //5=101
       //+6=110
       //--------
       //->100   ->4
       //--------


       //bitwise OR operator use -> |
    //    System.out.println(5|6);
       //5=101
      //+6=110
       //--------
       //->111   ->7
       //--------


       //bitwise XOR operator use -> ^
    //    System.out.println(5^6);
       //5=101
      //+6=110
      //--------
       //->011   ->3
      //--------


      //bitwise NOT operator use -> ~
    //    System.out.println(~5);
       //5=101
      //--------
       //->001   ->-6 ->reason in one note 
       //--------

    //    System.out.println(~9);
    //    System.out.println(~0);
    //    System.out.println(~-3);
    //    System.out.println(~-5);
       //positive ka NOT negative hota and negative ka NOT positive hota


       //left shift operator -> one note pr explain krti
    //    System.out.println(5<<2);
       //formula a<<b=> a*(2^b)=> 5*(2^2)=5*4=20 -> a*(2^b) this is formula to remember

       //note:  1 is set bit 
             // 0 is unset or clear bit


        // System.out.println(5>>2); //a/2^b=5/2^2=5/4=1 here the formula is: a/(2^b)

        //even/odd check
        // EOCheck(2);
       

        //find ith bit
        // getIthBit(10,2) ;


        //set ith bit
        // System.out.println(setIthBit(10,2));


        //clear ith bit
        // System.out.println(clearIthBit(10,1));

        //update ith bit
        // System.out.println(updateIthBit(3,2,1)); 


        //clear i bits
        // int n=15;
        // int bits_to_clear=2;
        // System.out.println(clearIbits(n,bits_to_clear));


        //clear bits in a range
        // int n=10;
        // int i=2;
        // int j=4;
        // System.out.println(clearBitsInRange(n,i,j));


        //checking if a number is in power of 2
        // int n=15;
        // System.out.println(checkTwoPower(n));


        //count set bits of a number
        // System.out.println(countSetBits(7));


        //fast exponentiation-> yeh yeh kisi bhi number ki power ko jldi calculate krke deta h
        // System.out.println(fastExponentiation(3,5)); //useful for bigger values like lakhs crores 
        //TC: O(log(n)+1)=log(5)+1=2+1=3 it ran 3 times for n=5 


        //1)swap without third variable
        // int a=4;
        // int b=2;
        // swap(a,b);


        //2)add 1 to a number using bitwise operator
        // System.out.println(addOne(14)); 
        //3)upper case ko lower mai badalna h bit ki help se
        // UpperToLower();
       /*

       'A' = 65 = 01000001
       ' ' = 32 = 00100000
            ---------------- OR
                  01100001 = 97 = 'a'
        */ 


    //    LowerToUpper();
       /*
       'a' = 97 = 01100001
       '_' = 95 = 01011111
            ---------------- AND
                  01000001 = 65 = 'A' 
            
        */

        //modular exponentiation
        int base=2;
        int n=4; //waise yeh value baadi lena ap ,maine bs smjhane k liye choti li value
        int mod=7;
        System.out.println(modularExponentiation(base,n,mod)); //batati hu one note pr dry run mai!

        //136. Single Number leetcode
        // 231. Power of Two            
        // 461. Hamming Distance
        // 191. Number of 1 Bits
        // 268. Missing Number
        //42. Trapping Rain Water
        //15. 3Sum
        
    }
}