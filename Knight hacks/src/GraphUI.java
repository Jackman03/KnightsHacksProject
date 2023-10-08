import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GraphUI extends JFrame implements ActionListener {
	
	


	private JFrame window = new JFrame("Sports Cars Unlimited!");
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 1000;
	private static final int INPUT_LAYOUT = 10;
	
	private static final int BUTTON_LENGTH = 100;
	private static final int BUTTON_WIDTH = 50;
	
	private static final int OUTPUT_WIDTH = 50;
	
	private JButton search,showAll,clear,exit;
	
	JLabel makeSearch = new JLabel("Make");
	JTextField makeSearchText = new JTextField(INPUT_LAYOUT);
	
	JLabel ModelSearch = new JLabel("Model");
	JTextField ModelSearchText = new JTextField(INPUT_LAYOUT);
	
	JTextField carResult = new JTextField(OUTPUT_WIDTH);
	
	
	JLabel mileSearch = new JLabel("Miles (<)");
	JTextField milesSearchText = new JTextField(INPUT_LAYOUT);
	
	JLabel costSearch = new JLabel("Cost (<)");
	JTextField costSearchText = new JTextField(INPUT_LAYOUT);
	
	
	
	JPanel searchArea = new JPanel();
	
	Color bottomColor = new Color(26, 42, 46);

	Color topColor = new Color(122, 167, 240);
	
	Color displayColor = new Color(55, 73, 128);
	
	Color advancedMenu = new Color(177, 202, 242);
	
	
    //database connections
    String url = "jdbc:mysql://localhost:3306/sports_cars";

    Connection connection;
    
    
    
   
    DefaultTableModel carTable = new DefaultTableModel();
    JTable table = new JTable(carTable);
    
	String carID;

	public GraphUI(){
		window.setSize(WIDTH,HEIGHT);
		window.setResizable(false);
	
		window.setLayout(null);
		
		
		
		
		
		
		//search area
		//*****************************************
		JPanel searchArea = new JPanel();
		searchArea.setBounds(0, 0, WIDTH, 50);
		searchArea.setBackground(topColor);
	
		searchArea.add(makeSearch);
		searchArea.add(makeSearchText);
		
		searchArea.add(ModelSearch);
		searchArea.add(ModelSearchText);

		
		search = new JButton("Search");
		
		search.setPreferredSize(new Dimension(BUTTON_LENGTH, BUTTON_WIDTH));
		search.addActionListener(this);
		searchArea.add(search);
		
		window.add(searchArea);
		//*****************************************
		
		
		//advanced search
		//*****************************************
		JPanel middleArea = new JPanel();
		middleArea.setBounds(0,50,WIDTH,50);
		middleArea.setBackground(advancedMenu);
		
		JLabel showLot = new JLabel("Dont know where to start? Look at the whole lot!");
		middleArea.add(showLot);
		showAll = new JButton("Search All!");
		showAll.setPreferredSize(new Dimension(BUTTON_LENGTH, BUTTON_WIDTH));
		showAll.addActionListener(this);
		middleArea.add(showAll);
		
		//advancedSearchButton = new JButton("Advanced Search");
		
	
		
		window.add(middleArea);
		
		
		
		
		//*****************************************
		
		//display area
		//*****************************************
		JPanel displayArea = new JPanel();
		displayArea.setBounds(0,100,WIDTH,400);
		displayArea.setBackground(displayColor);
		
		
		
		//displayArea.add(carTable);
		
		displayArea.add(new JScrollPane(table));
		
		
		window.add(displayArea);
		//*****************************************
		
		
		JPanel bottom = new JPanel();
		bottom.setBounds(0, 500, WIDTH, (HEIGHT/2)-40);
		bottom.setBackground(bottomColor);
		
		
		clear = new JButton("Clear list");
		
		clear.setPreferredSize(new Dimension(BUTTON_LENGTH, BUTTON_WIDTH));
		clear.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.setPreferredSize(new Dimension(BUTTON_LENGTH, BUTTON_WIDTH));
		exit.addActionListener(this);
		bottom.add(clear);
		bottom.add(exit);
		window.add(bottom);
		
		
		
		window.setVisible(true);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == search) {
			search s = new search();
			
			while(carTable.getRowCount() > 0)
			{
				carTable.removeRow(0);
			}
			
			carTable.setColumnCount(0);
			
			s.actionPerformed(e);
		}
		
		if(e.getSource() == showAll) {
			showLot sl = new showLot();
			sl.actionPerformed(e);
			
		}
		
		if(e.getSource() == clear) {
			while(carTable.getRowCount() > 0)
			{
				carTable.removeRow(0);
			}
			carTable.setColumnCount(0);
		}
		
		if(e.getSource() == exit) {
			System.exit(0);
		}
		
	}
	
	private class showLot implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				connection = DriverManager.getConnection(url, "root", "password");
				
				String query = "select * from cars;";

				Statement statment = connection.createStatement();
				
				//run the query
				ResultSet rs = statment.executeQuery(query);
				
				
				carTable.addColumn("Cars Avalible");
				
				
				//this part is creating the query statment to decide the type of car the user searches for
				
				while(rs.next()) {
					

					String queryR1 = rs.getString("Make") + ", " + rs.getString("Model") + ", "+ rs.getString("makeyear") +" " +
					rs.getString("miles") + " miles!  ("+ rs.getString("ID") + ")";
					
					//reset the text values 
					makeSearchText.setText("");
					ModelSearchText.setText("");
					
					
					carID = rs.getString("ID");

		            //carTable.addRow(new Object[]{carID, make, Model,color, carYear});
		            
		            carTable.insertRow(0,new Object[]{queryR1});
				}
				
				displayCarInfo();
				
				
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}}
	
	
	private class search implements ActionListener {
		


		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			//base cases before we search the DB
			
			if(makeSearchText.getText().equalsIgnoreCase("") || ModelSearchText.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null,"Please enter valid paramaters!", "Error", JOptionPane.ERROR_MESSAGE);
				return;

			}
			

			
			try{	//try and acess the database
				connection = DriverManager.getConnection(url, "root", "password");
				
				String baseQuery = "select * from cars where";
				
				String query = "select * from cars where make ='" +makeSearchText.getText()+"' and model ='" + ModelSearchText.getText() + "';";

				Statement statment = connection.createStatement();
				
				//run the query
				ResultSet rs = statment.executeQuery(query);
				

				if(!rs.isBeforeFirst() ) {	//cehcking if we dont have that car on file
					JOptionPane.showMessageDialog(null,"We dont seem to have a " +makeSearchText.getText()+", " +
				ModelSearchText.getText() + " on hand", "Error", JOptionPane.ERROR_MESSAGE);
					makeSearchText.setText("");
					ModelSearchText.setText("");
				}
				
				else {
						carTable.addColumn("Cars Avalible");
					
					
					//this part is creating the query statment to decide the type of car the user searches for
					
					while(rs.next()) {
						
	
						String queryR1 = rs.getString("Make") + ", " + rs.getString("Model") + ", "+ rs.getString("makeyear") +" " +
								rs.getString("miles") + " miles!  ("+ rs.getString("ID") + ")";
						
						carID = rs.getString("ID");
						
						//reset the text values 
						makeSearchText.setText("");
						ModelSearchText.setText("");
						
			            carTable.insertRow(0,new Object[]{queryR1});
					}
					
					displayCarInfo();
				}
					//create the display table

			}
			
			catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
	void finance() {
		
		//this will bring up the finance menu
		
		
	}
	
	void displayCarInfo() {
		
		table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                int selectedColumn = table.getSelectedColumn();

                if (selectedRow != -1 && selectedColumn != -1) {
                    Object cellValue = table.getValueAt(selectedRow, selectedColumn);
                    
                    String id = cellValue.toString();
                    
                    int len = id.length();
                    
                    id = id.substring(len-3, len-1);
                    
    				
					try {
						
						String query = "select * from cars where ID =" + id+";";
						
						
						
						Statement statment;
						statment = connection.createStatement();
						
						ResultSet rs = statment.executeQuery(query);
						
						 String price = "";
						 String color = "";
						 String model = "";
						 String specsList = "";
						
						if(rs.next()){
							
							color = rs.getString(4);
							price = rs.getString(6);
							model = rs.getString(3);
							specsList =  "Miles:" + rs.getString(7) + ". Transmission: "+ rs.getString(8)+ ". Engine: " + rs.getString(9);
							}
						
						Object[] options = { "FINANCE NOW", "KEEP LOOKING" };
						
						int res = JOptionPane.showOptionDialog(null,"The " + cellValue  + " could be yours soon!\n" + 
						"$ " + price + " Finance Now! \n" + 
								"Your new "+ model + " looks great in "+ color + "!\n" 
								+ "Specs:" + specsList
								, "Hop in!", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null, options, options[0]);
						
						
						if (res == JOptionPane.YES_OPTION) {	//if ther user wants to purchase the car
							
							//the finance option
							
							String downPayment = JOptionPane.showInputDialog("Please input your down payment up to: $" + price); 
							
							 Double dPrice = Double.parseDouble(price);
							 Double ddPayment = Double.parseDouble(downPayment);
							
							
							if(ddPayment > dPrice || ddPayment < 0) {
								JOptionPane.showMessageDialog(null, "Your downpayment is invalid! Please try again", "Error", JOptionPane.ERROR_MESSAGE);
								return;

						 }
							
							//store the downpayment for caculatuons later
							
							Object[] possibleValues = { "12 months", "24 months", "36 months" };

							 Object selectedValue = JOptionPane.showInputDialog(null,
							             "Please select a payment plan", "Input",
							             JOptionPane.INFORMATION_MESSAGE, null,
							             possibleValues, possibleValues[0]);
							 
							 
							 Double months = 0.0;
							 
							 //convert the price and downpayment to ints
							 
						
							 
							 //chrck if downpayment is greater then car payment!
							 
							 //if the downpayment is greater then the payment or less then 0
							 
							 
							 
							 Double totalAmount = dPrice - ddPayment;
							 
							 
							 if(selectedValue == "12 months") {
								 months = 12.0;
							 }
							 
							 else if(selectedValue == "24 months") {
								 months = 24.0;
							 
							 }
							 
							 else if(selectedValue == "36 months") {
								 months = 36.0;
							 
							 }
							 
							 //System.out.println(months);
							 
							 Double perMonth = 0.0;
							 
							 perMonth = totalAmount / months;
							 
							 DecimalFormat df_obj = new DecimalFormat("#.##");
							 
							 
							 
							 
							 String line = "\n With a downpayment of $" + ddPayment + " your new price comes to: $ " + totalAmount;
							 String line2 = "\n Over a total of " + months + " months you will pay " +df_obj.format(perMonth) + " per month!";
							 
							 String divider = "\n****************************************************************************************";	
							 
							 
							 
							 
							 Object[] options2 = { "i'll take it!", "not for me" };
							 
								int checkout = JOptionPane.showOptionDialog(null,"Payment Plan\n" +divider+ line + line2 + divider, "Your payment!", 
										JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null, options2, options2[0]);
								
								
								
								
								
								if (checkout == JOptionPane.YES_OPTION) {
									
									
									
									JOptionPane.showMessageDialog(null,"You are now the proud ownwer of a " + model + "!!!!!\n" + 
									"Your receipt has been printed out to a file (receipt.txt)", "Congratulations!!!!", JOptionPane.INFORMATION_MESSAGE);
									
									
									//we need to generate the recepti abd remove the car from the database
									String deleteQuery = "DELETE FROM cars WHERE id =" + id+";";
									
									Statement statement = connection.createStatement();
									
									statement.executeUpdate(deleteQuery);
									
									
									FileWriter fileWriter;
									
									try {
										fileWriter = new FileWriter("receipt.txt", true);
									    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
							            PrintWriter printWriter = new PrintWriter(bufferedWriter);
							            
							            TimeZone defaultTimeZone = TimeZone.getDefault();
								        
								        // Get the time zone abbreviation
								        String abbreviation = defaultTimeZone.getDisplayName(false, TimeZone.SHORT);
								        
								        // Create a SimpleDateFormat object with the desired format
										 Date currentDate = new Date(System.currentTimeMillis());
										 
										 
										 SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy, hh:mm:ss a");

									        // Format the date and time and print it
									     String formattedDateTime = sdf.format(currentDate);
							            
									     printWriter.println("");
									     
									     printWriter.println(divider);
							            
							            printWriter.println(formattedDateTime +"\n" + 
							            					cellValue+ "\n" +
							            					specsList + " \n" +
							            					"Down payment: $" + totalAmount + "\n" +
							            					"Monthly payment : $" + df_obj.format(perMonth) + "\n" +
							            					"Pay period: " + months + " months");
							            					
							            printWriter.println(divider);
							            					
							            printWriter.println("");
							            
							            printWriter.close();//close the writer
							            
							            
							            while(carTable.getRowCount() > 0)
										{
											carTable.removeRow(0);
										}
										carTable.setColumnCount(0);
										
									}
									
									catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								}
								
								else if (checkout == JOptionPane.NO_OPTION) {
							    	  return;
							      }
							

							 
							 
							
								//if the user does not checkout with the car
					       else if (res == JOptionPane.NO_OPTION) {
					    	  return;
					      }
					      
					      } else if (res == JOptionPane.CLOSED_OPTION) {
					    	  return;
					         
					      }
						
						
						
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    				
    				//run the query
    				
                }
            }
        });

	}

}



