import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class mainView {

	private JFrame frmProxypullerGoogle;
	private JTextField txtProxiesByProxiesme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView window = new mainView();
					window.frmProxypullerGoogle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProxypullerGoogle = new JFrame();
		frmProxypullerGoogle.setTitle("ProxyPuller - Google Passed Free Proxies");
		frmProxypullerGoogle.setBounds(100, 100, 600, 337);
		frmProxypullerGoogle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProxypullerGoogle.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 564, 202);
		frmProxypullerGoogle.getContentPane().add(scrollPane);
		
		JTextArea txtpnProxiesWillPopulate = new JTextArea();
		scrollPane.setViewportView(txtpnProxiesWillPopulate);
		txtpnProxiesWillPopulate.setLineWrap(true);
		txtpnProxiesWillPopulate.setRows(8);
		txtpnProxiesWillPopulate.setText("Proxies will Populate Here");
		
		JButton btnGetProxies = new JButton("Get Proxies");
		btnGetProxies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String proxies = app.pullProxies();
				txtpnProxiesWillPopulate.setText(proxies);
			}
		});
		btnGetProxies.setBounds(172, 220, 110, 30);
		frmProxypullerGoogle.getContentPane().add(btnGetProxies);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnProxiesWillPopulate.setText("");
			}
		});
		btnClear.setBounds(301, 220, 110, 30);
		frmProxypullerGoogle.getContentPane().add(btnClear);
		
		txtProxiesByProxiesme = new JTextField();
		txtProxiesByProxiesme.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtProxiesByProxiesme.setForeground(Color.WHITE);
		txtProxiesByProxiesme.setHorizontalAlignment(SwingConstants.CENTER);
		txtProxiesByProxiesme.setText("Proxies provided by spys.me. Scaping Via Jaunt Library");
		txtProxiesByProxiesme.setEnabled(false);
		txtProxiesByProxiesme.setEditable(false);
		txtProxiesByProxiesme.setBounds(141, 249, 320, 20);
		frmProxypullerGoogle.getContentPane().add(txtProxiesByProxiesme);
		txtProxiesByProxiesme.setColumns(10);
	}
}
