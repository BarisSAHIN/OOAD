package sample;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
/**
 * Factory interface for our factories
 *
 * */
public interface IndividualFactory {
    ArrayList<Individual> createMany(int count);
    Individual createOne(int gC, boolean gMask, int gDistance, int gSpeed);
}
