package adminView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customerView.CustomerLoginPage;
import pilotView.PilotLoginPage;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserTypeWindow extends JFrame {

	private JPanel contentPane;
	private JLabel txtZisAirlines;
	private JLabel txtLogInAs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTypeWindow frame = new UserTypeWindow();
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
	public UserTypeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtZisAirlines = new JLabel();
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setBounds(318, 93, 176, 37);
		contentPane.add(txtZisAirlines);
		
		txtLogInAs = new JLabel();
		txtLogInAs.setText("Log In As");
		txtLogInAs.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogInAs.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtLogInAs.setBounds(349, 175, 111, 19);
		contentPane.add(txtLogInAs);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLoginPage loginWindow = new AdminLoginPage();
				loginWindow.setLocationRelativeTo(null);
				loginWindow.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(132, 222, 111, 21);
		contentPane.add(btnNewButton);
		
		JButton btnPilot = new JButton("Pilot");
		btnPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PilotLoginPage window = new PilotLoginPage();
				dispose();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnPilot.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnPilot.setBounds(349, 222, 111, 21);
		contentPane.add(btnPilot);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginPage window = new CustomerLoginPage();
				dispose();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnCustomer.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCustomer.setBounds(562, 222, 118, 21);
		contentPane.add(btnCustomer);
	}
}
