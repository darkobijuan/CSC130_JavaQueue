
public interface QueueADT {
	
	public int get_size();					//Returns the count of elements in the queue
	public void push(int new_data);			//Push data onto the queue
	public void pop();						//Delete data off the queue
	public int peek();						//Look at the top element on the queue
	public boolean search(int search_data);	//Searches for element in queue
	public void print_queue();				//Print the elements in the queue

}
