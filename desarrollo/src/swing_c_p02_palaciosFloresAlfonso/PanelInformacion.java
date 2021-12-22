/**
 * PanelInformacion.java
28 nov. 2021 5:39:45
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

/**
 * @author alfonso palacios
 *
 */

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;



public class PanelInformacion extends JPanel {
	private JPanel panelDatosArrendador, panelDatosInmueble;
	JLabel etiquetaDatosArrendador, etiquetaDatosInmueble;
	JTextArea areaDeTextoDatosArrendador, areaDeTextoDatosInmueble;
	String textoArrendador, textoInmueble;

	/*
	 * el jtabbed se añade a la ventana y los paneles al jtabbed
	 */
	public PanelInformacion() {
		
		this.setPreferredSize(new Dimension(200,400));
		JTabbedPane pestañas;

		pestañas = new JTabbedPane();

		/* propiedades Panel1 */
		 componentesPanelDatosArrendador();
		/* propiedades Panel2 */
		 componentesPanelDatosInmueble();
		
		pestañas.addTab("Datos del arrendador", panelDatosArrendador);
		pestañas.addTab("Datos del inmueble", panelDatosInmueble);
	

		this.add(pestañas);

		
		

	}

	private void componentesPanelDatosArrendador() {
		panelDatosArrendador = new JPanel();
		panelDatosArrendador.setLayout(null);

		/*
		 * Propiedades del Label, lo instanciamos, posicionamos y activamos los eventos
		 */
		etiquetaDatosArrendador = new JLabel();
		etiquetaDatosArrendador.setText("Datos del Inmueble");
		etiquetaDatosArrendador.setPreferredSize(new Dimension(200,400));
		//etiquetaDatosArrendador.setBounds(120, 20, 180, 23);

		textoArrendador = "Nombre: " + " \nApellidos: " + "\nDNI: " + "\nTelefono: ";
		areaDeTextoDatosArrendador = new JTextArea();
		areaDeTextoDatosArrendador.setText(textoArrendador);
		areaDeTextoDatosArrendador.setPreferredSize(new Dimension(200,400));
		//areaDeTexto.setBounds(20, 50, 350, 100);

		/* Agregamos los componentes al Contenedor */
		panelDatosArrendador.add(etiquetaDatosArrendador);
		panelDatosArrendador.add(areaDeTextoDatosArrendador);
		panelDatosArrendador.setVisible(true);
		
		

	}

	private void componentesPanelDatosInmueble() {
		panelDatosInmueble = new JPanel();
		panelDatosInmueble.setLayout(null);

		/*
		 * Propiedades del Label, lo instanciamos, posicionamos y activamos los eventos
		 */
		etiquetaDatosInmueble = new JLabel();
		etiquetaDatosInmueble.setText("Datos del Inmueble");
		etiquetaDatosInmueble.setPreferredSize(new Dimension(200,400));
		//etiquetaDatosArrendador.setBounds(120, 20, 180, 23);

		textoArrendador = "Direccion: " + " \nProvincia: " + "\nFecha de alta: " + "\nFecha final de disponibilidad: " +
		"\nNumero de huespes: " + "\nNumero de dormitorios: " + "\nNumero de baños: " + "\nNumero de camas: " + "\nTipo de cama: " +
				"\n¿Niños?: " + "\nEdad de niños: " + "\nExtras: " + "\nPrecio minimo: " + " €"; 
		areaDeTextoDatosInmueble = new JTextArea();
		areaDeTextoDatosInmueble.setText(textoInmueble);
		areaDeTextoDatosInmueble.setPreferredSize(new Dimension(200,400));
		//areaDeTexto.setBounds(20, 50, 350, 100);

		/* Agregamos los componentes al Contenedor */
		panelDatosInmueble.add(etiquetaDatosInmueble);
		panelDatosInmueble.add(areaDeTextoDatosInmueble);
	
		panelDatosInmueble.setVisible(true);
		
	}

}
