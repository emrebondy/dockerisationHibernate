package com.exemple.servlets;

import Bean.Annonce;
import DAO.AnnonceDAOV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findId")
public class AnnonceFindServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AnnonceDAOV2 annonceDao = new AnnonceDAOV2();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Annonce annonce = annonceDao.find(id);

            if (annonce != null) {
                request.setAttribute("annonce", annonce);
                request.getRequestDispatcher("annonceEdit.jsp").forward(request, response);
            } else {
                response.sendRedirect("annonce"); // Redirige vers la liste si l'ID est invalide
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("annonce"); // Redirige en cas d'erreur
        }
    }
}
