package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class Task2 {
    public static void main(String [] args) {
        System.out.println("Введите номер задания.");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        switch (number) {
            case 1:
                System.out.println("Введите значение №1.");
                Scanner s1 = new Scanner(System.in);
                String word = s1.nextLine();

                System.out.println("Введите значение №2.");
                Scanner s2 = new Scanner(System.in);
                int n = s2.nextInt();

                System.out.println("Результат работы программы = "+ repeat(word, n));
                break;
            case 2:
                Scanner input = new Scanner(System.in); // Объявляем Scanner
                System.out.println("Введите размер массива.");
                int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
                int[] mass = new int[size]; // Создаём массив int размером в size
                System.out.println("Введите значения массива.");
                for (int i = 0; i < size; i++) {
                    mass[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
                }
                System.out.print("Результат работы программы = " + differenceMaxMin(mass));
                break;
            case 3:
                Scanner input1 = new Scanner(System.in); // Объявляем Scanner
                System.out.println("Введите размер массива.");
                int size1 = input1.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
                int[] mass1 = new int[size1]; // Создаём массив int размером в size
                System.out.println("Введите значения массива.");
                for (int i = 0; i < size1; i++) {
                    mass1[i] = input1.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
                }
                System.out.print("Результат работы программы = " + isAvgWhole(mass1));
                break;
            case 4:
                Scanner inp = new Scanner(System.in); // Объявляем Scanner
                System.out.println("Введите размер массива.");
                int size2 = inp.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
                int[] mass2 = new int[size2]; // Создаём массив int размером в size
                System.out.println("Введите значения массива.");
                for (int i = 0; i < size2; i++) {
                    mass2[i] = inp.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
                }
                System.out.print("Результат работы программы = " + Arrays.toString(cumulativeSum(mass2)));
                break;
            case 5:
                System.out.println("Введите значение.");
                Scanner r1 = new Scanner(System.in);
                String number1 = r1.nextLine();

                System.out.println("Результат работы программы " + getDecimalPlaces(number1));
                break;
            case 6:
                System.out.println("Введите значение.");
                Scanner y1 = new Scanner(System.in);
                int n1 = y1.nextInt();
                System.out.println("Число Фибоначчи " + Fibonacci(n1));
                break;
            case 7:
                System.out.println("Введите начение.");
                Scanner u1 = new Scanner(System.in);
                String  index = u1.nextLine();

                System.out.println("Результат работы программы " + isValid(index));
                break;
            case 8:
                System.out.println("Введите №1.");
                Scanner i1 = new Scanner(System.in);
                String  word1 = i1.nextLine();
                System.out.println("Введите №2.");
                Scanner i2 = new Scanner(System.in);
                String  world2 = i2.nextLine();

                System.out.println("Результат работы программы " + isStrangePair(word1, world2));
                break;
            case 9:
                System.out.println("Введите номер функции, которую хотите протестировать: 1. isPrefix 2. isSuffix");
                Scanner o1 = new Scanner(System.in);
                int  choice = o1.nextInt();
                System.out.println("Введите слово");
                Scanner o2 = new Scanner(System.in);
                String  word2 = o2.nextLine();
                if(choice == 1){
                    System.out.println("Введите префикс");
                    Scanner o3 = new Scanner(System.in);
                    String  pref = o3.nextLine();
                    System.out.println(isPrefix(word2, pref));
                }else if(choice == 2){
                    System.out.println("Введите суффикс");
                    Scanner o4 = new Scanner(System.in);
                    String  suf = o4.nextLine();
                    System.out.println(isSuffix(word2, suf));
                }
                break;
            case 10:
                System.out.println("Введите число (шаг).");
                Scanner p1 = new Scanner(System.in);
                int shag = p1.nextInt();

                System.out.println("Результат работы программы " + boxSeq(shag));
                break;
        }
    }


//Создайте функцию, которая повторяет каждый символ в строке n раз

        public static String repeat(String word, int n){
            String newWord = " ";
            for (int i = 0; i< word.length() ; i++){
                for (int j = 0; j<n; j++){
                    newWord+= word.charAt(i);
                }
            }
            return newWord;
        }

//Создайте функцию, которая принимает массив и возвращает разницу между
//самыми большими и самыми маленькими числами.

        public static int differenceMaxMin(int [] mass){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int value : mass) {
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
            return max - min;
        }

//Создайте функцию, которая принимает массив в качестве аргумента и возвращает
//true или false в зависимости от того, является ли среднее значение всех элементов
//массива целым числом или нет.

        public static boolean isAvgWhole(int[] mass1){
            double sum=0;

            for (int value : mass1) {
                sum += value;
            }
            return (sum % mass1.length) % 100 < 1;

        }

//Создайте метод, который берет массив целых чисел и возвращает массив, в
//котором каждое целое число является суммой самого себя + всех предыдущих
//чисел в массиве.

        public static int[] cumulativeSum( int [] mass2){

            for (int i = 1; i < mass2.length; i++){
                mass2[i] = mass2[i] + mass2[i-1];
            }
            return mass2;
        }

//Создайте функцию, которая возвращает число десятичных знаков, которое имеет
//число (заданное в виде строки). Любые нули после десятичной точки
//отсчитываются в сторону количества десятичных знаков.

        public static int getDecimalPlaces(String number1){
            if (number1.indexOf('.')!=0){
                return number1.length()-number1.indexOf('.')-1;
            }
            else
                return 0;
        }

//Создайте функцию, которая при заданном числе возвращает соответствующее
//число Фибоначчи.

        public static int Fibonacci (int n){
            switch (n) {
                case 0:
                case 1:
                    return 1;
                default:
                    return Fibonacci(n - 2) + Fibonacci(n - 1);
            }
        }

//Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку,
//напишите функцию, чтобы определить, является ли вход действительным
//почтовым индексом. Действительный почтовый индекс выглядит следующим
//образом:
//– Должно содержать только цифры (не допускается использование нецифровых цифр).
//– Не должно содержать никаких пробелов.
//– Длина не должна превышать 5 цифр.

        public static boolean isValid(String index){
            int buf = 0;
            for (int i = 0; i < index.length(); i++) {
                if (!Character.isDigit(index.charAt(i)))
                    buf++;
                else if (index.charAt(i) == ' ')
                    buf++;
                else if (index.length() != 5)
                    buf++;
            }
            return buf == 0;
        }

//Пара строк образует странную пару, если оба из следующих условий истинны:
//– Первая буква 1-й строки = последняя буква 2-й строки.
//– Последняя буква 1-й строки = первая буква 2-й строки.
//– Создайте функцию, которая возвращает true, если пара строк представляет собой
//странную пару, и false в противном случае.

        public static boolean isStrangePair (String word1, String word2){
            return word1.charAt(0) == word2.charAt(word2.length() - 1) &&
                    word2.charAt(0) == word2.charAt(word1.length() - 1);
        }

//Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
//– isPrefix должен возвращать true, если он начинается с префиксного аргумента.
//– isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
//– В противном случае верните false.

        public static boolean isPrefix(String word2, String pref){
            pref =  pref.substring(0,  pref.length()-1);
            return word2.startsWith(pref);
        }

        public static boolean isSuffix(String word2, String suf){
            suf = suf.substring(1);
            return word2.endsWith(suf);
        }

//Создайте функцию, которая принимает число (шаг) в качестве аргумента и
//возвращает количество полей на этом шаге последовательности.
//Шаг 0: начните с 0
//Шаг 1: Добавьте 3
//Шаг 2: Вычтите 1
//Повторите Шаги 1 И 2 ...

        public static int boxSeq(int shag){
            if (shag == 0) return 0;
            int count = 0;
            for (int i = 0; i < shag; i++) {
                if (i % 2 != 0) count--;
                else count += 3;
            }
            return count;
        }
    }

