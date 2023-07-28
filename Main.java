package com.bankingServices.dsp;

import com.bankingServices.dsp.bank.Bank;
import com.bankingServices.dsp.customers.Customer;
import com.bankingServices.dsp.customers.Customers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * banking services modules:
     * - transactions
     * - customers
     * - bank cash amount
     */

    // Scanner definition
    static Scanner scn = new Scanner(System.in);

    public static void display_all_customers(Customers customers) {
        int length = customers.length();
        ArrayList<Customer> customer_array = customers.getCustomers();

        System.out.println("Total Customers : " + length);
        if (length != 0)
            System.out.println("\n\n Customers Details : \n");
        for (int i = 0; i < length; i++) {
            System.out.println(customer_array.get(i).toString());
        }
    }

    public static void add_a_customer(Customers customers) {
        //Declaring scanner because it is not taking the whole name
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Customer Name : ");
        String name = sc.nextLine();
        customers.add_customer(name);
        System.out.println("Customer " + name + " Created");
    }

    public static void display_bank_balance() {
        System.out.println("Total Bank Balance : " + Bank.getBalance());
    }

    public static int input_customer_id(Customers customers) {
        int length = customers.length();
        System.out.print("Please enter the Customer ID : ");
        int id = scn.nextInt();
        if (id <= 0 || id > length) {
            System.out.println("Invalid ID");
            return -1;
        }
        return id;
    }

    public static int input_amount(boolean isCredit) {
        System.out.format("Please enter the the Amount to %s : ", isCredit ? "Credit" : "Debit");
        return scn.nextInt();
    }

    public static void view_customer_balance(Customers customers) {
        int id = input_customer_id(customers);
        if (id == -1) {
            return;
        }
        Customer customer = customers.getCustomer(id);
        if (customer == null) {
            return;
        }
        System.out.println("Balance Remaining : " + customer.getCustomer_balance());
    }

    public static void credit_customer_balance(Customers customers) {
        int id = input_customer_id(customers);
        if (id == -1) {
            return;
        }
        Customer customer = customers.getCustomer(id);
        if (customer == null) {
            return;
        }
        int amount = input_amount(true);
        customer.credit_customer_balance(amount);
        System.out.println("Amount Successfully Credited with " + amount + "/-");
        System.out.println("Balance Remaining : " + customer.getCustomer_balance());
    }

    public static void debit_customer_balance(Customers customers) {
        int id = input_customer_id(customers);
        if (id == -1) {
            return;
        }
        Customer customer = customers.getCustomer(id);
        if (customer == null) {
            return;
        }
        int amount = input_amount(false);
        boolean isDebited = customer.debit_customer_balance(amount);
        if (!isDebited) {
            System.out.println("Low Balance, operation failed");
            return;
        }
        System.out.println("Amount Successfully Debited with " + amount + "/-");
        System.out.println("Balance Remaining : " + customer.getCustomer_balance());
    }

    public static void display_a_customers(Customers customers) {
        ArrayList<Customer> customer_array = customers.getCustomers();
        int id = input_customer_id(customers);
        if (id == -1) {
            return;
        }
        String details = customer_array.get(id-1).toString();
        System.out.println(details);
    }

    public static void display_customer_transactions(Customers customers){
        int customer_id=input_customer_id(customers);
        if(customer_id==-1){
            return;
        }
        System.out.println("Customer Transaction Details : ");
        System.out.println(customers.getCustomer(customer_id).get_customer_transactions());
    }

    public static void main(String[] args) {
        //Creating Customers
        Customers customers = new Customers();
        while (true) {
            System.out.println("""
                    \s

                    WelCome to the Banking Services
                    Please select an option to continue
                    Bank Services:
                    1. View Bank Balance
                    2. View Customers
                    3. Add a Customer

                    Customer Services :
                    4. View Customer Bank Balance
                    5. Debit Amount
                    6. Credit Amount
                    7. View Customer Details
                    8. View Customer Transactions Details
                    0. Exit

                    Option:""");

            int str1 = scn.nextInt();

            boolean break_loop = false;
            switch (str1) {
                case 1 -> display_bank_balance();
                case 2 -> display_all_customers(customers);
                case 3 -> add_a_customer(customers);
                case 4 -> view_customer_balance(customers);
                case 5 -> debit_customer_balance(customers);
                case 6 -> credit_customer_balance(customers);
                case 7 -> display_a_customers(customers);
                case 8 -> display_customer_transactions(customers);
                case 0 -> break_loop = true;
            }
            if (break_loop) {
                System.out.println("Thank you for using our services, Hope to see you again!");
                break;
            }
        }
    }
}
