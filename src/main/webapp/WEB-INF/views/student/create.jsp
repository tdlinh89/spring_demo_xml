<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create new student</title>
	<link rel="stylesheet" href="/resources/css/index.css">
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/page-loader.jsp" />
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" />
    <jsp:include page="/WEB-INF/views/layout/sidebar.jsp" />
    
    <section class="content">
        <div class="container-fluid">
            <!-- Vertical Layout -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                Create new Student
                            </h2>
                        </div>
                        <div class="body">
                            <form:form id="form-register" action="${contextPath}/student/create" method="post" modelAttribute="student">
                                <form:label path="id">ID: <span style="color: red;"> *</span></form:label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <form:input path="id"  class="form-control" placeholder="ID" tabindex="1" />
                                        <span class="error-msg-2" id="id-error"><form:errors path="id"></form:errors></span>
                                    </div>
                                </div>
                                <label for="name">Name: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input class="form-control" name="name" id="name" placeholder="Name" tabindex="2" />
                                        <span class="error-msg-2" id="name-error"><form:errors path="name"></form:errors></span>
                                    </div>
                                </div>
                                <form:label path="age">Age: <span style="color: red;"> *</span></form:label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <form:input path="age" class="form-control" placeholder="Age" tabindex="3" />
                                        <span class="error-msg-2" id="age-error"><form:errors path="age"></form:errors></span>
                                    </div>
                                </div>
                                <form:label path="address">Address: <span style="color: red;"> *</span></form:label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <form:input path="address" id="address" class="form-control" placeholder="Address" tabindex="4" />
                                        <span class="error-msg-2" id="address-error"><form:errors path="address"></form:errors></span>
                                    </div>
                                </div>
                                <form:label path="birthday">Birthday: <span style="color: red;"> *</span></form:label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <form:input path="birthday" id="birthday" class="form-control" placeholder="Birthday" tabindex="5" />
                                        <span class="error-msg-2" id="birthday-error"><form:errors path="birthday"></form:errors></span>
                                    </div>
                                </div>
                                <form:label path="lopHoc">Lớp Học: <span style="color: red;"> *</span></form:label>
                                <div class="form-group">
                                    <div class="form-line">
	                                    <form:select path="lopHoc" class="form-control" tabindex="6">
												<form:options items="${lopHocs}" itemLabel="tenLop" itemValue="maLop" class="form-control"/>
										</form:select>
                                        <span class="error-msg-2" id="lopHoc-error"><form:errors path="lopHoc"></form:errors></span>
                                    </div>
                                </div>
                                <form:label path="phoneNumber">Phone number: <span style="color: red;"> *</span></form:label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <form:input path="phoneNumber" class="form-control" placeholder="Phone number" tabindex="8" />
                                        <span class="error-msg-2" id="phoneNumber-error"><form:errors path="phoneNumber"></form:errors></span>
                                    </div>
                                </div>
                                
                                <button type="submit" class="btn btn-primary btn-custom" tabindex="12"><i class="fa fa-check" aria-hidden="true"></i> Add</button>
                                <a href="${contextPath}/student/list" class="btn btn-primary btn-custom" tabindex="13"><i class="fa fa-remove" aria-hidden="true"></i> Back</a>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<jsp:include page="/WEB-INF/views/layout/script.jsp" />
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>