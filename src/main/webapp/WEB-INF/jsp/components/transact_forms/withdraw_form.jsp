<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Card: Withdraw-card -->
<div class="card withdraw-card">
    <!-- Card body -->
    <div class="card-body">

        <!-- Withdraw Form -->
        <form action="/transact/withdraw" method="POST" class="withdraw-form">
            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for="">Enter Withdraw Amount</label>
                <input type="text" name="withdrawal_amount" class="form-control" placeholder="Enter Withdraw Amount">
            </div>
            <!-- End of Form Group -->


            <!-- Form group -->
            <div class="form-group">
                <label for="">Select Account</label>
                <!-- Select account option -->
                <select name="account_id" class="form-control" id="">
                    <option value="">Select Account</option>

                    <c:if test="${userAccounts !=null }">
                        <c:forEach items="${userAccounts}" var="selectAccount">
                            <option value="${selectAccount.account_id}">${selectAccount.account_name}</option>
                        </c:forEach>
                    </c:if>
                </select>
                <!-- End Select account option -->
            </div>
            <!-- End of group -->


            <!-- Form Group -->
            <div class="form-group my-2">
                <button id="transact-btn" class="btn btn-md transaction-btn">Withdraw</button>
            </div>
            <!-- End of Form Group -->
        </form>
        <!-- End of Withdraw form -->
    </div>
    <!-- End of Card body  -->
</div>
<!-- End of Card: Withdraw-card -->