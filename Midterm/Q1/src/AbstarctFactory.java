
/**
 * Abstract Factory for our Region based factories
 * Its not a interface because function that gives blueprint is should be protected
 * and interfaces cant have a protected function
 * */
public abstract class AbstarctFactory {
    /**
     * Gives you a fully attached phone
     *
     *
     * */
    public abstract AbstractPhone takeOrder(Model model);
    /**
     *
     * Gives the blueprint of a phone model
     *
     *
     * */
    protected abstract AbstractPhone choosePhone(Model model);
}
