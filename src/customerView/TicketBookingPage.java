package customerView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import flightManagement.FlightDetails;
import flightManagement.Seat;
import flightManagement.Ticket;
import users.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class TicketBookingPage extends JFrame {

	JPanel contentPane;
	JComboBox<String> flightNumberBox;
	JComboBox<String> fromBox;
	JComboBox<String> toBox;
	JComboBox<String> classBox;
	JComboBox<String> seatBox;
	ArrayList<FlightDetails> fd = new ArrayList<>();
	JTextArea bookedSeatsTextArea = new JTextArea("");
	String selectedFrom;
	String selectedTo;
	String selectedFlight;
	String selectedClass;
	Seat[] seats;
	String selectedSeat;
	FlightDetails flight;
	Customer customer;
	String flightNumber;
	
	private void updateFlightInfo() { //for dynamic seat information
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("FDetails.dat"))){
			fd = (ArrayList<FlightDetails>)infile.readObject();
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	private void updateFlightNumbers() {
	    flightNumberBox.removeAllItems(); // Clear existing items
	    selectedFrom = fromBox.getSelectedItem().toString();
	    selectedTo = toBox.getSelectedItem().toString();
	    boolean flag = false;

	    for (int i = 0; i < fd.size(); i++) {
	        flight = fd.get(i);
	        if (selectedFrom.equals(flight.getDeparture()) && selectedTo.equals(flight.getArrival())) {
	            flightNumberBox.addItem(flight.getFlightNumber());
	            flag = true;
	        }
	    }
	    if(flag == false) {
	    	flightNumberBox.addItem("No Flight");
	    }
	}
	
	private void updateSeatBox() {
		updateFlightInfo(); 
		
		if(flightNumberBox.getSelectedItem() == null || classBox.getSelectedItem() == null || classBox.getSelectedItem().toString().equalsIgnoreCase("Selected Class")) {
			seatBox.addItem("Select Seat");
		}else {
			seatBox.removeAllItems(); 
			selectedFlight = flightNumberBox.getSelectedItem().toString();
			selectedClass = classBox.getSelectedItem().toString();
			
			for (int i = 0; i < fd.size(); i++) {
				flight = fd.get(i);
				if (selectedFlight.equals(flight.getFlightNumber())){
					seats = flight.getSeats();
					if(selectedClass.equals("First Class")) {
						for(int j=0; j<20; j++) {
							if(seats[j].getStatus() == false) {
								seatBox.addItem(Integer.toString(seats[j].getSeatNo()));
							}
							
						}
					}else if(selectedClass.equals("Business Class")) {
						for(int j=20; j<40; j++) {
							if(seats[j].getStatus() == false) {
								seatBox.addItem(Integer.toString(seats[j].getSeatNo()));
							}
							
						}
					}else if(selectedClass.equals("Economy Class")) {
						for(int j=40; j<100; j++) {
							if(seats[j].getStatus() == false) {
								seatBox.addItem(Integer.toString(seats[j].getSeatNo()));
							}
							
						}
					}
				}
			}
		}		
	}

	private void updateBookedSeatsTextArea() {
		if (bookedSeatsTextArea != null) {
			if (!bookedSeatsTextArea.getText().trim().isEmpty()) {
			    // If it has text, clear it
				bookedSeatsTextArea.setText("");
			}
		}
		
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("Tickets.dat"))){
			ArrayList<Ticket> ticketArr = (ArrayList<Ticket>)infile.readObject();
			//System.out.println("ticketArr read");
			for(int i=0; i<ticketArr.size(); i++) {
				if(ticketArr.get(i).getPassengerName().equalsIgnoreCase(customer.getName())) {
					if (bookedSeatsTextArea != null) {
	                       bookedSeatsTextArea.append(ticketArr.get(i).toString());
	                }
				}
			}
		}catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	protected void generateTicket() {
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("SessionInfo.dat"))){
			Customer customer = (Customer)infile.readObject();
			Ticket ticket = new Ticket(customer.getName(), (String)flightNumberBox.getSelectedItem(), (String)classBox.getSelectedItem(), (String)seatBox.getSelectedItem());
			try(ObjectInputStream infile2 = new ObjectInputStream(new FileInputStream("Tickets.dat"))){
				ArrayList<Ticket> ticketArr = (ArrayList<Ticket>)infile2.readObject();
				ticketArr.add(ticket);
				try(ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("Tickets.dat"))){
					outfile.writeObject(ticketArr);
				}
			}
		}catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketBookingPage frame = new TicketBookingPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TicketBookingPage() {
		try(ObjectInputStream infile = new ObjectInputStream(new FileInputStream("SessionInfo.dat"))){
			customer = (Customer)infile.readObject();
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		updateFlightInfo();
		
		addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
            	updateBookedSeatsTextArea();
            }
        });
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtZisAirlines = new JLabel();
		txtZisAirlines.setText("ZiS AIRLINES");
		txtZisAirlines.setHorizontalAlignment(SwingConstants.CENTER);
		txtZisAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		txtZisAirlines.setBounds(95, 10, 591, 37);
		contentPane.add(txtZisAirlines);
		
		JLabel lblBookYourTicket = new JLabel("Book your Ticket for a Dream Journey");
		lblBookYourTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookYourTicket.setForeground(Color.BLUE);
		lblBookYourTicket.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblBookYourTicket.setBounds(10, 44, 766, 21);
		contentPane.add(lblBookYourTicket);
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(39, 78, 55, 13);
		contentPane.add(lblNewLabel);
		
		fromBox = new JComboBox();
		fromBox.setToolTipText("");
		fromBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		fromBox.setBounds(90, 75, 114, 21);
		contentPane.add(fromBox);
		fromBox.addItem("Select Departure");
		for(int i=0; i<fd.size(); i++) {
			String departure = fd.get(i).getDeparture();
			// Check if the item is already in the ComboBox
			boolean alreadyAdded = false;
			for (int j = 0; j < fromBox.getItemCount(); j++) {
				if (departure.equals(fromBox.getItemAt(j))) {
					alreadyAdded = true;
			        break;
				}
			}
			if (!alreadyAdded) {
				fromBox.addItem(departure);
			}
		}
		fromBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFlightNumbers();
			}
		});
		
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTo.setBounds(287, 78, 50, 13);
		contentPane.add(lblTo);
		
		toBox = new JComboBox();
		toBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		toBox.setBounds(333, 75, 114, 21);
		contentPane.add(toBox);
		toBox.addItem("Select Destination");
		for(int i=0; i<fd.size(); i++) {
			String arrival = fd.get(i).getArrival();
			    
			// Check if the item is already in the ComboBox
			boolean alreadyAdded = false;
			for (int j = 0; j < toBox.getItemCount(); j++) {
				if (arrival.equals(toBox.getItemAt(j))) {
					alreadyAdded = true;
			        break;
				}
			}
			if (!alreadyAdded) {
				toBox.addItem(arrival);
			}
		}
		toBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFlightNumbers();
			}
		});
		
		
		JLabel lblFlightNumber = new JLabel("Flight Number");
		lblFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightNumber.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblFlightNumber.setBounds(500, 78, 128, 13);
		contentPane.add(lblFlightNumber);
		
		flightNumberBox = new JComboBox();
		flightNumberBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		flightNumberBox.setBounds(624, 75, 114, 21);
		contentPane.add(flightNumberBox);
		flightNumberBox.addItem("Select Flight");
		
		JLabel lblBookedSeats = new JLabel("Booked Seats");
		lblBookedSeats.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookedSeats.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBookedSeats.setBounds(90, 129, 128, 13);
		contentPane.add(lblBookedSeats);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(113, 152, 334, 229);
		contentPane.add(scrollPane);
		
		bookedSeatsTextArea = new JTextArea();
		bookedSeatsTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(bookedSeatsTextArea);
		bookedSeatsTextArea.setEditable(false);
		
		classBox = new JComboBox();
		classBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		classBox.setBounds(500, 146, 114, 21);
		contentPane.add(classBox);
		classBox.addItem("Select Class");
		classBox.addItem("First Class");
		classBox.addItem("Business Class");
		classBox.addItem("Economy Class");
		classBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSeatBox();
			}
		});
		
		seatBox = new JComboBox();
		seatBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		seatBox.setBounds(624, 146, 114, 21);
		contentPane.add(seatBox);
		seatBox.addItem("Select Seat");
		
		JButton btnNewButton = new JButton("Book Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedSeat = seatBox.getSelectedItem().toString();
				String message = customer.buyTicket(selectedFlight, Integer.parseInt(selectedSeat));
				generateTicket();
				//System.out.println("Ticket generated");
				JOptionPane.showMessageDialog(null, message);
				//System.out.println("Updating booked seats area");
				updateBookedSeatsTextArea();
				//System.out.println("Updating seatBox");
				updateSeatBox();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(568, 204, 114, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDashboard window = new CustomerDashboard();
				dispose();
            	window.setLocationRelativeTo(null);
            	window.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(0, 10, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
