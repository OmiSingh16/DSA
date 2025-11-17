import java.util.Arrays;
import java.util.Comparator;

public class ChocolaProblem {
  
  public static void main(String[] args) {
    // size of n=6 X m=4 choclate
    Integer [] costVer={2,1,3,1,4};
    Integer [] costHor = {4,1,2};
    Arrays.sort(costVer , Comparator.reverseOrder());
    Arrays.sort(costHor , Comparator.reverseOrder());

    int h =0 ,v=0;
    int hp =1 , vp =1;
    int cost = 0;

    while(h<costHor.length && v<costVer.length){
      if(costHor[h]<= costVer[v]){// vertical cut
        cost +=(costVer[v]*hp);
        vp++;
        v++;
      }else{
        cost+=(costHor[h]*vp);
        hp++;
        h++;
      }
    }
    while(h<costHor.length){
      cost+=(costHor[h]*vp);
        hp++;
        h++;
    }
    while(v<costVer.length){
       cost +=(costVer[v]*hp);
        vp++;
        v++;
    }
    System.out.println("Min cost required for chocola is : "+cost);
  }
}
