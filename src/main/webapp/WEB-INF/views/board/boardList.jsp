<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h3>${board} List</h3>
	  <div class="row">
		  <div class="col-sm-8">
			  <form id="searchForm" action="./${board}List">
			  	<input type="hidden" name="curPage" id="curPage">
			   <div class="input-group">
			   	<select class="input-group-sm" id="kind" name="kind">
			   		<option value="tt">Title</option>
			   		<option value="wr">Writer</option>
			   		<option value="con">Contents</option>
			   	</select>
			    		<input id="search" type="text" class="form-control" name="search" placeholder="Additional Info">
			    	<div class="input-group-btn">
			      	<button class="btn btn-default" type="submit">
			        	<i class="glyphicon glyphicon-search"></i>
			      	</button>
			    	</div>
			  	</div> 
			  </form>
		  </div>
	  </div>
  
  <table class="table table-hober">
  	<tr>
  		<td>Num</td>
  		<td>Title</td>
  		<td>Writer</td>
  		<td>Contents</td>
  		<td>Date</td>
  		<td>Hit</td>	
  	</tr>
  	
  	<c:forEach items="${lists}" var="list" varStatus="vs">
      <tr>
        <td>${list.num} : ${vs.first}</td>
        <td>
        	<a href ="./${board}Select?num=${list.num}">
        	<c:catch>
        	<c:forEach begin="1" end="${list.depth}">--</c:forEach>
        	</c:catch>
       		${list.title}
        	</a>
        </td>
        <td>${list.writer}</td>
        <td>${list.contents}</td>
        <td>${list.regDate}</td>
        <td>${list.hit}</td>
      </tr>
    </c:forEach>
  
  </table>
  <div>
	<c:if test="${pager.beforeCheck}">
  	 	<a href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">[이전]</a>
  	 </c:if>
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  		<a href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
  	</c:forEach>
  	<c:if test="${pager.nextCheck}">
  		<a href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">[다음]</a>
  	</c:if>
  </div>
  
  
  <a href="${board}Write" class="btn btn-danger">WRITE</a>
  
</div>

</body>
</html>