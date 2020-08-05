package com.aeliter.yaxin;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-04-04 11:56
 * @version: V1.0
 */
public class Cake {

    String cakeCode;
    String cakeName;
    float price;

    public Cake() {}

    public Cake(String cakeCode, String cakeName, float price) {
        this.cakeCode = cakeCode;
        this.cakeName = cakeName;
        this.price = price;
    }

    float getSaleSum(float price, float weight) {
        float saleSum = 0;
        saleSum = price * weight;
        return saleSum;
    }

}
