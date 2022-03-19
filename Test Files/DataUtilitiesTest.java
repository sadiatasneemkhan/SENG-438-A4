package org.jfree.data;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;

public class DataUtilitiesTest{
     
	//Start of calculateColumnTotal testing
     @Test
     public void test_calculateColumnTotal_posDoubleNum() {
         // setup
         Mockery mockingContext = new Mockery();
         final Values2D values = mockingContext.mock(Values2D.class);
         mockingContext.checking(new Expectations() {
             {
                 one(values).getRowCount();
                 will(returnValue(4));
                 
                 one(values).getValue(0, 0);
                 will(returnValue(7.5));
                 
                 one(values).getValue(1, 0);
                 will(returnValue(2.5));
                 
                 one(values).getValue(2, 0);
                 will(returnValue(1.5));
                 
                 one(values).getValue(3, 0);
                 will(returnValue(0.5));
             }
         });
         //exercise
         double result = DataUtilities.calculateColumnTotal(values, 0);
         
         // verify
         assertEquals("Result should be 12", result, 12.0, .000000001d);
     }
     
     @Test
     public void test_calculateColumnTotal_negation() {
         // setup
         Mockery mockingContext = new Mockery();
         final Values2D values = mockingContext.mock(Values2D.class);
         mockingContext.checking(new Expectations() {
             {
                 one(values).getRowCount();
                 will(returnValue(4));
                 
                 one(values).getValue(0, 0);
                 will(returnValue(0.0));
                 
                 one(values).getValue(1, 0);
                 will(returnValue(0.0));
                 
                 one(values).getValue(2, 0);
                 will(returnValue(0.0));
                 
                 one(values).getValue(3, 0);
                 will(returnValue(0.0));
             }
         });
         //exercise
         double result = DataUtilities.calculateColumnTotal(values, 0);
         
         // verify
         assertEquals("Result should be 0", result, 0.0, .000000001d);
     }
     
     @Test
     public void test_calculateColumnTotal_conditionalBoundary() {
         // setup
         Mockery mockingContext = new Mockery();
         final Values2D values = mockingContext.mock(Values2D.class);
         mockingContext.checking(new Expectations() {
             {
                 one(values).getRowCount();
                 will(returnValue(1));
                 
                 one(values).getValue(1, 0);
                 will(returnValue(1.0));
                 
             }
         });
         //exercise
         int rowNumber = 1;
         final int [] validColumnsToPass = {1};
         double result = DataUtilities.calculateColumnTotal(values, rowNumber, validColumnsToPass);
         
         // verify
         assertEquals("Result should be 0", result, 0.0, .000000001d);
     }
     
     @Test
     public void test_calculateColumnTotal_nullColumn() {
         // setup
         Mockery mockingContext = new Mockery();
         final Values2D values = mockingContext.mock(Values2D.class);
         mockingContext.checking(new Expectations() {
             {
                 one(values).getRowCount();
                 will(returnValue(4));
                 
                 one(values).getValue(0, 0);
                 will(returnValue(null));
                 
                 one(values).getValue(1, 0);
                 will(returnValue(null));
                 
                 one(values).getValue(2, 0);
                 will(returnValue(null));
                 
                 one(values).getValue(3, 0);
                 will(returnValue(null));
             }
         });
         //exercise
         int rows [] = {0,1,2,3};
         double result = DataUtilities.calculateColumnTotal(values, 0, rows);
         
         // verify
         assertEquals("Result should be null", result, 0.0, .000000001d);
     }
     
     @Test (expected = IllegalArgumentException.class)
     public void test_calculateColumnTotal_null() {
    	 DataUtilities.calculateColumnTotal(null, 0, null);
     }
     
     @Test
     public void test_calculateColumnTotal_nullValue() {
         // setup
         Mockery mockingContext = new Mockery();
         final Values2D values = mockingContext.mock(Values2D.class);
         mockingContext.checking(new Expectations() {
             {
                 one(values).getRowCount();
                 will(returnValue(4));
                 
                 one(values).getValue(0, 0);
                 will(returnValue(null));
                 
                 one(values).getValue(1, 0);
                 will(returnValue(2.5));
                 
                 one(values).getValue(2, 0);
                 will(returnValue(1.5));
                 
                 one(values).getValue(3, 0);
                 will(returnValue(0.5));
             }
         });
         //exercise
         double result = DataUtilities.calculateColumnTotal(values, 0);
         
         // verify
         assertEquals("Result should be 4.5", result, 4.5, .000000001d);
     }
     
