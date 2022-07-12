package currencyConversion;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@Autowired
	private BankAccountProxy bankAccountProxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}/user/{user}")
	public BankAccountDto getConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity, @PathVariable String user) {

		CurrencyExchangeDto currencyConversion = currencyExchangeProxy.getExchange(from, to);

		bankAccountProxy.getBankAccountByEmail(user);

		return bankAccountProxy.updateBankAccount(from, to, quantity, user,
				quantity.multiply(currencyConversion.getConversionMultiple()));

	}

}
