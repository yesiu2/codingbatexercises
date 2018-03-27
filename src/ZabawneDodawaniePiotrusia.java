import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Wojciech on 2018-03-16.
 */
public class ZabawneDodawaniePiotrusia {

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int set = 0;
        try {
            set = Integer.valueOf(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int number = 0;



        int[] resultArrayNumbers = new int[set];
        int[] resultArrayCounter = new int[set];

        for (int i = 0; i < set; i++) {
            int counter = 0;
            try {
              number = Integer.valueOf(bf.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            int reversedNumber = reverseNumber(number);

            if (number == reversedNumber) {
                resultArrayNumbers[i] = number;
                resultArrayCounter[i] = counter;
            } else {
                do {
                    counter++;
                    number += reversedNumber;

                    reversedNumber = reverseNumber(number);

                    if (number == reversedNumber) {
                        resultArrayNumbers[i] = number;
                        resultArrayCounter[i] = counter;
                        break;
                    }

                } while (number != reversedNumber);
            }
        }

        for (int i = 0; i < set; i++) {

            System.out.println(resultArrayNumbers[i] + " " + resultArrayCounter[i]);
        }
    }

    public static int reverseNumber(int number) {
        String numberInString = Integer.valueOf(number).toString();

        int reversedNumber = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = numberInString.length()-1; i>=0; i--) {

            sb.append(numberInString.charAt(i));

            reversedNumber = Integer.valueOf(sb.toString());


        }
        return reversedNumber;
    }
}
