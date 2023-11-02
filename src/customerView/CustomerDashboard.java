package customerView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminView.UserTypeWindow;
import pilotManagement.PilotTeam;
import users.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class CustomerDashboard extends JFrame {

	private JPanel contentPane;
	private JLabel costField;
	private JLabel usernameField;
	private JLabel contactField;
	private JLabel ageField;
	private Customer customer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDashboard frame = new CustomerDashboard();
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
	public CustomerDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(0, 58, 786, 37);
		contentPane.add(txtZisAirlines);
		
		JLabel lblCustomerDashboard = new JLabel("Customer Dashboard");
		lblCustomerDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerDashboard.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCustomerDashboard.setBounds(287, 105, 211, 21);
		contentPane.add(lblCustomerDashboard);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
					dispose();
					UserTypeWindow window = new UserTypeWindow();
					window.setLocationRelativeTo(null);
					window.setVisible(true);
            	}catch(Exception exc) {
            		JOptionPane.showMessageDialog(null, "Error");
            	}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 27, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(71, 164, 121, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(71, 205, 121, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contact");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(71, 244, 121, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(71, 284, 121, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Total Cost");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(71, 327, 121, 13);
		contentPane.add(lblNewLabel_1_4);
		
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("SessionInfo.dat"))){
    		customer = (Customer)infile.readObject();
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
		costField = new JLabel();
		costField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		costField.setBounds(202, 325, 150, 19);
		contentPane.add(costField);
		costField.setText(String.valueOf(customer.getCost()));
		
		usernameField = new JLabel();
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		usernameField.setBounds(202, 282, 150, 19);
		contentPane.add(usernameField);
		usernameField.setText(customer.getUserName());
		
		contactField = new JLabel();
		contactField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contactField.setBounds(202, 242, 150, 19);
		contentPane.add(contactField);
		contactField.setText(customer.getContact());
		
		ageField = new JLabel();
		ageField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		ageField.setBounds(202, 203, 150, 19);
		contentPane.add(ageField);
		ageField.setText(String.valueOf(customer.getAge()));
		
		JButton btnNewButton = new JButton("View Ongoing Flight Schedules");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBounds(465, 161, 248, 21);
		contentPane.add(btnNewButton);
		
		JButton btnSearchFlightSchedule = new JButton("Search Flight Schedule");
		btnSearchFlightSchedule.setForeground(Color.BLUE);
		btnSearchFlightSchedule.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnSearchFlightSchedule.setBounds(488, 202, 197, 21);
		contentPane.add(btnSearchFlightSchedule);
		
		JButton btnDeleteFlightSchedule = new JButton("Delete Flight Schedule");
		btnDeleteFlightSchedule.setForeground(Color.RED);
		btnDeleteFlightSchedule.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnDeleteFlightSchedule.setBounds(488, 241, 197, 21);
		contentPane.add(btnDeleteFlightSchedule);
		
		JLabel nameField = new JLabel();
		nameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		nameField.setBounds(202, 158, 150, 19);
		contentPane.add(nameField);
		nameField.setText(customer.getName());
	}
}
