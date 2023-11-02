package adminView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
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
import java.awt.SystemColor;
import java.awt.Color;

public class AdminLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginPage frame = new AdminLoginPage();
					frame.setLocationRelativeTo(null);
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
	public AdminLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userName = new JTextField();
		userName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		userName.setBounds(396, 164, 96, 19);
		contentPane.add(userName);
		userName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String nameToCheck = userName.getText();
					String passToCheck = passwordField.getText();
					boolean loginSuccessful = false; // Flag to track login status
					try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("AdminCredentials.dat"))){
						ArrayList<AdminCredentials> arr = (ArrayList<AdminCredentials>)infile.readObject();
						Iterator i = arr.iterator();
						while(i.hasNext()) {
							 AdminCredentials admin = ( AdminCredentials) i.next();
					            if (nameToCheck.equals(admin.getUserName()) && passToCheck.equals(admin.getPassWord())) {
					            	try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
					            		outfile.writeObject(admin);
					            	}
					            	loginSuccessful = true; // Set the flag to true for a successful login
					            	dispose();
					            	AdminDashboard window = new AdminDashboard();
					            	window.setLocationRelativeTo(null);
					            	window.setVisible(true);
				                    break; // Exit the loop when a match is found
					            }
						}
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					if (loginSuccessful) {
			            // Login successful
			            JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + nameToCheck, "Login Status", JOptionPane.INFORMATION_MESSAGE);
			        } else {
			            // Login failed
			            JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.", "Login Status", JOptionPane.ERROR_MESSAGE);
			        }
				}
			}
		});
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setEchoChar('*');
		passwordField.setBounds(396, 193, 96, 19);
		contentPane.add(passwordField);
		
		JLabel LabelUsername = new JLabel("Username");
		LabelUsername.setHorizontalAlignment(SwingConstants.CENTER);
		LabelUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		LabelUsername.setBounds(276, 167, 85, 13);
		contentPane.add(LabelUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(276, 194, 85, 13);
		contentPane.add(lblPassword);
		
		JButton LoginButton = new JButton("Sign in");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameToCheck = userName.getText();
				String passToCheck = passwordField.getText();
				boolean loginSuccessful = false; // Flag to track login status
				try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("AdminCredentials.dat"))){
					ArrayList arr = (ArrayList)infile.readObject();
					Iterator i = arr.iterator();
					while(i.hasNext()) {
						 AdminCredentials admin = ( AdminCredentials) i.next();
				            if (nameToCheck.equals(admin.getUserName()) && passToCheck.equals(admin.getPassWord())) {
				            	try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
				            		outfile.writeObject(admin);
				            	}
				            	loginSuccessful = true; // Set the flag to true for a successful login
				            	dispose();
				            	AdminDashboard window = new AdminDashboard();
				            	window.setLocationRelativeTo(null);
				            	window.setVisible(true);
			                    break; // Exit the loop when a match is found
				            }
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				if (loginSuccessful) {
		            // Login successful
		            JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + nameToCheck, "Login Status", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            // Login failed
		            JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.", "Login Status", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		LoginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		LoginButton.setBounds(322, 240, 105, 21);
		contentPane.add(LoginButton);
		
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
		btnNewButton_1.setBounds(26, 26, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(288, 63, 176, 37);
		contentPane.add(txtZisAirlines);
		
		JLabel lblAdminLogin = new JLabel();
		lblAdminLogin.setText("Admin Login");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setForeground(new Color(220, 20, 60));
		lblAdminLogin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAdminLogin.setBounds(288, 93, 176, 37);
		contentPane.add(lblAdminLogin);
	}
}
