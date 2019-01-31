package list;

import java.util.ArrayList;
import java.util.List;

public class listTest {

    public static void main(String agrs[]){


    List<String> ab = new ArrayList<String>();

    for(int i=0; i<500000*8; i++)
    ab.add("a");


        System.out.println(ab.get(500000*8-1));




    }
}
