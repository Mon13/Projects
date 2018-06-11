

import java.util.*;

/**
 * @author mounagiri
 *
 * @param <T>
 */
/**
 * @author mounagiri
 *
 * @param <T>
 */
public interface ListInterface<T> extends Iterable<T>
{
	/** A new element is added at the index position
	 * @param index
	 * @param element
	 */
	void add(int index, T element);
	
	/**
	 * @param index
	 * @param newElement
	 * @return T
	 */
	T set(int index, T newElement);
	
	/**The element at the index position is returned
	 * @param index
	 * @return T
	 */
	T get(int index);
	
	/** The index of the element is returned
	 * @param target
	 * @return int
	 */
	int indexOf(T target);
	
	
	/* The element at the index is removed
	 * @param index
	 */
	T remove(int index);
}