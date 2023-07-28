package com.bankingServices.dsp.transactions;

import java.util.ArrayList;
import java.util.Date;

public class Transactions {

    ArrayList<Transaction> transactions= new ArrayList<Transaction>();
    public String getTransaction(String id) {
        for(Transaction trans:transactions){
            if(trans.getTransaction_id().equals(id)){
                return trans.toString();
            }
        }
        return "Transaction not Found";
    }

   public boolean addTransaction(int amount,String type){
        Transaction new_transaction=new Transaction(amount,type);
        transactions.add(new_transaction);
        return true;
    }

    public StringBuffer getAllTransactions(){
        StringBuffer return_string=new StringBuffer("\n");
        for(Transaction trans:transactions){
            return_string.append(trans.toString()).append("\n");
        }
        return return_string;
    }
}
