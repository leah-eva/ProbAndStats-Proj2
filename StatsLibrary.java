/*
 * Sources:
 * 
 * 
 * https://www.geeksforgeeks.org/array-class-in-java/
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.lang.Math;

/**
 * The class StatsLibrary contains methods for performing basic statistical
 * computations such as finding measures of central tendency, set operations,
 * and finding probabilities using standard distributions.
 * 
 * @author leah-eva
 *
 */
public class StatsLibrary {
	
	
	
	/**
	 * This method finds the arithmetic mean of input values. The
	 * arithmetic mean is obtained by dividing the sum of values by the
	 * total count of values.
	 * 
	 * @param inputNumbers An ArrayList of Integer objects representing
	 * 		input values.
	 * @return A double representing the arithmetic mean of the values.
	 */
	public double findMean(ArrayList<Integer> inputNumbers) {
		
		//initiate double sum with value 0
		double sum = 0;
		
		//loop through elements in given ArrayList and add them to the sum
		for(int singleElement: inputNumbers) {
			
			//add element to running sum
			sum += singleElement;
			
		}
		
		//divide sum by total number of values in given ArrayList
		double result = sum / inputNumbers.size();
		
		//return result
		return result;
		
	}
	
	
	
	/**
	 * This method finds the median of input values. The median is obtained 
	 * by sorting the values (increasing or decreasing) and finding the
	 * midpoint of the values.
	 * 
	 * @param inputNumbers An array of doubles representing input values.
	 * @return A double representing the median of the values.
	 */
	public double findMedian(double[] inputNumbers) {
		
		//initiate double result
		double result;
		
		//sort given array
		Arrays.sort(inputNumbers);
		
		//check if number of values in array is odd
		if (inputNumbers.length % 2 != 0) {
			
			//create int index and store index of middle value
			int index = (inputNumbers.length / 2) - 1;
			
			//set result to equal value at int index
			result = inputNumbers[index];
			
		}
		
		//if number of values in array is not odd, it is even
		else {
			
			//create int index1 and store first of two middle values
			int index1 = inputNumbers.length/2 - 1;
			
			//create int index2 and store second of two middle values
			int index2 = inputNumbers.length/2;
			
			//set result to equal sum of middle values divided by 2
			result = (inputNumbers[index1] + inputNumbers[index2]) / 2;
			
		}
		
		//return value of result
		return result;
		
	}
	
	
	
	/**
	 * This method finds the mode of input values. The mode is obtained by
	 * finding the value that occurs the most often. If two values occur the
	 * same number of times, the mode does not exist.
	 * 
	 * @param inputNumbers An array of doubles representing input values.
	 * @return A double representing the mode of the values.
	 */
	public double findMode(double[] inputNumbers) {
		
		//sort given array
		Arrays.sort(inputNumbers);
		
		//create int currentCount to store number of occurrences of values 
		//initialize to 0
		int currentCount = 0;
		
		//create int maxCount to store greatest number of occurrences of a value
		//initialize to 0
		int maxCount = 0;
		
		//create int result to store current mode
		double result = 0;
		
		//loop through indices in sorted array excluding index 0
		for (int i = 1; i < inputNumbers.length - 1;i++) {
			
			//set current count to 1 for each new value
			currentCount = 1;
			
			//while index is in sorted array and previous value equals current
			//value
			while(i < inputNumbers.length && inputNumbers[i-1] 
					== inputNumbers[i]) {
				
				//increment currentCount
				currentCount++;
				
				//increment index
				i++;
				
			}
			
			//check if maximum occurrences of a value equals number 
			// of occurrences of current value
			if (maxCount == currentCount) {
				
				//set result equal to 0 to reflect no mode found
				result = 0;
				
			}
			
			//check if maximum occurrences of a value is less than the 
			// number of occurrences of current value
			else if(maxCount<currentCount) {
				
				//set result equal to current value to reflect new mode
				result = inputNumbers[i - 1];
				
				//set maxCount equal to currentCount to compare with 
				// future values
				maxCount = currentCount;
				
			}

		}
		
		//return value of result
		return result;
		
	}
	
	
	
	/**
	 * This method finds the standard deviation of input values.
	 * 
	 * @param inputNumbers An ArrayList of Integer objects representing 
	 * input values.
	 * @return A double representing the standard deviation of the values.
	 */
	public double findStandardDeviation (ArrayList<Integer> inputNumbers) {
		
		//return the value of the square root of the variance
		return Math.sqrt(findVariance(inputNumbers));
		
	}
	
	
	
