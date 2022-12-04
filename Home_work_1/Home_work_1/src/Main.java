import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
        int i = (int) (Math.random() * 1000);
//2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = maxSignBit(i);
//3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        allMult(i, n);
//4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        allnotMult(i, n);
    }
    static int maxSignBit (int i) {
        i = Math.abs(i);
        int msb = Integer.toBinaryString(i).length();
        System.out.printf("Cтарший значащий бит числа %d равен %d \n", i, msb);
        return msb;
    }

    static void allMult (int startRange, int divider) {

        System.out.printf("Ищем числа кратные " + divider + "; Начало дипазона = " + startRange + " \n ");
        int count = 0;
        for (int j = startRange; j < Short.MAX_VALUE; j++) {
            if (j % divider == 0) {

                count++;
            }
        }
        int[] m1 = new int[count];
        count = 0;
        for (int j = startRange; j < Short.MAX_VALUE; j++) {
            if (j % divider == 0) {
                m1[count] = j;
                count += 1;
            }
        }

        System.out.print(Arrays.toString(m1));

    }
    static void allnotMult (int endRange, int divider) {

        System.out.printf("Ищем числа не кратные " + divider + "; Конец дипазона = " + endRange + " \n ");
        int count = 0;
        for (int j = Short.MIN_VALUE; j < endRange; j++) {
            if (j % divider != 0) {

                count++;
            }
        }
        int[] m2 = new int[count];
        count = 0;
        for (int j = Short.MIN_VALUE; j < endRange; j++) {
            if (j % divider != 0) {
                m2[count] = j;
                count += 1;
            }
        }

        System.out.print(Arrays.toString(m2));

    }
}
