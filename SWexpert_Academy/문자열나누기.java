package SWexpert_Academy;

import java.util.*;

public class 문자열나누기 {

    static HashSet<String> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0 ; t < T; t ++){
            String s = sc.next();

            set = new HashSet<String>();
            String name = "";

            for (int i = 0 ; i < s.length(); i ++ )
            {
                name = "";
                for(int j = i; j < s.length();j++)
                {
                    name += s.substring(j, j+1);
                    set.add(name);
                }
            }
            List<String> li = new ArrayList(set);
            Collections.sort(li);

            for(String i : li){
                System.out.println(i);
            }
        }
        
        
        

    }
}
