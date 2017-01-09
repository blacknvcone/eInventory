package app.eInvent.eInventPayload;

import app.eInvent.eInventModel.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionPayload {
    private String salesName;
    private Date transactionDate;
    private int grossAmount;
    private int totalItem;
    private List<Product> itemData;

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(int grossAmount) {
        this.grossAmount = grossAmount;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public List<Product> getItemData() {
        return itemData;
    }

    public void setItemData(List<Product> products) {
        this.itemData = products;
    }
}
