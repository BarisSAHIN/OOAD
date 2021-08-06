/**
 * Test class for Iterator Pattern
 */

public class MainTest {

    public static void main(String[] args) {
        int[][] testdata = new  int[4][4];
        int val=1;

        System.out.println("Satellite Transmits Data ");
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                testdata[i][j] =val;
                val++;
                System.out.print(testdata[i][j] + " ");
                if (testdata[i][j]< 10)
                    System.out.print(" ");
            }
            System.out.println();

        }

        STDRepository testRepository = new STDRepository(testdata);
        System.out.print("ORDER: ");
        for(Iterator iter = testRepository.getIterator(); iter.hasNext();){
            int x = (int)iter.next();
            System.out.print(x + " ");
        }

    }
}
