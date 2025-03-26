package com.exemple.servlets;

import Bean.Annonce;

import DAO.AnnonceDAOV2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/annonce")
public class AnnonceListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            AnnonceDAOV2 annonceDAO = new AnnonceDAOV2();
            ArrayList<Annonce> annonceList = annonceDAO.list();

            request.setAttribute("annonceList", annonceList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/annonceList.jsp").forward(request, response);
    }

}
