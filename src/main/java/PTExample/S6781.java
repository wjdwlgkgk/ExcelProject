package PTExample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S6781 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {


        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++)
        {
            String num = br.readLine();
            String color = br.readLine();
            //R == 1, G == 2, B == 3
            int card[][] = new int[2][9];

            boolean Nflag = false, Cflag = false, conflag = false;

            for(int j=0; j<9; j++){
                card[0][j] = num.charAt(j) - 48 ;
                if(color.charAt(j) == 'R') card[1][j] = 1;
                else if(color.charAt(j) == 'G') card[1][j] = 2;
                else if(color.charAt(j) == 'B') card[1][j] = 3;
            }



            sb.append("#" + (i+1));
            if(Cflag && Nflag && conflag)
                sb.append(" Win\n");
            else
                sb.append(" Continue\n");
            // 세 숫자가 모두 같거나  111 세 숫자가 모두 연속된 숫자. 123
            // 동일한 색의 카드 세장. RRR


        }
        System.out.print(sb.toString());
    }
}
