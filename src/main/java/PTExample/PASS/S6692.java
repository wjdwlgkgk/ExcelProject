package PTExample.PASS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S6692 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws  Exception{

        Scanner scanner = new Scanner(System.in);



        int T = scanner.nextInt();

        for(int i = 0 ; i< T; i++)
        {
            int N = scanner.nextInt();
            double anw = 0;
            for(int j = 0 ; j< N; j++) {
                double p = scanner.nextFloat();
                int x = scanner.nextInt();
                anw = anw + (p * x);
            }
            anw = (Math.round(anw * 100000)/ 100000.0);
            sb.append("#" + (i+1) + " " + anw + "\n");
        }
        System.out.println(sb);
    }
}
