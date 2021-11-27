public class WeirdAlgorithm {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        long n = io.nextInt();

        while (n != 1) {
            io.print(n + " ");

            if (n % 2 == 0) {
                n = n / 2;
            }
            else {
                n = n * 3 + 1;
            }
        }

        io.print(n);
        io.close();
    }
}
