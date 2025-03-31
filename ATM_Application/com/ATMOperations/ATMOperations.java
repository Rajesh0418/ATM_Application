package com.ATMOperations;

import com.Customer.Customer;

public interface ATMOperations
{
    double deposit(Customer customer,double amount); //deposite the amount
    double withdraw(Customer customer,double amount); //withdraw the amount 
    double checkBalance(Customer customer);//checking the balance
}