package org.mathrick.swingsandbox;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
	private static class State {
		public SeqType seqType;
		public boolean fullSeq;
		public int seqArg;
		public int seqFrom;
		public int seqTo;

		public State(SeqType seqType, boolean fullSeq, int seqArg, int seqFrom,
				int seqTo) {
			this.seqType = seqType;
			this.fullSeq = fullSeq;
			this.seqArg = seqArg;
			this.seqFrom = seqFrom;
			this.seqTo = seqTo;
		}
	}

	private static final ButtonGroup buttonGroup = new ButtonGroup();
	private static JSpinner spinFrom;
	private static JSpinner spinTo;
	private static JSpinner spinArg;
	
	private static enum SeqType
	{
		SEQ_FACT,
		SEQ_FIB
	}
	
	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}

		final State state = new State(SeqType.SEQ_FACT, true, 0, 0, 10);
		
		JFrame frame = new JFrame("Fractonacci");
		frame.setMinimumSize(new Dimension(500, 300));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel1, 12, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel1, 12, SpringLayout.WEST, frame.getContentPane());
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
		
		radioFact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state.seqType = SeqType.SEQ_FACT;
			}
		});

		radioFib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state.seqType = SeqType.SEQ_FIB;
			}
		});

		final JCheckBox checkFullSeq = new JCheckBox("Generate full sequence");
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
		
		final JTextPane textResult = new JTextPane();
		JScrollPane scroll = new JScrollPane(textResult);
		panel.add(scroll);
		textResult.setBorder(null);
		textResult.setAlignmentY(Component.TOP_ALIGNMENT);
		textResult.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		JPanel panel4 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel1, 0, SpringLayout.SOUTH, panel4);
		frame.getContentPane().add(panel4);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showSequence(textResult, state);
			}
		});
		panel4.add(btnGenerate);
		
		final JPanel panel5 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel4, 6, SpringLayout.SOUTH, panel5);
		springLayout.putConstraint(SpringLayout.WEST, panel4, 0, SpringLayout.WEST, panel5);
		springLayout.putConstraint(SpringLayout.EAST, panel4, 0, SpringLayout.EAST, panel5);
		frame.getContentPane().add(panel5);
		final CardLayout argLayout = new CardLayout(0, 0);
		panel5.setLayout(argLayout);
		
		JPanel panelFullSeq = new JPanel();
		panel5.add(panelFullSeq, "fullSeq");
		panelFullSeq.setLayout(new BoxLayout(panelFullSeq, BoxLayout.X_AXIS));
		
		JLabel lblFrom = new JLabel("From");
		panelFullSeq.add(lblFrom);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(6);
		panelFullSeq.add(horizontalStrut_1);
		
		spinFrom = new JSpinner();
		spinFrom.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				state.seqFrom = ((Integer)spinFrom.getValue());
			}
		});
		panelFullSeq.add(spinFrom);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(6);
		panelFullSeq.add(horizontalStrut_2);
		
		JLabel lblTo = new JLabel("to");
		panelFullSeq.add(lblTo);
		
		Component horizontalStrut = Box.createHorizontalStrut(6);
		panelFullSeq.add(horizontalStrut);
		
		spinTo = new JSpinner();
		spinTo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				state.seqTo = ((Integer)spinTo.getValue());
			}
		});
		panelFullSeq.add(spinTo);
		
		Component glue = Box.createGlue();
		panelFullSeq.add(glue);
		
		JPanel panelShortSeq = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelShortSeq.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel5.add(panelShortSeq, "shortSeq");
		
		JLabel lblArgument = new JLabel("Argument");
		panelShortSeq.add(lblArgument);
		
		spinArg = new JSpinner();
		spinArg.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				state.seqArg = ((Integer)spinArg.getValue());
			}
		});
		panelShortSeq.add(spinArg);
		
		checkFullSeq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state.fullSeq = (checkFullSeq.isSelected());
				if (state.fullSeq)
				{
					argLayout.show(panel5, "fullSeq");
				} else
				{
					argLayout.show(panel5, "shortSeq");
				}
				
			}
		});
		
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

	protected static void showSequence(JTextPane text, State state) {

		StringBuilder str = new StringBuilder();
		String fmtFact = "%d! = %d\n";
		String fmtFib = "fib(%d) = %d\n";
		
		if(state.fullSeq)
		{
			switch(state.seqType)
			{
				case SEQ_FACT:
					str.append(String.format(fmtFact, 1, MathOps.factorial(1)));
			}
		} else
		{
			
		}
	}
}
