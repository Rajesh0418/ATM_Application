package com.ATMOperations;

import java.util.ArrayList;
import java.util.Scanner;

import com.Customer.Customer;

public class Authentication {
    public Customer authentication(ArrayList<Customer> customers) {
        Scanner sc=new Scanner(System.in);
        boolean n = true;
        System.out.println();
        System.out.println("Please insert your ATM card");
        System.out.println();
        try {
            Thread.sleep(5000); // the main thread is waiting for 3 sec...this line indicates that,in outside
                                // ATM machine we need to wait for sometime after insert an ATM card...this line
                                // indicates that is..
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return null;
        }
        do {
            System.out.print("Enter your password : ");
            String checkPassword = sc.next();
            for (Customer customer : customers) {
                if (customer.getPassword().equals(checkPassword)) {
                    return customer;
                }
            }
            if (n != false) {
                System.out.println("Invalid Password");
                System.out.println();
                n = true;
            }
        } while (n);
        return null;
    }
}
