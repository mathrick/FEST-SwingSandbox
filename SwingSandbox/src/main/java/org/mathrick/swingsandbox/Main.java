package org.mathrick.swingsandbox;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Main {
	private static final ButtonGroup buttonGroup = new ButtonGroup();
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		
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
		
		JLabel labelSeqType = new JLabel("Sequence type");
		
		Font boldFont = labelSeqType.getFont().deriveFont(Font.BOLD); 
		labelSeqType.setFont(boldFont);
		labelSeqType.setAlignmentY(Component.TOP_ALIGNMENT);
		panel1.add(labelSeqType);
		
		JPanel panel2 = new JPanel();
		panel2.setAlignmentY(Component.TOP_ALIGNMENT);
		panel2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel1.add(panel2);
		panel2.setBorder(new EmptyBorder(0, 12, 0, 0));
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		Component verticalStrut_1 = Box.createVerticalStrut(6);
		panel2.add(verticalStrut_1);
		
		JRadioButton radioFact = new JRadioButton("Factorial");
		radioFact.setSelected(true);
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
		labelResult.setFont(boldFont);
		labelResult.setAlignmentY(Component.TOP_ALIGNMENT);
		panel3.add(labelResult);
		
		Component verticalStrut = Box.createVerticalStrut(6);
		panel3.add(verticalStrut);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBorder(new EmptyBorder(0, 12, 0, 0));
		panel3.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JTextPane textResult = new JTextPane();
		JScrollPane scroll = new JScrollPane(textResult);
		panel.add(scroll);
		textResult.setBorder(null);
		textResult.setAlignmentY(Component.TOP_ALIGNMENT);
		textResult.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
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
		panel5.add(panelFullSeq, "fullSeq");
		panelFullSeq.setLayout(new BoxLayout(panelFullSeq, BoxLayout.X_AXIS));
		
		JLabel lblFrom = new JLabel("From");
		panelFullSeq.add(lblFrom);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(6);
		panelFullSeq.add(horizontalStrut_1);
		
		textField = new JTextField();
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
		FlowLayout flowLayout = (FlowLayout) panelShortSeq.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel5.add(panelShortSeq, "shortSeq");
		
		JLabel lblArgument = new JLabel("Argument");
		panelShortSeq.add(lblArgument);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		panelShortSeq.add(textField_2);
		textField_2.setColumns(3);
		
		JLabel lblParameters = new JLabel("Parameters");
		lblParameters.setFont(boldFont);
		springLayout.putConstraint(SpringLayout.NORTH, lblParameters, 12, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblParameters, 6, SpringLayout.EAST, panel1);
		springLayout.putConstraint(SpringLayout.NORTH, panel5, 6, SpringLayout.SOUTH, lblParameters);
		springLayout.putConstraint(SpringLayout.WEST, panel5, 12, SpringLayout.WEST, lblParameters);
		frame.getContentPane().add(lblParameters);
		frame.pack();
		frame.setVisible(true);
	}
}
