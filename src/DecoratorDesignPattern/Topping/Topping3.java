package DecoratorDesignPattern.Topping;

import DecoratorDesignPattern.Pizza.BasePizza;

public class Topping3 extends Topping {
    BasePizza basePizza;

    public Topping3(BasePizza pizza) {
        this.basePizza = pizza;
        System.out.println("Topping 3 is added!");
    }

    public int cost() {
        return this.basePizza.cost() + 30;
    }
}
