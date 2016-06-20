package model;

import java.awt.Point;
import org.Element.Lorann;
import org.Element.White;
import org.Element.YellowMen;
import org.junit.Test;

import contract.IElement;
import junit.framework.TestCase;

public class LorannTest extends TestCase {

	Point before = null;
	Model model;
	
	public void setup(){
		model = new Model();
		IElement[][] construct = new IElement[3][3];
		for(int i = 0; i<construct.length ; i++){
			for(int j = 0; j<construct[i].length ; j++){
				construct[i][j] = new White();
			}
		}
		construct[1][1] = new Lorann(1, 1);
		model.setMap(construct);
		model.getDynamicObject().add(construct[1][1]);
	}
	
	public void setupKill(){
		model = new Model();
		IElement[][] construct = new IElement[3][5];
		for(int i = 0; i<construct.length ; i++){
			for(int j = 0; j<construct[i].length ; j++){
				construct[i][j] = new White();
			}
		}
		construct[1][1] = new Lorann(1, 1);
		construct[1][4] = new YellowMen(1,4);
		model.setMap(construct);
		model.getDynamicObject().add(construct[1][1]);
	}

	
	@Test
	public void testLeft ()
	{
		setup();
		before = new Point(model.getLorann().getX(),model.getLorann().getY());
		model.setPress('l');
		model.tick();
		assertEquals(before.x, model.getLorann().getX()+1);
		assertEquals(before.y, model.getLorann().getY());
	}
	
	public void testRight ()
	{
		setup();
		before = new Point(model.getLorann().getX(),model.getLorann().getY());
		model.setPress('r');
		model.tick();
		assertEquals(before.x, model.getLorann().getX()-1);
		assertEquals(before.y, model.getLorann().getY());
	}
	
	public void testUp ()
	{
		setup();
		before = new Point(model.getLorann().getX(),model.getLorann().getY());
		model.setPress('u');
		model.tick();
		assertEquals(before.x, model.getLorann().getX());
		assertEquals(before.y, model.getLorann().getY()+1);
	}
	
	public void testDown ()
	{
		setup();
		before = new Point(model.getLorann().getX(),model.getLorann().getY());
		model.setPress('d');
		model.tick();
		assertEquals(before.x, model.getLorann().getX());
		assertEquals(before.y, model.getLorann().getY()-1);
	}
	
	public void testUpRight ()
	{
		setup();
		before = new Point(model.getLorann().getX(),model.getLorann().getY());
		model.setPress('r');
		model.setPress('u');
		model.tick();
		assertEquals(before.x, model.getLorann().getX()-1);
		assertEquals(before.y, model.getLorann().getY()+1);
	}
	
	public void testDownRight ()
	{
		setup();
		before = new Point(model.getLorann().getX(),model.getLorann().getY());
		model.setPress('r');
		model.setPress('d');
		model.tick();
		assertEquals(before.x, model.getLorann().getX()-1);
		assertEquals(before.y, model.getLorann().getY()-1);
	}
	
	public void testUpLeft ()
	{
		setup();
		before = new Point(model.getLorann().getX(),model.getLorann().getY());
		model.setPress('l');
		model.setPress('u');
		model.tick();
		assertEquals(before.x, model.getLorann().getX()+1);
		assertEquals(before.y, model.getLorann().getY()+1);
	}
	
	public void testDownLeft ()
	{
		setup();
		before = new Point(model.getLorann().getX(),model.getLorann().getY());
		model.setPress('l');
		model.setPress('d');
		model.tick();
		assertEquals(before.x, model.getLorann().getX()+1);
		assertEquals(before.y, model.getLorann().getY()-1);
	}
	
	@Test
	public void testKill ()
	{
		setupKill();
		model.setPress('l');
		model.setPress('s');
		for(int i = 0; i < 4; i++){
			model.tick();
			model.setUnpress('l');
			model.setUnpress('s');
		}
		if(!(model.getElementxy(4, 1) instanceof White)){
			fail("Monster not killed");
		}
	}
}
