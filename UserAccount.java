import java.util.Scanner;    
import java.util.Random;    //Generating a random number for INSC code and Bank account number 
import java.util.ArrayList;  //for creating an ArrayList
class ATM
{
    private double balance=0;
    public ATM(double deposite)  //initially balance amount is 0..because we don't have an account 
    {
        this.balance=deposite;
    }
    double deposit(double amount) //deposite the amount
    {
          balance=balance+amount;
          return balance;
    }
    double withdraw(double amount) //withdraw the amount 
    {
         balance=balance-amount;
         return balance;
    }
    double checkBalance() //checking the balance
    {
        return balance;
    }
}
public class UserAccount 
{
     public static void main(String args[])
     {
        ATM a=new ATM(0);
        ArrayList<String> holderNames=new ArrayList<String>();
        ArrayList<Integer> holAccNo=new ArrayList<Integer>();
        ArrayList<Integer> holIFSCno=new ArrayList<Integer>();
        ArrayList<Long> holPhno=new ArrayList<Long>();
        ArrayList<String> holPassword=new ArrayList<String>();
        System.out.println();
        System.out.println("\t\t\t----------------------------");
        System.out.println("\t\t\t! AUTOMATED TELLER MACHINE !");
        System.out.println("\t\t\t----------------------------");
        System.out.println();
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        int randNo1=random.nextInt(10000000,90000000); //for generating the bank account number
        int randNo2=random.nextInt(6000,9000);//for generating the IFSC number
        boolean i=true; //for outer loop
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
                          boolean t=true;//for inner loop
                          System.out.println();
                          System.out.println("\t\t\t  WELCOME TO REPO BANK"); //after visiting the bank...we need to fill those below details for creating a new account
                          System.out.println("\t\t\t  --------------------");
                          System.out.println();
                          System.out.println("Fill your details");  
                          System.out.println();
                          System.out.print("Name : ");  //enter your name 
                          String name=sc.next();
                          holderNames.add(name.toUpperCase()); // appending the holdername to the ArrayList
                          System.out.print("Phone number :");//enter your ph no.
                          long phNo=sc.nextLong();
                          holPhno.add(phNo);     //appending the holPhno to the ArrayList
                          System.out.print("E-mail : "); //enter your E-mail
                          String eMail=sc.next();
                          System.out.print("Address : "); //enter your Address
                          String address=sc.next();
                          System.out.println();
                          System.out.println("Your Bank Account has been created successfully");
                          System.out.println();
                          System.out.println("Your Bank Account number is : "+randNo1);  //generating account number
                          holAccNo.add(randNo1);
                          int ifscCode=randNo2;
                          System.out.println("Your IFSC number is : "+("BANK00F"+randNo2));  //generating the IFSC code with the string of BANK00F
                          holIFSCno.add(ifscCode);//appending the IFSC code to the ArrayList
                          System.out.println();
                          System.out.println("It is required to maintain minimum 1000rs balance in your account...So, let's deposit now."); 
                          do{                                                            //whenever we creating a new account then we has to deposit minimum balance 1000...this condition is for to deposite amount for newly creating account
                              System.out.print("Enter a amount to deposit : ");
                              double depositeTheAmt=sc.nextInt();
                              if(depositeTheAmt<1000)          //if customer deposit less than 1000...then, this is condition will be execueted  
                              {
                                   System.out.println("Minimum balance is 1000rs required");
                                   System.out.println();
                                   t=true;                  //minimum is 1000/- required..if customer enter below 1000 then this loop will again executed because minimum 1000 is required
                              }
                              else
                              {
                                   a.deposit(depositeTheAmt);    //if customer
                                   t=false;
                              }
                          }while(t);
                          System.out.println("Amount is deposited successfully to your bank account."); 
                          System.out.println();
                          String password;
                          do{
                               System.out.print("Create a '4' digit password to secure your account : "); //enter password for secure customer bank account
                               password=sc.next();
                               holPassword.add(password);//appending password to the ArrayList
                               if(password.length()==4) 
                                    break;
                               System.out.println("Please enter only 4 digits");
                          }while(password.length()!=4); //if password length is more than 4 or less than 4...the banker will not be accepted
                          System.out.println();
                          System.out.println("\t\t\tTHANK YOUR FOR VISIT OUR BANK");
                          break;
                 case 2 : 
                          boolean k=true;
                          System.out.println();
                          System.out.println("Please insert your ATM card");
                          System.out.println();
                          try{
                                 Thread.sleep(5000);   //the main thread is waiting for 3 sec...this line indicates that,in normal outside ATM machine we need to wait for sometime after insert an ATM card...this line indicates that is.. 
                              }catch (InterruptedException e) 
                              {
                                     e.printStackTrace();
                              }
                              do{
                                    System.out.print("Enter your password : "); //enter password....for checking the ATM machine
                                    String enterPassword=sc.next();
                                    if(holPassword.contains(enterPassword))
                                       k=false;
                                    else
                                    {
                                      System.out.println("Invalid Password");
                                      System.out.println();
                                      k=true;
                                    }
                               }while(k);
                               System.out.print("Enter how much amount you want to deposit : ");
                               double amountDeposited=sc.nextInt();
                               a.deposit(amountDeposited);
                               System.out.println("Your deposited amount is "+amountDeposited+" And the new balance is : "+a.checkBalance());
                               System.out.println("Your amount is deposited successfully to your bank account.");
                               System.out.println("Take your ATM card.");
                               break;
                      case 3 : 
                              boolean m=true;
                              System.out.println();
                              System.out.println("Please insert your ATM card");
                              System.out.println();
                              try{
                                 Thread.sleep(5000);   //the main thread is waiting for 3 sec...this line indicates that,in outside ATM machine we need to wait for sometime after insert an ATM card...this line indicates that is.. 
                              }catch (InterruptedException e) 
                              {
                                     e.printStackTrace();
                              }
                              do{
                                    System.out.print("Enter your password : ");
                                    String enterPassword=sc.next();
                                    if(holPassword.contains(enterPassword))
                                        m=false;
                                    else
                                    {
                                      System.out.println("Invalid Password");
                                      System.out.println();
                                      m=true;
                                    }
                                }while(m);
                                for(int b=0;b<2;b++)   //this loop is iteratirated two times only when Insufficient balance in customer account
                                {
                                     System.out.print("Enter how much amount you want to withdraw : ");
                                     double amountWithdraw=sc.nextInt();
                                     if(a.checkBalance()<amountWithdraw)  //insufficient balance condition
                                     {
                                          System.out.println("Insufficient Balance...You hava to withdraw below the amount of "+a.checkBalance()+" only");
                                     }
                                     else   
                                     {
                                          a.withdraw(amountWithdraw);
                                          System.out.println("Your withdrawl amount is "+amountWithdraw+" And the new balance is : "+a.checkBalance());
                                          System.out.println("Collect your money And take your  ATM card.");
                                          break; 
                                     }
                               }
                               break;
                     case 4 : 
                                boolean n=true;
                                System.out.println();
                                System.out.println("Please insert your ATM card");
                                System.out.println();
                                try
                                {
                                 Thread.sleep(5000);   //the main thread is waiting for 3 sec...this line indicates that,in outside ATM machine we need to wait for sometime after insert an ATM card...this line indicates that is.. 
                                 }catch (InterruptedException e) 
                                {
                                     e.printStackTrace();
                                }
                                do{
                                    System.out.print("Enter your password : ");
                                    String enterPassword=sc.next();
                                    if(holPassword.contains(enterPassword))
                                        n=false;
                                    else
                                    {
                                      System.out.println("Invalid Password");
                                      System.out.println();
                                      n=true;
                                    }
                                }while(n);
                                System.out.println("Your account balance is : "+a.checkBalance());//checking the balance only no other operatioons are not execute
                                break;
                     case 5 :
                                System.exit(0); //exit..if we don't want any operations
                     default : 
                                System.out.println("Invalid Choice");
                                System.out.println();
                                break;
              }
              if(choice!=5 && (choice>0 && choice<5))    //this is for representing the account details of a customer with each transactions in tabular form
              {
                   System.out.println();
                   System.out.println(); 
                   System.out.println("HOLDER_NAME\tACCOUNT_NO\tIFSC_NO\t\t PHONE_NO\tTOTAL_BALANCE");
                   System.out.println("------------------------------------------------------------------------------");
                   System.out.println(holderNames.get(0)+"\t\t "+holAccNo.get(0)+"\t"+(("BANK00F")+holIFSCno.get(0))+"\t "+holPhno.get(0)+"\t\t"+a.checkBalance());
                   System.out.println();
                   System.out.println();
                   System.out.println("\t\t\t    ****** THANK YOU ******");
                   System.out.println();
                   System.out.println();
                   i=true;
              }
              else if(choice==5)
                i=false;
        }while(i);
     }
}