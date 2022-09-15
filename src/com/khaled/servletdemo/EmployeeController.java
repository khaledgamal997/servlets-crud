package com.khaled.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "LIST";
            }

            switch (command) {
                case "LIST":
                    listEmployee(request, response);
                    break;
                case "LOAD":
                    loadEmployee(request, response);
                    break;
                case "DELETE":
                    deleteEmployee(request, response);
                    break;

                default:
                    listEmployee(request, response);
            }

        }
        catch (Exception e) {
            throw new ServletException(e);
        }

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            int id = Integer.parseInt(request.getParameter("employeeId"));
            employeeDAO.deleteEmployee(id);
            listEmployee(request, response);
        }
        catch (NumberFormatException e) {
            out.write("<h1>Are you for real!<h1>");
            out.write(
                    "<div class=\"tenor-gif-embed\" data-postid=\"4825128\" data-share-method=\"host\" data-aspect-ratio=\"2.36\" data-width=\"100%\"><a href=\"https://tenor.com/view/ryan-gosling-want-angry-gif-4825128\">What Do You Want GIF</a>from <a href=\"https://tenor.com/search/ryan+gosling-gifs\">Ryan Gosling GIFs</a></div> <script type=\"text/javascript\" async src=\"https://tenor.com/embed.js\"></script>");
        }
        catch (Exception e) {
            out.write("<h1>employee id does not exist! </h1>" + e);
        }

    }

    private void loadEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            Employee employee = employeeDAO.getEmployeeById(employeeId);
            request.setAttribute("THE_EMP", employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/update-form.jsp");
            dispatcher.forward(request, response);
        }
        catch (NumberFormatException e) {
            out.write("<h1>it not eveeeen a numbeeer!<h1>");
            out.write(
                    "<iframe src=\"https://giphy.com/embed/U2Ywj0rSBecRq\" width=\"480\" height=\"240\" frameBorder=\"0\" class=\"giphy-embed\" allowFullScreen></iframe><p><a href=\"https://giphy.com/gifs/U2Ywj0rSBecRq\">via GIPHY</a></p>");
        }
        catch (Exception e) {
            out.write("<h1>Sorry, This ID is Invalid!<h1>" + e);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            List<Employee> theEmployees = employeeDAO.getEmployee();
            request.setAttribute("employee_list", theEmployees);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employee.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e) {
            out.write("<h1> there is no employees to list<h1>" + e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            String command = req.getParameter("command");
            if (command == null) {
                command = "ADD";
            }

            switch (command) {
                case "ADD":
                    saveEmployee(req, resp);
                    break;
                case "UPDATE":
                    updateEmployee(req, resp);
                    break;

                default:
                    saveEmployee(req, resp);
            }

        }
        catch (Exception e) {
            throw new ServletException(e);
        }

    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("employeeId"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String title = req.getParameter("title");
        employeeDAO.updateEmployee(id, firstName, lastName, title);
        listEmployee(req, resp);

    }

    private void saveEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String title = req.getParameter("title");
        Employee employee = new Employee(firstName, lastName, title);

        employeeDAO.saveEmployee(employee);
        listEmployee(req, resp);

    }

}
