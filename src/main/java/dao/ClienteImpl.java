package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

public class ClienteImpl extends Conexion implements ICRUD<Cliente> {

    DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void guardar(Cliente cliente) throws Exception {
        try {
            String sql = "insert into CLIENTE" + " (NOMCLI,APECLI,DNICLI,TELCLI, EMACLI, ESTCLI,FECNAC,DOMCLI)"
                    + " values (?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = dao.Conexion.conectar().prepareStatement(sql);
            ps.setString(1, cliente.getNOMCLI());
            ps.setString(2, cliente.getAPECLI());
            ps.setString(3, cliente.getDNICLI());
            ps.setString(4, cliente.getTELCLI());
            ps.setString(5, cliente.getEMACLI());
            ps.setString(6, "A");
            ps.setString(7, fecha.format(cliente.getFECNAC()));
            ps.setString(8, cliente.getDOMCLI());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            Logger.getGlobal().log(Level.WARNING, "\"Error en ClienteImpl/registrar: ", e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Cliente cliente) throws Exception {
        try {
            String sql = "update CLIENTE set NOMCLI=?,APECLI=?,DNICLI=?,TELCLI=?, EMACLI=?,ESTCLI=?,FECNAC=?,DOMCLI=? where IDCLI=?";
            PreparedStatement ps = dao.Conexion.conectar().prepareStatement(sql);
            ps.setString(1, cliente.getNOMCLI());
            ps.setString(2, cliente.getAPECLI());
            ps.setString(3, cliente.getDNICLI());
            ps.setString(4, cliente.getTELCLI());
            ps.setString(5, cliente.getEMACLI());
            ps.setString(6, "A");
            ps.setString(7, fecha.format(cliente.getFECNAC()));
            ps.setString(8, cliente.getDOMCLI());
            ps.setInt(9, cliente.getIDCLI());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            Logger.getGlobal().log(Level.WARNING, "\"Error en ClienteImpl/modificar: ", e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Cliente cliente) throws Exception {
        try {
            String sql = "update CLIENTE set ESTCLI='I' where IDCLI=? ";
            PreparedStatement ps = dao.Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, cliente.getIDCLI());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getGlobal().log(Level.WARNING, "\"Error en ClienteImpl/eliminar: ", e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void restaurar(Cliente cliente) throws Exception {
        try {
            String sql = "update CLIENTE set ESTCLI='A' where IDCLI=? ";
            PreparedStatement ps = dao.Conexion.conectar().prepareStatement(sql);
            ps.setInt(1, cliente.getIDCLI());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getGlobal().log(Level.WARNING, "\"Error en ClienteImpl/restaurar: ", e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List listarTodos(int tipo) throws Exception {
        List<Cliente> lista = null;
        String sql = "";
        switch (tipo) {
            case 1:
                sql = "SELECT * FROM vCLIENTE WHERE ESTCLI = 'A'";
                break;
            case 2:
                sql = "SELECT * FROM vCLIENTE WHERE ESTCLI = 'I'";
                break;
            case 3:
                sql = "SELECT * FROM vCLIENTE";
                break;
        }
        try {
            lista = new ArrayList();
            Statement st = dao.Conexion.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIDCLI(rs.getInt("IDCLI"));
                cli.setNOMCLI(rs.getString("NOMCLI"));
                cli.setAPECLI(rs.getString("APECLI"));
                cli.setDNICLI(rs.getString("DNICLI"));
                cli.setTELCLI(rs.getString("TELCLI"));
                cli.setEMACLI(rs.getString("EMACLI"));
                cli.setFECNAC(rs.getDate("FECNAC"));
                cli.setDOMCLI(rs.getString("DOMCLI"));
                lista.add(cli);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getGlobal().log(Level.WARNING, "\"Error al listar todos ", e.getMessage());
        } finally {
            this.cerrar();
        }
        return lista;
    }

}
