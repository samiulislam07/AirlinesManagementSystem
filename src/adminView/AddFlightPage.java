package adminView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import users.Admin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFlightPage extends JFrame {

	private JPanel contentPane;
	private JTextField flightNumbertextField;
	private JTextField departureTextField;
	private JTextField arrivalTextField;
	private JTextField monthTextField;
	private JTextField dateTextField;
	private JTextField hourTextField;
	private JTextField minutesTextField;
	private JTextField durationTextField;
	private JTextField durationMinsTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlightPage frame = new AddFlightPage();
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
	public AddFlightPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(152, 10, 176, 37);
		contentPane.add(txtZisAirlines);
		
		JLabel lblFlightRegistrationForm = new JLabel();
		lblFlightRegistrationForm.setForeground(Color.RED);
		lblFlightRegistrationForm.setText("Flight Registration Form");
		lblFlightRegistrationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightRegistrationForm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblFlightRegistrationForm.setBounds(127, 39, 243, 37);
		contentPane.add(lblFlightRegistrationForm);
		
		flightNumbertextField = new JTextField();
		flightNumbertextField.setBounds(244, 104, 126, 19);
		contentPane.add(flightNumbertextField);
		flightNumbertextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Provide the following Information:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(32, 75, 168, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Flight Number");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(113, 106, 121, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Departure");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(113, 135, 121, 13);
		contentPane.add(lblNewLabel_1_1);
		
		departureTextField = new JTextField();
		departureTextField.setColumns(10);
		departureTextField.setBounds(244, 133, 126, 19);
		contentPane.add(departureTextField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Arrival");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(113, 160, 121, 13);
		contentPane.add(lblNewLabel_1_2);
		
		arrivalTextField = new JTextField();
		arrivalTextField.setColumns(10);
		arrivalTextField.setBounds(244, 158, 126, 19);
		contentPane.add(arrivalTextField);
		
		JLabel lblNewLabel_1_3 = new JLabel("Departure Month");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(113, 185, 121, 13);
		contentPane.add(lblNewLabel_1_3);
		
		monthTextField = new JTextField();
		monthTextField.setColumns(10);
		monthTextField.setBounds(244, 183, 126, 19);
		contentPane.add(monthTextField);
		
		JLabel lblNewLabel_1_4 = new JLabel("Departure Date");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(113, 210, 121, 13);
		contentPane.add(lblNewLabel_1_4);
		
		dateTextField = new JTextField();
		dateTextField.setColumns(10);
		dateTextField.setBounds(244, 208, 126, 19);
		contentPane.add(dateTextField);
		
		JLabel lblNewLabel_1_5 = new JLabel("Dearture Hour");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(113, 235, 121, 13);
		contentPane.add(lblNewLabel_1_5);
		
		hourTextField = new JTextField();
		hourTextField.setColumns(10);
		hourTextField.setBounds(244, 233, 126, 19);
		contentPane.add(hourTextField);
		
		JLabel lblNewLabel_1_6 = new JLabel("Departure Minutes");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(113, 260, 121, 13);
		contentPane.add(lblNewLabel_1_6);
		
		minutesTextField = new JTextField();
		minutesTextField.setColumns(10);
		minutesTextField.setBounds(244, 258, 126, 19);
		contentPane.add(minutesTextField);
		
		JLabel lblNewLabel_1_7 = new JLabel("Flight Duration in Hours");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_7.setBounds(66, 289, 168, 13);
		contentPane.add(lblNewLabel_1_7);
		
		durationTextField = new JTextField();
		durationTextField.setColumns(10);
		durationTextField.setBounds(244, 287, 126, 19);
		contentPane.add(durationTextField);
		
		JLabel lblNewLabel_1_8 = new JLabel("Duration In Mins");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_8.setBounds(113, 314, 121, 13);
		contentPane.add(lblNewLabel_1_8);
		
		durationMinsTextField = new JTextField();
		durationMinsTextField.setColumns(10);
		durationMinsTextField.setBounds(244, 312, 126, 19);
		contentPane.add(durationMinsTextField);
		
		JButton btnNewButton = new JButton("ADD FLIGHT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Admin a = new Admin();
					a.addFlight(flightNumbertextField.getText(), departureTextField.getText(),
							arrivalTextField.getText(), Integer.parseInt(monthTextField.getText()),
							Integer.parseInt(dateTextField.getText()),
							Integer.parseInt(hourTextField.getText()),
							Integer.parseInt(minutesTextField.getText()),
							Integer.parseInt(durationTextField.getText()),
							Integer.parseInt(durationMinsTextField.getText()));
					
					JOptionPane.showMessageDialog(null, "Flight Added Successfully");
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(178, 371, 126, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminDashboard window = new AdminDashboard();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
