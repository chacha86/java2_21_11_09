package test.day5;

public class InterfaceClassTest {

	public static void main(String[] args) {
		
		A a1 = new A();
		a1.test();
	}

}

class A {
	
	void test() {
		
		B b1 = new B();
		
		int rst = b1.func1();
		
		System.out.println(rst);
	}
	
}

interface test {
	int func1();
}



class B implements test {
	public int func1() {
		return 3;
	}
}




