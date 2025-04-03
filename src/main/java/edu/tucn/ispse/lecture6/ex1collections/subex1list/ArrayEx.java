package edu.tucn.ispse.lecture6.ex1collections.subex1list;

import java.util.Arrays;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class ArrayEx {
    public static void main(String[] args) {
        int[] array = new int[5];

        for (int i = 0; i < 5; i++) {
            array[i] = i;
        }

        for (int i = 0; i < 5; i++) {
            if (array[i] > 2) {
                System.out.println(array[i] * 2);
            }
        }

        //somewhere in the code
//        array[5] = 22;

//        Arrays.stream(array)
//                .filter(i -> i > 2)
//                .map(i -> i * 2)
//                .forEach(el -> System.out.println(el));
    }
}
