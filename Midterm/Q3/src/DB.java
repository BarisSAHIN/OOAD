import java.util.ArrayList;

/**
 * Our Originator class in Memento pattern and Receiver in Command Pastern
 *
 * */
public class DB {

    ArrayList<Table> tables;

    DB(){
        tables = new ArrayList<>();
    }
    public Backup save() {
        return new Backup(tables);
    }
    public void restore(Backup backupFile){
        tables = backupFile.getState();
    }
     /**
      *
      * Memento class for Memento Pattern
      *
      * */
     class Backup {
        private ArrayList<Table> tables;
        Backup(ArrayList<Table> gTables){
            tables = new ArrayList<>();
            tables.addAll(gTables);

        }
        private ArrayList<Table> getState(){
            return tables;
        }
    }
    /**
     * Delete oldest table in DB
     *
     * */
    public void delTable(){
        tables.remove(0);
    }
    /**
     * Print table names
     *
     * */
    public void print(){
        if(tables.size() == 0){
            System.out.println("There is no table in DB");
            return;
        }
        for (int i = 0;i<tables.size();i++){
            System.out.println("Table name: " + tables.get(i).tableName);
        }
    }
}
