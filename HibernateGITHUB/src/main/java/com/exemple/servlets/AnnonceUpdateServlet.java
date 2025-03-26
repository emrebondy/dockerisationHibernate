package com.exemple.servlets;

import Bean.Annonce;
import DAO.AnnonceDAOV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAnnonce")
public class AnnonceUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AnnonceDAOV2 annonceDao = new AnnonceDAOV2();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/annonceEdit.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Annonce annonce = new Annonce();

        annonce.setId(Integer.parseInt(request.getParameter("id")));
        annonce.setTitle(request.getParameter("title"));
        annonce.setDescription(request.getParameter("description"));
        annonce.setAdress(request.getParameter("adress"));
        annonce.setMail(request.getParameter("mail"));

        try {

            boolean success = annonceDao.update(annonce);

            if (success) {
                System.out.println("✅ Annonce mis à jour avec succès !");
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("error", "❌ Erreur lors de l'ajout de l'annonce.");
                request.getRequestDispatcher("annonceEdit.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "❌ Une erreur est survenue : " + e.getMessage());
            request.getRequestDispatcher("annonceEdit.jsp").forward(request, response);
        }

    }
}
