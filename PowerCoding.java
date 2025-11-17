/* import java.util.*;

class Visitor {
  int visitorId ;
  String visitorName;
  String visitorCnt;
  String visitorMeet;
  String visitTime;

  public Visitor(int visitorID , String visitorName, String visitorCnt, String visitorMeet, String visitTime){
    this.visitorId = visitorID;
    this.visitorName = visitorName;
    this.visitorCnt = visitorCnt;
    this.visitorMeet = visitorMeet;
    this.visitTime = visitTime;
  }
  public String toString(){
    return  visitorId +" | "+
   visitorName+" | "+
   visitorCnt+" | "+
   visitorMeet+" | "+
   visitTime;

  }
}

public class PowerCoding {
   public static void  main (String [] args){
    List<Visitor> visitors = new ArrayList<>();
    Scanner  sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());

    for(int i=0; i<n; i++){
      String line = sc.nextLine().trim();
      String [] parts = line.split(" ");

      // Detect operation 
      if(parts.length == 6){
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String contact = parts[2];
        String person = parts[4];
        String time = parts[5];
        visitors.add(new Visitor (id , name, contact , person,time));
        System.out.println("Visitor added succesfully");
      }
      else if(parts.length==1){
        int id = Integer.parseInt(parts[0]);
        boolean remove = visitors.removeIf(v ->  v.visitorId ==id );
        System.out.println(remove ?"Visitor deleted":"Visitor not found");
        
      }
    }

  }
}
 */