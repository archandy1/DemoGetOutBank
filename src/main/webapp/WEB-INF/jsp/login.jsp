<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/fontawesome/css/all.css">
    <link rel="stylesheet" href="../src/main/resources/static/css/fontawesome/default.css">
    <title>Login</title>
</head>

<body class="d-flex align-items-center justify-content-center">

<!-- Card: Login form card -->
<div class="card login-form-card col-3 border-0">
    <!-- card body -->

    <div class="card-body">
        <!-- form header -->
        <h1 class="form-header mb-3">
            <i class="fa fa-user-circle"></i> Login
        </h1>
        <!-- end form header -->
        <!-- Display message -->
        <c:if test="${requestScope.success != null}">
            <div class="alert-success text-center border border-success">
                <b>${requestScope.success}</b>
            </div>
        </c:if>
        <!-- End Display message -->
        <c:if test="${requestScope.error != null}">
            <div class="alert-danger text-center border border-danger">
                <b>${requestScope.error}</b>
            </div>
        </c:if>

        <!-- Display message -->
        <c:if test="${logged_out != null}">
            <div class="alert-info text-center border border-info">
                <b>${logged_out}</b>
            </div>
        </c:if>
        <!-- End Display message -->
        <!-- End Display message -->
        <!-- Login form -->
        <form action="/login" method="POST" class="login-form">

            <!-- From group -->
            <div class="form-group col">
                <input type="email" name="email" class="form-control" placeholder="Enter email"/>
            </div>
            <!-- End of From group -->
            <!-- row -->

            <!-- From group -->
            <div class="form-group col">
                <input type="password" name="password" class="form-control" placeholder="Enter password"/>
            </div>
            <!-- End of From group -->

            <!-- From group -->
            <div class="form-group col">
                <input type="hidden" name="token" value="${token}"/>
            </div>
            <!-- End of From group -->

            <!-- From group -->
            <div class="form-group col">
                <button class="btn btn-lg">Login</button>
            </div>
        </form>
        <!-- End Login form -->

        <!-- Card text -->
        <p class="card-text my-2">
            Don't have an account? <span class="ms-2 text-warning"><a href="/register" class="btn btn-bg text-warning"></a>Sign Up</span>
        </p>
        <!-- Card text -->

        <!-- Back button to landing page -->
        <small class="text-warning">
            <i class="fa fa-arrow-alt-circle-left me-1"></i> <a href="/" id="back-btn" class="btn btn-sm text-warning">Back</a>
        </small>
        <!--End  Back button to landing page -->

    </div>
    <!-- end card body -->

</div>
<!-- ECard: Login form card -->
</body>
</html>