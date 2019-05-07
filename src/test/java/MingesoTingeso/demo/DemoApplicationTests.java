package MingesoTingeso.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testConcatenate() {
		Producto Producto = new Producto();

		String result = Producto.concatenate("one", "two");

		assertEquals("onetwo", result);

	}
}
