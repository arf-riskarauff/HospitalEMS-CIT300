public class TreatmentRecord {
    int patientId;
    String patientName;
    String treatmentGiven;
    String dateCompleted;

    public TreatmentRecord(int patientId, String patientName, String treatmentGiven, String dateCompleted) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentGiven = treatmentGiven;
        this.dateCompleted = dateCompleted;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                " | Name: " + patientName +
                " | Treatment: " + treatmentGiven +
                " | Completed On: " + dateCompleted;
    }
}
