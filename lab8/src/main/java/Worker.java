public class Worker
{
    public String name;
    public gender gen;
    public enum gender {
        Boy, Girl;
    }
        public int age;
    public int salary;
    public dolsh work;
    public enum dolsh{
        Enginer, Cleaner;

        /*private final String name;

        dolsh(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }*/
    }

    public String getName() {
        return name;
    }

    public gender getGender() {
        return gen;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public dolsh getWork() {
        return work;
    }

    public Worker(String name, gender gen, int age, int salary, dolsh work) {
        this.name = name;
        this.gen = gen;
        this.age = age;
        this.salary = salary;
        this.work = work;
    }
}
