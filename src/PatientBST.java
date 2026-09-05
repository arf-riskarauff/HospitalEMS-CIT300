public class PatientBST {
    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node node, Patient patient) {
        if (node == null) {
            return new Node(patient);
        }
        if (patient.patientId < node.patient.patientId) {
            node.left = insertRec(node.left, patient);
        } else if (patient.patientId > node.patient.patientId) {
            node.right = insertRec(node.right, patient);
        } else {
            System.out.println("Patient ID " + patient.patientId + " already exists. Insert skipped.");
        }
        return node;
    }

    public Patient search(int patientId) {
        Node result = searchRec(root, patientId);
        return (result == null) ? null : result.patient;
    }

    private Node searchRec(Node node, int patientId) {
        if (node == null || node.patient.patientId == patientId) {
            return node;
        }
        if (patientId < node.patient.patientId) {
            return searchRec(node.left, patientId);
        } else {
            return searchRec(node.right, patientId);
        }
    }

    public void delete(int patientId) {
        if (search(patientId) == null) {
            System.out.println("Patient ID " + patientId + " not found. Cannot delete.");
            return;
        }
        root = deleteRec(root, patientId);
        System.out.println("Patient ID " + patientId + " deleted successfully.");
    }

    private Node deleteRec(Node node, int patientId) {
        if (node == null) return null;

        if (patientId < node.patient.patientId) {
            node.left = deleteRec(node.left, patientId);
        } else if (patientId > node.patient.patientId) {
            node.right = deleteRec(node.right, patientId);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node successor = findMin(node.right);
            node.patient = successor.patient;
            node.right = deleteRec(node.right, successor.patient.patientId);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }
        System.out.println("---- Patient Records (Ascending Patient ID) ----");
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.patient);
            inOrderRec(node.right);
        }
    }
}
