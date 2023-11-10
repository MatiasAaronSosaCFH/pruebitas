package Cohorte14Equipo21.back.auth.controllers;

import Cohorte14Equipo21.back.modelos.usuarios.auth.DTO.AuthResponseDTO;
import Cohorte14Equipo21.back.modelos.usuarios.auth.DTO.RegisterDTO;
import Cohorte14Equipo21.back.modelos.usuarios.auth.DTO.UserDTO;
import Cohorte14Equipo21.back.repositorios.UsersRepository;
import Cohorte14Equipo21.back.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class Login {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AuthService authService;
    @PostMapping("/entry")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(authService.login(userDTO));
    }
    @PostMapping("/registro")
    public ResponseEntity<AuthResponseDTO> resgitro(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(authService.register(registerDTO));
    }
}
