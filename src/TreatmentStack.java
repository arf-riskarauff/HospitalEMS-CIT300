public class TreatmentStack {
    private class SNode {
        TreatmentRecord record;
        SNode next;

        SNode(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private SNode top;
    private int size;

    public TreatmentStack() {
        top = null;
        size = 0;
    }

    public void push(TreatmentRecord record) {
        SNode newNode = new SNode(record);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Treatment record for Patient ID " + record.patientId + " pushed to stack.");
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty. No record to remove.");
            return null;
        }
        TreatmentRecord removed = top.record;
        top = top.next;
        size--;
        System.out.println("Most recent treatment record (Patient ID " + removed.patientId + ") removed from stack.");
        return removed;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }
        System.out.println("---- Treatment History (Most Recent First) ----");
        SNode current = top;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.record);
            current = current.next;
            position++;
        }
    }
}
