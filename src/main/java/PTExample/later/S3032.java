package PTExample.later;

import java.util.Scanner;

public class S3032 {
    public static void main(String[] args){ // 으려워

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int Test = 1; Test <= T; Test++)
        {
            sb.append("#" + Test + " ");
            int A = sc.nextInt();
            int B = sc.nextInt();
            int AC = 1, BC = -1;
            int RA = A, RB = B, R = 9999;

            while(true) {
                R = RA % RB;
                RA = RB;
                RB = R;
                if(R == 0 || R == 1){
                    break;
                }
            }

            if(R == 1) {
                while (true) {
                    if (A > B) {
                        B += B;
                        BC--;
                    } else if (A < B + 1) {
                        A += A;
                        AC++;
                    }
                    if ((A == B + 1) || (A + 1 == B)) {
                        break;
                    }
                }
                sb.append(AC + " " + BC + "\n");
            }
            else
                sb.append("-1\n");
        }
        System.out.print(sb);

    }
}