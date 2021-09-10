public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the list

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}
	
	public boolean addAll(MyList<E> otherList) {
		int temp = size;
		for(int i = 0; i < otherList.size(); i++) {
			add(otherList.get(i));
		}
		if(temp == size) {
			return false;
		}
		else {
			return true;
		}
	}

	/** Return true if this list contains no elements */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Return the number of elements in this list */
	public int size() {
		return size;
	}

	/** Remove the first occurrence of the element o from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else 
			return false;
	}
	
	public boolean removeAll(MyList<E> otherList) {
		int temp = size();
		for(int i = 0; i < size(); i++) {
			for(int j = 0; j < otherList.size(); j++) {
				if(get(i) == (otherList.get(j))) {
					remove(get(i));
				}
			}
		}
		if(size == temp) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean retainAll(MyList<E> otherList) {
		boolean pass = false;
		boolean result = false;
		for(int i = 0; i < size(); i++) {
			pass = false;
			for(int j = 0; j < otherList.size(); j++) {
				if(get(i) == otherList.get(j)) {
					pass = true;
				}
			}
			if(pass == false) {
				remove(get(i));
				result = true;
				i--;
			}
		}
		return result;
	}
}