import java.io.*;
import java.util.Scanner;

/**
 * Discrete Cosine Transform for 1D
 */

public class DCT extends FunctionTransform {

    double[] arr;
    double[] out;
    double[] cons;

    int N = 0;


    String inputPath;
    String outputPath;
    DCT(String input,String output){
        inputPath = input;
        outputPath = output;
    }
    @Override
    public void readFromFile() throws FileNotFoundException {
        File file = new File(inputPath);
        Scanner sc = new Scanner(file);
        N = sc.nextInt();

        arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextDouble();
        }
    }

    @Override
    public void writeToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Output");

        for (int i = 0; i < out.length; i++) {
            printWriter.println(out[i]);
        }
        printWriter.close();
    }

    @Override
    public void solve() {
        cons = new double[N];
        out = new double[N];

        for (int i = 1; i < N; i++) {
            cons[i] = 1;
        }
        cons[0] =  (1 / Math.sqrt(2.0));

        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N ; j++) {
                double sum = 0.0;
                for (int k = 0; k <N ; k++) {
                    for (int l = 0; l < N ; l++) {
                        sum += Math.cos(((2 * k + 1) / (2.0 * N)) * i * Math.PI) * Math.cos(((2 * l + 1) / (2.0 * N)) * j * Math.PI) * (arr[k]);
                    }
                    sum *= ((cons[i] * cons[j]) / 4.0);
                    out[i] = sum;
                }

            }

        }
    }

    @Override
    public boolean ExecTimeWant() {
        //In DCT there is no need for this function
        return true;
    }
}
