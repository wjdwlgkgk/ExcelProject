package PTExample.PASS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S6718 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++){
            int KM = Integer.parseInt(br.readLine());
            sb.append("#" + (i+1) + " ");
            if(KM < 100) sb.append(0);
            else if(100 <= KM &&  KM < 1000) sb.append(1);
            else if(1000 <= KM &&  KM < 10000) sb.append(2);
            else if(10000 <= KM &&  KM < 100000) sb.append(3);
            else if(100000 <= KM &&  KM < 1000000) sb.append(4);
            else  sb.append(5);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
