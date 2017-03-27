/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 * The CalcTotals class is used to calculate the total score for the quizzes and
 * assignments. By carefully combining functionality there only needs to be one
 * major function called calcTotalScore with parameters that identify if it is
 * supposed to calculate the quiz or assignment total.
 * 
 * @version : - * 14.13 - 12/02/2014 09:00
 * @author : - Amir Torabi
 * 
 *         <dt><span class="strong">See Also:</span></dt>
 *         <dd>: - Serialized Form</dd>
 * 
 *         <dt><span class="strong">Studentid:</span></dt>
 *         <dd>: - 5293010</dd>
 * 
 *         <dt><span class="strong">Email:</span></dt>
 *         <dd>: - torabi10@gmail.com</dd>
 * 
 *         <dt><span class="strong">Assignment.number:</span></dt>
 *         <dd>: - A19015-02</dd>
 * 
 * 
 */
public class CalcTotals implements CALCTotalsTemplate {

	private String strDatabaseName;
	private ArrayList<String> colFieldNames;

	/**
	 * This class have a constructor that accept the database name as a string
	 * and load it into a class level variable called strDatabaseName. This
	 * database name will be used by calcTotalScore to open the database.
	 * 
	 * 
	 */
	public CalcTotals(String strVar) {
		strDatabaseName = strVar;
	}

	/**
	 * This method calls calcTotalScore with the student ID along with a
	 * parameter of "Q".
	 * 
	 * @specified by calcTotalQuiz in interface CalcTotalsTemplate
	 * 
	 * @param strStudentID
	 *            - used to look up the record in database
	 * 
	 * @return total points earned from quiz scores which will be less than 31.
	 */

	public double calcTotalQuiz(String strStudentID) {
		return calcTotalScore(strStudentID, "Q");
	}

	/**
	 * This method calls calcTotalScore with the student ID along with a
	 * parameter of "A".
	 * 
	 * @param strStudentID
	 *            - used to look up the record in database
	 * 
	 * @return total points earned from calcTotalScore.
	 */

	public double calcTotalAsgn(String strStudentID) {
		return calcTotalScore(strStudentID, "A");
	}

	/**
	 * TThis method sums the total from the calcTotalQuiz and calcTotalAsgn
	 * functions then adds 48 before returning the total.
	 * 
	 * @param strStudentID
	 *            - used to look up the record in database
	 * 
	 * @return total points earned will be less than 100
	 */

	public double calcTotal(String strStudentID) {
		return calcTotalQuiz(strStudentID) + calcTotalAsgn(strStudentID) + 48;
	}

	/**
	 * This method accepts the total points the student has earned and returns a letter grade. This is done by dividing the total by 10 and using the integer result to index into a string of letter grades. Something like: strGrades = "FFFFFFDCBAA"; intPos = dblTotal / 10; strLetter = strGrades.substring(intPos, intPos+1);
	 * 
	 * @param dblTotal - total points student has earned
	 * 
	 * @return single letter grade
	 */

	public String getLetterGrade(double dblTotal) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * The purpose of method is to lookup the studentID in the database and
	 * calculate either the total of the quizzes or the total of the assignments
	 * based on the prefix parameter.
	 * 
	 * @param strStudentID
	 *            - student's ID number strPrefix - either a "Q" or an "A" for
	 *            quizzes or assignments respectively
	 * 
	 * @return For Quizzes a number up to 30, for Assignments a number up to 70
	 */

	public double calcTotalScore(String strStudentID, String strPrefix) {
		double dblTotal = 0;
		DB2 db = new DB2();
		db.openConnection(strDatabaseName);
		String strSQL = "SELECT * FROM grades WHERE stuid='" + strStudentID + "'";
		// create an array of 20 int called aryPoints
		int[] aryPoints = new int[20];
		// initialize aryPointsQ
		int[] aryPointsQ = new int[20];
		// initialize aryPintsA
		int[] aryPointA = new int[20];
		db.query(strSQL);
		if (db.moreRecords()) {
			if (strPrefix.equals("Q")) {
				aryPoints = aryPointsQ;
			} else {
				aryPoints = aryPointA;
			}
			for (int x = 1; x < 15; x++) {
				String strFieldName = strPrefix + String.format("%02d", x);
				double dblTemp = Double.parseDouble(db.getField(strFieldName));
				dblTotal = dblTotal + ((dblTemp / 100) * aryPoints[x]);
			}
		}
		db.close();

		return dblTotal;
	}
	/**
	 * The purpose of this method is to display a given debugging message to the
	 * output window of the compiler
	 * 
	 * @param strVar - message to be displayed
	 *
	 */

	public void status(String strVar) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
