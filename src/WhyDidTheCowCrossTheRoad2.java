// http://www.usaco.org/index.php?page=viewproblem2&cpid=718
import java.io.*;
import java.util.*;
import java.lang.Math;

public class WhyDidTheCowCrossTheRoad2 {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("nocross");
//        Kattio io = new Kattio();

        int n = io.nextInt();

        int[] aSide = new int[n];
        int[] bSide = new int[n];

        for (int i = 0; i < n; ++i) aSide[i] = io.nextInt();
        for (int i = 0; i < n; ++i) bSide[i] = io.nextInt();

        int[][] distances = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                distances[i][j] = Math.abs(aSide[i] - bSide[j]);
            }
        }

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            if (distances[i][0] <= 4) dp[i][0] = 1;
            if (distances[0][1] <= 4) dp[0][i] = 1;
        }

        int ans = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j - 1];
                if (distances[i][j] <= 4) dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] + 1);
                else dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                ans = Math.max(ans, dp[i][j]);
            }
        }

        io.println(ans);


        io.close();

    }
}
