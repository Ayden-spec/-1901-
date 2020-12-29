import java.util.Scanner;

public class homework {
    public static void main(String[] args){
        System.out.println("Введите номер задания.");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        switch (number) {
            case 1:
                System.out.println("Введите значение №1.");
                Scanner s1 = new Scanner(System.in);
                int znach1 = s1.nextInt();

                System.out.println("Введите значение №2.");
                Scanner s2 = new Scanner(System.in);
                int znach2 = s2.nextInt();
                int znach3 = znach1 % znach2;
                System.out.println("Остаток = "+ znach3);
                break;

            case 2:
                System.out.println("Длину основания треугольника.");
                Scanner w1 = new Scanner(System.in);
                int osn = w1.nextInt();
                System.out.println("Длину высоты треугольника.");
                Scanner w2 = new Scanner(System.in);
                int vis = w2.nextInt();
                int S = osn * vis / 2;
                System.out.println("Площадь треугольника = " + S);
                break;
            case 3:
                System.out.println("Введите количество куриц.");
                Scanner q1 = new Scanner(System.in);
                int chicken = q1.nextInt();
                System.out.println("Введите количество коров.");
                Scanner q2 = new Scanner(System.in);
                int cow = q2.nextInt();
                System.out.println("Введите количество свиней.");
                Scanner q3 = new Scanner(System.in);
                int pig = q3.nextInt();
                int animals = chicken * 2 + cow * 4 + pig * 4;
                System.out.println("Общее количество ног всех животных = " + animals);
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
                if (prob * prize > pay) {
                    System.out.println("true");
                }
                else {
                    System.out.println("false");
                }
                break;
            case 5:
                
                break;
            case 6:
                /*System.out.println("Введите prob.");
                Scanner t1 = new Scanner(System.in);
                String ascii = t1.nextLine();
                byte[] bytes = ascii.getBytes("US-ASCII");
                break;*/
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
}

