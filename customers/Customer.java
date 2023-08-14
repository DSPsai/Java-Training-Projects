package com.bankingServices.dsp.customers;
import com.bankingServices.dsp.bank.Bank;
import com.bankingServices.dsp.transactions.Transactions;

import java.util.Scanner;

public class Customer extends Bank implements CustomerInterface {
    public static int count = 1;
    public String customer_name;
    public int customer_id;
    private long customer_balance;
    private String password;
    private final Transactions transactions=new Transactions();
    private Scanner scn = new Scanner(System.in);

    public Customer(String customer_name, String password) {
        this.customer_name = customer_name;
        this.password = password;
        this.customer_id=count;
        count += 1;
    }

    public boolean authenticate(){
        System.out.println("Please enter Password of Customer "+this.customer_id+" : ");
        String password_input=this.scn.nextLine();
        if(password_input.equals(this.password)){
            return true;
        }else{
            System.out.println("Wrong Password, Please try again..!");
            return false;
        }
    }
    public long getCustomer_balance() {
        return this.customer_balance;
    }

    public void credit_customer_balance(int customer_balance) {
        super.creditBalance(customer_balance);
        this.transactions.addTransaction(customer_balance,"Credit");
        this.customer_balance += customer_balance;
    }

    public boolean debit_customer_balance(int customer_balance) {
        long bank_balance=getBalance();
        if (this.customer_balance < customer_balance) {
            System.out.println("Customer Bank Balance is Low, Cannot proceed with the request");
            return false;
        }
        if(bank_balance<customer_balance){
            System.out.println("Banking Services Balance is Low, Cannot proceed with the request");
            return false;
        }
        this.customer_balance -= customer_balance;
        this.transactions.addTransaction(customer_balance,"Debit");
        if(!super.debitBalance(customer_balance)){
            System.out.println("Error occurred while debiting the amount from bank");
            return false;
        };
        System.out.println("Amount Successfully Debited, Remaining Balance : "+this.getCustomer_balance());
        return true;
    }

    @Override
    public String toString() {
        return "Customer ID : " + customer_id + ", Customer Name : " + customer_name + ", Customer Balance : " + customer_balance+" "+transactions.getAllTransactions();
    }

    public String get_customer_transactions(){
        return transactions.getAllTransactions().toString();
    }

    public static int length() {
        return count-1;
    }
}
