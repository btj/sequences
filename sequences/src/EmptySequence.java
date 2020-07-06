public class EmptySequence extends Sequence {

	@Override
	public int getLength() { return 0; }
	
	@Override
	public boolean equals(Object other) { return other instanceof EmptySequence; }
	
	@Override
	public int hashCode() { return 0; }
	
}
