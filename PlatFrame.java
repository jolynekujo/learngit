package plaf;

import java.awt.event.*;
import javax.swing.*;

public class PlatFrame extends JFrame
{
	private JPanel buttonPanel;
	public PlatFrame()
	{
		buttonPanel = new JPanel();
		
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info : infos)
			makeButton(info.getName(), info.getClassName());
		
		add(buttonPanel);
		pack();
	}
	
	void makeButton(String name, final String plafName)
	{
		//add button to panel
		JButton button =  new JButton(name);
		buttonPanel.add(button);
		
		//set button action
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//button action: awitch to the new look-and-feel
				try
				{
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlatFrame.this);
					pack();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
