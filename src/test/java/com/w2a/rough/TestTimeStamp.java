package com.w2a.rough;

import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {
		
		Date d = new Date();
		
		String tc = new String();
		tc="TC01_USAA_Issue_HOM_AZ_Dotcom";
		
		String testCaseName = (tc+"_"+d.toString().replace(":", "__").replace(" ", "_")+".jpg");
		System.out.println(testCaseName);

	}

}
