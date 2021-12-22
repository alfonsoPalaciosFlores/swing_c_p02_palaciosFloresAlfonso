/**
 * CambiarImagen.java
27 nov. 2021 22:42:26
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

import javax.swing.*;
import java.util.TimerTask;
import java.awt.Dimension;
import java.util.Timer;

/**
 * @author alfonso palacios
 *
 */
public class PanelImagen extends JPanel {
	
	private JLabel imagen1, imagen2, imagen3;

	public PanelImagen() {

		this.setPreferredSize(new Dimension(200, 100));

		imagen1 = new JLabel(new ImageIcon(getClass().getResource("../recursos compendio 2/fotoPiso1.jpg")));

		imagen2 = new JLabel(new ImageIcon(getClass().getResource("../recursos compendio 2/fotoPiso2.jpg")));

		imagen3 = new JLabel(new ImageIcon(getClass().getResource("../recursos compendio 2/fotoPiso3.jpg")));
		
		Box cajaHorizontal = Box.createHorizontalBox();
		cajaHorizontal.add(imagen1);
		cajaHorizontal.add(Box.createHorizontalGlue());
		cajaHorizontal.add(imagen2);
		cajaHorizontal.add(Box.createHorizontalGlue());
		cajaHorizontal.add(imagen3);

		this.setVisible(true);

	}

}
