package pl.coderslab.collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main11 {
    public static void main(String[] args) {
        List<String> newList = topThree("earnings.txt").subList(0, 3);
        for (String string : newList) {
            System.out.println(string);
        }
    }

    static boolean verifyEarnings(String entry) {
        boolean testName = entry.matches("(?i).*(Kowalsk){1}.*");
        return testName;
    }

    public static List<String> topThree(String filename) {
        List<String> topList = new ArrayList<>();
        Pattern pat = Pattern.compile("(\\D*)(\\d*\\.?\\d*)([ ]zł]?)(\\D*)");
        Matcher m;
        Path path1 = Paths.get(filename);
        try {
            for (String line : Files.readAllLines(path1)) {
                m = pat.matcher(line);
                if (m.matches() && !verifyEarnings(line) && m.group(2) != null) {
                    topList.add(m.group(2) + " - " + m.group(1) + m.group(4));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading from file.");
        }
        Collections.sort(topList, new Comparator<String>() {
            public int compare(String s1, String s2) {
                double pop1 = Double.parseDouble(s1.split(" ")[0]);
                double pop2 = Double.parseDouble(s2.split(" ")[0]);
                return Double.compare(pop2, pop1);
            }
        });
        return topList;
    }
}
// powyzej cudze rozwiazanie dla zadania z main1 - o wiele bardziej eleganckie niz w Main1
// nie kumam tego co sie dzieje po Collectons.sort wyrazen lambda i musze je zrozumiec zeby pojsc dalej


