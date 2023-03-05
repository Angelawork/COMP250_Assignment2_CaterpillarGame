package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {
	private DNode head;
	private DNode tail;

	public void add(E elmt){
		DNode temp=new DNode();
		temp.element=elmt;
		temp.next=null;
		temp.prev=null;

		if(this.isEmpty()){
			head=temp;
			tail=temp;
		} else {
			tail.next = temp;
			temp.prev = tail;
			tail=temp;
		}

		size=size+1;
	}

	public void clear(){//would this work well?
		head=null;
		tail=null;
		/*
		DNode temp=head;
		if(!isEmpty()) {
			while (temp != null && temp.element != null) {
				temp.element = null;
				temp = temp.next;
			}
		}
		 */
		size=0;
	}
	public E remove(){
		if(getSize()==0){throw new NoSuchElementException("The list is empty!");}
		if (size == 1) {
			E temp=head.element;
			head = null;
			tail = null;

			size=size-1;
			return temp;
		}
		else {
			E temp = tail.element;

			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;

			size=size-1;
			return temp;
		}
	}

	public void addFirst(E elmt){
		DNode temp=new DNode();
		temp.element=elmt;
		temp.next=head;
		temp.prev=null;

		if(this.isEmpty()){
			head=temp;
			tail=temp;
		}else{
			head.prev=temp;
			head=temp;
		}
		size=size+1;
	}

	public void addLast(E elmt){
		this.add(elmt);
	}

	public E removeFirst(){//meaning of getSize if we can still access size here?
		if(this.isEmpty()){throw new NoSuchElementException("The list is empty!");}//equivalent to using getSize()==0?
		E temp=head.element;
		if (size == 1) {
			head = null;
			tail = null;
		}
		else {
			head = head.next;
			head.prev.next = null;
			head.prev = null;
		}
		size=size-1;
		return temp;
	}
	public E removeLast(){
		return this.remove();
	}

	public E peekFirst(){
		if(getSize()==0 || head==null){throw new NoSuchElementException("The list is empty!");}
		return head.element;
	}
	public E peekLast(){
		if(getSize()==0 || tail==null){throw new NoSuchElementException("The list is empty!");}
		return tail.element;
	}

	public boolean equals(Object input){
		if(input instanceof MyDoublyLinkedList) {
			DNode myHead = this.head;
			DNode inputHead = ((MyDoublyLinkedList)input).head;
			while(myHead!=null && inputHead!=null){
				if(myHead.element!=inputHead.element){
					return false;
				}
				myHead=myHead.next;
				inputHead=inputHead.next;
			}
			return (inputHead==null && myHead==null);
		} else return false;
	}

	public Iterator<E> iterator() {
		return new DLLIterator();
	}

	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
	}

	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
