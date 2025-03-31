package com;
import java.util.Scanner;
import java.util.ArrayList;  //for creating an ArrayList
import com.ATMOperations.ATMOperations;
import com.ATMOperations.Authentication;
import com.Bank.Bank;
import com.Customer.Customer;

class ATM
{
     public static void main(String args[])
     {
        ArrayList<Customer> customers=new ArrayList<>();
        ATMOperations atmOperations=new Bank();
        Customer customer=null;
        System.out.println();
        System.out.println("\t\t\t----------------------------");
        System.out.println("\t\t\t! AUTOMATED TELLER MACHINE !");
        System.out.println("\t\t\t----------------------------");
        System.out.println();
        Scanner sc=new Scanner(System.in);
        Authentication authentication=new Authentication();;
        int accountNumber=0; //for generating the bank account number
        int ifscCode=0;//for generating the IFSC number
        boolean operationContinue=true; //for outer loop
        do{
              System.out.println("1.Create a bank account(You have to visit our bank to create a new bank account)"); //if customer don't have an account than..they needs to visit the bank for to creating the account
              System.out.println("2.Deposit");
              System.out.println("3.Withdraw");
              System.out.println("4.Check balance");
              System.out.println("5.Exit");
              System.out.println();
              System.out.print("Enter your choice : ");
              int choice=sc.nextInt();
              switch(choice)
              {
                 case 1:
                           customer=new Customer();     
                           Bank bank=new Bank();
                           customer=bank.createAnBankAccount(customer,accountNumber,ifscCode,sc);  
                           customers.add(customer);              
                           break;
                 case 2 :                
                           customer=authentication.authentication(customers);
                           if(customer!=null)
                           {
                              System.out.print("Enter how much amount you want to deposit : ");
                              double depositeAmount=sc.nextInt();
                              atmOperations.deposit(customer,depositeAmount);
                              System.out.println("Your deposited amount is "+depositeAmount+" And the availabel balance is : "+customer.getBalanceAmount());
                              System.out.println("Your amount is deposited successfully into your bank account.");
                              System.out.println("Take your ATM card.");
                           }
                           break;
                 case 3 : 
                           customer=authentication.authentication(customers);

                           if(customer!=null)
                           {                        
                              System.out.print("Enter how much amount you want to withdraw : ");
                              double withdrawlAmount=sc.nextInt();
                              atmOperations.withdraw(customer,withdrawlAmount);
                              System.out.println("Your withdrawl amount is "+withdrawlAmount+" And the availabel balance is : "+customer.getBalanceAmount());
                              System.out.println("Your amount is deposited successfully into your bank account.");
                              System.out.println("Take your ATM card.");
                           }
                           break;
                 case 4 : 
                           customer=authentication.authentication(customers);
                           if(customer!=null)
                           {
                              System.out.println();
                              System.out.println("Available balance is : "+customer.getBalanceAmount());//checking the balance only no other operatioons are not execute
                              System.out.println();
                           }
                           break;
                 case 5 :
                           System.exit(0); //exit..if we don't want any operations
                 default : 
                           System.out.println("Invalid Choice");
                           System.out.println();
                           break;
              }
              if( choice!=4 && choice>0 && choice<5)    //this is for representing the account details of a customer with each transactions in tabular form
              {
                   System.out.println();
                   System.out.println(); 
                   System.out.println("HOLDER_NAME\tACCOUNT_NO\tIFSC_NO\t\t PHONE_NO\tTOTAL_BALANCE");
                   System.out.println("------------------------------------------------------------------------------");
                   for(Customer cus:customers){
                   System.out.println(cus.getAccountHolderName()+"\t\t "+cus.getAccountNumber()+"\t"+cus.getIFSCCode()+"\t "+cus.getPhoneNumber()+"\t\t"+cus.getBalanceAmount());
                   System.out.println();
                   }
                   System.out.println();
                   System.out.println("\t\t\t    ****** THANK YOU ******");
                   System.out.println();
                   System.out.println();
                   operationContinue=true;
              }
              else if(choice==5) operationContinue=false;
                
        }while(operationContinue);
        sc.close();
     }

}