package entities;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(exclude = {"productos"}) // para evitar stackoverflow
@EqualsAndHashCode(of = "nombre", callSuper = false) // compara categorias por nombre
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Categoria extends Base {

    private String nombre;

    private String descripcion;

    // inicializo el set
    @Builder.Default
    private Set<Producto> productos = new HashSet<>();

    // agregacion con producto
    // la categoria agrupa productos pero producto puede existir sin categoria
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }


}
