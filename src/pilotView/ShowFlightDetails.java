package pilotView;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import p1.Admin;
import p1.Pilot;
import p1reqs.FlightDetails;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShowFlightDetails extends JFrame {

	private JPanel contentPane;
	private JTextField searchBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowFlightDetails frame = new ShowFlightDetails();
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
	public ShowFlightDetails() {
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
		txtZisAirlines.setBounds(306, 10, 176, 37);
		contentPane.add(txtZisAirlines);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 69, 696, 384);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnLoadTable = new JButton("View Flights");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin a = new Admin();
				ArrayList<FlightDetails> f = a.viewFlight();
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0; i<f.size(); i++) {
					DLM.addElement(f.get(i));
				}
				list.setModel(DLM);
				
			}
		});
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLoadTable.setBounds(640, 38, 102, 21);
		contentPane.add(btnLoadTable);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PilotDashboard window = new PilotDashboard();
				window.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel searchLabel = new JLabel("Search by Departure");
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		searchLabel.setBounds(10, 42, 109, 13);
		contentPane.add(searchLabel);
		
		searchBar = new JTextField();
		searchBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pilot a = new Pilot();
					ArrayList<FlightDetails> f = a.searchFlight(searchBar.getText());
					if(f.size() == 0) {
						JOptionPane.showMessageDialog(null, "Sorry! Flight is not FOUND");
					}else {
						DefaultListModel DLM = new DefaultListModel();
						for(int i=0; i<f.size(); i++) {
							DLM.addElement(f.get(i));
						}
						list.setModel(DLM);
					}
										
					}catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "EXCEPTION");
						//exc.printStackTrace();
					}
			}
		});
		searchBar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		searchBar.setColumns(10);
		searchBar.setBounds(129, 39, 127, 19);
		contentPane.add(searchBar);
	}
}