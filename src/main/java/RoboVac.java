package main.java;

import java.util.Random;

public class RoboVac {
    private int[][] room;
    private int counter = 0;

    public void cleanRoom() {
        cleaningAlgorithmOne();
        System.out.println(counter);
    }

    public void cleanRoom2(int[][] directions) {
        cleaningAlgorithmTwo(directions);
        System.out.println(counter);
    }

    private void cleaningAlgorithmOne() {
        int[] position = setStartingPosition();
        int x = position[0];
        int y = position[1];

        while (checkForDirtySpots()) {
            printRoom(x, y);
            if (room[x][y] == 2) {
                room[x][y] = 1;
            }
            switch (randomNumber()) {
                case 0:
                    if (room[x - 1][y] != 0) {
                        x--;
                        counter++;
                    }
                    break;

                case 1:
                    if (room[x][y + 1] != 0) {
                        y++;
                        counter++;
                    }
                    break;

                case 2:
                    if (room[x + 1][y] != 0) {
                        x++;
                        counter++;
                    }
                    break;

                case 3:
                    if (room[x][y - 1] != 0) {
                        y--;
                        counter++;
                    }
                    break;
            }
        }
    }

    private void cleaningAlgorithmTwo(int[][] directions) {
        int[] position = setStartingPosition();
        int x = position[0];
        int y = position[1];
        for (int i = 0; i < directions.length; i++) {
            switch (directions[i][0]) {
                case 0:
                    for (int j = 0; j < directions[i][1]; j++) {
                        if (room[x - 1][y] == 0) {
                            break;
                        } else {
                            x--;
                            room[x][y] = 1;
                            counter++;
                            printRoom(x, y);
                        }
                    }
                case 1:
                    for (int j = 0; j < directions[i][1]; j++) {
                        if (room[x][y + 1] == 0) {
                            break;
                        } else {
                            y++;
                            room[x][y] = 1;
                            counter++;
                            printRoom(x, y);
                        }
                    }
                case 2:
                    for (int j = 0; j < directions[i][1]; j++) {
                        if (room[x + 1][y] == 0) {
                            break;
                        } else {
                            x++;
                            room[x][y] = 1;
                            counter++;
                            printRoom(x, y);
                        }
                    }
                case 3:
                    for (int j = 0; j < directions[i][1]; j++) {
                        if (room[x][y - 1] == 0) {
                            break;
                        } else {
                            y--;
                            room[x][y] = 1;
                            counter++;
                            printRoom(x, y);
                        }
                    }
            }
        }
    }

    private int[] setStartingPosition() {
        int[] startingPosition = {0, 0};
        Random r = new Random();
        Random q = new Random();

        while (room[startingPosition[0]][startingPosition[1]] == 0) {
            startingPosition[0] = r.nextInt(room.length - 1) + 1;
            startingPosition[1] = q.nextInt(room[0].length - 1) + 1;
            return startingPosition;
        }
        return startingPosition;
    }

    /*private int[] setStartingPosition() {
        int[] startingPosition = new int[2];
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[row].length; col++) {
                if (room[row][col] == 2) {
                    startingPosition[0] = row;
                    startingPosition[1] = col;
                    return startingPosition;
                }
            }
        }
        return startingPosition;
    } */

    /*private void cleaningAlgorithmTwo() {
        int[] startingPosition = setStartingPosition();
        int x = startingPosition[0];
        int y = startingPosition[1];

        for (int i = 0; i < ; i++) {

        }
    }*/
    private void printRoom(int x, int y) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (x == i && y == j) {
                    System.out.print("X ");
                } else
                    System.out.print((room)[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int randomNumber() {
        Random r = new Random();
        return r.nextInt(4);
    }

    private boolean checkForDirtySpots() {
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[row].length; col++) {
                if (room[row][col] == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setRoom(int n, int m) {
        int room[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    room[i][j] = 0;
                } else {
                    room[i][j] = 2;
                }
            }
        }
        this.room = room;
    }

    public void furnish(int length, int width, int[] position) {
        //position = new int[2];
        for (int i = position[0]; i < position[0] + length; i++) {
            for (int j = position[1]; j < position[1] + width; j++) {
                this.room[i][j] = 0;
            }
        }
    }
        /*this.room = room;
        int length = room.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (room[j].length != length) {
                    System.err.println("Add rectangular room");
                    return;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (room[i][j] < 0 || room[i][j] > 2) {
                    System.err.println("Values of room are between 0 and 2");
                    return;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (room[0][j] != 0 || room[i][0] != 0 || room[length - 1][j] != 0 || room[length - 1][j] != 0) {
                    System.err.println("Walls have to be 0");
                    return;
                }
            }
        }*/


    public int[][] getRoom() {
        return room;
    }

}
