/**
 * PanelCentralVentanaPrincipal.java
21 nov. 2021 12:07:17
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

import javax.swing.*;
import java.awt.*;

/**
 * @author alfonso palacios
 *
 */
public class PanelCentralVentanaPrincipal extends JPanel {

	private String mensaje;
	private JLabel etiquetaLogo, etiquetaMensaje;
	private ImageIcon imagenLogo;
	private String rutaIcono = "../recursos compendio 2/icono.png";
	private JTextArea textoMensaje;
	private JTextField campoMensaje;
	//private Color amarillo = new Color(240,217,51);

	public PanelCentralVentanaPrincipal() {

		this.setLayout(new BorderLayout());
		
		
		// establecer imagen
		imagenLogo = new ImageIcon(getClass().getResource(rutaIcono));
		etiquetaLogo = new JLabel(imagenLogo);
		
		mensaje = "Inmobiliaria Casa Mediterranea \nAyuda al alquiler, venta y compra \nde todo tipo de inmueble \nCon la siguiente aplicacion \npuedes dar de alta su piso \ndonde podrás ponerlo en alquiler";
	
		textoMensaje = new JTextArea(mensaje);
		textoMensaje.setPreferredSize(new Dimension(200,150));
		textoMensaje.setOpaque(false);
		textoMensaje.setAlignmentX(CENTER_ALIGNMENT);//mirar bien
		textoMensaje.setAlignmentY(SwingConstants.CENTER);
		textoMensaje.setEditable(false);
		
		
		Box cajaHorizontal = Box.createHorizontalBox();
		
		cajaHorizontal.add(Box.createHorizontalGlue());
		cajaHorizontal.add(Box.createHorizontalStrut(40));
		cajaHorizontal.add(textoMensaje);	
		cajaHorizontal.add(Box.createHorizontalStrut(40));
		cajaHorizontal.add(Box.createHorizontalGlue());
		cajaHorizontal.add(etiquetaLogo);
		cajaHorizontal.add(Box.createHorizontalStrut(40));
		cajaHorizontal.add(Box.createHorizontalGlue());
		
		this.add(cajaHorizontal);
		
		this.setBackground(Colores.amarillo);
		

		this.setVisible(true);
		
	}
	


}
