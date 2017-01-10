package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FileDialog;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

public class LastFMImportGUI {

	private JFrame frmLastfmImport;
	private File fSelectedFile;
	private JTextField txtLastfmUsername;
	private JTextField txtLastfmPassword;
	private JTextField txtSelectFile;
	private JLabel lblSendScrobbles;
	private JCheckBox chckbxSendscrobbles;
	private JTextPane txtpnOutput;
	private JLabel lblOutput;
	private JButton btnStart;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LastFMImportGUI window = new LastFMImportGUI();
					window.frmLastfmImport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LastFMImportGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLastfmImport = new JFrame();
		frmLastfmImport.setTitle("Last.FM Import");
		frmLastfmImport.setBounds(100, 100, 706, 581);
		frmLastfmImport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{145, 354, 0};
		gridBagLayout.rowHeights = new int[]{50, 25, 0, 35, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frmLastfmImport.getContentPane().setLayout(gridBagLayout);
		
		JButton btnSelectFile = new JButton("Select File");
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if(fileChooser.showOpenDialog(frmLastfmImport) == JFileChooser.APPROVE_OPTION)
				{
					fSelectedFile = fileChooser.getSelectedFile();
					txtSelectFile.setText(getSelectedFile().getAbsolutePath());
				}
			}
		});
		GridBagConstraints gbc_btnSelectFile = new GridBagConstraints();
		gbc_btnSelectFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelectFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSelectFile.gridx = 0;
		gbc_btnSelectFile.gridy = 0;
		frmLastfmImport.getContentPane().add(btnSelectFile, gbc_btnSelectFile);
		
		txtSelectFile = new JTextField();
		txtSelectFile.setEditable(false);
		GridBagConstraints gbc_txtSelectFile = new GridBagConstraints();
		gbc_txtSelectFile.insets = new Insets(0, 0, 5, 0);
		gbc_txtSelectFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSelectFile.gridx = 1;
		gbc_txtSelectFile.gridy = 0;
		frmLastfmImport.getContentPane().add(txtSelectFile, gbc_txtSelectFile);
		txtSelectFile.setColumns(10);
		
		JLabel lblLastfmUsername = new JLabel("Last.FM Username");
		GridBagConstraints gbc_lblLastfmUsername = new GridBagConstraints();
		gbc_lblLastfmUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastfmUsername.anchor = GridBagConstraints.WEST;
		gbc_lblLastfmUsername.gridx = 0;
		gbc_lblLastfmUsername.gridy = 1;
		frmLastfmImport.getContentPane().add(lblLastfmUsername, gbc_lblLastfmUsername);
		
		txtLastfmUsername = new JTextField();
		GridBagConstraints gbc_txtLastfmUsername = new GridBagConstraints();
		gbc_txtLastfmUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastfmUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastfmUsername.gridx = 1;
		gbc_txtLastfmUsername.gridy = 1;
		frmLastfmImport.getContentPane().add(txtLastfmUsername, gbc_txtLastfmUsername);
		txtLastfmUsername.setColumns(10);
		
		JLabel lblLastfmPassword = new JLabel("Last.FM Password");
		GridBagConstraints gbc_lblLastfmPassword = new GridBagConstraints();
		gbc_lblLastfmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastfmPassword.anchor = GridBagConstraints.WEST;
		gbc_lblLastfmPassword.gridx = 0;
		gbc_lblLastfmPassword.gridy = 2;
		frmLastfmImport.getContentPane().add(lblLastfmPassword, gbc_lblLastfmPassword);
		
		txtLastfmPassword = new JTextField();
		GridBagConstraints gbc_txtLastfmPassword = new GridBagConstraints();
		gbc_txtLastfmPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastfmPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastfmPassword.gridx = 1;
		gbc_txtLastfmPassword.gridy = 2;
		frmLastfmImport.getContentPane().add(txtLastfmPassword, gbc_txtLastfmPassword);
		txtLastfmPassword.setColumns(10);
		
		lblSendScrobbles = new JLabel("Send Scrobbles");
		lblSendScrobbles.setToolTipText("Tells whether to actually scrobble to Last.FM while reading the file.  It's wise to go through the file once first with this off in order to ensure that everything looks good.");
		GridBagConstraints gbc_lblSendScrobbles = new GridBagConstraints();
		gbc_lblSendScrobbles.anchor = GridBagConstraints.WEST;
		gbc_lblSendScrobbles.insets = new Insets(0, 0, 5, 5);
		gbc_lblSendScrobbles.gridx = 0;
		gbc_lblSendScrobbles.gridy = 3;
		frmLastfmImport.getContentPane().add(lblSendScrobbles, gbc_lblSendScrobbles);
		
		chckbxSendscrobbles = new JCheckBox("");
		GridBagConstraints gbc_chckbxSendscrobbles = new GridBagConstraints();
		gbc_chckbxSendscrobbles.anchor = GridBagConstraints.WEST;
		gbc_chckbxSendscrobbles.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxSendscrobbles.gridx = 1;
		gbc_chckbxSendscrobbles.gridy = 3;
		frmLastfmImport.getContentPane().add(chckbxSendscrobbles, gbc_chckbxSendscrobbles);
		
		lblOutput = new JLabel("Output");
		GridBagConstraints gbc_lblOutput = new GridBagConstraints();
		gbc_lblOutput.anchor = GridBagConstraints.NORTH;
		gbc_lblOutput.insets = new Insets(0, 0, 5, 5);
		gbc_lblOutput.gridx = 0;
		gbc_lblOutput.gridy = 4;
		frmLastfmImport.getContentPane().add(lblOutput, gbc_lblOutput);
		
		
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(getSelectedFile() != null)
					{
						appendLine(getSelectedFile().getAbsolutePath());
					}
					
					appendLine(getUsername());
					appendLine(getPassword());
					
					for(int i = 1; i <= 500; i++)
					{
						appendLine(Integer.toString(i));
					}
					
					appendLine("Sleeping...");
					
					Thread.sleep(5000);
					
					for(int i = 500; i <= 1000; i++)
					{
						appendLine(Integer.toString(i));
					}
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		frmLastfmImport.getContentPane().add(scrollPane, gbc_scrollPane);
		
		txtpnOutput = new JTextPane();
		scrollPane.setViewportView(txtpnOutput);
		txtpnOutput.setEditable(false);
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.gridwidth = 2;
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 5;
		frmLastfmImport.getContentPane().add(btnStart, gbc_btnStart);
	}
	
	public File getSelectedFile()
	{
		return fSelectedFile;
	}
	
	public String getUsername()
	{
		return txtLastfmUsername.getText();
	}
	
	public String getPassword()
	{
		return txtLastfmPassword.getText();
	}
	
	public void appendLine(String appendText) throws BadLocationException
	{
		Document doc = txtpnOutput.getStyledDocument();
		doc.insertString(doc.getLength(), String.format("%s\r\n", appendText), null);
	}

}