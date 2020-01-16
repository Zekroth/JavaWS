package Components;

public class Generatore extends EComponent{
	
	/**
	 * 	FIELDS
	 */
	
	public boolean Dc_Ac;
	public Double Voltage;
	public Double Current;
	public Double Frequency;
	public boolean State = false;
	
	/**
	 * 	METHODS
	 */
	
	public void Switch() {
		
		State = !State;
	
	}
	
	@Override
	public void Update(Double TimePassedSinceLastUpdate) {
		
		if(this.State) {
			this.AppliedCurrent = Current;
			this.AppliedVoltage = Voltage;
			this.Frequency = super.Frequency;
		}else {
			this.AppliedCurrent = 0.0d;
			this.AppliedVoltage = 0.0d;
			this.Frequency = 0.0d;
		}
		
		
	}
	
	
}
