package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;


public class UtilsTest
{

    @Test
    public void testCalculatePriceOfDiscountProduct() {

        int discountNumber = 3;
        int number = 3;
        double price = 1.25;
        double discountPrice = 3.0;
        Assert.assertEquals(3.00,
                Utils.calculatePriceOfDiscountProduct(discountNumber, number, price, discountPrice),
                0.0001);

         discountNumber = 6;
         number = 1;
         price = 1.00;
         discountPrice = 5.0;
        Assert.assertEquals(1.00,
                Utils.calculatePriceOfDiscountProduct(discountNumber, number, price, discountPrice),
                0.0001);

        discountNumber = 5;
        number = 10;
        price = 1.00;
        discountPrice = 4.0;
        Assert.assertEquals(8.00,
                Utils.calculatePriceOfDiscountProduct(discountNumber, number, price, discountPrice),
                0.0001);

        discountNumber = 5;
        number = 12;
        price = 1.00;
        discountPrice = 4.0;
        Assert.assertEquals(10.00,
                Utils.calculatePriceOfDiscountProduct(discountNumber, number, price, discountPrice),
                0.0001);

        discountNumber = 5;
        number = 0;
        price = 1.00;
        discountPrice = 4.0;
        Assert.assertEquals(0.00,
                Utils.calculatePriceOfDiscountProduct(discountNumber, number, price, discountPrice),
                0.0001);
    }

    @Test
    public void testCalculateFrequency() {

        String basket = "ABCDABA";
        Map<Character, Integer> map = Utils.calculateFrequency(basket);

        Assert.assertNotNull(map.get('A'));
        Assert.assertNotNull(map.get('B'));
        Assert.assertNotNull(map.get('C'));
        Assert.assertNotNull(map.get('D'));

        Assert.assertEquals(3, (int) map.get('A'));
        Assert.assertEquals(2, (int) map.get('B'));
        Assert.assertEquals(1, (int) map.get('C'));
        Assert.assertEquals(1, (int) map.get('D'));

        basket = "";
        map = Utils.calculateFrequency(basket);

        Assert.assertNull(map.get('A'));
        Assert.assertNull(map.get('B'));
        Assert.assertNull(map.get('C'));
        Assert.assertNull(map.get('D'));

        basket = "A";
        map = Utils.calculateFrequency(basket);

        Assert.assertNotNull(map.get('A'));
        Assert.assertNull(map.get('B'));
        Assert.assertNull(map.get('C'));
        Assert.assertNull(map.get('D'));

        Assert.assertEquals(1, (int) map.get('A'));
    }

    @Test
    public void testCalculateTotalCost() {
        String basket = "ABCDABA";

        Assert.assertEquals(13.25, Utils.calculateTotalCost(basket), 0.0001);

        basket = "";

        Assert.assertEquals(0, Utils.calculateTotalCost(basket), 0.0001);
    }
}