	/**
	 * This method finds the variance of input values.
	 * 
	 * @param inputNumbers An ArrayList of Integer objects representing
	 * 		the input values.
	 * @return A double representing the variance of the values.
	 */
	public double findVariance(ArrayList<Integer> inputNumbers) {
		
		//create double mean and set it equal to the mean of given values
		double mean = findMean(inputNumbers);
		
		//create double varianceNumerator to store the numerator of the result
		// and set it equal to 0 for now
		double varianceNumerator = 0;
		
		//loop through values in given ArrayList, inputNumbers
		for(int singleElement: inputNumbers) {
			
			//subtract mean from current value and square it
			//	then add to varianceNumerator
			varianceNumerator += (singleElement - mean)*(singleElement 
					- mean);
			
		}
		
		//create double variance to store final result,
		// the previously calculated numerator divided by one less than
		// the number of values
		double variance = (varianceNumerator / (inputNumbers.size() - 1));
		
		//return value of variance
		return variance;
		
	}
	
	
	
	/**
	 * This method finds the intersection of two discrete lists of values. 
	 * 
	 * @param list1 An ArrayList of Integer objects.
	 * @param list2 Another ArrayList of Integer objects.
	 * @return An ArrayList of Integer objects representing the intersection
	 * 		of list1 and list2.
	 */
	public ArrayList<Integer> findIntersection (ArrayList<Integer> list1, 
			ArrayList<Integer> list2){
		
		//create new ArrayList intersection
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		
		//loop through indices in given list1
		for( int i = 0; i < list1.size(); i++) {
			
			//loop through indices in given list2
			for(int j = 0; j < list2.size(); j++) {
				
				//check if values in both lists are equal
				if(list1.get(i)==list2.get(j)) {
					
					//add common value to ArrayList intersection
					intersection.add(list1.get(i));
					
				}
				
			}
			
		}
		
		//return ArrayList intersection
		return intersection;
		
	}
	
	
	
	/**
	 * This method finds the union of two discrete lists of values.
	 * 
	 * @param list1 An ArrayList of Integer objects.
	 * @param list2 Another ArrayList of Integer objects.
	 * @return An ArrayList of Integer objects representing the union of 
	 * 		list1 and list2.
	 */
	public ArrayList<Integer> findUnion (ArrayList<Integer> list1, 
			ArrayList<Integer> list2){
		
		//create ArrayList tempList
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		
		//loop through given list1
		for(int value: list1) {
			
			//add list1 value to tempList
			tempList.add(value);
			
		}
		
		//loop through given list2
		 for(int value: list2) {
			 
			 //add list2 values to tempList
			 tempList.add(value);
			 
		 }
		 
		 //store all unique values from tempList in result
		 ArrayList<Integer> result = findUniqueValues(tempList);
		 
		 //return value of result
		 return result;
		 
	}
	
	
	
	/**
	 * This method finds and returns an ArrayList of Integer objects that
	 * contains only unique elements of a given ArrayList of Integer objects. 
	 * 
	 * @param inputValues An ArrayList of Integer objects.
	 * @return An ArrayList of unique Integer objects.
	 */
	public ArrayList<Integer> findUniqueValues(ArrayList<Integer> 
		inputValues) {
		
		//Store shallow copy of ArrayList inputValues in 
		// new ArrayList uniqueValues
		ArrayList<Integer> uniqueValues = 
				(ArrayList<Integer>) inputValues.clone();
		
		//sort ArrayList uniqueValues
		//https://www.javatpoint.com/how-to-sort-arraylist-in-java
		Collections.sort(uniqueValues);
		
		//loop through indices in uniqueValues
		for(int i = 1; i < uniqueValues.size(); i++) {

			//create int firstValue to store value at previous index
			int firstValue = uniqueValues.get(i-1);

			//create int secondValue to store value at current index
			int secondValue = uniqueValues.get(i);

			//check if value at previous index equals value at current index
			if(firstValue == secondValue) {

				//remove duplicate value at current index
				uniqueValues.remove(i);

				//decrement index pointer to account for removing a value
				i--;

			}

		}
		
		//return uniqueValues which now holds given values without repetition
		return uniqueValues;
		
	}
	
	
	
