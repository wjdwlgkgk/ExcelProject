package PTExample.later;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1494 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String args[]) throws Exception{

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++) {

            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> xArr = new ArrayList<>();
            ArrayList<Integer> yArr = new ArrayList<>();

            for(int j = 0 ; j < N ; j++){
                st = new StringTokenizer(br.readLine());
                xArr.add(Integer.parseInt(st.nextToken()));
                yArr.add(Integer.parseInt(st.nextToken()));
            }

            for(int j = 0 ; j < N ; j++){
                int Xmin = 0, Ymin = 0;
                for(int k = 0 ; k < N; k++) {
                    if(j != k) {
                        Xmin = Xmin < Math.abs(xArr.get(j) - xArr.get(k)) ? Xmin : Math.abs(xArr.get(j) - xArr.get(k));
                        Ymin = Ymin < Math.abs(yArr.get(j) - yArr.get(k)) ? Ymin : Math.abs(yArr.get(j) - yArr.get(k));
                    }
                }
            }

        }
    }

}
