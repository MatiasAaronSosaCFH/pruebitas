package Cohorte14Equipo21.back.service;

import Cohorte14Equipo21.back.modelos.usuarios.usuario.User;
import Cohorte14Equipo21.back.repositorios.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    private  static  UsersRepository usuarioP;


    public Optional<User> tomarUsuario(Long id){
        return usersRepository.findById(id);
    }

    public static User traerUsuario(Long id){
        Optional<User> usuario = usuarioP.findById(id);
        return usuario.orElse(null);
    }
}
