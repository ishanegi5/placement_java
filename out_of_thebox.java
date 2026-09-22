public class out_of_thebox {
    public static void main(){
        System.out.print("0 1 ");
        int start=3;
        int store=4;
        for(int i=1;i<=10;i++){            
            System.out.print(store+" ");
            start+=2;
            store+=start;
            
        }

        for(int i=0;i<=5;i++){
            System.out.print(i*i+" ");
        }
    }
}
