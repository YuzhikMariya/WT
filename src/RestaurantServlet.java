import by.bsuir.Yuzhik.model.XMLToRestaurant.DomHandler;
import by.bsuir.Yuzhik.model.XMLToRestaurant.SaxParser;
import by.bsuir.Yuzhik.model.entity.RestaurantWrapper;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String path = request.getParameter("path");
        String parser = request.getParameter("parser");

        PrintWriter out = response.getWriter();

        switch (parser) {
            case "sax":
                SaxParser saxParser = new SaxParser();
                try{
                    RestaurantWrapper rest = saxParser.saxPars(path);
                    request.setAttribute("dishes", rest.getDishes());
                    request.setAttribute("orders", rest.getOrders());
                    request.setAttribute("employees", rest.getEmployees());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
                    dispatcher.forward(request,response);
                }
                catch (Exception e){
                    out.println("Error");
                }
                break;
            case "stax":
                break;
            case "dom":
                DomHandler domHandler = new DomHandler();
                try{
                    RestaurantWrapper rest = domHandler.parse(path);
                    request.setAttribute("dishes", rest.getDishes());
                    request.setAttribute("orders", rest.getOrders());
                    request.setAttribute("employees", rest.getEmployees());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
                    dispatcher.forward(request,response);
                }
                catch (Exception e){
                    out.println("Error");
                }
                break;
        }
    }
}
