package com.wmoreira.javadevn3;

import java.util.Optional;
import java.util.Scanner;

/**
 * @author wellington.362@gmail.com
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        Stream stream = new StreamImpl(input);

        System.out.println("Input: " + input);

        Optional<Character> result = Optional.ofNullable(firstChar(stream));

        if (result.isPresent()) {
            System.out.println("Output: " + result.get());
            return;
        }
        System.out.println("Todos os caracteres se repetiram");

    }

    public static Character firstChar(Stream stream) {

        //Caracteres da stream
        StringBuilder sb = new StringBuilder();

        //Caracteres repetidos na stream
        StringBuilder repeated = new StringBuilder();
        while (stream.hasNext()) {
            String c = String.valueOf(stream.getNext());
            int cIndex = sb.indexOf(c, 0);
            if (cIndex > -1 && repeated.indexOf(c) == -1) {
                repeated.append(c);
            }
            sb.append(c);
        }

        //regex remove os caracteres repetidos
        String result = sb.toString().replaceAll("[" + repeated.toString() + "]", "");

        if (result.length() == 0) {
            return null;
        }

        return result.charAt(0);
    }

}
