import java.util.*;

class Main {
    private static int getOrMin(Map<String, Integer> map, String key) {
        // implement me
        if (map.get(key) == null) {
            return getMin(map);
        } else {
            return map.get(key);
        }
    }

    private static int getMin(Map<String, Integer> map) {
        int min = -1;

        for (int i : map.values()) {
            if (min == -1 || i < min) {
                min = i;
            }
        }
        return min;
    }

    // do not change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> m = new HashMap<>();
        int size = scanner.nextInt();
        for (int i = 0; i < size; ++i) {
            String key = scanner.next();
            int value = scanner.nextInt();
            m.put(key, value);
        }
        String key = scanner.next();
        int result = getOrMin(Map.copyOf(m), key);
        System.out.println(result);
    }
}