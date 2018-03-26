package utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by sam on 2017/3/10.
 */
public class MyProcess {
    /*
    private static MyProcess ProcessObj;
    public static MyProcess getInstance() {
        if (ProcessObj == null) {
            synchronized (MyProcess.class) {
                if (ProcessObj == null) {
                    ProcessObj = new MyProcess();
                }
            }
        }
        return ProcessObj;
    }
    public MyProcess(){}
*/
    public static String execCommand(String command){
        String str = "";
        try {

            Process process;
            InputStreamReader ir;
            LineNumberReader input;
            String line = "";
            process = Runtime.getRuntime().exec(command);
            ir = new InputStreamReader(process.getInputStream());
            input = new LineNumberReader(ir);
            while ((line = input.readLine()) != null) {
                str  = str + line +"\n";
            }
            input.close();
            ir.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String execCommand_simple(String command){
        String str = "";
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] a){
        System.out.println("sdf  == "+execCommand("lsof -i tcp:4726"));
    }

    public static Boolean IsProcessActive(long port) {
        Boolean flag = false;
        String command = "lsof -i tcp:"+port;
        String result = "";
        try {

            result = execCommand(command);
            if(result.contains(String.valueOf(port))){
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
/*
    public static void kill(String command) {

        try {
            java.lang.Process process;
            InputStreamReader ir;
            LineNumberReader input;
            String line = null;
            process = Runtime.getRuntime().exec(command);
            ir = new InputStreamReader(process.getInputStream());
            input = new LineNumberReader(ir);

            while ((line = input.readLine()) != null) {
                StringBuilder KillAdbString = new StringBuilder();
                KillAdbString.append("kill -9 ");
                KillAdbString.append(line.toString());
                process = Runtime.getRuntime().exec(KillAdbString.toString());
            }
            input.close();
            ir.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
}
