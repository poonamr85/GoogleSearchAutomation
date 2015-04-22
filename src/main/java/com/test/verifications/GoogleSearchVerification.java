package com.test.verifications;

import org.testng.Assert;

import com.test.google.util.Google;

public final class GoogleSearchVerification {
	private static final String MATCH_URL_STRING = "https://www.google.com/maps/place";
	
	public static void resultPageVerification(){
		Assert.assertTrue(Google.getResultPage(),"Search results not found");
		Assert.assertTrue(Google.getCurrentURL(),"InCorrect result page");
	}
	
	public static void imagePresenceVerification(){
	Assert.assertTrue(Google.getImagePresence(),"Map image is not Present on the page");
	}
	
	public static void sourceImageVerification(){
	Assert.assertTrue(Google.getURLString().startsWith(MATCH_URL_STRING),"String URL is not as expected");
	}
	
	public static void searchBoxTextVerification(){
		Assert.assertTrue(Google.getSearchBoxText(), "Text does not contain 12345");
	}
}
