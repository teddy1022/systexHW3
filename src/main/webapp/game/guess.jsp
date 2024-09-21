<!DOCTYPE html>
<html>
<head>
    <title>Guess Game</title>
    <link href="../style/myStyle.css" rel="stylesheet"><link>
</head>
<body>
    <h1>Guess a number between 1 and 10</h1>
    <form action="GameController.do" method="post">
    
    	<table>
    		<tbody>
    			<tr>
					<td>Your guess: </td>
					<td><input class="txt" type="text" name="guessNumber"></td>
				</tr>
	 
        	</tbody>
		</table>
        <input class="submit" type="submit" value="Generate">
    </form>
    <%
        String error = request.getParameter("error");
        if ("invalid".equals(error)) {
    %>
        <p style="color: red;">Please enter a valid number!</p>
    <%
        }
        String remains = request.getParameter("remains");
        if (remains != null) {
    %>
        <p>You have <%= remains %> guesses left.</p>
    <%
        }
    %>
       
    <%

        String hint = (String) session.getAttribute("hint");
        if (hint != null) {
    %>
        <p style="color: blue;"><%= hint %></p>
    <%
            session.removeAttribute("hint");
        }
    %>
    <br/><br/>
    <a href="../index.jsp">Back to Home</a>
</body>
</html>
