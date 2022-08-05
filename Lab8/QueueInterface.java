
public interface QueueInterface<E> {

	/**
	 * Inserts the specified element into this queue, returning true upon success
	 * @param item the element to add
	 * @return true
	 */
	public boolean add(E item);
	
	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 * @return the head of this queue, or null if this queue is empty
	 */
	public E peek();
	
	/**
	 * Retrieves, but does not remove, the head of this queue. This method differs from peek only in that it throws an exception if this queue is empty.
	 * @throws NoSuchElementException - if this queue is empty
	 * @return the head of this queue
	 */
	public E element();
	
	/**
	 * Retrieves and removes the head of this queue.
	 * @throws NoSuchElementException - if this queue is empty
	 * @return the head of this queue
	 */
	public E remove();
	
	/**
	 * Removes all of the elements from this queue. The queue will be empty after this call returns.
	 */
	public void clear();
	
	/**
	 * Tests if this queue is empty.
	 * @return true if and only if this queue contains no items; false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of components in this queue.
	 * @return the number of components in this queue.
	 */
	public int size();
	
}