     @Test
     public void test_calculateColumnTotal_negDoubleNum() {
         // setup
         Mockery mockingContext = new Mockery();
         final Values2D values = mockingContext.mock(Values2D.class);
         mockingContext.checking(new Expectations() {
             {
                 one(values).getRowCount();
                 will(returnValue(4));
                 
                 one(values).getValue(0, 0);
                 will(returnValue(-7.5));
                 
                 one(values).getValue(1, 0);
                 will(returnValue(-2.5));
                 
                 one(values).getValue(2, 0);
                 will(returnValue(-1.5));
                 
                 one(values).getValue(3, 0);
                 will(returnValue(-0.5));
             }
         });
         //exercise
         double result = DataUtilities.calculateColumnTotal(values, 0);
         
         // verify
         assertEquals("Result should be -12", result, -12.0, .000000001d);
     }
     
     @Test
     public void test_calculateColumnTotal_posIntNum() {
         // setup
         Mockery mockingContext = new Mockery();
         final Values2D values = mockingContext.mock(Values2D.class);
         mockingContext.checking(new Expectations() {
             {
                 one(values).getRowCount();
                 will(returnValue(4));
                 
                 one(values).getValue(0, 0);
                 will(returnValue(1));
                 
                 one(values).getValue(1, 0);
                 will(returnValue(1));
                 
                 one(values).getValue(2, 0);
                 will(returnValue(1));
                 
                 one(values).getValue(3, 0);
                 will(returnValue(5));
             }
         });
         //exercise
         double result = DataUtilities.calculateColumnTotal(values, 0);
         
         // verify
         assertEquals("Result should be 8", result, 8, .000000001d);
     }
     
     @Test
     public void test_calculateColumnTotal_negIntNum() {
         // setup
         Mockery mockingContext = new Mockery();
         final Values2D values = mockingContext.mock(Values2D.class);
         mockingContext.checking(new Expectations() {
             {
                 one(values).getRowCount();
                 will(returnValue(4));
                 
                 one(values).getValue(0, 0);
                 will(returnValue(-1));
                 
                 one(values).getValue(1, 0);
                 will(returnValue(-1));
                 
                 one(values).getValue(2, 0);
                 will(returnValue(-1));
                 
                 one(values).getValue(3, 0);
                 will(returnValue(-5));
             }
         });
         //exercise
         double result = DataUtilities.calculateColumnTotal(values, 0);
         
         // verify
         assertEquals("Result should be -8", result, -8, .000000001d);
     }
     
     
   //Start of equal testing
    @Test
 	public void test_equal_normalCase() {
 		double[][] a = {{2.99, 3.6, 6.9}, {1.25, 4.2, 7.38}};
 		double[][] b = {{2.99, 3.6, 6.9}, {1.25, 4.2, 7.38}};
 		assertTrue(DataUtilities.equal(a,  b));
 	}
     
 	@Test
 	public void test_equal_notEqual() {
 		double[][] a = {{2.99, 3.6, 6.8}, {1.25, 4.2, 7.38}};
 		double[][] b = {{2.99, 3.6, 6.9}, {1.23, 4.2, 7.39}};
 		assertFalse(DataUtilities.equal(a,  b));
 	}
 	
 	@Test
 	public void test_equal_differentInnerDimensions() {
 		double[][] a = {{2.99, 3.6}, {1.25, 4.2}};
 		double[][] b = {{2.99, 3.6, 6.9}, {1.25, 4.2, 7.38}};
 		assertFalse(DataUtilities.equal(a,  b));
 	}
 	
 	@Test
 	public void test_equal_bothNull() {
 		double[][] a = null;
 		double[][] b = null;
 		assertTrue(DataUtilities.equal(a,  b));
 	}
 	
 	@Test 
 	public void test_equal_bNull(){
 		double[][] a = {{2.99, 3.6}, {1.25, 4.2}};
 		double[][] b = null;
 		assertFalse(DataUtilities.equal(a,  b));
 	}
 	
 	@Test 
 	public void test_equal_substituting0and1(){
 		double[][] a = {{4}, {2}};
 		double[][] b = {{5}, {2}};
 		boolean result = DataUtilities.equal(a,  b);
 		boolean expected = false;
 		assertEquals("mutation testing substitute", expected, result);
 	}
 	
 	@Test 
 	public void test_equal_equalToGreaterOrEqual(){
 		double[][] a = {{2}};
 		double[][] b = {{2}, {4}, {5}};
 		boolean result = DataUtilities.equal(a,  b);
 		boolean expected = false;
 		assertEquals("mutation testing substitute", expected, result);
 	}
 
///////////////////////////////////////////////////////////////////////////

