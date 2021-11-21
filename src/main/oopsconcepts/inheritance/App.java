package edureka.inheritance;

class Mobile extends Product {
    String os;
    int ram;
    int sdCardSize;

    Mobile() {
        System.out.println("Mobile object constructed");
    }

    void setProductDetails(int pid, String name, int price, String os, int ram, int sdCardSize) {
        super.setProductDetails(pid, name, price);
        this.os = os;
        this.ram = ram;
        this.sdCardSize = sdCardSize;
    }

    void showProductDetails() {
        super.showProductDetails();
        System.out.println("OS: " + os + " Ram: " + ram + " sdCardSize: " + sdCardSize);
    }


}

class Product {
    private int pid;
    String name;
    int price;

    Product() {
        System.out.println("Product Object Constructed");
    }

    void setProductDetails(int pid, String name, int price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
    }

    void showProductDetails() {
        System.out.println("Product Id: " + pid + " Name: " + name + " Price: " + price);
    }
}

public class App {
    public static void main(String[] args) {
        Product p = new Product();
        p.setProductDetails(1, "susmitha", 10);
        p.showProductDetails();
        Mobile mobile = new Mobile();
        mobile.setProductDetails(301, "iphonex", 70000);
        mobile.showProductDetails();
    }
}
