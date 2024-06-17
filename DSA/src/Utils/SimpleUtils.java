package Utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SimpleUtils {
    public static void main(String[] args){

        //Convert String to int
        String s = "1";
        int i = Integer.parseInt(s);
        System.out.println("Convert String: \""+s+"\" to int: "+i);

        //convert char to int
        char c = '1';
        int a = c - '0';
        int b = Character.getNumericValue(c);
        System.out.println("Convert char: \""+c+"\" to int: "+b);

        //String to char array
        String s1="example";
        char[] ch1 = s1.toCharArray();
        System.out.println(ch1[0]);

        //Substring
        System.out.println(s1.substring(s1.length()-2)); //starting from given index to end
        System.out.println(s1.substring(0,3));//starting index to end index-1(inclusive to start index, exclusive of end index)

        //Array to arraylist
        int[] arr = {1,2,3,4,5};
        String[] strArr = {"a","b","c","d","e"};
        List ls1 = Arrays.asList(arr);
        List ls2 = Arrays.asList(strArr);
        System.out.println(ls2);

        //Array to linkedlist
        Integer[] arr1 = {1,2,3,4,5};
        LinkedList<Integer> ll1 = new LinkedList<>(Arrays.asList(arr1));

        //String replace special characters
        String special = "a b c d !@#d $%f^&*g()h_+'.,~` 34324324324 i j k";
        System.out.println(special.replaceAll("[^a-zA-Z0-9]",""));

    }
}
