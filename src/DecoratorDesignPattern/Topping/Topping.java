package DecoratorDesignPattern.Topping;

import DecoratorDesignPattern.Pizza.BasePizza;

public abstract class Topping extends BasePizza {
    public abstract int cost();
}
