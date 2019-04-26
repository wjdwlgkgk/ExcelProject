package PTExample.PASS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1244 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++)
        {
            st = new StringTokenizer(br.readLine());
            //최대 6자리 수.
            String N = st.nextToken();
            // 교환 횟수.
            int change = Integer.parseInt(st.nextToken());
            int arrInt[] = new int[N.length()];

            for(int j =0 ; j< arrInt.length; j++)
                arrInt[j] = N.charAt(j) - '0';

            int count = 0, same = 0;
            for(int j = 0 ; j< change; j++) {
                int max = 0, maxindex = 0;
                for(int k =count ; k< arrInt.length; k++) {
                    if (arrInt[k] > max) {
                        max = arrInt[k];
                        maxindex = k;
                    }
                    if(arrInt[k] == max)
                    {
                        same++;
                    }
                }
                int temp = 0;
                temp = arrInt[maxindex];
                arrInt[maxindex] = arrInt[count];
                arrInt[count] = temp;
                count++;
            }

            for(int k =0 ; k< arrInt.length; k++)
                System.out.print(arrInt[k]);
        }
    }
}

