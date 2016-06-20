package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.*;

public class DAOHelloWorldTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public void testcreate ()
	{
		assertEquals(null, DAOHelloWorld.HelloWorld find(1));
		assertEquals("test", "test");
	}
	

}
