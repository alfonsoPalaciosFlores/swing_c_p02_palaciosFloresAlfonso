/**
 * PanelEmpresa.java
22 nov. 2021 10:31:28
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * @author alfonso palacios
 *
 */
public class PanelEmpresa extends JPanel {
	
	private String nombreEmpresa;
	private JLabel etiquetaNombreEmpresa;
	private Font fuente;
	
	public PanelEmpresa() {
		
		//this.setLayout(null); mirar si conn layaout y colocarlo en el centro????
		//creo elementos
		nombreEmpresa = "Inmobiliaria Casa Mediterranea";
		
		etiquetaNombreEmpresa = new JLabel();
		etiquetaNombreEmpresa.setText(nombreEmpresa);//ver que me salga las letras
		etiquetaNombreEmpresa.setPreferredSize(new Dimension(200,100));
		fuente = new Font("Arial", 80, Font.BOLD);
		//añado fuente ver la fuente
		this.setFont(fuente);

		etiquetaNombreEmpresa.setForeground(Colores.azul);
		
		this.setBackground(Colores.marron);
		
	
		
		
		this.add(etiquetaNombreEmpresa);
		
		this.setVisible(true);
		
		
	}

}
