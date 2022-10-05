package vyatsu;

public class Product {
    int id;
    String title;
    int price;

    public Producgt(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
    public String info(){
        return id + " | "+ title + " | " + price;    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
