
public abstract class EComponent {
	
	/** 
	 * 		CONSTANTS
	 * */
	
	public final static Double TEMPERATURA_AMBIENTE = 20.0;
	
	/** 
	 * 		FIELDS
	 * */
	
	public String ComponentID = null;
	
	public Double AppliedCurrent = Double.MIN_VALUE;
	public Double AppliedVoltage = Double.MIN_VALUE;
	public Double Frequency = Double.MIN_VALUE;
	public Double Resistance = Double.MIN_VALUE;
	public Double impedence() {
		return 1/Resistance;
	}
	public Double Capacity = Double.MIN_VALUE;
	public Double Conductance = Double.MIN_VALUE;
	/* for later implementation
	public Double Heat = TEMPERATURA_AMBIENTE;
	public Double DissipationRate = Double.MAX_VALUE;
	public Double MaximumHeat;
	public Double MinimumHeat;
	 */
	public Double HeatGenerated = 0.0;

	/** 
	 * 		METHODS
	 * */
	
	public abstract void Update(Double timePassedSinceLastUpdate);
}
