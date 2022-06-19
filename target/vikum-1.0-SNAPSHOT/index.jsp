<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Addition of Students</title>

    <!-- css styling for table -->
    <style>
        .css-styled-table {
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 0.9em;
            font-family: sans-serif;
            min-width: 400px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
        }
        .css-styled-table thead tr {
            background-color: #009879;
            color: #ffffff;
            text-align: left;
        }
        .css-styled-table th,
        .css-styled-table td {
            padding: 12px 15px;
        }
        .css-styled-table tbody tr {
            border-bottom: 1px solid #dddddd;
        }

        .css-styled-table tbody tr:nth-of-type(even) {
            background-color: #f3f3f3;
        }

        .css-styled-table tbody tr:last-of-type {
            border-bottom: 2px solid #009879;
        }
        .css-styled-table tbody tr.active-row {
            font-weight: bold;
            color: #009879;
        }

        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }
    </style>


</head>
<body>

<h1>Add New Student</h1>

<!-- SaveServlet is the servlet name that is looked up and POST is the method that got called -->
<form action="SaveServlet" method="post">
    <table class="css-styled-table">
        <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>IM No:</td><td><input type="text" name="im"/></td></tr>
        <tr><td>DOB:</td><td><input type="date" name="dob"/></td></tr>
        <tr><td>Path:
        </td><td>

            <input type="radio" name="path" value="IT"><label>IT</label>

            <input type="radio" name="path" value="Management"><label>Management</label>

        </td></tr>
        <tr><td>Intern Company Name:</td><td><input type="text" name="company"/></td></tr>
        <tr><td colspan="2"><input type="submit" class="button" value="Save Student Details"/></td></tr>
    </table>
</form>

<br/>
<a href="ViewServlet">view Table</a>

</body>
</html>
