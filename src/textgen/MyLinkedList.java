package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		
		tail.prev = head;
		tail.prev.next = tail;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		if(element == null){
			throw new NullPointerException();
		}
		
		LLNode node = new LLNode(element);
		
		node.next = tail;
		node.prev = node.next.prev;
		node.next.prev.next = node;
		node.next.prev = node;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> n = head;
		for (int i = 0; i <= index; i++) {
			n = n.next;
		}
		return n.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		
		if(element == null){
			throw new NullPointerException();
		}
		LLNode<E> node = new LLNode(element);
		LLNode<E> prev = head;
		for (int i = 0; i <= index; i++) {
			prev = prev.next;
		}
		node.next = prev.next;
		node.prev = prev;
		prev.next.prev = node;
		prev.next = node;
		
		size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> n = head;
		for (int i = 0; i <= index; i++) {
			n = n.next;
		}
		n.prev.next = n.next;
		n.next.prev = n.prev;
		size--;

		
		return n.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> n = head;
		for (int i = 0; i <= index; i++) {
			n = n.next;
		}
		n.data = element;
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(){
		this.data = null;
		this.next = null;
		this.prev = null;
	}

}
