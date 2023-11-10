package Cohorte14Equipo21.back.modelos.imagen;

import Cohorte14Equipo21.back.modelos.imagen.DTO.ImagenDTO;
import Cohorte14Equipo21.back.modelos.producto.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "imagen_nombre", nullable = false)
    private String nombre;
    @Column(name = "imagen_url", nullable = false)
    private String imagenUrl;
    @Column(name = "imagen_id", nullable = false)
    private String imagenId;


    public Imagen(String nombre, String imagenUrl, String imagenId){
        this.nombre=nombre;
        this.imagenUrl=imagenUrl;
        this.imagenId=imagenId;
    }

    public Imagen(ImagenDTO imagenDTO){
        this.nombre = imagenDTO.nombre();
        this.imagenUrl=imagenDTO.url();
        this.imagenId=imagenDTO.id();
    }


    public static Imagen retornarImagen(ImagenDTO imagenDTO){
        return new Imagen(imagenDTO);
    }
}
