<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Card: payment-card -->
<div class="card payment-card">
    <!-- Card body -->
    <div class="card-body">

<!--   Payment form      -->
        <form action="/transact/payment" method="POST">
            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for=""> Account Holder</label>
                <input type="text" name="beneficiary" class="form-control" placeholder="Enter Account holder">
            </div>
            <!-- End of Form Group -->

            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for=""> Account Number</label>
                <input type="text" name="accountNumber" class="form-control" placeholder="Enter Account holder number">
            </div>
            <!-- End of Form Group -->

            <!-- Form group -->
            <div class="form-group">
                <label for="">Select Account</label>
                <!-- Select account option -->
                <select name="accountId" class="form-control" id="">
                    <option value="">Select Account</option>

                    <c:if test="${userAccounts !=null }">
                        <c:forEach items="${userAccounts}" var="selectAccount">
                            <option value="${selectAccount.accountId}">${selectAccount.accountName}</option>
                        </c:forEach>
                    </c:if>
                </select>
                <!-- End Select account option -->
            </div>
            <!-- End of group -->

            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for="">Reference</label>
                <input type="text" name="reference" class="form-control" placeholder="Enter Reference">
            </div>
            <!-- End of Form Group -->

            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for="">Enter Payment Amount</label>
                <input type="text" name="payment_amount" class="form-control" placeholder="Enter Payment Amount">
            </div>
            <!-- End of Form Group -->

            <!-- Form Group -->
            <div class="form-group mb-2">

                <button id="transact-btn" class="btn btn-md transaction-btn">Pay</button>
            </div>
            <!-- End of Form Group -->
        </form>

<!--    End of payment form    -->

    </div>
    <!-- End Card body -->

</div>
<!-- End of Card: payment-card -->