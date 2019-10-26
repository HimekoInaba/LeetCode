package me.syrym.easy;

public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3,4}, {2,3,4,5}};


        System.out.println(a.length);
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 0) {
            return false;
        }
        if (coordinates.length == 1) {
            return true;
        }
        int prevX = coordinates[0][0], prevY = coordinates[0][1];
        for (int i = 1; i < coordinates.length; i++) {
            if (((prevX + coordinates[i][1]) - (prevY + coordinates[i][0])) == 0) {
                prevY = coordinates[i][1];
                prevX = coordinates[i][0];
            } else {
                return false;
            }
        }
        return true;
    }
}
