import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "name")
    private String name;

    public Buyer (String name)
    {
        this.name = name;
    }
    public Buyer() {}

    @OneToMany (mappedBy="buyer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Order> orders;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id= " + id + ", name= " + name;
    }
}