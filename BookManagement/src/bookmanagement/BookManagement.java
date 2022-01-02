package bookmanagement;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
import data.BookShelf;
import data.MyToys;


public class BookManagement {

    public static void main(String[] args) {
        BookShelf bookArr = new BookShelf();
        
        int choice;
        do {            
            printMenu();
            choice = MyToys.getAPositiveInt("Choose from 1..7: ");
            switch(choice) {
                case 1:
                    while(true) {
                    bookArr.showBookList();
                    if (MyToys.chooseOneOrZero("Press 1 to show booklist again, 0 to return to Menu: ") == 0)
                        break;
                    }
                    break;
                case 2:
                    while(true) {
                    bookArr.addANewBook();
                    if (MyToys.chooseOneOrZero("Press 1 to add another book, 0 to return to Menu: ") == 0)
                        break;
                    }
                    break;
                case 3:
                    while(true) {
                    bookArr.updateABook();
                    if (MyToys.chooseOneOrZero("Press 1 to update another book, 0 to return to Menu: ") == 0)
                        break;
                    }
                    break;
                case 4:
                    while(true) {
                    bookArr.deleteABook();
                    if (MyToys.chooseOneOrZero("Press 1 to delete another book, 0 to return to Menu: ") == 0)
                        break;
                    }
                    break;
                case 5:
                    while(true) {
                    bookArr.searchABook();
                    if (MyToys.chooseOneOrZero("Press 1 to search another book, 0 to return to Menu: ") == 0)
                        break;
                    }
                case 6:
                    while(true) {
                    bookArr.storeToTextFile();
                    if (MyToys.chooseOneOrZero("Press 1 to store booklist again, 0 to return to Menu: ") == 0)
                        break;
                    }
                    break;
                case 7:
                    System.out.println("Thank you and Goodbye!");
                    break;
                default:
                    System.out.println("Out of bound! Input between 1..7!");
                    break;
            }
        } while (choice != 7);
        
        
    }
    public static void printMenu() {
        System.out.println("\nWelcome to HKT store. @ Copyright <Do Ngan Ha _ SE161779>");
        System.out.println("1. Show the book list");
        System.out.println("2. Add new book");
        System.out.println("3. Update new book");
        System.out.println("4. Delete book");
        System.out.println("5. Search book");
        System.out.println("6. Store data to file");
        System.out.println("7. Quit");
        
    }

}
