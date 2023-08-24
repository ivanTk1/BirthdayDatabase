package for_proj3;

import java.util.Comparator;
import java.util.Iterator;

public class LinkedList<E extends Comparable <E>> implements Iterable<E> {
	
	private Node<E> head;
	private int size;
	private Comparator<E> myComparator;
	
	public int size() {
		return size;
	}
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public void addAlpha(E data) {
	    Node<E> n = new Node<>(data);
	    if(head == null) {
	        head = n;
	        size++;
	        return;
	    }
	    if(( data).compareTo(head.getData()) < 0) { 
	        n.setLink(head);
	        head = n;
	        size++;
	        return;
	    }
	    Node<E> current = head;
	    while(current.getLink() != null && data.compareTo(current.getLink().getData()) > 0) {
	        current = current.getLink();
	    }
	    n.setLink(current.getLink());
	    current.setLink(n);
	    size++;
	}

	public boolean contains(E data) {
		boolean loop = true;
		int i = 0;
		while(loop) {
			if(i==size) {
				break;
			}
			if(get(i).equals(data)) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	private int myCompare(E a, E b) {
		if(myComparator == null) {
			return (a).compareTo(b);
		}
		return myComparator.compare(a,b);
	}

	public void add(E data) {
		Node<E> n = new Node<>(data);
		if(head == null) {
			head = n;
			size++;
			return;
		}
		Node<E> mover = head;
		while(mover.getLink() != null) {
			mover = mover.getLink();
		}
		mover.setLink(n);
		size++;
	}
	
	public void addFirst(E data) {
		Node<E> n = new Node<>(data);
		n.setLink(head);
		head = n;
		size++;
	}
	
	public String toString() {
		String toReturn = "";
		Node<E> mover = head;
		while(mover != null) {
			toReturn += mover.getData() + " - ";
			mover = mover.getLink();
		}
		if(size == 0) {
			toReturn = "Empty list";
		}
		return toReturn;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> mover = head;
		for(int i = 0; i < index; i++) {
			mover = mover.getLink();
		}
		return mover.getData();
	}
	
	public void set(int index, E data) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> mover = head;
		for(int i = 0; i < index; i++) {
			mover = mover.getLink();
		}
		mover.setData(data);
	}
	
	public boolean remove(E data) {
	    if (head == null) {
	        return false;
	    }
	    if (head.getData().equals(data)) {
	        head = head.getLink();
	        size--;
	        return true;
	    }

	    MyListIterator<E> iterator = new MyListIterator<>(this);
	    while (iterator.hasNext()) {
	        E element = iterator.next();
	        if (element.equals(data)) {
	            iterator.remove();
	            return true;
	        }
	    }
	    return false;
	}
	
	public void remove(int i) {
	    if (i < 0 || i >= size) {
	        throw new IndexOutOfBoundsException();
	    }
	    if (i == 0) {
	        head = head.getLink();
	        size--;
	        return;
	    }
	    Node<E> current = head;
	    for (int j = 0; j < i - 1; j++) {
	        current = current.getLink();
	    }
	    current.setLink(current.getLink().getLink());
	    size--;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new MyListIterator<>(this);
	}

	public Node<E> getHead() {
		return head;
	} 
	   
}
