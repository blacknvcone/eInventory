package app.eInvent.eInventModel;

/**
 * Created by blacknvc on 04/01/2017.
 */

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue
    private long transId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_trans")
    private Date dateTrans;

    @Column(length = 60)
    private String salesName;
    @Column
    private long productId;
    @Column(length = 10)
    private int totalItem;



    public Transaction(){}

    public long getTransId(){return transId;}
    public void setTransId(long id){this.transId = id;}

    public String getSalesName(){return salesName;}
    public void setSalesName(String sales){this.salesName = sales;}

    public long getProductId(){return productId;}
    public void setProductId(long proId){this.productId = proId;}

    public Date getDateField(){return dateTrans;}
    public void setDateField(Date date_trans){this.dateTrans = date_trans;}

    public int getTotalItem() {
        return totalItem;
    }
    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }
}
