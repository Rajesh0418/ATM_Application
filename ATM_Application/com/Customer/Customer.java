package com.Customer;
public class Customer{
    String accountHolderName;
    String phoneNumber;
    String accountNumber;
    String ifscCode;
    String address;
    String password;
    String eMail;
    public double balanceAmount;

    //getaccountHolderNamer and set accountHolderName 
    public  String getAccountHolderName(){
         return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName){
         this.accountHolderName=accountHolderName;
    }

    //get phNo and set phNo
    public String getPhoneNumber(){
         return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
         this.phoneNumber=phoneNumber;
    }

    //AccNo and set AccNum
    public  String getAccountNumber(){
         return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
         this.accountNumber=accountNumber;
    }

    //get ifscCode and set ifscCode
    public String getIFSCCode(){
         return ifscCode;
    }
    public void setIFSCCode(String ifscCode){
         this.ifscCode=ifscCode;
    }

    //get address and set adress
    public String getAddress(){
         return address;
    }
    public void setAddress(String adress){
         this.address=adress;
    }

    //get password and set password
    public String getPassword(){
         return password;
    }
    public void setPassword(String password){
         this.password=password;
    }

    //get email and set email
    public String getEmail(){
         return eMail;
    }
    public void setEmail(String emial){
         this.eMail=emial;
    }

    //get balance
    public double getBalanceAmount() 
    {
          return balanceAmount;
    }
}
