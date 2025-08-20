package in.ineuron;

public class MathApp {
	public int add(int x, int y){
		return x+y;
	}
    public static void main( String[] args ){
        MathApp m = new MathApp();
		int result = m.add(100,200);
		System.out.println("The sum is :: "+result);
    }
}
