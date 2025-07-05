import java.util.*;
class p7{
    // Common prefix
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[sc.nextInt()];
        for(int i=0; i<str.length; i++){
            str[i] = sc.next();
        }
        System.out.println(commonPrefix(str));

    }

    public static String commonPrefix(String[] str){
        if(str ==null || str.length==0) return "";
        String prefix = str[0];
        for(int i=1; i<str.length; i++){
            while(!str[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}