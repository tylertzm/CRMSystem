import java.util.ArrayList;
import java.util.Scanner;

public class KundeTest {
    
    public static void main(String[] args) {
        
        Kunde kunde1 = new Kunde(1, 25, 22.5, 2, true, "male", "southwest", 15000);
        Kunde kunde2 = new Kunde(2, 40, 27.8, 3, false, "female", "southeast", 30000);
        Kunde kunde3 = new Kunde(3, 30, 24.1, 1, false, "female", "northeast", 20000);
        Kunde kunde4 = new Kunde(4, 55, 29.4, 0, true, "male", "northwest", 35000);
        Kunde kunde5 = new Kunde(5, 22, 20.2, 0, false, "female", "southwest", 18000);
        ArrayList<Kunde> Kundelist = new ArrayList<>();
        Kundelist.add(kunde1);
        Kundelist.add(kunde2);
        Kundelist.add(kunde3);
        Kundelist.add(kunde4);
        Kundelist.add(kunde5);

        
        Scanner scanner = new Scanner(System.in);
        System.out.println(
        "CRM SYSTEM \n" +
        "Choose the options below to access your database\n" +
        "0. Close CRM system.\n" +
        "1. Show Customers\n" +
        "2. Sort Customers by\n" +
        "3. Add new customer\n" +
        "4. Delete existing customer\n" +
        "5. Search for a customer"
        );
        
        int choice = scanner.nextInt();
        while (choice != 0) {
            
            switch (choice) {
            
            case 1: {
                if (Kundelist.size() == 0) { 
                    System.out.println("empty");
                } else {
                    Kunde.printKunde(Kundelist);;
                }
                break;  // Add this break statement to prevent fall-through
            }
            
            case 2: {
            	
            	System.out.println("What do you want to sort the data by?\n"  +"1. Alter"+ "\n2.BMI");
            	choice = scanner.nextInt();
            	switch (choice) {
				case 1: {
				Kundelist=	Kunde.sortAge(Kundelist);
					Kunde.printKunde(Kundelist);
					break;
					
				}
				case 2:{
					Kunde.sortBMI(Kundelist);
					Kundelist=	Kunde.sortAge(Kundelist);
					Kunde.printKunde(Kundelist);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
            	break;
            }
            
            case 3: {
                System.out.println("ID: ");
                int id = scanner.nextInt();
                System.out.println("Alter (int): ");
                int alter = scanner.nextInt();
                System.out.println("BMI (double): ");
                double bmi = scanner.nextDouble();
                System.out.println("Anzahl der Kinder (int): ");
                int akinder = scanner.nextInt();
                System.out.println("Raucherstatus (true/false): ");
                boolean raucherstatus = scanner.nextBoolean();
                scanner.nextLine();  
                System.out.println("Geschlecht (male/female): ");
                String geschlecht = scanner.nextLine();  
                System.out.println("Region (string): ");
                String region = scanner.nextLine();
                System.out.println("Einnahmen (int): ");
                int einnahmen = scanner.nextInt();
                
                Kunde kunde = new Kunde(id, alter, bmi, akinder, raucherstatus, geschlecht, region, einnahmen);
                Kundelist.add(kunde);
                
                System.out.println("Customer added!");
                
                break;  
            }

            case 4: {
            	System.out.println("State the ID of the customer you want to delete.");
            	int id = scanner.nextInt();
            	Kunde.deleteKunde(Kundelist, id);
  
            	break;  
            }
            
            case 5: {
            	
            	System.out.println("Please enter the ID of the customer you want to search for");
            	int search  = scanner.nextInt();
            	Kunde.SearchbyName(Kundelist, search);
            	break;

            }
            
            default:
                throw new IllegalArgumentException("Unexpected value: " + choice + ", try again");
            }
            
            System.out.println(
            "Choose the options below to access your database\n" +
            "0. Close CRM system.\n" +
            "1. Show Customers\n" +
            "2. Sort Customers by\n" +
            "3. Add new customer\n" +
            "4. Delete existing customer"
            );
            choice = scanner.nextInt();
        }

        System.out.println("CRM system closed.");
        scanner.close();  
    }
}
