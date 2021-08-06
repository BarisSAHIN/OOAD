/**
 * Select command
 *Takes DB and parameters like table and column in a String Array
 * */
public class Select implements Command {
    DB reciver;
    String[] params;

    Select(DB database,String[] args){
        reciver = database;
        params = args;
    }
    /**
     * For showing backup system and rolling back work this command does nothing and return always success
     * */
    @Override
    public int execute() {
        System.out.println("Select Executed");
        return 0;
    }
}
