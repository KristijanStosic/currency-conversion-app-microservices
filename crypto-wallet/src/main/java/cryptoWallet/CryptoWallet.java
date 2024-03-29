package cryptoWallet;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CryptoWallet {
	
	@Id
	@Column(nullable=false)
	private long id;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(name = "btc_amount")
	private BigDecimal btc_amount;
	
	@Column(name = "eth_amount")
	private BigDecimal eth_amount;
	
	@Column(name = "xrp_amount")
	private BigDecimal xrp_amount;
	
	
	public CryptoWallet() {
		
	}
	
	public CryptoWallet(long id, String email, BigDecimal btc_amount, BigDecimal eth_amount, BigDecimal xrp_amount) {
		super();
		this.id = id;
		this.email = email;
		this.btc_amount = btc_amount;
		this.eth_amount = eth_amount;
		this.xrp_amount = xrp_amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getBtc_amount() {
		return btc_amount;
	}

	public void setBtc_amount(BigDecimal btc_amount) {
		this.btc_amount = btc_amount;
	}

	public BigDecimal getEth_amount() {
		return eth_amount;
	}

	public void setEth_amount(BigDecimal eth_amount) {
		this.eth_amount = eth_amount;
	}

	public BigDecimal getXrp_amount() {
		return xrp_amount;
	}

	public void setXrp_amount(BigDecimal xrp_amount) {
		this.xrp_amount = xrp_amount;
	}
}