 	//NEW TEST CASE
 	@Test 
 	public void test_equal_aNull(){
 		double[][] a = null;
 		double[][] b = {{2.99, 3.6}, {1.25, 4.2}};
 		assertFalse(DataUtilities.equal(a,  b));
 	}
 	
 	//NEW TEST CASE
 	@Test
 	public void test_equal_differentOuterDimensions() {
 		double[][] a = {{2.99, 3.6}, {1.25, 4.2}};
 		double[][] b = {{2.99, 3.6}, {1.25, 4.2}, {1.0, 2.0}};
 		assertFalse(DataUtilities.equal(a,  b));
 	}
 
///////////////////////////////////////////////////////////////////////////
 	
 	@Test
 	public void test_equal_infValue() {
 		double[][] a = {{Double.POSITIVE_INFINITY, 3.6, 6.9}, {1.25, 4.2, 7.38}};
 		double[][] b = {{Double.POSITIVE_INFINITY, 3.6, 6.9}, {1.25, 4.2, 7.38}};
 		assertTrue(DataUtilities.equal(a,  b));
 	}
 	
 	@Test
 	public void test_equal_nanValue() {
 		double[][] a = {{(0.0/0.0), 3.6, 6.9}, {1.25, 4.2, 7.38}};
 		double[][] b = {{(0.0/0.0), 3.6, 6.9}, {1.25, 4.2, 7.38}};
 		assertTrue(DataUtilities.equal(a,  b));
 	}
 	
 	//Start of clone testing
 	@Test
 	public void test_clone_declare() {
 		double[][] a = {{2.99, 3.6, 6.8}, {1.25, 4.2, 7.38}};
 		double[][] b = DataUtilities.clone(a);
 		assertArrayEquals(a,b);
 	}
 	
 	@Test
 	public void test_clone_reassign() {
 		double[][] a = {{1.1, 1.3}, {1.3, 1.1}};
 		double[][] b = {{2.99, 3.6, 6.8}, {1.25, 4.2, 7.38}};
 		b = DataUtilities.clone(a);
 		assertArrayEquals(a,b);
 	}
 	
 	@Test
 	public void test_clone_increaseDimensions() {
 		double[][] a = {{1.1, 1.3, 4.2}, {1.3, 1.1, 2.5}, {1.5, 4.5, 6.9}};
 		double[][] b = {{2.99, 3.6, 6.8}, {1.25, 4.2, 7.38}};
 		b = DataUtilities.clone(a);
 		assertArrayEquals(a,b);
 	}
 	
 	@Test
 	public void test_clone_removeConditional() {
 		double[][] a = new double[5][5];
 		a[0] = null;
 		double[][] b = DataUtilities.clone(a);
 		double[][] result = new double[5][5];
 		result[0] = null;
 		assertArrayEquals("removing conditional statement to true", result,b);
 	}
 	
 	@Test (expected = IllegalArgumentException.class)
 	public void test_clone_checkingNull() {
 		DataUtilities.clone(null);
 	}
 	
 	@Test
 	public void test_clone_empty() {
 		double[][] a = new double[2][2];
 		double[][] result = DataUtilities.clone(a);
 		assertArrayEquals("Testing for empty array", a, result);
 	}
 	
 	//Start of createNumberArray testing
 	@Test
	public void test_createNumberArray_test() {
		double d1 = 8.0;
		double d2 = 7.0;
		double [] doubles = {8.0, 7.0};
		Number numbers[] = new Number[2];
		numbers[0] = d1;
		numbers[1] = d2;
		Number[] resultArray = DataUtilities.createNumberArray(doubles);
		assertArrayEquals(numbers, resultArray);
	}
	
	@Test
	public void test_createNumberArray_bigNums() {
		double d1 = 888888888;
		double d2 = 777777777;
		double d3 = Double.MAX_VALUE;
		double [] doubles = {888888888, 777777777, Double.MAX_VALUE};
		Number numbers[] = new Number[3];
		numbers[0] = d1;
		numbers[1] = d2;
		numbers[2] = d3;
		Number[] resultArray = DataUtilities.createNumberArray(doubles);
		assertArrayEquals(numbers, resultArray);
	}
	
	@Test
	public void test_createNumberArray_bigNegativeNums() {
		double d1 = -888888888;
		double d2 = -777777777;
		double d3 = Double.MIN_VALUE;
		double [] doubles = {-888888888, -777777777, Double.MIN_VALUE};
		Number numbers[] = new Number[3];
		numbers[0] = d1;
		numbers[1] = d2;
		numbers[2] = d3;
		Number[] resultArray = DataUtilities.createNumberArray(doubles);
		assertArrayEquals(numbers, resultArray);
	}
	
