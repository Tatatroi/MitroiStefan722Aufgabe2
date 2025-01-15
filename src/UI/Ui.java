package UI;

import CONTROLLER.Controller;
import Model.Medikamente;
import Model.Patienten;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private static final Scanner scanner = new Scanner(System.in);
    private static Controller controller = null;
    public Ui(Controller controller){
        Ui.controller = controller;
    }

    public void start(){
        while (true) {
            System.out.println("\nSports Store Management System");
            System.out.println("1. Manage Medicament's");
            System.out.println("2. Manage Patients");
            System.out.println("3. Filter patients by diagnose");
            System.out.println("4  Filter Patients by medicament");
            System.out.println("5. Sort Medicament's by Price");
            System.out.println("6. Add products to Customer");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manageMedicaments();
                    break;
                case 2:
                    manageCustomers();
                    break;
                case 3:
                    filterPatientByDiagnose();
                    break;
                case 4:
                    filterByKrankenheit();
                    break;
                case 5:
                    sortByPrice();
                    break;
                case 6:
                    addMedicamentToCustomer();
                case 7:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageMedicaments() {
        while (true) {
            System.out.println("\nMedicament Management");
            System.out.println("1. Add Medicament");
            System.out.println("2. View Medicament's");
            System.out.println("3. Update Medicament");
            System.out.println("4. Delete Medicament");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter med name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter med price: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter med hospital: ");
                    String hospital = scanner.nextLine();
                    controller.createMedicament(name, price, hospital);
                    System.out.println("Medicament added successfully.");
                    break;
                case 2:
                    System.out.println("\nMedicament's List:");
                    controller.getAllMedikamente().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter the name of the med to update: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Enter new price: ");
                    Integer price2 = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter new hospital: ");
                    String hospital2 = scanner.nextLine();

                    controller.updateMedikament(updateName,price2,hospital2);
                    System.out.println("Medicament updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter the name of the medicament to delete: ");
                    String deleteName = scanner.nextLine();
                    controller.deleteMedicament(deleteName);
                    System.out.println("Medicament deleted successfully.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageCustomers() {
        while (true) {
            System.out.println("\nPatients Management");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
//                    System.out.print("Enter patient ID: ");
//                    int id = Integer.parseInt(scanner.nextLine());
//
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter patient age: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter patient diagnose: ");
                    String diagnose = scanner.nextLine();

                    List<Medikamente> medikamenteList = new ArrayList<>();
                    controller.createPatient(name,age,diagnose,medikamenteList);
                    System.out.println("Customer added successfully.");
                    break;
                case 2:
                    System.out.println("\nPatient Med List:");
                    controller.getAllPatienten().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter the ID of the patient to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new diagnose: ");
                    String newDiagnose = scanner.nextLine();

                    controller.updatePatient(updateId,newName,newAge,newDiagnose);

                    System.out.println("Patient updated successfully.");

                    break;
                case 4:
                    System.out.print("Enter the ID of the patient to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    controller.deletePatient(deleteId);
                    System.out.println("Customer deleted successfully.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void filterPatientByDiagnose(){
        System.out.print("Enter diagnose for filtering: ");
        String diagnose = scanner.nextLine();
        List<Patienten>pt = controller.filterByDiagnose(diagnose);
        pt.forEach(System.out::println);
    }

    public static void filterByKrankenheit(){
        System.out.print("Enter hospital to filter meds: ");
        String hosiptal = scanner.nextLine();
        List<Patienten>pt = controller.filterByKrankenheit(hosiptal);
        pt.forEach(System.out::println);
    }

    public static void sortByPrice(){
        System.out.println("Enter the type of filtering, asc for 'ascending', desc for 'descending': ");
        String type = scanner.nextLine();
        System.out.println("Enter the id for the patient you want to sort meds: ");
        int idClient = Integer.parseInt(scanner.nextLine());
        List<Medikamente> md = new ArrayList<>();
        switch (type){
            case "asc" -> md = controller.sortByPrice(idClient,"asc");
            case "desc" -> md = controller.sortByPrice(idClient,"desc");
        }
        md.forEach(System.out::println);
    }
    public void addMedicamentToCustomer(){

    }


}
