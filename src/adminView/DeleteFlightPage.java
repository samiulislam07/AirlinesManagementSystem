package adminView;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import flightManagement.FlightDetails;
import users.Admin;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class DeleteFlightPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane FlightInfotextPane;
	private JButton deleteButton;
	private FlightDetails f;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFlightPage frame = new DeleteFlightPage();
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
	public DeleteFlightPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FlightInfotextPane = new JTextPane();
		FlightInfotextPane.setEditable(false);
		FlightInfotextPane.setBounds(237, 56, 250, 150);
		contentPane.add(FlightInfotextPane);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Admin a = new Admin();
					ArrayList<FlightDetails> foundFlight = a.searchFlight(textField.getText());
					if(foundFlight.size() == 0) {
						JOptionPane.showMessageDialog(null, "Sorry! Flight is not FOUND");
					}else {
						for(int i=0; i<foundFlight.size(); i++) {
							FlightInfotextPane.setText("FlightNumber: "+foundFlight.get(i).getFlightNumber()
							+"\nDeparture: "+foundFlight.get(i).getDeparture()
							+"\nArrival:"+foundFlight.get(i).getArrival()
							+"\nDeparture Date:"+foundFlight.get(i).getDepartureDate()
							+"\nArrival Date:"+foundFlight.get(i).getArrivalDate());
						}
						
					}
										
					}
					catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "Sorry! Flight is not FOUND");
						//exc.printStackTrace();
					}
			}
		});
		textField.setBounds(58, 99, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Flight Number to Delete:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 76, 204, 13);
		contentPane.add(lblNewLabel);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(177, 10, 176, 37);
		contentPane.add(txtZisAirlines);
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Admin a = new Admin();
					boolean flag = a.deleteFlightDetails(textField.getText());
					if(flag==true) {
						FlightInfotextPane.setText("");
						textField.setText("");
						JOptionPane.showMessageDialog(null, "Deleted Successfully");
					}
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
		deleteButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		deleteButton.setBounds(318, 216, 85, 21);
		contentPane.add(deleteButton);
		
		btnNewButton = new JButton("Go back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard window = new AdminDashboard();
				dispose();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		
	}
}
