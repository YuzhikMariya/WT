package app.servlets;

import app.entity.RestaurantWrapper;
import app.parsers.DomHandler;
import app.parsers.SaxParser;
import app.parsers.StaxHandler;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/RestaurantServlet", urlPatterns = {"/RestaurantServlet"})
public class RestaurantServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(RestaurantServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String path = request.getParameter("path");
        String parser = request.getParameter("parser");

        PrintWriter out = response.getWriter();
        RestaurantWrapper rest = new RestaurantWrapper();

        if ("sax".equals(parser)) {
            SaxParser saxParser = new SaxParser();
            try {
                rest = saxParser.saxPars(path);
            } catch (Exception e) {
                logger.error("Sax parse error", e);
            }
        } else if ("stax".equals(parser)) {
                StaxHandler staxHandler = new StaxHandler();
                try{
                    rest = staxHandler.parse(path);
                }
                catch (Exception e){
                    logger.error("Stax parse error", e);
                }
        } else if ("dom".equals(parser)) {
                DomHandler domHandler = new DomHandler();
                try{
                    rest = domHandler.parse(path);
                }
                catch (Exception e){
                    logger.error("Dom parse error", e);
                }
        }
        request.setAttribute("dishes", rest.getDishes());
        request.setAttribute("orders", rest.getOrders());
        request.setAttribute("employees", rest.getEmployees());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
        dispatcher.forward(request,response);
    }
}