package pl.coderslab.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("====================== liczby zmiennoprzecinkowe =====================");
        String reg1 = "^\\d*\\.{1}\\d*$";
        System.out.println(Pattern.matches(reg1, "3.78"));
        System.out.println(Pattern.matches(reg1, "5.65"));
        System.out.println(Pattern.matches(reg1, "123.123"));

        System.out.println("====================== liczby w notacji naukowej =====================");
        String reg2 = "^\\d*\\.{0,}\\d{0,}[eE]{0,}[\\+\\-]{0,}\\d{1,}$";
        System.out.println(Pattern.matches(reg2, "5.4325e+04"));
        System.out.println(Pattern.matches(reg2, "2.0000342E-06"));
        System.out.println(Pattern.matches(reg2, "0.3e10"));

        System.out.println("====================== data dd/mm/yyyy bez uwzgledniania przestepnych ===================");
        String reg31 = "^(([0-2][0-9]|[3][0-1])\\/([0][1|3-9]|[1][0-2]))\\/([0-9][0-9][0-9][0-9])$"; // oprocz luty
        String reg32 = "^(([0-2][0-8])\\/([0][2]))\\/([0-9][0-9][0-9][0-9])$"; // luty
        // do przestepnych dodatkowy reg33 string trzeba zrobic ktory tylko co 4 lata bedzie chwytal
        // dodatkowo nie uwzglednilem miesiecy krotszych niz 31 dni oprocz lutego ktory uwzglednilem
        System.out.println(checkDate1(reg31,reg32,"01/01/0001"));
        System.out.println(checkDate1(reg31,reg32,"03/09/3001"));
        System.out.println(checkDate1(reg31,reg32,"28/02/1956"));
        System.out.println(checkDate1(reg31,reg32,"01/02/2001"));
        System.out.println(checkDate1(reg31,reg32,"11/02/2001"));
        System.out.println(checkDate1(reg31,reg32,"32/02/2002"));
        System.out.println(checkDate1(reg31,reg32,"23/00/2222"));
        System.out.println(checkDate1(reg31,reg32,"29/02/2002"));
        System.out.println(checkDate1(reg31,reg32,"30/02/2002"));
        System.out.println(checkDate1(reg31,reg32,"20/02/2001"));
        System.out.println(checkDate1(reg31,reg32,"01/02/2000"));
        System.out.println(checkDate1(reg31,reg32,"01/11/2001"));
        System.out.println(checkDate1(reg31,reg32,"01/12/2001"));
        System.out.println(checkDate1(reg31,reg32,"01/09/1501"));
        System.out.println(checkDate1(reg31,reg32,"01/10/1601"));
        System.out.println(checkDate1(reg31,reg32,"01/10/0000"));

        System.out.println("====================== data yyyy-mm-dd rok>2000 bez przestepnych ========================");
        String reg41 = "^([2-9][0-9][0-9][0-9])\\-([0][1|3-9]|[1][0-2])\\-([0][1-9]|[1-2][0-9]|[3][0-1])$"; // oprocz luty
        String reg42 = "^([2-9][0-9][0-9][0-9])\\-([0][2])\\-([0-1][0-9]|[2][0-8])$"; //luty
        System.out.println(checkDate1(reg41,reg42,"3001-09-03"));
        System.out.println(checkDate1(reg41,reg42,"2956-02-28"));
        System.out.println(checkDate1(reg41,reg42,"2001-02-01"));
        System.out.println(checkDate1(reg41,reg42,"2001-02-11"));
        System.out.println(checkDate1(reg41,reg42,"2002-02-32"));
        System.out.println(checkDate1(reg41,reg42,"2222-00-23"));
        System.out.println(checkDate1(reg41,reg42,"2002-02-29"));
        System.out.println(checkDate1(reg41,reg42,"2002-02-30"));
        System.out.println(checkDate1(reg41,reg42,"2001-02-20"));
        System.out.println(checkDate1(reg41,reg42,"2000-02-09"));
        System.out.println(checkDate1(reg41,reg42,"2001-11-01"));
        System.out.println(checkDate1(reg41,reg42,"2001-12-01"));
        System.out.println(checkDate1(reg41,reg42,"2001-12-00"));
    }

    public static boolean checkDate1(String regex1, String regex2, String candidate) {
        boolean check1 = Pattern.matches(regex1, candidate);
        boolean check2 = Pattern.matches(regex2, candidate);
        return check1 || check2;

    }
}


/*
#### Zadanie 3


1. W pliku `Main2.java` do zmiennych **reg1**, **reg2**, **reg3**, **reg4** wpisz kolejno wyrażenia regularne, opisujące:

    * liczby zmiennoprzecinkowe (5.65 , 123.123)
    * liczby w notacji naukowej ( 5.4325e+04 ; 2.0000342E-06)
    * datę w formacie `dd/mm/yyyy`
    * datę w formacie `yyyy-mm-dd` - gdzie rok jest powyżej 2000
    *
 */