package view.ui;

import java.awt.*;
import javax.swing.*;

public class PackageMetadata extends JPanel {
    private static final long serialVersionUID = 0;

    public PackageMetadata() {
        setLayout(new GridBagLayout());

        // Set up grid bag constraints
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(5, 5, 5, 5);

        // Items label
        JLabel itemsLabel = new JLabel("Items:");
        add(itemsLabel, c);

        // Items text field
        JTextField itemsField = new JTextField(
		 "Item x\n"
		+ "Item y\n"
		+ "Item x\n"
		+ "Item y\n"
		+ "Item x\n"
		+ "Item y\n"
		+ "Item x\n"
		+ "Item y\n"
		+ "Item x\n"
		+ "Item y\n"
	);
        c.gridx++;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(itemsField, c);

        // Price label
        c.gridy++;
        c.gridx = 0;
        c.fill = GridBagConstraints.NONE;
        JLabel priceLabel = new JLabel("Price:");
        add(priceLabel, c);

        // Price text field
        var priceField = new JLabel("$2292.2");
        c.gridx++;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(priceField, c);

        // Address label
        c.gridy++;
        c.gridx = 0;
        JLabel addressLabel = new JLabel("Address:");
        add(addressLabel, c);

        // Address text area
        var addressField = new JLabel("Hell bldg. 129");
        c.gridx++;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        add(addressField, c);

        // Estimated delivery date label
        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 1;
        JLabel estDeliveryDateLabel = new JLabel("Est. Delivery Date:");
        add(estDeliveryDateLabel, c);

        // Estimated delivery date text field
        var estDeliveryDateField = new JLabel("12:37:22");
        c.gridx++;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(estDeliveryDateField, c);

        // Tracking number label
        c.gridy++;
        c.gridx = 0;
        JLabel trackingNumberLabel = new JLabel("Tracking Number:");
        add(trackingNumberLabel, c);

        // Tracking number text field
        var trackingNumberField = new JLabel("#28293");
        c.gridx++;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(trackingNumberField, c);
    }
}
