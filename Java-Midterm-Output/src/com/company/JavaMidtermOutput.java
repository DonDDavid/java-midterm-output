package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaMidtermOutput {

    public static Scanner don = new Scanner(System.in);
    public static ArrayList<String> uName = new ArrayList<>();
    public static ArrayList<Integer> uAge = new ArrayList<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean y = true;
        do {
            System.out.println("""
                    =======Options========
                    1. Add entry
                    2. Delete entry
                    3. View all entries
                    4. Update an entry
                    5. Exit
                    """);

            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> insert(uName, uAge);
                case 2 -> delete();
                case 3 -> view();
                case 4 -> update();
                case 5 -> exit();
                default -> System.out.println("bad input");
            }
            
            System.out.println("want to process more? y/n");
            String x = in.next();
            char ch = x.charAt(0);
            if (ch == 'n')
                y = false;
        }
        while (y);
    }


    // ADD
    static void insert(ArrayList<String> uName, ArrayList<Integer> uAge) {
        Scanner in = new Scanner(System.in);

        boolean y = true;
        do {
            System.out.println("=======Add Entry=======");
            System.out.println("1. Enter name: ");
            String name = don.next();
            uName.add(name);

            System.out.println("2. Enter age: ");
            int age = don.nextInt();
            uAge.add(age);
            System.out.println("want to insert more? y/n");
            String x = in.next();
            char ch = x.charAt(0);
            if (ch == 'n')
                y = false;
        }
        while (y);
    }


    //DELETE
    static void delete() {
        System.out.println("======Delete Entry======");

            System.out.print("Enter a Name to Delete: ");
            String delUser = don.next();
        boolean y = true;
        do{
            if (uName.contains(delUser)) {

                for (int i = 0; i < uName.size(); i++)
                    if (delUser.equals(uName.get(i))) {
                        System.out.println(uName.get(i) + " has been deleted!");
                        uName.remove(i);
                        uAge.remove(i);
                        System.out.println("want to delete more? y/n");
                        String x = don.next();
                        char ch = x.charAt(0);
                        if (ch == 'n')
                            y = false;
                        break;
                    }

            }else {
                System.out.println("No " + delUser + " in the list");
                break;
            }
        }
        while (y);
    }


    //VIEW
    static void view() {
        System.out.println("======VIEW ALL ENTRIES=======");
        for (int i = 0; i < uName.size(); i++) {
            System.out.println(uName.get(i) + " is " + uAge.get(i));
        }
    }


    //UPDATE
    static void update() {
        System.out.println("======Update an Entry=======");

        System.out.print("Enter a Name to Update: ");
        String userUpdate = don.next();

        if (uName.contains(userUpdate)) {
            for (int i = 0; i < uName.size(); i++) {
                if (userUpdate.equals(uName.get(i))) {
                    System.out.print("Enter New Name: ");
                    String name = don.next();
                    uName.set(i, name);
                    System.out.print("Enter New Age: ");
                    int age = don.nextInt();
                    uAge.set(i, age);
                }
            }
        }
    }


    //EXIT
    static void exit() {
        System.out.println("Thanks!");
        System.exit(0);
    }
}


