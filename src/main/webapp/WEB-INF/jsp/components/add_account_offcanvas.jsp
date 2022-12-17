<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- Right side offcanvas: Offcanvas Account -->
<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasRightLabel">Create / Add an Account </h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <!-- End of Offcanvas body: Accounts Form Wrapper -->
    <div class="offcanvas-body">
        <!-- Card: Accounts Form Card -->

        <div class="card">
            <!--  Card body  -->
            <div class="card-body">
                <form action="/account/create_account" method="POST" class="add-account-form">
                    <!-- Form group  -->
                    <div class="form-group mb-3">
                        <label for="">Enter Account Name</label>
                        <input type="text" name="accountName" class="form-control" placeholder="Enter Account Name">
                    </div>
                    <!-- End of Form group  -->
                    <!-- Form group  -->
                    <div class="form-group mb-3">
                        <label for="">Select Account Type</label>
                        <select name="accountType" id="" class="form-control">
                            <option value="current">Current</option>
                            <option value="savings">Savings</option>
                        </select>
                    </div>
                    <!-- End of Form group  -->

                    <!-- Form Group -->
                    <div class="form-group my-2">
                        <button id="transact-btn" class="btn btn-md transaction-btn">Add Account</button>
                    </div>
                    <!-- End of Form Group -->
                </form>

            </div>
            <!-- End of Card body  -->
        </div>

        <!-- End Card: Accounts Form Card -->
    </div>
    <!-- End of Offcanvas body: Accounts Form Container -->
</div>
<!-- End of Right side offcanvas: Accounts Form Container -->