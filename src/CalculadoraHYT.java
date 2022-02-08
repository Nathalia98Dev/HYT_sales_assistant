import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.zip.Inflater;

public class CalculadoraHYT extends JFrame implements ActionListener, ItemListener, ChangeListener {
    public final String DESCARGA_DIRECTA = "Descarga directa";
    public final String AFILIADO = "Afiliado";
    public final String COMERCIO = "Comercio";

    private JLabel title, image, speech, tip, speechC, tipC, download;
    private JPanel panel, panelTable, panelCell;
    private JRadioButton radioB1, radioB2, radioB3, radioB4, radioB5, radioB6, radioB7, radioB8, radioB9;
    private ButtonGroup group;
    private JTable tableClient, tableSpeech;
    private JComboBox comboBox;

    private String select = "";

    public CalculadoraHYT() {
        setSize(500, 500);

        // se agrega titulo a la ventana
        setTitle("HYT Sales assistant");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200, 200));

        starComponents();
    }

    private void starComponents() {
        panels();
        labels();
        radioButtons();
        tables();
    }

    private void panels() {
        panel = new JPanel(); // creacion del panel
        this.getContentPane().add(panel); // agregamos el panel a la ventana
        panel.setLayout(null);
        
        panelTable = new JPanel(); // creacion del panel
        panelTable.setBounds(10, 105, 620, 610); // se ubica el panel 
        panelTable.setBackground(Color.BLUE); // se le coloca un fondo al panel 
        panelTable.setLayout(null);
        panel.add(panelTable);

        panelCell = new JPanel(); // creacion del panel
        panelCell.setBounds(10, 105, 620, 610); // se ubica el panel 
        panelCell.setBackground(Color.BLUE); // se le coloca un fondo al panel 
        panelCell.setLayout(null);
        panel.add(panelCell);
        
        /* panelTable = new JPanel(); // creacion del panel
        panelTable.setBounds(10, 105, 620, 610); // se ubica el panel 
        panelTable.setBackground(Color.BLUE); // se le coloca un fondo al panel 
        panelTable.setLayout(null);
        panel.add(panelTable); */
    }

    private void labels() {
        title = new JLabel("Bienvenido 'Vendedor' - DD/MM/AAAA", SwingConstants.CENTER);
        title.setOpaque(true); // para quitar el fondo por defecto que es transparente
        
        title.setBounds(120, 21, 350, 20);
        title.setForeground(Color.BLACK); // color del texto
        // title.setBackground(Color.BLUE);
        title.setFont(new Font("arial", 0, 20)); // para quitar la fuente por defecto, 0->plano, 1->negrita, 2->cursiva,
        // 3->negrita/cursiva
        panel.add(title);

        ImageIcon img = new ImageIcon("page-icon.png");
        image = new JLabel();
        image.setBounds(10, 10, 100, 43);
        image.setIcon(new ImageIcon(
                img.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(image);

        // label de la tabla
        speech = new JLabel();
        speechC = new JLabel();
        tip = new JLabel();
        tipC = new JLabel();

        speech.setText("<html><p><b>Buenos días, ____ te habla ____ soy la persona encargada de darte la bienvenida, a HYT, la Super APP que acabas de descargar ¿Cómo estás? ¿Cómo va tu día? Veo que obtuviste la aplicación a través de uno de nuestros comercios afiliados</b> <i>(En caso de que sea de un referido: Enlace de invitación, Si fue una descarga directa: a través de APP STORE O GOOGLE PLAY)</i></p><p><b>El motivo de mi llamada es familiarizarte con las diversas funcionalidades de nuestra super APP _________<i>(Nombre del cliente)</i> Te comento, HYT, cuenta con varios servicios y productos, por ende, te hare algunas preguntas para poder identificar cuales se ajustan más a tu perfil y necesidad ¿vale? ¿Cuéntame qué te llamó la atención, que fue lo que te motivo a descargar nuestra App?</b></p></html>");
        tip.setText("<html><ol><li>Identifica al cliente por su nombre de forma jovial</li><li>Ve el detalle en el CRM de cuando descargo la aplicación y la fuente ((que el TL lo tome automático del CRM))</li></ol></html>");
        // speechC.setText("Speech");
        // tipC.setText("Tip");

        // combox para la ultima columna
        comboBox = new JComboBox();
        comboBox.addItem(DESCARGA_DIRECTA);
        comboBox.addItem(AFILIADO);
        comboBox.addItem(COMERCIO);
        comboBox.addItemListener(this);

        //
        download = new JLabel("Motivo de la descarga", SwingConstants.CENTER);
        download.setBounds(650, 120, 350, 25);
        download.setForeground(Color.BLACK); // color del texto
        download.setFont(new Font("arial", 0, 20)); // para quitar la fuente por defecto, 0->plano, 1->negrita, 2->cursiva, 3->negrita/cursiva
        panel.add(download);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboBox) {
            select = comboBox.getSelectedItem().toString();

            if (select.equals(DESCARGA_DIRECTA)) {
                // speechC.setText("<html><p>Veo que obtuviste la aplicación a través de uno de nuestros comercios afiliados. Sin embargo, ante todo me encantaría darte una calurosa bienvenida, a nuestra Super APP, ¿Cómo estás? ¿Cómo va tu día? ________ me alegra mucho _________</p><html>");
                // tipC.setText("<html><p><ol><li>Menciona el nombre del comercio</li><li>Escucha al cliente con atención, intenta ser simpático y agradable, usa un tono de voz moderado y evita hablar muy rápido eso generara confianza e inspiraras profesionalismo</li><li>Respóndele al cliente en caso de que te pregunte ¿cómo te va? O si indica que está bien sigue el speech</li></ol></p><html>");
                title.setText(select);
                speechC.setText(select);
                tipC.setText(select);
            } else if (select.equals(AFILIADO)) {
                // speechC.setText("<html><p>Veo que obtuviste la aplicación a través del enlace de invitación de uno de nuestros usuarios, Sin embargo, ante todo me encantaría darte una calurosa bienvenida, a nuestra Super APP, ¿Cómo estás? ¿Cómo va tu día? _____________ me alegra mucho _________</p><html>");
                // tipC.setText("<html><p><ol><li>Escucha al cliente con atención, intenta ser simpático y agradable, usa un tono de voz moderado y evita hablar muy rápido eso generara confianza e inspiraras profesionalismo</li><li>Respóndele al cliente en caso de que te pregunte ¿cómo te va? O si indica que está bien, sigue el speech</li></ol></p><html>");
                title.setText(select);
                speechC.setText(select);
                tipC.setText(select);
            } else if (select.equals(COMERCIO)) {
                // speechC.setText("<html><p>Veo que obtuviste la aplicación a través de uno de nuestros comercios afiliados*, Sin embargo, ante todo me encantaría darte una calurosa bienvenida, a nuestra Super APP, ¿Cómo estás? ¿Cómo va tu día? me alegra mucho __________ </p><html>");
                // tipC.setText("<html><p><ol><li>Escucha al cliente con atención, intenta ser simpático y agradable, usa un tono de voz moderado y evita hablar muy rápido eso generara confianza e inspiraras profesionalismo.</li><li>Respóndele al cliente en caso de que te pregunte ¿cómo te va? O si indica que está bien, sigue el speech</li></ol></p><html>");
                title.setText(select);
                speechC.setText(select);
                tipC.setText(select);
            }
        }
    }

    private void radioButtons() {
        radioB1 = new JRadioButton("Me refirió un amigo", true);
        radioB2 = new JRadioButton("Vi un código QR en una tienda", false);
        radioB3 = new JRadioButton("Vi una publicidad en una red social", false);
        radioB4 = new JRadioButton("Buscaba una wallet", false);
        radioB5 = new JRadioButton("Vi que habían ofertas al usar la app", false);
        radioB6 = new JRadioButton("Me interesa cambiar cripto a dólares (Exchange)", false);
        radioB7 = new JRadioButton("Buscaba una app para enviar dinero", false);
        radioB8 = new JRadioButton("Buscaba una app para hacer un pago con BTC", false);
        radioB9 = new JRadioButton("Buscaba un paquete o asesoría de marketing", false);

        radioB1.setBounds(650, 150, 400, 30);
        radioB2.setBounds(650, 180, 400, 30);
        radioB3.setBounds(650, 210, 400, 30);
        radioB4.setBounds(650, 240, 400, 30);
        radioB5.setBounds(650, 270, 400, 30);
        radioB6.setBounds(650, 300, 400, 30);
        radioB7.setBounds(650, 330, 400, 30);
        radioB8.setBounds(650, 360, 400, 30);
        radioB9.setBounds(650, 390, 400, 30);

        panel.add(radioB1);
        panel.add(radioB2);
        panel.add(radioB3);
        panel.add(radioB4);
        panel.add(radioB5);
        panel.add(radioB6);
        panel.add(radioB7);
        panel.add(radioB8);
        panel.add(radioB9);

        group = new ButtonGroup();
        group.add(radioB1);
        group.add(radioB2);
        group.add(radioB3);
        group.add(radioB4);
        group.add(radioB5);
        group.add(radioB6);
        group.add(radioB7);
        group.add(radioB8);
        group.add(radioB9);
    }

    private void tables() {
        String[] infoClient = { "Cliente", "ID Cliente", "Campaña", "Sub-campaña", "Pais", "Status",
                "Tipo de cliente" };

        Object[][] rowData = {
                { "Jorge Umaña", "123456789", "campaña", "sub-campaña", "Colombia", "status", "" }
        };
        String[] infoSpeech = { "Speech", "Tip" };

        Object[][] rowDataS = {
                { speech.getText(), tip.getText() },
                { speechC.getText(), tipC.getText() }
        };

        // tabla de la informacion del cliente
        tableClient = new JTable(rowData, infoClient);
        tableClient.editCellAt(1,6);

        JScrollPane scrollPane = new JScrollPane(tableClient);
        tableClient.setFillsViewportHeight(true);
        tableClient.setRowSelectionAllowed(false);
        tableClient.getTableHeader().setReorderingAllowed(false);

        tableClient.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBox));
        /* DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        tableClient.getColumnModel().getColumn(6).setCellRenderer(renderer); */

        scrollPane.setBounds(10, 60, 990, 40);
        panel.add(scrollPane);

        // tabla de speech y tips
        tableSpeech = new JTable(rowDataS, infoSpeech);

        JScrollPane scrollPane2 = new JScrollPane(tableSpeech);
        tableSpeech.setFillsViewportHeight(true);
        tableSpeech.setRowSelectionAllowed(false);
        tableSpeech.setRowHeight(500);
        tableSpeech.getTableHeader().setReorderingAllowed(false);

        // tableSpeech.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(panelCell));

        // DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
        // cell.setHorizontalAlignment(SwingConstants.BOTTOM);
        // tableSpeech.getColumnModel().getColumn(0).setCellRenderer(cell);

        scrollPane2.setBounds(10, 10, 600, 600);
        panelTable.add(scrollPane2);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) throws Exception {
        CalculadoraHYT formulario1 = new CalculadoraHYT();

        // coordenadas de la ventana junto con el tamaño que tendra en pixeles
        formulario1.setBounds(0, 0, 1024, 770);

        // para que se vea la ventana
        formulario1.setVisible(true);

        // para que la ventana no se pueda cambiar de tamaño
        formulario1.setResizable(false);

        // para que la ventana se inicie en el centro de la pantalla
        formulario1.setLocationRelativeTo(null);
    }
}