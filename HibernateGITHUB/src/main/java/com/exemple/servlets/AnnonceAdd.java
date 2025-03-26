package com.exemple.servlets;

import Bean.Annonce;
import DAO.AnnonceDAOV2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addAnnonce") // URL du servlet
public class AnnonceAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AnnonceDAOV2 annonceDao = new AnnonceDAOV2();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/annonceAdd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            Annonce annonce = new Annonce();

            annonce.setTitle(request.getParameter("title"));
            annonce.setDescription(request.getParameter("description"));
            annonce.setAdress(request.getParameter("adress"));
            annonce.setMail(request.getParameter("mail"));

            try {

                boolean success = annonceDao.create(annonce);

                if (success) {
                    System.out.println("✅ Annonce ajoutée avec succès !");
                    response.sendRedirect("index.jsp");
                } else {
                    request.setAttribute("error", "❌ Erreur lors de l'ajout de l'annonce.");
                    request.getRequestDispatcher("annonceAdd.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "❌ Une erreur est survenue : " + e.getMessage());
                request.getRequestDispatcher("annonceAdd.jsp").forward(request, response);
            }

    }
}
