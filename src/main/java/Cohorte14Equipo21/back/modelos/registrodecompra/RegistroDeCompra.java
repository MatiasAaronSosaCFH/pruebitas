package Cohorte14Equipo21.back.modelos.registrodecompra;


import Cohorte14Equipo21.back.modelos.producto.Producto;
import Cohorte14Equipo21.back.modelos.registrodecompra.dto.RegistroDeCompraDTO;
import Cohorte14Equipo21.back.modelos.usuarios.usuario.User;
import Cohorte14Equipo21.back.repositorios.UsersRepository;
import Cohorte14Equipo21.back.service.UserService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registro_de_compra")
public class RegistroDeCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinColumn(name = "productos_comprados", nullable = false, referencedColumnName = "id")
    private List<Producto> productosComprados = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    public RegistroDeCompra(RegistroDeCompraDTO registroDeCompraDTO, Long id){
        this.productosComprados = registroDeCompraDTO.productos().stream().map(Producto::new).toList();
        this.user = UserService.traerUsuario(id);
    }
}
