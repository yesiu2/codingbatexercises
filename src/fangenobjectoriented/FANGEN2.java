package fangenobjectoriented;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojciech on 2018-04-02.
 */
public class FANGEN2 {

    public static void main(String[] args) throws IllegalArgumentException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> fans = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            int fan = 0;
            try {
                fan = Integer.parseInt(bf.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fan == 0) {
                break;
            }
            fans.add(fan);
        }

        FanFactory fanFactory = new FanFactory();

        for (Integer fan : fans) {
            if (fan > 0) {
                Fan fanLeft = fanFactory.getFan(fan, FanDirection.LeftCurved);
                fanLeft.draw();
            } else {
                Fan fanRight = fanFactory.getFan(fan, FanDirection.RightCurved);
                fanRight.draw();
            }
        }
    }


    public static class FanFactory {

        Fan getFan(int i, FanDirection direction) throws IllegalArgumentException {
            if (direction.equals(FanDirection.LeftCurved)) {
                Fan fan = new Fan();
                String[][] fanTab = new String[i * 2][i * 2];
                wiatraczekLewoskretny(fanTab);
                fan.setFanTab(fanTab);
                return fan;

            } else if (direction.equals(FanDirection.RightCurved)) {
                Fan fan = new Fan();
                String[][] fanTab = new String[Math.abs(i*2)][Math.abs(i*2)];
                wiatraczekPrawoskretny(fanTab);
                fan.setFanTab(fanTab);
                return fan;
            } else {
                throw new IllegalArgumentException();
            }
        }

        static String[][] wiatraczekPrawoskretny(String[][] fanTab) {

            rightCurvedLeftUpWing(fanTab);
            rightCurvedLeftDownWing(fanTab);
            rightCurvedRightDownWing(fanTab);
            rightCurvedRightUpWing(fanTab);




            return fanTab;
        }

        private static void rightCurvedRightUpWing(String[][] fanTab) {
            for (int row = 0; row < fanTab.length/2; row++) {
                int a = fanTab.length-1;
                for (int col = fanTab.length/2; col < fanTab.length; col++) {

                    fanTab[row][col]= fanTab[(fanTab.length/2)+row][a];
                    a--;
                }

            }
        }

        private static void rightCurvedRightDownWing(String[][] fanTab) {
            for (int row = fanTab.length/2; row < fanTab.length; row++) {
                for (int col = fanTab.length/2; col < fanTab.length; col++) {

                    if (row >=col) {
                        fanTab[row][col] = "*";
                    } else {
                        fanTab[row][col] = ".";
                    }
                }

            }
        }

        private static void rightCurvedLeftDownWing(String[][] fanTab) {
            for (int i = fanTab.length/2; i < fanTab.length; i++) {
                int a = (fanTab.length/2)-1;

                for (int j = 0; j < fanTab.length/2; j++) {
                    fanTab[i][j] = fanTab[i-fanTab.length/2][a];
                    a--;
                }

            }
        }

        private static void rightCurvedLeftUpWing(String[][] fanTab) {

            for (int row = 0; row < fanTab.length/2; row++) {
                for (int col = 0; col < fanTab.length/2; col++) {

                    if (row <=col) {
                        fanTab[row][col] = "*";
                    } else {
                        fanTab[row][col] = ".";
                    }
                }

            }
        }

        private static String[][] wiatraczekLewoskretny(String[][] fanTab) {

            leftCuvedLeftUpWing(fanTab);
            leftCurvedLeftDownWing(fanTab);
            leftCurvedRightDownWing(fanTab);
            leftCurvedRightUpWing(fanTab);




            return fanTab;
        }

        private static void leftCurvedLeftDownWing(String[][] fanTab) {
            for (int i = 0; i < fanTab.length/2; i++) {
                int a = (fanTab.length/2)-1;
                for (int j = 0; j < fanTab.length/2; j++) {
                    fanTab[i+fanTab.length/2][j] = fanTab[i][a];
                    a--;
                }
            }
        }


        private static void leftCuvedLeftUpWing(String[][] fanTab) {
            for (int row = 0; row < fanTab.length/2; row++) {
                for (int col = 0; col < fanTab.length/2; col++) {

                    if (row >= col) {
                        fanTab[row][col] = "*";
                    } else {
                        fanTab[row][col] = ".";
                    }
                }

            }
        }

        private static void leftCurvedRightDownWing(String[][] fanTab) {
            for (int row = fanTab.length/2; row < fanTab.length; row++) {
                for (int col = fanTab.length/2; col < fanTab.length; col++) {

                    if (row <=col) {
                        fanTab[row][col] = "*";
                    } else {
                        fanTab[row][col] = ".";
                    }
                }

            }
        }

        private static void leftCurvedRightUpWing(String[][] fanTab) {
            for (int row = 0; row < fanTab.length/2; row++) {
                int a = fanTab.length/2;
                for (int col = fanTab.length/2; col < fanTab.length; col++) {

                    fanTab[row][col] = fanTab[a][fanTab.length-row-1];
                    a++;
                }

            }
        }
    }


    public static class Fan implements Draw {

        String[][] fanTab;

        public String[][] getFanTab() {
            return fanTab;
        }

        public void setFanTab(String[][] fanTab) {
            this.fanTab = fanTab;
        }

        @Override
        public void draw() {
            String[][] fanTab = this.fanTab;
            for (String[] aFanTab : fanTab) {
                for (int k = 0; k < fanTab.length; k++) {
                    System.out.print(aFanTab[k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        }
    }

    interface Draw {
        void draw();
    }

    enum FanDirection {
        LeftCurved,
        RightCurved
    }
