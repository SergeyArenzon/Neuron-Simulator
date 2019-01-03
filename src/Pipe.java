
public class Pipe {
	public double weight;
	 public int num_of_spikes;
	 public String name;
	
	
	
	 public Pipe(){
			
	}
	 public Pipe(double weight, int num_of_Spikes) {
		this.weight= weight;
		this.num_of_spikes= num_of_Spikes;	
	}
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public int getNum_of_spikes() {
		return num_of_spikes;
	}


	public void setNum_of_spikes(int num_of_spikes) {
		this.num_of_spikes = num_of_spikes;
	}
	
	@Override
	public String toString() {
		return "Pipe [weight=" + weight + ", num_of_spikes=" + num_of_spikes + "]";
	}

}
