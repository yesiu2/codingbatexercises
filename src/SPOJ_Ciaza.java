import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CiazowySpecjalista
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int set = 0;
        try {
            set = Integer.valueOf(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        double kids = 0;

        double[] returnArray = new double[set];

        for (int i = 0; i < set; i++) {

            String input = null;
            try {
                input = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (input.equals(null)) {
                break;
            }


            String[] inputArray = input.split(" ");



            double howMuchOlderIsMother = Integer.valueOf(inputArray[0]);
            double inHowManyYearsMotherWillBeXTimesOlder = Integer.valueOf(inputArray[1]);
            double howManyTimesSheWillBeOlder = Integer.valueOf(inputArray[2]);

            double leftSide = howMuchOlderIsMother+inHowManyYearsMotherWillBeXTimesOlder;
            double rightSide = inHowManyYearsMotherWillBeXTimesOlder*howManyTimesSheWillBeOlder;
            kids = (rightSide - leftSide) / (howManyTimesSheWillBeOlder - 1);

            kids = Math.round(12 * kids);



            returnArray[i] = kids;

        }

        for (double i : returnArray) {
            System.out.println((int) i);


        }
    }
}