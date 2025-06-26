package Marquee.BinarySearch.Leetcode;


public class ValidParanthesis {
    String str = "{[(])}";
    char[] arr = new char[str.length()];
    int top = -1;

    public boolean pop(){
        if(top==arr.length-1) return false;
        top--;
        return true;
    }

    public boolean push(char c){
        arr[++top] = c;
        return true;
    }

    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }

    public char peek(){
        if(isEmpty()){
            return '0';
        }
        else{
            return arr[top];
        }
    }

    public boolean isValid(String str){
        if(str.length()==1) return false;
        for(char c: str.toCharArray()){
            if(c=='['||c=='{'||c=='('){
                push(c);
            }
            if(c==']'||c=='}'||c==')'){
                char temp = peek();
                if(temp=='['&&c!=']' || temp=='{'&&c!='}'|| temp=='('&&c!=')'){
                    return false;
                }
                pop();
            }
        }

        return top==-1? true: false;
    }

    public static void main(String args[]){
        ValidParanthesis vp = new ValidParanthesis();
        System.out.println(vp.isValid(vp.str));
    }
}
