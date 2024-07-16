package InterfazGrafica;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.*;
import meowparlour.Conexion;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.text.Document;

public class RealizarCompra extends javax.swing.JFrame {

    public RealizarCompra() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializarTablaProductos();
        
        BotonBorrar.setEnabled(false); // Inicialmente deshabilitado

        // Agregar un ListSelectionListener a la tabla
        TablaProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    BotonBorrar.setEnabled(TablaProductos.getSelectedRow() != -1); // Habilitar solo si hay una fila seleccionada
                }
            }
        });

        BotonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarActionPerformed(evt);
            }
        });
    }
    
    private void inicializarTablaProductos() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Codigo de barras", "Nombre", "Descripcion", "Precio sin IVA", "IVA", "Precio con IVA", "Cantidad", "Total con IVA"}
        );
        TablaProductos.setModel(model);
    }
    
    private void actualizarTotales() {
        DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
        double subtotal = 0.0;
        double ivaTotal = 0.0;
        double total = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            int cantidad = (int) model.getValueAt(i, 6);
            double precioSinIVA = (double) model.getValueAt(i, 3);
            double iva = (double) model.getValueAt(i, 4);
            double precioConIVA = (double) model.getValueAt(i, 5);

            subtotal += precioSinIVA * cantidad;
            ivaTotal += iva * cantidad;
            total += precioConIVA * cantidad;
        }

        FieldSubtotal.setText(String.format("Subtotal (sin IVA): %.2f", subtotal));
        FieldIVA.setText(String.format("IVA: %.2f", ivaTotal));
        FieldTotal.setText(String.format("Total: %.2f", total));
    }
    
    private void BotonBorrarActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = TablaProductos.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
            model.removeRow(selectedRow);
            actualizarTotales(); // Actualizar totales después de eliminar una fila
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FieldCodigoBarras = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        FieldSubtotal = new javax.swing.JTextField();
        FieldIVA = new javax.swing.JTextField();
        FieldTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        FieldNIT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        FieldNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FieldDireccion = new javax.swing.JTextField();
        BotonRealizarCompra = new javax.swing.JButton();
        BotonBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 675));
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(234, 202, 164));
        Fondo.setForeground(new java.awt.Color(0, 0, 0));
        Fondo.setMaximumSize(new java.awt.Dimension(1200, 675));
        Fondo.setMinimumSize(new java.awt.Dimension(1200, 675));
        Fondo.setName(""); // NOI18N
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Código de barras");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 200, 40));

        FieldCodigoBarras.setBackground(new java.awt.Color(246, 244, 234));
        FieldCodigoBarras.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        FieldCodigoBarras.setForeground(new java.awt.Color(0, 0, 0));
        FieldCodigoBarras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldCodigoBarras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        FieldCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldCodigoBarrasActionPerformed(evt);
            }
        });
        Fondo.add(FieldCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 450, 60));

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaProductos);

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 790, 510));

        jPanel1.setBackground(new java.awt.Color(234, 202, 164));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FieldSubtotal.setEditable(false);
        FieldSubtotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(FieldSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 310, 40));

        FieldIVA.setEditable(false);
        FieldIVA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(FieldIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 310, 40));

        FieldTotal.setEditable(false);
        FieldTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(FieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 310, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingresa el NIT para la factura");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 40));

        FieldNIT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        FieldNIT.setText("CF");
        jPanel1.add(FieldNIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 310, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ingresa el nombre para la factura");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 290, 40));

        FieldNombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(FieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 310, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ingresa la dirección para la factura");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 290, 40));

        FieldDireccion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        FieldDireccion.setText("Ciudad");
        jPanel1.add(FieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 310, 40));

        Fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 330, 510));

        BotonRealizarCompra.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BotonRealizarCompra.setText("Realizar compra");
        BotonRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRealizarCompraActionPerformed(evt);
            }
        });
        Fondo.add(BotonRealizarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 330, 60));

        BotonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonBorrar.png"))); // NOI18N
        Fondo.add(BotonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 60, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FieldCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldCodigoBarrasActionPerformed
        String codigoBarras = FieldCodigoBarras.getText().trim();
        if (codigoBarras.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de código de barras está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM productos WHERE CodigoDeBarras = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, codigoBarras);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("Nombre");
                    String descripcion = rs.getString("Descripcion");
                    double precio = rs.getDouble("Precio");
                    double PrecioSinIVA = precio - (precio * 0.12);
                    int CantidadNueva;
                    DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
                    boolean productoExiste = false;
                    FieldCodigoBarras.setText("");
                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (model.getValueAt(i, 0).equals(codigoBarras)) {
                            int cantidad = (int) model.getValueAt(i, 6);
                            CantidadNueva = cantidad + 1;
                            model.setValueAt(CantidadNueva, i, 6);
                            model.setValueAt(precio * CantidadNueva, i, 7); 
                            productoExiste = true;
                            break;
                        }
                    }
                    if (!productoExiste) {
                        double iva = precio * 0.12;
                        model.addRow(new Object[]{codigoBarras, nombre, descripcion, PrecioSinIVA, iva, precio, 1, precio});
                    }
                    actualizarTotales();
                } else {
                    JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_FieldCodigoBarrasActionPerformed

    private void BotonRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRealizarCompraActionPerformed
        if (FieldNIT.getText().isEmpty() || FieldNombre.getText().isEmpty() || FieldDireccion.getText().isEmpty() ||
            FieldSubtotal.getText().isEmpty() || FieldIVA.getText().isEmpty() || FieldTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "La tabla de productos no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        verificarStockYGuardarFactura();
    }//GEN-LAST:event_BotonRealizarCompraActionPerformed
    
    private void verificarStockYGuardarFactura() {
        DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
        Conexion conexion = new Conexion();
        boolean stockSuficiente = true;

        try (Connection con = conexion.getConnection()) {
            for (int i = 0; i < model.getRowCount(); i++) {
                String codigoBarras = (String) model.getValueAt(i, 0);
                int cantidadRequerida = (int) model.getValueAt(i, 6);

                String sql = "SELECT Cantidad FROM productos WHERE CodigoDeBarras = ?";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setString(1, codigoBarras);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            int cantidadDisponible = rs.getInt("Cantidad");
                            if (cantidadDisponible < cantidadRequerida) {
                                JOptionPane.showMessageDialog(this, "No hay stock suficiente para el producto con código de barras: " + codigoBarras, "Error", JOptionPane.ERROR_MESSAGE);
                                stockSuficiente = false;
                                break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Producto con código de barras: " + codigoBarras + " no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                            stockSuficiente = false;
                            break;
                        }
                    }
                }
            }

            if (stockSuficiente) {
                guardarFactura();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void guardarFactura() {
        DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
        Conexion conexion = new Conexion();

        String sqlFactura = "INSERT INTO facturas (NIT, NombreCliente, DireccionCliente, Subtotal, IVA, Total) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlFacturaProductos = "INSERT INTO detalle_factura (IdFactura, CodigoDeBarras, Cantidad, SubtotalProducto) VALUES (?, ?, ?, ?)";
        String sqlUpdateStock = "UPDATE productos SET Cantidad = Cantidad - ? WHERE CodigoDeBarras = ?";

        try (Connection con = conexion.getConnection();
             PreparedStatement pstFactura = con.prepareStatement(sqlFactura, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstFacturaProductos = con.prepareStatement(sqlFacturaProductos);
             PreparedStatement pstUpdateStock = con.prepareStatement(sqlUpdateStock)) {

            pstFactura.setString(1, FieldNIT.getText());
            pstFactura.setString(2, FieldNombre.getText());
            pstFactura.setString(3, FieldDireccion.getText());
            pstFactura.setDouble(4, Double.parseDouble(FieldSubtotal.getText().substring(23)));
            pstFactura.setDouble(5, Double.parseDouble(FieldIVA.getText().substring(5)));
            pstFactura.setDouble(6, Double.parseDouble(FieldTotal.getText().substring(7)));
            pstFactura.executeUpdate();

            ResultSet generatedKeys = pstFactura.getGeneratedKeys();
            int facturaID = 0;
            if (generatedKeys.next()) {
                facturaID = generatedKeys.getInt(1);
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                String codigoBarras = (String) model.getValueAt(i, 0);
                int cantidad = (int) model.getValueAt(i, 6);
                double subtotal = (double) model.getValueAt(i, 3) * cantidad;

                pstFacturaProductos.setInt(1, facturaID);
                pstFacturaProductos.setString(2, codigoBarras);
                pstFacturaProductos.setInt(3, cantidad);
                pstFacturaProductos.setDouble(4, subtotal);
                pstFacturaProductos.executeUpdate();

                // Actualizar stock en la tabla productos
                pstUpdateStock.setInt(1, cantidad);
                pstUpdateStock.setString(2, codigoBarras);
                pstUpdateStock.executeUpdate();
            }

            generarPDF(facturaID);

            JOptionPane.showMessageDialog(this, "Compra realizada y factura generada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar la factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void generarPDF(int facturaID) {
        Document document = new Document();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setSelectedFile(new File("factura_" + facturaID + ".pdf"));

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try {
                PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
                document.open();

                Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
                Paragraph titulo = new Paragraph("Meow Parlour", fontTitulo);
                titulo.setAlignment(Element.ALIGN_CENTER);
                document.add(titulo);

                document.add(new Paragraph("Número de Factura: " + facturaID));
                document.add(new Paragraph("NIT: " + FieldNIT.getText()));
                document.add(new Paragraph("Nombre: " + FieldNombre.getText()));
                document.add(new Paragraph("Dirección: " + FieldDireccion.getText()));
                document.add(new Paragraph(" "));

                PdfPTable table = new PdfPTable(5); // Cambiado a 5 columnas para incluir Nombre de Producto
                table.setWidthPercentage(100);
                PdfPCell cell;

                cell = new PdfPCell(new Phrase("Código de Barras"));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Nombre de Producto")); // Agregado nombre de producto
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Cantidad"));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Subtotal"));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Total"));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    table.addCell((String) model.getValueAt(i, 0)); // Código de Barras
                    table.addCell((String) model.getValueAt(i, 1)); // Nombre de Producto
                    table.addCell(String.valueOf(model.getValueAt(i, 6))); // Cantidad
                    table.addCell(String.valueOf(model.getValueAt(i, 3))); // Subtotal
                    table.addCell(String.valueOf(model.getValueAt(i, 5))); // Total
                }

                document.add(table);

                document.add(new Paragraph(" "));
                document.add(new Paragraph("Subtotal (sin IVA): " + FieldSubtotal.getText().substring(19))); // Ajustado inicio de la posición para el subtotal
                document.add(new Paragraph("IVA: " + FieldIVA.getText().substring(5)));
                document.add(new Paragraph("Total: " + FieldTotal.getText().substring(7)));

                document.close();

                // Guardar el PDF en la base de datos
                guardarPDFenBD(facturaID, fileToSave);

                JOptionPane.showMessageDialog(this, "PDF de la factura guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (DocumentException | IOException e) {
                JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void guardarPDFenBD(int facturaID, File file) {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO facturas_pdf (FacturaID, FacturaPDF) VALUES (?, ?)";

        try (Connection con = conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, facturaID);
            FileInputStream fis = new FileInputStream(file);
            pst.setBinaryStream(2, fis, (int) file.length());
            pst.executeUpdate();

            fis.close();
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el PDF en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RealizarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new UsuarioAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBorrar;
    private javax.swing.JButton BotonRealizarCompra;
    private javax.swing.JTextField FieldCodigoBarras;
    private javax.swing.JTextField FieldDireccion;
    private javax.swing.JTextField FieldIVA;
    private javax.swing.JTextField FieldNIT;
    private javax.swing.JTextField FieldNombre;
    private javax.swing.JTextField FieldSubtotal;
    private javax.swing.JTextField FieldTotal;
    private javax.swing.JPanel Fondo;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
