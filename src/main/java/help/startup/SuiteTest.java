package help.startup;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/3/17.
 */
public class SuiteTest {

    public void StartSuiteTest(){
//        TestNG testNG = new TestNG();
//        testNG.setTestClasses(new Class[]{Testsuite1.class});
//
//        HTMLReporter test = new HTMLReporter();
//        JUnitXMLReporter test2 = new JUnitXMLReporter();
//        testNG.addListener(test);
//        testNG.addListener(test2);
//        testNG.run();
        TestNG testNG = new TestNG();
        List<String> suites = new ArrayList<String>();
//        web文件流的启动路劲是tomcat下的bin文件夹,可以用相对路径../webapps/工程名/
//        suites.add("../webapps/soma-test/WEB-INF/classes/com/instanza/soma/test/MiniRegressionSuite.xml");
        suites.add("/Users/"+System.getProperties().getProperty("user.name")+"/Desktop/xmlfile/MiniRegressionSuite.xml");
        testNG.setTestSuites(suites);

        //NeedToDo debug调试时要用绝对路径访问
        testNG.setOutputDirectory("../webapps/downreport"+Thread.currentThread().getName());

        System.out.println("output" + testNG.getOutputDirectory());

        testNG.run();
    }

}
