package Cohorte14Equipo21.back.modelos.registrodecompra.dto;

import Cohorte14Equipo21.back.modelos.producto.DTO.ProductoDTO;

import java.util.List;

public record RegistroDeCompraDTO( List<ProductoDTO> productos) {
}
