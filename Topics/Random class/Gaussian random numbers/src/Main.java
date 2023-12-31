import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        boolean isSeedFound = false;
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        double M = Double.parseDouble(scanner.nextLine());
        int seedNumber = -1;

        for (int i = K; !isSeedFound; i++) {
            Random random = new Random(i);
            for (int j = 1; j <= N; j++) {
                double gaussianNumber = random.nextGaussian();
                if (gaussianNumber > M) {
                    isSeedFound = false;
                    break;
                }
                isSeedFound = true;
            }
            seedNumber = i;
        }
        System.out.println(seedNumber);
    }
}