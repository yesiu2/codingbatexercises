import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojciech on 2018-03-16.
 */
public class LiczbyZnaczace {

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int zestawy = 0;
        try {
            zestawy = Integer.valueOf(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> howManySignificant = new ArrayList<>();

        for (int i = 0; i < zestawy; i++) {

            int numerekOd = 0;
            int numerekDo = 0;
            int counter = 0;
            try {
                String numbersString = bf.readLine();
                String[] numbers = numbersString.split(" ");

                numerekOd = Integer.valueOf(numbers[0]);
                numerekDo = Integer.valueOf(numbers[1]);

            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int j = numerekOd; j <= numerekDo; j++) {

                if (isSignificant(j)) {
                 counter++;
                }

            }

            howManySignificant.add(counter);
        }

        for (int i : howManySignificant) {
            System.out.println(i);
        }
    }

    public static boolean isSignificant(int number) {
        List<Integer> dzielniki = new ArrayList<>();

        int sum = 0;
        int howMany = 0;

        for (int i = number-1; i > 1 ; i--) {
            if (number % i == 0) {

                sum+=i;
                howMany++;
            }
        }
        BigDecimal srednia = new BigDecimal(BigInteger.ZERO);

        BigDecimal pierwiastek = new BigDecimal(Math.sqrt(number));
        if (howMany == 0) {
            return false;
        }

        srednia = new BigDecimal(sum).divide(BigDecimal.valueOf(howMany), 2, RoundingMode.HALF_UP);
        int toReturn = srednia.compareTo(pierwiastek);

        return toReturn <= 0;
    }
}
