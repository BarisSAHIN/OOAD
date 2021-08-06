public class AutoRifle extends BattleSuitDecorator{

    private final String name = "Auto Rifle";
    private final int price = 30000;
    private final double weight = 1.5;
    protected BattleSuit upgradeSuit;

    public AutoRifle(BattleSuit upgrade){
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
