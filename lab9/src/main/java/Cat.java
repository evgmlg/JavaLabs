
public class Cat{

    @Table(title = "Cats")
    public void SomeMethod(){ System.out.println("Some method");}
    @Column
    public String name;
    @Column
    public int age;
    @Column
    public String color;

    public String parent;

    public Cat (String name, int age, String color, String parent){
        this.name = name;
        this.age = age;
        this.color = color;

    }
}
