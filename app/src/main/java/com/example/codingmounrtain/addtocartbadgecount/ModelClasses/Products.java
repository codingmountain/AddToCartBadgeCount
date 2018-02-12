package com.example.codingmounrtain.addtocartbadgecount.ModelClasses;

/**
 * Created by chintu gandhwani on 1/22/2018.
 */

public class Products {

    private String productName;
    private int productImageId;
    private boolean addedTocart = false;

    public  Products(String productName,int productImageId)
    {
        this.productName=productName;
        this.productImageId=productImageId;
    }

    public boolean isAddedTocart() {
        return addedTocart;
    }

    public void setAddedTocart(boolean addedTocart) {
        this.addedTocart = addedTocart;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductImageId() {
        return productImageId;
    }

}
