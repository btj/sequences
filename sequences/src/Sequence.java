import java.util.Iterator;
import java.util.function.Consumer;

class SequenceIterator<T> implements Iterator<T> {
	
	private Sequence<? extends T> sequence;
	
	SequenceIterator(Sequence<? extends T> sequence) { this.sequence = sequence; }
	
	public boolean hasNext() { return sequence instanceof NonemptySequence<?>; }
	
	public T next() {
		NonemptySequence<? extends T> nonemptySequence = (NonemptySequence<? extends T>)sequence;
		sequence = nonemptySequence.getTail();
		return nonemptySequence.getHead();
	}
	
}
public abstract class Sequence<T> implements Iterable<T> {
	
	public abstract int getLength();
	
	@Override
	public Iterator<T> iterator() { return new SequenceIterator<T>(this); }

	public void forEach(Consumer<? super T> consumer) {
		for (T element : this)
			consumer.accept(element);
	}
	
}
