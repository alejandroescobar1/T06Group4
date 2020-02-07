/* CourseCalculator.java
 * 
 * This program calculates your final grade for CPSC 233 as a weighted average
 * given a set of raw grades in each of five grading categories and the corresponding
 * weights.
 * 
 * Recall that you will have:
 *   10 Individual Assignments (10% or 0.1 of your overall grade)
 *   11 Individual Quizzes (20% or 0.2 of your overall grade)
 *   6 Coding Challenges (30% or 0.3 of your overall grade)
 *   10 Team Quizzes (10% or 0.1 of your overall grade)
 *   1 Team Project (30% or 0.3 of your overall grade)
 */

public class CourseCalculator {

	// TODO: these variables should no longer be public (use the default visibility for now)
	// or static

	double[] iAssignmentGrades = {2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0};
	double[] iQuizGrades = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
	double[] iCodingChallengeGrades = {3.0, 3.0, 3.0, 3.0, 3.0, 3.0};
	double[] tQuizGrades = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
	double tProjectGrade = 1.0;
	double finalGrade = 3.3;
	
	
	// Constructor for the class. Do not modify.	
	public CourseCalculator()
	{
		calculateFinalGrade();
	}
	
	
	// TODO: implement similar methods for each of the other grade categories:
	// iQuizGrades
	// iCodingChallengeGrades
	// tQuizGrades
	// tProjectGrade
	// Don't forget to add an appropriate comment block
				
	public double calculateIAssignmentGrade(double [] rawGrades)
	{
		final double iAssignmentGradeWeight = 0.1;
		return findAverageGrade(rawGrades) * iAssignmentGradeWeight;
	}
	public double calculateIQuizGrade(double[] iQuizRaw) {
		final double iQuizGradeWeight = 0.2;
		return findAverageGrade(iQuizRaw)*iQuizGradeWeight;
	}
	public double calculateICodingChallengeGrade(double[] iCodingChallengeRaw) {
		final double iCodingChallengeWeight = 0.3;
		return findAverageGrade(iCodingChallengeRaw)*iCodingChallengeWeight;
	}
	public double calculateTQuizGrade(double[] tQuizRaw) {
		final double tQuizGradeWeight = 0.1;
		return findAverageGrade(tQuizRaw)*tQuizGradeWeight;
	}
	public double calculateTProjectGrade(double tProjectRaw) {
		final double tProjectGradeWeight = 0.3;
		return tProjectRaw*tProjectGradeWeight;
	}
	

	// You should refer to this method to help you understand how each of the 
	// methods it calls should be implemented.
	// DO NOT MODIFY.
	public void calculateFinalGrade()
	{
		finalGrade = calculateIAssignmentGrade(iAssignmentGrades) +
				calculateIQuizGrade(iQuizGrades) +
				calculateICodingChallengeGrade(iCodingChallengeGrades) +
				calculateTQuizGrade(tQuizGrades) + 
				calculateTProjectGrade(tProjectGrade);
	}
	
	// Provided only to help your main method run. 
	// You may modify this, but I do not recommend it
	
	public String toString()
	{
		return "Your final grade will be " + finalGrade;
	}
		


	/* This method should calculate the mean of all the values in the array.
	 * 
	 * To do this, you should sum all the values in the array and divide 
	 * this sum by the number of values in the array
	 * 
	 * DO NOT MODIFY THIS METHOD
	 * 
	 *  @param An array of doubles containing the raw grades to be averaged 
	 * 	@return The mean of the values contained in the input array
	 */
	
	
	public double findAverageGrade(double [] rawGrades)
	{
		double mean = 0.0;
		double sum = 0.0;
		
		// your code must go here
		for (int gradeCounter = 0; gradeCounter < rawGrades.length; gradeCounter++)
		{
			sum += rawGrades[gradeCounter];
		}
		
		mean = sum / rawGrades.length;
				
		// include a check: if your mean is greater than 4.0 or less than 0.0
		// have the method return 0
		if ((mean < 0.0) || (mean > 4.3))
		{
			mean = 0.0;
		}
	
				
		return mean;
	}
	
	// Provided for your convenience only, to help you understand
	//    how the code is put together. You may modify this.
	
	public static void main(String[] args) {
		
		CourseCalculator myCourseCalculator = new CourseCalculator();
		System.out.println(myCourseCalculator.toString());

	}
	
}


