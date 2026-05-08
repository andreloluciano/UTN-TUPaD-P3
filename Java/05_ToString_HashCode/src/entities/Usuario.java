package entities;
import enums.Rol;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Rol rol;
    // asociacion con pedido
    private Set<Pedido> pedidos; // un usuario puede tener muchos pedidos

    public Usuario(int id, String nombre, String apellido, String email,
                   String password,
                   Rol rol) {

        super(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.pedidos = new HashSet<>();      // inicializo el set
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Rol getRol() {
        return rol;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    // metodo para agregar pedidos
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                ", pedidos=" + pedidos +
                '}';
    }

    @Override // para comparar usuarios
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email); // comparacion por mail
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }
}
