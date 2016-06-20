package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.Element.YellowMen;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class YellowMenTest
{
	YellowMen yellowMen;
	Model model;
	Point before;
	Point after;
	
	@Before
	public void Before(){
		model = new Model();
		model.setNextMap("n4");
		model.tick();
		for(int i = 0; i < model.getMap().length;i++)
		{
			for(int j = 0; j < model.getMap()[i].length;j++)
			{
				if(model.getMap()[i][j] instanceof YellowMen)
				{
					this.yellowMen = (YellowMen) model.getMap()[i][j];
				}
			}
		}
	}
	
	@Test
	public void test()
	{
		before = new Point(this.yellowMen.getX(), this.yellowMen.getY());
		yellowMen.moveRight();
		after = new Point(this.yellowMen.getX() - 1, this.yellowMen.getY());
		Assert.assertEquals(before, after);

	}

}
