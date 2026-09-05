import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    public static void main(String[] args) {
        int choice;
        do {
            printMainMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> patientMenu();
                case 2 -> queueMenu();
                case 3 -> stackMenu();
                case 4 -> visitHistoryMenu();
                case 0 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    private static void printMainMenu() {
        System.out.println("\n===== MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM =====");
        System.out.println("1. Patient Records (BST)");
        System.out.println("2. Emergency Patient Queue (Queue)");
        System.out.println("3. Treatment History (Stack)");
        System.out.println("4. Patient Visit History (Linked List)");
        System.out.println("0. Exit");
    }

    private static void patientMenu() {
        int choice;
        do {
            System.out.println("\n---- Patient Records Menu ----");
            System.out.println("1. Insert Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients (In-order)");
            System.out.println("0. Back to Main Menu");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> insertPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> patientBST.displayInOrder();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void insertPatient() {
        int id = readInt("Enter Patient ID: ");
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        int age = readInt("Enter Age: ");
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = sc.nextLine();

        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
        System.out.println("Patient added successfully.");
    }

    private static void searchPatient() {
        int id = readInt("Enter Patient ID to search: ");
        Patient found = patientBST.search(id);
        if (found != null) {
            System.out.println("Patient Found: " + found);
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    private static void deletePatient() {
        int id = readInt("Enter Patient ID to delete: ");
        patientBST.delete(id);
    }

    private static void stackMenu() {
        int choice;
        do {
            System.out.println("\n---- Treatment History Menu ----");
            System.out.println("1. Push Completed Treatment");
            System.out.println("2. Pop Most Recent Treatment");
            System.out.println("3. Display Treatment History");
            System.out.println("0. Back to Main Menu");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> pushTreatment();
                case 2 -> treatmentStack.pop();
                case 3 -> treatmentStack.display();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void queueMenu() {
        int choice;
        do {
            System.out.println("\n---- Emergency Patient Queue Menu ----");
            System.out.println("1. Add Patient to Queue (Enqueue)");
            System.out.println("2. Treat Next Patient (Dequeue)");
            System.out.println("3. Display Waiting Patients");
            System.out.println("0. Back to Main Menu");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> enqueuePatient();
                case 2 -> emergencyQueue.dequeue();
                case 3 -> emergencyQueue.display();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void enqueuePatient() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found in records.");
            return;
        }
        emergencyQueue.enqueue(patient);
    }
    private static void pushTreatment() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found in records.");
            return;
        }
        System.out.print("Enter Treatment Given: ");
        String treatment = sc.nextLine();
        System.out.print("Enter Completion Date (e.g. 2026-09-05): ");
        String date = sc.nextLine();

        TreatmentRecord record = new TreatmentRecord(patient.patientId, patient.name, treatment, date);
        treatmentStack.push(record);
    }

    private static void visitHistoryMenu() {
        int choice;
        do {
            System.out.println("\n---- Patient Visit History Menu ----");
            System.out.println("1. Add Visit");
            System.out.println("2. Remove Visit");
            System.out.println("3. Search Visit");
            System.out.println("4. Display Visit History");
            System.out.println("0. Back to Main Menu");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addVisit();
                case 2 -> removeVisit();
                case 3 -> searchVisit();
                case 4 -> displayVisitHistory();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static Patient getPatientForVisit() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found in records.");
        }
        return patient;
    }

    private static void addVisit() {
        Patient patient = getPatientForVisit();
        if (patient == null) return;

        int visitId = readInt("Enter Visit ID: ");
        System.out.print("Enter Visit Date: ");
        String date = sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = sc.nextLine();

        Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
        patient.visitHistory.addVisit(visit);
    }

    private static void removeVisit() {
        Patient patient = getPatientForVisit();
        if (patient == null) return;

        int visitId = readInt("Enter Visit ID to remove: ");
        patient.visitHistory.removeVisit(visitId);
    }

    private static void searchVisit() {
        Patient patient = getPatientForVisit();
        if (patient == null) return;

        int visitId = readInt("Enter Visit ID to search: ");
        Visit found = patient.visitHistory.searchVisit(visitId);
        if (found != null) {
            System.out.println("Visit Found: " + found);
        } else {
            System.out.println("Visit ID " + visitId + " not found for this patient.");
        }
    }

    private static void displayVisitHistory() {
        Patient patient = getPatientForVisit();
        if (patient == null) return;
        patient.visitHistory.displayHistory();
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print(prompt);
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }
}
