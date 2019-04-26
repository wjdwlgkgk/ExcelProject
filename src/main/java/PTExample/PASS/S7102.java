package PTExample.PASS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S7102 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int numArr[] = new int[N + M + 2];

            for (int j = 1; j <= N; j++)
                for(int k = 1; k <= M; k++)
                    numArr[j + k] = numArr[j + k] + 1;

            int max = 0;
            ArrayList<Integer> anw = new ArrayList<>();

            for(int j = 0; j < N + M + 2; j++) {
                if (max < numArr[j]) {
                    max = numArr[j];
                }
            }
            for(int j = 0; j < N + M + 2; j++) {
                if (max == numArr[j]) {
                    anw.add(j);
                }
            }

            sb.append("#" + (i+1));
            for(int j = 0 ; j < anw.size(); j++)
                sb.append(" " + anw.get(j));

            sb.append("\n");


        }

        System.out.print(sb);

    }
}
