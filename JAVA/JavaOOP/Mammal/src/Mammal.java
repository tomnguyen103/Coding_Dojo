
public class Mammal {
	private int energyLevel = 10;
	
	public Mammal() {
		
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		System.out.println("This mammal has "+ energyLevel +  " energy level.");
		return energyLevel;
	}
	
}
