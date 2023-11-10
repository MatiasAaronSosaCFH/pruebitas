package Cohorte14Equipo21.back.modelos.usuarios.auth.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterDTO (String username,
                           String password,
                           String email,
                           String direccion){

}
