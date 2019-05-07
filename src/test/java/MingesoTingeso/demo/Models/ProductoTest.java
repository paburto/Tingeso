package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductoTest {

    @Test
    public void getId() {
        Producto p= new Producto();
        p.setPrecio(10000);
        assertEquals(10002, p.getPrecio());
    }
}