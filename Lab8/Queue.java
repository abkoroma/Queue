import java.util.NoSuchElementException;

public class Queue<E> implements QueueInterface<E> {
	Node head;
	Node tail;
	int size;
	
	public Queue() {
		clear();
	}
	
	private class Node {
		Node next;
		E value;
		
		public Node(E element) {
			this.value = element;
			next = null;
		}
		
	}
	
	
	@Override
	public boolean add(E item) {
		
		if (isEmpty()) {
			tail = new Node(item);
			head = tail;
		}
		else {
			tail.next = new Node(item);
			tail = tail.next;
		}

		size++;
		return true;
	}

	@Override
	public E peek() {
		
		if (isEmpty()) {
			return null;
		}
		
		return head.value;
		
	}

	@Override
	public E element() {
		
		if (isEmpty()) {
			throw new NoSuchElementException ();
		}
		
		return head.value;
	}

	@Override
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException ();
		}
		
		if(head == null) {
			tail = null;
		}
		
		size--;
		Node tempNode = head;
		head = head.next;
	
		return tempNode.value;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	public String toString()
    {
   	 String s = "[";
   	 Node n = head;
   	 while(n != null)
   	 {
   		 s += n.value + ", ";
   		 n = n.next;
   	 }
   	 if(s.length() > 1)
   		 s = s.substring(0, s.length() - 2);
   	 s += "]";
   	 return s;
    }


}
