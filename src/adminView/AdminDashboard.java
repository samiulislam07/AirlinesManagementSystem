package adminView;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pilotManagement.PilotTeam;
import users.Admin;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JFrame {

	private JPanel contentPane;
	private AdminCredentials a;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SessionInfo.dat"))){
            		
            	}catch(Exception exc) {
            		JOptionPane.showMessageDialog(null, "Error");
            	}
				dispose();
				UserTypeWindow window = new UserTypeWindow();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(21, 43, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Admin Dashboard");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(298, 134, 186, 21);
		contentPane.add(lblNewLabel);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(0, 74, 786, 37);
		contentPane.add(txtZisAirlines);
		
		JButton btnNewButton = new JButton("View Ongoing Flight Schedules");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShowingFlightDetails window = new ShowingFlightDetails();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBounds(275, 196, 248, 21);
		contentPane.add(btnNewButton);
		
		JButton btnAddFlightSchedule = new JButton("Add Flight Schedule");
		btnAddFlightSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddFlightPage window = new AddFlightPage();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnAddFlightSchedule.setForeground(Color.GREEN);
		btnAddFlightSchedule.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAddFlightSchedule.setBounds(310, 238, 174, 21);
		contentPane.add(btnAddFlightSchedule);
		
		JButton btnSearchFlightSchedule = new JButton("Search Flight Schedule");
		btnSearchFlightSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShowingFlightDetails window = new ShowingFlightDetails();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnSearchFlightSchedule.setForeground(Color.BLUE);
		btnSearchFlightSchedule.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnSearchFlightSchedule.setBounds(298, 283, 197, 21);
		contentPane.add(btnSearchFlightSchedule);
		
		JButton btnDeleteFlightSchedule = new JButton("Delete Flight Schedule");
		btnDeleteFlightSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeleteFlightPage window = new DeleteFlightPage();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnDeleteFlightSchedule.setForeground(Color.RED);
		btnDeleteFlightSchedule.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnDeleteFlightSchedule.setBounds(298, 327, 197, 21);
		contentPane.add(btnDeleteFlightSchedule);
		
		JLabel UserLabel = new JLabel("New label");
		UserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UserLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		UserLabel.setBounds(21, 20, 85, 21);
		contentPane.add(UserLabel);
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("SessionInfo.dat"))){
    		a = (AdminCredentials)infile.readObject();
    		UserLabel.setText(a.getUserName());
    	}catch(Exception e) {
    		UserLabel.setText("");
    	}
		UserLabel.setText(a.getUserName());
	}

}
