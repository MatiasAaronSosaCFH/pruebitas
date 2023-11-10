package Cohorte14Equipo21.back.controllers;

import Cohorte14Equipo21.back.modelos.usuarios.usuario.User;
import Cohorte14Equipo21.back.repositorios.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/datos")
    public ResponseEntity<User> datosDelUsuario(@RequestBody Long id){
         if (usersRepository.existsById(id)) return ResponseEntity.ok(usersRepository.findById(id).get());
         else return ResponseEntity.notFound().build();
    }
}
