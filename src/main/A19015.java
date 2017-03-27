/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJDialog.java
 *
 * Created on May 12, 2016, 1:20:51 AM
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The purpose of this class is to generate a form with a combobox, six buttons
 * and several labels which load a roster and grades table within the a student
 * database and calculate the scores for quizzes and assignments..
 * 
 *  @version : - * 14.13 - 12/02/2014 09:00
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
public class A19015 extends javax.swing.JDialog {

	static final String strDatabaseName = "mydb";
	private ArrayList<String> colFieldNames;

	/** Creates new form NewJDialog */
	public A19015(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		colFieldNames = new ArrayList<String>();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		CreateTableEvent = new javax.swing.JButton();
		PopulateGradesEvent = new javax.swing.JButton();
		PopulateComboboxEvent = new javax.swing.JButton();
		CreateReportEvent = new javax.swing.JButton();
		ExitEvent = new javax.swing.JButton();
		PopulateRosterEvent = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("San Diego Miramar College");

		jLabel5.setText("Student ID");

		jLabel6.setText("Total Quizzes");

		jLabel7.setText("Total Assignments");

		jLabel8.setText("Total Score");

		jLabel9.setText("Letter Grade");

		jLabel14.setText("");

		jLabel13.setText("");

		jLabel12.setText("");

		jLabel11.setText("");

		jLabel10.setText("");

		jLabel2.setText("Select Student");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});

		jLabel3.setText("Email:");

		jLabel4.setText("");

		CreateTableEvent.setText("Create Tables");
		CreateTableEvent.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CreateTableEventActionPerformed(evt);
			}
		});

		PopulateGradesEvent.setText("Populate Grades");
		PopulateGradesEvent.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PopulateGradesEventActionPerformed(evt);
			}
		});

		PopulateComboboxEvent.setText("Populate ComboBox");
		PopulateComboboxEvent.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PopulateComboboxEventActionPerformed(evt);
			}
		});

		CreateReportEvent.setText("Create Reports");
		CreateReportEvent.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CreateReportEventActionPerformed(evt);
			}
		});

		ExitEvent.setText("Exit");
		ExitEvent.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ExitEventActionPerformed(evt);
			}
		});

		PopulateRosterEvent.setText("Populate Roster");
		PopulateRosterEvent.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PopulateRosterEventActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(72, 72, 72)
						.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addGap(76, 76, 76))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup().addGap(38, 38, 38).addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 167,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51,
										Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabel10))
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabel11))
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabel12))
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabel13))
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabel14))))
								.addComponent(jLabel3))
						.addContainerGap())
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(CreateTableEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 191,
										javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(PopulateRosterEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 191,
								javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(PopulateGradesEvent,
										javax.swing.GroupLayout.PREFERRED_SIZE, 191,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(PopulateComboboxEvent, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 198,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(ExitEvent, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 198,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(CreateReportEvent, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 198,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(54, 54, 54)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(jLabel10))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(jLabel11))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(jLabel12))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8).addComponent(jLabel13))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9).addComponent(jLabel14)))
						.addGroup(layout.createSequentialGroup().addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(44, 44, 44)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(CreateTableEvent).addComponent(PopulateComboboxEvent))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(PopulateGradesEvent).addComponent(CreateReportEvent))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(PopulateRosterEvent).addComponent(ExitEvent))
				.addContainerGap(40, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	/**
	 * Spec #13 - Combobox Event - The purpose of this event is to grab the
	 * selectedItem from the combobox and look up the student's record in the
	 * database then populate the screen fields.
	 * 
	 */
	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		String strRecord = (String) this.jComboBox1.getSelectedItem();
		String aryFields[] = strRecord.split(" ");
		if (strRecord.split(" ").length == 2) {
			String lname = strRecord.split(" ")[0], fname = strRecord.split(" ")[1];
			System.out.println(lname + " " + fname);
			// DB2 db = new DB2();
			// db.openConnection(strDatabaseName);
			// String strTableName = "select stuid, email from roster where
			// lastname = '" + lname + "' AND firstname = '"
			// + fname + "' ";
			// try {
			// db.execute(strTableName);
			// db.getField(1);
			// db.getField(2);
			// } catch (Exception ex) {
			// ex.printStackTrace();
			// }
			// db.close();
			//
			// CalcTotals ct = new CalcTotals(strDatabaseName);
			// ct.calcTotal("");

			// ct.calcTotal(strStudentID);
		}

	}

	/**
	 * Spec #7 - Create Tables Button
	 * 
	 */
	private void CreateTableEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CreateTableEventActionPerformed
		// TODO add your handling code here:

		DB2 db = new DB2();
		db.openConnection(strDatabaseName);

		String strTableName = "ROSTER";

		try {
			db.execute("DROP TABLE " + strTableName);
			db.execute(createTableSQL(strTableName));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		strTableName = "GRADES";
		try {
			db.execute("DROP TABLE " + strTableName);
			db.execute(createTableSQL(strTableName));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		db.close();

	}// GEN-LAST:event_CreateTableEventActionPerformed

	private void PopulateGradesEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_PopulateGradesEventActionPerformed
		// TODO add your handling code here:
		processFile("GRADES");
	}// GEN-LAST:event_PopulateGradesEventActionPerformed

	private void PopulateRosterEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_PopulateRosterEventActionPerformed
		// TODO add your handling code here:
		processFile("ROSTER");
	}// GEN-LAST:event_PopulateRosterEventActionPerformed

	private void PopulateComboboxEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_PopulateComboboxEventActionPerformed
		// TODO add your handling code here:
		/*
		 * declare your DB2 object open the database create an SQL statement
		 * that will select all records in the roster table and sort it by the
		 * lastname and then by the firstname hand your SQL statement to the DB2
		 * object query method loop through the dataset using moreRecords inside
		 * the loop add the trimmed contents of the lastname a space an then the
		 * firstname to the combobox
		 */

		DB2 dbObj = new DB2();
		dbObj.openConnection(strDatabaseName);
		String sqlStatment = "select lastname , firstname from roster";
		dbObj.query(sqlStatment);
		// this.jComboBox1.removeAllItems();
		int index = 0;
		while (dbObj.moreRecords()) {

			String lname = dbObj.getField(1).trim();
			String fname = dbObj.getField(2).trim();
			this.jComboBox1.insertItemAt(lname + " " + fname, index++);
			// this.jComboBox1.insertItemAt(item, index);

		}

		dbObj.close();
	}// GEN-LAST:event_PopulateComboboxEventActionPerformed

	private void CreateReportEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CreateReportEventActionPerformed
		// TODO add your handling code here:
		/*
		 * Ok here is where you show me you are starting to understand this
		 * stuff. create an SQL command that will download all of the records
		 * from the GRADES table declare your DB2 object open a text file for
		 * output and call it Module15Output.txt open the database loop through
		 * the database write one record for each student and write the
		 * following fields all separated by semi-colons and each record
		 * separated by a carriage return / line feed. In other words, use write
		 * for each field and one writeline at the end of the fields: trimmed
		 * student id trimmed lastname trimmed firstname total of quizzes (see
		 * CALCTOTAL class) total of assignments (see CALCTOTAL class) total of
		 * both quizzes and assignments (see CALCTOTAL class) letter grade (see
		 * CALCTOTAL class) don't forget to close your database and your output
		 * file
		 */

		String sql = "select * from GRADES";
