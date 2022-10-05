import javax.persistence.*;

@Entity
@Table (name = "ord_er")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_price")
    private int productPrice;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order(Buyer buyer, Product product, int productPrice) {
        this.buyer = buyer;
        this.product = product;
        this.productPrice = productPrice;
    }

    public Order() {
    }

    public int getBuyerID() {
        return buyer.getId();
    }
    public void setBuyerID(int buyerID) {
        this.buyer.setId(buyerID);
    }

    public int getProductID() {
        return product.getId();
    }
    public void setProductID(int productID) {
        this.product.setId(productID);
    }

    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Buyer: " + buyer.getName() + ", Product: " + product.getTitle();
    }

}
