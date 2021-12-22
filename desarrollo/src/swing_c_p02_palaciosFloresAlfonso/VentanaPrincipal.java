/**
 * VentanaPrincipal.java
17 nov. 2021 12:21:19
@author Alfonso Palacios
 */
package swing_c_p02_palaciosFloresAlfonso;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author alfonso palacios
 *
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

	private String rutaIcono = "../recursos compendio 2/icono.png";
	private String tituloVentana = "Gestión Apartamentos Turísticos - Inmobiliaria Casa Mediterranea";
	private JButton botonAltaPisos;
	private JButton botonBajaPisos;
	private PanelCentralVentanaPrincipal panelCentral;
	private String rutaIconoNuevo = "../recursos compendio 2/iconoNuevo.png";
	private String rutaIconoEliminar = "../recursos compendio 2/iconoEliminar.png";

	private JMenuBar miBarra;
	private JMenu archivo, registro, ayuda;
	private JMenuItem salir, altaPiso, bajaPiso, acercaDe;

	public VentanaPrincipal() {

		estableceVentana(rutaIcono, tituloVentana, creaImagen(rutaIcono, 8, 8));

		this.setLayout(new BorderLayout());

		panelCentral = new PanelCentralVentanaPrincipal();
		this.add(panelCentral, BorderLayout.CENTER);

		estableceBotones();

		this.getContentPane().setBackground(Colores.azul);

		estableceBarra();

	}

	/**
	 * 
	 */
	private void estableceBarra() {
		// creo la barra
		miBarra = new JMenuBar();
		miBarra.setBackground(Colores.azul);
		// creo las opciones de la barra
		archivo = new JMenu("Archivo");
		registro = new JMenu("Regristro");
		ayuda = new JMenu("Ayuda");

		// creo las opciones del menu

		salir = new JMenuItem("Salir");
		altaPiso = new JMenuItem("Alta Piso");
		bajaPiso = new JMenuItem("Baja Piso");
		acercaDe = new JMenuItem("Acerca de");

		salir.setBackground(Colores.violeta);
		altaPiso.setBackground(Colores.violeta);
		bajaPiso.setBackground(Colores.violeta);
		acercaDe.setBackground(Colores.violeta);
		
		//establezco tooltiptext
		salir.setToolTipText("Salir de la aplicacion");
		altaPiso.setToolTipText("Da de alta un inmueble");
		bajaPiso.setToolTipText("Da de baja un inmueble");
		acercaDe.setToolTipText("Informacion de la empresa");
		
		

		// agrego funciones y atajo de teclado
		registro.setMnemonic(KeyEvent.VK_R);
		altaPiso.setMnemonic(KeyEvent.VK_A);
		bajaPiso.setMnemonic(KeyEvent.VK_B);
		
		salir.addActionListener(this);
		altaPiso.addActionListener(this);
		bajaPiso.addActionListener(this);
		acercaDe.addActionListener(this);

		// agregamos los elementos al reves de como lo he creado
		archivo.add(salir);
		registro.add(altaPiso);
		registro.add(bajaPiso);
		ayuda.add(acercaDe);

		miBarra.add(archivo);
		miBarra.add(registro);
		miBarra.add(ayuda);

		this.setJMenuBar(miBarra);

	}

	/**
	 * 
	 */
	private void estableceBotones() {
		// establecer botones
		botonAltaPisos = new JButton(creaIcono(rutaIconoNuevo, 40, 30));
		botonBajaPisos = new JButton(creaIcono(rutaIconoEliminar, 40, 30));

		botonAltaPisos.setBackground(Colores.violeta);
		botonBajaPisos.setBackground(Colores.violeta);

		botonAltaPisos.setMnemonic(KeyEvent.VK_A);
		botonBajaPisos.setMnemonic(KeyEvent.VK_B);

		botonAltaPisos.addActionListener(this);
		botonBajaPisos.addActionListener(this);
		
		//set tooltiptext
		botonAltaPisos.setToolTipText("Da de alta un inmueble");
		botonBajaPisos.setToolTipText("Da de baja un inmueble");
		

		Box cajaHorizontalBotones = Box.createHorizontalBox();
		cajaHorizontalBotones.setPreferredSize(new Dimension(60, 60));
		cajaHorizontalBotones.add(Box.createHorizontalGlue());
		cajaHorizontalBotones.add(botonAltaPisos, BorderLayout.CENTER);
		cajaHorizontalBotones.add(Box.createHorizontalGlue());
		cajaHorizontalBotones.add(botonBajaPisos, BorderLayout.CENTER);
		cajaHorizontalBotones.add(Box.createHorizontalGlue());

		this.add(cajaHorizontalBotones, BorderLayout.SOUTH);
	}

	/**
	 * establece el tamaño de la ventana y la posiciona en el centro de pantalla
	 * 
	 * @param cadena de la ruta de la imagen para establecer de icono
	 * @param string con el nombre del titulo de la ventana
	 * @param Image  para establecerlo como icono, usar el metodo creaIcono
	 */
	private void estableceVentana(String rutaIcono, String tituloVentana, Image miIcono) {

		Toolkit miPantalla = Toolkit.getDefaultToolkit();

		Dimension tamanyoPantalla = new Dimension();

		tamanyoPantalla = miPantalla.getScreenSize();

		int altoPantalla = tamanyoPantalla.height;
		int anchoPantalla = tamanyoPantalla.width;

		this.setBounds(anchoPantalla / 4, altoPantalla / 4, anchoPantalla / 2, altoPantalla / 2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(tituloVentana);
		this.setResizable(false);

		this.setIconImage(miIcono);

	}

	/**
	 * crea una imagen con un tamaño establecido
	 * 
	 * @param String ruta de la imagen
	 * @param int    x ancho del icono,preferiblemente 8
	 * @param int    y alto del icono,preferiblemente 8
	 * @return imagen que sera usada como icono con tamaño establecido
	 */
	public Image creaImagen(String ruta, int x, int y) {
		int anchoIcono = x;
		int altoIcono = y;
		ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
		Image convercionIcono = icono.getImage();
		Image tamanyoIcono = convercionIcono.getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
		return tamanyoIcono;

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

		salir(e);
		bajaPiso(e);
		ayuda(e);
		altaPiso(e);
		

	}

	/**
	 * @param e
	 */
	private void altaPiso(ActionEvent e) {
		if(e.getSource() == botonAltaPisos || e.getSource() == altaPiso) {
			VentanaDialogo miVentanaModal = new VentanaDialogo(this, true);
			miVentanaModal.setVisible(true);
		}
		
	}

	/**
	 * @param e
	 */
	private void ayuda(ActionEvent e) {
		
		String jOptionPanelMensaje = "Nombre de la empresa: Inmobiliaria Casa Mediterranea \n"
				+ "Domicilio: Camino Jaul Bajo s/n Almería\n"
				+ "Telefono: 950222579\n"
				+ "Empresa dedicada al alquiler, compra y venta de inmuebles";
		
		if(e.getSource() == acercaDe)
			JOptionPane.showMessageDialog(null, jOptionPanelMensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
		
	}

	/**
	 * @param e
	 */
	private void bajaPiso(ActionEvent e) {
		String jOptionPanelMensaje = "Esta opcion no esta desarrollada, perdone las molestias";
		
		if(e.getSource() == bajaPiso || e.getSource() == botonBajaPisos)
			JOptionPane.showMessageDialog(null, jOptionPanelMensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
		
	}

	/**
	 * @param e
	 */
	private void salir(ActionEvent e) {
		if (e.getSource() == salir) {
			System.exit(0);
		}

	}

}
