package MingesoTingeso.demo.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	Producto findProductoByCodigoProducto(int codigoProducto);
	
	Producto findProductoById(Long id);
	
	Producto findProductoByCategoria(String categoria);
	
	Producto findProductoByNombreProducto(String nombreProducto);
	
	Producto deleteProductoById(Long id);
}
