package Cohorte14Equipo21.back.controllers;

import Cohorte14Equipo21.back.modelos.registrodecompra.RegistroDeCompra;
import Cohorte14Equipo21.back.modelos.registrodecompra.dto.RegistroDeCompraDTO;
import Cohorte14Equipo21.back.service.RegistroDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class RegistroDeCompraController {

    @Autowired
    private RegistroDeCompraService registroDeCompraService;

    @GetMapping("/{id}")
    public ResponseEntity<RegistroDeCompra> retornarRegistroPorUsuario(@PathVariable Long id){
        Optional<RegistroDeCompra> registro = registroDeCompraService.buscarRegistro(id);
        return registro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarRegistroDeCompras(@RequestBody RegistroDeCompraDTO registroDeCompraDTO, @RequestBody Long id){

        if (registroDeCompraDTO.productos().isEmpty()) return new ResponseEntity<>(new String("esta vacia la lista"), HttpStatus.BAD_REQUEST);
        if (id<1) return new ResponseEntity<>(new String("el numero es incorrecto"), HttpStatus.BAD_REQUEST);
        registroDeCompraService.guardar(new RegistroDeCompra(registroDeCompraDTO, id));
        if (registroDeCompraService.buscarRegistro(id).isPresent()) return ResponseEntity.ok("Se guardo el registro correctamente");
        else return new ResponseEntity<>(new String("nose que paso papu"), HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/buscar-cliente/{id}")
    public ResponseEntity<?> buscarRegistroDeComprasPorIdDelCliente(@PathVariable Long id){
        RegistroDeCompra registro = registroDeCompraService.buscarPorIdDelCliente(id);
        if (id<1) return new ResponseEntity<>(new String("id no valido"), HttpStatus.NOT_ACCEPTABLE);
        if (registro == null) return new ResponseEntity<>(new String("no encontramos la lista"), HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok(registro);
    }
}
