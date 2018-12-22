import java.util.Random;

public class Pipe {
	private Random random = new Random();
	public double gamma;
	 public int spike;
	
	
	public Pipe() {
		this.gamma=random.nextDouble();
		this.spike=random.nextInt(100);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pipe p = new Pipe();
		System.out.println("gamma: "+p.gamma+" spike: "+p.spike);

	}

}
