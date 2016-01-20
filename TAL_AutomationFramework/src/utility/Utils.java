package utility;

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

				System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

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

			Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());

			throw (e);

		}

	}

}