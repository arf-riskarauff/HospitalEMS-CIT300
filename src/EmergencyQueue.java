public class EmergencyQueue {
    private class QNode {
        Patient patient;
        QNode next;

        QNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QNode front, rear;
    private int size;

    public EmergencyQueue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(Patient patient) {
        QNode newNode = new QNode(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.name + " (ID: " + patient.patientId + ") added to emergency queue.");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty. No patient to treat.");
            return null;
        }
        Patient treated = front.patient;
        front = front.next;
        if (front == null) rear = null;
        size--;
        System.out.println("Patient " + treated.name + " (ID: " + treated.patientId + ") is now being treated (dequeued).");
        return treated;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting in the emergency queue.");
            return;
        }
        System.out.println("---- Patients Waiting in Emergency Queue (Front to Rear) ----");
        QNode current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }
}
