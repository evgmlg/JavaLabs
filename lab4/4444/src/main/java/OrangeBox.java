import java.util.List;

public class OrangeBox<T extends Orange> extends Box<T>{
    public OrangeBox() {
    }

    public OrangeBox(T... fruits) {
        super(fruits);
    }

    public OrangeBox(List<T> list) {
        super(list);
    }

    void add(T fruit) {
        super.add(fruit);
    }


    void MoveFrom(OrangeBox box) {
        for(Object s : box.list)
        {
            this.list.add((T) s);
        }
    }
}
