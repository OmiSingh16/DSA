import java.util.*;

class Visitor2 {
    int visitorId;
    String visitorName;
    String contactNumber;
    String visitPurpose;
    String employeeToMeet;
    String visitTime;

    public Visitor2(int visitorId, String visitorName, String contactNumber,
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

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Visitor2> visitors = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine()); // number of operations

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");

            if (parts.length >= 6) {
                // INSERT operation (id name contact purpose employee time)
                int id = Integer.parseInt(parts[0]);
                String contact = parts[parts.length - 3];
                String time = parts[parts.length - 1];
                String employee = parts[parts.length - 2];

                // visitorName: everything between id and contact
                String visitorName = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length - 3));
                // visitPurpose: here we assume it’s part of visitorName if needed, or adjust as per input
                // For simplicity, let's take first word as visitorName, remaining as visitPurpose
                String[] nameAndPurpose = visitorName.split(" ", 2);
                visitorName = nameAndPurpose[0];
                String visitPurpose = nameAndPurpose.length > 1 ? nameAndPurpose[1] : "N/A";

                visitors.add(new Visitor2(id, visitorName, contact, visitPurpose, employee, time));
                System.out.println("Visitor added successfully");

            } else if (parts.length >= 2) {
                // UPDATE operation: id newPurpose (newPurpose can be multiple words)
                int uid = Integer.parseInt(parts[0]);
                String newPurpose = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length));
                boolean updated = false;
                for (Visitor2 v : visitors) {
                    if (v.visitorId == uid) {
                        v.visitPurpose = newPurpose;
                        updated = true;
                        break;
                    }
                }
                System.out.println(updated ? "Visitor record updated" : "Visitor ID not found");

            } else if (parts.length == 1) {
                // DELETE operation: id
                int did = Integer.parseInt(parts[0]);
                boolean removed = visitors.removeIf(v -> v.visitorId == did);
                System.out.println(removed ? "Visitor record deleted" : "Visitor ID not found");
            }
        }

        // Final DISPLAY after all operations
        if (visitors.isEmpty()) {
            System.out.println("No visitor records found");
        } else {
            visitors.sort(Comparator.comparingInt(v -> v.visitorId));
            for (Visitor2 v : visitors) {
                System.out.println(v);
            }
        }

        sc.close();
    }
}
