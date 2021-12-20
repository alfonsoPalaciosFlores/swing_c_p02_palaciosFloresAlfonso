/**
 * PanelDatosInmueble.java
27 nov. 2021 16:58:19
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

import java.awt.event.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author alfonso palacios
 *
 */
public class PanelDatosInmueble extends JPanel implements ActionListener {

	private JLabel etiquetaDireccion, etiquetaProvincia, etiquetaFechaAlta, etiquetaFechaFinDisponibilidad,
			etiquetaNhuesped, etiquetaNbanios, etiquetaNdormitorios, etiquetaNcamas, etiquetaNinios,
			etiquetaPrecioMinimo, etiquetasTipoCama, etiquetaTitulo;
	private JTextField textoDireccion, textoPrecioMinimo;
	private JFormattedTextField cajaDeTextoConFormatoFechaAlta, cajaDeTextoConFormatoFechaFinDisponibilidad;
	private LocalDate hoy = LocalDate.now();
	private LocalDate fechaUnAnio = hoy.plusYears(1);
	private JComboBox<String> comboProvincia, comboTipoDeCama;
	private JSpinner spinnerNhuesped, spinnerNdormintorios, spinnerNbanios, spinnerNcamas, spinnerFechaAlta,
			spinnerFechaFinDisponibilidad;
	private JCheckBox checkExtraNinios;
	private GridBagConstraints constraints;
	private GridBagLayout layout;
	private String[] provincias = { "", "Alava", "Albacete", "Alicante", "Almería", "Asturias", "Avila", "Badajoz",
			"Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "La Coruña",
			"Cuenca", "Gerona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén",
			"León", "Lérida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia", "Las Palmas",
			"Pontevedra", "La Rioja", "Salamanca", "Segovia", "Sevilla", "Soria", "Tarragona", "Santa Cruz de Tenerife",
			"Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza" };

	private String[] tipoCama1 = { "Indvidual" };
	private PanelExtraNinios panelExtraNinios;
	private JLabel imagen1 = new JLabel(creaIcono("../recursos compendio 2/fotoPiso1.jpg", 150, 100));
	private JLabel imagen2 = new JLabel(creaIcono("../recursos compendio 2/fotoPiso2.jpg", 150, 100));
	private JLabel imagen3 = new JLabel(creaIcono("../recursos compendio 2/fotoPiso3.jpg", 150, 100));
	public static boolean isVacioDatosInmuebles = false;
	private Dimension d = new Dimension(80, 20);

