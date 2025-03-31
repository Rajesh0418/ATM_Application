package com.Bank;

import java.util.Random;
import java.util.Scanner;

import com.ATMOperations.ATMOperations;
import com.Customer.Customer;

public class Bank implements ATMOperations{

    public Customer createAnBankAccount(Customer customer,int accountNumber, int ifscCode,Scanner sc) 
    {
        Random random=new Random();
        boolean t = true;// for inner loop
        System.out.println();
        System.out.println("\t\t\t  WELCOME TO REPO BANK"); // after visiting the bank...we need to fill those below
                                                            // details for creating a new account
        System.out.println("\t\t\t  --------------------");
        System.out.println();
        System.out.println("Fill your details");
        System.out.println();
        System.out.print("Name : "); // enter your name
        String name = sc.next();
        customer.setAccountHolderName(name.toUpperCase()); // appending the holdername to the ArrayList
        System.out.print("Phone number :");// enter your ph no.
        String phNo = sc.next();
        customer.setPhoneNumber(phNo); // appending the holPhno to the ArrayList
        System.out.print("E-mail : "); // enter your E-mail
        String email = sc.next();
        customer.setEmail(email);
        System.out.print("Address : "); // enter your Address
        String address = sc.next();
        customer.setAddress(address);
        System.out.println();

        System.out.println("Your Bank Account has been created successfully");
        System.out.println();
        accountNumber = random.nextInt(10000000, 90000000);
        System.out.println("Your Bank Account number is : " + accountNumber); // generating account number
        customer.setAccountNumber(String.valueOf(accountNumber));

        ifscCode = random.nextInt(6000, 9000);
        System.out.println("Your IFSC number is : " + ("BANK00F" + ifscCode)); // generating the IFSC code with the
                                                                               // string of BANK00F
        customer.setIFSCCode("BANK00F" + String.valueOf(ifscCode));// appending the IFSC code to the ArrayList
        System.out.println();
        System.out.println("It is required to maintain minimum 1000rs balance in your account...So, let's deposit now.");

        do { // whenever we creating a new account then we has to deposit minimum balance
             // 1000...this condition is for to deposite amount for newly creating account
            System.out.print("Enter a amount to deposit : ");
            double depositeAmt = sc.nextInt();
            if (depositeAmt < 1000) // if customer deposit less than 1000...then, this is condition will be
                                    // execueted
            {
                System.out.println("Minimum balance is 1000rs required");
                System.out.println();
                t = true; // minimum is 1000/- required..if customer enter less than 1000 then this loop
                          // will again executed because minimum 1000 is required
            } else {
                deposit(customer, depositeAmt); // if customer
                System.out.println(customer.getAccountNumber());
                t = false;
            }
        } while (t);
        System.out.println("Amount is deposited successfully to your bank account.");
        System.out.println();

        String password;
        do {
            System.out.print("Create a '4' digit password to secure your account : "); // enter password for secure
                                                                                       // customer bank account
            password = sc.next();
            customer.setPassword(password);// appending password to the ArrayList
            if (password.length() == 4)
                break;
            System.out.println("Please enter only 4 digits");
        } while (password.length() != 4); // if password length is more than 4 or less than 4...the banker will not be
                                          // accepted
        System.out.println();  

        System.out.println("\t\t\tTHANK YOUR FOR VISIT OUR BANK");
        return customer;
    }

    @Override
    public double deposit(Customer customer,double depositeAmount)
    {
        customer.balanceAmount=customer.getBalanceAmount()+depositeAmount;
        customer.balanceAmount=customer.balanceAmount;
        return customer.getBalanceAmount();
    }

    @Override
    public double withdraw(Customer customer, double withdrawlAmount) 
    {

        Scanner sc=new Scanner(System.in);
        while(true)
        {
            if(customer.getBalanceAmount()<withdrawlAmount)  //insufficient balance condition
            {
                System.out.println("Insufficient Balance...You can withdrawl the amount upto "+customer.getBalanceAmount()+" rs only");
                System.out.println("Enter how much amount you want to withdraw ? ");
                withdrawlAmount=sc.nextInt();
                System.out.println();
            }
            else   
            {
                customer.balanceAmount=customer.getBalanceAmount()-withdrawlAmount;
                customer.balanceAmount=customer.balanceAmount;
                return customer.getBalanceAmount();
            }
        }
                                
    }

    @Override
    public double checkBalance(Customer customer) {
        return customer.getBalanceAmount();
    }
}

