
public class Cavo extends EComponent{
	
	public EComponent TerminaleA;
	public EComponent TerminaleB;
	
	
	@Override
	public void Update(Double timePassedSinceLastUpdate) {
		
		this.HeatGenerated += this.Resistance * this.AppliedCurrent * this.AppliedCurrent * timePassedSinceLastUpdate ;
		
		this.TerminaleA.AppliedCurrent += this.TerminaleB.AppliedCurrent;
		this.AppliedVoltage = this.TerminaleA.AppliedVoltage + this.TerminaleB.AppliedVoltage;
	}
	
}
