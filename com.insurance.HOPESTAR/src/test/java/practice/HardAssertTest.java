package practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {

	@Test
	public void HardAssert()
	{
		System.out.println("----Pass 1-------");
		System.out.println("----Pass 2-------");
		assertEquals("A", "B", "MISMATCH in DATA");
		System.out.println("----Pass 3-------");
		System.out.println("----Pass 4-------");
	}
	@Test
	public void SampleHardAssert()
	{
		System.out.println("----Pass 5-------");
		assertTrue(false, "True expected, resulting in false");
		System.out.println("----Pass 6-------");
	}
	@Test
	public void NullTestHardAssert()
	{
		System.out.println("----Pass 7-------");
		Object a = new Object();
		a=null;
		assertNotNull(a, "Object/variable is null");
		System.out.println("----Pass 8-------");
	}
}
