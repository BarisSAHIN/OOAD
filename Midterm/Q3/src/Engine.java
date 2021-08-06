import java.util.Stack;
/**
 * Our Caretaker class for Memento
 *
 * */
public class Engine {

    private DB database;
    private Stack<Object> dbBackups;

    Engine(DB db){
        database = db;
        dbBackups = new Stack<>();
    }
    /**
     *
     * Create Backup(Memento) of system by using Orginator's save
     *
     * */
    public void backupDB(){
        dbBackups.push(database.save());
    }
    /**
     * Restores the system from last backup by using Orginator's restore
     *
     * */
    public void restoreBackup(){
        database.restore((DB.Backup)dbBackups.pop());
    }

    /**
     * Parse the transaction and call doCommand function for  process parsed commands
     * Will take a backup before starting the parsing transaction by calling backupDB()
     * If an error occurs during a processing a command it will restore system from last backup by calling restoreBackup()
     *
     * */
    public void doTransaction(String[][] Transaction){

        backupDB();
        for(int i = 0;i<Transaction.length;i++){
            if(doCommand(Transaction[i][0],Transaction[i]) == 1){
                System.out.println("Wrong code rolling back");
                restoreBackup();
                return;
            }
            System.out.println("Command Successfully applied DB state:");
            database.print();
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
        System.out.println("Transaction Successfully applied DB state:");
        database.print();

    }

    /**
     *Calls given command
     *
     * @return 1 as error in command 0 as Successful command -1 no such command
     *
     * */
    public int doCommand(String command,String[] params){
        if(command == "SELECT")
            return new Select(database,params).execute();
        if(command == "UPDATE")
            return new Update(database,params).execute();
        if(command == "ALTER")
            return new Alter(database,params).execute();
        return -1;
    }
}
