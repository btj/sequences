import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class SequencesTest {

	@Test
	void test() {
		// Minimal test suite that tests all statements
		EmptySequence empty = new EmptySequence();
		assertEquals(0, empty.getLength());
		assertEquals(empty, new EmptySequence());
		assertTrue(new HashSet<>(List.of(empty)).contains(new EmptySequence()));
		
		NonemptySequence c = new NonemptySequence("c", empty);
		assertEquals("c", c.getHead());
		assertEquals(empty, c.getTail());
		assertEquals(1, c.getLength());
		assertEquals(c, new NonemptySequence("c", new EmptySequence()));
		assertNotEquals(empty, c);
		assertNotEquals(c, empty);
		assertNotEquals(c, new NonemptySequence("b", new EmptySequence()));
		assertNotEquals(c, new NonemptySequence("c", new NonemptySequence("d", new EmptySequence())));
		assertTrue(new HashSet<>(List.of(c)).contains(new NonemptySequence("c", new EmptySequence())));
	}

}
