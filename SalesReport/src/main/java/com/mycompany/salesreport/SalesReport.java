/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesreport;

/**
 *
 * @author Student
 */
import java.util.Scanner;

import java.util.Scanner;

public class SalesReport {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] mattresses = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        int[][] sales = new int[3][3];

        // Get sales input
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + mattresses[i] + ": ");
                sales[i][j] = input.nextInt();
            }
            System.out.println();
        }

        // Create Product and PrintProduct objects
        Product prod = new Product(mattresses, sales);
        PrintProduct printer = new PrintProduct(prod);

        // Display report
        System.out.println("MATTRESS SALES REPORT");
        System.out.println("--------------------------------------------------");
        System.out.println("Product\t\t\t\tTotal");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < 3; i++) {
            int rowTotal = sales[i][0] + sales[i][1] + sales[i][2];
            System.out.println(mattresses[i] + "\t" + rowTotal);
        }

        System.out.println("--------------------------------------------------");
        printer.printTotalSales();
        printer.printAverageSales();
        printer.printMostPopularProduct();

        input.close();
    }
}
