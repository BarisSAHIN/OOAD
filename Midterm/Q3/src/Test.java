/**
 * Test clas for midterm MementoQ3
 *
 * */
public class Test {
    public static void main(String[] args){

        DB database = new DB();
        Engine dbEngine = new Engine(database);

        Table table = new Table();
        table.tableName = "0. table";

        Table table1 = new Table();
        table1.tableName = "1. table";


        Table table2 = new Table();
        table2.tableName = "2. table";

        database.tables.add(table);
        database.tables.add(table1);
        database.tables.add(table2);

        String[][] transaction = {{"SELECT","Param1","Param2","Paran3"},
                {"SELECT","Param1","Param2","Paran3"},
                {"ALTER","Param1","Param2","Paran3"},
                {"ALTER","Param1","Param2","Paran3"},
                {"ALTER","Param1","Param2","Paran3"},
                {"UPDATE","Param1","Param2","Paran3"}};


        String[][] transaction1 = {{"SELECT","Param1","Param2","Paran3"},
                {"SELECT","Param1","Param2","Paran3"},
                {"ALTER","Param1","Param2","Paran3"},
                {"ALTER","Param1","Param2","Paran3"},
                {"ALTER","Param1","Param2","Paran3"}};

        System.out.println("Start Of DB:");
        database.print();
        System.out.println("//////////////////////");
        dbEngine.doTransaction(transaction);
        System.out.println("#####################################\nAfter \"SELECT\",\"SELECT\",\"ALTER\",\"ALTER\",\"ALTER\",\"UPDATE\"(fail) transaction:");
        database.print();
        System.out.println("#####################################");
        dbEngine.doTransaction(transaction1);
        System.out.println("#####################################\nAfter \"SELECT\",\"SELECT\",\"ALTER\",\"ALTER\",\"ALTER\" transaction:");
        database.print();
        System.out.println("#####################################");

    }
}
