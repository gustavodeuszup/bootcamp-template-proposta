package br.com.zup.bootcamp.proposta.model.dto.finantialanalysis;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialAnalysisRequestDto {
    @JsonProperty("documento")
    private String document;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("idProposta")
    private Long proposalId;

    public FinancialAnalysisRequestDto(String document, String name, Long proposalId) {
        this.document = document;
        this.name = name;
        this.proposalId = proposalId;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }
}
