
public class Coincidence_Detector {
	
public boolean coincidenceB_detected = false, coincidenceC_detected = false ;;
public int counter ;
public Pipe D_1, D_2;

// constructor
public  Coincidence_Detector() {

	this.coincidenceB_detected = false ;
	this.coincidenceC_detected = false ;
	this.counter= 0;
//	D_1 = new Pipe();
//	D_2 = new Pipe();

}

public boolean isCoincidenceB_detected() {
	return coincidenceB_detected;
}

public boolean isCoincidenceC_detected() {
	return coincidenceC_detected;
}

/**
 * check for coincidence according to the part 1.B
 * @param provided_gamma
 * @param currentPipe
 */
public void checkforCoincidenceB(double provided_gamma,Pipe currentPipe) {
	if(provided_gamma==1 && D_1 == null) {
		this.D_1 = currentPipe;
		counter++;
		//this.D_1.setName("D_1");
	}
	else if(provided_gamma==1 && D_1 != null) {
		this.D_2 = currentPipe;
		counter++;
	   // this.D_2.setName("D_2");
	}
	
	if( D_1 != null && D_2 != null )
		coincidenceB_detected = true;
}


/**
 * check for coincidence according to the part 1.C
 * @param provided_gamma
 * @param currentPipe
 */
public void checkforCoincidenceC(double provided_gamma) {
	if(provided_gamma==1)
		counter++;
	if(counter==2)
		coincidenceC_detected = true;
}





}
