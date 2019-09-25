
public class Queue implements QueueADT {
	
	//Private Variables
	private int head = 0;				//The start of the Queue
	private int tail = 0;				//The end of the Queue
	private int queue_size = 0;			//Count of elements in the queue
	private static int SIZE = 10;		//The size of the queue
	private int[] queue;				//Array to implement the queue

	
	//Wraps around the array (Creates the circluar array)
	private int wrap_around(int index) {
		while (index < 0) index += SIZE;
		if (index >= SIZE) index = index % SIZE;
		return index;
	}

	//Set an element in the queue
	private void set_element (int index, int new_value){
		this.queue[wrap_around(index)] = new_value;
	}


	//Return element in the queue
	private int get_element(int index){
		return this.queue[wrap_around(index)];
	}



	//Constructor
	public Queue(){
		this.queue =  new int[SIZE];
		this.head = 0;
		this.tail = 0;
		this.queue_size = 0;
	}


	//Gets the size of the queue
	@Override
	public int get_size(){
		return this.queue_size;
	}

	//Inserts an element into the queue
	@Override
	public void push(int new_data){
		//Checks if queue is full
		if(get_size()+1 >= SIZE){
			System.out.println("WARNING: The queue is full. Cannot push element!");
			return;
		}
		System.out.println("Push: "+new_data);			//Print number being pushed
		this.queue_size++;								//Increase queue size
		set_element(this.tail, new_data);				//Function that does the pushing
		tail = wrap_around(this.tail+1);				//Wrap tail if needed
	}


	//Deletes an element from the queue
	@Override 
	public void pop(){
		//If queue is empty
		if (get_size() <=0){
			System.out.println("WARNING: Cannot pop off of an empty queue!");
			return;
		}
		System.out.println("Pop: "+this.queue[wrap_around(this.head)]);
		this.queue_size--;								//Decrease queue size
		this.head = wrap_around(this.head+1);			//Wrap head if needed
	}

	//Return the element at the top of the queue
	@Override 
	public int peek(){
		int top = this.head;
		System.out.println("Head of Queue: "+this.queue[wrap_around(top)]);
		return this.queue[wrap_around(top)];
	}

	//Searches an element in the queue, returns true if found & false if not 
	@Override 
	public boolean search(int search_data){
		//If queue is empty
		if (get_size() <= 0){
			System.out.println("Cannot search for element when the queue is empty!");
			return false;
		}
		int start_index = this.head;					//Start of the queue
		int end_index = this.tail;						//End of the queue

		//Handle if we have wrapped around
		if (this.tail < this.head){
			end_index += SIZE;
		}

		//Search
		for (int i = start_index; i < end_index; i++){
			if (get_element(i) == search_data) {
				System.out.println("Searched: "+search_data+" was found in the queue!");	
				return true;
			}
		}
		System.out.println("Searched: "+search_data+" was not found in the queue");	
		return false;
	}

	//Prints the queue
	@Override 
	public void print_queue(){
		//If queue is empty
		if (get_size() <= 0){
			System.out.println("Empty Queue!");
			return;
		}
		int start_index = this.head;					//Start of the queue
		int end_index = this.tail;						//End of the queue
		int counter = 0;								//Count of elements for printing
		
		//Handle if we have wrapped around
		if (this.tail < this.head){
			end_index += SIZE;
		}

		//Print Queue
		System.out.println("---------------Printing Queue---------------");
		for (int i = start_index; i < end_index; i++){
			System.out.println("Node "+ counter++ +": "+get_element(i));
		}
	}



}






