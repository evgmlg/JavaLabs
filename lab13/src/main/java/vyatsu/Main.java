package vyatsu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        productService.printAll();
        Card card = context.getBean("card",Card.class);
        card.Add(productService.findByTitle("Product#1"));
        card.Add(productService.findByTitle("Product#2"));
        card.Add(productService.findByTitle("Product#3"));
        OrderServices order = context.getBean("orderServices", OrderServices.class);
        order.FastOrder(productService.findByTitle("Product#9"));//Быстрый заказ
        order.Order();//Корзинный заказ
        ((AnnotationConfigApplicationContext)context).close();

    }
}
