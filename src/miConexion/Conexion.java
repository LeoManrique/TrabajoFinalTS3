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
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_productos", "root", "");
            JOptionPane.showMessageDialog(null, "Conexion establecida .......");
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `sucursal` int(11) NOT NULL,
  `montor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD KEY `fkey` (`sucursal`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`sucursal`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comida`
--
ALTER TABLE `comida`
  ADD CONSTRAINT `fkey` FOREIGN KEY (`sucursal`) REFERENCES `pedidos` (`sucursal`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
*/
