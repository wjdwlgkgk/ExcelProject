package PTExample.PASS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4698 {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String args[]) throws Exception{

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++)
        {
            sb.append("#" + (i+1) + " " );
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int anw= sol(A, B, D);

            sb.append(anw + "\n");

        }
        System.out.print(sb);
    }

    public static int sol(int A, int B, int D){

        int anw = 0;

        int arr[] = new int[B+1];

        for(int i = 2; i<= B; i++){
            arr[i] = i;
        }

        for(int i = 2; i<= B; i++) {
            if (arr[i] == 0)
                continue;
            for (int j = i + i; j <= B; j += i) {
                arr[j] = 0;
            }
        }


        for(int i = A; i<= B; i++) {
            if((arr[i] != 0)) {
                int temp = arr[i];
                while(temp != 0) {
                    if(temp % 10 == D) {
                        anw++;
                        break;
                    }
                    temp/=10;
                }
            }
        }

        return anw;
    }

}
