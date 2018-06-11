package cs401_Project;

import java.util.Comparator;
import java.util.Iterator;

public class Sorted_LinkedList_Array<T> implements ListInterface<T>{

	int num_elements=0;
	T elements[];
	int size = 50;
	protected Comparator<T> comp_obj;
	protected boolean found; 
	protected int loc_value; 
	int current_pointer ;


	public Sorted_LinkedList_Array()

	{
		elements = (T[]) new Object[size];
		comp_obj = new Comparator<T>()
				{

			public int compare(T element1, T element2)
			{
				return ((Comparable<T>)element1).compareTo(element2);
			}
				};
	}


	public Sorted_LinkedList_Array(Comparator<T> comp_obj)
	{
		elements = (T[]) new Object[size];
		this.comp_obj = comp_obj;
	}

	public void add(int index, T element) 

	{
		throw new UnsupportedOperationException("Unsupported index-based add method");
	}	


	public T set(int index, T newElement) 

	{
		throw new UnsupportedOperationException("Unsupported index-based set method");
	}

	@Override
	public boolean is_full() {
		if (num_elements == size ){
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

	protected void Find_recursive(T target, int first, int last)

	{
		int result;
		if (first > last)
		{
			found = false;
			result = comp_obj.compare(target,elements[loc_value]);
			if (result > 0)
				loc_value++;    		
		}
		else
		{
			loc_value = (first + last) / 2;
			result = comp_obj.compare(target,elements[loc_value]);
			if (result == 0)  
				found = true;
			else
				if (result > 0)  
					Find_recursive(target, loc_value + 1, last);
				else             
					Find_recursive(target, first, loc_value - 1);
		}
	}

	public boolean add(T element)
	{
		loc_value = 0;
		found = false;
		if (!is_empty())
			Find_recursive(element, 0, num_elements - 1);

		for (int m = num_elements; m > loc_value; m--)
			elements[m] =elements[m - 1];
		elements[loc_value] = element;

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
					throw new IndexOutOfBoundsException("Illegal invocation of next " +" in LBList iterator.\n");

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
	public T get(int index) {
		T element_value= elements[index];

		return element_value;


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
