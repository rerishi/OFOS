package com.OFOS.HM.User.Testscripts;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OFOS.HM.GenericUtils.UserBaseClass;

@Listeners(com.OFOS.HM.GenericUtils.UserListenerImplementationClass.class)
public class UserLoginTest extends UserBaseClass{
	
	@Test(groups = "Smoke")
	public void userLogin() throws IOException, InterruptedException {
		
		String expectedTitle="Home";
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		if(expectedTitle.equalsIgnoreCase(actualTitle))
		{
			System.out.println("Passed");
		}
	}

}
