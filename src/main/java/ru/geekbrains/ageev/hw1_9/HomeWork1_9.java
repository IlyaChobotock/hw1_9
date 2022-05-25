package ru.geekbrains.ageev.hw1_9;

public class HomeWork1_9 {

    public static void main(String[] args) {
        // Строковые массивы в разных вариациях
        String[][] arrNums = {
                {"1", "1", "1", "1"},
                {"1", "1", "2", "1"},
                {"1", "1", "6", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] arrNums1 = {
                {"1", "1", "dfg", "1"},
                {"1", "1", "2", "1"},
                {"1", "1", "6", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] arrNums2 = {
                {"1", "1", "2", "1"},
                {"1", "1", "2", "1"},
                {"1", "1", "6", "1", "2"},
                {"1", "1", "1", "1"}
        };

        String[][] arrNums3 = {
                {"1", "1", "1", "1"},
                {"1", "1", "2", "1"},
                {"1", "1", "6", "1"},
                {"1", "1", "1", "1"},
                {"2"}
        };
        // Запускаем выполнение метода с подачей разных вариантов строковых массивов
        try {
            sumArr(arrNums);
            sumArr(arrNums1);
            //sumArr(arrNums2);
            //sumArr(arrNums3);
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод, на вход которого подаётся двумерный строковый массив размером 4х4
     * @param arr
     * @throws MyArraySizeException
     * @throws MyArrayDataException
     */
    public static void sumArr (String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        // Сначала проверяем количество строк. Если отлично от 4, то бросаем исключение по размеру
        if (arr.length != 4) throw new MyArraySizeException("Количество строк отлично от 4!");
        for (String[] strings : arr) {
            // Далее проверяем количество столбцов. Если отлично от 4, то бросаем исключение по размеру
            if (strings.length != 4) throw new MyArraySizeException("Количество столбцов отлично от 4!");
            for (String string : strings) {
                // Проверяем на наличие в каждой ячейке двумерного массива числового значения. Если не числовое значение, то бросаем исключение по типу данных
                if (!checkString(string))
                    throw new MyArrayDataException("В массиве есть отличный от цифры элемент!");
                sum = sum + Integer.parseInt(string);
            }
        }
        System.out.println(sum);
    }

    /**
     * Метод проверки в каждой ячейке двумерного массива числового значения (тип данных)
     * @param string - передаем строку на входе
     * @return возвращаем истину, если числовое значение. Если другой тип - ложь
     */
    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
// Класс собственного исключения MyArraySizeException
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message){
        super(message);
    }
}

// Класс собственного исключения MyArrayDataException
class MyArrayDataException extends Exception{
    public MyArrayDataException(String message){
        super(message);
    }
}
