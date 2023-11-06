package customerView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import users.Admin;
import users.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CustomerSignUpPage extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField contactField;
	private JTextField usernameField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSignUpPage frame = new CustomerSignUpPage();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerSignUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(148, 26, 176, 37);
		contentPane.add(txtZisAirlines);
		
		JLabel lblCustomerSignUp = new JLabel();
		lblCustomerSignUp.setText("Customer Sign Up Form");
		lblCustomerSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerSignUp.setForeground(Color.RED);
		lblCustomerSignUp.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCustomerSignUp.setBounds(119, 59, 234, 37);
		contentPane.add(lblCustomerSignUp);
		
		JLabel lblNewLabel = new JLabel("Provide the following Information:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(44, 126, 220, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(87, 166, 121, 13);
		contentPane.add(lblNewLabel_1);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		nameField.setColumns(10);
		nameField.setBounds(218, 164, 150, 19);
		contentPane.add(nameField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(87, 207, 121, 13);
		contentPane.add(lblNewLabel_1_1);
		
		ageField = new JTextField();
		ageField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		ageField.setColumns(10);
		ageField.setBounds(218, 205, 150, 19);
		contentPane.add(ageField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contact");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(87, 246, 121, 13);
		contentPane.add(lblNewLabel_1_2);
		
		contactField = new JTextField();
		contactField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contactField.setColumns(10);
		contactField.setBounds(218, 244, 150, 19);
		contentPane.add(contactField);
		
		JLabel lblNewLabel_1_3 = new JLabel("Set Username");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(87, 286, 121, 13);
		contentPane.add(lblNewLabel_1_3);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		usernameField.setColumns(10);
		usernameField.setBounds(218, 284, 150, 19);
		contentPane.add(usernameField);
		
		JLabel lblNewLabel_1_4 = new JLabel("Set Password");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(87, 329, 121, 13);
		contentPane.add(lblNewLabel_1_4);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setColumns(10);
		passwordField.setBounds(218, 327, 150, 19);
		contentPane.add(passwordField);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer(nameField.getText(), Integer.parseInt(ageField.getText()),
						contactField.getText(), usernameField.getText(), passwordField.getText());
				try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("CustomerCredentials.dat"))){
					ArrayList<Customer> cust = (ArrayList<Customer>)infile.readObject();
					int flag=0;
					for(int i=0; i<cust.size(); i++)
					{
						if(customer.getUserName().equals(cust.get(i).getUserName()))
						{
							flag=1;
							throw new usernameException("Username is taken");
							
						}
					}
					if(flag==0)
                  {     cust.add(customer);
					    try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("CustomerCredentials.dat"))){
							outfile.writeObject(cust);
							JOptionPane.showMessageDialog(btnSignUp, "Signed up Successfully!");
							}
				  }
					
				}catch(usernameException exc) {
					JOptionPane.showMessageDialog(btnSignUp, exc);
				}catch(ClassNotFoundException exc) {
					System.out.println("Class Not Found");
				}catch(IOException exc) {
					System.out.println("IOException "+exc);
				}
			}
		});
		btnSignUp.setForeground(Color.GREEN);
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSignUp.setBounds(164, 357, 126, 21);
		contentPane.add(btnSignUp);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginPage window = new CustomerLoginPage();
				dispose();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
