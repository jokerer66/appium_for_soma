package help.startup;

import help.bean.AppiumServer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by apple on 2017/3/14.
 */
public class SuiteTestThread implements Runnable {
    String index;
    public static AppiumServer appiumServer = new AppiumServer();
    ExecutorService pool = null;
    public SuiteTestThread(){

    }
    public SuiteTestThread(String index) {
        this.index = index;
    }

    @Override
    public void run(){
        Thread.currentThread().setName(index);
        new SuiteTest().StartSuiteTest();
    }

}
