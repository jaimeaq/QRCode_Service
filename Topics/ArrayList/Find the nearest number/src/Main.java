import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int minDistance = -1;
        ArrayList<Integer> outputList = new ArrayList<>();

        String input = scanner.nextLine();
        int n = scanner.nextInt();

        String[] inputArray = input.split(" ");
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(inputArray));

        for (String s : inputList) {
            int currNumber = Integer.parseInt(s);
            int currDistance = Math.abs(n - currNumber);

            if (minDistance == -1) {
                minDistance = currDistance;
            } else if (currDistance < minDistance) {
                minDistance = currDistance;
            }
        }

        for (String s : inputList) {
            int currNumber = Integer.parseInt(s);
            int currDistance = Math.abs(n - currNumber);

            if (currDistance == minDistance) {
                outputList.add(currNumber);
            }
        }

        Collections.sort(outputList);

        for (int i : outputList) {
            System.out.print(i + " ");
        }
    }
}