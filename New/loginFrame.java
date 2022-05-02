import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;


// importing the classes needed to build the ui and use certian functions

// main class jframe for the UI window
public class loginFrame extends JFrame {

	// panel where content is displayed
	private JPanel contentPane;

	/**
	 * Launch the application. <- used window builder
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame loginFrame = new loginFrame();
					loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. <- used window builder
	 */
	// window constructor
	public loginFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// message user sees when they log in
		JLabel panelMessage = new JLabel("Welcome to the Book Store application, please log in.");
		panelMessage.setHorizontalAlignment(SwingConstants.CENTER);
		panelMessage.setBounds(10, 11, 414, 30);
		contentPane.add(panelMessage); // add the element given the above parameters 
		
		// combo box used to display different users as list does not work well with absolute positioning layout
		DefaultComboBoxModel listUsers = new DefaultComboBoxModel(); // this type of combo box allows the scanner to write the elements inside it
    	try {
		      File accountRead = new File("UserAccounts.txt"); // the file class opens the text file
		      Scanner myReader = new Scanner(accountRead); // the scanner reads the file
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine(); // reads
		        String[] temp = data.split(","); // and stores each line splitting at each comma followed by a space character
		        String userID = temp[0];
		        String username = temp[1]; 
		        String userType = temp[6]; // placing them into an array allowing entire parts of the database to be used at once
		    
		        listUsers.addElement(userID + " -" + username + " -" + userType); // listing them in the combo box
		      }
		      myReader.close();
		      // debug code System.out.println("Finished.");
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
    	JComboBox userList = new JComboBox(listUsers); // using the model combo box to initiate the actual combo box to be used while retaining the values iterated into it
		userList.setSelectedIndex(0);
		userList.setBounds(136, 69, 162, 22);
		contentPane.add(userList);
		
		JButton userLogin = new JButton("Log In"); // creating a button to be used
		userLogin.setBounds(172, 181, 89, 23);
		contentPane.add(userLogin);
		userLogin.setBounds(172, 181, 89, 23);
		contentPane.add(userLogin);
		userLogin.addActionListener(new ActionListener() { // creating a listener to run a switch case to handle login scenarios
			public void actionPerformed(ActionEvent e) {
				String pleaseHelp = (String)userList.getSelectedItem();
				String tempCompare = (String)userList.getSelectedItem();
				int selectedUser = userList.getSelectedIndex();
				// debug text
				/*System.out.println(selectedUser);
				System.out.println(tempCompare);
				System.out.println(pleaseHelp); */ 
				switch (selectedUser) {
				case 0:
					dispose();
					adminFrame adminFrame = new adminFrame();
					adminFrame.main(null);  
					break;
				case 1:
					dispose();
					customerFrame customerFrame1 = new customerFrame();
					customerFrame.main(null);  
					break;
				case 2:
					dispose();
					customerFrame customerFrame2 = new customerFrame();
					customerFrame.main(null);  
					break;
				case 3:
					dispose();
					customerFrame customerFrame3 = new customerFrame();
					customerFrame.main(null);  
					break;
					
				}
			}
		});
		
	}
}
