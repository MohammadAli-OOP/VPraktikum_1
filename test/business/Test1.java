package business;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class Test1 {

	
	@Test
	void test2() {
		Tee tee=new Tee("Gr�ne Minze", 319, 2, "ja", new String[] {"Gr�ner Tee","Pfefferminze"});
		assertTrue(()->tee.getKoffin()=="ja");
	}
	
	@Test
	void test() {
		assertThrows(IllegalArgumentException.class, ()->new Tee("Gr�ne Minze", 319, 2, "ja",null));
	}

}
