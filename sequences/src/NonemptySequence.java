import java.util.Objects;

public class NonemptySequence extends Sequence {

	private final Object head;
	private final Sequence tail;
	
	public Object getHead() { return head; }
	public Sequence getTail() { return tail; }
	
	@Override
	public int getLength() { return 1 + tail.getLength(); }

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof NonemptySequence))
			return false;
		NonemptySequence otherSequence = (NonemptySequence)other;
		return Objects.equals(head, otherSequence.head) && tail.equals(otherSequence.tail);
	}
	
	@Override
	public int hashCode() { return Objects.hash(head, tail); }

	public NonemptySequence(Object head, Sequence tail) {
		if (tail == null) throw new IllegalArgumentException("tail is null");
		this.head = head;
		this.tail = tail;
	}
	
}
