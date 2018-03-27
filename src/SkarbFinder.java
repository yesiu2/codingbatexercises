import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wojciech on 2018-03-24.
 */
public class SkarbFinder {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> stringList = new ArrayList<>();

        int set = 0;
        try {
            set = Integer.valueOf(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < set; i++) {
            int tips = 0;
            Map<Integer, Integer> pathMap = new HashMap<>();
            pathMap.put(0, 0);
            pathMap.put(1, 0);
            pathMap.put(2, 0);
            pathMap.put(3, 0);
            try {
                tips = Integer.valueOf(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < tips; j++) {
                String pair = null;
                try {
                    pair = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String[] pairs = pair.split(" ");

                int key = Integer.parseInt(pairs[0]);
                int value = Integer.parseInt(pairs[1]);
                if (key == 1 || key == 2) {
                    value = -value;
                }

                pathMap.put(key, pathMap.get(key)+value);
            }

            int y = pathMap.get(0) + pathMap.get(1);
            int x = pathMap.get(3) + pathMap.get(2);

            if (y == 0 && x == 0) {
                stringList.add("studnia");
            }

            int northSouthDest = 0 - y;
            int westEastDest = 0 - x;

            if (northSouthDest > 0) {
                stringList.add("1 " + Math.abs(northSouthDest));
            }
            if (northSouthDest < 0) {
                stringList.add("0 " + Math.abs(northSouthDest));
            }

            if (westEastDest > 0) {
                stringList.add("2 " + Math.abs(westEastDest));
            }

            if (westEastDest < 0) {
                stringList.add("3 " + Math.abs(westEastDest));
            }





        }

        for (String s : stringList) {
            System.out.println(s);
        }
    }

}
