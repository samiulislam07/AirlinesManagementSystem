package pilotView;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminView.ShowingFlightDetails;
import adminView.UserTypeWindow;
import pilotManagement.PilotTeam;

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
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class PilotDashboard extends JFrame {

	private JPanel contentPane;
	private PilotTeam t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PilotDashboard frame = new PilotDashboard();
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
	public PilotDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 499);
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
				UserTypeWindow window = new UserTypeWindow();
				dispose();
				window.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(10, 30, 776, 37);
		contentPane.add(txtZisAirlines);
		
		JLabel lblPilotDashboard = new JLabel("Pilot Dashboard");
		lblPilotDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblPilotDashboard.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPilotDashboard.setBounds(305, 77, 186, 21);
		contentPane.add(lblPilotDashboard);
		
		JButton btnNewButton = new JButton("View Ongoing Flight Schedules");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowFlightDetails window = new ShowFlightDetails();
				dispose();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBounds(278, 298, 248, 21);
		contentPane.add(btnNewButton);
		
		JButton btnChooseFlight = new JButton("Choose Flight");
		btnChooseFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseFlight window = new ChooseFlight();
				dispose();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnChooseFlight.setForeground(Color.GREEN);
		btnChooseFlight.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnChooseFlight.setBounds(305, 344, 197, 21);
		contentPane.add(btnChooseFlight);
		
		JLabel lblNewLabel = new JLabel("Team");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(332, 115, 55, 13);
		contentPane.add(lblNewLabel);
		
		JLabel teamNameLabel = new JLabel();
		teamNameLabel.setForeground(Color.RED);
		teamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		teamNameLabel.setBounds(390, 107, 79, 27);
		contentPane.add(teamNameLabel);
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("SessionInfo.dat"))){
    		t = (PilotTeam)infile.readObject();
    	}catch(Exception e) {
    		teamNameLabel.setText("");
    	}
		teamNameLabel.setText(t.Team);
		
		JTextPane captainTextPane = new JTextPane();
		captainTextPane.setBackground(Color.RED);
		captainTextPane.setFont(new Font("Times New Roman", Font.BOLD, 20));
		captainTextPane.setBounds(139, 146, 248, 119);
		contentPane.add(captainTextPane);
		captainTextPane.setText(t.ob[0].toString());
		
		JTextPane CoPilotTextPane = new JTextPane();
		CoPilotTextPane.setBackground(Color.CYAN);
		CoPilotTextPane.setFont(new Font("Times New Roman", Font.BOLD, 20));
		CoPilotTextPane.setEditable(false);
		CoPilotTextPane.setBounds(400, 146, 248, 119);
		contentPane.add(CoPilotTextPane);
		CoPilotTextPane.setText(t.ob[1].toString());
	}

}
