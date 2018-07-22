public class Car {
	public static final int TANK_EMPTY = 0;
	public static final int TANK_FULL = 100;


	private int tankLevel;
	private FuelType fuelType;
	private int dirtyLevel;
	boolean isClear;

	public Car(FuelType fuelType) {
		if(fuelType == null){
			throw new IllegalArgumentException("Nieokreslono rodzaju paliwa");
		}
		this.fuelType = fuelType; }



	public FuelType getFuelType() { return fuelType; }

	public void setTankLevel(int tankLevel) {
		if(tankLevel <0 || tankLevel >TANK_FULL){
			throw new  IllegalArgumentException("Wartosc musi byc z zakresu 0-100");
		}
		this.tankLevel = tankLevel;
	}

	public int getTankLevel() { return tankLevel; }

	public int getDirtyLevel() { return dirtyLevel; }

	public void setDirtyLevel(int dirtyLevel) { this.dirtyLevel = dirtyLevel; }

	boolean isDirty() {
		return dirtyLevel > 50;
	}
}
