package model;

import java.awt.Point;
import org.Element.Lorann;

import org.Element.Lorann;
import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class LorannTest extends TestCase {

	Point after = null;
	Point before = null;
	Lorann lorann;
	Model model;
	
	@Test
	public void test ()
	{
		model = new Model();
		model.setNextMap("n1");
		model.loadMap();
		lorann = new Lorann(5, 5);
		before = new Point(lorann.getX(), lorann.getY());
		lorann.moveRight();
		after = new Point(lorann.getX(), lorann.getY());
		Assert.assertNotEquals(before, after);
	}
}
