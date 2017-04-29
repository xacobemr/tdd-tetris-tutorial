package tetris;

import org.junit.runner.RunWith;

import net.orfjackal.nestedjunit.NestedJUnit;
import org.junit.*;

@RunWith(NestedJUnit.class)
public class Step7_ImprovingCoverageTest extends Assert{

	Block block = new Block('.');
	
	
	@Test
	public void returnTrue(){
		assertEquals(true,block.is_hollow_at(1, 1));
	}
	
	@Test
	public void returnFalse(){
		assertEquals(false,block.is_hollow_at(0, 0));
	}
	
}
