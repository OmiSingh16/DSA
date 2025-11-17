import java.util.*;

class Visitor1 {
    int visitorId;
    String visitorName;
    String contactNumber;
    String visitPurpose;
    String employeeToMeet;
    String visitTime;

    public Visitor1(int visitorId, String visitorName, String contactNumber,
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

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Visitor1> list = new ArrayList<>();

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("\nAvailable Commands: INSERT, UPDATE, DELETE, DISPLAY\n");

        for (int i = 0; i < n; i++) {
            String command = sc.next().toUpperCase();

            switch (command) {
                case "INSERT":
                    System.out.print("Enter Visitor ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Visitor Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter Visit Purpose: ");
                    String purpose = sc.nextLine();
                    System.out.print("Enter Employee to Meet: ");
                    String employee = sc.nextLine();
                    System.out.print("Enter Visit Time: ");
                    String time = sc.nextLine();

                    list.add(new Visitor1(id, name, contact, purpose, employee, time));
                    System.out.println(" Visitor added successfully!\n");
                    break;

                case "UPDATE":
                    System.out.print("Enter Visitor ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Visit Purpose: ");
                    String newPurpose = sc.nextLine();
                    boolean updated = false;
                    for (Visitor1 v : list) {
                        if (v.visitorId == uid) {
                            v.visitPurpose = newPurpose;
                            updated = true;
                            break;
                        }
                    }
                    if (updated)
                        System.out.println(" Visitor record updated!\n");
                    else
                        System.out.println("  Visitor ID not found.\n");
                    break;

                case "DELETE":
                    System.out.print("Enter Visitor ID to delete: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    boolean removed = list.removeIf(v -> v.visitorId == did);
                    if (removed)
                        System.out.println(" Visitor record deleted!\n");
                    else
                        System.out.println("  Visitor ID not found.\n");
                    break;

                case "DISPLAY":
                    System.out.println("\n📋 Current Visitor Records:");
                    if (list.isEmpty()) {
                        System.out.println("No visitor records found.\n");
                    } else {
                        list.sort(Comparator.comparingInt(v -> v.visitorId));
                        for (Visitor1 v : list) {
                            System.out.println(v);
                        }
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("❌ Invalid Command. Try again.\n");
            }
        }

        System.out.println("Program execution completed ✅");
        sc.close();
    }
}
