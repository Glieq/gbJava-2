
// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class task2 {
    public static void bubbleSort(int[] arr) {
        Logger logger = Logger.getLogger(task2.class.getName());
        logger.setLevel(Level.INFO);
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        // SimpleFormatter sFormat = new SimpleFormatter();
        XMLFormatter xml = new XMLFormatter();
        // ch.setFormatter(sFormat);
        ch.setFormatter(xml);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

                logger.info("Этап " + (i + 1) + ", Итерация " + (j + 1) + ": " + Arrays.toString(arr));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int[] arr2 = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Исходный массив:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        bubbleSort(arr);

        System.out.println("\nОтсортированный массив:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
