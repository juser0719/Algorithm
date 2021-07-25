package SWexpert_Academy;

class ShapePrinter {
    public void printPyramid (int height){
        int n = 1;
        int cnt = 1;
        String max_num = Integer.toString(height * (height + 1)/2);
        for(int h =0 ; h < height;  h++){
            
            for(int i = 0 ; i < cnt ; i ++){
                int padding = max_num.length() - Integer.toString(n).length();
                String str = "";
                while(padding != 0){
                    str += " ";
                    padding--;
                }
                System.out.print(str + n + " ");
                n++;
            }
            System.out.println();
            cnt ++;
        }
    }
}

public class 플로이드삼각형 {
    public static void main(String[] args) {
        
        ShapePrinter sh =  new ShapePrinter();
        sh.printPyramid(15);
    }
}
