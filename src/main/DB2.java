/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of this class is to provide a generic database interface for
 * DERBY databases.
 *
 @version : - * 14.13 - 12/02/2014 09:00
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
public class DB2 implements DB2Template {
	// origional : "jdbc:derby://localhost:1527/#####;create=true;"
	private static final String dbURL = "jdbc:derby:#####;create=true;";

	DatabaseMetaData md;
	ResultSet rs;

	// jdbc Connection
	private static Connection conn = null;
	private static Statement stmt = null;

	/*
	 * @see main.DB2Template#openConnection(java.lang.String)
	 *
	 */
	/**
	 * The purpose of this method is to accept the filename of the Microsoft
	 * Access database and open a connection to it.
	 * 
	 * @specified openConnection in interface DB2Template
	 * 
	 * @param strDatabaseName
	 *            - the name of the database being used
	 * 
	 * @return true if open was successful, otherwise false
	 */
	public boolean openConnection(String strDatabaseName) {

		boolean flag = false;
		try {

			Class.forName("org.apache.derby.jdbc.ClientDriver");
			// Get a connection
			conn = DriverManager.getConnection(dbURL.replace("#####", strDatabaseName));
			flag = true;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	/**
	 * The purpose of this method is to accept an SQL statement and query (view
	 * only) the dataset using the executeReader method
	 * 
	 * @specified query in interface DB2Template
	 * 
	 * @param strSQL
	 *            - a fully formed SQL statement
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean query(String strSQL) {
		boolean flag = false;
		try {
			stmt = conn.createStatement();
			stmt.execute(strSQL);
			this.rs = stmt.getResultSet();
			flag = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	/**
	 * The purpose of this method is to accept an SQL statement and update the
	 * dataset using the executeNonQuery method
	 * 
	 * @specified execute in interface DB2Template
	 * 
	 * @param strSQL
	 *            - a fully formed SQL statement
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean execute(String strSQL) {
		boolean flag = false;
		try {
			stmt = conn.createStatement();

			stmt.executeUpdate(strSQL);
			System.out.println("Running successfully");
			this.rs = stmt.getResultSet();
			System.out.println("Ran successfully");
			flag = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	/**
	 * The purpose of this method is to execute a read() method on the dataset
	 * and return a Boolean which indicates whether or not there are any more
	 * records in the dataset. Otherwise it is to return false
	 * 
	 * @specified moreRecords in interface DB2Template
	 * 
	 * 
	 * @return true if there are more records in dataset, otherwise false
	 */
	public boolean moreRecords() {
		if (this.rs != null) {
			try {

				return this.rs.next();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * The purpose of this method is to accept the name of the filed and return
	 * the contents of the field from the dataset for the current record
	 * 
	 * @specified getField in interface DB2Template
	 * 
	 * @param strFieldName
	 *            - the name of a field within the table
	 * 
	 * @return the contents of the field
	 */
	public String getField(String strFieldName) {
		if (this.rs != null) {
			try {

				return (String) this.rs.getObject(strFieldName);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return "";

	}

	/**
	 * The purpose of this method is to accept an integer number indicating the
	 * position of the field within the dataset and return the field name of the
	 * field
	 * 
	 * @specified getFieldName in interface DB2Template
	 * 
	 * @param intFieldNum
	 *            - the position number of the field
	 * 
	 * @return the contents of the field
	 */
	public String getField(int intFieldNum) {
		if (this.rs != null) {
			try {

				return (String) this.rs.getObject(intFieldNum);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * The purpose of this method is to terminate the connection to the
	 * database.
	 * 
	 * @specified close in interface DB2Template
	 * 
	 */
	public void close() {
		try {
			if (this.stmt != null && !this.stmt.isClosed())
				this.stmt.close();
			if (this.rs != null && !this.rs.isClosed())
				this.rs.close();
			if (this.conn != null && !this.conn.isClosed())
				this.conn.close();

		} catch (SQLException ex) {

		}

	}

	/**
	 * The purpose of this method is to delete all of the records that meed a
	 * specific condition. If no condition is specified than all records are
	 * deleted
	 * 
	 * @specified deleteAll in interface DB2Template
	 * 
	 * @param strTableName
	 *            - the TableName followed by conditions
	 * 
	 */
	public void deleteAll(String strTable) {
		try {
			Statement statement = this.conn.createStatement();
			String strQRY = "DELETE FROM " + strTable;
			statement.executeUpdate(strQRY);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * The purpose of this method is to build and execute an SQL command that
	 * will look up a specific record in the database. If the record does not
	 * exist, it will create a blank record and update the key field. If the
	 * record already exists in the database, the method just returns to the
	 * calling program without updating the database.
	 * 
	 * @specified checkRecord in interface DB2Template
	 * 
	 * @param strTableName
	 *            - name of the table like grades or roster strKeyName - name of
	 *            the field the db is index on, like stuid strKeyContents - this
	 *            is likely the studentID
	 * 
	 * @return true if record added, false if record not added
	 */
	public boolean checkRecord(String strTable, String strKeyName, String strKeyContents) {

		String checkRecord = "INSERT INTO " + strTable + " ( " + strKeyName + " ) " + "  VALUES  ( '" + strKeyContents
				+ "' ) ";
		System.out.println(checkRecord);
		return this.query(checkRecord);
		// return false;

	}

	/**
	 * The purpose of this method is to update a specific field within a specific record in the database
	 * 
	 * @specified setField in interface DB2Template
	 * 
	 * @param strTableName - name of the table like grades or roster
strKeyName - name of the field the db is index on, like stuid
strKeyContents - this is likely the studentID
strFieldName - field to be updated
strFieldContents - contents of the field
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean setField(String strTable, String strKeyName, String strKeyContents, String strFieldName,
			String strFieldContents) {

		String checkRecord = " UPDATE " + strTable + " SET " + strFieldName + " = '" + strFieldContents + "' WHERE "
				+ strKeyName + " =  '" + strKeyContents + "' ";

		System.out.println(checkRecord);

		return this.query(checkRecord);
		// return false;
	}

	/**
	 * This method return the number of records in the active dataset
	 * 
	 * @specified by getDBRecordCount in interface  DB2Template
	 * 
	 * @param strStudentID
	 *            - used to look up the record in database
	 * 
	 * @return number of records in the dataset as an integer
	 */
	public int getDBRecordCount(String strTableName) {
		int size = -1;
		if (this.rs != null) {
			try {
				rs.last();
				size = rs.getRow();
				rs.beforeFirst();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return size;
	}

	/**
	 * The purpose of this method is to display a message on the system console for debugging purposes
	 * 
	 * @specified status in interface DB2Template	
	 * 
	 * @param strStudentID
	 *            - used to look up the record in database
	 * 
	 * @return strMsg - whatever you want displayed
	 */
	public void status(String strVar) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
