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

<%--header--%>
<c:import url="components/incl/header.jsp"/>

<!-- CONTAINER -->
<div class="container">

    <!-- Payment History -->
    <div class="card">
        <div class="card-header">
            <i class="fas fa-credit-card me-2"></i> Transaction History
        </div>
        <!-- card body -->
        <div class="card-body">
            <c:if test="${requestScope.transact_history !=null}">
                <!-- Payment history TAble -->
                <table class="table text-center table-striped">
                    <tr>
                        <th>Transaction ID</th>
                            <%--                                <th>Account Name</th>--%>
                        <th>Transaction Type</th>
                        <th>Amount</th>
                        <th>Source</th>
                        <th>Status</th>
                        <th>Reason Code</th>
                        <th>Created At</th>
                    </tr>
                    <!-- Loop through Payment history  -->
                    <c:forEach items="${requestScope.transact_history}" var="trasactionHistory">
                        <tr>
                            <td>${trasactionHistory.transaction_id}</td>
                                <%--                                    <td>${trasactionHistory.account_name}</td>--%>
                            <td>${trasactionHistory.transaction_type}</td>
                            <td>${trasactionHistory.amount}</td>
                            <td>${trasactionHistory.source}</td>
                            <td>${trasactionHistory.status}</td>

                            <td>${trasactionHistory.reason_code}</td>
                            <td>${trasactionHistory.created_at}</td>
                        </tr>
                    </c:forEach>
                    <!-- End Loop through Payment history  -->
                </table>
                <!-- End Payment history TAble -->
            </c:if>
        </div>
        <!-- End of card body -->
    </div>
    <!-- End of container -->
</div>
<!-- END OF CONTAINER -->


<%--footer--%>
<c:import url="components/incl/footer.jsp"/>
