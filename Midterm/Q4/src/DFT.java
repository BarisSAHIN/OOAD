import java.io.*;
import java.util.Scanner;

/**
 * Discrete Fourier Transform for 1D
 */

public class DFT extends FunctionTransform {

    double[] arr;
    double[] img;
    double[] real;
    boolean ans;
    long time;

    String inputPath;
    String outputPath;

    int N=0;

    DFT(String input,String output){
        inputPath = input;
        outputPath = output;
    }
    @Override
    public void readFromFile() throws FileNotFoundException {

        File file = new File(inputPath);
        Scanner sc = new Scanner(file);
        N= sc.nextInt();

        arr= new double[N];
        for (int i = 0; i <N ; i++) {
            arr[i] = sc.nextDouble();
        }
    }

    @Override
    public void writeToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Imagine");
        for (int i = 0; i <img.length; i++) {
            printWriter.println(img[i]);
        }
        printWriter.println("Real");
        for (int i = 0; i <real.length; i++) {
            printWriter.println(real[i]);
        }
        printWriter.close();
    }

    @Override
    public void solve() {
        long startTime = System.nanoTime();

        real = new double[N];
        img = new double[N];

        for (int i = 0; i < N; i++) {
            real[i] = 0;
            for (int j = 0; j < N ; j++) {
               real[i] += arr[j]* Math.cos(i*j*Math.PI /N);
            }
            img[i]=0;
            for (int j = 0; j < N ; j++) {
                img[i] -= arr[j]* Math.sin(i*j*Math.PI /N);
            }

        }
        long endTime = System.nanoTime();
        time = endTime-startTime;
        if (ans) {
            System.out.println("Execution time in nanoseconds  :" + time);
        }
    }

    @Override
    public boolean ExecTimeWant() {
            ans = false;
            System.out.println("Do you want to see working time? : y/n");
            Scanner reader = new Scanner(System.in);
            String opt = reader.next();
            if (opt == "y")
                ans = true;
            else if (opt == "n")
                ans = false;

            return ans;

    }
}

