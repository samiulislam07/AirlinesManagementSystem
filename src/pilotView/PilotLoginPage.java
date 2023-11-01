package pilotView;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pilotManagement.PilotTeam;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class PilotLoginPage extends JFrame {

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
					PilotLoginPage frame = new PilotLoginPage();
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
	public PilotLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(32, 32, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(304, 32, 176, 37);
		contentPane.add(txtZisAirlines);
		
		JLabel LabelUsername = new JLabel("Username");
		LabelUsername.setHorizontalAlignment(SwingConstants.CENTER);
		LabelUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		LabelUsername.setBounds(282, 155, 85, 13);
		contentPane.add(LabelUsername);
		
		userName = new JTextField();
		userName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		userName.setColumns(10);
		userName.setBounds(402, 152, 96, 19);
		contentPane.add(userName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(282, 182, 85, 13);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String nameToCheck = userName.getText();
					String passToCheck = passwordField.getText();
					boolean loginSuccessful = false; // Flag to track login status
					try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("PilotTeamDetails.dat"))){
						ArrayList arr = (ArrayList)infile.readObject();
						Iterator i = arr.iterator();
						while(i.hasNext()) {
							 PilotTeam team = (PilotTeam) i.next();
					            if (nameToCheck.equals(team.userName) && passToCheck.equals(team.password)) {
					            	try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
					            		outfile.writeObject(team);
					            	}
					            	loginSuccessful = true; // Set the flag to true for a successful login
					            	dispose();
					            	PilotDashboard window = new PilotDashboard();
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
		passwordField.setBounds(402, 181, 96, 19);
		contentPane.add(passwordField);
		
		JButton LoginButton = new JButton("Sign in");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String nameToCheck = userName.getText();
					String passToCheck = passwordField.getText();
					boolean loginSuccessful = false; // Flag to track login status
					try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("PilotTeamDetails.dat"))){
						ArrayList<PilotTeam> arr = (ArrayList<PilotTeam>)infile.readObject();
						Iterator i = arr.iterator();
						while(i.hasNext()) {
							 PilotTeam team = (PilotTeam) i.next();
					            if (nameToCheck.equals(team.userName) && passToCheck.equals(team.password)) {
					            	try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
					            		outfile.writeObject(team);
					            	}
					            	loginSuccessful = true; // Set the flag to true for a successful login
					            	dispose();
					            	PilotDashboard window = new PilotDashboard();
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
		LoginButton.setBounds(328, 228, 105, 21);
		contentPane.add(LoginButton);
		
		JLabel lblPilotLogin = new JLabel();
		lblPilotLogin.setForeground(SystemColor.textHighlight);
		lblPilotLogin.setText("Pilot Login");
		lblPilotLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPilotLogin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPilotLogin.setBounds(304, 64, 176, 37);
		contentPane.add(lblPilotLogin);
	}
}
