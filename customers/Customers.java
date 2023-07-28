package com.bankingServices.dsp.customers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Customers {

    public ArrayList<Customer> customers = new ArrayList<Customer>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void add_customer(String name) {
        Customer new_customer = new Customer(name);
        customers.add(new_customer);
    }

    public Customer getCustomer(int id) {
        if(id<1 || id>length()){
            System.out.println("Invalid ID");
            return null;
        }
        return this.customers.get(id-1);
    }

    public int length() {
        return Customer.length();
    }
}
