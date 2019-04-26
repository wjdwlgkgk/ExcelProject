package PTExample.PASS;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception{

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            int max = 0, min = 0;
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int Prob[] = new int[N];


            for(int j = 0; j< N; j++)
                 Prob[j] = Integer.parseInt(st.nextToken());

            if(N == 2)
            {
                if(Prob[0] > Prob[1]) min = Prob[0] - Prob[1];
                else if(Prob[0] < Prob[1]) max = Prob[1] - Prob[0];
            }
            else if(N > 2) {
                for (int j = 1; j < N - 1; j++) {
                    if (Prob[j - 1] < Prob[j]) {
                        if (max < Prob[j] - Prob[j - 1])
                            max = Prob[j] - Prob[j - 1];
                    }
                    if (Prob[j - 1] > Prob[j]) {
                        if (min < Prob[j - 1] - Prob[j])
                            min = Prob[j - 1] - Prob[j];
                    }


                    if (Prob[j] < Prob[j + 1]) {
                        if (max < Prob[j + 1] - Prob[j])
                            max = Prob[j + 1] - Prob[j];
                    }
                    if (Prob[j] > Prob[j + 1]) {
                        if (min < Prob[j] - Prob[j + 1])
                            min = Prob[j] - Prob[j + 1];
                    }

                }
            }
            System.out.println("#" + (i+1) + " " + max + " " + min);
        }
    }
}