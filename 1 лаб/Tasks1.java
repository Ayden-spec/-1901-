import java.util.Scanner;

import sun.font.CharToGlyphMapper;

public class Tasks1 {

    public static void main(String [] args){
        System.out.println("Введите номер задания.");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        switch (number) {
            case 1:
            System.out.println("Введите значение №1.");
            Scanner s1 = new Scanner(System.in);
            int a = s1.nextInt();

            System.out.println("Введите значение №2.");
            Scanner s2 = new Scanner(System.in);
            int b = s2.nextInt();

            System.out.println("Остаток = " + remainder(a, b));
            break;
            case 2:
            System.out.println("Длину основания треугольника.");
                Scanner w1 = new Scanner(System.in);
                int vis = w1.nextInt();
                System.out.println("Длину высоты треугольника.");
                Scanner w2 = new Scanner(System.in);
                int h = w2.nextInt();

                System.out.println("Площадь треугольника = " + triArea(vis, h));
            break;
            case 3:
            System.out.println("Введите количество куриц.");
            Scanner q1 = new Scanner(System.in);
            int chickens = q1.nextInt();
            System.out.println("Введите количество коров.");
            Scanner q2 = new Scanner(System.in);
            int cows = q2.nextInt();
            System.out.println("Введите количество свиней.");
            Scanner q3 = new Scanner(System.in);
            int pigs = q3.nextInt();

            System.out.println("Общее количество ног всех животных = " + animal(chickens, cows, pigs));
            break;
            case 4:
            System.out.println("Введите prob.");
            Scanner e1 = new Scanner(System.in);
            int prob = e1.nextInt();
            System.out.println("Введите prize.");
            Scanner e2 = new Scanner(System.in);
            int prize = e2.nextInt();
            System.out.println("Введите pay.");
            Scanner e3 = new Scanner(System.in);
            int pay = e3.nextInt();

            System.out.println(profitableGamble(prob, prize, pay));
            break;
            case 5:
            System.out.println("Введите N.");
            Scanner r1 = new Scanner(System.in);
            int N = r1.nextInt();
            System.out.println("Введите a.");
            Scanner r2 = new Scanner(System.in);
            int a1 = r2.nextInt();
            System.out.println("Введите b.");
            Scanner r3 = new Scanner(System.in);
            int b1 = r3.nextInt();

            System.out.println("Результат работы программы" + operation(N, a, b));
            break;
            case 6:
            
            break;
            case 7:
        
            break;
            case 8:
        
            break;
            case 9:
        
            break;
            case 10:
        
            break;
        }

    }
    //В Java есть единственный оператор, способный обеспечить остаток от операции
    //деления. Два числа передаются в качестве параметров. Первый параметр,
    //разделенный на второй параметр, будет иметь остаток, возможно, ноль. Верните
    //это значение.
    public static int remainder (int a, int b){
        return a % b ;
    }

//Напишите функцию, которая принимает основание и высоту треугольника и
//возвращает его площадь.

    public static double triArea (int vis, int h){
        return 0.5*a*h ;
    }

//В этой задаче фермер просит вас сказать ему, сколько ног можно сосчитать среди
//всех его животных. Фермер разводит три вида:
//chickens = 2 legs
//cows = 4 legs
//pigs = 4 legs
//Фермер подсчитал своих животных, и он дает вам промежуточный итог для каждого вида.
//Вы должны реализовать функцию, которая возвращает общее количество ног всех
//животных.

public static int animal(int chickens, int cows, int pigs){
        return chickens*2 + cows* 4 + pigs*4 ;
    }

//Создайте функцию, которая принимает три аргумента (prob, prize, pay) и
//возвращает true, если prob * prize > pay; в противном случае возвращает false.
//Чтобы проиллюстрировать это: profitableGamble (0,2, 50, 9) должен выдать значение true,
//поскольку 1 (0,2 * 50 - 9), а 1> 0.

    public static boolean profitableGamble ( double prob, double prize, double pay){
        return prob * prize > pay;
    }

//Напишите функцию, которая принимает 3 числа и возвращает, что нужно сделать с
//a и b: они должны быть сложены, вычитаны, умножены или разделены, чтобы
//получить N. Если ни одна из операций не может дать N, верните "none".
//3 числа – это N, a и b.

    public static String operation(int N, int a, int b) {
        if (a+b == N)
            return "added";
        else if (a-b == N)
            return "subtracted";
        else if (a*b == N)
            return "multiply";
        else if (a/b == N)
            return "davide";
        else return "none";
    }

// Создайте функцию, которая возвращает значение ASCII переданного символа.

    public static int ctoa(char t1) {
        return (int) t1;
    }

//Напишите функцию, которая берет последнее число из последовательного списка
//чисел и возвращает сумму всех чисел до него и включая его.

    public static int addUpTo(int n){
        int[] mass = new int[n];
        int sum = 0;
        for(int i = 0; n > i; i++){
            mass[i] = i+1;
            sum = sum + mass[i];
        }
        return sum;
    }

//Создайте функцию, которая находит максимальное значение третьего ребра
//треугольника, где длины сторон являются целыми числами.

    public static int nextEdge(int a, int b){
        return a + b -1;
    }

//Создайте функцию, которая принимает массив чисел и возвращает сумму его
//кубов.

    public static int sumOfCubes(int [] mass){
        int sum = 0;
        for (int value : mass) {
            sum += Math.pow(value, 3);
        }
        return sum;
    }

//Создайте функцию, которая будет для данного a, b, c выполнять следующие
//действия:
//– Добавьте A к себе B раз.
//– Проверьте, делится ли результат на C.

    public static boolean abcmath(int a, int b, int c){
        for (int i = 0; i<b ; i++){
            a=a+a;
        }
        return a % c == 0;
    }
}