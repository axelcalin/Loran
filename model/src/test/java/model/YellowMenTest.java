package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.Element.Lorann;
import org.Element.Stone;
import org.Element.White;
import org.Element.YellowMen;
import org.junit.Test;

import contract.IElement;

public class YellowMenTest
{
	YellowMen yellowMen;
	Model model;
	Point before;
	
	public void setup(){
		model = new Model();
		IElement[][] construct = new IElement[3][3];
		for(int i = 0; i<construct.length ; i++){
			for(int j = 0; j<construct[i].length ; j++){
				construct[i][j] = new White();
			}
		}
		construct[1][1] = new YellowMen(1, 1);
		model.setMap(construct);
		model.getDynamicObject().add(construct[1][1]);
		this.yellowMen = (YellowMen) construct[1][1];
	}
	
	public void setup2(){
		model = new Model();
		IElement[][] construct = new IElement[3][3];
		for(int i = 0; i<construct.length ; i++){
			for(int j = 0; j<construct[i].length ; j++){
				construct[i][j] = new Stone();
			}
		}
		construct[1][1] = new YellowMen(1, 1);
		model.setMap(construct);
		model.getDynamicObject().add(construct[1][1]);
		this.yellowMen = (YellowMen) construct[1][1];
	}
	
	public void setupKill(){
		model = new Model();
		IElement[][] construct = new IElement[3][3];
		for(int i = 0; i<construct.length ; i++){
			for(int j = 0; j<construct[i].length ; j++){
				construct[i][j] = new Stone();
			}
		}
		construct[1][1] = new YellowMen(1, 1);
		construct[1][2] = new Lorann(2,1);
		model.setMap(construct);
		model.getDynamicObject().add(construct[1][1]);
		model.getDynamicObject().add(construct[1][2]);
		this.yellowMen = (YellowMen) construct[1][1];
	}
	
	@Test
	public void testLeft ()
	{
		setup();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveLeft();
		assertEquals(before.x, yellowMen.getX()+1);
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testRight ()
	{
		setup();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveRight();
		assertEquals(before.x, yellowMen.getX()-1);
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testUp ()
	{
		setup();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveUp();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY()+1);
	}
	
	@Test
	public void testDown ()
	{
		setup();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveDown();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY()-1);
	}
	
	@Test
	public void testUpRight ()
	{
		setup();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveUpRight();
		assertEquals(before.x, yellowMen.getX()-1);
		assertEquals(before.y, yellowMen.getY()+1);
	}
	
	@Test
	public void testDownRight ()
	{
		setup();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveDownRight();
		assertEquals(before.x, yellowMen.getX()-1);
		assertEquals(before.y, yellowMen.getY()-1);
	}
	
	@Test
	public void testUpLeft ()
	{
		setup();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveUpLeft();
		assertEquals(before.x, yellowMen.getX()+1);
		assertEquals(before.y, yellowMen.getY()+1);
	}
	
	@Test
	public void testDownLeft ()
	{
		setup();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveDownLeft();
		assertEquals(before.x, yellowMen.getX()+1);
		assertEquals(before.y, yellowMen.getY()-1);
	}
	
	@Test
	public void testLeftBlocking ()
	{
		setup2();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveLeft();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testRightBlocking ()
	{
		setup2();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveRight();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testUpBlocking ()
	{
		setup2();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveUp();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testDownBlocking ()
	{
		setup2();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveDown();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testUpRightBlocking ()
	{
		setup2();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveUpRight();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testDownRightBlocking ()
	{
		setup2();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveDownRight();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testUpLeftBlocking ()
	{
		setup2();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveUpLeft();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testDownLeftBlocking ()
	{
		setup2();
		before = new Point(yellowMen.getX(),yellowMen.getY());
		yellowMen.moveDownLeft();
		assertEquals(before.x, yellowMen.getX());
		assertEquals(before.y, yellowMen.getY());
	}
	
	@Test
	public void testKillLorann(){
		setupKill();
		yellowMen.moveRight();
		model.doKill();
		if(!(model.getElementxy(yellowMen.getX(), yellowMen.getY()) instanceof YellowMen)){
			fail("YellowMen killed.");
		}
		if(!(model.getElementxy(yellowMen.getX()+1, yellowMen.getY()) instanceof White)){
			fail("Lorann not killed.");
		}
	}
}
