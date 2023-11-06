package customerView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminView.AdminCredentials;
import adminView.AdminDashboard;
import adminView.UserTypeWindow;
import users.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomerLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLoginPage frame = new CustomerLoginPage();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(294, 52, 176, 37);
		contentPane.add(txtZisAirlines);
		
		JLabel lblCustomerLogin = new JLabel();
		lblCustomerLogin.setText("Customer Login");
		lblCustomerLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerLogin.setForeground(Color.GREEN);
		lblCustomerLogin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCustomerLogin.setBounds(294, 85, 176, 37);
		contentPane.add(lblCustomerLogin);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserTypeWindow window = new UserTypeWindow();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 28, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel LabelUsername = new JLabel("Username");
		LabelUsername.setHorizontalAlignment(SwingConstants.CENTER);
		LabelUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		LabelUsername.setBounds(294, 169, 85, 13);
		contentPane.add(LabelUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(294, 198, 85, 13);
		contentPane.add(lblPassword);
		
		userName = new JTextField();
		userName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		userName.setColumns(10);
		userName.setBounds(393, 166, 96, 19);
		contentPane.add(userName);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String nameToCheck = userName.getText();
					String passToCheck = passwordField.getText();
					boolean loginSuccessful = false;
					try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("CustomerCredentials.dat"))){
						ArrayList<Customer> arr = (ArrayList<Customer>)infile.readObject();
						Iterator i = arr.iterator();
						while(i.hasNext()) {
							 Customer customer = (Customer) i.next();
					            if (nameToCheck.equals(customer.getUserName()) && passToCheck.equals(customer.getPassword())) {
					            	try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
					            		outfile.writeObject(customer);
					            	}
					            	loginSuccessful = true;
					            	dispose();
					            	CustomerDashboard window = new CustomerDashboard();
					            	window.setLocationRelativeTo(null);
					            	window.setVisible(true);
				                    break;
					            }
						}
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					if (loginSuccessful) {
			            JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + nameToCheck, "Login Status", JOptionPane.INFORMATION_MESSAGE);
			        } else {
			            JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.", "Login Status", JOptionPane.ERROR_MESSAGE);
			        }
				}
			}
		});
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setEchoChar('*');
		passwordField.setBounds(393, 195, 96, 19);
		contentPane.add(passwordField);
		
		JButton LoginButton = new JButton("Sign in");
		LoginButton.setForeground(Color.GREEN);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameToCheck = userName.getText();
				String passToCheck = passwordField.getText();
				boolean loginSuccessful = false;
				try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("CustomerCredentials.dat"))){
					ArrayList<Customer> arr = (ArrayList<Customer>)infile.readObject();
					Iterator i = arr.iterator();
					while(i.hasNext()) {
						 Customer customer = (Customer) i.next();
				            if (nameToCheck.equals(customer.getUserName()) && passToCheck.equals(customer.getPassword())) {
				            	try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
				            		outfile.writeObject(customer);
				            	}
				            	loginSuccessful = true;
				            	dispose();
				            	CustomerDashboard window = new CustomerDashboard();
				            	window.setLocationRelativeTo(null);
				            	window.setVisible(true);
			                    break;
				            }
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				if (loginSuccessful) {
		            JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + nameToCheck, "Login Status", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.", "Login Status", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		LoginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		LoginButton.setBounds(338, 241, 96, 21);
		contentPane.add(LoginButton);
		
		JButton btnSignUp = new JButton("Create a new Account");
		btnSignUp.setForeground(Color.RED);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerSignUpPage window = new CustomerSignUpPage();
				dispose();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSignUp.setBounds(282, 306, 218, 21);
		contentPane.add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("Or");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(364, 283, 45, 13);
		contentPane.add(lblNewLabel);
	}
}
