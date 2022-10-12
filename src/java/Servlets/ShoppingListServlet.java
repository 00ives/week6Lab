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
        boolean newUser = true;
        try {
            
        newUser = (boolean)session.getAttribute("newUser");
        } catch (Exception e) {
        }
       

        if (username != null && !username.equals("")) {
            newUser = true;
            boolean loggedIn = true;
            session.setAttribute("username", username);
            session.setAttribute("loggedIn", loggedIn);
            session.setAttribute("newUser", newUser);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

        if (newUser) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (logout != null) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            boolean loggedIn = (boolean) session.getAttribute("loggedIn");
            ItemService store = (ItemService)session.getAttribute("store");
            if (loggedIn) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        }

    }

    public void displayShoppingList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemService store = null;
        ArrayList<Item> test = null;
        HttpSession session = request.getSession();

        boolean newUser = (boolean) session.getAttribute("newUser");

        if (newUser) {
            store = new ItemService();
            session.setAttribute("store", store);
            newUser = false;
            session.setAttribute("newUser", newUser);
        } else {
            store = (ItemService) session.getAttribute("store");
        }

        String userItemInput = request.getParameter("userItemInput");

        if (userItemInput != null && !userItemInput.equals("")) {
            Item listItem = new Item(userItemInput);
            store.addToShoppingList(listItem);
        }

        String loopIndex = request.getParameter("groceryList");
        request.setAttribute("loopIndex", loopIndex);

        if (loopIndex != null && !loopIndex.equals("")) {
            store.deleteFromShoppingList(loopIndex);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        displayShoppingList(request, response);

    }

}
