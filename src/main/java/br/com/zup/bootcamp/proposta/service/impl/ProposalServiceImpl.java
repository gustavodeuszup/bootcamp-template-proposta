package br.com.zup.bootcamp.proposta.service.impl;

import br.com.zup.bootcamp.proposta.client.FinancialAnalysisClient;
import br.com.zup.bootcamp.proposta.model.ProposalRequest;
import br.com.zup.bootcamp.proposta.model.dto.ProposalRequestDto;
import br.com.zup.bootcamp.proposta.model.dto.ProposalRequestPJDto;
import br.com.zup.bootcamp.proposta.model.dto.ProposalResponseDto;
import br.com.zup.bootcamp.proposta.model.dto.finantialanalysis.FinancialAnalysisRequestDto;
import br.com.zup.bootcamp.proposta.model.dto.finantialanalysis.FinancialAnalysisResponseDto;
import br.com.zup.bootcamp.proposta.repository.ProposalRepository;
import br.com.zup.bootcamp.proposta.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ProposalServiceImpl implements ProposalService {
    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private FinancialAnalysisClient analysisClient;

    @Override
    public ResponseEntity<?> propostal(ProposalRequestDto request, UriComponentsBuilder builder) {

        List<ProposalRequest> byCpf = proposalRepository.findByDocument(request.getDocument());
        if(byCpf != null)
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        ProposalRequest proposalCreated = proposalRepository.save(this.convertDtoToEntity(request));

        try{
            FinancialAnalysisRequestDto financialAnalysisRequestDto = new FinancialAnalysisRequestDto(request.getDocument(), request.getName(), request.getId());
            ResponseEntity<FinancialAnalysisResponseDto> financialAnalysisResponseDtoResponseEntity = analysisClient.financialAnalysis(financialAnalysisRequestDto);

            URI build = builder.path("/propostas/{id}").build(proposalCreated.getId());

            return ResponseEntity.created(build).build();
        }catch (HttpStatusCodeException e){
            return ResponseEntity.status(e.getStatusCode()).body("Erro ao chamar serviço");
        }
    }

    @Override
    public ResponseEntity<?> propostal(ProposalRequestPJDto request, UriComponentsBuilder builder) {

        List<ProposalRequest> byCpf = proposalRepository.findByDocument(request.getDocument());
        if(byCpf != null)
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        ProposalRequest save = proposalRepository.save(this.convertDtoToEntityPJ(request));

        try{
            URI build = builder.path("/propostas/{id}").build(save.getId());
            return ResponseEntity.created(build).build();
        }
        catch (MethodNotAllowedException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public ProposalResponseDto findById(Long id) {
        ProposalResponseDto response = new ProposalResponseDto();
        if(id == null){
            throw new IllegalArgumentException("o id para busca não pode ser nulo");
        }
        Optional<ProposalRequest> byId = proposalRepository.findById(id);

        if (byId.isPresent()) {
            response = this.convertEntityToDto(byId.get());
            
        }
        return response;
    }

    private ProposalRequest convertDtoToEntity(ProposalRequestDto request){

        ProposalRequest proposalRequest = new ProposalRequest();
            proposalRequest.setDocument(request.getDocument());
            proposalRequest.setAddress(request.getAddress());
            proposalRequest.setDocument(request.getDocument());
            proposalRequest.setEmail(request.getEmail());
            proposalRequest.setName(request.getName());
            proposalRequest.setSalary(request.getSalary());

        return proposalRequest;
    }

    private ProposalRequest convertDtoToEntityPJ(ProposalRequestPJDto request){

        ProposalRequest proposalRequest = new ProposalRequest();
        proposalRequest.setDocument(request.getDocument());
        proposalRequest.setAddress(request.getAddress());
        proposalRequest.setDocument(request.getDocument());
        proposalRequest.setEmail(request.getEmail());
        proposalRequest.setName(request.getName());
        proposalRequest.setSalary(request.getSalary());

        return proposalRequest;
    }

    private ProposalResponseDto convertEntityToDto(ProposalRequest request){

        ProposalResponseDto response = new ProposalResponseDto();
            response.setDocument(request.getDocument());
            response.setAddress(request.getAddress());
            response.setDocument(request.getDocument());
            response.setEmail(request.getEmail());
            response.setName(request.getName());
            response.setSalary(request.getSalary());

        return response;
    }
}
