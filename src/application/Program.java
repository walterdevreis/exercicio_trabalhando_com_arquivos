package src.application;

import src.entities.Products;

import java.util.Locale;

public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);

        Products products = new Products("S21 Fe", 1000.00, 3);

        System.out.println(products);
    }
}
