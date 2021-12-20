/**
 * PanelBotones.java
27 nov. 2021 19:26:41
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

/**
 * @author alfonso palacios
 *
 */
public class PanelBotones extends JPanel implements ActionListener {

	private JButton botonImprimir, botonGuardar, botonNuevo;
	private String rutaNuevo ="../recursos compendio 2/nuevo.png";
	private String rutaGuardar = "../recursos compendio 2/guardar.png";
	private String rutaImprimir ="../recursos compendio 2/imprimir.png";
	
	public PanelBotones() {
		
		this.setLayout(new BorderLayout());
		
		this.setBackground(Colores.marron);
		
		this.setPreferredSize(new Dimension(100,50));
		
		
		
		botonNuevo = new JButton(creaIcono(rutaNuevo, 50,20));
		botonGuardar = new JButton(creaIcono(rutaGuardar, 50,20));
		botonImprimir = new JButton(creaIcono(rutaImprimir, 50,20));
		
		botonGuardar.setToolTipText("Guardar");
		botonImprimir.setToolTipText("Imprimir");
		botonNuevo.setToolTipText("Nuevo");
		
		botonGuardar.setToolTipText("Guarda Registro, rellenar campos obligatorios");
		botonImprimir.setToolTipText("Muestra infomracion, rellenar campos obligatorios");
		botonNuevo.setToolTipText("Crea un nuevo registro, restaura valores de los campos");
		
		botonGuardar.addActionListener(this);
		
		
		Box cajaHorizontal = Box.createHorizontalBox();
		
		cajaHorizontal.add(Box.createHorizontalGlue());
		cajaHorizontal.add(botonNuevo, BorderLayout.CENTER);
		cajaHorizontal.add(Box.createHorizontalGlue());
		cajaHorizontal.add(botonGuardar, BorderLayout.CENTER);
		cajaHorizontal.add(Box.createHorizontalGlue());
		cajaHorizontal.add(botonImprimir, BorderLayout.CENTER);
		cajaHorizontal.add(Box.createHorizontalGlue());
		
		this.add(cajaHorizontal);
		
		this.setVisible(true);
		
		
	}
	
	public ImageIcon creaIcono(String ruta, int x, int y) {
		int anchoIcono = x;
		int altoIcono = y;
		ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
		Image convercionIcono = icono.getImage();
		Image tamanyoIcono = convercionIcono.getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
		ImageIcon iconoFinal = new ImageIcon(tamanyoIcono);
		return iconoFinal;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonGuardar) {
			if(PanelDatosPersonales.isVacioDatosPersonales || PanelDatosInmueble.isVacioDatosInmuebles) {
				JOptionPane.showMessageDialog(null, "Falta campos obligatorioas por rellenar", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
				
			else
				JOptionPane.showMessageDialog(null, "Registro guardado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
		PanelDatosPersonales.isVacioDatosPersonales =  false;
		PanelDatosInmueble.isVacioDatosInmuebles = false;
	}

}
