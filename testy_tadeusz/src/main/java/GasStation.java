import com.google.common.base.Preconditions;

import java.math.BigDecimal;

public class GasStation {

	public int tankToFullLevel(Car car) {
		int petrolToFill = Car.TANK_FULL - car.getTankLevel();
		car.setTankLevel(Car.TANK_FULL);

		return petrolToFill;
	}

	BigDecimal getAFee(FuelType fuelType, int amount ) {
		Preconditions.checkNotNull(fuelType, "Fuel type musi zostać określony");
		Preconditions.checkArgument(amount >= 0, "Fuel type musi zostać określony");
		return fuelType.getPrice().multiply(new BigDecimal(amount));
	}

	BigDecimal tankFuel(Car car, int amount){
		Preconditions.checkNotNull(car, "car nie moze by nulem");
		Preconditions.checkArgument(amount >= 0, "Fuel type musi zostać określony");
		car.setTankLevel(car.getTankLevel() + amount);
		return getAFee(car.getFuelType(),amount);


	}
}
