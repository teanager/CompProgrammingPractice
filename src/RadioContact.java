import java.io.IOException;
import java.lang.Math;

public class RadioContact {

    static int energy(int[] loc1, int[] loc2) {
        return (int)(Math.pow(loc1[0] - loc2[0], 2) + Math.pow(loc1[1] - loc2[1], 2));
    }

    public static void main(String[] args) throws IOException {
//        Kattio io = new Kattio();
        Kattio io = new Kattio("radio");

        int n = io.nextInt();
        int m = io.nextInt();

        int[][] fLoc = new int[n + 1][2];
        int[][] bLoc = new int[m + 1][2];

        fLoc[0][0] = io.nextInt();
        fLoc[0][1] = io.nextInt();

        bLoc[0][0] = io.nextInt();
        bLoc[0][1] = io.nextInt();

        String fPath = io.next();
        String bPath = io.next();

        for (int i = 1; i <= n; ++i) {
            char c = fPath.charAt(i - 1);

            fLoc[i] = fLoc[i - 1].clone();

            if (c == 'N') ++fLoc[i][1];
            else if (c == 'S') --fLoc[i][1];
            else if (c == 'E') ++fLoc[i][0];
            else if (c == 'W') --fLoc[i][0];
        }

        for (int i = 1; i <= m; ++i) {
            char c = bPath.charAt(i - 1);

            bLoc[i] = bLoc[i - 1].clone();

            if (c == 'N') ++bLoc[i][1];
            else if (c == 'S') --bLoc[i][1];
            else if (c == 'E') ++bLoc[i][0];
            else if (c == 'W') --bLoc[i][0];
        }


        int[][] dp = new int[n + 1][m + 1];
//        dp[0][0] = energy(fLoc[0], bLoc[0]);

        for (int i = 1; i <= n; ++i) {
            dp[i][0] = dp[i - 1][0] + energy(fLoc[i], bLoc[0]);
        }

        for (int i = 1; i <= m; ++i) {
            dp[0][i] = dp[0][i - 1] + energy(fLoc[0], bLoc[i]);
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                dp[i][j] += energy(fLoc[i], bLoc[j]);
            }
        }

//        io.println(dp[n][0]);
        io.println(dp[n][m]);

        io.close();


    }
}
