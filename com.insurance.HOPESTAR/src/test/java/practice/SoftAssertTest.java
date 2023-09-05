package practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.asserts.*;
import org.testng.annotations.Test;

public class SoftAssertTest {

	SoftAssert sa = new SoftAssert();
	@Test
	public void SoftAssert()
	{
		System.out.println("----Pass 1-------");
		System.out.println("----Pass 2-------");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("A","B", "Data mismatch");
		System.out.println("----Pass 3-------");
		System.out.println("----Pass 4-------");
		sa.assertAll();
	}
	@Test
	public void SampleSoftAssert()
	{
		System.out.println("----Pass 5-------");
		sa.assertTrue(false, "True expected, resulting in false");
		System.out.println("----Pass 6-------");
	}
	@Test
	public void NullTestSoftAssert()
	{
		System.out.println("----Pass 7-------");
		Object a = new Object();
		a=null;
		sa.assertNotNull(a, "Object/variable is null");
		System.out.println("----Pass 8-------");
	}
}
//use sa.assertAll() at the end of each test script to raise exception while using soft assert

