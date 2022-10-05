import java.io.PrintStream;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        boolean out_of_comp = false;
        IActions[] competitors = new IActions[]{
                new Human("Ибрагим", 1, 50),
                new Cat("Барсик", 100, 2),
                new Robot("Генадий", 100, 10)};
        IActions[] var4 = competitors;
        int var5 = competitors.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            IActions c = var4[var6];
            int n = 0;
            Barriers[] var8 = Barriers.values();
            int var9 = var8.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                Barriers barriers = var8[var10];
                PrintStream var10000;
                String var10001;
                if (barriers.getDimension() <= c.getJumpHeight() && n < 4 && barriers.getType() == 1) {
                    var10000 = System.out;
                    var10001 = c.getName();
                    var10000.println(var10001 + " преодолел " + barriers.getTitle());
                } else if (barriers.getType() == 1) {
                    if (!c.super_jump()) {
                        var10000 = System.out;
                        var10001 = c.getName();
                        var10000.println(var10001 + " не смог преодолеть " + barriers.getTitle());
                        break;
                    }

                    var10000 = System.out;
                    var10001 = c.getName();
                    var10000.println(var10001 + " преодолел " + barriers.getTitle() + " с помошью суперпрыжка");
                }

                ++n;
                if (barriers.getDimension() <= c.getRunDist() && n > 3 && barriers.getType() == 2) {
                    var10000 = System.out;
                    var10001 = c.getName();
                    var10000.println(var10001 + " преодолел " + barriers.getTitle());
                } else if (barriers.getType() == 2) {
                    var10000 = System.out;
                    var10001 = c.getName();
                    var10000.println(var10001 + " не смог преодолеть " + barriers.getTitle());
                    break;
                }
            }
        }

    }
}

