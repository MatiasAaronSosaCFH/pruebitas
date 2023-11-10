package Cohorte14Equipo21.back.modelos.usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "calle", nullable = false)
    private String calle;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "pais", nullable = false)
    private String pais;
    @Column(name = "provincia", nullable = false)
    private String provincia;
    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;
}
