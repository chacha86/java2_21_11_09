package test.day6;

public class InterfaceClassTest {

	public static void main(String[] args) {
		
		A a1 = new A();
		a1.test();
	}

}

class A {
	
	void test() {
		
		Test b1 = new C();
		
		int rst = b1.func();
		
		System.out.println(rst);
	}
	
}

interface Test {
	int func();
}



class B implements Test {
	public int func() {
		return 1;
	}
}

class C implements Test {
	public int func()  {
		return 3;
	}
}

class D implements Test {
	public int func() {
		return 7;
	}
}




