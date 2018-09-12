package pl.coderslab.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GenerateRandom {

    public static void main(String[] args) {
        Map<Integer, Integer> map = checkRand(500000, 10);
        Set<Integer> keys = map.keySet();
        for (Integer i : keys) {
            System.out.println("Liczbę (klucz): " + i + " | wylosowano: " + map.get(i) + "razy.");
        }
    }

    public static Map<Integer, Integer> checkRand(int amount, int interval) {
        Map<Integer, Integer> result = new HashMap<>();
        Random generator = new Random();
        for (int i = 0; i < amount; i++) {
            int tmp = generator.nextInt(interval);
            if (result.containsKey(tmp)) {
                result.put(tmp, result.get(tmp) + 1);
            } else {
                result.put(tmp, 1);
            }
        }
        return result;
    }
}
