/**
 * Alter command
 *Takes DB and parameters like table and column in a String Array
 * */
public class Alter implements Command {
    DB reciver;
    String[] params;

    Alter(DB database,String[] args){
        reciver = database;
        params = args;
    }
    /**
     * For showing backup system and rolling back work this command delete oldest table in DB and return always success
     * */
    @Override
    public int execute() {
        System.out.println("Alter Executed");
        reciver.delTable();
        return 0;
    }
}
