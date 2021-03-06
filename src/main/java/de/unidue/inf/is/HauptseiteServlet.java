package de.unidue.inf.is;

import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String query;
        con = null;
        try {
            con = DBUtil.getConnection("insdb");
            query = "SELECT * FROM dbp47.anzeige";
            Statement statement;
            statement = con.createStatement();
            ResultSet resultset = statement.executeQuery(query);



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
        }


        request.setAttribute("anzeigeListe", anzeigeListe);
        request.getRequestDispatcher("hauptseite.ftl").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}
