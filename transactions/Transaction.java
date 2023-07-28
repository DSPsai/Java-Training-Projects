package com.bankingServices.dsp.transactions;

import java.util.Date;

public class Transaction implements TransactionInterface{

    public static int count=0;
    private String transaction_id;
    private long amount;

    private String type;

    private String date;

    public Transaction(long amount, String type){
        Date today= new Date();
        this.date=today.toString();
        this.type=type;
        this.transaction_id=String.valueOf(count);
        this.amount=amount;
        count+=1;
    }
    public String getTransaction_id(){
        return transaction_id;
    }
    @Override
    public String toString(){
        return "Transaction ID: "+transaction_id+", Amount: "+amount+", Date: "+date+", Type of Transaction: "+type;
    }
}
