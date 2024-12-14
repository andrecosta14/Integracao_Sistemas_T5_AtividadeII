package credibank.credibank.controllers;

import credibank.credibank.services.CrediBankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


// Marks this class as a REST Controller, making it capable of handling HTTP requests in a Spring Boot application.
@RestController
public class CreditBankController {

  private CrediBankService crediBankService;

  // Constructor for dependency injection of the CrediBankService.
  public CreditBankController(CrediBankService crediBankService) {
    this.crediBankService = crediBankService;
  }

  /**
     * Endpoint to get a digital check based on a credit account ID and value.
     * - Path: /digital-check/{creditAccountId}/{value}
     * - Accepts a 16-digit credit account ID and a monetary value greater than zero.
     * - Returns a result string from the CrediBankService or a validation error message.
     *
     * @param creditAccountId - The 16-digit ID of the credit account.
     * @param value - The monetary value to process.
     * @return A message indicating success or the nature of a validation error.
     */
  @GetMapping("/digital-check/{creditAccountId}/{value}")
  public String getDigitalCheck(
    @PathVariable String creditAccountId,
    @PathVariable double value) {

    // Validate the credit account ID format to ensure it is exactly 16 digits.
    if (!creditAccountId.matches("\\d{16}")) {
      return "Invalid credit account ID. Must be 16 digits.";
    }

    // Ensure the value provided is positive and non-zero.
    if (value <= 0) {
      return "Value must be greater than zero.";
    }

    // If validations pass, delegate the request to the service layer.
    return crediBankService.getDigitalCheck(creditAccountId, value);
  }
}
