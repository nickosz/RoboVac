package main.java;

public class RoomMaker {
    private int[][] room;

    public int[][] setRoom(int n, int m) {
        int room[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    room[i][j] = 0;
                } else {
                    room[i][j] = 2;
                }
            }
        }
       return room;
    }
}
