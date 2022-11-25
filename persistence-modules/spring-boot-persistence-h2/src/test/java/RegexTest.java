import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RegexTest {
    public static void main(String[] args) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int countdownStarter = 20;

            public void run() {

                System.out.println(countdownStarter);
                countdownStarter--;

                if (countdownStarter < 0) {
                    System.out.println("Timer Over!");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }

        //@Test
    public void test(){
        int runtime = 1;

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int countdownStarter = 20;

            public void run() {

                System.out.println(countdownStarter);
                countdownStarter--;

                if (countdownStarter < 0) {
                    System.out.println("Timer Over!");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);

/*        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println("print this for 15 secs");
                }
            };

            Future<?> f = service.submit(r);
            f.get(runtime, TimeUnit.SECONDS);     // attempt the task for two minutes
        }
        catch (final InterruptedException e) {
            // The thread was interrupted during sleep, wait or join
        }
        catch (final TimeoutException e) {
            // Took too long!
        }
        catch (final ExecutionException e) {
            // An exception from within the Runnable task
        }
        finally {
            service.shutdown();
            System.out.println("15 secs is over");
        }*/

        //System.out.println("print this for 15 secs");
/*        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("print this for 1min");
            }
        }, 2*60*1000);*/
        // Since Java-8
        //timer.schedule(() -> System.out.println("print this for 1min"), 1*60*1000);
    }
}

