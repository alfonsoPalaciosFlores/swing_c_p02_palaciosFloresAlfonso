/**
 * VentanaDialogo.java
21 nov. 2021 19:14:57
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import javafx.scene.paint.Color;

import java.awt.Container;
/**
 * @author alfonso palacios
 *
 */
public class VentanaDialogo extends JDialog {
	
	private PanelEmpresa panelEmpresa;
	private Container contenedor;
	private PanelDatosPersonales panelDatosPersonales;
	private PanelDatosInmueble panelDatosInmueble;
	private PanelBotones panelBotones;
	private PanelInformacion panelInformacion;
	
	
	public VentanaDialogo(VentanaPrincipal miVentanaPrincipal, boolean modal) {
		
		super(miVentanaPrincipal, modal);
	
		this.setTitle("Alta Pisos");
		this.setSize(this.getToolkit().getScreenSize()); 
		
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());

		
		panelEmpresa = new PanelEmpresa();
		contenedor.add(panelEmpresa, BorderLayout.NORTH);
				
		panelDatosPersonales = new PanelDatosPersonales();
		contenedor.add(panelDatosPersonales,BorderLayout.WEST);
		
		panelDatosInmueble = new PanelDatosInmueble();
		contenedor.add(panelDatosInmueble,BorderLayout.CENTER);
		
		panelBotones = new PanelBotones();
		contenedor.add(panelBotones, BorderLayout.SOUTH);
		
		panelInformacion = new PanelInformacion();
		contenedor.add(panelInformacion, BorderLayout.EAST);
		
		
	}
	

}
