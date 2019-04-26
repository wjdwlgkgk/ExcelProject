package PTExample.PASS;

import java.util.Scanner;

public class S7510 {
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i = 1; i<= T; i++) {
            sb.append("#" + i + " ");
            int anw = 1;
            int N = sc.nextInt();

            if(N > 1) {
                int su = (N / 2) + 1;

                for (int j = 1; j < su; j++) {
                    int count = 1, hap = 0;
                    for (int k = j; k <= su; k++) {
                        hap += k;
                        if (hap == N) {
                            anw++;
                            break;
                        } else if (hap > N) {
                            break;
                        }
                    }
                }
            }
            sb.append(anw + "\n");
        }

        System.out.print(sb);
    }
}
