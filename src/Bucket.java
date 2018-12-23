import java.util.Random;


///////////////////Neuron Simulator////////////////
class Bucket {
	Random random = new Random();
	double leak = random.nextDouble();
	int capacity = random.nextInt(1000);
	Pipe p;
	public void  simulate()   
	{
		
		double treshHold=0;	
		double spikeXgamma=0;
		Thread t = new Thread();
		t.run();
		
		while (treshHold<=capacity) {
			Pipe p=new Pipe();
			this.p=p;
			spikeXgamma=spikeXgamma+p.gamma*p.spike;		
			treshHold =(spikeXgamma)-leak;
			System.out.println("Capacity= "+capacity+" Treshhold= "+treshHold+" Spike= "+p.spike+" Gamma= "+p.gamma);

			try {
				t.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
		t.interrupt();
		
				System.out.println("Last spike: "+p.spike);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Bucket b = new Bucket();
		b.simulate();
		
		
	}
	}













	