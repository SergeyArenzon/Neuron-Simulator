import java.util.Stack;

public class Pipe {
	public double weight;
	 public int num_of_spikes;
	 public String name;
	 public Stack <Integer> spikeSet;
	
	
	 public Pipe(){
			
	}
	 public Pipe(double weight, int num_of_Spikes) {
		this.weight= weight;
		this.num_of_spikes= num_of_Spikes;	
		this.name = "";
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
	
	public Stack<Integer> getSpikeSet() {
		return spikeSet;
	}
	public void setSpikeSet(int arr[]) {
		spikeSet = new Stack<>();
		for (int i : arr) {
			spikeSet.add(arr[i]);
		}
	}
	@Override
	public String toString() {
		return "Pipe [weight=" + weight + ", num_of_spikes=" + num_of_spikes + "]";
	}

}
