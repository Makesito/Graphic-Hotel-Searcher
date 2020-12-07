import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class StringITest {

	@Test
	void test() throws IOException {
		StringI a1 = new StringI(new String[]{"Introduce new user name","Introduzca su nuevo nombre de usuario"});
		String[] lenguages = new String[]{"English","Español"};
		a1.DefineLenguages(lenguages);
		
		assertEquals(a1.getText(0),"Introduce new user name");
		assertEquals(a1.getText(1),"Introduzca su nuevo nombre de usuario");
	}

}
