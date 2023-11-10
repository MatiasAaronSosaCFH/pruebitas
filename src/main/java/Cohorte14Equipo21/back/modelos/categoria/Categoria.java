package Cohorte14Equipo21.back.modelos.categoria;

import Cohorte14Equipo21.back.modelos.producto.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;

    public Categoria(CategoriaDTO categoriaDTO){
        this.id=categoriaDTO.id();
        this.nombre=categoriaDTO.nombre();
    }

    public static Categoria retornarCategoria(CategoriaDTO categoriaDTO){
        return new Categoria(categoriaDTO);
    }
}
