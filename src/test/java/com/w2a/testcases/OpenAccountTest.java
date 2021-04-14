package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase {

	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void openAccountTest(Hashtable<String, String> data) throws InterruptedException {
		if (!(TestUtil.isTestRunnable("OpenAccountTest", excel))) {
			throw new SkipException("Skipping the test " + "OpenAccountTest".toUpperCase() + "As the Run mode is NO");
		}
		
		click("openAccountBtn_CSS");
		select("customerName_CSS", data.get("customer"));
		select("curreny_CSS", data.get("currency"));
		click("processBtn_CSS");
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
	}

}
