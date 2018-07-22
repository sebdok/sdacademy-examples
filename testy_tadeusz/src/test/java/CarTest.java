import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
	Car car;

	@BeforeEach
	void beforeEach() {
		car = new Car(FuelType.PETROL);
	}

	@DisplayName("Powinno zwrócić obiekt klasy jeśli przy tworzeniu nie wystąpiły problemy")
	@Test
	void test_0() {
		assertThat(car).isExactlyInstanceOf(Car.class);
	}

	@DisplayName("Powinno zwrócić false jeśli wartość jest mniejsza od 0")
	@Test
	void test_1() {
		assertThat(car.getTankLevel()).isZero();
	}

	@DisplayName("Powinno zwrócić wartość tankowania, jeśli tankowanie przebiegło pomyślnie")
	@ParameterizedTest
	@ValueSource(ints = {Car.TANK_EMPTY, 1, 50, Car.TANK_FULL})
	void test_2(int value) {
		car.setTankLevel(value);
		assertThat(car.getTankLevel()).isEqualTo(value);
	}

	@DisplayName("Powinno rzucić wyjątkiem IllegalArgumentException kiedy wartość jest mniejsza od 0")
	@Test
	void test_3() {
		assertThatIllegalArgumentException().isThrownBy(() -> car.setTankLevel(-1));
	}

	@DisplayName("Powinno rzucić wyjątkiem IllegalArgumentException kiedy wartość jest większe od 100")
	@Test
	void test_4() {
		assertThatIllegalArgumentException().isThrownBy(() -> car.setTankLevel(101));
	}

	@DisplayName("Powinno rzucić wyjątkiem IllegalArgumentException kiedy nie okreslimy typu paliwa")
	@Test
	void test_5() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Car(null));
	}

	@DisplayName("sprwadz czy samochód jest brudny")
	@Test
	void test_6(){
		car.setDirtyLevel(56);
		assertThat(car.isDirty()).isTrue();
	}

	@DisplayName("zwraca false jesli samochod ma zabrudzenie mniejsze lub rowne 50%")
	@Test
	void test_7(){
		car.setDirtyLevel(50);
		assertThat(car.isDirty()).isFalse();
	}

	@DisplayName("zwraca true jesli samochod ma zabrudzenie wieksze niz 50%")
	@Test
	void test_8(){
		car.setDirtyLevel(51);
		assertThat(car.isDirty()).isTrue();
	}

	@DisplayName("po umyciu samochodu dirtylevel wynosi 0%")
	@Test
	void test_9(){
		CarWash carWash = new CarWash();
		car.setDirtyLevel(20);
		carWash.wash(car);
		assertThat(car.getDirtyLevel()).isZero();
	}


}