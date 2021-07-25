package SWexpert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 백만장자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        System.out.println(T);
        for(int t = 1; t <= T ; t++){
            int N = Integer.parseInt(br.readLine());
            String[] prices = br.readLine().split(" ");
            long res = 0;

            for(int i = N-1; i>=0;i--){
                int j = i-1;
                int temp=0;

                while(j>=0 && Integer.parseInt(prices[i]) > Integer.parseInt(prices[j])){
                    temp += Integer.parseInt(prices[i]);
                    temp -= Integer.parseInt(prices[j]);
                    j--;
                }

                res += temp;
                i = j+1;
                
            }
            System.out.println("#"+t+" "+res);
            
        }

    }
}