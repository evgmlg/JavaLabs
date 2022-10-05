import java.util.List;

public class AppleBox<T extends Fruit> extends Box<T>{

    public AppleBox() {
    }

    public AppleBox(T... fruits) {
        super(fruits);
    }

    public AppleBox(List<T> list) {
        super(list);
    }

    public void MoveFrom(Box<T> box) {
        for(Object s : box.list)
        {
            this.list.add((T) s);
        }
    }


}
