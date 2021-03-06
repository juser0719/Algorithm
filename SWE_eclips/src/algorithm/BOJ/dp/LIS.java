package algorithm.BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {
	 public static void main(String[] args) throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    // 자신을 끝으로 하는 LIS 최장길이
    int[] LIS = new int[N + 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
    }

    int res = 0;
    for (int i = 1; i <= N; i++) {
        // 자신만으로 LIS 구성했을 때의 길이는 1
        LIS[i] = 1;

        // 자신(i)의 앞에 있는 원소들과 비교
        for (int j = 0; j < i; j++) {
            // 앞쪽 원소보다 자신이 큰 경우
            if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1)
                LIS[i] = LIS[j] + 1;
        }
        // 현재 원소의 LIS 값과 전체 최대값하고 비교하여 최댓값 갱신
        res = Math.max(res, LIS[i]);
    }

    System.out.println(res);

}


}
