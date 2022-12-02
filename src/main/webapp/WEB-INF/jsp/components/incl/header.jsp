<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- Main Page Header-->

<header class="main-page-header mb-3 bg-primary">
    <!-- container -->
    <div class="container d-flex">
        <!-- Company Name -->
        <div class="company-name">
            Get-Out Bank
        </div>
        <!-- End Company Name -->

        <!-- Navigation -->
        <div class="nav navigation">
            <li><a href="/app/dashboard">Dashboard</a></li>
            <li><a href="/app/payment_history">Payment History</a></li>
            <li><a href="/app/transact_history">Transaction History</a></li>
        </div>
        <!-- End Navigation -->

        <!-- Display name -->
        <div class="display-name ms-auto text-white">
            <i class="fa fa-circle text-success"></i> Welcome: <span>${user.first_name} ${user.last_name}</span>
        </div>
        <!-- End of  Display name -->

        <!-- logout button -->
        <a href="/logout" class="btn btn-sm text-white ms-2">
            <i class="fas fa-sign-out-alt"></i> Sign Out
        </a>
        <!-- End of logout button -->
    </div>
    <!-- end of container -->
</header>
<!-- End of Main Page Header-->