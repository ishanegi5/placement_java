public class test {
    public static void update(int a,int b){
        a=2;
        b=5;
        return;
    }
    public static void main(){
        int a=9;
        int b=8;
        System.out.println(a+" "+b);
        update(a,b);
        System.out.println(a+" "+b);
    }
}
