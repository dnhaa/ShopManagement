
package data;


public class Phone {
    private String model;
    private String CPU;
    private int RAM;
    private String primaryCamera;
    private int screenSize;
    private double price;
    private String color;
    private String brand;

    public Phone(String model, String CPU, int RAM, String primaryCamera, int screenSize, double price, String color, String brand) {
        this.model = model;
        this.CPU = CPU;
        this.RAM = RAM;
        this.primaryCamera = primaryCamera;
        this.screenSize = screenSize;
        this.price = price;
        this.color = color;
        this.brand = brand;
    }

    
    public String getModel() {
        return model;
    }

//    public void setModel(String model) {
//        this.model = model;
//    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(String primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Phone{" + "model=" + model + ", CPU=" + CPU + ", RAM=" + RAM + ", primaryCamera=" + primaryCamera + ", screenSize=" + screenSize + ", price=" + price + ", color=" + color + ", brand=" + brand + '}';
    }
    
    public void printPhone() {
        System.out.printf("|%-15s|%-15s|%2d GB|%-14s|%10d\"|%10.1f|%-8s|%-10s|\n", model, CPU, RAM, primaryCamera, screenSize, price, color, brand);
    }
}