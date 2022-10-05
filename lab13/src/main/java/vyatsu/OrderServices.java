package vyatsu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServicegs {

    @Autowired
    Card card;

    public void Order()
    {
        int Price = 0;
        System.out.println("Ваш заказ из корзины");
        for(Productgg x : card.card)
        {
            Price += x.getPrice();
            System.out.println(x.title);
        }
        System.out.println("Общая цена " + Price);
    }

    public void FastOrder(Product x)
    {
        System.out.println("Быстрый заказ " + x.title +" по цене "+x.getPrice());
    }
}
