public class RocketLauncher extends BattleSuitDecorator{

    private final String name = "Rocket Launcher";
    private final int price = 150000;
    private final double weight = 7.5;
    protected BattleSuit upgradeSuit;

    public RocketLauncher(BattleSuit upgrade){
        this.upgradeSuit = upgrade;
    }
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
