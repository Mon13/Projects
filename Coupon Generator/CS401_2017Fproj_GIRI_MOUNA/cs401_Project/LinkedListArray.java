package cs401_Project;

import java.util.Iterator;


public class LinkedListArray<T> implements ListInterface<T>{

	int num_elements=0;
	T elements[];
	int default_size = 50;
	int user_size=0;
	int current_pointer ;

	public LinkedListArray() {
		super();
		elements = (T[]) new Object[default_size];
	}

	public LinkedListArray(int size) {
		super();
		elements = (T[]) new Object[size];
	}

	@Override
	public boolean is_full() {
		if (num_elements == default_size){
			return true;
		}
		return false;
	}

	@Override
	public boolean is_empty() {
		if (num_elements == 0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {

		return num_elements;
	}


	@Override
	public boolean add(T e) {
			elements[num_elements] = e ;
			num_elements++;
			return true;
		 
		
	}

	@Override
	public boolean contains(T e) {
		if (num_elements > 0) {

			for (int i = 0 ; i < num_elements ; i++ ) {
				if(elements[i].equals(e)) 
					return true;
			}

		}
		return false;
	}



	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>()
				{
			private int previousPos = -1;
			public boolean hasNext() {
				return (previousPos < (size() - 1)) ; 
			}
			public T next()
			{
				if (!hasNext())
					throw new IndexOutOfBoundsException("Illegal invocation of next");

				previousPos++;
				return elements[previousPos]; 
			}
			public void remove()
			{
				for (int i = previousPos; i <= num_elements - 2; i++) 
					elements [i] = elements[i+1];
				elements [num_elements - 1] = null; 
				num_elements--;
				previousPos--;
			} };
	}



	@Override
	public void add(int index, T element) {
		if (element != null) {
			elements[index] = element ;
			num_elements++;
		}


	}

	@Override
	public T set(int index, T newElement) 

	{
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("Illegal index of " + index +" passed to ABList set method.\n");

		T hold = elements[index]; 
		elements[index] = newElement; 
		num_elements++;
		return hold;
	}

	@Override
	public T get(int index) {
		T element_value= elements[index];
		if(element_value != null)
		{
			return element_value;
		}
		return null;
	}

	@Override
	public int indexOf(T target) {
		if (num_elements > 0) {

			for (int i = 0 ; i < num_elements ; i++ ) {
				if(elements[i] == target) 
					return i;
			}

		}
		return -1;
	}

	@Override
	public T remove(int index) {

		T elem=null;
		T current_pointer = elements[index] ;


		for (int i = index + 1 ; i < num_elements ; i++) {
			elements[index] = elements[i] ;
			index++ ;
		}
		num_elements-- ;
		return elem;
	}



}
