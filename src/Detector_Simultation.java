


import java.util.ArrayList;

public class Detector_Simultation {

	final double GAMMA = 1; // we assume that each Spike has the same fixed amount of charge = GAMMA; 
	final long DELTA_T = 1; // one millisecond 
	double provided_Gamma;
	final int MAX_CAPACITY = 20; // treshHold
	Bucket neuron;
	boolean detectorB ;
	int weight = 1;



	public Detector_Simultation(boolean detectorB){
		this.detectorB = detectorB;
	}
	/**
	 * run simulation 
	 * 
	 */
	public void  simulate(){



		simulator_initialization(6);
		Coincidence_Detector detector = new Coincidence_Detector();



		System.out.println("Simulator of a leaky integrate and fire neuron");
		System.out.println(neuron);

		// each iteration represent an update.Time of the update = DELTA_T 
		// we stimulate the neuron randomly.the simulation run until threshold is reached.
		int iteration = 1;
		while (!neuron.treshholdReached()) {
			System.out.println("Iteration "+ (iteration++));

			provided_Gamma = 0;
			if(!detectorB){
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
				
			}
			if(Rand.getRandomBoolean()){ // simulate random stimulation
				for (Pipe pipe : neuron.choosePipeRandomaly()) {
					double newCharge = weight*pipe.getNum_of_spikes()*GAMMA*DELTA_T;
					System.out.println(pipe);
					if(detectorB) detector.checkforCoincidenceB(newCharge, pipe);
					if(!detectorB) detector.checkforCoincidenceC(newCharge, pipe);
					provided_Gamma += newCharge;
				}
			}
			if(detectorB && detector.isCoincidenceB_detected()){
				System.out.println("Coincidence B detected !");
				detector.initalize();
			}
			
			if(!detectorB && detector.isCoincidenceC_detected() ){
				System.out.println("Coincidence C detected !");
				detector.initalize();
			}


			neuron.updateCurrentCapacity((provided_Gamma)-(neuron.getLeak()*DELTA_T));
			System.out.println("current Capacity= "+neuron.getCurrentCapacity()+" provided Gamma= "+provided_Gamma+"\n");		
		}
		System.out.println("\nCurrent Capacity bigger than Treshhold's neuron: spike output ="+neuron.outputSpike());
	}


	/**
	 * initialization of the neuron with specific values for simulation
	 * In order to get our Coincidence detector working, we need to set the weight of the 
	 * spikes to 1. Indeed, if we set it randomly we will probably never get exactly two input
	 * of one spike and then coincidence will never exist.
	 */
	public void simulator_initialization(int numofPipe){
		double currentCapacity=0.0;	
		provided_Gamma=0;
		ArrayList<Pipe> pipes =  new ArrayList<>();
		int numOfpipe = numofPipe;
		final double LEAK = GAMMA/50 ;
		
		for (int i = 0; i < numOfpipe-2; i++) {
			int num_of_Spikes = Rand.randInt(1, 5);
			Pipe pipe = new Pipe(num_of_Spikes);
			pipe.setName(Integer.toString(i+1));
			pipe.setWeight(weight);
			pipes.add(pipe);
		 }
		// setting the two dendrites corresponding of 1.c
		int nextrain1[]={1,1,1,1}; // 5 - 1 that already be generated
		int nextrain2[]={1,1}; // 3 - 1 that already be generated
		Pipe D_1 = new Pipe(1); 
		D_1.setName("D_1");
		D_1.setWeight(weight);
		D_1.setSpikeSet(nextrain1);
		Pipe D_2 = new Pipe(1);
		D_2.setName("D_2");
		D_2.setWeight(weight);
		D_2.setSpikeSet(nextrain2);

		pipes.add(D_1);
		pipes.add(D_2);

		neuron = new Bucket(LEAK, MAX_CAPACITY,currentCapacity,GAMMA, pipes);
	}
}
