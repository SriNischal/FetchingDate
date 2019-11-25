package com.atmecs.tutorialsninja.utils;

import java.util.Random;

import org.testng.annotations.Test;

public class RandomNumber {
	int randomNumber;
	@Test
	public int generateRandom()
	{
	Random objGenerator = new Random();
	   for (int iCount = 0; iCount< 1; iCount++){
	     randomNumber = objGenerator.nextInt(17);
	     System.out.println("Random No : " + randomNumber);
	    }
	   return randomNumber;

}
}
