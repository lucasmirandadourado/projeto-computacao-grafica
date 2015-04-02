import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PlanoCoordenadas extends JPanel {

	BufferedImage imagemCoordenadas;
	
	public PlanoCoordenadas() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouse) {
				imagemCoordenadas.setRGB(mouse.getX(), mouse.getY(), Color.BLACK.getRGB() );
				repaint();
			}
		});
	
		setSize(600, 600);
		
		imagemCoordenadas = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		g.create();
		
		g.drawImage(imagemCoordenadas, 0, 0, null);
		
	}
	

}
