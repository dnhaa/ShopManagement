package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import util.MyToys;


public class Cabinet {

    
    private List<Phone> arr = new ArrayList();
    private Scanner sc = new Scanner(System.in);

    
    public Cabinet() {
    }

    
    //1. Add a phone
    public void addAPhone() {
        String model;
        String CPU;
        int RAM;
        String primaryCamera;
        int screenSize;
        double price;
        String color;
        String brand;

        System.out.println("Input phone #" + (arr.size() + 1));
        while (true) {

            model = MyToys.getAString("Input model: ");
            if (searchAPhone(model) == null) {
                break;
            }
            System.out.println("Model cannot be duplicated! Try again!");
        }
        CPU = MyToys.getAString("Input CPU: ");
        RAM = MyToys.getAPositiveInt("Input RAM: ");
        primaryCamera = MyToys.getAString("Input primary camera: ");
        screenSize = MyToys.getAPositiveInt("Input screen size: ");
        price = MyToys.getAPositiveDouble("Input price: ");
        color = MyToys.getAString("Input color: ");
        brand = MyToys.getAString("Input brand: ");
        Phone aNewPhone = new Phone(model, CPU, RAM, primaryCamera, screenSize, price, color, brand);
        arr.add(aNewPhone);
        System.out.println("PHONE ADDED SUCCESSFULLY!");
        aNewPhone.printPhone();
    }

    
    public void printPhoneList() {
        if (arr.isEmpty()) {
            System.out.println("The list of phones is empty.");
            return;
        }
        System.out.printf("|%-15s|%-15s|%-5s|%-14s|%-5s|%-10s|%-8s|%-10s|\n", "MODEL", "CPU", "RAM", "PRIMARY CAMERA", "SCREEN SIZE", "PRICE", "COLOR", "BRAND");
        for (Phone phone : arr) {
            phone.printPhone();
        }
    }


    public Phone searchAPhone(String model) {

        for (Phone phone : arr) {
            if (phone.getModel().equalsIgnoreCase(model)) {
                return phone;
            }
        }
        return null;
    }

    
    //2. Search a phone
    public void searchAPhone() {
        if (arr.isEmpty()) {
            System.out.println("The list of phones is empty.");
            return;
        }
        String model = MyToys.getAString("Input the phone model to search: ");
        Phone phoneInSearch = searchAPhone(model);
        if (phoneInSearch == null) {
            System.out.println("This phone Model does not exist!");
        } else {
            System.out.println("PHONE FOUND!");
            phoneInSearch.printPhone();
        }

    }

    
    //3. Remove a phone
    public void removeAPhone() {
        if (arr.isEmpty()) {
            System.out.println("The list of phones is empty.");
            return;
        }
        String model = MyToys.getAString("Input the phone model to remove: ");
        Phone phoneInSearch = searchAPhone(model);
        if (phoneInSearch == null) {
            System.out.println("PHONE NOT FOUND!");
        } else {
            int tmp = MyToys.chooseOneOrZero("Press 1 to confirm deletion, 0 to return: ");
            if (tmp == 1) {
                arr.remove(phoneInSearch);
                System.out.println("PHONE REMOVED SUCCESSFULLY!");
            } else {
                System.out.println("NO PHONE IS REMOVED.");
            }
        }

    }
    

    //4. Print phone list in the descending order of Model
    public void printPhoneListDescendingModel() {
        if (arr.isEmpty()) {
            System.out.println("The list of phones is empty.");
            return;
        }
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(i).getModel().compareTo(arr.get(j).getModel()) < 0) {
                    Phone tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                }
            }
        }
        System.out.println("Phone List in The Descending Order of Model:");
        printPhoneList();
    }
    
    
    //5. Store phone list to a text file
    public void storeToTextFile() {
        String name = MyToys.getAString("Enter the file name you want to save: ");
        name = name + ".text";
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(name));
            out.printf("|%-15s|%-15s|%-5s|%-14s|%-5s|%-10s|%-8s|%-10s|\n", "MODEL", "CPU", "RAM", "PRIMARY CAMERA", "SCREEN SIZE", "PRICE", "COLOR", "BRAND");
            for (Phone phone : arr) {
                //out.write(phone + System.lineSeparator());
                out.printf("|%-15s|%-15s|%2d GB|%-14s|%10.1f\"|%10.1f|%-8s|%-10s|\n", phone.getModel(), phone.getCPU(), phone.getRAM(), phone.getPrimaryCamera(), phone.getScreenSize(), phone.getPrice(), phone.getColor(), phone.getBrand());
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
}
