package Marquee.BinarySearch.programs;

import java.util.Arrays;

public class BiscuitDriver {
    public static void main(String args[]){
        Biscuit[] biscuit = new Biscuit[]{
                new Biscuit("BorBon", "chennai", "05/07/2023"),
                new Biscuit("Milkbikies", "banglr", "23/05/2025")
        };
        Arrays.sort(biscuit);
        System.out.println(Arrays.toString(biscuit));
    }
}
