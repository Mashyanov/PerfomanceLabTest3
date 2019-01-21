//В магазине 5 касс, в каждый момент времени к кассе стоит очередь некоторой длины. 
//Каждые 30 минут измеряется средняя длина очереди в каждую кассу и для каждой 
//кассы это значение (число вещественное) 
//записывается в соответсвующий ей файл (всего 5 файлов), магазин работает 8 часов 
//день. Рассматривается только один день.
//На момент запуска приложения все значения уже находятся в файлах.
// 
//Написать программу, которая по данным замеров определяет интервал времени,
//когда в магазине было наибольшее количество посетителей за день. 
//
//от автора: в этом задании не рассмотрен вариант двух разных периодов с одинаковой 
//средней загрузкой всех касс. Хоть это и маловероятно, но всё же возможно. Оправдание 
//этому лишь в очень жестком дефиците времени. Тем не менее, такой вариант 
//развития событий полностью описан в следующем, четвертом задании. Надеюсь,
//в этом нет ничего криминального! Спасибо! 
package test3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Александр Машьянов, mashyanov1987@gmail.com, +7(981)784-79-67
 */
public class Test3 {

    public static void main(String[] args) {
       try {
            Scanner scanner;
            /* Порядковый номер периода с наибольшей суммарной средней очередью 
            * на кассах. Значение -1 присвоено для самоконтроля*/
            int result = -1;
            /** максимальная суммарная длина средней очереди*/
            double max = 0;
            /** temp, просто temp. Используется для поиска максимального значения*/
            double temp;
            /**Коллекция, содержащая данные по всем кассам за все периоды времени*/
            ArrayList<Double> data = new ArrayList<>();
            
            //ЗАПРАШИВАЕМ У ПОЛЬЗОВАТЕЛЯ ФАЙЛЫ ДАННЫМИ ПО ВСЕМ КАССАМ
            File file0 = new File(JOptionPane.showInputDialog("Укажите файл первой кассы", "till0.txt"));
            File file1 = new File(JOptionPane.showInputDialog("Укажите файл второй кассы", "till1.txt"));
            File file2 = new File(JOptionPane.showInputDialog("Укажите файл третьей кассы", "till2.txt"));
            File file3 = new File(JOptionPane.showInputDialog("Укажите файл четвертой кассы", "till3.txt"));
            File file4 = new File(JOptionPane.showInputDialog("Укажите файл пятой кассы", "till4.txt"));
           
            //ПРОВЕРЯЕМ, ЧТО ВСЕ ЭТИ ФАЙЛЫ СУЩЕСТВУЮТ
            if(!file0.exists()||!file1.exists()||!file2.exists()||!file3.exists()||!file4.exists()) 
                throw new FileNotFoundException("ФАЙЛ НЕ НАЙДЕН");
                                  
            //СЧИТЫВАЕМ ДАННЫЕ ИЗ ВЫСЕХ ФАЙЛОВ ПО ОЧЕРЕДИ
            scanner = new Scanner(file0);
            while(scanner.hasNext()) data.add(Double.parseDouble(scanner.next()));
            scanner = new Scanner(file1);
            while(scanner.hasNext()) data.add(Double.parseDouble(scanner.next()));
            scanner = new Scanner(file2);
            while(scanner.hasNext()) data.add(Double.parseDouble(scanner.next()));
            scanner = new Scanner(file3);
            while(scanner.hasNext()) data.add(Double.parseDouble(scanner.next()));
            scanner = new Scanner(file4);
            while(scanner.hasNext()) data.add(Double.parseDouble(scanner.next()));
            scanner.close();
            //ПРОВЕРЯЕМ, ЧТО КОЛИЧЕСТВО ДАННЫХ ВЕРНО
            if(data.size()!=80) throw new IOException("Неверные данные в файлах");
            //НАХОДИМ НОМЕР ПЕРИОДА ВРЕМЕНИ С САМОЙ ДЛИННОЙ СУММАРНОЙ СРЕДНЕЙ ОЧЕРЕДЬЮ
            for (int i = 0; i < 16; i++) {
               temp = data.get(i) + data.get(i+5) + data.get(i+10) + data.get(i+15) + data.get(i+20);
               if(temp > max) {
                   max = temp;
                   result = i;
               }
           }
            //ИНТЕРПРЕТИРУЕМ РЕЗУЛЬТАТ ПОИСКА И ВЫДАЕМ ПОЛЬЗОВАТЕЛЮ ОТЧЕТ ЗА ДЕНЬ
            /* от автора: да, данную часть можно было сделать элегантнее, без всех этих кейсов,
             * и именно так я и поступил в следующем, четвертом задании, которое про банк.
             * Здесь же кейсы просто для разнообразия кода :) */
            switch(result){
                case 0:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 8:00 до 8:30");
                    break;
                    case 1:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 8:30 до 9:00");
                    break;
                    case 2:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 9:00 до 9:30");
                    break;
                    case 3:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 9:30 до 10:00");
                    break;
                    case 4:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 10:00 до 10:30");
                    break;
                    case 5:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 10:30 до 11:00");
                    break;
                    case 6:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 11:00 до 11:30");
                    break;
                    case 7:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 11:30 до 12:00");
                    break;
                    case 8:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 12:00 до 12:30");
                    break;
                    case 9:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 12:30 до 13:00");
                    break;
                    case 10:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 13:00 до 13:30");
                    break;
                    case 11:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 13:30 до 14:00");
                    break;
                    case 12:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 14:00 до 14:30");
                    break;
                    case 13:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 14:30 до 15:00");
                    break;
                    case 14:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 15:00 до 15:30");
                    break;
                    case 15:
                    System.out.println("По результатам замеров наиболее напряженным оказался период с 15:30 до 16:00");
                    break;
                    case -1:
                    System.out.println("Факир был пьян, и фокус не удался...");
                    break;
            }
   
     } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JPanel(), "FileNotFoundException:\n" + ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            System.err.println("FileNotFoundException:" + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JPanel(), "FileNotFoundException:\n" + ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            System.err.println("IOException:" + ex.getMessage());
        }
    }}

