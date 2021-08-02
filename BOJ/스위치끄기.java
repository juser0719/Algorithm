package BOJ;

import java.util.Scanner;

public class 스위치끄기 {
    static int[] switchs;
    static int P = 0;
    public static void pelen(int[] arr,int idx,int cnt)
    {
        int left = idx- cnt;
        int right = idx + cnt;

        if (0<left && right < arr.length && (arr[left] == arr[right]))
            pelen(arr, idx, cnt+1);
        else
            P = cnt-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        switchs = new int[N+1]; // 0~8

        for(int i = 1 ; i <= N; i++)
            {
                switchs[i] = sc.nextInt();
            }
        int M = sc.nextInt();

        for(int i = 0 ; i < M;i ++)
        {
            int type = sc.nextInt();
            int idx  = sc.nextInt();

            if (type == 1) // man
            {   
                for(int j  = idx; j <= N ; j+=idx)
                {
                    if(switchs[j] == 1)
                        switchs[j] = 0;
                    else
                        switchs[j] = 1;
                }
            } else 
            {
                pelen(switchs,idx,1);
                // System.out.println("펠린드롭옵ㅇㅂ옵오오보"+P);
                for(int j = idx -P; j <= idx+P ; j++)
                {
                    if(switchs[j] == 1)
                        switchs[j] = 0;
                    else 
                        switchs[j] = 1;
                }
            }
        }

        for(int i = 1 ; i <= N; i++)
            {
                System.out.printf("%d ",switchs[i]);
                if(i%20 == 0) System.out.println();
            }
    }
}
