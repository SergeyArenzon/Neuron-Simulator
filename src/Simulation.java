import java.util.ArrayList;

public class Simulation {

	final double GAMMA = 1; // we assume that each Spike has the same fixed amount of charge = GAMMA; 
	final long DELTA_T = 1; // one millisecond 
	final int MAX_CAPACITY = 10; // treshHold
	Bucket neuron;

	/**
	 * run simulation 
	 * 
	 */
	public void  simulate(){


		simulator_random_initialization();

		System.out.println("Simulator of a leaky integrate and fire neuron");
		System.out.println(neuron);

		// each iteration represent an update.time of the update = DELTA_T 
		// we stimulate the neuron randomly.the simulation run until threshold is reached.
		int iteration = 1;
		while (!neuron.treshholdReached()) {
			System.out.println("Iteration "+ (iteration++));
			
			double provided_Gamma = 0;
			
			if(Rand.getRandomBoolean()){ // simulate random stimulation
			for (Pipe pipe : neuron.choosePipeRandomaly()) {
				provided_Gamma += pipe.getRandomWeight()*pipe.getNum_of_spikes()*GAMMA*DELTA_T;
				System.out.println(pipe);

			}
			}
			neuron.updateCurrentCapacity((provided_Gamma)-(neuron.getLeak()*DELTA_T));
			System.out.println("\ncurrent Capacity= "+neuron.getCurrentCapacity()
			+" provided Gamma= "+provided_Gamma+"\n");		
		}
		System.out.println("\nCurrent Capacity bigger than Treshhold's neuron: spike output ="
		+neuron.outputSpike());
	}
	
	/**
	 * initialization of the neuron with random values for simulation
	 */
	public void simulator_random_initialization(){
		double currentCapacity=0.0;	
		ArrayList<Pipe> pipes =  new ArrayList<>();
		int numOfpipe = Rand.randInt(2,5);
		final double LEAK = GAMMA/50 ;

		for (int i = 0; i < numOfpipe; i++) {
			//double weight = Rand.randDouble(0, 1);
			int max_num_of_Spikes = Rand.randInt(1, 5);
			Pipe pipe = new Pipe(max_num_of_Spikes);
			pipes.add(pipe);
		}
		neuron = new Bucket(LEAK, MAX_CAPACITY,currentCapacity,GAMMA, pipes);

	}

}
