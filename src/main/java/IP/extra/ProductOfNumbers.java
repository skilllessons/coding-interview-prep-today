package main.java.IP.extra;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

    private List<Integer> list = new ArrayList<>();


    public ProductOfNumbers() {

    }

    public void add(int num) {
        list.add(num);

    }

    public int getProduct(int k) {

        int temp = 1;

        for (int i = list.size() - 1; i >=k; i--) {
            if (i <= 0) break;
            temp = temp * list.get(i);
        }

        return temp;

    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is
        productOfNumbers.getProduct(3);
        productOfNumbers.getProduct(4);
        productOfNumbers.add(8);
        productOfNumbers.getProduct(2);
    }
}
