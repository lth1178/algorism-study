package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import lambda.LabmdaTestFunction;

public class Test {
	public static void main(String[] args) {
		
		
		Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]); 
		consumer
		.andThen(a -> System.out.println(a))
		.andThen((str) -> System.out.println(str.split(" ")[1]))
		.andThen((str) -> System.out.println(str.split(" ")[2]))
		.accept("tset test2 test3 test5");
		List<String> listTest = new ArrayList<String>();
		
		listTest.forEach(System.out::println);

		TestIntserface testInterface = new TestIntserface() {
			
			@Override
			public void test() {
				// TODO Auto-generated method stub
				
			}
		};
	
		
	}
	public static void typeTest() {
		int primitiveType_01 = 1;
		int primitiveType_02 = 2;
		int primitiveType_03 = 3;
		
		System.out.println("primitiveType_01 : "+ primitiveType_01 + ", primitiveType_02 : "+ primitiveType_02 + ", primitiveType_03 : " + primitiveType_03);
		
		primitiveType_01 = primitiveType_02;
		primitiveType_02 = 4;
		primitiveType_03 = 5;
		System.out.println("primitiveType_01 : "+ primitiveType_01 + ", primitiveType_02 : "+ primitiveType_02 + ", primitiveType_03 : " + primitiveType_03);
		System.out.println("\n\n\n");
		
		
		int[] ReferenceType_01 = {1};
		int[] ReferenceType_02 = {2};
		int[] ReferenceType_03 = {3};

		System.out.println("ReferenceType_01 : "+ ReferenceType_01 + ", ReferenceType_02 : "+ ReferenceType_02 + ", ReferenceType_03 : " + ReferenceType_03);
		System.out.println("ReferenceType_01 : "+ ReferenceType_01[0] + ", ReferenceType_02 : "+ ReferenceType_02[0] + ", ReferenceType_03 : " + ReferenceType_03[0]);
		ReferenceType_01 = ReferenceType_02;
		ReferenceType_02[0] = 4;
		ReferenceType_03[0] = 5;
		
		System.out.println("ReferenceType_01 : "+ ReferenceType_01 + ", ReferenceType_02 : "+ ReferenceType_02 + ", ReferenceType_03 : " + ReferenceType_03);
		System.out.println("ReferenceType_01 : "+ ReferenceType_01[0] + ", ReferenceType_02 : "+ ReferenceType_02[0] + ", ReferenceType_03 : " + ReferenceType_03[0]);
	}
}
