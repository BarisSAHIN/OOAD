package sample;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
/**
 * Concrete Factory for building Healty Individual one by one or bulkly
 *
 * */
public class HealtyIndividualFactory implements IndividualFactory{

    /**
     * For creating many healty state
     * */
    @Override
    public ArrayList<Individual> createMany(int count) {
        ArrayList<Individual> individuals = new ArrayList<>();
        for (int i = 0; i<count;i++)
            individuals.add(new Individual(new HealtyState()));
        return individuals;
    }
    /**
     * For creating one healty with given parameters
     * */
    @Override
    public Individual createOne(int gC, boolean gMask, int gDistance, int gSpeed) {
        return new Individual(new HealtyState(),gC,gMask,gDistance,gSpeed);
    }
}
