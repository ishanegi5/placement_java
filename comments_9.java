public class comments_9 {
    public static void main(){
        byte b=127; //max range
        // byte b=-128; //min range
        System.out.println(b);
        char ch='a'; //correct
        //char ch="a"; //incorrect
        // char ch="ab"; //incorrect
        System.out.println(ch);
        boolean var=true; //correct and false->correct
        // boolean var=True; //incorrect
        // boolean var="True"; //incorrect
        System.out.println(var);
        int a=8;
        float f= 50.9f; //yaha f likhna important h kyuki double data type java ka by default h internally so it gives this error 
        // "datatypes.java:15: error: incompatible types: possible lossy conversion from double to float"
        long l=450;
        double d=9.9424;
        short s=23;

        /*
        1 byte=8 bits 
        bits=> 0 or 1

        
        memory space needed:
        byte- 1 byte
        short- 2 bytes
        int-4 bytes
        long - 8 bytes
        char - 2 bytes
        float-4 bytes
        double- 8 bytes
        boolean- 1 byte
         */
    }
}
