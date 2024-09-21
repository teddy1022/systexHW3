<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
<link href="../style/myStyle.css" rel="stylesheet"><link>
</head>
<body>
	<h1>Lottery Number Generator</h1>
    <form action="LotteryController.do" method="post">
    	<table>
    		<tbody>
    			<tr>
					<td>Exclude Numbers (separate by space): </td>
					<td><input class="txt" type="text" name="excludeNumbers"></td>
				</tr>
				<tr>
					<td>Loop Count: </td>
					<td><input class="txt" type="text" name="loopCount"><br></td>
				</tr>
				<tr>     		 
        	</tbody>
        </table>	
        <input class="submit" type="submit" value="Generate">
    </form><br/><br/>
    <a href="../index.jsp">Back to Home</a>
</body>
</html>