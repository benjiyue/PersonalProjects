class MyStack {
	Queue<Integer> queue = new LinkedList();
	// Push element x onto stack.
	//must be pushed to the normal queue
	public void push(int x) {
		queue.add(x);
		for(int i=0;i<queue.size()-1;i++)
			queue.add(queue.remove());
	}
	//must be removed from the front of the reversed
	// Removes the element on top of the stack.
	public void pop() {
		queue.remove();
	}

	//call peek on tehe reversed
	// Get the top element.
	public int top() {
		return queue.peek();
	}

	//return that both are empty
	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
}