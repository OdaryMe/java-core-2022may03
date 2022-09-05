package ru.geekbrains.java2.homeworks.hw2;

public class Hw2 {
    static int arrSizeX = 4;
    static int arrSizeY = 4;

    public static void main(String[] args) {

        String[][][] someArrays = {
                {
                {"7", "103", "-211", "4"},
                {"0", "23", "11", "-3"},
                {"140", "50", "-18", "30"},
                {"-500", "-1", "6", "13"}
            },

            {
                {"7", "103", "-211", "4"},
                {"0", "23", "11", "-3"},
                {"140", "50", "-18", "30"}
            },

            {
                {"7", "103", "-211"},
                {"0", "23", "11", "-3"},
                {"140", "50", "-18", "30"},
                {"-500", "-1", "6", "13"}
            },

            {
                {"7", "103", "-211", "4"},
                {"0", "23", "11", "-3"},
                {"140", "50", "-18", "30"},
                {"-500", "-1", "five", "13"}
            }
            };

        for (String[][] someArray : someArrays) {
            try {
                System.out.println(sumForSpecificArrSize(someArray));
            }catch (MyArraySizeException | MyArrayDataException e) {
                //System.err.println(e);
                //e.printStackTrace();
                //e.getMessage();
                System.err.println(e.getMessage());
            }
        }
    }

    private static int sumForSpecificArrSize(String[][] arr) {
        for (String[] strings : arr) {
            if (arr.length != arrSizeY) throw new MyArraySizeException("Invalid array size(Y).");
            for (int i = 0; i < strings.length; i++) {
                if (strings.length != arrSizeX) throw new MyArraySizeException("Invalid array size(X).");
                checkArrayElements(arr);
            }
        }
        return sumArr(arr);
    }

    private static int sumArr(String[][] arr) {
        int sum = 0;
        for (String[] strings : arr) {
            for (String string : strings) {
                    int a = Integer.parseInt(string);
                    sum += a;
                }
            }
            return sum;
        }


    private static boolean checkArrayElements(String[][] arr) {
        for (String[] strings : arr) {
            for (String string : strings) {
                char[] x = string.toCharArray();
                for (char c : x) {
                    boolean valid = ((c >= '0') && (c <= '9') || (c == '-'));
                    if (!valid) throw new MyArrayDataException("Invalid array element. Number expected.");
                }
            }
        }
        return true;
    }
}
