package pl.sdacademy.hr;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class HrManagerTest {
	private HrManager hrManager = new HrManager();

	@BeforeEach
	void setup(){
		hrManager = new HrManager();
	}

	@DisplayName("should create non-null new employee when is given firs name, last name and date of birth")
	@Test
	void test0() {
		//given
		String firstName = "Adam";
		String lastName = "Kowalski";
		String dateOfBirth = "01-01-1960";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);
		//then
		Assertions.assertThat(employee).isNotNull();
	}

	@DisplayName("should create a new employee with All fields:firs name, last name and date of birth")
	@Test
	void test1() {
		//given
		String firstName = "Adam";
		String lastName = "Kowalski";
		String dateOfBirth = "01-01-1960";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);

		//then
		Assertions.assertThat(employee.getFirsName()).isEqualTo(firstName);
		Assertions.assertThat(employee.getLastName()).isEqualTo(lastName);
		Assertions.assertThat(employee.getDateOfBirth()).isEqualTo(dateOfBirth);
	}

	@DisplayName("Should check if new Employee is add to the database")
	@Test
	void test2() {
		//given
		String firstName = "Adam";
		String lastName = "Kowalski";
		String dateOfBirth = "01-01-1960";
		Employee newEmployee = hrManager.create(firstName, lastName, dateOfBirth);
		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		Assertions.assertThat(allEmployees).containsOnly(newEmployee);



	}
	@DisplayName("Should check if  two new Employee are added to the database")
	@Test
	void test3() {
		//given
		String firstName = "Adam";
		String lastName = "Kowalski";
		String dateOfBirth = "01-01-1960";
		Employee adam = hrManager.create("Adam", "Kowalski", "01-01-1960");
		Employee john = hrManager.create("John", "Smith", "02-01-1962");

		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		Assertions.assertThat(allEmployees).containsOnly(adam,john);



	}
}