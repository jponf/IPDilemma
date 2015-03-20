package cat.udl.ipdilemma;

/**
 * Represents an immutable pair of two elements
 * @param <T> Pair elements type.
 */
public final class Pair<T> {

    private final T first;
    private final T second;

    /**
     * Builds a new pair of objects.
     * @param first the first element of the pair.
     * @param second the second element of the pair.
     */
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    /**
     * Returns the first element of the pair.
     * @return the first element of the pair.
     */
    public T getFirst() {
        return first;
    }

    /**
     * Returns the second element of the pair.
     * @return the second element of the pair.
     */
    public T getSecond() {
        return second;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.first.hashCode();
        hash = 17 * hash + this.second.hashCode();
        return hash;
    }

	/**
	 *
	 * @param obj
	 * @return True if the given object is an instance of Pair<T> and the internal
	 * pair of elements are equals
	 */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair<T> other = (Pair<T>) obj;
        return first.equals(other.first) && second.equals(other.second);
    }

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }
}
