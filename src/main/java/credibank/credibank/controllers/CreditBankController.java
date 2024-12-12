package credibank.credibank.controllers;

import credibank.credibank.services.CrediBankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


// REST Controller
@RestController
public class CreditBankController {

  private CrediBankService crediBankService;

  public CreditBankController(CrediBankService crediBankService) {
    this.crediBankService = crediBankService;
  }

  @GetMapping("/digital-check/{creditAccountId}/{value}")
  public String getDigitalCheck(
    @PathVariable String creditAccountId,
    @PathVariable double value) {

    if (!creditAccountId.matches("\\d{16}")) {
      return "Invalid credit account ID. Must be 16 digits.";
    }

    if (value <= 0) {
      return "Value must be greater than zero.";
    }

    return crediBankService.getDigitalCheck(creditAccountId, value);
  }
}
