import java.util.Stack;

public class Stack41Part2 {
    public static boolean parenthesis(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{'){
                s.push(str.charAt(i));
            }
            else{
                if(s.isEmpty()){
                    return false; // stack khali tha "}})" tb yeh 
                }
                else if(str.charAt(i)==')' && s.peek()=='(' || (str.charAt(i)==']' && s.peek()=='[') || str.charAt(i)=='}' && s.peek()=='{'){
                    s.pop();
                }
                else{
                    return false; //ager matching ni h toh yeh
                }
                
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;

    }

    public static boolean duplicateParenthesis(String st){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)=='(' || st.charAt(i)=='a' || st.charAt(i)=='b' || 
            st.charAt(i)=='c' || st.charAt(i)=='d' || st.charAt(i)=='+' ||
             st.charAt(i)=='-' ||st.charAt(i)=='*' ||st.charAt(i)=='/' ||st.charAt(i)=='%'){
                s.push(st.charAt(i));
            }
            else{
                int count=0;
                while(!s.isEmpty() && s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(s.isEmpty()){
                    return true;
                }
                if(count<1){
                    return true;
                }
                s.pop();
            }
        }
        return false;
    }

    public static int maxRecArea(int arr[]){
        int lftS[]=new int[arr.length];
        int rgtS[]=new int[arr.length];
        int maxArea=0;
        Stack<Integer> s=new Stack<>();
        // left se small jo mille current k comparision mai recent uska array
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                lftS[i]=-1;
            }
            else{
                lftS[i]=s.peek();
            }
            s.push(i);
        }
        
        // right se small jo mille current k comparision mai recent uska array
        s=new Stack<>(); //empty kr lenge stack ko
        for(int j=arr.length-1;j>=0;j--){
            while(!s.isEmpty() && arr[s.peek()]>arr[j]){
                s.pop();
            }
            if(s.isEmpty()){
                rgtS[j]=arr.length;
            }
            else{
                rgtS[j]=s.peek();
            }
            s.push(j);
        }
        int area;
        for(int k=0;k<arr.length;k++){
            area=arr[k]*(rgtS[k]-lftS[k]-1); //area=height*(j-i-1) => j:rgtS[j] and i:lftS[i]
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
    public static void main(){
        /*
        Valid Parentheses

        Given a string s containing just the characters '(', ')', '{', ')', '[' and ']', 
        determine if the input string is valid.
        An input string is valid if:
        1. Open brackets must be closed by the same type of brackets.
        2. Open brackets must be closed in the correct order.
        3. Every close bracket has a corresponding open bracket of the same type.
        4.ager stack khali ni hua pop krwake bhi sub end tk iska mtlab invalid parenthesis

        eg:
        tell isme konsa valid h konsa ni:

        s="(){}[]"

        s = "()"

        s = "(]"

        S = ")("

        */
        // System.out.println(parenthesis("})")); //TC: O(2n)=O(n)->ek baar push ek baar pop



        //microsoft,google and other companies have asked this question :
        //duplicate parenthesis:
        /*

        Duplicate Parentheses
        Given a balanced expression, find if it contains duplicate parentheses or not. A set of
        parentheses are duplicate if the same subexpression is surrounded by multiple
        parentheses.

        Return a true if it contains duplicates else return false.

        

        example : (((a+(b)))+(c+d)) :true

        example : ((((a)+(b))+c+d)) :true

        example : ((a+ b)+(c+d)) : false

        example : ( ( (a + b))+c) :true
        
        
        */
    //    System.out.println(duplicateParenthesis("(((a)+(b)))")); //TC:O(n)



       //Max rectangular area in histogram-> microsoft,paytm,facebook etc asked
       int arr[]={2,1,5,6,2,3};
       System.out.println(maxRecArea(arr));  //TC:O(n)

    }
}
