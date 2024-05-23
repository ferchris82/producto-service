package chrisferdev.producto_service.dto;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "producto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductoRequest {

    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

}
