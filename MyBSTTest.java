import static org.junit.Assert.*;

import org.junit.Test;

public class MyBSTTest {

	@Test
	public void testContains(){

		MyBST<String> stringBST=new MyBST<String>();
		String s="hello";
		assertFalse("should be false for s",stringBST.contains(s));
		assertTrue(stringBST.add(s));

		String a="apple";
		String b="ball";
		String c="cat";
		stringBST.add(b);
		stringBST.add(a);
		stringBST.add(c);

		assertTrue("a",stringBST.contains(a));
		assertTrue("b",stringBST.contains(b));
		assertTrue("c",stringBST.contains(c));
		assertFalse("false",stringBST.contains("Batman"));
		assertTrue("cat",stringBST.contains("cat"));
		assertFalse("bat",stringBST.contains("bat"));
		System.out.println(stringBST.toString());
		System.out.flush();
	}


	@Test
	public void MyBSTtest() {
		MyBST<Integer> x=new MyBST<Integer>();
		Integer y=new Integer(0);
		Integer a=new Integer(3);
		assertTrue(x.add(new Integer(2)));
		assertTrue(x.add(new Integer(4)));
		assertTrue(x.add(new Integer(1)));
		assertTrue(x.add(new Integer(9)));
		assertTrue(x.add(y));
		assertTrue(x.add(a));
		assertFalse(x.add(a));
		assertFalse(x.add(new Integer(9)));
		assertFalse("should be false",x.add(y));

		String s=x.toString();
		System.out.println(s);
	}
	@Test
	public void testFirst(){
		MyBST<String> stringBST=new MyBST<String>();
		String s="hello";
		assertFalse("should be false for s",stringBST.contains(s));
		assertTrue(stringBST.add(s));

		String a="apple";
		String b="ball";
		String c="cat";
		stringBST.add(b);
		stringBST.add(a);
		stringBST.add(c);

		assertTrue("a",stringBST.contains(a));
		assertTrue("b",stringBST.contains(b));
		assertTrue("c",stringBST.contains(c));
		assertFalse("false",stringBST.contains("Batman"));
		assertTrue("cat",stringBST.contains("cat"));
		assertFalse("bat",stringBST.contains("bat"));
		System.out.println(stringBST.first());
		System.out.println(stringBST.toString());
		System.out.flush();
		
	}
	



}
