package misventana;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import miCola.ArrayCola;
import miConexion.Conexion;
import miLista.ListaLEG;
import miLista.NodoLEG;
import misClases.Comida;
import misClases.GestionPedidos;
import misClases.Pedido;



public final class MiFormulario extends javax.swing.JFrame {
    
    ListaLEG<Comida> listaCom;
    GestionPedidos gestion;
    String []registrosP;
    String []registrosC;
    DefaultTableModel modeloPedidos;
    DefaultTableModel modeloComidas;
    Conexion conexion;
    Connection cn;
    String sql;  
    public MiFormulario() {
        initComponents();    
        
        listaCom = new ListaLEG<>();
        conexion = new Conexion();
        cn = conexion.conexion();
        
        setLocationRelativeTo(this);
        gestion = new GestionPedidos();
        CargarPedidosbkp();
        //System.out.println(gestion.toString());
        
    }
    public void CargarPedidos(){
        String []cabeceraP={"Sucursal","Monto Recaudado"};
        registrosP=new String[2];
        ArrayCola cola = gestion.getCola();
        modeloPedidos = new DefaultTableModel(null, cabeceraP);
        
        ArrayCola<Pedido> colaAux = new ArrayCola<>(); 
        Pedido ped;
        while (!cola.colaVacia()){
            ped = cola.frentec();
            cola.desencolar();
            colaAux.encolar(ped);
            registrosP = new String[2];
            registrosP[0]=String.valueOf(ped.getSucursal());
            registrosP[1]=String.valueOf(ped.getMontoR());
            modeloPedidos.addRow(registrosP);          
        }
        while (!colaAux.colaVacia()){
            ped = colaAux.frentec();
            colaAux.desencolar();
            cola.encolar(ped);
        }
        jTableListadoPedidos.setModel(modeloPedidos);   
    }
    public void CargarPedidosbkp(){
        String []cabeceraP={"Sucursal","Monto Recaudado"};
        registrosP=new String[2];
        
        modeloPedidos = new DefaultTableModel(null, cabeceraP);
        sql = "Select * from pedidos";
               
        try {        
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registrosP[0]=rs.getString("sucursal");
                registrosP[1]=rs.getString("montor");
                modeloPedidos.addRow(registrosP);
                Pedido pedido = new Pedido(Integer.parseInt(registrosP[0]));
                pedido.setMontoR(Double.parseDouble(registrosP[1]));
                gestion.encolarPedido(pedido);
            }
            CargarComidasbkp();
            jTableListadoPedidos.setModel(modeloPedidos);           
        } catch (SQLException e) {
            System.out.println("Error ...."+e.getMessage());       
        }         
    }
    public void CargarComidas(){
        String []cabeceraC={"Sucursal","Comida","Cantidad","PrecioU"};        
        registrosC=new String[4];
        ArrayCola cola = gestion.getCola();
        modeloComidas = new DefaultTableModel(null, cabeceraC);
        
        ArrayCola<Pedido> colaAux = new ArrayCola<>(); 
        Pedido ped;
        while (!cola.colaVacia()){
            ped = cola.frentec();
            cola.desencolar();
            colaAux.encolar(ped);
            ListaLEG<Comida> lista = ped.getLista();
            NodoLEG<Comida> primero = lista.getPrimero();
            
            for (NodoLEG<Comida> aux = primero; aux != null; aux = aux.getSiguiente()){
                registrosC[0] = String.valueOf(ped.getSucursal());
                registrosC[1] = aux.getDato().getNombre();
                registrosC[2] = String.valueOf(aux.getDato().getCantidad());
                registrosC[3] = String.valueOf(aux.getDato().getPrecio());
                modeloComidas.addRow(registrosC);
            }
        }
        while (!colaAux.colaVacia()){
            ped = colaAux.frentec();
            colaAux.desencolar();
            cola.encolar(ped);
        }

        jTableListadoComidas.setModel(modeloComidas);           
             
    }
    
    public void CargarComidasbkp(){
        String []cabeceraC={"Sucursal","Comida","Cantidad","PrecioU"};        
        registrosC=new String[4];
        
        modeloComidas = new DefaultTableModel(null, cabeceraC);
        sql = "Select * from comida";
        
        try {        
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registrosC[0]=rs.getString("sucursal");
                registrosC[1]=rs.getString("nombre");
                registrosC[2]=rs.getString("cantidad");
                registrosC[3]=rs.getString("precio");
                modeloComidas.addRow(registrosC);
                gestion.getPedido(Integer.parseInt(registrosC[0])).getLista().agregarNuevaComida(new Comida(registrosC[1],Integer.parseInt(registrosC[2]),Double.parseDouble(registrosC[3]))
                );
            }
            
         //   System.out.println(gestion.toString());
            jTableListadoComidas.setModel(modeloComidas);           
        } catch (SQLException e) {
            System.out.println("Error ...."+e.getMessage());       
        }         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListadoPedidos = new javax.swing.JTable();
        jButtonSalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSucursalPedido = new javax.swing.JTextField();
        jButtonAgregarPedido = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSucursalComida = new javax.swing.JTextField();
        jTextFieldNombreComida = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jButtonAgregarComida = new javax.swing.JButton();
        jButtonEliminarComida = new javax.swing.JButton();
        jButtonEliminarCAleatoria = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListadoComidas = new javax.swing.JTable();
        jButtonComidaMayorMonto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restaurante");

        jPanelFondo.setBackground(new java.awt.Color(244, 231, 200));

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Shruti", 1, 16))); // NOI18N

        jTableListadoPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableListadoPedidos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")), "Registro Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Shruti", 1, 16))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Shruti", 0, 13)); // NOI18N
        jLabel4.setText("Sucursal:");

        jButtonAgregarPedido.setText("Registrar Sucursal");
        jButtonAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSucursalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonAgregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldSucursalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButtonAgregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro Comidas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Shruti", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Shruti", 0, 13)); // NOI18N
        jLabel1.setText("Nro Sucursal:");

        jLabel2.setFont(new java.awt.Font("Shruti", 0, 13)); // NOI18N
        jLabel2.setText("Nombre de comida:");

        jLabel3.setFont(new java.awt.Font("Shruti", 0, 13)); // NOI18N
        jLabel3.setText("Cantidad:");

        jLabel5.setFont(new java.awt.Font("Shruti", 0, 13)); // NOI18N
        jLabel5.setText("Precio:");

        jTextFieldNombreComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreComidaActionPerformed(evt);
            }
        });

        jButtonAgregarComida.setText("Agregar Comida");
        jButtonAgregarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarComidaActionPerformed(evt);
            }
        });

        jButtonEliminarComida.setText("Eliminar Comida");
        jButtonEliminarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarComidaActionPerformed(evt);
            }
        });

        jButtonEliminarCAleatoria.setText("Eliminar Comida Aleatoria");
        jButtonEliminarCAleatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCAleatoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAgregarComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEliminarComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEliminarCAleatoria, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSucursalComida, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombreComida, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldSucursalComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombreComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(45, 45, 45)
                .addComponent(jButtonAgregarComida)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarComida)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarCAleatoria)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Comidas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Shruti", 1, 16))); // NOI18N

        jTableListadoComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableListadoComidas);

        jButtonComidaMayorMonto.setText("Comida con mayor monto");
        jButtonComidaMayorMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComidaMayorMontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonComidaMayorMonto)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonComidaMayorMonto)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jButtonSalir)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalir))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonComidaMayorMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComidaMayorMontoActionPerformed
        ArrayCola cola = gestion.getCola();
        
        ArrayCola<Pedido> colaAux = new ArrayCola<>(); 
        Pedido ped;
        String comidamax = "";
        double preciomax = 0;
        
        while (!cola.colaVacia()){
            ped = cola.frentec();
            cola.desencolar();
            colaAux.encolar(ped);
            if (ped.getLista().getTalla() > 0){
                Comida comida = ped.getLista().getComidaMayorMonto();
                double precio = comida.getPrecio();
                if (precio > preciomax){
                    comidamax = comida.getNombre();
                    preciomax = comida.getPrecio();
                }
            }
            
        }
        while (!colaAux.colaVacia()){
            ped = colaAux.frentec();
            colaAux.desencolar();
            cola.encolar(ped);
        }
        JOptionPane.showMessageDialog(null, "La comida con mayor monto es: "+comidamax);
        System.out.println(gestion.toString());

    }//GEN-LAST:event_jButtonComidaMayorMontoActionPerformed

    private void jTextFieldNombreComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreComidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreComidaActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarPedidoActionPerformed
             
       Pedido pedido = new Pedido(Integer.parseInt(jTextFieldSucursalPedido.getText()));
        try {
            if(!gestion.validarRepetido(pedido.getSucursal())){    
                gestion.encolarPedido(pedido);
                sql="insert into pedidos (sucursal,montor) Values (?,0)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, pedido.getSucursal());

                int n = pst.executeUpdate();
                if(n!=0){
                    //JOptionPane.showMessageDialog(this, "Cargando Sucursal ...");
                }
            }else{
               JOptionPane.showMessageDialog(null,"La sucursal "+pedido.getSucursal()+" ya ha sido registrada . . .");
            }
            CargarPedidos();
            } catch (SQLException e) {
                System.out.println("Error encontrado  "+e.getMessage());}
       
    }//GEN-LAST:event_jButtonAgregarPedidoActionPerformed

    private void jButtonAgregarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarComidaActionPerformed
       int suc = Integer.parseInt(jTextFieldSucursalComida.getText());       
       String nom = jTextFieldNombreComida.getText();
       int cant = Integer.parseInt(jTextFieldCantidad.getText());
       double precio = Double.parseDouble(jTextFieldPrecio.getText());
       
        sql="insert into comida (sucursal,nombre,cantidad,precio) Values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, suc);
            pst.setString(2, nom);
            pst.setInt(3, cant);
            pst.setDouble(4, precio);
            pst.executeUpdate();
            CargarPedidos();            
        } catch (SQLException e) {
            System.out.println("Error encontrado  "+e.getMessage());
        }
       
       Comida comida = new Comida(nom, cant, precio);
       
       gestion.getPedido(suc).getLista().agregarNuevaComida(comida);
       gestion.getPedido(suc).calcularMontoR();
       
       CargarPedidos();
       CargarComidas();
    }//GEN-LAST:event_jButtonAgregarComidaActionPerformed

    private void jButtonEliminarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarComidaActionPerformed

        int pos = jTableListadoComidas.getSelectedRow();        
        int suc = Integer.parseInt(String.valueOf(modeloComidas.getValueAt(pos, 0)));
        String comi = String.valueOf(modeloComidas.getValueAt(pos, 1));
        //int cant = Integer.parseInt(String.valueOf(modeloComidas.getValueAt(pos, 2)));
        //double prec = Double.parseDouble(String.valueOf(modeloComidas.getValueAt(pos, 3)));
              
        sql="DELETE FROM comida WHERE nombre = ? AND sucursal = ?";                
        
        try{             
            PreparedStatement pst = cn.prepareStatement(sql);             
            pst.setString(1, comi);
            pst.setInt(2, suc);            
            pst.executeUpdate();
            gestion.getPedido(suc).getLista().eliminarDato(comi);
            gestion.getPedido(suc).calcularMontoR();
        } catch (SQLException e) {
            System.out.println("Error encontrado  "+e.getMessage());
        }
        //ELIMINA LA FILA DE LA TABLA
        CargarPedidos();
        if(pos>=0){
            modeloComidas.removeRow(pos);
        }else{
            JOptionPane.showMessageDialog(null,"No se puede eliminar ..");
        }
        double total = 0;
        for (int j = 0; j < modeloComidas.getRowCount(); j++) {
            int amount = Integer.parseInt((String) jTableListadoComidas.getValueAt(j, 3));
            total+=amount;
        }
    }//GEN-LAST:event_jButtonEliminarComidaActionPerformed

    private void jButtonEliminarCAleatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCAleatoriaActionPerformed
        int pos = jTableListadoPedidos.getSelectedRow();        
        int suc = Integer.parseInt(String.valueOf(modeloPedidos.getValueAt(pos, 0)));
        //String comi = String.valueOf(modeloComidas.getValueAt(pos, 1));
        //int cant = Integer.parseInt(String.valueOf(modeloComidas.getValueAt(pos, 2)));
        //double prec = Double.parseDouble(String.valueOf(modeloComidas.getValueAt(pos, 3)));

        try{             
            gestion.getPedido(suc).getLista().eliminarDatoAleatorio();
            gestion.getPedido(suc).calcularMontoR();
        } catch (Exception e) {
            System.out.println("Error encontrado  "+e.getMessage());
        }
        //ELIMINA LA FILA DE LA TABLA
        CargarComidas(); 
        CargarPedidos();       
        /*if(pos>=0){
            //modeloComidas.removeRow(pos);
        }else{
            JOptionPane.showMessageDialog(null,"No se puede eliminar ..");
        }
        double total = 0;
        for (int j = 0; j < modeloComidas.getRowCount(); j++) {
            int amount = Integer.parseInt((String) jTableListadoComidas.getValueAt(j, 3));
            total+=amount;
        }*/
    }//GEN-LAST:event_jButtonEliminarCAleatoriaActionPerformed
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MiFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiFormulario().setVisible(true);
            }
           
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarComida;
    private javax.swing.JButton jButtonAgregarPedido;
    private javax.swing.JButton jButtonComidaMayorMonto;
    private javax.swing.JButton jButtonEliminarCAleatoria;
    private javax.swing.JButton jButtonEliminarComida;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListadoComidas;
    private javax.swing.JTable jTableListadoPedidos;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldNombreComida;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldSucursalComida;
    private javax.swing.JTextField jTextFieldSucursalPedido;
    // End of variables declaration//GEN-END:variables
}
