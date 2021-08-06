/**
 * Update command
 *Takes DB and parameters like table and column in a String Array
 * */
public class Update implements Command {
    DB reciver;
    String[] params;

    Update(DB database,String[] args){
        reciver = database;
        params = args;
    }
    /**
     * For showing backup system and rolling back work this command does nothing and return always fail
     * */
    @Override
    public int execute() {
        System.out.println("Update Executed");
        return 1;
    }
}
