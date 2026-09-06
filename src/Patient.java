public class Patient {
    int patientId;
    String name;
    int age;
    String contactNumber;
    String medicalCondition;
    VisitLinkedList visitHistory;

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                " | Name: " + name +
                " | Age: " + age +
                " | Contact: " + contactNumber +
                " | Condition: " + medicalCondition;
    }
}
