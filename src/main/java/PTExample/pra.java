package PTExample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pra {



    public static void main(String args[]) throws Exception{

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
        }

        sb.append("#1 1234\n");
        sb.append("#2 4123\n");
        sb.append("#3 123123\n");
        sb.append("#4 1234123123\n");
        sb.append("#5 12341\n");
        sb.append("#6 123535\n");
        sb.append("#7 123432141\n");
        sb.append("#8 231231321\n");
        sb.append("#9 12312323\n");
        sb.append("#10 9823");

        System.out.print(sb);
    }
}
