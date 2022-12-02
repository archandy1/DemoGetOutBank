<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="../css/fontawesome/css/all.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/bootstrap.bundle.js"></script>
    <title>Dashboard</title>
</head>
<body>

<c:import url="components/incl/header.jsp"/>

<!-- Transact Offcanvas  left-->
<c:import url="components/transact_offcanvas.jsp"/>

<!-- Add Accounts  Offcanvas  right-->
<c:import url="components/add_account_offcanvas.jsp"/>

<!-- messeges container -->
<div class="container">
    <!-- Display message -->
    <c:if test="${success != null}">
        <div class="alert-success text-center border border-success">
            <b>${success}</b>
        </div>
    </c:if>
    <!-- End Display message -->

    <!-- Display message -->
    <c:if test="${error != null}">
        <div class="alert-danger text-center border border-danger">
            <b>${error}</b>
        </div>
    </c:if>
    <!-- End Display message -->
</div>
<!-- End of messeges container -->


<c:choose>

<c:when test="${fn:length(userAccounts) > 0}">

    <c:import url="components/accounts_display.jsp"/>

</c:when>
<c:otherwise>

    <c:import url="components/no_accounts_display.jsp"/>

</c:otherwise>
</c:choose>

<c:import url="components/incl/footer.jsp"/>