//		DB2 dbObj = new DB2();
//		dbObj.openConnection(strDatabaseName);
//		dbObj.query(sql);
//		dbObj.getDBRecordCount(strDatabaseName);
		
//		File f = new File("Module15Output.txt");
//		Scanner s = new Scanner(f);
//
//		while (s.hasNextLine()) {
//			String str[] = s.nextLine().split(";");
//			System.out.println(str.length + "  , " + colFieldNames.size());
//			if (str.length + 1 >= colFieldNames.size()) {
//				dbObj.checkRecord(strTableName, "stuid", str[0]);
//
//				for (int i = 1; i < colFieldNames.size(); i++) {
//
//					dbObj.setField(strTableName, "stuid", str[0], colFieldNames.get(i), str[i]);
//				}
//			}
//
//		}
//		s.close();
//		dbObj.close();

	}// GEN-LAST:event_CreateReportEventActionPerformed

	private void ExitEventActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ExitEventActionPerformed
		// TODO add your handling code here:
		System.exit(0);
	}// GEN-LAST:event_ExitEventActionPerformed

	/**
	 * Spec #14 - ProcessFile() The purpose of this method is to open a data
	 * file and update the database with that data. The filename is based on the
	 * table name. This routine also uses INET2.getNetFile method which checks
	 * to see if the file exists and if it doesn't it downloads it from the
	 * Internet.
	 * 
	 * @param strTableName
	 *            - the name of the database table like grades or roster
	 */
	void processFile(String strTableName) {
		/*
		 * declare your variables call loadFieldNames with your table name as
		 * the parameter (see spec below) call getNetFile from your INET2 class
		 * with the table name and "data" as the second parameter to represent
		 * the type of file we want. declare and open your database read the
		 * text file (see Lecture notes for Module 09) line by line. Instead of
		 * AddRecord we are going to use checkRecord from our DB2 class.
		 * 
		 * ' declare your scanner object ' open the text file for input - note
		 * that the return value for the getNetFile is the file name for this
		 * table. Nice huh! ' loop through the file ' strRecord =
		 * inputfile.readline ' split strRecord - see above only this time the
		 * delimeter is a semi-colon. ' call your checkRecord method (you will
		 * need the table name, the name of the key field which is stuid and the
		 * contents of the key field which is aryFields(0) ' here is the tricky
		 * part. You want to populate the rest of the fields without a lot of
		 * hassle. ' The loadFieldNames loaded up your arraylist with all of the
		 * field names. ' When you read each record from the data file, split
		 * the record into an array using a semi-colon as a delimiter ' Next
		 * loop through the aryFields object and setField for each field in the
		 * record ' end of your loop ' close your reader ' close your database
		 */
		try {
			loadFieldNames(strTableName);
			INET2 obje = new INET2();
			String fileName = obje.getNetFile(strTableName, "data");

			DB2 dbObj = new DB2();
			dbObj.openConnection(strDatabaseName);

			File f = new File(fileName);
			Scanner s = new Scanner(f);

			while (s.hasNextLine()) {
				String str[] = s.nextLine().split(";");
				System.out.println(str.length + "  , " + colFieldNames.size());
				if (str.length + 1 >= colFieldNames.size()) {
					dbObj.checkRecord(strTableName, "stuid", str[0]);

					for (int i = 1; i < colFieldNames.size(); i++) {

						dbObj.setField(strTableName, "stuid", str[0], colFieldNames.get(i), str[i]);
					}
				}

			}
			s.close();
			dbObj.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Spec #15 - Load Field Names - The purpose of this routine is to create an
	 * arraylist (collection) of field names from the schema file for use later
	 * in the program.
	 * 
	 * @param strTableName
	 *            - the name of the database table like grades or roster
	 */
	public void loadFieldNames(String strTableName) {
		colFieldNames.clear();
		INET2 obje = new INET2();
		String content = obje.getFromFile(obje.getNetFile(strTableName, "schema"));

		String aray[] = content.split("\n");
		for (int i = 10; i < aray.length; i++) {

			colFieldNames.add(aray[i].split(" ")[0]);

		}

		System.out.println(colFieldNames.toString());

		/*
		 * clear the arraylist call getNetFile in your INET2 class with your
		 * table name and "schema" as a file type loop through the schema text
		 * file remember to skip the first 10 records remember to check to see
		 * if the record length is greater than 5 (there are some blank records
		 * at the end of the schema file that mess things up) split each record
		 * (you should be an expert at this by now) keeping in mind that the
		 * schema file has records that are separated by a space add the first
		 * field from aryFields to your collection (collections are discussed on
		 * pg 753) end of loop close your text file
		 */
	}

	/**
	 * Spec #17 - Create the file name for the schema file for this table Using
	 * your INET class, check to see if the file exists locally and if it does
	 * not download it from the Internet. Build the SQL to create that table and
	 * the fields within it. Return the SQL command as a string.
	 * 
	 * @param strTableName
	 *            - the name of the database table like grades or roster
	 * 
	 * @return a fully formed SQL command to create a new table with fields
	 */

	public String createTableSQL(String strTableName) {
		/*
		 * Initialize your strSQL variable to "" call getNetFile with your table
		 * name and "schema" as a file type. Remember this function returns the
		 * file name that you can use later in this function. again you are
		 * going to use the streamReader open your text file. you got the file
		 * name from getNetFile() loop through your text file because this is
		 * the schema file, skip the first 10 records and check to make sure the
		 * length of each record is over 5 split the record using a space as a
		 * delimiter append the field name and the length of the field to the
		 * strSQL string end of loop next we need to take the strSQL string and
		 * put CREATE TABLE in front of it along with the table name then chop
		 * off the last two characters to get rid of the last comma. finally
		 * return strSQL
		 */
		String strSQL = "";
		try {
			INET2 obj = new INET2();
			String fileName = obj.getNetFile(strTableName, "schema");

			File f = new File(fileName);
			Scanner s = new Scanner(f);
			int i = 1;
			while (s.hasNext()) {
				String content = s.nextLine();
				if (i++ > 10 && content.length() > 5) {
					String[] arr = content.split(" ");
					strSQL += arr[0] + " " + arr[1] + " , ";
				}
			}

			strSQL = "CREATE TABLE " + strTableName + " ( " + strSQL.subSequence(0, strSQL.length() - 2) + " ) ";
			System.out.println(strSQL);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		return strSQL;
	}

	/**
	 * The purpose of this method is to display a message on the system console
	 * for debugging purposes. This is not part of the spec but it sure makes
	 * debugging easier.
	 * 
	 * @param: strMsg
	 *             - whatever you want displayed
	 */

	public void status(String strMsg) {

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				A19015 dialog = new A19015(new javax.swing.JFrame(), true);
				// System.out.println(dialog.createTableSQL("roster"));
				// dialog.createTableSQL("roster");
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {

					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});

	}

	// Variables declaration - do not modify
	private javax.swing.JButton CreateReportEvent;
	private javax.swing.JButton CreateTableEvent;
	private javax.swing.JButton ExitEvent;
	private javax.swing.JButton PopulateComboboxEvent;
	private javax.swing.JButton PopulateGradesEvent;
	private javax.swing.JButton PopulateRosterEvent;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	// End of variables declaration
}
