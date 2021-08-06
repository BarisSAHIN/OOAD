import jdk.nashorn.internal.objects.annotations.Getter;
/**
 *
 *
 *
 * Interface for all battle suits and its decorators
 *
 * */
public interface BattleSuit {

    @Getter
    String getName();

    @Getter
    int getPrice();

    @Getter
    double getWeight();
}
