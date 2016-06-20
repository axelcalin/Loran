package model;

import java.awt.Point;
import org.Element.Lorann;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class LorannTest extends TestCase {

	Point before = null;
	Point after = null;
	Lorann lorann;
	Model model;
	
	@Test
	public void test ()
	{
		model = new Model();
		model.setNextMap("n2");
		model.loadMap();

		before = new Point(model.getLorann().getX(), model.getLorann().getY());
		model.getLorann().moveRight();
		after = new Point(model.getLorann().getX(), model.getLorann().getY());
		Assert.assertNotEquals(before, after);
	}
}
