package app.eInvent.eInventModel;

/**
 * Created by blacknvc on 04/01/2017.
 */

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue
    private long transId;

    @Column(length = 60)
    private String salesName;
    @Column
    private long productId;
    @Column(length = 10)
    private int totalItem;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_trans")
    private java.util.Date date_trans;

    public long getTransId(){return transId;}
    public void setTransId(long id){this.transId = id;}

    public String getSalesName(){return salesName;}
    public void setSalesName(String sales){this.salesName = sales;}

    public long getProductId(){return productId;}
    public void setProductId(long proId){this.productId = proId;}

    public java.util.Date getDateField(){return date_trans;}
    public void setDateField(java.util.Date setDate){this.date_trans = setDate;}

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }
}
