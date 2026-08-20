public class type_promotion_12 {
    public static void main(){
        // char a='a';
        // char b='b';
        // System.out.println((int)a);
        // System.out.println(a-b);

        //short,char,byte are promoted to integer data type when evaluating an expression +,-,*,/,%
        



        //idher subse bada data type bnn gaya subke liye-> long ,float ,double ager h 
        // kisi expression mai toh wo respective data type mai convert hoga
        // int c=4;
        // float d=9.80f;
        // double e=34.2;
        // double s=a+b+c+d+e;
        // System.out.println(s);



        //byte mai normal evaluation krte time bhi error ayega cause int mai convert hota h
        byte b=8;
        // b=b*2; //error: incompatible types: possible lossy conversion from int to byte-> kyuki 
        // humne * kiya isliye error aaya usne isse int mai convert kiya

        b=(byte)(b*2);
        System.out.println(b); 

    }
}
