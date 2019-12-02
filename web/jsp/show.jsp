<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zeng
  Date: 2019/6/5
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/u2/all" method="post">
产品代码 <input type="text" size="3" name="id" value="${sessionScope.page.id}">
风险评级 <select name="dange" >、
    <option value="0">请选择</option>
    <option value="R2">R2</option>
    <option value="R3">R3</option>
</select>
    <input type="submit" value="查询">
</form>
<table bgcolor="blue" cellspacing="0" cellpadding="10" border="1">
    <tr>
        <td>产品代码</td>
        <td>风险评级</td>
        <td>预期收益</td>
        <td>发售起始日</td>
        <td>发售截止日</td>
        <td>产品到期日</td>
    </tr>
    <c:forEach var="money" items="${sessionScope.list}">
        <tr>
            <td>${money.id}</td>

            <td>
                ${money.dange}
            </td>
            <td>${money.rate}</td>
            <td>${money.birth}</td>
            <td>${money.death}</td>
            <td>${money.birthday}</td>
        </tr>
    </c:forEach>
</table>

<table>
    <tr>
        <td><a href="javascript:goPage(1)">首页</a></td>
        <td><a href="javascript:goPage(${sessionScope.page.currPage-1})">上一页</a></td>
        <c:forEach var="i" begin="1" end="${sessionScope.page.totalPage}">
            <td><a href="javascript:goPage(${i})">${i}</a></td>
        </c:forEach>
        <td><a href="javascript:goPage(${sessionScope.page.currPage+1})">下一页</a></td>
        <td><a href="javascript:goPage(${sessionScope.page.totalPage})">尾页</a></td>
        <td>跳转到第<input type="text" value="${sessionScope.page.currPage}" size="3">页
            <input type="button" value="Go" onclick="goPage(this.previousElementSibling.value)"></td>
    </tr>
</table>
</body>
<script>
    function goPage(v) {
        if (v>${sessionScope.page.totalPage}){
            v=${sessionScope.page.totalPage}
        }
        if (v<1){
            v=1
        }
        location.href="/u2/all?currPage="+v
    }
</script>
</html>
