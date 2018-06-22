package misVentanas;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import misClases.ArrayCola;
import misClases.ArrayPila;

public class Ventana <E> extends javax.swing.JFrame {
    ArrayPila<E> pila;
    ArrayCola<E> cola;
    String[][] modelo;
    String[] columnas;
    TableModel tabla;
    
    public Ventana() {
        columnas = new String[2];
        columnas[0] = "Pila";
        columnas[1] = "Cola";
        modelo = new String[50][50];
        tabla = new DefaultTableModel(modelo, columnas);
        pila = new ArrayPila<>();
        cola = new ArrayCola<>();
        modelo = (String[][]) new String[50][2];
        initComponents();
    }
    
    public void insertarModeloPila(String x){
        modelo[pila.getTope()][0] = x;
    }
    public void insertarModeloCola(String x){
        modelo[cola.getFinalc()][1] = x;
    }
    public void eliminarModeloPila(){
        modelo[pila.getTope()][0] = null;
    }
    public void eliminarModeloCola(){
        modelo[cola.getFrentec()][1] = null;
    }
    public String toStringModeloPila(){
        String res = "Pila: \n";
        String elemento;
        for (int i = 0; true; i++){
            elemento = modelo[i][0];
            if (elemento == null){
                break;
            } else {
                res = res + elemento + "\n";
            }
        }
        return res;
    }
    public String toStringModeloCola(){
        String res = "Cola: \n";
        String elemento;
        for (int i = 0; true; i++){
            elemento = modelo[i][1];
            if (elemento == null){
                break;
            } else {
                res = res + elemento + "\n";
            }
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableContenido = new javax.swing.JTable();
        ApilarPila = new javax.swing.JButton();
        DesapilarPila = new javax.swing.JButton();
        ApilarCola = new javax.swing.JButton();
        DesapilarCola = new javax.swing.JButton();
        ElementoPila = new javax.swing.JTextField();
        ElementoCola = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableContenido.setModel(this.tabla);
        jTableContenido.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableContenido);

        ApilarPila.setText("Apilar");
        ApilarPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApilarPilaActionPerformed(evt);
            }
        });

        DesapilarPila.setText("Desapilar");
        DesapilarPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesapilarPilaActionPerformed(evt);
            }
        });

        ApilarCola.setText("Encolar");
        ApilarCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApilarColaActionPerformed(evt);
            }
        });

        DesapilarCola.setText("Desencolar");
        DesapilarCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesapilarColaActionPerformed(evt);
            }
        });

        jLabel1.setText("Pila");

        jLabel2.setText("Cola");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FIRST IN");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LAST IN");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(ElementoCola, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ElementoPila, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ApilarPila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ApilarCola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DesapilarCola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DesapilarPila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApilarPila)
                    .addComponent(DesapilarPila)
                    .addComponent(ElementoPila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApilarCola)
                    .addComponent(DesapilarCola)
                    .addComponent(ElementoCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApilarPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApilarPilaActionPerformed
        String elemento = ElementoPila.getText();
        if (elemento.length()>0){
            pila.apilar((E) elemento);
            insertarModeloPila(elemento);
            tabla = new DefaultTableModel(modelo, columnas);
            ElementoPila.setText("");
            jTableContenido.setModel(this.tabla);
        }
    }//GEN-LAST:event_ApilarPilaActionPerformed

    private void ApilarColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApilarColaActionPerformed
        String elemento = ElementoCola.getText();
        if (elemento.length()>0){
            cola.encolar((E) elemento);
            insertarModeloCola(elemento);
            tabla = new DefaultTableModel(modelo, columnas);
            ElementoCola.setText("");
            jTableContenido.setModel(this.tabla);
        }
    }//GEN-LAST:event_ApilarColaActionPerformed

    private void DesapilarPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesapilarPilaActionPerformed
        if(!pila.pilaVacia()){
            eliminarModeloPila();
            pila.desapilar();
            tabla = new DefaultTableModel(modelo, columnas);
            jTableContenido.setModel(this.tabla);
        }
    }//GEN-LAST:event_DesapilarPilaActionPerformed

    private void DesapilarColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesapilarColaActionPerformed
        System.out.println("Frente: "+cola.getFrentec());
        System.out.println("Final: "+cola.getFinalc());
        if(!cola.colaVacia()){
            eliminarModeloCola();
            cola.desencolar();
            tabla = new DefaultTableModel(modelo, columnas);
            jTableContenido.setModel(this.tabla);
        }
    }//GEN-LAST:event_DesapilarColaActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApilarCola;
    private javax.swing.JButton ApilarPila;
    private javax.swing.JButton DesapilarCola;
    private javax.swing.JButton DesapilarPila;
    private javax.swing.JTextField ElementoCola;
    private javax.swing.JTextField ElementoPila;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableContenido;
    // End of variables declaration//GEN-END:variables
}
