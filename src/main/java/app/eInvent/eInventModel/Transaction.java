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

    @Column(name = "date_trans")
    @Transient
    private String dateTransString;

    @Column(length = 60)
    private String salesName;
    //@Column
    //private long productId;
    @Column(length = 10)
    private int totalItem;

    @Column
    private long product_Id;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public Transaction(){}

    public long getTransId(){return transId;}
    public void setTransId(long id){this.transId = id;}

    public String getSalesName(){return salesName;}
    public void setSalesName(String sales){this.salesName = sales;}

    public Date getDateField(){return dateTrans;}
    public void setDateField(Date date_trans){this.dateTrans = date_trans;}

    public int getTotalItem() {
        return totalItem;
    }
    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public String getDateTransString() {
        return dateTrans.toString();
    }

    public void setDateTransString(String dateTransString) {
        this.dateTransString = dateTransString;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(Long product_Id) {
        this.product_Id = product_Id;
    }
}
