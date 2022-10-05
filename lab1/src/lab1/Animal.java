package lab1;

class Animal {
    int maxrundist;
    int maxswimdist;
    String name;
    public static short animalcount = 0;

    public Animal(int maxrundist, int maxswimdist, String name){
        this.maxrundist = maxrundist;
        this.maxswimdist = maxswimdist;
        this.name = name;
        animalcount++;
    }


    public void rundist(int maxrun){
        if(maxrun > maxrundist){
            System.out.println(name+" смог пробежать только "+maxrundist +"м");
        }
        else{
            System.out.println(name+" пробежал "+maxrun+"м");
        }
    }

    public void swimdist(int maxswim){
        if(maxswim > maxswimdist){
            System.out.println(name+" не смог проплыть дистанцию "+maxswim +"м");
        }
        else{
            System.out.println(name+" проплыл дистанцию "+maxswim +"м");
        }
    }
}
