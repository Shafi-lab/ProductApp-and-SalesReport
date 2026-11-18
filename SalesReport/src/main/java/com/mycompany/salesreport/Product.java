package com.mycompany.salesreport;


import com.mycompany.salesreport.IProduct;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class Product implements IProduct {

    private String[] products;
    private int[][] sales;

    public Product(String[] products, int[][] sales) {
        this.products = products;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total = total + sales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = 0;

        for (int i = 0; i < sales.length; i++) {
            count = count + sales[i].length;
        }

        return (double) total / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int highest = 0;
        String topProduct = "";

        for (int i = 0; i < sales.length; i++) {
            int rowTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                rowTotal = rowTotal + sales[i][j];
            }

            if (rowTotal > highest) {
                highest = rowTotal;
                topProduct = products[i];
            }
        }
        return topProduct;
    }
}
