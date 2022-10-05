public class MyArrayDataException extends RuntimeException {
    public int i;
    public int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

}
