import org.junit.Test;

public class Test_String {

    @Test
    public void name() {
        String str = "핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳핳";
        StringBuilder builder = new StringBuilder();
        int count = 0 ;

        for(;;){
            builder.append(str);
            System.out.println(count);
            count++;
        }

    }
}
