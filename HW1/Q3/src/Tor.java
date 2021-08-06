public class Tor implements BattleSuit{

    @Override
    public String getName() {
        return "Tor";
    }

    /**
     * Get price of the suit.
     * @return Returns the price of suit, int.
     */
    @Override
    public int getPrice() {
        return 5000000;
    }

    /**
     * Get Weight of the suit.
     * @return Returns the price of suit, double.
     */
    @Override
    public double getWeight() {
        return 50;
    }
}
