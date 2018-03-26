package utils.files;

import java.io.*;

/**
 * Created by apple on 2017/4/1.
 */
public class MyFile {


    private static MyFile myfile;
    public static MyFile getInstance() {
        if (myfile == null) {
            synchronized (MyFile.class) {
                if (myfile == null) {
                    myfile = new MyFile();
                }
            }
        }
        return myfile;
    }

    public MyFile() {
    }


//    public static void main(String[] argc){
//        String filename = "/Users/"+System.getProperties().getProperty("user.name")+"/Desktop/xmlfile/MiniRegressionSuite.xml";
//        MyFile myFile = MyFile.getInstance();
//        myFile.create_exe_file(filename,"test");
//    }
    /**
     *
     * @param allfile_path  脚本文件的路径
     * @param file_context 脚本内容
     * @return
     */
    public boolean create_exe_file(String allfile_path, String file_context) {
        boolean flag = true;
        String filepath = allfile_path.substring(0,allfile_path.lastIndexOf("/"));
        File file1 = new File(filepath);
        File file2 = new File(allfile_path);
        try{
            if (!file1.exists()) {
                file1.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        writerFile(allfile_path, file_context);
        return flag;
    }

    //调用shell命令的方法
    public String run_command(String command_str) {
        String flag_run_command = "0";
        try {
            Process process = Runtime.getRuntime().exec(command_str);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line = null;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
            ir.close();
        } catch (IOException e) {
            flag_run_command = "401";
        }
        return flag_run_command;
    }

    //传入文件路径以及文件内容，写入文件
    public boolean writerFile(String filePath,String context){
        boolean flag = true;
        File file = new File(filePath);
        String str = context;
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false)));

            if(str!=null){
                bw.write(str);
            }
            bw.flush();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
            flag = false;
            System.out.println("写入文件失败");
        }

        return flag;
    }
}
