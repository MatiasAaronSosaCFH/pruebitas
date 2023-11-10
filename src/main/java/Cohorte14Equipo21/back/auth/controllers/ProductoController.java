package Cohorte14Equipo21.back.auth.controllers;

import Cohorte14Equipo21.back.modelos.categoria.Categoria;
import Cohorte14Equipo21.back.modelos.producto.DTO.ProductoDTO;
import Cohorte14Equipo21.back.modelos.producto.DTO.ProductoRecibido;
import Cohorte14Equipo21.back.modelos.producto.Producto;
import Cohorte14Equipo21.back.service.CategoriaService;
import Cohorte14Equipo21.back.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    CategoriaService categoriaService;
    @GetMapping
    public ResponseEntity<Page<Producto>> todosLosProductos(@RequestParam(defaultValue = "1") int page,
                                                            @RequestParam(defaultValue = "10") int size,
                                                            @RequestParam(defaultValue = "id") String sortBy,
                                                            @RequestParam(defaultValue = "ASC") String sortOrder){
        Page<Producto> productos = productoService.getPages(page,size,sortBy,sortOrder);
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/{productoRecibido}")
    public ResponseEntity<ProductoDTO> agregarProducto(@RequestBody @Valid ProductoRecibido productoRecibido){
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<Page<Producto>> findByCategory(@PathVariable Long categoryId, @RequestParam(defaultValue = "1") int page,
                                                         @RequestParam(defaultValue = "10") int size,
                                                         @RequestParam(defaultValue = "id") String sortBy,
                                                         @RequestParam(defaultValue = "ASC") String sortOrder) {
        Optional<Categoria> category = categoriaService.encontrarCategoria(categoryId);
        if(category.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
        return ResponseEntity.ok(productoService.findByCategory(pageable, category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findOneById(@PathVariable Long id) {
        Optional<Producto> product = productoService.encontrarProducto(id);
        if(product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }
}
