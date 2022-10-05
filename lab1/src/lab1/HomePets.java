package lab1;

public class HomePets extends Animal {

    String owner;

    public HomePets(int maxrundist, int maxswimdist, String name, String owner){
        super(maxrundist, maxswimdist, name);
        this.owner=owner;
    }
    public void owner(){
        System.out.println(owner+":"+name+", беги ко мне!");
    }

}
