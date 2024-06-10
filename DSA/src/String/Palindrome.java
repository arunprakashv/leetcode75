package String;

public class Palindrome {
    public static void main(String[] args){
        String  palin = "ab@a";
        boolean palindrome = isPalindrome(palin);
        System.out.println(palindrome);

    }

    public static boolean isPalindrome(String s) {

        String str = s.replaceAll("[^a-zA-Z0-9]","");
        str = str.toLowerCase();
        boolean isBoolean = true;
        char[] chars = str.toCharArray();
        if(str.length()==1) return true;
        for(int i=0;i<chars.length;i++){
            if(!(chars[i] == chars[(chars.length-1) - i])){
                isBoolean = false;
                break;
            }
        }
        return isBoolean;
    }
}
