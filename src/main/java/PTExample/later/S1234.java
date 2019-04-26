package PTExample.later;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1234 {

    public static void main(String args[]) throws Exception{

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 1; i++) {
            sb.append("#" + (i + 1) + " ");

            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            int UP = 1, DOWN = 1;
            char anw[] = new char[size];

            for (int j = 0; j < size; j++)
                anw[j] = str.charAt(j);

/////////////////////////////////// 메인
            for(int k = 0; k<= size-1; k++) {
                if((k + 1 + DOWN) >= 0 && (k  + UP < size)) {
//                    while (anw[k + UP] == '-') {
//                        if ((k + 1 + UP) > size - 1) break;
//                        UP++;
//                    }
//                    while (anw[k + 1 - DOWN] == '-') {
//                        if ((k + 1 + DOWN) < 0) break;
//                        DOWN++;
//                    }

                    while(anw[k + 1 - DOWN] == anw[k + UP]) {
                        anw[k + UP] = '-';
                        anw[k + 1 - DOWN] = '-';
                        DOWN++;
                        UP++;
                        if((k + 1 + DOWN < 0) || (k  + UP >= size)) {
                            break;
                        }
                        if(anw[k + 1 - DOWN] != anw[k + UP]){
                            k = k + UP - 1;
                            UP = 1; DOWN= 1;
                            break;
                        }
                    }
                }

            }

////////////////////메인




            for (int j = 0; j < size; j++){
                if(anw[j] != '-') {
                    sb.append(anw[j]);
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
