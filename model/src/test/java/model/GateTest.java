package model;

import static org.junit.Assert.*;

import org.Element.CrystalBall;
import org.Element.Gate;
import org.Element.Lorann;
import org.Element.Sprite;
import org.Element.White;
import org.junit.Test;

import contract.IElement;

public class GateTest {
	
	Model model;
	Gate gate;
	IElement[][] construct;
	
	
	
	public void setup(){
		this.model = new Model();
		construct = new IElement[3][3];
		for(int i = 0; i<construct.length ; i++){
			for(int j = 0; j<construct[i].length ; j++){
				construct[i][j] = new White();
			}
		}
		construct[1][1] = new Lorann(1, 1);
		construct[1][0] = new Gate(false);
		construct[1][2] = new CrystalBall(1, 2);
		model.setMap(construct);
		model.getDynamicObject().add(construct[1][1]);
		gate = (Gate) construct[1][0];
	}

	@Test
	public void testKill() {
		setup();
		model.getLorann().moveLeft();
		model.tick();
		if(construct == model.getMap()){
			fail("Lorann not killed");
		}
	}
	
	@Test
	public void testOpen(){
		setup();
		Sprite gatesprite = gate.getSprite();
		model.getLorann().moveRight();
		if(gate.getSprite() == gatesprite){
			fail("Door not open");
		}
	}

}
