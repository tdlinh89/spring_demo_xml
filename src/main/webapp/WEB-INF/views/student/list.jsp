<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>List student</title>
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/page-loader.jsp" />
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" />
    <jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />
    
    <section class="content">
        <div class="container-fluid">
            <!-- Striped Rows -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                List student
                            </h2>
                        </div>
                        <div>
                        	<form action="${contextPath }/student/list" method="get">
                        		<label>Chọn tên lớp</label>
                        		<select name="maLop">
                        			<c:forEach items="${lopHocs }" var="lopHoc">
                        				<option value="${lopHoc.maLop }">${lopHoc.tenLop }</option>
                        			</c:forEach>
								</select>
								<label>Chọn độ tuổi</label>
								<select name="age">
                        			<c:forEach items="${ages }" var="age">
                        				<option value="${age}">${age}</option>
                        			</c:forEach>
								</select>
								<input type="submit" value="Search">
                        	</form>
                        </div>
                        <div class="body table-responsive">
                            <table class="table table-striped" id="dataTable-listMember">
                                <thead>
                                    <tr>
                                        <th>ID</th>
										<th>Name</th>
										<th>Age</th>
										<th>Address</th>
										<th>Button</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${not empty listStudents}">
                                    	<c:forEach items="${listStudents}" var="student">
											<tr>
												<td>${student.id }</td>
												<td>${student.name }</td>
												<td>${student.age }</td>
												<td>${student.address }</td>
												<td>
													<a href="${contextPath}/student/update?id=${student.id }">Update</a>
													<a href="${contextPath}/student/delete?id=${student.id }">Delete</a>
													<a href="${contextPath}/student/detail?id=${student.id }">Detail</a>
												</td>
											</tr>
										</c:forEach>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Striped Rows -->
        </div>
    </section>
	<jsp:include page="/WEB-INF/views/layout/script.jsp" />
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>