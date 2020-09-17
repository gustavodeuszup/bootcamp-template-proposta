package br.com.zup.bootcamp.proposta.model.dto.finantialanalysis;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialAnalysisResponseDto {
    @JsonProperty("documento")
    private String document;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("idProposta")
    private String proposalId;
    @JsonProperty("resultadoSolicitacao")
    private String status;

    public FinancialAnalysisResponseDto(){}

    public FinancialAnalysisResponseDto(String document, String name, String proposalId, String status) {
        this.document = document;
        this.name = name;
        this.proposalId = proposalId;
        this.status = status;
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

    public String getProposalId() {
        return proposalId;
    }

    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
