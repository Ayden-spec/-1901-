public class Palindrome {
    public static void main(String[] args) {//определяет, являются ли введёные через консоль строки палиндромами
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if(isPalindrome(s)){
                System.out.println("string" + s + "is a palindrome");
            }
        }
    }
    public static String reverseString(String s){//переворачивает строку
        String rev = "";
        for (int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        return rev;
    }
    public static boolean isPalindrome(String s){//определяет, является ли строка палиндромом
        String rev= reverseString(s);
        if (s.equals(rev)){
            return true;
        }
        else {
            return false;
        }
    }
}