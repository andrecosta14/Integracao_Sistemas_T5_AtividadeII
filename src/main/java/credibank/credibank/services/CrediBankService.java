package credibank.credibank.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

// Service Class to handle communication with CrediBank's external API
@Service
public class CrediBankService {

  // WebClient instance for making HTTP requests
  private WebClient webClient;

  // Constructor to initialize the WebClient with a base URL
  public CrediBankService() {
    this.webClient = WebClient.builder().baseUrl("https://credibank.intsis.utad.pt:8080").build();
  }

  /**
   * Retrieves a digital check by making a GET request to the CrediBank API.
   * @param creditAccountId the unique identifier of the credit account.
   * @param value the value associated with the digital check.
   * @return the response from the API as a String.
   */
  public String getDigitalCheck(String creditAccountId, double value) {

    // Format the endpoint dynamically with the account ID and value
    String endpoint = String.format("/check/%s/ammount/%.2f/", creditAccountId, value);

    // Perform a GET request to the endpoint and retrieve the response body as a String
    return webClient
      .get()
      .uri(endpoint)
      .retrieve()
      .bodyToMono(String.class) // Converts the response to a reactive Mono of String
      .block(); // Blocks to return the value synchronously
  }
}
