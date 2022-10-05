import java.util.List;

public class BananaBox <T extends Fruit> extends Box<T>{
    public BananaBox() {
    }

    public BananaBox(T... fruits) {
        super(fruits);
    }

    public BananaBox(List<T> list) {
        super(list);
    }

    public void MoveFrom(Box<T> box) {
        for(Object s : box.list)
        {
            this.list.add((T) s);
        }
    }
}
