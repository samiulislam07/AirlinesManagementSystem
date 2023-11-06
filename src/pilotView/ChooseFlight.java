package pilotView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import flightManagement.FlightDetails;
import pilotManagement.AssignedPilot;
import users.Admin;
import users.Pilot;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ChooseFlight extends JFrame {

	private JPanel contentPane;
	private JTextField flightNumberTextField;
	private JList<AssignedPilot> list;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFlight frame = new ChooseFlight();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChooseFlight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PilotDashboard window = new PilotDashboard();
				dispose();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(184, 10, 176, 37);
		contentPane.add(txtZisAirlines);
		
		JLabel lblEnterFlightNumber = new JLabel("Enter Flight Number to Choose:");
		lblEnterFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterFlightNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEnterFlightNumber.setBounds(50, 211, 437, 13);
		contentPane.add(lblEnterFlightNumber);
		
		flightNumberTextField = new JTextField();
		flightNumberTextField.setColumns(10);
		flightNumberTextField.setBounds(174, 234, 96, 19);
		contentPane.add(flightNumberTextField);
		
		
		JButton btnChoose = new JButton("CHOOSE");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pilot p = new Pilot();
				boolean flag = p.chooseFlight(flightNumberTextField.getText());
				if(flag == true) {
					ArrayList<AssignedPilot> AssgPilots = (ArrayList<AssignedPilot>)p.viewFlightAssgDetails();
					DefaultListModel<AssignedPilot> DLM = new DefaultListModel<AssignedPilot>();
					for(int i=0; i<AssgPilots.size(); i++) {
						DLM.addElement(AssgPilots.get(i));
					}
					list.setModel(DLM);
					JOptionPane.showMessageDialog(null, "You have been assigned successfully!");
				}else {
					JOptionPane.showMessageDialog(null, "You cannot be assigned!");
				}
			}
		});
		btnChoose.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnChoose.setBounds(274, 234, 96, 21);
		contentPane.add(btnChoose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 46, 437, 155);
		contentPane.add(scrollPane);
		
		list = new JList<AssignedPilot>();
		scrollPane.setViewportView(list);
		Pilot p = new Pilot();
		ArrayList<AssignedPilot> AssgPilots = (ArrayList<AssignedPilot>)p.viewFlightAssgDetails();
		DefaultListModel<AssignedPilot> DLM = new DefaultListModel<AssignedPilot>();
		for(int i=0; i<AssgPilots.size(); i++) {
			DLM.addElement(AssgPilots.get(i));
		}
		list.setModel(DLM);
	}
}
