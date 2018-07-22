import java.math.BigDecimal;

public enum FuelType {
	DISEL(new BigDecimal(5.48)),
	PETROL(new BigDecimal(5.35)),
	ELECTRIC(new BigDecimal(1.4));

	private BigDecimal price;

	FuelType(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
