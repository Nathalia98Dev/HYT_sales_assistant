import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.zip.Inflater;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewCal extends JFrame implements ActionListener, ItemListener, ChangeListener {
    public final String DESCARGA_DIRECTA = "Descarga directa";
    public final String AFILIADO = "Afiliado";
    public final String COMERCIO = "Comercio";

    private JPanel panelFrame, panelInfo, jpTitle, jpInfoClient, jpSpeech;
    private JPanel jpDialogue, jpTip, jpDescargaDirecta, jpAfiliado, jpComercio;
    private JPanel jpTPD1, jpTPD2, jpTPD3, jpTPT1, jpTPT2, jpTPT3;
    private JScrollPane scrollPane;
    private JLabel title, image;
    private JTable tableClient, tableSpeech;
    private JComboBox comboBox;
    private CardLayout tipCliente;

    private String select = "";

    public NewCal() {
        setSize(500, 500);

        // se agrega titulo a la ventana
        setTitle("HYT Sales assistant");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200, 200));

        starComponents();
    }

    public void starComponents(){
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 450, 250);

        panelFrame = new JPanel();
        panelFrame.setPreferredSize(new Dimension(1024, 570));
        panelFrame.setLayout(new BorderLayout());

        title();
        apertura();
        distribucionSpeech();
        motivoDescarga();

        scrollPane.setViewportView(panelFrame);
        add(scrollPane);
    }

    public void title() {
        jpTitle = new JPanel();

        // Se agrega el logo
        ImageIcon img = new ImageIcon("page-icon.png");
        image = new JLabel();
        image.setBounds(10, 10, 100, 43);
        image.setIcon(new ImageIcon(
                img.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH)));
        jpTitle.add(image);

        // Se agrega el titulo al frame
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        title = new JLabel("Bienvenido 'Vendedor' - " + dtf.format(LocalDateTime.now()), SwingConstants.CENTER);
        title.setOpaque(true); // para quitar el fondo por defecto que es transparente
        title.setBounds(120, 21, 350, 20);
        title.setForeground(Color.BLACK); // color del texto
        title.setFont(new Font("arial", 0, 20)); // para quitar la fuente por defecto, 0->plano, 1->negrita, 2->cursiva, 3->negrita/cursiva
        jpTitle.add(title);
 
        panelFrame.add(jpTitle, BorderLayout.NORTH);
    }

    public void apertura() {
        panelInfo = new JPanel();
        jpInfoClient = new JPanel();

        String[] infoClient = { "Cliente", "ID Cliente", "Campaña", "Sub-campaña", "Pais", "Status",
                "Tipo de cliente" };

        Object[][] rowData = {
                { "Jorge Umaña", "123456789", "campaña", "sub-campaña", "Colombia", "status", "" }
        };

        // tabla de la informacion del cliente
        tableClient = new JTable(rowData, infoClient);
        tableClient.editCellAt(1,6);

        // JScrollPane scrollPane = new JScrollPane(tableClient);
        tableClient.setFillsViewportHeight(true);
        tableClient.setRowSelectionAllowed(false);
        tableClient.getTableHeader().setReorderingAllowed(false);
        tableClient.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBox));
        
        // combox para la ultima columna
        comboBox = new JComboBox();
        comboBox.addItem("Seleccione");
        comboBox.addItem(DESCARGA_DIRECTA);
        comboBox.addItem(AFILIADO);
        comboBox.addItem(COMERCIO);
        comboBox.addItemListener(this);

        //scrollPane.setBounds(10, 60, 990, 40);
        jpInfoClient.add(tableClient);
 
        panelInfo.add(jpInfoClient, BorderLayout.NORTH);
        panelFrame.add(panelInfo, BorderLayout.CENTER);
    }

    public void distribucionSpeech() {
        jpSpeech = new JPanel();
        jpSpeech.setLayout(new BorderLayout());
        
        jpDialogue = new JPanel();
        jpDialogue.setLayout(new BorderLayout());

        jpTPD1 = new JPanel();
        jpTPD2 = new JPanel();
        jpTPD3 = new JPanel();

        jpTip = new JPanel();
        jpTip.setLayout(new BorderLayout());

        jpTPT1 = new JPanel();
        jpTPT2 = new JPanel();
        jpTPT3 = new JPanel();

        jpSpeech.add(jpDialogue, BorderLayout.WEST);
        jpSpeech.add(jpTip, BorderLayout.EAST);
        panelInfo.add(jpSpeech, BorderLayout.WEST);
    }

    public void motivoDescarga() {

    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        select = comboBox.getSelectedItem().toString();
        jpDescargaDirecta = new JPanel();
        jpAfiliado = new JPanel();
        jpComercio = new JPanel();

        if (e.getSource() == comboBox) {

            if (select.equals(DESCARGA_DIRECTA)) {
                // speechC.setText("<html><p>Veo que obtuviste la aplicación a través de uno de nuestros comercios afiliados. Sin embargo, ante todo me encantaría darte una calurosa bienvenida, a nuestra Super APP, ¿Cómo estás? ¿Cómo va tu día? ________ me alegra mucho _________</p><html>");
                // tipC.setText("<html><p><ol><li>Menciona el nombre del comercio</li><li>Escucha al cliente con atención, intenta ser simpático y agradable, usa un tono de voz moderado y evita hablar muy rápido eso generara confianza e inspiraras profesionalismo</li><li>Respóndele al cliente en caso de que te pregunte ¿cómo te va? O si indica que está bien sigue el speech</li></ol></p><html>");
                jpDescargaDirecta.setBackground(Color.GREEN);               
                jpDescargaDirecta.add(speechC);
                jpDescargaDirecta.add(tipC);
                panelTable.add(jpDescargaDirecta);
                tipCliente.next(panelTable); 
            } 
            
            if (select.equals(AFILIADO)) {
                // speechC.setText("<html><p>Veo que obtuviste la aplicación a través del enlace de invitación de uno de nuestros usuarios, Sin embargo, ante todo me encantaría darte una calurosa bienvenida, a nuestra Super APP, ¿Cómo estás? ¿Cómo va tu día? _____________ me alegra mucho _________</p><html>");
                // tipC.setText("<html><p><ol><li>Escucha al cliente con atención, intenta ser simpático y agradable, usa un tono de voz moderado y evita hablar muy rápido eso generara confianza e inspiraras profesionalismo</li><li>Respóndele al cliente en caso de que te pregunte ¿cómo te va? O si indica que está bien, sigue el speech</li></ol></p><html>");
                jpAfiliado.setBackground(Color.BLUE);             
                jpAfiliado.add(speechC);
                jpAfiliado.add(tipC);
                panelTable.add(jpAfiliado);
                tipCliente.next(panelTable); 
            } 
            
            if (select.equals(COMERCIO)) {
                // speechC.setText("<html><p>Veo que obtuviste la aplicación a través de uno de nuestros comercios afiliados*, Sin embargo, ante todo me encantaría darte una calurosa bienvenida, a nuestra Super APP, ¿Cómo estás? ¿Cómo va tu día? me alegra mucho __________ </p><html>");
                // tipC.setText("<html><p><ol><li>Escucha al cliente con atención, intenta ser simpático y agradable, usa un tono de voz moderado y evita hablar muy rápido eso generara confianza e inspiraras profesionalismo.</li><li>Respóndele al cliente en caso de que te pregunte ¿cómo te va? O si indica que está bien, sigue el speech</li></ol></p><html>");
                jpComercio.setBackground(Color.MAGENTA);               
                jpComercio.add(speechC);
                jpComercio.add(tipC);
                panelTable.add(jpComercio);
                tipCliente.next(panelTable); 
            }
        }        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public static void main(String[] args) throws Exception {
        NewCal formulario1 = new NewCal();

        // coordenadas de la ventana junto con el tamaño que tendra en pixeles
        formulario1.setBounds(0, 0, 1024, 570);
        // formulario1.setBounds(0, 0, 420, 250);

        // para que se vea la ventana
        formulario1.setVisible(true);

        // para que la ventana no se pueda cambiar de tamaño
        formulario1.setResizable(true);

        // para que la ventana se inicie en el centro de la pantalla
        formulario1.setLocationRelativeTo(null);
    }
}
