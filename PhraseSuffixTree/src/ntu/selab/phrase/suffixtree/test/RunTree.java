package ntu.selab.phrase.suffixtree.test;


import ntu.selab.phrase.suffixtree.*;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;



public class RunTree extends TestCase {

	// MyClass is tested
	   MyClass tester = new MyClass();

	   // Tests
	   assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
	   assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
	   assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
}
