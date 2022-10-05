public class Main_app {
    public static void main(String[] args) {
        String[][] array_good = {
                {"2", "2", "2", "4"},
                {"2", "6", "2", "8"},
                {"2", "10", "2", "12"},
                {"2", "14", "2", "16"}
        };
//        String[][] array_size_problem = {
//                {"1", "2", "3", "4"},
//                {"5", "6", "7"},
//                {"9", "10", "11", "12"},
//                {"13", "14", "15", "16"}
//        };
//        String[][] array_data_problem = {
//                {"1", "2", "3", "4"},
//                {"5", ".", "7", "8"},
//                {"9", "10", "11", "12"},
//                {"13", "14", "15", "16"}
//        };
        try {
            try{
                int result = method_array(array_good);
                System.out.println("Результат: " + result);
            }
            catch (MyArraySizeException e)
            {
                System.out.println("Размер массива должен быть 4х4!");
            }
        }
        catch (MyArrayDataException e)
        {
            System.out.println("Неверное значение в массиве");
            System.out.println("Ошибка в яичейке: " + e.i + "x" + e.j);
        }
        catch (MyArrayNechetException e){
            System.out.println("В вашем массиве присутствуют нечетное(-ые) число(-а)!");
        }
    }
    public static int method_array(String[][] arr) throws MyArrayDataException, MyArrayDataException, MyArrayNechetException{
        int a = 4;
        int count = 0;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    num = Integer.parseInt(arr[i][j]);
                    count = count + num;
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(1 + i, 1 + j);
                }
                if(num%2!=0){
                    throw new MyArrayNechetException();
                }
            }
        }
        return count;
    }
}
