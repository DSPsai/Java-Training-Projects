package com.bankingServices.dsp.customers;

public interface CustomerInterface {
    void credit_customer_balance(int customer_balance);
    boolean debit_customer_balance(int customer_balance);
    long getCustomer_balance();
    String toString();
}
