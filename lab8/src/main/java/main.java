import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args)
    {
        System.out.println("Задание 1");
        List<String> listy = new ArrayList<>(Arrays.asList("Яблоко","Апельсин","Роза","Апельсин"));
        listy.stream().forEach(x -> Collections.frequency(listy,x));
        List<Integer> misty = listy.stream().distinct().map(x -> Collections.frequency(listy,x)).collect(Collectors.toList());
        System.out.println(listy.get(misty.indexOf(Collections.max(misty))));

        System.out.println("Задание 2");
        List<Worker> workers = new ArrayList<>(Arrays.asList(
                new Worker( "Диана",   Worker.gender.Girl, 17, 300,  Worker.dolsh.Enginer),
                new Worker( "Артём",   Worker.gender.Boy , 49, 300,  Worker.dolsh.Enginer),
                new Worker( "Света",   Worker.gender.Girl, 18, 300,  Worker.dolsh.Enginer),
                new Worker( "Илья",    Worker.gender.Boy,  75, 300,  Worker.dolsh.Cleaner),
                new Worker( "Лиза",    Worker.gender.Girl, 37, 300,  Worker.dolsh.Cleaner),
                new Worker( "Жанна",   Worker.gender.Girl, 84, 200,  Worker.dolsh.Cleaner),
                new Worker( "Никита",  Worker.gender.Boy,  25, 200,  Worker.dolsh.Cleaner),
                new Worker( "Люда",    Worker.gender.Girl, 35, 200,  Worker.dolsh.Enginer),
                new Worker( "Борис",   Worker.gender.Boy,  55, 200,  Worker.dolsh.Enginer),
                new Worker( "Ибрагим", Worker.gender.Boy,  39, 200,  Worker.dolsh.Enginer)
                ));
        System.out.println(workers.stream().mapToDouble(Worker -> Worker.salary).average());

        System.out.println("Задание 3");
        Oldy(3,workers);
        System.out.println("Доп");
        GenderSort(3,workers);
    }

    public static void Oldy(int n, List<Worker> x)
    {
         System.out.println(x.stream()
                 .sorted(Comparator.comparing(Worker::getAge).reversed())
                 .limit(n)
                 .sorted(Comparator.comparing(Worker::getName))
                 .map(Worker -> Worker.name)
                 .collect(Collectors.joining( " , " ,n+"-х самых старших сотрудников зовут " , ";" )));
            }
    public static void GenderSort(int n, List<Worker> x)
    {
        System.out.println(x.stream()
                .filter(worker -> worker.gen == Worker.gender.Boy)
                .sorted(Comparator.comparing(Worker::getAge).reversed())
                .limit(n)
                .sorted(Comparator.comparing(Worker::getName))
                .map(Worker -> Worker.name)
                .collect(Collectors.joining( " , " ,n+"-х самых старших мужчин сотрудников зовут " , ";" )));
        System.out.println(x.stream()
                .filter(worker -> worker.gen == Worker.gender.Girl)
                .sorted(Comparator.comparing(Worker::getAge).reversed())
                .limit(n)
                .sorted(Comparator.comparing(Worker::getName))
                .map(Worker -> Worker.name)
                .collect(Collectors.joining( " , " ,n+"-х самых старших женщин сотрудников зовут " , ";" )));
    }

}
