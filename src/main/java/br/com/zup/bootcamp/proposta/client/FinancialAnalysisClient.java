package br.com.zup.bootcamp.proposta.client;

import br.com.zup.bootcamp.proposta.model.dto.finantialanalysis.FinancialAnalysisRequestDto;
import br.com.zup.bootcamp.proposta.model.dto.finantialanalysis.FinancialAnalysisResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FinancialAnalysisClient {

    @Autowired
    private final RestTemplate restTemplate;

    private final String url;

    public FinancialAnalysisClient(RestTemplate restTemplate, @Value("${host.financialanalysis}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public ResponseEntity<FinancialAnalysisResponseDto>  financialAnalysis(FinancialAnalysisRequestDto request){

        HttpEntity<FinancialAnalysisRequestDto> requestRest = new HttpEntity<>(request);

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestRest,
                FinancialAnalysisResponseDto.class
        );
    }

}
