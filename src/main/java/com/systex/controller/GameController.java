package com.systex.controller;

import com.systex.model.GuessGame;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/GameController")
public class GameController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GameController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GuessGame game = (GuessGame) session.getAttribute("guessGame");

        if (game == null) {
            int range = 10;
            int remains = 3;
            game = new GuessGame(range, remains);
            session.setAttribute("guessGame", game);
        }

        // 獲取用戶猜的數字
        String guessNumberParam = request.getParameter("guessNumber");
        try {
            int guessNumber = Integer.parseInt(guessNumberParam);
            boolean isCorrect = game.guess(guessNumber);

            if (isCorrect) {
                session.invalidate(); 
                response.sendRedirect("youWin.jsp");
            } else if (game.getRemains() <= 0) {
                session.invalidate(); 
                response.sendRedirect("youLose.jsp");
            } else {
            	String hint = game.getHint(guessNumber);
                session.setAttribute("hint", hint); 
                response.sendRedirect("guess.jsp?remains=" + game.getRemains()); 
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("guess.jsp?error=invalid");
        }
    }
}
