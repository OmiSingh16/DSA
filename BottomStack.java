import java.util.*;
public class BottomStack {
  public static void pushAtBottom(Stack<Integer> s ,int data){
     if(s.isEmpty()){
      s.push(data);
      return;
     } 
    int top = s.pop();
    pushAtBottom(s, data);
    s.push(top);
    }
    // reverse stack
    public static void reverseStack(Stack<Integer> s){
      if(s.isEmpty()) return;
      int top = s.pop();
      reverseStack(s);
      pushAtBottom(s, top);
    }

    //print stack
    public static void printStack(Stack<Integer> s){
    Stack<Integer> temp = new Stack<>();
    while(!s.isEmpty()){
        int top = s.pop();
        System.out.println(top);
        temp.push(top);
    }
    // restore original stack
    while(!temp.isEmpty()){
        s.push(temp.pop());
    }
}

    
    public static void main(String[] args){
   Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(5);
    s.push(9);
    printStack(s);
    // pushAtBottom(s,4);
    System.out.println("Here is the Reverse String");
    reverseStack(s);
    printStack(s);
    
  }
}
