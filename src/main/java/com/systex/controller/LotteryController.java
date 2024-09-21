package com.systex.controller;

import com.systex.model.LotteryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

@WebServlet("/LotteryController")
public class LotteryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LotteryService lotteryService = new LotteryService();

    public LotteryController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String excludeNumbersParam = request.getParameter("excludeNumbers");
        String loopCountParam = request.getParameter("loopCount");

        LinkedList<Integer> excludeNumbers = parseExcludedNumbers(excludeNumbersParam);

        int loopCount = 1;
        try {
            loopCount = Integer.parseInt(loopCountParam);
        } catch (NumberFormatException e) {
            loopCount = 1; 
        }

        ArrayList<Integer>[] randomSets = lotteryService.getNumber(loopCount, excludeNumbers);

        request.setAttribute("result", formatResult(randomSets));

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    private LinkedList<Integer> parseExcludedNumbers(String excludeNumbersStr) {
        LinkedList<Integer> excludeNumbers = new LinkedList<>();
        if (excludeNumbersStr != null && !excludeNumbersStr.isEmpty()) {
            String[] numbers = excludeNumbersStr.split(" ");
            for (String number : numbers) {
                try {
                    excludeNumbers.add(Integer.parseInt(number.trim()));
                } catch (NumberFormatException e) {

                }
            }
        }
        return excludeNumbers;
    }

    private String formatResult(ArrayList<Integer>[] randomSets) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < randomSets.length; i++) {
            result.append("Set ").append(i + 1).append(": ");
            for (Integer num : randomSets[i]) {
                result.append(String.format("%02d", num)).append(" "); 
            }
            result.append("\n");
        }
        return result.toString();
    }
}
