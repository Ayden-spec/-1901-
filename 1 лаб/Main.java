package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Простые числа");

        for (int i = 2; i <= 100; i++) {
            if (Primes.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Введите слово для проверки полиндрома");
        String str = scan.nextLine();
        if(Palindrome.isPalindrome(str)){
            System.out.println("Слово '" + str + "' является полиндромом");
        }

    }
}
