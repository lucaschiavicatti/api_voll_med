package med.voll.api.service;

import med.voll.api.domain.medico.DadosAtualizacaoMedico;
import med.voll.api.domain.medico.DadosCadastroMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico cadastrar(DadosCadastroMedico dados) {
        return repository.save(new Medico(dados));
    }

    public Medico detalhar(String id) {
        Optional<Medico> optionalMedico = repository.findById(id);

        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            return medico;
        }

        return null;
    }

    public Page<Medico> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao);
    }

    public Medico atualizar(DadosAtualizacaoMedico dados, String id) {
        Optional<Medico> optionalMedico = repository.findById(id);

        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            medico.atualizarInformacoes(dados);
            return repository.save(medico);
        }

        return null;
    }

    public void excluir(String id) {
        Optional<Medico> optionalMedico = repository.findById(id);

        optionalMedico.ifPresent(medico -> {
            medico.excluir();
            repository.save(medico);
        });

    }

}
