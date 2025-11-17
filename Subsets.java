public class Subsets {
  
  // public static void findSubsets(String str , String ans, int i){
  //   //Base Case
  //   if(i==str.length()){
  //     if(ans.length()==0){
  //       System.out.println("null");
  //     }
  //     System.out.println(ans);
  //     return ;
  //   }
  //   //REcursion
  //   // Yes Choice
  //   findSubsets(str, ans+str.charAt(i), i+1);

  //   // No choice
  //   findSubsets(str, ans, i+1);
  // }

  // public static void main (String[] args){
  //   String str = "abc";
  //   findSubsets(str ,"",0);
  // }

  //  Using String Builder...
   public static void findSubsets(String str, StringBuilder ans, int i) {
        // Base Case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans.toString());
            }
            return;
        }

        // Yes Choice -> include str.charAt(i)
        ans.append(str.charAt(i));
        findSubsets(str, ans, i + 1);

        // Backtrack (remove last char before exploring No choice)
        ans.deleteCharAt(ans.length() - 1);

        // No Choice -> skip str.charAt(i)
        findSubsets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        StringBuilder ans = new StringBuilder();
        findSubsets(str, ans, 0);
    }
}
