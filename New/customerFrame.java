import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JTree;
import java.awt.List;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringJoiner;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// import needed classes/modules


// create customerframe

public class customerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField cardNumberEntry;
	private JTextField securityNumberEntry;
	private JTextField emailAddressEntry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerFrame frame = new customerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// customerframe constructor
	public customerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// labels for layout reasons
		
		JLabel userStatusLabel = new JLabel("You are currently logged in as a customer.");
		userStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userStatusLabel.setBounds(447, 11, 277, 23);
		contentPane.add(userStatusLabel);
		
		// logout button takes user to login page
		
		JButton logoutButton = new JButton("Log out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginFrame loginFrame = new loginFrame();
				loginFrame.main(null);  
				}
			});
		logoutButton.setBounds(558, 34, 89, 23);
		contentPane.add(logoutButton);
		
		JLabel panelMessage = new JLabel("Customer Panel");
		panelMessage.setHorizontalAlignment(SwingConstants.CENTER);
		panelMessage.setBounds(30, 67, 664, 23);
		contentPane.add(panelMessage);
		
		JLabel bookListLabel = new JLabel("Available Books");
		bookListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookListLabel.setBounds(30, 88, 664, 23);
		contentPane.add(bookListLabel);
		
		// combo box allows me to iterate dater into it so a database can be used
		
		DefaultComboBoxModel listBooks = new DefaultComboBoxModel();
		
		try {
		      File getBooks = new File("Stock.txt");
		      Scanner myReader = new Scanner(getBooks);
		      while (myReader.hasNextLine()) {
		    	  String data = myReader.nextLine();
				    
		    	  listBooks.addElement(data);
		      }
		      myReader.close();
		      // debug code
		      //System.out.println("Finished.");
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		JComboBox bookListComboBox = new JComboBox(listBooks);
		bookListComboBox.setBounds(54, 122, 552, 22);
		contentPane.add(bookListComboBox);
		
		
		JLabel userBasketLabel = new JLabel("Your Basket");
		userBasketLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userBasketLabel.setBounds(54, 266, 121, 23);
		contentPane.add(userBasketLabel);
		
		// i use a selection statement here to differentiate between different payment types types, which affects which entry fields are enabled and acts as some form of data validation
		
		JComboBox paymentMethodComboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"PayPal", "Credit/Debit Card"}));
		paymentMethodComboBox.setBounds(325, 301, 136, 22);
		contentPane.add(paymentMethodComboBox);
		paymentMethodComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
						String selectedPaymentType = (String)paymentMethodComboBox.getSelectedItem();
						
						if (selectedPaymentType == "PayPal") {
							emailAddressEntry.setEnabled(true);
							cardNumberEntry.setEnabled(false);
							securityNumberEntry.setEnabled(false);
						}
						else if (selectedPaymentType == "Credit/Debit Card") {
							cardNumberEntry.setEnabled(true);
							securityNumberEntry.setEnabled(true);
							emailAddressEntry.setEnabled(false);
						}
						
					}
				});
		
		
		JLabel paymentMethodLabel = new JLabel("Payment Method");
		paymentMethodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodLabel.setBounds(325, 279, 121, 23);
		contentPane.add(paymentMethodLabel);
		
		cardNumberEntry = new JTextField();
		cardNumberEntry.setEnabled(false);
		cardNumberEntry.setColumns(8);
		cardNumberEntry.setBounds(325, 359, 86, 20);
		contentPane.add(cardNumberEntry);
		
		JLabel cardNumberLabel = new JLabel("Card Number");
		cardNumberLabel.setBounds(325, 334, 70, 14);
		contentPane.add(cardNumberLabel);
		
		securityNumberEntry = new JTextField();
		securityNumberEntry.setEnabled(false);
		securityNumberEntry.setColumns(8);
		securityNumberEntry.setBounds(325, 415, 86, 20);
		contentPane.add(securityNumberEntry);
		
		JLabel securityNumberLabel = new JLabel("Security Number");
		securityNumberLabel.setBounds(325, 390, 86, 14);
		contentPane.add(securityNumberLabel);
		
		emailAddressEntry = new JTextField();
		emailAddressEntry.setColumns(8);
		emailAddressEntry.setBounds(421, 359, 86, 20);
		contentPane.add(emailAddressEntry);
		
		JLabel emailAddressLabel = new JLabel("Email Address");
		emailAddressLabel.setBounds(421, 334, 86, 14);
		contentPane.add(emailAddressLabel);
		
		// combo box for payment here too
		
		DefaultComboBoxModel userBasket = new DefaultComboBoxModel();
		JComboBox userBasketComboBox = new JComboBox(userBasket);
		userBasketComboBox.setBounds(10, 301, 277, 23);
		contentPane.add(userBasketComboBox);
		
		JLabel basketTotalLabel = new JLabel("Your total is: \u00A30.00" );
		
		// adds the selected book to the basket
		
		JButton addBookButton = new JButton("Add Book");
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedBook = (String)bookListComboBox.getSelectedItem();
				userBasket.addElement(selectedBook);
				String[] selectedBookArray = selectedBook.split(", ");
				System.out.println(selectedBookArray[6]);
				
			}
		});
		addBookButton.setBounds(616, 122, 89, 22);
		contentPane.add(addBookButton);
		
		// empties the users basket
		
		JButton cancelOrderButton = new JButton("Cancel Order");
		cancelOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userBasketComboBox.removeAllItems();
				cancelPrompt cancelPrompt = new cancelPrompt();
				cancelPrompt.main(null);
				basketTotalLabel.setText("Your total is: \u00A30.00");
			}
		});
		cancelOrderButton.setBounds(558, 414, 136, 23);
		contentPane.add(cancelOrderButton);
		
		
		
		
		JLabel basketTotalCost = new JLabel("Your total is: \u00A30.00");
		basketTotalCost.setBounds(556, 266, 138, 70);
		contentPane.add(basketTotalCost);
		
		// calculates total, opens prompt and purchases books once clicked
		
		JButton purchaseButton = new JButton("Purchase");
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total = 0;
				int count = userBasketComboBox.getItemCount();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    builder.append(userBasketComboBox.getItemAt(i));
                    	String selectedBook = (String)bookListComboBox.getSelectedItem();
        				String[] selectedBookArray = selectedBook.split(", ");
        				double temp = Double.parseDouble(selectedBookArray[6]);
        				total += temp;
        				String textTotal = String.valueOf(total);
        				basketTotalCost.setText("Your total is: \u00A3" + textTotal);
        				
                 
                }
                String selectedPaymentType = (String)paymentMethodComboBox.getSelectedItem();
                if (selectedPaymentType == "PayPal") {
                	
                	String userID;
    				String paypalEmail = emailAddressEntry.getText();
    				if (total > 0) {
    					
    				/*	int countPayPal = userBasketComboBox.getItemCount();
    	                StringBuilder builderPayPal = new StringBuilder();
    	                for (int i = 0; i < countPayPal; i++) {
    	                    builder.append(userBasketComboBox.getItemAt(i));
    	                    	String selectedBook = (String)bookListComboBox.getSelectedItem();
    	        				String[] selectedBookArray = selectedBook.split(", ");
    					StringJoiner joiner = new StringJoiner(", ");
    					joiner.add(selectedBookArray[0]).add(selectedBookArray[6]).add(selectedPaymentType);
    					String stockEntry = joiner.toString();
    					
    					System.out.println(stockEntry);
    					
    					File log = new File("ActivityLog.txt");
    					PrintWriter out;
    					try {
    						out = new PrintWriter(new FileWriter(log, true));
    						out.append("\n" + stockEntry);
    						out.close();
    					} catch (IOException e1) {
    						e1.printStackTrace();
    					} */
    					
    					
    					userBasketComboBox.removeAllItems();
    					basketTotalLabel.setText("Your total is: \u00A30.00");
    					purchaseSuccessful purchaseSuccessful = new purchaseSuccessful();
    					purchaseSuccessful.main(null);
    					
    				}
                }
    			else if (selectedPaymentType == "Credit/Debit Card") {
                    	
          
        				String cardNumber = cardNumberEntry.getText();
        				String securityNumber = securityNumberEntry.getText();
        				if (total > 0) {
        					/* int countCredit = userBasketComboBox.getItemCount();
        	                StringBuilder builderCredit = new StringBuilder();
        	                for (int i = 0; i < countCredit; i++) {
        	                    builder.append(userBasketComboBox.getItemAt(i));
        	                    	String selectedBook = (String)bookListComboBox.getSelectedItem();
        	        				String[] selectedBookArray = selectedBook.split(", ");
        					StringJoiner joiner = new StringJoiner(", ");
        					joiner.add(selectedBookArray[0]).add(selectedBookArray[6]).add(selectedPaymentType);
        					String stockEntry = joiner.toString();
        					
        					System.out.println(stockEntry);
        					
        					File log = new File("ActivityLog.txt");
        					PrintWriter out;
        					try {
        						out = new PrintWriter(new FileWriter(log, true));
        						out.append("\n" + stockEntry);
        						out.close();
        					} catch (IOException e1) {
        						// TODO Auto-generated catch block
        						e1.printStackTrace();
        					}
        				}*/
        					userBasketComboBox.removeAllItems();
        					basketTotalLabel.setText("Your total is: \u00A30.00");
        					purchaseSuccessful purchaseSuccessful = new purchaseSuccessful();
        					purchaseSuccessful.main(null);
        				}	
    			
                	
    			}
                }
			
                
				/* basketTotalCost.setText("Item count: " + count + "; ["
	                    + builder.toString() + "]"); */
				
			
			
			
			
		});
		purchaseButton.setBounds(556, 331, 138, 77);
		contentPane.add(purchaseButton);
	}
}
