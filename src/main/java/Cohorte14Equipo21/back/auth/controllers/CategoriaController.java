package Cohorte14Equipo21.back.auth.controllers;

import Cohorte14Equipo21.back.modelos.categoria.Categoria;
import Cohorte14Equipo21.back.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Page<Categoria>> getAllPaginated(@RequestParam(defaultValue = "1") int page,
                                                           @RequestParam(defaultValue = "10") int size,
                                                           @RequestParam(defaultValue = "id") String sortBy,
                                                           @RequestParam(defaultValue = "ASC") String sortOrder) {
        Page<Categoria> categories = categoriaService.getPages(page,size,sortBy,sortOrder);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable(value = "id") Long id ){
        var prueba = categoriaService.encontrarCategoria(id);
        return prueba.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());


}
