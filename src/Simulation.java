import java.util.ArrayList;

public class Simulation {
   
	final double GAMMA = 1; // we assume that each Spike has the same fixed amount of charge = GAMMA; 
	final long DELTA_T = 1; // one millisecond 
	double provided_Gamma;
	final int MAX_CAPACITY = 20; // treshHold
	Bucket neuron;

	/**
	 * run simulation 
	 * 
	 */
	public void  simulate(){


			simulator_initialization(4);
		 //simulator_random_initialization();;
		Coincidence_Detector detector = new Coincidence_Detector();



		System.out.println("Simulator of a leaky integrate and fire neuron");
		System.out.println(neuron);

		// each iteration represent an Event in which spikes are input into the neuron 
		// we simulate Events until the neuron treshhold is reached.
		int iteration = 1;
		while (!neuron.treshholdReached()) {
			System.out.println("Iteration "+ (iteration++));
			
			provided_Gamma = 0;

			// we get a spike from D_1
			if (detector.isE_1_Occured() && !neuron.getPipe("D_1").getSpikeSet().empty()) {
             provided_Gamma+= neuron.getPipe("D_1").getSpikeSet().pop();
             System.out.println("Spike num "+(5-neuron.getPipe("D_1").getSpikeSet().size())+" generated from D_1");
			}
			// we get a spike from D_2
			if (detector.isE_2_Occured() && !neuron.getPipe("D_2").getSpikeSet().empty()) {
	             provided_Gamma+= neuron.getPipe("D_2").getSpikeSet().pop();
	             System.out.println("Spike num "+(3-neuron.getPipe("D_2").getSpikeSet().size())+" generated from D_2");

				}
			
			for (Pipe pipe : neuron.choosePipeRandomaly()) {
				System.out.println("Pipe Number: "+pipe.getCounter());
				provided_Gamma += pipe.getWeight()*pipe.getNum_of_spikes()*GAMMA*DELTA_T;
				detector.checkforCoincidenceB(provided_Gamma, pipe);
			//	detector.checkforCoincidenceC(provided_Gamma, pipe);
			}
			if(detector.isCoincidenceB_detected())
				System.out.println("Coincidence B detected !");


			neuron.updateCurrentCapacity((provided_Gamma)-(neuron.getLeak()*DELTA_T));
			System.out.println("current Capacity= "+neuron.getCurrentCapacity()+" provided Gamma= "+provided_Gamma+"\n");		
		}
		System.out.println("\nCurrent Capacity bigger than Treshhold's neuron: spike output ="+neuron.outputSpike());
	}

	/**
	 * initialization of the neuron with random values for simulation
	 */
	public void simulator_random_initialization(){
		double currentCapacity=0.0;	
		provided_Gamma=0;
		ArrayList<Pipe> pipes =  new ArrayList<>();
		int numOfpipe = Rand.randInt(2,5);
		final double LEAK = GAMMA/50 ;
	
		for (int i = 0; i < numOfpipe; i++) {
			double weight = Rand.randDouble(0, 1);
			int num_of_Spikes = Rand.randInt(1, 5);
			Pipe pipe = new Pipe(weight, num_of_Spikes,i);
			
			pipes.add(pipe);
		}
		neuron = new Bucket(LEAK, MAX_CAPACITY,currentCapacity,GAMMA, pipes);

	}

	/**
	 * initialization of the neuron with random values for simulation
	 */
	public void simulator_initialization(int numofPipe){
		double currentCapacity=0.0;	
		provided_Gamma=0;
		ArrayList<Pipe> pipes =  new ArrayList<>();
		int numOfpipe = numofPipe;
		final double LEAK = GAMMA/10 ;
		int num = 0;
		for (int i = 0; i < numOfpipe-2; i++) {
			double weight = 1;
			int num_of_Spikes = Rand.randInt(1, 5);
			Pipe pipe = new Pipe(weight, num_of_Spikes,i);
			num=i;
			pipes.add(pipe);
		}
		// setting the two dendrites corresponding of 1.c
		int nextrain1[]={1,1,1,1}; // 5 - 1 that already be generated
		int nextrain2[]={1,1}; // 3 - 1 that already be generated
		Pipe D_1 = new Pipe(1, 1,num+1);
		D_1.setName("D_1");
		D_1.setSpikeSet(nextrain1);
		Pipe D_2 = new Pipe(1, 1,num+2);
		D_2.setName("D_2");
		D_2.setSpikeSet(nextrain2);

		pipes.add(D_1);
		pipes.add(D_2);

		neuron = new Bucket(LEAK, MAX_CAPACITY,currentCapacity,GAMMA, pipes);
	}

}
