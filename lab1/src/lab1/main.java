package lab1;

public class main {

    public static void main(String[] args){
        Animal[] animals = {
                new Dog("Бобик"),
                new Homecat("Рыжик"),
                new Tiger("Тигер"),
                new Karakul("Шлёпа"),
                new Karakul("Гоша"),
                new Hamster("Хоуми"),
                new Hamster("Хоуми2"),
                new Dog("Доги")
        };

        for (Animal animal : animals){
            animal.rundist(25);
            animal.swimdist(1);
        }

        System.out.println("Количество животных: "+ Animal.animalcount);
        System.out.println("Количество домашних котов: "+ Homecat.homecatcount);
        System.out.println("Количество песелей: "+ Dog.dogcount);
        System.out.println("Количество тигров: "+ Tiger.tigercount);
        System.out.println("Количество каракулов: "+ Karakul.karakulcount);
        System.out.println("Количество хоумяков: "+ Hamster.hamstercount);
        ((HomePets)animals[1]).owner();
    }
}
