public enum Barriers {
//    HIGH_WALLLL(1, "Ультра-мега-супер-гипер высокую Стену", 1000101110),
    LOW_WALL(1, "Низкую Стену", 10),
    MED_WALL(1, "Среднюю Стену", 50),
    HIGH_WALL(1, "Высокую Стену", 100),
    HIGH_WALLL(1, "Супер высокую Стену", 1000),
    HIGH_WALLLlL(1, "Ультра-мега-супер-гипер высокую Стену", 1000101110),
    SHORT_TRACK(2, "Короткую Дорожку", 10),
    MEDIUM_TRACK(2, "Среднюю Дорожку", 100),
    LONG_TRACK(2, "Длинную Дорожку", 1000);

    private int type;
    private String title;
    private int dimension;

    public int getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDimension() {
        return this.dimension;
    }

    private Barriers(int type, String title, int length) {
        this.title = title;
        this.type = type;
        this.dimension = length;
    }
}