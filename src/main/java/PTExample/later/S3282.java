package PTExample.later;

import java.util.HashMap;
import java.util.Scanner;

public class S3282 { // knapsack

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int Test = 1; Test <= T; Test++) {
            int N = sc.nextInt();
            int maxV = sc.nextInt();

            int V[] = new int[N];
            int C[] = new int[N];
            int A[] = new int[N*(N-1)/2];

            for (int i = 0; i < N; i++) {
                V[i] = sc.nextInt();
                C[i] = sc.nextInt();
            }


        }
    }


}
