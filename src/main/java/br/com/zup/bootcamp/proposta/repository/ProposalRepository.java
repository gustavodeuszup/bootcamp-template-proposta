package br.com.zup.bootcamp.proposta.repository;

import br.com.zup.bootcamp.proposta.model.ProposalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<ProposalRequest, Long> {

    List<ProposalRequest> findByDocument(String cpf);

}
