package miConexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
        private Connection con;

    public Conexion() {
        con=null;
    }
    
    public Connection conexion(){        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/restaurante", "root", ""); //crear BD restaurante
            //JOptionPane.showMessageDialog(null, "Conexion establecida .......");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en la conexion "+ex.getMessage());        
        }
        return con;  
    }   
}

/*
CREATE TABLE `comida` (
  `nombre` varchar(200) NOT NULL,
  `precio` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `sucursal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `pedidos` (
  `sucursal` int(11) NOT NULL,
  `montor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DELIMITER $$
CREATE TRIGGER `aumentarMontoR` AFTER INSERT ON `comida` FOR EACH ROW BEGIN
    UPDATE pedidos
    SET montor = montor + NEW.precio*NEW.cantidad
    WHERE sucursal = NEW.sucursal;
  END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `disminuirMontoR` AFTER DELETE ON `comida` FOR EACH ROW BEGIN
    UPDATE pedidos
    SET montor = montor - OLD.precio*OLD.cantidad
    WHERE sucursal = OLD.sucursal;
  END
$$
DELIMITER ;

INSERT INTO `pedidos` (`sucursal`, `montor`) VALUES
(1, 20),
(2, 0);

ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`sucursal`);
*/
