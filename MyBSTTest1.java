import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class MyBSTTest1 {
	@Test
	public void testFirstandLast(){
		MyBST<String> stringBST=new MyBST<String>();
		String s="hello";
		assertFalse("should be false for s",stringBST.contains(s));
		assertTrue(stringBST.add(s));

		String a="apple";
		String b="ball";
		String c="cat";
		stringBST.add(c);
		stringBST.add(b);
		stringBST.add(a);
		stringBST.add("zoo");
		stringBST.add("xylophone");
		stringBST.add("wolverine");
		stringBST.add("batman");
		stringBST.add("aaa");
		stringBST.add("a");
		stringBST.add("rollerblading");
		stringBST.add("fast");
		
		
		System.out.println(stringBST.first().toString());
		System.out.println(stringBST.last().toString());
		System.out.println(stringBST.toString());
		System.out.flush();
		
		MyBST<Integer> x=new MyBST<Integer>();
		Integer y=new Integer(0);
		Integer l=new Integer(3);
		assertTrue(x.add(new Integer(14)));
		assertTrue(x.add(new Integer(4)));
		assertTrue(x.add(new Integer(1)));
		assertTrue(x.add(new Integer(9)));
		assertTrue(x.add(y));
		assertTrue(x.add(l));
		assertFalse(x.add(l));
		assertFalse(x.add(new Integer(9)));
		assertFalse("should be false",x.add(y));
		x.add(new Integer(0));
		x.add(new Integer(100));
		x.add(new Integer(10));
		x.add(new Integer(98));
		x.add(new Integer(12356));
		
		String m=x.toString();
		System.out.println(m);
		System.out.println(x.first());
		System.out.println(x.last());
		try{
			MyBST<Integer> k=new MyBST<Integer>();
			Object po="hagu";
			k.contains(null);
		}
		catch (NoSuchElementException e){
			System.err.println("righterror");
		}
		catch (NullPointerException e){
			System.err.println("bloop");
		}
		catch (ClassCastException e){
			System.err.println("poop");
		}
		
	}
	
	@Test
	public void testRemove(){
		MyBST<String> stringBST=new MyBST<String>();
		
		

		String a="apple";
		String b="ball";
		String c="cat";
		stringBST.add(c);
		stringBST.add(b);
		stringBST.add(a);
		stringBST.add("zoo");
		stringBST.add("xylophone");
		stringBST.add("wolverine");
		stringBST.add("batman");
		stringBST.add("aaa");
		stringBST.add("a");
		stringBST.add("rollerblading");
		stringBST.add("fast");
		stringBST.add("fast");
		stringBST.add("rally");
		stringBST.add("google");
		stringBST.add("xyz");
		stringBST.add("xxx");
		
		
		System.out.println(stringBST.toString());
		assertTrue(stringBST.remove("rally"));
		assertTrue(stringBST.remove("ball"));
		assertTrue(stringBST.remove("apple"));
		assertTrue(stringBST.remove("wolverine"));
		assertTrue(stringBST.remove("xylophone"));
		assertTrue(stringBST.remove("cat"));
		
		System.out.println(stringBST.toString());
		
		
	}

}
