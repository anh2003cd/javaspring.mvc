<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>

            <!-- Latest compiled and minified CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
            <!-- Latest compiled JavaScript -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            <!--link rel="stylesheet" href="/css/demo.css"-->
        </head>

        <body>

            <h2 style="text-align: center"> Create a user</h2>

            <form style="text-align: center;">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-3">
                    <label for="phone_number" class="form-label">phone_number</label>
                    <input type="text" class="form-control" id="phone_number">
                </div>
                <div class="mb-3">
                    <label for="Full_name" class="form-label">Full_name</label>
                    <input type="password" class="form-control" id="Full_name">
                </div>
                <div class="Address">
                    <label for="Address" class="form-label">Address</label>
                    <input type="password" class="form-control" id="Address">
                </div>


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </body>

        </html>