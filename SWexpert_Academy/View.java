package SWexpert_Academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class View {
    static int N;
   	static int[] building;
	public static void main(String args[]) throws IOException
	{
		System.setIn(new FileInputStream("/Users/jeon-ungjae/Desktop/woong/Coding/Algorithm/SWexpert_Academy/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T=10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); 
            building = new int[N];
            for (int i = 0; i < N; i++) {
                building[i] = sc.nextInt();
            }

            int cnt = 0;
            
            for (int i = 2; i < N - 2; i++) {
                int max = Math.max(building[i - 2], Math.max(building[i - 1], Math.max(building[i + 1], building[i + 2])));
                if (building[i] - max > 0)
                    {
                        cnt += building[i] - max;
                        i +=2;
                    }
            }

            System.out.println("#" + test_case + " " + cnt);


		}
	}
}
