import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Indiancoins {
  public static void main(String[] args) {
    
    Integer [] notes = {20,500,1,50,2000,10,5,2,100};
    Arrays.sort(notes , Comparator.reverseOrder());

    int countN = 0;
    int amount = 1059;
    ArrayList<Integer> ans = new ArrayList<>();
    for(int i=0; i<notes.length; i++){
      if(notes[i]<=amount){  
        while(notes[i]<=amount){
          countN++;
          ans.add(notes[i]);
          amount -= notes[i];
        }
      }
    }
     System.out.println("Min number of Notes which can be Used to pay the amount will be : "+countN);
     System.out.println("These notes are as follows ->");
     int count = 0;
     for (int n : ans) {
      System.out.print(n);
      count++;
      if (count < ans.size()) { // not the last element
        System.out.print(", ");
        }
    }
      System.out.println();
  }
}
