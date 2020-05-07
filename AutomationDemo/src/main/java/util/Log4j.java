package util;
/*
 * package utilities;
 * 
 * import java.io.File;
 * 
 * import org.apache.log4j.Logger; import org.apache.log4j.xml.DOMConfigurator;
 * 
 * 
 * public class Log4j {
 * 
 * 
 * 
 * // Initialize Log4j logs
 * 
 * final static Logger Log = Log4j.getLogData(Log4j.class.getName()); // This is
 * to print log for the beginning of the test case, as we usually run so many
 * test cases as a test suite
 * 
 * 
 * public static void main(String agr[]) {
 * DOMConfigurator.configure("log4j.xml");
 * 
 * Log.info("Text"); Log.info("Text"); Log.info("Text"); }
 * 
 * 
 * public static Logger getLogData(String className){ String path = new
 * File("").getAbsolutePath(); DOMConfigurator.configure("log4j.xml"); return
 * Logger.getLogger(className); }
 * 
 * public static void startTestCase(String sTestCaseName){
 * 
 * Log.info(
 * "****************************************************************************************"
 * );
 * 
 * Log.info(
 * "****************************************************************************************"
 * );
 * 
 * Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+
 * "       $$$$$$$$$$$$$$$$$$$$$$$$$");
 * 
 * Log.info(
 * "****************************************************************************************"
 * );
 * 
 * Log.info(
 * "****************************************************************************************"
 * );
 * 
 * }
 * 
 * //This is to print log for the ending of the test case
 * 
 * public static void endTestCase(String sTestCaseName){
 * 
 * Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "
 * +"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
 * 
 * Log.info("X");
 * 
 * Log.info("X");
 * 
 * Log.info("X");
 * 
 * Log.info("X");
 * 
 * }
 * 
 * // Need to create these methods, so that they can be called
 * 
 * public static void info(String message) {
 * 
 * Log.info(message);
 * 
 * }
 * 
 * public static void warn(String message) {
 * 
 * Log.warn(message);
 * 
 * }
 * 
 * public static void error(String message) {
 * 
 * Log.error(message);
 * 
 * }
 * 
 * public static void fatal(String message) {
 * 
 * Log.fatal(message);
 * 
 * }
 * 
 * public static void debug(String message) {
 * 
 * Log.debug(message);
 * 
 * }
 * 
 * }
 * 
 */