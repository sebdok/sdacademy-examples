import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class GasStationTest {
	Car car;
	GasStation gasStation;

	@BeforeEach
	void beforeEach() {
		car = new Car(FuelType.PETROL);
		gasStation = new GasStation();
	}

	@DisplayName("Powinno rzucić wyjątkiem NullPointerException kiedy parametr samochodu jest nullem")
	@Test
	void test_1() {
		assertThatNullPointerException().isThrownBy(() -> gasStation.tankToFullLevel(null));
	}

	@DisplayName("Zatankuj do pełna przy jakiejś aktualnej wartości baku")
	@ParameterizedTest
	@ValueSource(ints = {Car.TANK_EMPTY, 23, 56, 37, Car.TANK_FULL})
	void test_2(int value) {
		car.setTankLevel(value);
		gasStation.tankToFullLevel(car);
		assertThat(car.getTankLevel()).isEqualTo(Car.TANK_FULL);
	}

	@DisplayName("Powinno zwrócić ilość zatankowanego paliwa")
	@ParameterizedTest
	@ValueSource(ints = {Car.TANK_EMPTY, 23, 56, 37, Car.TANK_FULL})
	void test_3(int value) {
		car.setTankLevel(value);
		assertThat(gasStation.tankToFullLevel(car)).isEqualTo(Car.TANK_FULL - value);
	}

	@DisplayName("Powinno zwrócić cene za zatankowane paliwo")
	@ParameterizedTest
	@ValueSource(ints = {Car.TANK_EMPTY, 25, 50, 75, Car.TANK_FULL})
	void test_4(int tankLevel) {
		BigDecimal price = car.getFuelType().getPrice();
		assertThat(gasStation.getAFee(car.getFuelType(),Car.TANK_FULL - tankLevel)).isEqualTo(new BigDecimal
			(Car.TANK_FULL -
			tankLevel)
			.multiply(price));
	}

	@DisplayName("Powinno rzucić wyjątkiem IllegalArgumentException w przypadku kiedy parametr jest mniejszy od 0")
	@Test
	void test_5() {
		assertThatIllegalArgumentException().isThrownBy(() -> gasStation.getAFee(FuelType.PETROL, -1));
	}

	@DisplayName("Powinno rzucic wyjątek gdy parametr samochodu jest nullem")
	@Test
	void test_6() {
		assertThatNullPointerException().isThrownBy(() -> gasStation.tankFuel(null, 1));
	}
	@DisplayName("Powinno rzucic wyjątek gdy parametr paliwa jest mniejszy od 0")
	@Test
	void test_7() {
		assertThatIllegalArgumentException().isThrownBy(() -> gasStation.tankFuel(car, -1));
	}
	@DisplayName("Powinno rzucic wyjątek gdy parametr paliwa jest mniejszy od 0")
	@ParameterizedTest
	@ValueSource(ints = {1, 10, 20})
	void test_8(int fuelToTank) {
		car.setTankLevel(80);
		int oldFuel = car.getTankLevel();
		FuelType fuelType = car.getFuelType();
		assertThat(gasStation.tankFuel(car, fuelToTank)).isEqualTo(gasStation.getAFee(fuelType,
			fuelToTank));
		assertThat(car.getTankLevel()).isEqualTo(oldFuel + fuelToTank);
	}




}