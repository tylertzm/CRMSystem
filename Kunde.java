import java.util.ArrayList;

public class Kunde {
    private int ID;
    private int Alter;
    private double BMI;
    private int Anzahl_der_Kinder;
    private boolean Raucherstatus;   
    private String Geschlecht;     
    private String Region;
    private int Einnahmen;
    


    public Kunde(int ID, int Alter, double BMI, int Anzahl_der_Kinder, boolean Raucherstatus, String Geschlecht, String Region, int Einnahmen) {
        this.ID = ID;
        this.Alter = Alter;
        this.BMI = BMI;
        this.Anzahl_der_Kinder = Anzahl_der_Kinder;
        this.Raucherstatus = Raucherstatus;
        this.Geschlecht = Geschlecht;
        this.Region = Region;
        this.Einnahmen = Einnahmen;
    }
    
    public static void printKunde(ArrayList<Kunde> kundenList) {
        System.out.printf("%-5s %-7s %-6s %-10s %-15s %-10s %-10s %-10s%n", 
                "ID", "Alter", "BMI", "Kinder", "Raucherstatus", "Geschlecht", "Region", "Einnahmen");

        for (Kunde kunde : kundenList) {
            System.out.println(kunde);
        }
    }
    
    @Override
    public String toString() {
        return String.format("%-5d %-7d %-6.2f %-10d %-15s %-10s %-10s %-10d",
                ID, Alter, BMI, Anzahl_der_Kinder, (Raucherstatus ? "Ja" : "Nein"), Geschlecht, Region, Einnahmen);
    }
    
    public static ArrayList<Kunde> sortAge(ArrayList<Kunde> kundelist) {
    	
    	for (int j = 0; j < kundelist.size(); j++) {

		for(int i = 0; i < kundelist.size()-1;i++) {
			if(kundelist.get(i).getAlter()> kundelist.get(i+1).getAlter());
			Kunde temp = kundelist.get(i);
			kundelist.get(i).setAlter(i, kundelist.get(i+1));
			kundelist.get(i).setAlter(i, temp);

			
		}
		}
    	return kundelist;
	}
    
    public static ArrayList<Kunde> sortBMI(ArrayList<Kunde> kundelist) {
    	for (int j = 0; j < kundelist.size(); j++) {
    		for(int i = 0; i < kundelist.size()-1;i++) {
    			if(kundelist.get(i).getBMI()> kundelist.get(i+1).getBMI()) {
    				if(kundelist.get(i).getAlter()> kundelist.get(i+1).getAlter());
    				Kunde temp = kundelist.get(i);
    				kundelist.get(i).setBMI(i, kundelist.get(i+1));
    				kundelist.get(i).setAlter(i, temp);
    			}
    			
    		}
		}
    	return kundelist;

	}
    
    public static void SearchbyName(ArrayList<Kunde> kundelist, int id) {
    	for (int j = 0; j < kundelist.size(); j++) {
			if(kundelist.get(j).getID() == id) 	
				id = j;
    	}
		System.out.println(kundelist.get(id).toString()); 

		
	}
    
    public static ArrayList<Kunde> deleteKunde(ArrayList<Kunde> kundelist, int id) {
		for(int i = 0; i < kundelist.size();i++) {
			if(kundelist.get(id-1).getID() == kundelist.get(i).getID()) {
				kundelist.remove(id-1);
			}
		}

		return kundelist;
		
	}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAlter() {
        return Alter;
    }

    public void setAlter(int Alter, Kunde kunde) {
        this.Alter = Alter;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI, Kunde kunde) {
        this.BMI = BMI;
    }

    public int getAnzahl_der_Kinder() {
        return Anzahl_der_Kinder;
    }

    public void setAnzahl_der_Kinder(int Anzahl_der_Kinder) {
        this.Anzahl_der_Kinder = Anzahl_der_Kinder;
    }

    public boolean isRaucherstatus() {
        return Raucherstatus;
    }

    public void setRaucherstatus(boolean Raucherstatus) {
        this.Raucherstatus = Raucherstatus;
    }

    public String isGeschlecht() {
        return Geschlecht;
    }

    public void setGeschlecht(String Geschlecht) {
        this.Geschlecht = Geschlecht;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public int getEinnahmen() {
        return Einnahmen;
    }

    public void setEinnahmen(int Einnahmen) {
        this.Einnahmen = Einnahmen;
    }

}
