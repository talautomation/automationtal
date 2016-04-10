package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {

	public static WebDriver driver = null;

	public static WebDriver openBrowser(int iTestCaseRow, String URL) throws Exception {

		String sBrowserName;

		try {

			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);

			if (sBrowserName.equals("Mozilla")) {

				// System.setProperty("webdriver.firefox.bin",
				// "C:\\Users\\TTRNA3\\AppData\\Local\\Mozilla
				// Firefox\\firefox.exe");

				System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\mozilla Firefox\\firefox.exe");

				driver = new FirefoxDriver();
				utility.Waitutil.implicitwait(driver);
				driver.get(URL);
				// driver.manage().window().maximize();
				utility.Waitutil.implicitwait(driver);

			}

		} catch (Exception e) {

			// Log.error("Class Utils | Method OpenBrowser | Exception desc :
			// "+e.getMessage());

		}

		return driver;

	}

	public static String getTestCaseName(String sTestCase) throws Exception {

		String value = sTestCase;
		
		

		try {
			Log.info("Test Case Name is : " + value);
			int posi = value.indexOf("@");
			
			value = value.substring(0, posi);

			posi = value.lastIndexOf(".");

			value = value.substring(posi + 1);
			

			return value;

		} catch (Exception e) {

			System.out.println("reached step 2");
			Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());

			throw (e);

		}

	}

	public static String getCurrentTimeStamp() {

		SimpleDateFormat formater = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
		Calendar calendar = Calendar.getInstance();
		String timeformat = formater.format(calendar.getTime());
		return timeformat;

		// This returns some thing like Fail_Z_debug_TC_2016-01-22
		// 14:06:48.912.png - which will fail while storing the file in the
		// destination path.
		// java.util.Date date = new java.util.Date();
		// return new Timestamp(date.getTime()).toString();

	}

	public static String captureScreenshot(WebDriver driver, String testcaseName, String screenshotDir, String Status)
			throws IOException {

		// String randomUUID = UUID.randomUUID().toString();
		// System.out.println("Randmom UUID is:- " + randomUUID);

		// This one is to append with ramndom UID
		// String fileName = screenshotDir + "/" + Status + "_" + testcaseName +
		// "_" + randomUUID + ".png";
		// System.out.println("filename is" + fileName);

		// The below code sends the file into temp path directory for example -
		// C:\Users\TTRNA3\AppData\Local\Temp\screenshot8984264717712533134.png
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// System.out.println("source file is" + scrFile);

		String scrFolder = screenshotDir + "/"
				+ new SimpleDateFormat("yyyy_MMM_dd").format(Calendar.getInstance().getTime()).toString();
		new File(scrFolder).mkdir();

		String fileName = scrFolder + "/" + Status + "_" + testcaseName + "_" + getCurrentTimeStamp() + ".png";
		// System.out.println("New source folder is:- " + scrFolder);

		File destFile = new File(fileName);
		// System.out.println("dest file is" + destFile);

		FileUtils.copyFile(scrFile, destFile);
		return fileName;
	}

}