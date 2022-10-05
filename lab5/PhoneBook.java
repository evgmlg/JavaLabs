package com.vyatsu.задание5;

import java.util.*;

public class PhoneBook {

    private TreeMap<String,Set<String>> persons = new TreeMap<>();

    public void add(String name, String number){
        boolean rep = true;
        {
            for(Set x : persons.values()){
                if(x.contains(number)) rep = false;
            }
            if(rep){
                if(persons.containsKey(name)){
                    if(persons.get(name).add(number) == false){
                        System.out.println("Номер " + number + " уже существует, добавить невозможно.");
                    }
                }
                else{
                    persons.put(name, new HashSet<String>(Collections.singleton(number)));
                }
            }
            else{
                System.out.println("Номер " + number + " уже существует, добавить невозможно.");
            }
        }
    }
    public void get(String name){
        if(this.persons.containsKey(name)){
            System.out.println(this.persons.get(name).toString());
        }
    }
    public void getAll(){
        for(var pair : persons.entrySet()){
            String name = pair.getKey();
            Set<String> number = pair.getValue();
            System.out.println(name + ": " + number);
        }
    }
}
