<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Container: No accounts -->
<div class="container">
    <!-- Card NO ACCOUNTS -->
    <div class="card no-accounts-card">
        <!-- Card body -->
        <div class="card-body">
            <!-- Card title -->
            <h1 class="card-title">
                <i class="fas fa-ban text-danger"></i> You have no accounts
            </h1>
            <!-- End Card title -->
            <hr>

            <!-- Card text -->
            <div class="card-text">
                You currently have no active accounts. <br>
                Please click below to add a new account.

            </div>
            <!-- END Card text -->
            <br>
            <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
                    aria-controls="offcanvasRight">
                Add New Account
            </button>

        </div>
        <!-- End of Card body -->

    </div>
    <!-- END Card NO ACCOUNTS -->
</div>
<!-- END Container: No accounts -->