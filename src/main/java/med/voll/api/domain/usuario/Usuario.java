package med.voll.api.domain.usuario;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "Usuario")
public class Usuario {

    @Id
    private String id;
    private String login;
    private String senha;
}
