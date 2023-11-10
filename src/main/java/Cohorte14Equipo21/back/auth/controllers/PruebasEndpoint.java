package Cohorte14Equipo21.back.auth.controllers;

import Cohorte14Equipo21.back.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class PruebasEndpoint {

    @Autowired
    private AuthService authService;

   /* @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid LoginDTO request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody @Valid RegisterDTO request){
        return ResponseEntity.ok(authService.register(request));
    }*/
}
