package pl.coderslab.collection;

import java.util.regex.Pattern;

public class Main3 {

    public static void main(String[] args) {

        System.out.println(verifyLogin("ada5"));
        System.out.println(verifyLogin("9ada5"));
        System.out.println(verifyLogin("ad-m35"));
        System.out.println(verifyLogin("ga-_da5"));
    }

    static boolean verifyLogin(String login) { // uzaje ze zgodnie z trescia zadania mam zweryfikowac login a nie email
        String regex = "^[_\\-a-zA-Z][_\\-a-zA-Z0-9]{4,}$";
        return Pattern.matches(regex, login);

    }
}

/*
#### Zadanie 4
W pliku `Main3.java`
1. Napisz metodę `static boolean verifyLogin(String email)`,
która zwróci **true** jeżeli ciąg znaków:
    * Ma minimum 5 znaków.
    * Zawiera tylko litery, cyfry, znak podkreślenia, myślnik
    * Nie zaczyna się od cyfry
**false** w przeciwnym wypadku.
 */
