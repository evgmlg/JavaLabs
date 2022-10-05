package com.vyatsu.задание5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        String[] names = {"Лермонтов", "Пушкин", "Толстой", "Ахматова", "Есенин", "Толстой", "Чехов","Гоголь", "Пушкин","Ломоносв","Толстой","Маяковский","Бунин"};

        Set<String> uwords = new HashSet<>(Arrays.asList(names));
        System.out.println(uwords);
        System.out.println("");

        HashMap<String, Integer> wordList = new HashMap<>();
        for (String a : names){
            wordList.merge(a, 1, Integer::sum);
        }
        System.out.println(wordList.entrySet());
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Пушкин", "123456789");
        phoneBook.add("Пушкин", "123456789");
        phoneBook.add("Пушкин", "9876543");
        phoneBook.add("Фет", "123456789");
        phoneBook.add("Гоголь", "1234554");
        phoneBook.add("Толстой", "1357911");
        phoneBook.add("Петя" +
                "+", "1357911");
        phoneBook.add("Ахматова", "25476332");
        phoneBook.add("Маяковский", "87654321");
        phoneBook.add("Есенин", "21345637");

        phoneBook.getAll();
    }
}
