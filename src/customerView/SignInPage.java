package customerView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminView.UserTypeWindow;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignInPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInPage frame = new SignInPage();
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
	public SignInPage() {
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
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(393, 166, 96, 19);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setEchoChar('*');
		passwordField.setBounds(393, 195, 96, 19);
		contentPane.add(passwordField);
		
		JButton LoginButton = new JButton("Sign in");
		LoginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		LoginButton.setBounds(335, 242, 105, 21);
		contentPane.add(LoginButton);
	}
}
