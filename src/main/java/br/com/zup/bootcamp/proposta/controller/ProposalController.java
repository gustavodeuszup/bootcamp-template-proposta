package br.com.zup.bootcamp.proposta.controller;

import br.com.zup.bootcamp.proposta.model.dto.ProposalRequestDto;
import br.com.zup.bootcamp.proposta.model.dto.ProposalRequestPJDto;
import br.com.zup.bootcamp.proposta.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping(value = "/proposal")
    public ResponseEntity<?> proposal(@RequestBody @Valid ProposalRequestDto request, UriComponentsBuilder builder){
    return proposalService.propostal(request, builder);

    }

    @PostMapping(value = "/proposal-pj")
    public ResponseEntity<?> proposalPJ(
            @RequestBody @Valid ProposalRequestPJDto request, UriComponentsBuilder builder) {
            return proposalService.propostal(request, builder);
    }

    @GetMapping(value = "/proposal/{id}")
    public ResponseEntity<?> proposalPJ(@PathVariable Long id) {
        return ResponseEntity.ok().body(proposalService.findById(id));
    }

}
