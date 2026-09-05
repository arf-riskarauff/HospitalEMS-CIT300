# Mini Hospital Emergency Management System

**Module:** CIT300 - Data Structures and Algorithms
**Assignment:** Individual Mid Assignment
**Student:** A.R. Fathima Riska (23DA2-1137)

## Overview
A console-based Java application simulating a hospital's emergency management
process using four core data structures.

## Data Structures Used

| Feature | Data Structure | Class |
|---|---|---|
| Patient Records | Binary Search Tree (BST), keyed by Patient ID | `PatientBST.java` |
| Emergency Waiting List | Queue (FIFO) | `EmergencyQueue.java` |
| Treatment History | Stack (LIFO) | `TreatmentStack.java` |
| Patient Visit History | Singly Linked List | `VisitLinkedList.java` |

## Project Structure
```
HospitalEMS/
 ├── src/
 │   ├── Main.java
 │   ├── Patient.java
 │   ├── PatientBST.java
 │   ├── EmergencyQueue.java
 │   ├── TreatmentRecord.java
 │   ├── TreatmentStack.java
 │   ├── Visit.java
 │   └── VisitLinkedList.java
 └── README.md
```

## How to Compile & Run
```bash
cd src
javac *.java -d ../out
cd ../out
java Main
```

## Features
- **Patient Records (BST):** insert, search, delete, in-order traversal (ascending Patient ID)
- **Emergency Queue:** enqueue, dequeue, display waiting list, empty-queue handling
- **Treatment Stack:** push, pop, display history, empty-stack handling
- **Visit History (Linked List):** add visit, remove visit, search visit, display history (per patient)

## Notes
- Each patient record includes: Patient ID, Name, Age, Contact Number, Medical Condition.
- Each visit record includes: Visit ID, Visit Date, Doctor Name, Diagnosis, Treatment.
- A patient must exist in the BST before being added to the Emergency Queue,
  having a treatment pushed to the stack, or having visits added to their history.
