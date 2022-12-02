<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/fontawesome/css/all.css">

    <style>
        * {
            box-sizing: border-box;
            font-family: Verdana, Geneva, Tahoma, sans-serif;
        }

        body {
            height: 100vh;
        }

        .card .card-text {
            font-size: medium;
        }
    </style>
    <title>Error</title>
</head>
<body class="d-flex align-items-center justify-content-center">

<!-- card: error card -->
<div class="card col-3 alert alert-danger border border-danger">

    <!-- Card Title -->
    <h3 class="card-title">
        <i class="fa fa-window-close"></i> Error:
        <hr>
    </h3>
    <!-- Card body-->
    <div class="card-body">
        <!-- Card text-->
        <p class="card-text">
            <!-- Display message -->
            <c:if test="${requestScope.error != null}">
        <div class="alert-danger text-center border border-danger">
            <b>${requestScope.error}</b>
        </div>
        </c:if>
        <!-- End Display message -->
        </p>
        <!-- End of Card text-->
        <hr>

        <!-- Back to login page -->
        <a href="login.html" class="btn btn-sm btn-danger">
            <i class="fa fa-arrow-alt-circle-left me-1"></i> Back
        </a>
        <!-- End Back to login page -->
    </div>
    <!-- End of Card body-->


    <!-- End of Card Title -->

</div>

<!-- End of card: error card -->

</body>
</html>