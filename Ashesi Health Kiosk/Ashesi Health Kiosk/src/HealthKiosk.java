
import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) throws Exception {
       
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the service code(P/T/L/C):");
        String letter = sc.next();

       switch (letter.toUpperCase()) {
        case "P":
        System.out.println("Go to the pharmacy Desk");break;
        
        case "L":
        System.out.println("Go to the Lab Desk");break;

        case "C":
        System.out.println("Go to the Counselling Desk");break;

        case "T":
        System.out.println("Go to the Triage Desk");
            break;
       
        default:
        System.out.println("Invalid Service Code");
            break;

       }
     double roundedbmi = 0;
     int metricValue = 0;
     
     if ("T".equals(letter.toUpperCase())){
        System.out.print("""
    Enter 1 for BMI
    Enter 2 for dosage rounder
    Enter 3 for trig calculation:
    """);
        int metric = sc.nextInt();
        if (metric == 1){
            System.out.print("enter the weight");
        
            double weight = sc.nextInt();
            System.out.print("enter the height");
            double height = sc.nextDouble();
            double bmi = weight/height*height;
            roundedbmi = Math.round(bmi*10)/10;
            System.out.println("your BMI is" + roundedbmi);
            if (roundedbmi<18.5){
                System.out.println("Underweight");
            } else if (roundedbmi>=18.5 && roundedbmi<24.9){
                System.out.println("Normal ");
            } else if (roundedbmi>= 30){
                System.out.println("Obese");
            }
            
            metricValue = (int)roundedbmi;
        }       
        if (metric == 2){
            System.out.print("enter the dosage:");
            double dosage = sc.nextDouble();
            double numberOfTablets = Math.ceil(dosage/250);
            System.out.println("the number of tablets is " + numberOfTablets);
            metricValue = (int)numberOfTablets;
        }
        if (metric == 3) {
            System.out.print("Enter the angle in degrees:");
            double angle = sc.nextDouble();
            System.out.println("the sin of the angle is " + Math.round(Math.sin(Math.toRadians(angle))*1000) + "And  the cos of the angle is " + Math.round(Math.cos(Math.toRadians(angle))*1000));
            metricValue = (int)Math.round(Math.sin(Math.toRadians(angle))*1000);
        } 
        if (metric!=1 && metric!= 2 && metric!=3){
            System.out.println("enter a valid input");
        } 
        }
     


       char idletter = (char)Math.rint(((Math.random() * 26)+ 65));
       int idnumber1 = (int)((Math.random()*6)+3);
       int idnumber2 = (int)((Math.random()*6)+3);
       int idnumber3 = (int)((Math.random()*6)+3);
       int idnumber4 = (int)((Math.random()*6)+3);
       String id = idletter+"" + idnumber1+idnumber2+idnumber3+idnumber4;

       System.out.println(id);
       if (id.length() != 5) {
            System.out.println("Invalid length");
        } else if (!Character.isLetter(id.charAt(0))) {
            System.out.println("Invalid: first char must be a letter");
        } else if (!(Character.isDigit(id.charAt(1)) &&
                    Character.isDigit(id.charAt(2)) &&
                    Character.isDigit(id.charAt(3)) &&
                    Character.isDigit(id.charAt(4)))) {
            System.out.println("Invalid: last 4 must be digits");
        } else {
            System.out.println("ID OK: " + id);
        }

       System.out.print("Enter your first name: ");
       String firstName = sc.next();
       String fn = firstName.toUpperCase();
       char base = (fn.charAt(0));

       char shifted = (char)('A' + (base - 'A' + 2) % 26);

       String lastTwo = id.substring(id.length() - 2);

       String displayCode = shifted + lastTwo + "-" + metricValue;

       System.out.println("Display Code: " + displayCode);

       String serviceName = "";
       switch (letter.toUpperCase()) {
          case "P":
          serviceName = "PHARMACY";
          break;
          case "L":
        serviceName = "LAB";
        break;
          case "C":
        serviceName = "COUNSELING";
        break;
          case "T":
         serviceName = "TRIAGE";
        break;
        default:
        serviceName = "UNKNOWN";
}


      String summary = serviceName + " | ID=" + id;

      if (serviceName.equals("TRIAGE")) {
         summary += " | BMI=" + roundedbmi; 
        }
        summary += " | Code=" + displayCode;
        System.out.println("Summary: " + summary);

     }

    
}

