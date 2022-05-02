import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.StringJoiner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// imported needed classes/packages


// adminframe created
public class adminFrame extends JFrame {

	private JPanel contentPane;
	private JTextField isbnEntry;
	private JTextField bookTitleEntry;
	private JTextField bookLanguageEntry;
	private JTextField bookReleaseDateEntry;
	private JTextField bookRetailPriceEntry;
	private JTextField bookGenreEntry;
	private JTextField bookPagesEntry;
	private JTextField bookConditionEntry;
	private JTextField bookDurationEntry;
	private JTextField bookFormatEntry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminFrame frame = new adminFrame();
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
	// adminframe constructor created
	public adminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// labels for the sake of layout
		
		JLabel panelMessage = new JLabel("Administrator Panel");
		panelMessage.setHorizontalAlignment(SwingConstants.CENTER);
		panelMessage.setBounds(10, 68, 664, 23);
		contentPane.add(panelMessage);
		
		JLabel userStatusLabel = new JLabel("You are currently logged in as an administrator.");
		userStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userStatusLabel.setBounds(397, 11, 277, 23);
		contentPane.add(userStatusLabel);
		
		
		// logout button takes you to login page using a call to main in another gui file
		JButton logoutButton = new JButton("Log out");
		logoutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			loginFrame loginFrame = new loginFrame();
			loginFrame.main(null);  
			}
		});
		logoutButton.setBounds(508, 34, 89, 23);
		contentPane.add(logoutButton);
		
		JLabel isbnLabel = new JLabel("ISBN");
		isbnLabel.setBounds(34, 321, 46, 14);
		contentPane.add(isbnLabel);
		
		JLabel bookTypeLabel = new JLabel("Book Type");
		bookTypeLabel.setBounds(133, 321, 50, 14);
		contentPane.add(bookTypeLabel);
		
		// entries to parse data
		
		isbnEntry = new JTextField();
		isbnEntry.setBounds(34, 346, 86, 20);
		contentPane.add(isbnEntry);
		isbnEntry.setColumns(8);
		
		bookTitleEntry = new JTextField();
		bookTitleEntry.setColumns(10);
		bookTitleEntry.setBounds(229, 346, 86, 20);
		contentPane.add(bookTitleEntry);
		
		JLabel bookTitleLabel = new JLabel("Book Title");
		bookTitleLabel.setBounds(229, 321, 46, 14);
		contentPane.add(bookTitleLabel);
		
		bookLanguageEntry = new JTextField();
		bookLanguageEntry.setColumns(10);
		bookLanguageEntry.setBounds(325, 346, 86, 20);
		contentPane.add(bookLanguageEntry);
		
		JLabel bookLanguageLabel = new JLabel("Book Language");
		bookLanguageLabel.setBounds(325, 321, 73, 14);
		contentPane.add(bookLanguageLabel);
		
		bookReleaseDateEntry = new JTextField();
		bookReleaseDateEntry.setColumns(10);
		bookReleaseDateEntry.setBounds(519, 346, 86, 20);
		contentPane.add(bookReleaseDateEntry);
		
		JLabel bookReleaseDate = new JLabel("Release Date");
		bookReleaseDate.setBounds(519, 321, 64, 14);
		contentPane.add(bookReleaseDate);
		
		bookRetailPriceEntry = new JTextField();
		bookRetailPriceEntry.setColumns(10);
		bookRetailPriceEntry.setBounds(34, 402, 86, 20);
		contentPane.add(bookRetailPriceEntry);
		
		JLabel bookRetailPriceLabel = new JLabel("Retail Price");
		bookRetailPriceLabel.setBounds(34, 377, 64, 14);
		contentPane.add(bookRetailPriceLabel);
		
		bookGenreEntry = new JTextField();
		bookGenreEntry.setColumns(10);
		bookGenreEntry.setBounds(423, 346, 86, 20);
		contentPane.add(bookGenreEntry);
		
		JLabel bookGenreLabel = new JLabel("Genre");
		bookGenreLabel.setBounds(423, 321, 46, 14);
		contentPane.add(bookGenreLabel);
		
		bookPagesEntry = new JTextField();
		bookPagesEntry.setColumns(10);
		bookPagesEntry.setBounds(133, 402, 86, 20);
		contentPane.add(bookPagesEntry);
		
		JLabel bookPagesLabel = new JLabel("No. of Pages");
		bookPagesLabel.setBounds(133, 377, 64, 14);
		contentPane.add(bookPagesLabel);
		
		bookConditionEntry = new JTextField();
		bookConditionEntry.setColumns(10);
		bookConditionEntry.setBounds(229, 402, 86, 20);
		contentPane.add(bookConditionEntry);
		
		JLabel bookConditionLabel = new JLabel("Condition");
		bookConditionLabel.setBounds(229, 377, 46, 14);
		contentPane.add(bookConditionLabel);
		
		bookDurationEntry = new JTextField();
		bookDurationEntry.setEnabled(false);
		bookDurationEntry.setColumns(10);
		bookDurationEntry.setBounds(325, 402, 86, 20);
		contentPane.add(bookDurationEntry);
		
		JLabel bookDurationLabel = new JLabel("Duration");
		bookDurationLabel.setBounds(325, 377, 46, 14);
		contentPane.add(bookDurationLabel);
		
		
		
		bookFormatEntry = new JTextField();
		bookFormatEntry.setEnabled(false);
		bookFormatEntry.setColumns(10);
		bookFormatEntry.setBounds(423, 402, 86, 20);
		contentPane.add(bookFormatEntry);
		
		JLabel bookFormatLabel = new JLabel("Format");
		bookFormatLabel.setBounds(423, 377, 46, 14);
		contentPane.add(bookFormatLabel);
		
		// this type of combo box allows me to easily append data to it's selections allowing for a database to be used
		
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
		bookListComboBox.setBounds(34, 123, 610, 22);
		contentPane.add(bookListComboBox);
		
		JLabel currentStockLabel = new JLabel("Current Stock");
		currentStockLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentStockLabel.setBounds(10, 89, 664, 23);
		contentPane.add(currentStockLabel);
		
		// i use a selection statement here to differentiate between different book types, which affects which entry fields are enabled and acts as some form of data validation
		
		JComboBox bookTypeComboBox = new JComboBox();
		bookTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Paperback", "Ebook", "Audiobook"}));
		bookTypeComboBox.setBounds(133, 345, 86, 22);
		contentPane.add(bookTypeComboBox);
		bookTypeComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String selectedBookType = (String)bookTypeComboBox.getSelectedItem();
				
				if (selectedBookType == "Paperback") {
					bookConditionEntry.setEnabled(true);
					bookPagesEntry.setEnabled(true);
					bookDurationEntry.setEnabled(false);
					bookFormatEntry.setEnabled(false);
				}
				else if (selectedBookType == "Ebook") {
					bookConditionEntry.setEnabled(false);
					bookPagesEntry.setEnabled(true);
					bookDurationEntry.setEnabled(false);
					bookFormatEntry.setEnabled(true);
				}
				else if (selectedBookType == "Audiobook") {
					bookConditionEntry.setEnabled(false);
					bookPagesEntry.setEnabled(false);
					bookDurationEntry.setEnabled(true);
					bookFormatEntry.setEnabled(true);
				}
				
			}
		});
		JButton addBookButton = new JButton("Add Book");
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = isbnEntry.getText();
				String bookType = (String)bookTypeComboBox.getSelectedItem();
				String bookTitle = bookTitleEntry.getText();
				String bookLanguage = bookLanguageEntry.getText();
				String bookGenre = bookGenreEntry.getText();
				String bookReleaseDate = bookReleaseDateEntry.getText();
				String bookRetailPrice = bookRetailPriceEntry.getText();
				if (bookType == "Paperback") {
					
					
					
					String bookPages = bookPagesEntry.getText();
					String bookCondition = bookConditionEntry.getText();
					// debug code to see if i was parsing data correctly
					/*
					System.out.println(isbn);
					System.out.println(bookType);
					System.out.println(bookTitle);
					System.out.println(bookLanguage);
					System.out.println(bookGenre);
					System.out.println(bookReleaseDate);
					System.out.println(bookRetailPrice);
					System.out.println(bookPages);
					System.out.println(bookCondition);
					*/
					StringJoiner joiner = new StringJoiner(", ");
					joiner.add(isbn).add(bookType).add(bookTitle).add(bookLanguage).add(bookGenre).add(bookReleaseDate).add(bookRetailPrice).add(bookPages).add(bookCondition);
					String stockEntry = joiner.toString();
					
					System.out.println(stockEntry);
					
					File log = new File("Stock.txt");
					PrintWriter out;
					try {
						out = new PrintWriter(new FileWriter(log, true));
						out.append("\n" + stockEntry);
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
						    
				}
				else if (bookType == "Ebook") {
					
					
					String bookPages = bookPagesEntry.getText();
					String bookFormat = bookFormatEntry.getText();
					/*
					System.out.println(isbn);
					System.out.println(bookType);
					System.out.println(bookTitle);
					System.out.println(bookLanguage);
					System.out.println(bookGenre);
					System.out.println(bookReleaseDate);
					System.out.println(bookRetailPrice);
					System.out.println(bookPages);
					System.out.println(bookFormat);
					*/
					StringJoiner joiner = new StringJoiner(", ");
					joiner.add(isbn).add(bookType).add(bookTitle).add(bookLanguage).add(bookGenre).add(bookReleaseDate).add(bookRetailPrice).add(bookPages).add(bookFormat);
					String stockEntry = joiner.toString();
					
					System.out.println(stockEntry);
					
					File log = new File("Stock.txt");
					PrintWriter out;
					try {
						out = new PrintWriter(new FileWriter(log, true));
						out.append("\n" + stockEntry);
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				else if (bookType == "Audiobook") {
					String bookDuration = bookDurationEntry.getText();
					String bookFormat = bookFormatEntry.getText();
					/*
					System.out.println(isbn);
					System.out.println(bookType);
					System.out.println(bookTitle);
					System.out.println(bookLanguage);
					System.out.println(bookGenre);
					System.out.println(bookReleaseDate);
					System.out.println(bookRetailPrice);
					System.out.println(bookDuration);
					System.out.println(bookFormat);
					*/
					
					// join the strings to append to the stock list
					
					StringJoiner joiner = new StringJoiner(", ");
					joiner.add(isbn).add(bookType).add(bookTitle).add(bookLanguage).add(bookGenre).add(bookReleaseDate).add(bookRetailPrice).add(bookDuration).add(bookFormat);
					String stockEntry = joiner.toString();
					
					System.out.println(stockEntry);
					
					File log = new File("Stock.txt");
					PrintWriter out;
					try {
						out = new PrintWriter(new FileWriter(log, true));
						out.append("\n" + stockEntry);
						out.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
				
				
			}
		});
		addBookButton.setBounds(529, 386, 119, 53);
		contentPane.add(addBookButton);
	}
	
}
