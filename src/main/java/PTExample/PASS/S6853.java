package PTExample.PASS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S6853 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {

        int T;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int Square[] = new int[4];
            int anw[] = new int[3];
            for (int j = 0; j < Square.length; j++)
                Square[j] = Integer.parseInt(st.nextToken());

            int Xmax = 0, Xmin = 0, Ymax = 0, Ymin = 0;
            if (Square[0] > Square[2]) {
                Xmax = Square[0];
                Xmin = Square[2];
            } else if (Square[0] < Square[2]) {
                Xmax = Square[2];
                Xmin = Square[0];
            }

            if (Square[1] > Square[3]) {
                Ymax = Square[1];
                Ymin = Square[3];
            } else if (Square[1] < Square[3]) {
                Ymax = Square[3];
                Ymin = Square[1];
            }

            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if ((Xmin < x && x < Xmax) && (Ymin < y && y < Ymax)) {
                    anw[0]++;
                }
                else if(Xmin == x || Xmax == x) {
                    if((Ymin <= y && y <= Ymax)){
                        anw[1]++;
                    }
                    else
                        anw[2]++;

                }
                else if(Ymax == y || Ymin == y) {
                    if((Xmin <= x && x <= Xmax)){
                        anw[1]++;
                    }
                    else
                        anw[2]++;
                }
                else if (Xmin > x || x > Xmax || Ymin > y || y > Ymax){
                    anw[2]++;
                }

            }
            sb.append("#" + (i + 1) + " " + anw[0] + " " + anw[1] + " " + anw[2] + "\n");
        }
        System.out.print(sb.toString());
    }
}
