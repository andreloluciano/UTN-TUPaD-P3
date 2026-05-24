package entities;
import enums.Rol;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(exclude = {"password", "pedidos"}) // evita mostrar password, y pedidos para evitar stackoverflow
@EqualsAndHashCode(of = "email", callSuper = false) // compara usuarios por email
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Rol rol;
    @Builder.Default  // asociacion con pedido
    private Set<Pedido> pedidos = new HashSet<>(); // un usuario puede tener muchos pedidos

    // agrega pedidos al usuario
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}
