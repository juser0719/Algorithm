package algo;
import java.util.Scanner;

public class 평탄화 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int dump = sc.nextInt();
            int[] map = new int[101];
            int max = 1;
            int min = 100;
            for (int i = 0; i < 100; i++) {
                int tmp = sc.nextInt();
                map[tmp]++;
                max = Math.max(max, tmp);
                min = Math.min(min, tmp);
            }
            for (int i = 0; i < dump; i++) {
                map[min]--;
                map[min + 1]++;

                map[max]--;
                map[max - 1]++;

                while (map[min] == 0) {
                    min++;
                }

                while (map[max] == 0) {
                    max--;
                }
            }

            System.out.println("#" + tc + " " + (max - min));
        } 
    }
}