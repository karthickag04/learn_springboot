<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - JSP App</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f9f9f9;
            text-align: center;
            margin-top: 60px;
        }
        .form-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            display: inline-block;
            box-shadow: 0 0 15px rgba(0,0,0,0.15);
        }
        h2 {
            margin-bottom: 25px;
            color: #333;
        }
        input[type="text"], input[type="password"], input[type="email"] {
            width: 250px;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .back-link {
            margin-top: 15px;
            display: block;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>User Registration</h2>
        
		
		<form action="/register" method="post">
            <input type="text" name="username" placeholder="Username" required /><br />
            <input type="email" name="email" placeholder="Email" required /><br />
            <input type="password" name="password" placeholder="Password" required /><br />

			<input type="text" name="address" placeholder="address" required /><br />
            <input type="submit" value="Register" />
        </form>
		
		
        <a href="index.jsp" class="back-link">← Back to Home</a>
    </div>

</body>
</html>
