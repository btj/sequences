import java.util.Objects;

public class NonemptySequence<T> extends Sequence<T> {

	private final T head;
	private final Sequence<? extends T> tail;
	
	public T getHead() { return head; }
	public Sequence<? extends T> getTail() { return tail; }
	
	@Override
	public int getLength() { return 1 + tail.getLength(); }

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof NonemptySequence<?>))
			return false;
		NonemptySequence<?> otherSequence = (NonemptySequence<?>)other;
		return Objects.equals(head, otherSequence.head) && tail.equals(otherSequence.tail);
	}
	
	@Override
	public int hashCode() { return Objects.hash(head, tail); }

	public NonemptySequence(T head, Sequence<? extends T> tail) {
		if (tail == null) throw new IllegalArgumentException("tail is null");
		this.head = head;
		this.tail = tail;
	}
	
}
