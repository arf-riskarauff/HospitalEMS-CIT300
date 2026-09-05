public class VisitLinkedList {
    private class LNode {
        Visit visit;
        LNode next;

        LNode(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private LNode head;
    private int size;

    public VisitLinkedList() {
        head = null;
        size = 0;
    }

    public void addVisit(Visit visit) {
        LNode newNode = new LNode(visit);
        if (head == null) {
            head = newNode;
        } else {
            LNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Visit ID " + visit.visitId + " added to patient's visit history.");
    }

    public boolean removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history available to remove from.");
            return false;
        }

        if (head.visit.visitId == visitId) {
            head = head.next;
            size--;
            System.out.println("Visit ID " + visitId + " removed from history.");
            return true;
        }

        LNode current = head;
        while (current.next != null && current.next.visit.visitId != visitId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Visit ID " + visitId + " not found in history.");
            return false;
        }

        current.next = current.next.next;
        size--;
        System.out.println("Visit ID " + visitId + " removed from history.");
        return true;
    }

    public Visit searchVisit(int visitId) {
        LNode current = head;
        while (current != null) {
            if (current.visit.visitId == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }

    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history found for this patient.");
            return;
        }
        System.out.println("---- Visit History ----");
        LNode current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.visit);
            current = current.next;
            position++;
        }
    }

    public int getSize() {
        return size;
    }
}
