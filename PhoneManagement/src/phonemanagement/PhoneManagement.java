
package phonemanagement;
        
import data.Cabinet;
import java.io.IOException;
import util.MyToys;

public class PhoneManagement {
    public static void main(String[] args) throws IOException {
        Cabinet phoneArr = new Cabinet();
        int choice;
        do {            
            printMenu();
            choice = MyToys.getAPositiveInt("Choose an option from 1..6: ");
            switch(choice) {
                case 1:
                    while(true) {
                    phoneArr.addAPhone();
                    int n = MyToys.chooseOneOrZero("Press 1 to add another phone, 0 to return to menu: ");
                    if (n == 0)
                        break;
                    }
                    break;
                case 2:
                    while(true) {
                    phoneArr.searchAPhone();
                    int n = MyToys.chooseOneOrZero("Press 1 to search another phone, 0 to return to menu: ");
                    if (n == 0)
                        break;
                    }
                    break;
                case 3:
                    while(true) {
                    phoneArr.removeAPhone();
                    int n = MyToys.chooseOneOrZero("Press 1 to remove another phone, 0 to return to menu: ");
                    if (n == 0)
                        break;
                    }
                    break;
                case 4:
                    while(true) {
                    phoneArr.printPhoneListDescendingModel();
                    int n = MyToys.chooseOneOrZero("Press 1 to print list again, 0 to return to menu: ");
                    if (n == 0)
                        break;
                    }
                    break;
                case 5: 
                    while(true) {
                    phoneArr.storeToTextFile();
                    int n = MyToys.chooseOneOrZero("Press 1 to save to file again, 0 to return to menu: ");
                    if (n == 0)
                        break;
                    }
                    break;
                case 6:
                    System.out.println("Thank you and goodbye!");
                    break;
                default:
                    System.out.println("Out of bound! Please choose from 1..6!");
                    break;
            }
        } while (choice != 6);
    }
    
    
    //Function to print Menu
    public static void printMenu() {
        System.out.println("\nWelcome to HKT Store - @ 2021 by <SE161779 - Do Ngan Ha>");
        System.out.println("Select the options belows:");
        System.out.println("1. Add a phone");
        System.out.println("2. Search a phone by model");
        System.out.println("3. Remove the phone by model");
        System.out.println("4. Print the phone list in the descending order of Model");
        System.out.println("5. Store the phone list to text file");
        System.out.println("6. Quit");   
    }
}
