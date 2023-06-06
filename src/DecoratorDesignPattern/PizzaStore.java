package DecoratorDesignPattern;

import DecoratorDesignPattern.Pizza.BasePizza;
import DecoratorDesignPattern.Pizza.Pizza1;
import DecoratorDesignPattern.Topping.Topping;
import DecoratorDesignPattern.Topping.Topping1;
import DecoratorDesignPattern.Topping.Topping2;

public class PizzaStore {
    public static void main(String args[]) {
        BasePizza pizza1 = new Pizza1();
        Topping pizzaWithTopping = new Topping1(pizza1);

        System.out.println(pizzaWithTopping.cost());

        System.out.println(new Topping1(new Topping2(new Pizza1())).cost());
    }

}
