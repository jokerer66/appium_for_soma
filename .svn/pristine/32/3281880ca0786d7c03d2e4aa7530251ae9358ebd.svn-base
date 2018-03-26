package com.instanza.soma.debug;

/**
 * Created by apple on 2017/3/24.
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testthread implements Callable{


    private String packname;
    private String svnversion;
    ExecutorService pool = null;
    public testthread(String packname,String svnversion) {
        this.packname = packname;
        this.svnversion = svnversion;
    }


//    public static void main(String[] argc){
//        for(int i=0;i<2;i++)
//        {
//            testthread test = new testthread("name"+i,"222");
//            test.output("name"+i,"222");
//        }
//    }
    //单个线程处理方法，如果要串行处理，在Object前面加上synchronized
    @Override
    public Object call() throws Exception {

        String flag = "0";
        synchronized (this) {

            for(int i=0;i<60;i++){
                System.out.println("flag in thread 2= "+i+" name = "+Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }



//            notify();

        }

        return flag;
    }


    public String output(String name,String svnversion){

        String back_str="";
        try {

            System.out.println("back_str = "+back_str);
            //创建一个线程池
            pool = Executors.newFixedThreadPool(5);

            back_str = pool.submit( new testthread(name,svnversion)).get().toString();//得到返回值

            //关闭线程池
            pool.shutdown();

        }catch(Exception e){

        }

        System.out.println("back_str = "+back_str);
        return back_str;
    }


}