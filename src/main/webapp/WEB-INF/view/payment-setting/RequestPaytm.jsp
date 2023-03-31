<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request Paytm</title>
</head>
<body>
<form method="post" action="https://securegw-stage.paytm.in/theia/api/v1/showPaymentPage?mid=${mid}&orderId=${orderId}"
      name="paytm">

    <table border="1">
        <tbody>
        <input type="hidden" name="mid" value="${mid}">
        <input type="hidden" name="orderId" value="${orderId}">
        <input type="hidden" name="txnToken" value="${txnToken}">
        </tbody>
    </table>
    <script type="text/javascript"> document.paytm.submit(); </script>
</form>

</body>
</html>