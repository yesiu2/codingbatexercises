import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojciech on 2018-03-22.
 */
public class CzyUmieszPotegowac {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int set = 0;
        try {
            set = Integer.valueOf(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


        int[] result1 = new int[set];


        for (int i = 0; i < set; i++) {
            String nums = null;
            try {
                nums = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] array = nums.split(" ");
            int powBase = Integer.valueOf(array[0]);
            int expotent = Integer.valueOf(array[1]);

            result1[i] = lastDigit(powBase % 10, expotent);

        }

        for (int i : result1) {
            System.out.println(i);
        }

    }

    private static int lastDigit(int powBase, int expotent) {
        if (powBase == 0) {
            return 0;
        } else if (powBase == 1) {
            return 1;
        } else if (powBase == 5) {
            return 5;
        } else if (powBase == 6) {
            return 6;
        } else if (powBase == 4) {
            if (expotent % 2 == 0) {
                return 6;
            } else {
                return 4;
            }

        } else if (powBase == 9) {
            if (expotent % 2 == 0) {
                return 1;
            } else {
                return 9;
            }
        } else if (powBase == 2) {
            if (expotent % 4 == 1) {
                return 2;
            } else if (expotent % 4 == 2) {
                return 4;
            } else if (expotent % 4 == 3) {
                return 8;
            } else {
                return 6;
            }
        } else if (powBase == 3) {

            if (expotent % 4 == 1) {
                return 3;
            } else if (expotent % 4 == 2) {
                return 9;
            } else if (expotent % 4 == 3) {
                return 7;
            } else {
                return 1;
            }

        } else if (powBase == 7) {
            if (expotent % 4 == 1) {
                return 7;
            } else if (expotent % 4 == 2) {
                return 9;
            } else if (expotent % 4 == 3) {
                return 3;
            } else {
                return 1;
            }
        } else {
            if (expotent % 4 == 1) {
                return 8;
            } else if (expotent % 4 == 2) {
                return 4;
            } else if (expotent % 4 == 3) {
                return 2;
            } else {
                return 6;
            }
        }
    }
}
