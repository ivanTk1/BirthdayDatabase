package for_proj3;

import java.util.Iterator;

public class MyListIterator<E extends Comparable <E>> implements Iterator<E> {

	private LinkedList<E> list;
	private Object element;
	private int index;
	private boolean removeGotCalled;
	
	public MyListIterator(LinkedList<E> thelist) {
		list = thelist;
		element = list.get(0);
		index = 0;
		removeGotCalled = false;
		
	}

	@Override
	public boolean hasNext() {
		return element != null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		Object toReturn = element;
		index++;
		try {
			element = list.get(index);
		}catch(IndexOutOfBoundsException e) {
			element = null;
		}
		removeGotCalled = false;
		return (E)toReturn;
	}
	
	@Override
	public void remove() {
		if(index == 0 || removeGotCalled) {
			throw new IllegalStateException();
		}
		list.remove(index-1);
		index--;
		removeGotCalled = true;
	}
	
	
}
