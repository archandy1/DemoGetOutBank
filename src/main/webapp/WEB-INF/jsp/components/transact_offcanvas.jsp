<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start of Offcanvas Transactions -->
<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasExampleLabel">Transactions</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <!-- Offcanvas: Transactions body -->
    <div class="offcanvas-body">

        <!-- Transaction Type drop down list-->
        <select name="transaction-type" class="form-control my-3" id="transact-type">
            <option value="">Select transaction type</option>
            <option value="transfer">Transfer</option>
            <option value="deposit">Deposit</option>
            <option value="withdraw">Withdraw</option>
        </select>
        <!-- END Transaction Type drop down list-->

        <!-- Payment form cards-->
<%--        <c:import url="components/transact_forms/payment_form.jsp"/>--%>
        <!-- Transfer form cards-->
        <c:import url="components/transact_forms/transfer_form.jsp"/>
        <!-- Deposit form cards-->
        <c:import url="components/transact_forms/deposit_form.jsp"/>
        <!-- Withdraw form cards-->
        <c:import url="components/transact_forms/withdraw_form.jsp"/>

    </div>
    <!-- End of Offcanvas: Transactions body -->
</div>
<!-- End of Start Offcanvas Transactions -->