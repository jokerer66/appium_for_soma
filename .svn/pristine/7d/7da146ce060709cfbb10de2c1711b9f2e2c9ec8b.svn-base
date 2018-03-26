package help.startup;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/3/17.
 */
public class makeReport {
    public  static Object object = new Object();


//    public static void main(String[] argc){
//        makeReport ee = new makeReport();
//        ee.print_report();
//
//    }

    public void print_report(){
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
        suites.add("/Users/apple/Desktop/soma-test/src/test/java/com/instanza/soma/test/MiniRegressionSuite.xml");
        testNG.setTestSuites(suites);

        testNG.setOutputDirectory("/Users/apple/Downloads/packagetool-about/apache-tomcat-9.0.0.M4/webapps/downreport"+Thread.currentThread().getName());
        System.out.println("output" + testNG.getOutputDirectory());

        testNG.run();

    }

}
