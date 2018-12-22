import java.util.Random;

class Bucket {
	Random random = new Random();
	Pipe p;
	double leak = random.nextDouble();
	int capacity = random.nextInt(1000);
	
	public int  simulate()   
	{
		Pipe p=new Pipe();
		double treshHold=0;	
		double spikeXgamma=0;
		Thread t = new Thread();
		t.run();
		
		while (treshHold<=capacity) {
			
			spikeXgamma=spikeXgamma+p.gamma*p.spike;
			
			treshHold =(spikeXgamma)-leak;
			Pipe other = new Pipe();
			this.p=other;
			//System.out.println("Capacity ="+capacity+" Treshhold= "+treshHold+" Spike ="+p.spike+"Gamma= "+p.gamma);
		
			try {
				t.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
		t.interrupt();
		return p.spike;
		
				
		}
	
	
	
	
//	class Thread implements Runnable{
//		Pipe p=new Pipe();
//			double treshHold=0;	
//			double spikeXgamma=0;
//		@Override
//		public void run() {
//		
//			
//			
//			
//			while (treshHold<capacity) {
//				
//				spikeXgamma=spikeXgamma+p.gamma*p.spike;
//				
//				treshHold =(spikeXgamma)-leak;
//				Pipe other = new Pipe();
//				this.p=other;
//				System.out.println("Capacity ="+capacity+" Treshhold= "+treshHold+" Spike ="+p.spike+"Gamma= "+p.gamma);
//			
//	
//			
//		}
//		
//		
//	}
//	
//	
//	
//	
//	
//	
//		
//		
//		
//			
//		
//	}
	
	
 
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Bucket b = new Bucket();
		b.simulate();
		
		
	}
	}













	