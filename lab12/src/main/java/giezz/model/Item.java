package giezz.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OptimisticLock;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OptimisticLock(excluded =  true )
    private long val;

    public Item() {
    }

    @Version
    private long version;

    public Item(long val) {
        this.val = val;
    }

    public long getVal() {
        return val;
    }

    public void setVal(long val) {
        this.val = val;
    }

    public long getVersion() {
        return version;
    }

    public long getId() {
        return id;
    }
}
