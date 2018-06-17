package pl.sdacademy.hr;

class Employee {
	private static String dateOfBirth ;
	private final String firstName;
	private final String lastName;

	public Employee(String firstName, String lastName, String dateOfBirth ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirsName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + dateOfBirth;
	}
}