	/**
	 * Finds the complement of a "sublist" given a "sublist" and a 
	 * corresponding "universal list". This is analogous to a subset and 
	 * universal set but named differently to avoid confusing with the 
	 * popular Set interface (java.util.Set).
	 * 
	 * @param universalList An ArrayList of Integer objects representing the 
	 * 		universal list.
	 * @param subList An ArrayList of Integer objects representing the 
	 * 		subList.
	 * @return An ArrayList of Integer objects representing the complement
	 * 		of the sublist.
	 */
	public ArrayList<Integer> findComplement(ArrayList<Integer> 
		universalList, ArrayList<Integer> subList){
		
		//initialize result list to copy universalList
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//copy 
		for(int value: universalList) {
			result.add(value);
		}
		
		//loop through subList values
		for(Integer value: subList) {
			
			//remove subList values from copy of universalList
			universalList.remove(value);
		
		}
		
		return universalList;
		
	}

	
	
	/**
	 * This method finds the factorial of an input number recursively.
	 * 
	 * 
	 * @param inputNumber An integer value to take the factorial of.
	 * @return A BigInteger representing the factorial of the value.
	 */
	public BigInteger findFactorial (int inputNumber){
		
		//base case
		if(inputNumber == 1 || inputNumber == 0) {
			
			//convert integer 1 to BigInteger
			BigInteger factorial = BigInteger.valueOf(1);
			
			return factorial;
			
		}
		
		//recursive case
		else {
			
			return BigInteger.valueOf(inputNumber).multiply(findFactorial(
					(inputNumber) - 1));
			
		}
		
	}
	
	
	
	/**
	 * This method finds the number of possible combinations of a specific 
	 * number of objects chosen from a total number of objects.
	 * 
	 * @param n The total number of objects.
	 * @param r The number of objects chosen.
	 * @return A BigInteger representing the number of possible combinations.
	 */
	public BigInteger findNumberOfCombinations (int n, int r) {
		
		//use formula to get result
		return findFactorial(n).divide(findFactorial(r).multiply(
				findFactorial(n - r)));
		
	}
	
	
	
	/**
	 * This method finds the number of possible permutations of a specific
	 * number of objects chosen from a total number of objects.
	 * 
	 * @param n The total number of objects.
	 * @param r The number of objects chosen.
	 * @return A BigInteger representing the number of possible 
	 * permutations.
	 */
	public BigInteger findNumberOfPermutations (int n, int r) {
		
		//use formula to get result
		return findFactorial(n).divide(findFactorial(n - r));
		
	}
	
	
	
	/**
	 * This method finds the probability of a specified number of 
	 * successes in a binomial distribution, given the number of trials, the 
	 * number of successes, and the probability of success for one event.
	 * 
	 * @param n The number of trials.
	 * @param y The number of successes.
	 * @param p A double representing the probability of success.
	 * @return A double representing the probability of y successes.
	 */
	public double findProbabilityBinomial (int n, int y, double p) {
		
		//calculate value of combination part
		double combinationValue = findNumberOfCombinations(n,y).doubleValue();
		
		//calculate probability of failure
		double q = 1 - p;
		
		//use formula to get result
		return combinationValue*Math.pow(p, y)*Math.pow(q, (n-y));
		
	}
	
	
	
	/**
	 * This method finds the probability of obtaining a first success after
	 * specified number of trials in a geometric distribution, given the 
	 * number of trials carried out up to and including the first success, 
	 * and the probability of success for one event.
	 * 
	 * @param y The number of trials carried out up to and including the 
	 * 		first success.
	 * @param p A double representing the probability of success for one
	 * 		event.
	 * @return A double representing the probability of first success on the
	 * 		y'th trial.
	 */
	public double findProbabilityGeometric (int y, double p) {
		
		//calculate probability of failure
		double q = 1 - p;
		
		//use formula to get result
		return Math.pow(q, y - 1)* p;
		
	}
	
	
	
	/**
	 * This method finds the probability of an event using a Hypergeometric
	 * 	probability distribution.
	 * 
	 * @param N The population size.
	 * @param n The sample size.
	 * @param r The number of successes in the population.
	 * @param y A random variable.
	 * @return A double representing the probability.
	 */
	public double findProbabilityHypergeometric (int N, int n, int r, int y) {
		
		double C1 = findNumberOfCombinations(r,y).doubleValue();
		double C2 = findNumberOfCombinations((N-r),(n-y)).doubleValue();
		double C3 = findNumberOfCombinations(N,n).doubleValue();
		
		return (C1*C2)/(C3);
		
	}
	
	
	
	/**
	 * This method finds the probability of an event using a Poisson 
	 * 	distribution.
	 * 
	 * @param lambda The average value of the random variable.
	 * @param y      The random variable.
	 * @return		 A double representing the probability.
	 */
	public double findProbabilityPoisson (int lambda, int y) {
		
		
		return ((Math.pow(lambda, y))/findFactorial(y).doubleValue())
				* Math.pow(Math.E, (-1*lambda));
		
	}
	
	
}