	public PanelDatosInmueble() {

		// colocar tamaño
		this.setPreferredSize(new Dimension(500, 100));

		// colocar color azul
		this.setBackground(Colores.verdeFondoPanelDatosInmueble);

		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();

		// creo etiquetas
		creoEtiquetas();
		
		

		// texto
		textoDireccion = new JTextField();
		textoDireccion.setPreferredSize(new Dimension(150, 20));
		textoDireccion.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));

		textoPrecioMinimo = new JTextField();
		textoPrecioMinimo.setPreferredSize(new Dimension(80, 20));
		textoPrecioMinimo.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));
		
		textoDireccion.setToolTipText("Campo Obligatorio");

		// crear spinner

		creaSpinner();
		

		// fecha
		cajaDeTextoConFormatoFechaAlta = new JFormattedTextField();
		cajaDeTextoConFormatoFechaAlta.setValue(hoy.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
		cajaDeTextoConFormatoFechaAlta
				.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));

		cajaDeTextoConFormatoFechaFinDisponibilidad = new JFormattedTextField();

		cajaDeTextoConFormatoFechaFinDisponibilidad
				.setValue(fechaUnAnio.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
		cajaDeTextoConFormatoFechaFinDisponibilidad
				.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));

		// crear combobox

		comboProvincia = new JComboBox<>(provincias);
		comboProvincia.setEditable(true);
		comboProvincia.setEnabled(true);
		comboProvincia.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));
		
		comboProvincia.setToolTipText("Campo obligatorio");

		comboTipoDeCama = new JComboBox<>(tipoCama1);
		comboTipoDeCama.setEditable(true);
		comboTipoDeCama.setEnabled(true);
		comboTipoDeCama.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));

		// checkBox
		checkExtraNinios = new JCheckBox("¿Niños?");
		checkExtraNinios.setPreferredSize(d);
		checkExtraNinios.addActionListener(this);

		// creo el panel

		panelExtraNinios = new PanelExtraNinios();


		insertoImagenes();

		// añadir elementos
		anadirElementosAlLayout();		

		estableceTipoCamas();

		establecePrecio();

		//revisa que los campos obligatorios esten relleno
		if (textoDireccion.getText().equals("") || comboProvincia.getSelectedIndex() == 0)
			isVacioDatosInmuebles = true;

		this.setVisible(true);
	}

	/**
	 * crea los distintos spinner con su formato
	 */
	private void creaSpinner() {
		spinnerNhuesped = new JSpinner(new SpinnerNumberModel(0, 0, 8, 1));
		spinnerNdormintorios = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));
		spinnerNbanios = new JSpinner(new SpinnerNumberModel(0, 0, 2, 1));
		spinnerNcamas = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));

		spinnerFechaAlta = new JSpinner(new SpinnerDateModel());
		spinnerFechaFinDisponibilidad = new JSpinner(new SpinnerDateModel());

		spinnerNhuesped.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));
		spinnerNdormintorios.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));
		spinnerNbanios.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));
		spinnerNcamas.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));
		spinnerFechaAlta.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));
		spinnerFechaFinDisponibilidad
				.setBorder(BorderFactory.createLineBorder(Colores.verdeBordePanelDatosInmueble, 4));

		

		spinnerNhuesped.setPreferredSize(d);
		spinnerNdormintorios.setPreferredSize(d);
		spinnerNbanios.setPreferredSize(d);
		spinnerNcamas.setPreferredSize(d);
		spinnerFechaAlta.setPreferredSize(d);
		spinnerFechaFinDisponibilidad.setPreferredSize(d);
		
	}

	/**
	 * crea las etiquetas
	 */
	private void creoEtiquetas() {
		etiquetaDireccion = new JLabel("* Direccion: ");
		etiquetaFechaAlta = new JLabel("Fecha de alta: ");
		etiquetaFechaFinDisponibilidad = new JLabel("Fecha fin de disponibilidad");
		etiquetaNbanios = new JLabel("Numero de baños: ");
		etiquetaNcamas = new JLabel("Numero de camas: ");
		etiquetaNdormitorios = new JLabel("Numero de dormitorios: ");
		etiquetaNhuesped = new JLabel("Numero de huesped: ");
		etiquetaNinios = new JLabel("Numero de niños: ");
		etiquetaPrecioMinimo = new JLabel("Precio minimo: ");
		etiquetaProvincia = new JLabel("* Provincia: ");
		etiquetasTipoCama = new JLabel("Tipo de Cama: ");
		etiquetaTitulo = new JLabel("DATOS INMUEBLE");
		
	}

	/**
	 * introduce en el layout los elementos creados
	 */
	private void anadirElementosAlLayout() {
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaTitulo, 0, 0, 4, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaDireccion, 1, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(textoDireccion, 1, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaProvincia, 1, 3, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(comboProvincia, 1, 4, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaFechaAlta, 2, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(cajaDeTextoConFormatoFechaAlta, 2, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaFechaFinDisponibilidad, 2, 3, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(cajaDeTextoConFormatoFechaFinDisponibilidad, 2, 4, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaNhuesped, 3, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(spinnerNhuesped, 3, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaNdormitorios, 3, 3, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(spinnerNdormintorios, 3, 4, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaNcamas, 4, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(spinnerNcamas, 4, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaNbanios, 4, 3, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(spinnerNbanios, 4, 4, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetasTipoCama, 5, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(comboTipoDeCama, 5, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(checkExtraNinios, 5, 3, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(panelExtraNinios, 6, 1, 2, 1, 1, 1);

		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(etiquetaPrecioMinimo, 6, 3, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(textoPrecioMinimo, 6, 4, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(imagen1, 8, 1, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(imagen2, 8, 2, 1, 1, 1, 1);
		constraints.fill = GridBagConstraints.NONE;
		this.addComponent(imagen3, 8, 3, 1, 1, 1, 1);
		
	}

	/**
	 * establece el precio diario atendiendo al numero al tipo de cama, numerro de baños y los extras por niños 
	 */
	private void establecePrecio() {
		textoPrecioMinimo.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				double precioTipocama = 0;
				double precioNbanios = 0;
				double precioNinios = 0;
				double precioTotal = 0;
				int valorNcamas = (int) spinnerNcamas.getValue();
				int valorNbanos = (int) spinnerNbanios.getValue();

				int tipoCama = comboTipoDeCama.getSelectedIndex();

				if (tipoCama == 0 || tipoCama == 2)
					precioTipocama = 15 * valorNcamas;
				else
					precioTipocama = 20 * valorNcamas;

				precioNbanios = 25 * valorNbanos;

				if (checkExtraNinios.isSelected())
					precioNinios = 12;

				precioTotal = precioNbanios + precioNinios + precioTipocama;

				String precioFinal = String.valueOf(precioTotal);

				textoPrecioMinimo.setText(precioFinal);

			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
	}

	/**
	 * Establec las opciones a elegir en el ttipo de cama en funcion de numero de camas
	 */
	private void estableceTipoCamas() {
		spinnerNcamas.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int valor = 0;
				if (e.getSource() == spinnerNcamas) {
					valor = (int) spinnerNcamas.getValue();
					if (valor == 0 || valor == 1) {

						comboTipoDeCama.removeItem("Indvidual");
						comboTipoDeCama.removeItem("Doble");
						comboTipoDeCama.removeItem("Cama supletoria");

						comboTipoDeCama.addItem("Indvidual");
					}
					if (valor == 2) {

						comboTipoDeCama.removeItem("Indvidual");
						comboTipoDeCama.removeItem("Doble");
						comboTipoDeCama.removeItem("Cama supletoria");

						comboTipoDeCama.addItem("Indvidual");
						comboTipoDeCama.addItem("Doble");

					}
					if (valor > 2) {

						comboTipoDeCama.removeItem("Indvidual");
						comboTipoDeCama.removeItem("Doble");
						comboTipoDeCama.removeItem("Cama supletoria");

						comboTipoDeCama.addItem("Indvidual");
						comboTipoDeCama.addItem("Doble");
						comboTipoDeCama.addItem("Cama supletoria");
					}

				}

			}

		});
	}

	/**
	 * inserta imagenes del piso cuando el campo direccion esta relleno y pierde el
	 * foco
	 */
	private void insertoImagenes() {
		// imagenes
		imagen1.setVisible(false);
		imagen2.setVisible(false);
		imagen3.setVisible(false);

		textoDireccion.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!textoDireccion.getText().equals("")) {
					imagen1.setVisible(true);
					imagen2.setVisible(true);
					imagen3.setVisible(true);
				} else {
					imagen1.setVisible(false);
					imagen2.setVisible(false);
					imagen3.setVisible(false);
				}

			}

		});

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

		if (checkExtraNinios.isSelected())
			panelExtraNinios.setVisible(true);
		else
			panelExtraNinios.setVisible(false);

	}

}
