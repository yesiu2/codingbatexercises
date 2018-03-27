import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Wojciech on 2018-03-06.
 */
public class RownanieKwadratowe {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String input;

        List<Integer> integers = new ArrayList<>();


        try {
            do {
                input = br.readLine();

                if (input == null) {
                    break;
                }
                if (!input.isEmpty()) {
                    String[] array = input.split(" ");
                    double a = Double.parseDouble(array[0]);
                    double b = Double.parseDouble(array[1]);
                    double c = Double.parseDouble(array[2]);

                    double delta = Math.pow(b, 2) - 4 * a * c;



                    if (delta == 0) {
                        integers.add(1);
                    } else if (delta > 0) {
                        integers.add(2);
                    } else {
                        integers.add(0);
                    }
                } else {
                    break;
                }

            } while (5 == 5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < integers.size(); j++) {
            System.out.println(integers.get(j));

        }


    }
}
