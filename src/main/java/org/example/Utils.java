package org.example;

import org.example.entity.DiscountProduct;
import org.example.entity.Product;
import org.example.model.DB;

import java.util.*;
import java.util.stream.Collectors;

public class Utils {

    public static double calculatePriceOfDiscountProduct(int discountNumber,int number, double price, double discountPrice){

        int discountCoefficient = number / discountNumber;
        int coefficient = number % discountNumber;

        return discountPrice * discountCoefficient + coefficient * price;
    }

//    public static String sort(String s){
//        List<Character> list = Arrays.stream(stringToCharacterArray(s)).collect(Collectors.toList());
//        Collections.sort(list);
//        return list.toString();
//    }
//
//    public static Character[] stringToCharacterArray(String s){
//        Character[] result = new Character[s.length()];
//
//        for(int i = 0; i < s.length(); i++){
//            result[i] = s.charAt(i);
//        }
//
//        return result;
//    }

    public static Map<Character, Integer> calculateFrequency(String s){
        Map<Character, Integer> result = new HashMap<>();

        for(int n = 0; n < s.length(); n++){
            Character c = s.charAt(n);
            if(result.containsKey(c)){
                result.replace(c, result.get(c) + 1);
            } else {
                result.put(c, 1);
            }
        }
        return result;
    }

    public static double calculateTotalCost(String basket){
        double result = 0;
        Map<Character,Integer> frequencyMap = calculateFrequency(basket);
        for(Product p : DB.warehouse){
            if(frequencyMap.get(p.getCode()) == null)
                continue;

            if(p instanceof DiscountProduct){
                DiscountProduct dp = (DiscountProduct) p;
                result += calculatePriceOfDiscountProduct(dp.getDiscountNumber(), frequencyMap.get(dp.getCode()),
                                                          dp.getPrice(), dp.getDiscountPrice());
            } else {
                result += p.getPrice() * frequencyMap.get(p.getCode());
            }
        }
        return result;
    }
}
