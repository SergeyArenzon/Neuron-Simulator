import java.util.ArrayList;

public class Simulation {

	final double GAMMA = 1; // we assume that each Spike has the same fixed amount of charge = GAMMA; 
	final long DELTA_T = 1; // one millisecond 
	double provided_Gamma;
	Bucket neuron;

	/**
	 * run simulation 
	 * 
	 */
	public void  simulate() {
		
		simulator_initialization();
		
		Thread t = new Thread();
		t.run();
		
		while (!neuron.isFull()) {
			provided_Gamma = 0;
			for (Pipe pipe : neuron.getPipes()) {
				provided_Gamma += pipe.getWeight()*pipe.getNum_of_spikes()*GAMMA;
			}
			neuron.updateCurrentCapacity((provided_Gamma)-neuron.getLeak());
			System.out.println("current Capacity= "+neuron.getCurrentCapacity()+" provided Gamma= "+provided_Gamma);

			try {
				
				t.sleep(DELTA_T);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		t.interrupt();

		System.out.println("\nCurrent Capacity bigger than Treshhold's neuron: spike output ="+neuron.outputSpike());
	}
	
	/**
	 * initialization of the neuron for simulation
	 */
	public void simulator_initialization(){
		 double currentCapacity=0.0;	
		 provided_Gamma=0;
		ArrayList<Pipe> pipes =  new ArrayList<>();
		final int MAX_CAPACITY = 500; // treshHold
		int numOfpipe = Rand.randInt(2,5);
		final double LEAK = GAMMA/10 ;

		for (int i = 0; i < numOfpipe; i++) {
			double weight = Rand.randDouble(0, 1);
			int num_of_Spikes = Rand.randInt(1, 5);
			Pipe pipe = new Pipe(weight, num_of_Spikes);
			pipes.add(pipe);
		}
		neuron = new Bucket(LEAK, MAX_CAPACITY,currentCapacity,GAMMA, pipes);
		
		System.out.println("Simulator of a leaky integrate and fire neuron");
		System.out.println(neuron);
	}

}
