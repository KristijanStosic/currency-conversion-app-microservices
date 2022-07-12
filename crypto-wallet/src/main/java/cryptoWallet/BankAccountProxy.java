package cryptoWallet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="bank-account")
public interface BankAccountProxy {
	
	@GetMapping("/bank-account/user/{user}")
	BankAccountDto getBankAccountByEmail(@PathVariable("user") String user);
}
