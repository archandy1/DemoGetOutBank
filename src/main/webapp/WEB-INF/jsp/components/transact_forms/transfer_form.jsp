<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Card: transfer-card -->
<div class="card transfer-card">
    <!-- Card body -->
    <div class="card-body">

        <!-- transfer form -->
        <form action="/transact/transfer" method="POST">
            <!-- Form group -->
            <div class="form-group">
                <label for="">Select Account</label>
                <!-- Select account option -->
                <select name="transfer_from" class="form-control" id="">
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

            <!-- Form group -->
            <div class="form-group">
                <label for="">Select Account</label>
                <!-- Select account option -->
                <select name="transfer_to" class="form-control" id="">
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
            <div class="form-group mb-2">
                <label for="">Enter Transfer Amount</label>
                <input type="text" name="transfer_amount" class="form-control" placeholder="Enter Transfer Amount">
            </div>
            <!-- End of Form Group -->

            <!-- Form Group -->
            <div class="form-group mb-2">

                <button id="transact-btn" class="btn btn-md transaction-btn">Transfer</button>
            </div>
            <!-- End of Form Group -->

        </form>
        <!-- end of transfer form -->

    </div>
    <!-- End of card body -->

</div>
<!-- End of Card: transfer-card -->