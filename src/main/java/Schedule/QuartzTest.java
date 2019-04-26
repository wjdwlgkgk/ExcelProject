package Schedule;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

public class QuartzTest {

    private SchedulerFactory schedulerFactory;
    private Scheduler scheduler;

    /*
    public QuartzTest(){
        try{

            schedulerFactory = new StdSchedulerFactory();
            scheduler = schedulerFactory.getScheduler();

            JobDetail job1 = new JobDetail("job1", "group1", TestJob1.class);
            CronTrigger trigger1 = new CronTrigger("trigger1", "group1", "0 * * * * ?");
            scheduler.scheduleJob(job1, trigger1);

            JobDetail job2 = new JobDetail("job2", "group2", TestJob2.class);
            CronTrigger trigger2 = new CronTrigger("trigger2", "group2", "30 * * * * ?");
            scheduler.scheduleJob(job2, trigger2);

            Thread.sleep(10000);
            scheduler.deleteJob("job2","group2");


            scheduler.start();


            }catch(SchedulerException e) {
            e.printStackTrace();
            }catch(ParseException e){
            e.printStackTrace();
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    */
        public static void main(String[] args){
            new QuartzTest();
        }


}
