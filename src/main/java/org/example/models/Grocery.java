package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();
    public static void startGrocery() {
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Please choose an option: ");
            System.out.println("0: Quit");
            System.out.println("1: Add Items");
            System.out.println("2: Remove Items");
            int choose = input.nextInt();
            input.nextLine();

            if (choose == 0) {
                break;
            } else if (choose == 1) {
                System.out.println("Please enter the items you want to add.");
                String items = input.nextLine();
                addItems(items);
            } else if (choose == 2) {
                System.out.println("Please enter the items you want to remove.");
                String items = input.nextLine();
                removeItems(items);
            }
        }
        // "elma,karpuz,muz"
        // "elma" "karpuz" "muz" --> 3 elemanlı array
    }

    public static void addItems(String items) {
        String[] strArr = items.split(",");
        for (String str: strArr) {
            str = str.trim();
            if (!checkItemIsInList(str)) {
                groceryList.add(str);
            }
        }
        printSorted();

    }


    public static void removeItems(String items) {
        String[] strArr = items.split(",");
        for (String str: strArr) {
            str = str.trim();
            if (checkItemIsInList(str)) {
                groceryList.remove(str);
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String item) {
        return groceryList.contains(item.trim());
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        for (String item: groceryList){
            System.out.print(item + ", ");
        }
    }
}
