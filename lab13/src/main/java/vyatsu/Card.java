package vyatsu;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Card {
    public List<Product> card = new ArrayList<>();

    public void Add(Product x)
    {
        card.add(x);
    }
}
