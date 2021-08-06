package sample;
import java.util.ArrayList;

/**
 * Concrete Factory for building Infected Individual one by one or bulkly
 *
 * */
public class InfectedIndividualFactory implements IndividualFactory{
    private double deathTimer;

    /**
     * InfectedState takes deathTime so this factory needs deathTime
     *
     * */
    InfectedIndividualFactory(double gDeathTimer){
        deathTimer = gDeathTimer;
    }

    /**
     * For creating many infected
     * */
    @Override
    public ArrayList<Individual> createMany(int count) {
        ArrayList<Individual> individuals = new ArrayList<>();
        for (int i = 0; i<count;i++)
            individuals.add(new Individual(new InfectedState(deathTimer)));
        return individuals;
    }

    /**
     * For creating one infected with given parameters
     * */
    @Override
    public Individual createOne(int gC, boolean gMask, int gDistance, int gSpeed) {
        return new Individual(new InfectedState(deathTimer),gC,gMask,gDistance,gSpeed);
    }
}
