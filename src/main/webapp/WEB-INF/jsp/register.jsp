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
    <link rel="stylesheet" href="css/default.css">
    <title>Register</title>
</head>
<body class="d-flex align-items-center justify-content-center">

<!-- Card: Registration form card -->
<div class="card registration-form-card col-6 border-0">
    <!-- card body -->

    <div class="card-body">
        <!-- form header -->
        <h1 class="form-header card-title mb-3">
            <i class="fa fa-edit"></i> User registration form
        </h1>
        <!-- end form header -->

        <!-- Display message -->
        <c:if test="${requestScope.passwordMisMatch != null}">
            <div class="alert-danger text-center border border-danger">
                <b>${requestScope.passwordMisMatch}</b>
            </div>
        </c:if>
        <!-- End Display message -->

        <!-- Display message -->
        <c:if test="${requestScope.success != null}">
            <div class="alert-success text-center border-danger">
                <b>${requestScope.success}</b>
            </div>
            <!-- End Display message -->
        </c:if>

        <!-- Registration form -->
        <form:form action="/register" class="reg-form" modelAttribute="registerUser">
            <!-- row -->
            <div class="row">
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="firstName" class="form-control" placeholder="Enter first name"/>
                    <form:errors path="firstName" class="bg-denger"/>
                </div>
                <!-- End of From group -->
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="lastName" class="form-control" placeholder="Enter last name"/>
                    <form:errors path="lastName" class="bg-denger"/>
                </div>
                <!-- End of From group -->
            </div>
            <!-- End of row -->
            <!-- From group -->
            <div class="form-group col">
                <form:input type="email" path="email" class="form-control" placeholder="Enter email"/>
                <form:errors path="email" class="bg-denger"/>
            </div>
            <!-- End of From group -->
            <!-- row -->
            <div class="row">
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="password" path="password" class="form-control" placeholder="Enter password"/>
                    <form:errors path="password" class="bg-denger"/>
                </div>
                <!-- End of From group -->
                <!-- From group -->
                <div class="form-group col">
                    <input type="password" name="confirm_password" class="form-control" placeholder="Confirm password"/>
                    <small class="bg-danger">${confirm_pass}</small>
                </div>
                <!-- End of From group -->

            </div>
            <div class="row">
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="pesel" class="form-control" placeholder="Enter pesel"/>
                    <form:errors path="pesel" class="bg-denger"/>

                </div>
                <!-- End of From group -->
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="dateOfBirth" class="form-control"
                                placeholder="Enter date of birth"/>
                    <form:errors path="dateOfBirth" class="bg-denger"/>
                </div>
                <!-- End of From group -->
            </div>
            <div class="row">
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="city" class="form-control" placeholder="Enter City"/>
                    <form:errors path="city" class="bg-denger"/>
                </div>
                <!-- End of From group -->
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="zipCode" class="form-control" placeholder="Enter Zip-code"/>
                    <form:errors path="zipCode" class="bg-denger"/>
                </div>
                <!-- End of From group -->
            </div>
            <div class="row">
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="streetName" class="form-control" placeholder="Enter Street Name"/>
                    <form:errors path="streetName" class="bg-denger"/>
                </div>
                <!-- End of From group -->
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="streetNumber" class="form-control"
                                placeholder="Enter Street Number"/>
                    <form:errors path="streetNumber" class="bg-denger"/>
                </div>
                <!-- End of From group -->
            </div>
            <div class="row">
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="flatOrBuildingNumber" class="form-control"
                                placeholder="Enter Building number"/>
                    <form:errors path="flatOrBuildingNumber" class="bg-denger"/>
                </div>
                <!-- End of From group -->
                <!-- From group -->
                <div class="form-group col">
                    <form:input type="text" path="phoneNumber" class="form-control" placeholder="Enter Phone number"/>
                    <form:errors path="phoneNumber" class="bg-denger"/>
                </div>
                <!-- End of From group -->
            </div>
            <!-- End of row -->
            <!-- From group -->
            <div class="form-group col">
                <button class="btn btn-lg">Register</button>
            </div>
        </form:form>

        <!-- End Registration form -->

        <!-- Card text -->
        <p class="card-text my-2">
            Already have an account? <span class="ms-2 text-warning"><a href="/login"
                                                                        class="btn btn-sm text-warning"></a>Sign In</span>
        </p>
        <!-- Card text -->

        <!-- Back button to landing page -->
        <small class="text-warning">
            <i class="fa fa-arrow-alt-circle-left me-1"></i> <a href="/" class="btn btn-sm text-warning">Back</a>
        </small>
        <!--End  Back button to landing page -->

    </div>

    <!-- end card body -->


</div>
<!-- ECard: Registration form card -->

</body>
</html>