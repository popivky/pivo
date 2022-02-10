import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@ToString
@Entity
@Table(name = "PurchaseList")

public class PurchaseList {

    @EmbeddedId
    keyPurchase keyPurchase;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


}
