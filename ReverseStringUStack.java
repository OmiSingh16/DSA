import java.util.Stack;

public class ReverseStringUStack {
 public static String reverseString(String str){
      Stack<Character> s1 = new Stack<>();
      int i=0;
      while(i<str.length()){
        s1.push(str.charAt(i));
        i++;
      }

      StringBuilder result = new StringBuilder("");
      while(!s1.isEmpty()){
        char ch = s1.pop();
        result.append(ch); 
      }
      return  result.toString();
    }
    public static void main(String[] args){
    String str = "OmPrakash";
    String result = reverseString(str);
    System.out.println(result);
  } 
}
