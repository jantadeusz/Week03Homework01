package pl.coderslab.collection;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Main1 {
    public static void main(String[] args) {

        List<String> listOfEarnings = createListOfEarnings("earnings.txt");
        System.out.println("============== list of earnings ================================");
        for (String s : listOfEarnings) {
            System.out.println(s);
        }
        List<String> filteredList = filterListOfEarnings(listOfEarnings, "Kowalsk");
        System.out.println("============== filtered list ================================");
        for (String s : filteredList) {
            System.out.println(s);
        }
        Map<String, Double> mapOfEarnings = createMapOfEarnings(filteredList);
        Set<String> keys = mapOfEarnings.keySet();
        System.out.println("======================= keys =====================================");
        for (String str : keys) {
            System.out.println("Klucz: " + str + " | wartość: " + mapOfEarnings.get(str));
        }

        System.out.println("========= final list of employess to remove from company - solution of exercise =========");
        List<String> finalList = employeesWithBiggestSalary(filteredList, 3);
        for (String s : finalList) {
            System.out.println(s);
        }

        System.out.println("=============== better solution using Collections.sort ==================================");
        Collections.sort(filteredList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                double d1 = Double.parseDouble(o1.split(" ")[2]);
                double d2 = Double.parseDouble(o2.split(" ")[2]);
                return Double.compare(d2, d1);
            }
        });
        List<String> alternativeFinal = filteredList.subList(0, 3);
        for (String s : alternativeFinal) {
            System.out.println(s);
        }

    }
/*
komentarz:
moożna to zadanie zrobić z użyciem TreeMap ale wymaga to używania wyrażeń lambda
i utworzenia dodatkowej klasy ValueComparator
-------------------------------------------------------------------dojdę do tego

 */

    public static List<String> createListOfEarnings(String filename) {
        List<String> result = new ArrayList<>();
        File file = new File(filename);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            String tmp = sc.nextLine();
            System.out.println(tmp);
            result.add(tmp);
        }
        return result;
    }

    public static List<String> filterListOfEarnings(List<String> list, String unwantedText) {
        List<String> filteredList = new ArrayList<>();
        String regex = ".*\\d+.*";
        for (String str : list) {
            if (Pattern.matches(regex, str) && !str.contains(unwantedText)) {
                filteredList.add(str);
            }
        }
        return filteredList;
    }

    public static Map<String, Double> createMapOfEarnings(List<String> list) {
        Map<String, Double> result = new HashMap<>();
        for (String str : list) {
            String[] record = str.split(" ");
            Double salary = Double.parseDouble(record[2]);
            if (salary != null) {
                result.put(str, salary);
            } else {
                result.put(str + " | sth went wrong", 0.0);
            }
        }
        return result;
    }

    public static List<String> employeesWithBiggestSalary(List<String> list, int numberOfEmployees) {
        String[] temp = new String[list.size()];
        int counter = 0;
        for (String str : list) {
            String[] record = str.split(" ");
            Double salary = Double.parseDouble(record[2]);
            if (salary != null) {
                temp[counter] = String.valueOf(salary) + " original record -> " + str;
                counter += 1;
            }
        }
        Arrays.sort(temp, Collections.reverseOrder());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < numberOfEmployees; i++) {
            result.add(temp[i]);
        }
        return result;
    }
}
/*

#### Zadanie 2

Ze względu na oszczędności w pewnej firmie planowane są zwolnienia najlepiej opłacanych pracowników,
którzy nie są spokrewnieni z szefem o nazwisku **Kowalski**.

1. W pliku `Main1.java` napisz program, który wczyta dane z pliku `earnings.txt`.

2. Wyświetli listę 3 pracowników z największymi zarobkami, których nazwisko nie jest takie samo jak szefa (Kowalski).

    * Zwróć uwagę że nazwisko to może się odmieniać (Kowalski, Kowalska).
    * Zwróć uwagę na ułożenie danych w pliku, występują linie które nie zawierają płac.
    * Zwróć uwagę że ułożenie danych w pliku może się zmieniać.
    * Zwróć uwagę że kolejność danych w lini może być przestawiona.
 */
