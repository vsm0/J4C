package view.ui;

import java.awt.*;
import javax.swing.*;

public class PackageEntry extends JPanel
{
	public PackageEntry()
	{
		super();
		/*
		setLayout(new GridBagLayout());
		var constraints = new GridBagConstraints();

		String uid = "1234567890";
		String deliveryStatus = "In Transit";
		double price = 19.99;
		int daysToDelivery = 3;

// Create the components for the panel
JLabel uidLabel = new JLabel("UIID:", SwingConstants.RIGHT);
JTextField uidField = new JTextField(uid, 10);
uidField.setEditable(false);

JLabel deliveryStatusLabel = new JLabel("Delivery Status:", SwingConstants.RIGHT);
JTextField deliveryStatusField = new JTextField(deliveryStatus, 10);
deliveryStatusField.setEditable(false);

JLabel priceLabel = new JLabel("Price Overview:", SwingConstants.RIGHT);
JFormattedTextField priceField = new JFormattedTextField(price);
priceField.setColumns(10);
priceField.setHorizontalAlignment(SwingConstants.TRAILING);
priceField.setEditable(false);

JLabel countdownLabel = new JLabel("Days Until Delivery:", SwingConstants.RIGHT);
JProgressBar countdownBar = new JProgressBar(0, daysToDelivery*24);
countdownBar.setValue((daysToDelivery*24)-(int)(System.currentTimeMillis()/(1000*60*60*24)));
countdownBar.setStringPainted(true);
countdownBar.setFont(new Font("Arial", Font.BOLD, 14));
countdownBar.setForeground(Color.RED);
countdownBar.setBackground(Color.WHITE);

// Add the components to the panel using GridBagLayout
constraints.gridx = 0;
constraints.gridy = 0;
constraints.anchor = GridBagConstraints.EAST;
constraints.insets = new Insets(5, 5, 5, 5);
add(uidLabel, constraints);

constraints.gridx = 1;
constraints.gridy = 0;
constraints.fill = GridBagConstraints.HORIZONTAL;
add(uidField, constraints);

constraints.gridx = 0;
constraints.gridy = 1;
add(deliveryStatusLabel, constraints);

constraints.gridx = 1;
constraints.gridy = 1;
add(deliveryStatusField, constraints);

constraints.gridx = 0;
constraints.gridy = 2;
add(priceLabel, constraints);

constraints.gridx = 1;
constraints.gridy = 2;
add(priceField, constraints);

constraints.gridx = 0;
constraints.gridy = 3;
constraints.gridwidth = 2;
add(countdownLabel, constraints);

constraints.gridx = 0;
constraints.gridy = 4;
constraints.gridwidth = 2;
add(countdownBar, constraints);
*/
	}
}

