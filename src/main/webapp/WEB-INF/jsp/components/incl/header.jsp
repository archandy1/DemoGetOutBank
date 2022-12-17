<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- Main Page Header-->

<header class="main-page-header mb-3">
    <!-- container -->
    <div class="container d-flex">
        <!-- Company Name -->
        <div id="company" class=" h1 company-name">
            GetOutBank
        </div>
        <!-- End Company Name -->

        <!-- Navigation -->
        <div class="nav-title navigation">
            <li><a href="/app/dashboard">Dashboard</a></li>
<%--            <li><a href="/app/payment_history">Payment History</a></li>--%>
            <li><a href="/app/transact_history">Transaction History</a></li>
        </div>
        <!-- End Navigation -->

        <!-- Display name -->
        <div class="display-name ms-auto text-white">
            <i class="fa fa-circle text-success"></i> Welcome: <span>${user.firstName} ${user.lastName}</span>
        </div>
        <!-- End of  Display name -->

        <!-- logout button -->
        <a id="sign-out-btn" href="/logout" class="btn btn-bg text-white ms-2">
            <i id="sign-out" class="fas fa-sign-out-alt"></i> Sign Out
        </a>
        <!-- End of logout button -->
    </div>
    <!-- end of container -->
</header>
<!-- End of Main Page Header-->