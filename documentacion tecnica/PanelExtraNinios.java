/**
 * PanelExtraNinios.java
27 nov. 2021 18:55:20
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.DimensionUIResource;


/**
 * @author alfonso palacios
 *
 */
public class PanelExtraNinios extends JPanel implements ChangeListener {
	private GridBagConstraints constraints;
	private GridBagLayout layout;
	private JSpinner spinnerEdadNinios;
	private JTextField textoExtras;
	private JLabel etiquetaEdadNinios, etiquetaExtras;

	public PanelExtraNinios() {

		// colocar tamaño
		this.setPreferredSize(new Dimension(500, 50));

		this.setBackground(Colores.marron);

		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();

		etiquetaEdadNinios = new JLabel("Edad Niños: ");
		etiquetaExtras = new JLabel("Extras: ");

		spinnerEdadNinios = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		Dimension d = new Dimension(80, 20);
		spinnerEdadNinios.setPreferredSize(d);
		spinnerEdadNinios.addChangeListener(this);

		textoExtras = new JTextField();
		textoExtras.setPreferredSize(new DimensionUIResource(150, 20));
		

		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaEdadNinios, 1, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(spinnerEdadNinios, 1, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaExtras, 1, 3, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(textoExtras, 1, 4, 1, 1, 1, 1);

		this.setVisible(false);

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

	@Override
	public void stateChanged(ChangeEvent e) {
		int valor = 0;

		if (e.getSource() == spinnerEdadNinios) {
			valor = (int) spinnerEdadNinios.getValue();
			if (valor >= 0 || valor <= 3)
				textoExtras.setText("Cuna");
			if (valor > 3)
				textoExtras.setText("Cama supletoria pequeña");

		}

	}

}
