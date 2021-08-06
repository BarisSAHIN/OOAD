public class Ora implements BattleSuit{
    @Override
    public String getName() {
        return "Ora";
    }

    /**
     * Get price of the suit.
     * @return Returns the price of suit, int.
     */
    @Override
    public int getPrice() {
        return 1500000;
    }

    /**
     * Get Weight of the suit.
     * @return Returns the price of suit, double.
     */
    @Override
    public double getWeight() {
        return 30;
    }
}
