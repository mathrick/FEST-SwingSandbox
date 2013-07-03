package com.mycompany.app;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.Box;

public class Main {
	private static final JLabel labelHello = new JLabel("Sequence type");
	private static final ButtonGroup buttonGroup = new ButtonGroup();
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fractonacci");
		frame.setMinimumSize(new Dimension(500, 300));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel1, 12, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel1, 10, SpringLayout.WEST, frame.getContentPane());
		panel1.setBorder(null);
		panel1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		frame.getContentPane().add(panel1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		labelHello.setAlignmentY(Component.TOP_ALIGNMENT);
		panel1.add(labelHello);
		
		JPanel panel2 = new JPanel();
		panel2.setAlignmentY(Component.TOP_ALIGNMENT);
		panel2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel1.add(panel2);
		panel2.setBorder(new EmptyBorder(0, 12, 0, 0));
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		JRadioButton radioFact = new JRadioButton("Factorial");
		buttonGroup.add(radioFact);
		radioFact.setAlignmentY(Component.TOP_ALIGNMENT);
		panel2.add(radioFact);
		
		JRadioButton radioFib = new JRadioButton("Fibonacci");
		radioFib.setAlignmentY(Component.TOP_ALIGNMENT);
		panel2.add(radioFib);
		buttonGroup.add(radioFib);
		
		JCheckBox checkFullSeq = new JCheckBox("Generate full sequence");
		checkFullSeq.setAlignmentY(Component.TOP_ALIGNMENT);
		checkFullSeq.setSelected(true);
		panel2.add(checkFullSeq);
		
		JPanel panel3 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel3, 6, SpringLayout.SOUTH, panel1);
		springLayout.putConstraint(SpringLayout.SOUTH, panel3, -6, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel3, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel3, -10, SpringLayout.EAST, frame.getContentPane());
		panel3.setAlignmentY(Component.TOP_ALIGNMENT);
		panel3.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel3.setBorder(null);
		frame.getContentPane().add(panel3);
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		
		JLabel labelResult = new JLabel("Result");
		labelResult.setAlignmentY(Component.TOP_ALIGNMENT);
		panel3.add(labelResult);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBorder(new CompoundBorder(new EmptyBorder(0, 12, 0, 0), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		panel3.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextPane textResult = new JTextPane();
		panel.add(textResult);
		textResult.setAlignmentY(Component.TOP_ALIGNMENT);
		textResult.setAlignmentX(Component.LEFT_ALIGNMENT);
		textResult.setText("asasdasdasd");
		textResult.setEditable(false);
		
		JPanel panel4 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel1, 0, SpringLayout.SOUTH, panel4);
		frame.getContentPane().add(panel4);
		
		JButton btnGenerate = new JButton("Generate");
		panel4.add(btnGenerate);
		
		JPanel panel5 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel4, 6, SpringLayout.SOUTH, panel5);
		springLayout.putConstraint(SpringLayout.WEST, panel4, 0, SpringLayout.WEST, panel5);
		springLayout.putConstraint(SpringLayout.EAST, panel4, 0, SpringLayout.EAST, panel5);
		frame.getContentPane().add(panel5);
		panel5.setLayout(new CardLayout(0, 0));
		
		JPanel panelFullSeq = new JPanel();
		panel5.add(panelFullSeq, "name_965594730336054");
		panelFullSeq.setLayout(new BoxLayout(panelFullSeq, BoxLayout.X_AXIS));
		
		JLabel lblFrom = new JLabel("From");
		panelFullSeq.add(lblFrom);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(6);
		panelFullSeq.add(horizontalStrut_1);
		
		textField = new JTextField();
		textField.setMinimumSize(new Dimension(4, 20));
		textField.setText("0");
		panelFullSeq.add(textField);
		textField.setColumns(3);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(6);
		panelFullSeq.add(horizontalStrut_2);
		
		JLabel lblTo = new JLabel("to");
		panelFullSeq.add(lblTo);
		
		Component horizontalStrut = Box.createHorizontalStrut(6);
		panelFullSeq.add(horizontalStrut);
		
		textField_1 = new JTextField();
		textField_1.setText("10");
		panelFullSeq.add(textField_1);
		textField_1.setColumns(3);
		
		Component glue = Box.createGlue();
		panelFullSeq.add(glue);
		
		JPanel panelShortSeq = new JPanel();
		panel5.add(panelShortSeq, "name_965597978327799");
		
		JLabel lblArgument = new JLabel("Argument");
		panelShortSeq.add(lblArgument);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		panelShortSeq.add(textField_2);
		textField_2.setColumns(3);
		
		JLabel lblParameters = new JLabel("Parameters");
		springLayout.putConstraint(SpringLayout.NORTH, lblParameters, 12, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblParameters, 6, SpringLayout.EAST, panel1);
		springLayout.putConstraint(SpringLayout.NORTH, panel5, 6, SpringLayout.SOUTH, lblParameters);
		springLayout.putConstraint(SpringLayout.WEST, panel5, 12, SpringLayout.WEST, lblParameters);
		frame.getContentPane().add(lblParameters);
		frame.pack();
		frame.setVisible(true);
	}
}
