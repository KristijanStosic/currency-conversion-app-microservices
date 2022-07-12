package cryptoWallet;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class CryptoWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoWalletApplication.class, args);
	}

}
