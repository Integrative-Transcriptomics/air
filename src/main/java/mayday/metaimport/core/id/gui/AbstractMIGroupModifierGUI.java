package mayday.metaimport.core.id.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import mayday.core.gui.MaydayDialog;

import mayday.metaimport.core.id.AbstractMIGroupModifier;

/**
 * 
 * @author Michael Piechotta
 * @version $Revision: 1.2 $, $Date: 2014/11/19 13:46:37 $
 * 
 */
@SuppressWarnings("serial")
public abstract class AbstractMIGroupModifierGUI extends MaydayDialog {

	/**
	 * 
	 */
	protected AbstractMIGroupModifier miGroupModifier;

	/**
	 * Constructor.
	 * 
	 * @param idModifier
	 */
	public AbstractMIGroupModifierGUI(AbstractMIGroupModifier miGroupModifier) {
		super();
		this.miGroupModifier = miGroupModifier;
	}

	/**
	 * 
	 */
	public void init() {
		setLayout(new GridBagLayout());
		setTitle("MIGroups");

		initContent();
		initButtons();

		initLocation();

		setResizable(false);
		pack();
	}

	/**
	 * 
	 */
	abstract protected void initContent();

	/**
	 * 
	 */
	protected void initButtons() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		gbc.weightx = 1.0;
		gbc.weighty = .2;

		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		add(closeButton, gbc);
	}

	/**
	 * Initializes the location to the middle of the screen.
	 * 
	 * taken from PluginManagerDialog
	 */
	protected void initLocation() {
		// get the screen resolution
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		// compute the upper left corner of the dialog to center it on
		// the screen
		int x = (int) ((screen.width - getWidth()) * 0.5);
		int y = (int) ((screen.height - getHeight()) * 0.5);
		setLocation(x, y);
	}

}
