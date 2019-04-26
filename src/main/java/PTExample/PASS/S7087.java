package PTExample.PASS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S7087 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception{

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++)
        {
            int flag = 'A';
            int count = 0;
            ArrayList<String> strArr = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());


            for(int j = 0 ; j< N; j++)
                strArr.add(br.readLine());

            int end = 0;
            while(end < strArr.size()){
                end = 0;
                for(int j = 0; j<strArr.size(); j++)
                {
                    if(flag == strArr.get(j).charAt(0))
                    {
                        count++;
                        flag++;
                        break;
                    }
                    else
                    {
                        end++;
                    }
                }
            }


            if(i == T-1) sb.append("#" + (i+1) + " " + count);
            else if(i < T-1)sb.append("#" + (i+1) + " " + count + "\n");
        }
        System.out.print(sb.toString());
    }
}


//    int T = Integer.parseInt(br.readLine());
//        for(int i = 0 ; i < T; i++)
//        {
//
//        int flag = 'A';
//        int count = 0;
//        int N = Integer.parseInt(br.readLine());
//        for(int j = 0 ; j< N; j++)
//        {
//        String str = br.readLine();
//        if(flag == str.charAt(0)){
//        count++;
//        flag++;
//        }
//        }
//
//        if(i == T-1) sb.append("#" + (i+1) + " " + count);
//        else if(i < T-1)sb.append("#" + (i+1) + " " + count + "\n");
//        }
//        System.out.print(sb.toString());