package com.exemple.servlets;

import DAO.AnnonceDAOV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAnnonce")
public class AnnonceDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AnnonceDAOV2 annonceDao = new AnnonceDAOV2();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            boolean success = annonceDao.delete(id);

            if (success) {
                System.out.println("✅ Annonce supprimée avec succès !");
            } else {
                System.out.println("❌ Erreur lors de la suppression de l'annonce.");
            }

            response.sendRedirect("annonce");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("annonce");
        }
    }
}
