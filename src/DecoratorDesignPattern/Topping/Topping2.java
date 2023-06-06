package DecoratorDesignPattern.Topping;

import DecoratorDesignPattern.Pizza.BasePizza;

public class Topping2 extends Topping {
    BasePizza basePizza;

    public Topping2(BasePizza pizza) {
        this.basePizza = pizza;
        System.out.println("Topping 2 is added!");
    }

    public int cost() {
        return this.basePizza.cost() + 20;
    }
}
