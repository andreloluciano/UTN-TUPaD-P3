package entities;
import java.util.Objects;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "nombre", callSuper = false) // compara productos por nombre
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Producto extends Base {

    private String nombre;
    private double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;

}
