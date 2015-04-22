package com.test.google.application.search;

import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.google.util.Google;
import com.test.verifications.GoogleSearchVerification;

public class GoogleTest {
 
	@BeforeClass
	public static void setUp() {
		Logger.getLogger("LOGGERINFO").info("******************** Launching the browser ***********************");
		Google.launchBroswer();
  }
	@Test (priority =1)
	public void openGoogleTest(){
		Logger.getLogger("LOGGERINFO").info("******************** Test case started : Open Google URL ***********************");
		Google.getURL();
		Google.searchText();
		Logger.getLogger("LOGGERINFO").info("******************** Test case Ended : Open Google URL ***********************");
	}
	
	@Test (priority = 2)
	public void verifyResultPageTest(){
		Logger.getLogger("LOGGERINFO").info("******************** Test case started : Verify Result Page ***********************");
		Google.getResultPage();
		GoogleSearchVerification.resultPageVerification();
		Logger.getLogger("LOGGERINFO").info("******************** Test case Ended : Verify Result Page ***********************");
	}
	
	@Test (priority = 3)
	public void verifyImagePresenceTest(){
		Logger.getLogger("LOGGERINFO").info("******************** Test case started : Verify Image Presence ***********************");
		Google.getImagePresence();
		GoogleSearchVerification.imagePresenceVerification();		
		Logger.getLogger("LOGGERINFO").info("******************** Test case Ended : Verify Image Presence ***********************");
	}
	
	@Test (priority = 4)
	public void verifyURLString(){
		Logger.getLogger("LOGGERINFO").info("******************** Test case started : Verify URL string ***********************");
		Google.getURLString();
		GoogleSearchVerification.sourceImageVerification();
		Logger.getLogger("LOGGERINFO").info("******************** Test case Ended : Verify URL string ***********************");
	}
	
	@Test (priority = 5)
	public void verifySearchBoxText(){
		Logger.getLogger("LOGGERINFO").info("******************** Test case started : Verify search box Text ***********************");
		Google.getSearchBoxText();
		GoogleSearchVerification.searchBoxTextVerification();
		Logger.getLogger("LOGGERINFO").info("******************** Test case Ended : Verify search box Text ***********************");
	}

	@AfterClass
	public static void tearDown() 
	{
		Google.closeBrowser();
	}
}
