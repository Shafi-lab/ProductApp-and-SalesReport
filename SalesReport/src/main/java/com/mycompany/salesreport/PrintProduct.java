package com.mycompany.salesreport;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class PrintProduct {

    private Product product;

    public PrintProduct(Product product) {
        this.product = product;
    }

    public void printTotalSales() {
        System.out.println("Total products sold: " + product.GetTotalProductsSold());
    }

    public void printAverageSales() {
        System.out.println("Average products sold: " + Math.round(product.GetAverageProductSold()));
    }

    public void printMostPopularProduct() {
        System.out.println("Most popular product: " + product.GetMostPopularProduct());
    }
}

