package currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import currencyexchange.errorHandling.BadRequestException;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchange(@PathVariable String from, @PathVariable String to) {
		String port = environment.getProperty("local.server.port");
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new BadRequestException("Currency values not entered correctly");
		}
		return new CurrencyExchange(currencyExchange.getId(), from, to, currencyExchange.getConversionMultiple(), port);
	}
}
