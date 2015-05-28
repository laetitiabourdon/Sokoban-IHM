package fr.iutvalence.info.m2103.project.sokoban;

import java.awt.*;

import javax.swing.*;

public class DisplayGame implements Runnable
{
	private Map map;
	
	public DisplayGame(Map map)
	{
		this.map = map;
	}

	@Override
	public void run()
	{
		JFrame window = new JFrame();

		window.setTitle("Sokoban");
		window.setSize(480,500);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		
		
		JPanel panel = new JPanel(new GridLayout(12,12));
		
		for (int i = 11; i >= 0; i--)
		{
			for (int j = 11; j >= 0; j--)
			{
				
				JLabel label = new JLabel();
				
				if (this.map.getElementOfGrid(i, j) == SquareType.VOID)
				{
					label.setIcon(new ImageIcon("img/sol.png"));
				}
				else if (this.map.getElementOfGrid(i, j) == SquareType.WALL)
				{
					label.setIcon(new ImageIcon("img/mur1.png"));
				}
				
				if (this.map.getBoxPos().getX() == i && this.map.getBoxPos().getY() == j)
				{
					label.setIcon(new ImageIcon("img/caisse.png"));
				}
				else if (this.map.getCharPos().getX() == i && this.map.getCharPos().getY() == j)
				{
					label.setIcon(new ImageIcon("img/perso.png"));
				}
				else if (this.map.getRPpos().getX() == i && this.map.getRPpos().getY() == j)
				{
					label.setIcon(new ImageIcon("img/sortie.png"));
				}
				
				panel.add(label);
				
				
				
			}
		}
		
		window.add(panel);
		
		
		window.setVisible(true);
	}
}