import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class SequencesTest {
	
	static <T> List<T> getElements(Iterable<T> iterable) {
		ArrayList<T> list = new ArrayList<>();
		for (T element : iterable)
			list.add(element);
		return list;
	}
	
	static <T> List<T> getElementsInternal(Sequence<T> sequence) {
		ArrayList<T> list = new ArrayList<T>();
		sequence.forEach(element -> list.add(element));
		return list;
	}
	
	@Test
	void test() {
		// Minimal test suite that tests all statements
		EmptySequence<String> empty = new EmptySequence<String>();
		assertEquals(0, empty.getLength());
		assertEquals(empty, new EmptySequence<String>());
		assertTrue(new HashSet<>(List.of(empty)).contains(new EmptySequence<String>()));
		
		NonemptySequence<String> c = new NonemptySequence<String>("c", empty);
		assertEquals("c", c.getHead());
		assertEquals(empty, c.getTail());
		assertEquals(1, c.getLength());
		assertEquals(c, new NonemptySequence<String>("c", new EmptySequence<String>()));
		assertNotEquals(empty, c);
		assertNotEquals(c, empty);
		assertNotEquals(c, new NonemptySequence<String>("b", new EmptySequence<String>()));
		assertNotEquals(c, new NonemptySequence<String>("c", new NonemptySequence<String>("d", new EmptySequence<String>())));
		assertTrue(new HashSet<>(List.of(c)).contains(new NonemptySequence<String>("c", new EmptySequence<String>())));
		
		assertEquals(List.of(), getElements(empty));
		assertEquals(List.of("c"), getElements(c));
		assertEquals(List.of("b", "c"), getElements(new NonemptySequence<>("b", c)));
		
		assertEquals(List.of(), getElementsInternal(empty));
		assertEquals(List.of("c"), getElementsInternal(c));
		assertEquals(List.of("b", "c"), getElementsInternal(new NonemptySequence<>("b", c)));
	}

}
