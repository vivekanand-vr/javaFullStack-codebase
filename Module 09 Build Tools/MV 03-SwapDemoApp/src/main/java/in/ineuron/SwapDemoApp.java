package in.ineuron;
class SwapApp
{
int a,b;
public void accept(int x,int y){
a=x;
b=y;
}
public void swapValues(){
a=a+b;
b=a-b;
a=a-b;
}
void disp(){
System.out.println("Value of a is :: "+a);
System.out.println("Value of b is :: "+b);
}
}
public class SwapDemoApp {
public static void main( String[] args ){

if(args.length!=2)
System.out.println("Plz enter 2 numbers...");
else{
int x1= Integer.parseInt(args[0]);
int x2= Integer.parseInt(args[1]);
SwapApp s = new SwapApp();
s.accept(x1,x2);
System.out.println("Before swapping");
System.out.println("---------------");
s.disp();
s.swapValues();
System.out.println("After swapping");
System.out.println("---------------");
s.disp();
}
}
}