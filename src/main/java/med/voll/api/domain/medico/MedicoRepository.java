package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicoRepository extends MongoRepository<Medico, String> {

    public Page<Medico> findAllByAtivoTrue(Pageable paginacao);

}
