
public class Lampadina extends EComponent{
	
	public Double Lumens = 1055.0;
	public Double WattsNeeded = 75.0;
	
	
	
	
	public boolean State = false;




	@Override
	public void Update(Double timePassedSinceLastUpdate) {
		// TODO Auto-generated method stub
		if(this.AppliedCurrent * this.AppliedVoltage >= WattsNeeded) {
			this.State = true;
		}else{
			this.State = false;
		}
	}
	
	
}
