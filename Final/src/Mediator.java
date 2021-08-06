package sample;


/**
 *
 * Our mediator class
 *
 * It will do collide and hospitalize works
 *
 * **/
public class Mediator {

    /**
     * Distance function for the collision
     *
     * */
    private static double distance(Individual I1, Individual I2){
        double centerX1 = I1.getX()+2.5;
        double centerY1 = I1.getY()+2.5;

        double centerX2 = I2.getX()+2.5;
        double centerY2 = I2.getY()+2.5;

        return Math.sqrt((Math.pow(centerX1-centerX2,2)+Math.pow(centerY1-centerY2,2)))-5.0;
    }

    /**
     * It checks if two individual collides
     *
     *
     * */
    public static boolean isColliding(Individual I1,Individual I2) {
        if(distance(I1,I2) <= Math.min(I1.getD(),I2.getD())+5){
            if(I1.getStateName() == HealthStateNames.INCONTACT || I2.getStateName() == HealthStateNames.INCONTACT )
                return false;
            else
                return true;
        }
        else
            return false;
    }

    /**
     *
     * It calculates contact result and sets new states for individuals if one of them is infected
     *It will just set their current states as next state and change theşr states to collision state
     * */
    public static void contact(Individual I1,Individual I2,double rate,double deathTimer) {

        int D = Math.min(I1.getD(),I2.getD());
        int C = Math.max(I1.getC(),I2.getC());

        if((I1.getStateName()== HealthStateNames.INFECTED && I2.getStateName() == HealthStateNames.HEALTY) ||
           (I2.getStateName()== HealthStateNames.INFECTED && I1.getStateName() == HealthStateNames.HEALTY)){
            double calculatedP = Math.min(rate * (1.0+C/10.0) * I1.getMask() * I2.getMask() * (1.0-D/10.0),1.0);

            double randomP = I1.rand.nextInt(100)/100.0;
            if(calculatedP>=randomP){// Infected
                if(I1.getStateName() == HealthStateNames.HEALTY){
                    I1.changeState(new CollisionState(new InfectedState(deathTimer),C));
                    I2.changeState(new CollisionState(I2.getState(),C));
                }
                else{
                    I2.changeState(new CollisionState(new InfectedState(deathTimer),C));
                    I1.changeState(new CollisionState(I1.getState(),C));
                }
                return;
            }
        }
        I1.changeState(new CollisionState(I1.getState(),C));
        I2.changeState(new CollisionState(I2.getState(),C));
    }

    /**
     * takes an individual and a hospital changes individual state to healty and calls hospitals discharge function
     *
     * */
    public static void dischargeIndividual(Individual content, Hospital hospital) {
        if(!hospital.isEmpty()){
            hospital.discharge();
            content.changeState(new HealtyState());
        }
        return;
    }

    /**
     * Takes an Individual and change its state to hospitalized
     * and calls hospitals hospitalize function
     * */
    public static void hospitalize(Individual I, Hospital H){
        if(H.isEmpty()){
            I.changeState(new HospitalizedState(H));
            H.hospitalize();
        }
        return;
    }
}
