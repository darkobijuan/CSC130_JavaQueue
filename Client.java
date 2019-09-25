import java.util.Random;

public class Client {
	public static void main (String[] args){
		test_functions();
	}

	private static void test_functions(){
		Random rand = new Random();
		QueueADT my_queue = new Queue();

		//Push
		System.out.println("PUSHING 5 ELEMENTS");
		for (int i = 0; i < 5; i++){
			my_queue.push(rand.nextInt());
		}
		System.out.println("");
		my_queue.print_queue();
		System.out.println("");

		//Peek & Pop
		System.out.println("POPPING 6 ELEMENTS");
		for (int i = 0; i < 6; i++){
			my_queue.peek();
			my_queue.pop();
		}
		System.out.println("");
		my_queue.print_queue();
		System.out.println("");

		//Push
		System.out.println("PUSHING 3 ELEMENTS");
		for (int i = 0; i < 3; i++){
			my_queue.push(rand.nextInt());
		}
		System.out.println("");
		my_queue.print_queue();
		System.out.println("");

		//Search
		System.out.println("PUSHING 3 ELEMENTS");
		my_queue.push(100);
		my_queue.push(600);
		my_queue.push(900);
		System.out.println("");
		my_queue.print_queue();
		System.out.println("");
		System.out.println("SEARCHING 4 ELEMENTS");
		my_queue.search(100);
		my_queue.search(900);
		my_queue.search(600);
		my_queue.search(rand.nextInt());
	}
}
