package br.com.zup.bootcamp.proposta.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "proposal")
public class ProposalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String address;
    @NotNull
    private String document;
    @NotNull
    private String email;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal salary;

    public ProposalRequest() { }

    public ProposalRequest(@NotNull String address, @NotNull String document, @NotNull String email, @NotNull String name, @NotNull BigDecimal salary) {
        this.address = address;
        this.document = document;
        this.email = email;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
