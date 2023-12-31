import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int rndNumber = 0;
        int maxOfN = 0;
        int currNumber = 0;
        int minOfMax = 0;
        int theSeed = 0;

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        minOfMax = k;

        for (int i = a; i <= b; i++) {
            Random random = new Random(i);
            maxOfN = 0;
            for (int j = 0; j < n; j++) {
                rndNumber = random.nextInt(k);
                if (rndNumber > maxOfN) {
                    maxOfN = rndNumber;
                }
            }

            currNumber = maxOfN;
            if (currNumber < minOfMax) {
                minOfMax = currNumber;
                theSeed = i;
            }
        }

        System.out.println(theSeed);
        System.out.println(minOfMax);
    }
}