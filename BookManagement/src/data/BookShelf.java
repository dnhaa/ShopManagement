package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BookShelf {

    private List<Book> arr = new ArrayList();
    private Scanner sc = new Scanner(System.in);
    
    

    public BookShelf() {
        arr.add(new Book(1111111111, "BAC HANH TAP LUC", 100, "TG01"));
        arr.add(new Book(2222222222L, "XUAN HUONG THI TAP", 10003.54, "TG02"));
        arr.add(new Book(5555555555L, "LAO HAC", 500, "TG05"));
        arr.add(new Book(6666666666L, "HOA DOC CHIEN HAO", 600, "TG06"));
    }

    //1. Show the book list
    public void showBookList() {
        List<String> authorNameArr= getAuthorName();
        System.out.printf("|%-5s|%-10s|%-20s|%-11s|%-9s|%-15s|\n", "Book", "ISBN", "TITLE", "PRICE", "AUTHOR ID", "AUTHOR NAME");
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("|%-5s|%10d|%-20s|%11.2f|%9s|", "Book", arr.get(i).getISBN(), arr.get(i).getTitle(), arr.get(i).getPrice(), arr.get(i).getAuthorID());
            System.out.println(authorNameArr.get(i) + "|");
            
        }
    }

    //2. Add new books
    public void addANewBook() {
        long ISBN;
        String title;
        double price;
        String authorID;
        
        while (true) {
            ISBN = MyToys.getAPositiveLong("Input ISBN (10-digit format): ");
            if (searchABook(ISBN) == null)
                break;
            System.out.println("ISBN cannot be duplicated!");
        }
        title = MyToys.getAString("Input title: ");
        price = MyToys.getAPositiveDouble("Input price: ");
        authorID = checkAuthorID("Input author ID: ");

        arr.add (new Book(ISBN, title, price, authorID));
        System.out.println("Book added!");
    }

    
    public Book searchABook(long ISBN) {

        for (Book book : arr) {
            if (book.getISBN() == (ISBN)) {
                return book;
            }
        }
        return null;
    }

    
    public List<Book> searchABookTitle(String title) {
        List<Book> bookArrToSearch = new ArrayList();

        for (Book book : arr) {
            if (book.getTitle().contains(title)) {
                bookArrToSearch.add(book);
            }
        }
        return bookArrToSearch;
    }
    
        
    //5. Search a book
    public void searchABook() {
        if (arr.isEmpty()) {
            System.out.println("The list of books is empty.");
            return;
        }
        String title = MyToys.getAString("Input the book's title: ");
        List<Book> bookInSearch = searchABookTitle(title);
        if (bookInSearch.isEmpty()) {
            System.out.println("No book is matched!");
        } else {
            System.out.println("BOOK FOUND!");
            System.out.printf("|%-5s|%-10s|%-20s|%-11s|%-9s|\n", "Book", "ISBN", "TITLE", "PRICE", "AUTHOR ID");
            for (Book book : bookInSearch) {
                book.showBook();
            }
        }

    }
    
    
    //3. Update book
    public void updateABook() {
        if (arr.isEmpty()) {
            System.out.println("The list of books is empty.");
            return;
        }
        long ISBN = MyToys.getAPositiveLong("Input the book's ISBN to update (10-digit format): ");
        Book bookToUpdate = searchABook(ISBN);
        if (bookToUpdate == null) {
            System.out.println("This book ISBN does not exist!");
        } else {
            bookToUpdate.setTitle(MyToys.getAStringUpdate("Input new title, \"ENTER\" to skip: ", bookToUpdate.getTitle()));
            bookToUpdate.setPrice(MyToys.getAPositiveDoubleUpdate("Input new price, \"ENTER\" to skip: ", bookToUpdate.getPrice()));
            bookToUpdate.setAuthorID(checkAuthorIDUpdate("Input new author ID, \"ENTER\" to skip: ", bookToUpdate.getAuthorID())); 
            System.out.println("BOOK UPDATED SUCCESSFULLY!");
        }
    }

    
    //4. Delete a book
    public void deleteABook() {
        if (arr.isEmpty()) {
            System.out.println("The list of books is empty.");
            return;
        }
        long ISBN = MyToys.getAPositiveLong("Input the book's ISBN to delete (10-digit format): ");
        Book bookToDelete = searchABook(ISBN);
        if (bookToDelete == null) {
            System.out.println("This book ISBN does not exist!");
        } else {
            System.out.println("BOOK FOUND!");
            if (MyToys.chooseOneOrZero("Press 1 to confirm deletion, 0 to return: ") == 1) {
                arr.remove(bookToDelete);
                System.out.println("BOOK REMOVED SUCCESSFULLY!");
        }
            else
                System.out.println("NO BOOK WAS REMOVED!");
        }
    }
    
    
    //6. Store data to file
    public void storeToTextFile() {
        
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("book.dat"));
            out.printf("|%-5s|%-10s|%-20s|%-11s|%-9s|\n", "Book", "ISBN", "TITLE", "PRICE", "AUTHOR ID");
            for (Book book : arr) {
                //out.write(book + System.lineSeparator());
                out.printf("|%-5s|%10d|%-20s|%11.2f|%9s|\n", "Book", book.getISBN(), book.getTitle(), book.getPrice(), book.getAuthorID());
            }
            System.out.println("INFORMATION SAVED TO FILE SUCCESSFULLY!");
        } catch (IOException e) {
            System.out.println("UNABLE TO STORE DATA TO TEXT FILE.");
        } finally {
            if (out != null) {
                System.out.println("Closing file");
                out.close();
            } else {
                System.out.println("File not open");
            }
        }
    }
    
    
    public List<String> getAuthorIDList() {
        List <Author> authorArr = new ArrayList();
        String authorID;
        String name;
        try {
            File f = new File("D:\\\\summer2021\\\\lab\\\\lab2\\\\author.dat");
            if (!f.exists()) {
                return null;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String detail;
            while ((detail = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(detail, ";");
                authorID = stk.nextToken().toUpperCase();
                name = stk.nextToken().toUpperCase();
                Author anAuthor = new Author(authorID, name);
                authorArr.add(anAuthor);
            }
            bf.close();
            fr.close();
            List <String> authorIDList = new ArrayList();
            for (Author author : authorArr) {
                authorIDList.add(author.getAuthorID());
            }
            return authorIDList;
        } catch (Exception e) {
            System.out.println("File not found!");
        }
        return null;
    }
    
        public List<String> getAuthorName() {
        List <Author> authorArr = new ArrayList();
        String authorID;
        String name;
        try {
            File f = new File("D:\\\\summer2021\\\\lab\\\\lab2\\\\author.dat");
            if (!f.exists()) {
                return null;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String detail;
            while ((detail = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(detail, ";");
                authorID = stk.nextToken().toUpperCase();
                name = stk.nextToken().toUpperCase();
                Author anAuthor = new Author(authorID, name);
                authorArr.add(anAuthor);
            }
            bf.close();
            fr.close();
            List <String> authorIDList = new ArrayList();
            for (Author author : authorArr) {
                authorIDList.add(author.getName());
            }
            return authorIDList;
        } catch (Exception e) {
            System.out.println("File not found!");
        }
        return null;
    }
    
    
    public String checkAuthorID(String msg) {
        String authorID;
        while (true) {
        authorID = MyToys.getAString(msg);
        int check = -1;
        List<String> tmp = getAuthorIDList();
            for (String string : tmp) {
                if (string.equalsIgnoreCase(authorID)) {
                    check = 0;
                } 
            }
            if (check == 0)
                break;
            System.out.println("Author ID does not exist in the author list!");        
        }
        return authorID;
    }
    
    
    public String checkAuthorIDUpdate(String msg, String previousAuthorID) {
        String authorID;
        while (true) {
        authorID = MyToys.getAStringUpdate(msg, previousAuthorID);
        int check = -1;
        List<String> tmp = getAuthorIDList();
            for (String string : tmp) {
                if (string.equalsIgnoreCase(authorID)) {
                    check = 0;
                } 
            }
            if (check == 0)
                break;
            System.out.println("Author does not exist in the author list!");        
        }
        return authorID;
    }
    
    
}
