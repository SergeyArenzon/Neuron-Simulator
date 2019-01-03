import java.util.ArrayList;

//  an object representing a bucket (neuron)

public class Bucket {

	double leak, gamma ,currentCapacity;
	int treshHold ;
	ArrayList<Pipe> pipes ;

	// constructor
	public Bucket(double leak, int treshHold,double currentCapacity,double gamma, ArrayList<Pipe> pipes) {
		this.currentCapacity = currentCapacity;
		this.leak = leak;
		this.treshHold = treshHold;
		this.gamma = gamma ;
		this.pipes = new ArrayList<>();
		this.pipes.addAll(pipes);
	}
	
	
	public boolean isFull(){
		return this.treshHold <= this.currentCapacity ;
	}
	/**
	 * update the currentCapacity with the final charges gamma 
	 * amount inserted ( final = total charges - lost charges)
	 * @param newCapacity
	 */
	public void updateCurrentCapacity(double finalGammaInserted){
		this.currentCapacity += finalGammaInserted;
	}
	/**
	 * this function return an output spike (i.e. the charge carried by each spike of the neuron)
	 * the current capacity is set to 0;
	 * @return gamma 
	 */
	public double outputSpike(){
		this.currentCapacity = 0;
		return this.gamma ;
	}
	
	public ArrayList<Pipe> choosePipeRandomaly(){
		ArrayList<Pipe> choosenPipes = new ArrayList<>();
		for (Pipe pipe : this.getPipes()) {
			if(Rand.getRandomBoolean())
				choosenPipes.add(pipe);
		}
		return choosenPipes;
	}
	
	 /////////////// getter and setter ///////////////
	
	public double getLeak() {
		return leak;
	}
	public void setLeak(double leak) {
		this.leak = leak;
	}
	public int gettreshHold() {
		return treshHold;
	}
	public void settreshHold(int treshHold) {
		this.treshHold = treshHold;
	}
	
	public double getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(double currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public double getGamma() {
		return gamma;
	}

	public void setGamma(int gamma) {
		this.gamma = gamma;
	}

	public ArrayList<Pipe> getPipes() {
		return pipes;
	}
	public void setPipes(ArrayList<Pipe> pipes) {
		this.pipes = pipes;
	}
	public int getNumOfPipes(){
		return this.pipes.size();
	}

	@Override
	public String toString() {
		String ans = "";
		ans += "Neuron description:\nleak=" + leak + ", treshHold=" + treshHold +", num of pipes=" + this.getNumOfPipes() + ".\nPipes:\n";
		for (Pipe pipe : pipes) {
			ans += pipe.toString() +"\n";
		}
		return ans;
	}
	
	
	
}
