package med.voll.api.domain.medico;

import lombok.*;
import med.voll.api.domain.endereco.Endereco;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "medico")
public class Medico {

    @Id
    private String id;
    private String nome;
    private String email;

    private String telefone;
    private String crm;
    private Especialidade especialidade;
    private Endereco endereco;
    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados){

        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
