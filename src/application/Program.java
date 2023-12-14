package src.application;

import src.entities.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String path = sc.nextLine();

        List<Products> productsList = new ArrayList<>();

        File sourceFile = new File(path);
        String sourceFolder = sourceFile.getParent();

        boolean sucess = new File(sourceFolder + "\\out").mkdir();

        String targetFile = sourceFolder + "\\out\\summary.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while (line != null){
                String[] item = line.split(",");
                String name = item[0];
                double price = Double.parseDouble(item[1]);
                int quantity = Integer.parseInt(item[2]);
                productsList.add(new Products(name, price, quantity));

                line = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))){
                for(Products items : productsList){
                    bw.write(String.format("%s,%.2f", items.getName(), items.totalValue()));
                    bw.newLine();
                }
            }
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
