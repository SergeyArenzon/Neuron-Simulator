
public class main {

	public static void main(String[] args) {
		Simulation simulator = new Simulation();
		Detector_Simultation detect_simul_b = new Detector_Simultation(true);
		Detector_Simultation detect_simul_c = new Detector_Simultation(false);

	    //simulator.simulate();
	//	detect_simul_b.simulate();
		detect_simul_c.simulate();

	}

}
