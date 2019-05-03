package MingesoTingeso.demo.Controllers;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MingesoTingeso.demo.Models.Producto;
import MingesoTingeso.demo.Repositories.ProductoRepository;

@CrossOrigin
@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	ProductoRepository productoRepository;
	
	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findProductoById(id);
    }
	
	@RequestMapping(value = "/codigo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Producto getActorById(@PathVariable int codigoProducto) {
        return productoRepository.findProductoByCodigoProducto(codigoProducto);
    }
	
	@PostMapping("/create")
    @ResponseBody
    public Producto create(@RequestBody Producto resource) throws ParseException {
        return productoRepository.save(resource);
    }
}
