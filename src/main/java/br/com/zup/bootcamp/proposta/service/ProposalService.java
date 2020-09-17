package br.com.zup.bootcamp.proposta.service;

import br.com.zup.bootcamp.proposta.model.dto.ProposalRequestDto;
import br.com.zup.bootcamp.proposta.model.dto.ProposalRequestPJDto;
import br.com.zup.bootcamp.proposta.model.dto.ProposalResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface ProposalService {
    ResponseEntity<?> propostal(ProposalRequestDto request, UriComponentsBuilder builder);
    ResponseEntity<?>  propostal(ProposalRequestPJDto request, UriComponentsBuilder builder);
    ProposalResponseDto findById(Long id);
}
