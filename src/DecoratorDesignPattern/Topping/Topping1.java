package DecoratorDesignPattern.Topping;

import DecoratorDesignPattern.Pizza.BasePizza;

public class Topping1 extends Topping {
    BasePizza basePizza;

    public Topping1(BasePizza pizza) {
        this.basePizza = pizza;
        System.out.println("Topping 1 is added!");
    }

    public int cost() {
        return this.basePizza.cost() + 10;
    }
}