	@Test
	public void test_createNumberArray_millionArray() {
		double doubles[] = new double[1000000];
		Number numbers[] = new Number[1000000];
		int index = 0;
		double nums = 0;
		while (index < 1000000) {
			numbers[index] = nums;
			doubles[index] = nums;
			index++;
			nums++;
		}
		Number[] resultArray = DataUtilities.createNumberArray(doubles);
		assertArrayEquals(numbers, resultArray);
	}
		
	@Test (expected = IllegalArgumentException.class)
	public void test_createNumberArray_nullArray() {
		double doubles[] = null;
		Number[] resultArray = DataUtilities.createNumberArray(doubles);
	}
	
//	@Test
//	public void test_createNumberArray_testNullValue() {
//		double d1 = 8;
//		double d2 = 7;
//		double [] doubles = new double[3];
//		doubles[0] = d1;
//		doubles[1] = d2;
//		Number numbers[] = new Number[3];
//		numbers[0] = d1;
//		numbers[1] = d2;
//		Number[] resultArray = DataUtilities.createNumberArray(doubles);
//		assertArrayEquals(numbers, resultArray);
//	}
	
	//Start of createNumberArray2D testing
	@Test
	public void test_createNumberArray2D_test() {
		double d1 = 8.0;
		double d2 = 7.0;
		double d3 = 6.0;
		double d4 = 5.0;
		double [][] doubles = {{8.0, 7.0},{6.0, 5.0}};
		Number numbers[][] = new Number[2][2];
		numbers[0][0] = d1;
		numbers[0][1] = d2;
		numbers[1][0] = d3;
		numbers[1][1] = d4;
		Number[][] resultArray = DataUtilities.createNumberArray2D(doubles);
		assertArrayEquals(numbers, resultArray);
	}
	
//	@Test
//	public void test_createNumberArray2D_testNullValue() {
//		double d1 = 8;
//		double d2 = 7;
//		double d3 = 6;
//		double [][] doubles = new double[2][2];
//		doubles[0][0] = d1;
//		doubles[0][1] = d2;
//		doubles[1][0] = d3;
//		Number numbers[][] = new Number[2][2];
//		numbers[0][0] = d1;
//		numbers[0][1] = d2;
//		numbers[1][0] = d3;
//		Number[][] resultArray = DataUtilities.createNumberArray2D(doubles);
//		assertArrayEquals(numbers, resultArray);
//	}
	
	
	@Test
	public void test_createNumberArray2D_bigNums() {
		double d1 = 888888888;
		double d2 = 777777777;
		double d3 = Double.MAX_VALUE;
		double d4 = 555555555;
		double [][] doubles = {{888888888, 777777777}, {Double.MAX_VALUE, 555555555}};
		Number numbers[][] = new Number[2][2];
		numbers[0][0] = d1;
		numbers[0][1] = d2;
		numbers[1][0] = d3;
		numbers[1][1] = d4;
		Number[][] resultArray = DataUtilities.createNumberArray2D(doubles);
		assertArrayEquals(numbers, resultArray);
	}
	
	@Test
	public void test_createNumberArray2D_bigNegativeNums() {
		double d1 = -888888888;
		double d2 = -777777777;
		double d3 = Double.MIN_VALUE;
		double d4 = -555555555;
		double [][] doubles = {{-888888888, -777777777}, {Double.MIN_VALUE, -555555555}};
		Number numbers[][] = new Number[2][2];
		numbers[0][0] = d1;
		numbers[0][1] = d2;
		numbers[1][0] = d3;
		numbers[1][1] = d4;
		Number[][] resultArray = DataUtilities.createNumberArray2D(doubles);
		assertArrayEquals(numbers, resultArray);
	}
	
	@Test
	public void test_createNumberArray2D_millionArray() {
		double doubles[][] = new double[1000][1000];
		Number numbers[][] = new Number[1000][1000];
		int x = 0;
		int y;
		double nums = 0;
		while (x < 1000) {
			y = 0;
			while (y < 1000) {
				numbers[x][y] = nums;
				doubles[x][y] = nums;
				y++;
				nums++;
			}
			x++;
		}
		Number[][]resultArray = DataUtilities.createNumberArray2D(doubles);
		assertArrayEquals(numbers, resultArray);
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void test_createNumberArray2D_nullArray() {
		double doubles[][] = null;
		Number[][] resultArray = DataUtilities.createNumberArray2D(doubles);
	}
}
