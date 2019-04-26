package Schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

public class TestJob2 implements Job {

    public void execute(JobExecutionContext context){
        System.out.println("TestJob2.execute() is Execute... : " + new Date());
    }

}
