/**
 * PanelDatosPersonales.java
22 nov. 2021 11:49:57
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * @author alfonso palacios
 *
 */
@SuppressWarnings("serial")
public class PanelDatosPersonales extends JPanel {

	private JLabel etiquetaNombre, etiquetaApellidos, etiquetaTelefono, etiquetaDni, etiquetaTitulo;
	private JTextField textoNombre, textoApellidos;
	private JFormattedTextField cajaDeTextoConFormatoTelefono, cajaDeTextoConFormatoDni;
	private MaskFormatter mascaraTelefono, mascaraDni;
	private GridBagConstraints constraints;
	private GridBagLayout layout;
	public static boolean isVacioDatosPersonales = false;

	public PanelDatosPersonales() {
		
		

		// colocar tamaño
		this.setPreferredSize(new Dimension(300,100));
		
		//colocar color azul
		this.setBackground(Colores.azulFondoPanelDatosPersonales);

		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();

		etiquetaNombre = new JLabel("* Nombre: ");
		etiquetaApellidos = new JLabel("* Apellidos: ");
		etiquetaDni = new JLabel("* DNI: ");
		etiquetaTelefono = new JLabel("* Telefono: ");
		etiquetaTitulo = new JLabel("DATOS PERSONALES");

		textoNombre = new JTextField();// intetar ponerle que solo sean letras
		textoApellidos = new JTextField();
		

		textoNombre.setPreferredSize(new Dimension(200, 30));
		textoApellidos.setPreferredSize(new Dimension(200, 30));
		
		textoNombre.setBorder(BorderFactory.createLineBorder(Colores.azulBordesDatosPersonales, 3));		
		textoApellidos.setBorder(BorderFactory.createLineBorder(Colores.azulBordesDatosPersonales, 3));
		
		textoApellidos.setToolTipText("Campo Obligatorio");
		textoNombre.setToolTipText("Campo Obligatorio");

		try {
			mascaraTelefono = new MaskFormatter("#########");
			cajaDeTextoConFormatoTelefono = new JFormattedTextField(mascaraTelefono);
			cajaDeTextoConFormatoTelefono.setPreferredSize(new Dimension(200, 30));
			cajaDeTextoConFormatoTelefono.setFocusLostBehavior(cajaDeTextoConFormatoTelefono.COMMIT);
			cajaDeTextoConFormatoTelefono.setBorder(BorderFactory.createLineBorder(Colores.azulBordesDatosPersonales, 3));
			cajaDeTextoConFormatoTelefono.setToolTipText("Campo obligatorio");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			mascaraDni = new MaskFormatter("########?");
			cajaDeTextoConFormatoDni = new JFormattedTextField(mascaraDni);
			cajaDeTextoConFormatoDni.setPreferredSize(new Dimension(200, 30));
			cajaDeTextoConFormatoDni.setFocusLostBehavior(cajaDeTextoConFormatoTelefono.COMMIT);
			cajaDeTextoConFormatoDni.setBorder(BorderFactory.createLineBorder(Colores.azulBordesDatosPersonales, 3));
			cajaDeTextoConFormatoDni.setToolTipText("Campo obligatorio");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaTitulo, 0, 0, 4, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaNombre, 1, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(textoNombre, 1, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaApellidos, 2, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(textoApellidos, 2, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaDni, 3, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(cajaDeTextoConFormatoDni, 3, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaTelefono, 4, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(cajaDeTextoConFormatoTelefono, 4, 2, 1, 1, 1, 1);
		
		
		//cormprueba si hay algun campo obligatorio por rellenar.
		if(textoApellidos.getText().equals("") || textoNombre.getText().equals("") || cajaDeTextoConFormatoTelefono.getText().equals("") || cajaDeTextoConFormatoDni.getText().equals(""))
			isVacioDatosPersonales = true;
		
			
		
		this.setVisible(true);
	}
	private void addComponent(Component component, int row, int column, int width, int height, int weightx,
			int weighty) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		layout.setConstraints(component, constraints);
		this.add(component);
	}
}
