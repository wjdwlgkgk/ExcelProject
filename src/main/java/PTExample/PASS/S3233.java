package PTExample.PASS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3233 {

   static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
   static StringTokenizer st;
   static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception{

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i< T; i++)
        {
            sb.append("#" + (i+1) + " ");
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            float anw = (x * x) / ((float)y * y);

            sb.append((int)anw + "\n");
        }
        System.out.print(sb);
    }
}
