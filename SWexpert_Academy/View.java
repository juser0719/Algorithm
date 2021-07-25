package SWexpert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class View {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt( br.readLine());
        int[] bulidings = new int[N];
        int T = 1;
        int idx= 0;
        for(String height : br.readLine().split(" ")){
            bulidings[idx] = Integer.parseInt(height);
            idx++;
        }

        int cnt = 0;
        for(int i = 2 ; i < N-2; i ++){
            int now = bulidings[i];
            int max = Math.max(Math.max(bulidings[i-2],bulidings[i-1]),Math.max(bulidings[i+1],bulidings[i+2]));
            if (now > max){
                cnt += now - max;
            }
        }
        System.out.println("#" + T +" " + cnt);
        T++;
    }    
}
