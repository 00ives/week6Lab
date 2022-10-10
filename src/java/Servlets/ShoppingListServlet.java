package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import models.Item;
import services.ItemService;

/**
 *
 * @author ivorl
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String logout = request.getParameter("logout");
        if (username != null && !username.equals("")) {
            boolean newUser = true;
            boolean loggedIn = true;
            session.setAttribute("username", username);
            session.setAttribute("loggedIn", loggedIn);
            session.setAttribute("newUser", newUser);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;

        }
        if (session.isNew()) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } else if (logout != null) {
//            newUser = true;
//            session.setAttribute("newUser", true);
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } else {
            boolean loggedIn = (boolean) session.getAttribute("loggedIn");
            if (loggedIn) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }

    }

    public void displayShoppingList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Item listItem = null;
//        String userItemInput = "";
        ItemService shoppingList = null;
        ArrayList<Item> test = null;
//        String loopIndex = request.getParameter("groceryList");
//        request.setAttribute("loopIndex", loopIndex);
        HttpSession session = request.getSession();
         try {
            test = shoppingList.getShoppingList();
            
        } catch (Exception e) {
        }
        boolean newUser = (boolean) session.getAttribute("newUser");
//        shoppingList = (ItemService) session.getAttribute("shoppinglist");
        if (newUser) {
            shoppingList = new ItemService();
            session.setAttribute("shoppingList", shoppingList);
            newUser = false;
            session.setAttribute("newUser", newUser);
        } else {
            shoppingList = (ItemService) session.getAttribute("shoppingList");
        }
        request.setAttribute("test", shoppingList);
        request.setAttribute("shoppingList", shoppingList);
        
        String userItemInput = request.getParameter("userItemInput");

        if (userItemInput != null && !userItemInput.equals("")) {
            Item listItem = new Item(userItemInput);
            shoppingList.addToShoppingList(listItem);
            

        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        displayShoppingList(request, response);

    }

}
