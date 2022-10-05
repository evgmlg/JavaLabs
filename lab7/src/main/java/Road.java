public class Road extends Stage {
    public Road(int lenght){
        this.length = lenght;
        this.description = "Дорога " + lenght + " метров";
    }

    public void go(Car c){
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
