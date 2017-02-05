package concurrency;

import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String name;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// теперь собственно реализуем интерфейс Comparator, для сортировки по названию
class SortedByName implements Comparator<Product> {

    @Override
    public int compare(Product obj1, Product obj2) {
        String str1 = obj1.getName();
        String str2 = obj2.getName();

        return str1.compareTo(str2);
    }
}

// а так же реализуем интерфейс Comparator, для сортировки по цене
class SortedByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        double price1 = o1.getPrice();
        double price2 = o2.getPrice();

        if (price1 > price2) {
            return 1;
        } else if (price1 < price2) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class ComplexComparator {
    public static void main(String[] args) {
        Product[] products = new Product[3];

        products[0] = new Product();
        products[0].setName("Milk");
        products[0].setPrice(7.56);
        products[0].setQuantity(56);

        products[1] = new Product();
        products[1].setName("Coffee");
        products[1].setPrice(17.00);
        products[1].setQuantity(32);

        products[2] = new Product();
        products[2].setName("Tea");
        products[2].setPrice(12.50);
        products[2].setQuantity(0);

        System.out.println("============ no sorted ==============");
        for (Product i : products) {
            System.out.println("Name: " + i.getName() +
                    " price: " + i.getPrice() +
                    " quantity: " + i.getQuantity());
        }

        System.out.println("========e== sorted by price===========");
        Arrays.sort(products, new SortedByPrice());

        for (Product i : products) {
            System.out.println("Name: " + i.getName() +
                    " price: " + i.getPrice() +
                    " quantity: " + i.getQuantity());
        }

        System.out.println("========== sorted by name ===========");
        Arrays.sort(products, new SortedByName());

        for (Product i : products) {
            System.out.println("Name: " + i.getName() +
                    " price: " + i.getPrice() +
                    " quantity: " + i.getQuantity());
        }
    }
}
