public class Laser extends BattleSuitDecorator{

    private final String name = "Laser";
    private final int price = 200000;
    private final double weight = 5.5;
    protected BattleSuit upgradeSuit;

    public Laser(BattleSuit upgrade){
        this.upgradeSuit = upgrade;
    }
    /**
     * Return the decorated Suit's price plus accessorise price.
     * @return
     */
    @Override
    public String getName() {
        String returnVal = name + "," + upgradeSuit.getName();
        return returnVal;
    }

    /**
     * Return the decorated Suit's price plus accessorise price.
     * @return
     */
    @Override
    public int getPrice() {
        int returnVal = upgradeSuit.getPrice() + price;
        return returnVal;
    }
    /**
     * Return the decorated Suit's weight plus accessorise weight.
     * @return
     */
    @Override
    public double getWeight() {
        double returnVal = upgradeSuit.getWeight() + weight;
        return returnVal;
    }
}
