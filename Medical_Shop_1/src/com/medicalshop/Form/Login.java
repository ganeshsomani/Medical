package com.medicalshop.Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		frame.setBounds(100, 100, 891, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(391, 120, 159, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(391, 165, 159, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(259, 122, 122, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(259, 167, 120, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(323, 208, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(new Color(102, 204, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel_2.setBounds(240, 43, 280, 37);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
