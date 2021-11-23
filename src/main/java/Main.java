package main.java;

public class Main {
    public static void main(String[] args) {

        RoboVac robovac = new RoboVac();
        robovac.setRoom(9, 8);
        robovac.furnish(2,3,new int[]{3,3});
        //robovac.furnish(4,6,new int[]{6,4});

        int[][] parameter = new int[][]{{ 1, 1 }, { 2, 2 }};

        for (int i = 0; i < parameter.length; i++) {
            for (int j = 0; j < parameter[i].length; j++) {
                System.out.print(parameter[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println();

        //robovac.cleanRoom();
        robovac.cleanRoom2(parameter);
        System.out.println();

        for (int i = 0; i < robovac.getRoom().length; i++) {
            for (int j = 0; j < robovac.getRoom()[i].length; j++) {
                System.out.print(robovac.getRoom()[i][j] + " ");
            }
            System.out.println();
        }

    }
}
