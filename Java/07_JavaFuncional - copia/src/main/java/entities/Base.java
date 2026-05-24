package entities;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public abstract class Base {

    private int id;
    @Builder.Default
    private boolean eliminado = false;
    @Builder.Default
    private LocalDateTime creadoFecha = LocalDateTime.now();

}
