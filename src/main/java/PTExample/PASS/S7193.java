package PTExample.PASS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S7193 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {

        int T;
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String X = st.nextToken();

            int anw = 0;

            for(int j = 0 ; j< X.length(); j++)
                anw = anw + (X.charAt(j) - 48);

            anw = anw % (N-1);


            sb.append("#"+ (i+1) + " " + anw + "\n");
        }

        System.out.print(sb);
    }
}
