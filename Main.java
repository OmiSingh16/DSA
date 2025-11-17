import java.util.*;

class Visitor {
    int visitorId;
    String visitorName;
    String contactNumber;
    String visitPurpose;
    String employeeToMeet;
    String visitTime;

    public Visitor(int visitorId, String visitorName, String contactNumber,
                   String visitPurpose, String employeeToMeet, String visitTime) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.contactNumber = contactNumber;
        this.visitPurpose = visitPurpose;
        this.employeeToMeet = employeeToMeet;
        this.visitTime = visitTime;
    }

    @Override
    public String toString() {
        return visitorId + " | " + visitorName + " | " + contactNumber + " | " +
               visitPurpose + " | " + employeeToMeet + " | " + visitTime;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Visitor> visitors = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine()); // number of operations

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");

            // Detect operation type based on number of fields
            if (parts.length == 6) {
                // INSERT operation: id name contact purpose employee time
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String contact = parts[2];
                String purpose = parts[3];
                String employee = parts[4];
                String time = parts[5];

                visitors.add(new Visitor(id, name, contact, purpose, employee, time));
                System.out.println("Visitor added successfully");

            } else if (parts.length == 2) {
                // UPDATE operation: id newPurpose
                int uid = Integer.parseInt(parts[0]);
                String newPurpose = parts[1];
                boolean updated = false;
                for (Visitor v : visitors) {
                    if (v.visitorId == uid) {
                        v.visitPurpose = newPurpose;
                        updated = true;
                        break;
                    }
                }
                System.out.println(updated ? "Visitor record updated" : "Visitor ID not found");

            } else if (parts.length == 1) {
                // DELETE or DISPLAY operation
                int idToDelete = Integer.parseInt(parts[0]);
                boolean removed = visitors.removeIf(v -> v.visitorId == idToDelete);
                System.out.println(removed ? "Visitor record deleted" : "Visitor ID not found");
            }
        }

        // Final DISPLAY after all operations
        if (visitors.isEmpty()) {
            System.out.println("No visitor records found");
        } else {
            visitors.sort(Comparator.comparingInt(v -> v.visitorId));
            for (Visitor v : visitors) {
                System.out.println(v);
            }
        }

        sc.close();
    }
}
 