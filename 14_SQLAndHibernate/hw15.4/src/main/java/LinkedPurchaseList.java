import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class LinkedPurchaseList {

    @Getter
    @Setter
    @EmbeddedId
    private keyLinkedPurchaseList keyLinkedPurchaseList;

}
