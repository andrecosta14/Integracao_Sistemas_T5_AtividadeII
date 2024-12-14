package credibank.credibank.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

// Service Class
@Service
public class CrediBankService {

  private WebClient webClient;


  public CrediBankService() {
    this.webClient = WebClient.builder().baseUrl("https://credibank.intsis.utad.pt:8080").build();
  }

  public String getDigitalCheck(String creditAccountId, double value) {
    String endpoint = String.format("/check/%s/ammount/%.2f/", creditAccountId, value);

    return webClient
      .get()
      .uri(endpoint)
      .retrieve()
      .bodyToMono(String.class)
      .block();
  }
}
