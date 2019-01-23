package de.unidue.inf.is;

import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 */
public final class HauptseiteServlet extends HttpServlet {

    private static List<Anzeige> anzeigeListe = new ArrayList<>();
    private Connection con;

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Put the user list in request and let freemarker paint it.
        con = null;
        try {
            con = DBUtil.getExternalConnection("insdb");
            String sqlAnzeigen = "SELECT * FROM dbp47.anzeige WHERE status = ?";
            PreparedStatement preparedStatementAnzeigen = con.prepareStatement(sqlAnzeigen);
            ResultSet resultset = preparedStatementAnzeigen.executeQuery(sqlAnzeigen);



            while (resultset.next()) {
                Anzeige anzeige = new Anzeige();
                anzeige.setId(resultset.getLong("id"));
                anzeige.setTitel(resultset.getString("titel"));
                anzeige.setPreis(resultset.getDouble("preis"));
                anzeige.setBeschreibung(resultset.getString("text"));
                anzeige.setUser(resultset.getString("ersteller"));
                anzeige.setErstellungsDatum(resultset.getDate("erstellungsdatum"));
                anzeigeListe.add(anzeige);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        request.setAttribute("anzeigeListe", anzeigeListe);
        request.getRequestDispatcher("hauptseite.ftl").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}
