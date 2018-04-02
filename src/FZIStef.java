import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Wojciech on 2018-03-29.
 */
public class FZIStef {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int set = 0;
        try {
            set = Integer.valueOf(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] trasa = new int[set];

        for (int i = 0; i < set; i++) {
            trasa[i] = Integer.valueOf(br.readLine());

        }

        int biggest = 0;

        for (int i = 0; i < trasa.length; i++) {
            if (trasa.length == 1) {
                biggest = trasa[i];
            }
            int currentVal = trasa[i];
            for (int j = i+1; j < trasa.length; j++) {
                currentVal += trasa[j];
                if (currentVal > biggest) {
                    biggest=currentVal;
                }
            }

        }




        System.out.println(biggest);
    }
}
