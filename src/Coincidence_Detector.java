
public class Coincidence_Detector {
	
public boolean coincidenceB_detected = false ;
public int counter ;
public Pipe D_1, D_2;
private boolean E_1_Occured,E_2_Occured;

// constructor
public  Coincidence_Detector() {

	this.coincidenceB_detected = false ;
	this.E_1_Occured = false ;
	this.E_2_Occured = false ;
	this.counter= 0;
}

// getter and setter
public boolean isCoincidenceB_detected() {
	return coincidenceB_detected;
}

public boolean isE_1_Occured() {
	return E_1_Occured;
}

public void setE_1_Occured(boolean e_1_Occured) {
	E_1_Occured = e_1_Occured;
}

public boolean isE_2_Occured() {
	return E_2_Occured;
}

public void setE_2_Occured(boolean e_2_Occured) {
	E_2_Occured = e_2_Occured;
}

/**
 * check for coincidence according to the part 1.B
 * Assume E1 causes a spike to be generated for dendrites (pipe) D1 ,
 *  E2 causes a spike to be generated for (pipe) dendrites D2.
 * @param provided_gamma
 * @param currentPipe
 */
public void checkforCoincidenceB(double provided_gamma,Pipe currentPipe) {
	if(provided_gamma==1 && D_1 == null) {
		this.D_1 = currentPipe;
	}
	else if(provided_gamma==1 && D_1 != null) {
		this.D_2 = currentPipe;
	}
	if( D_1 != null && D_2 != null )
		coincidenceB_detected = true;
}


/**
 * check for coincidence according to the part 1.C
 * Assume E1 causes a set of 5 spikes to be generated over consecutive discrete time steps,
 *  E2 causes a set of 3 spikes to be generated for over consecutive discrete time steps.
 *  
 *  we notice that when E_1 or E_2 occurred, specific number of spikes is generated. 
 *  thereby we need to assure that the next spikes will be received by the neuron.
 *  So, we have two solutions:
 *  - Adapt the neuron treshhold
 *  - input the next spikes in the reseted neuron.
 * @param provided_gamma
 * @param currentPipe
 */
public void checkforCoincidenceC(double provided_gamma,Pipe currentPipe) {
	if(provided_gamma==1 && currentPipe.getName().equals("D_1")){
		E_1_Occured = true ;
		System.out.println("E_1 from 1.c occured ! spike num 1 generated from D_1");
	}
		
	if(provided_gamma==1 && currentPipe.getName().equals("D_2")){
		E_2_Occured = true ;
		System.out.println("E_2 from 1.c occured !");
	}
}

}
