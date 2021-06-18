package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println(args[0]);//смотреть путь файла в аргумантах!
        //создаем массив для входных данных.
        ArrayList<Double> arr = new ArrayList<>();

        //считываем данные из файла, и записываем в массив.
try {

    FileReader fr = new FileReader(args[0]);
    BufferedReader reader = new BufferedReader(fr);
    String line = reader.readLine();

    while (line != null) {
        arr.add(Double.valueOf(line));
        line = reader.readLine();
    }

    fr.close();
    reader.close();

}catch (IOException e){
    System.out.println(e.getMessage());
}



        //вывод в консоль парцентиля
        System.out.printf("%.2f%n", percentile(arr, 90));
        //вывод медианы
        System.out.printf("%.2f%n", median(arr));
        //максимальное значение
        System.out.printf("%.2f%n", max(arr));
        //минимальное значение
        System.out.printf("%.2f%n", min(arr));
        //среднее значение
        System.out.printf("%.2f%n", average(arr));



    }
    //метод вычисление парцентиля
    public static double percentile(List<Double> arr, double percentile) {
        //сортируем массив
        Collections.sort(arr);
        //находим порядковый индекс 90%
        double indexN =  percentile / 100.00 * arr.size() ;
        double index =  (percentile / 100.00) * (indexN - 1) + 1  ;
        return index;
    }


    //метод вычисления медианы
    public static double median (List<Double> arr){
        int x;
        double result;
    Collections.sort(arr);
    //четные ( Будет ВРЕМЯ СДЕЛАЙ НЕЧЕТНЫЕ!)
    if(arr.size() % 2 == 0 ) {
         x = arr.size() / 2;
         result = (arr.get( x - 1 ) + arr.get( x + 1 )) / 2;
        return result;
    }else
        // не проверил!
        result = arr.size() / 2 ;
        return result;
    }


    //метод вычисления макс.значения
    public static double max (List<Double>arr){
        Collections.sort(arr);
        double result = arr.get(arr.size() - 1);
        return result;
    }


    //метод вычисления мин.значения
    public static double min (List<Double>arr){
        Collections.sort(arr);
        double result = arr.get(0);
        return result;
    }


    //Метод вычисление среднего значения
    public static double average (List<Double>arr){
        double result = 0;

        for (int i = 0; i < arr.size(); i++) {
            result = (int) (result + arr.get(i));
        }
        result = result / arr.size() ;

        return result;
    }
}



