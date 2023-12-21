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
                    	<h2>Đăng ký khoá học</h2>
                    </div>
                    <form:form action="${contextPath }/student/createKhoaHoc" method="post" modelAttribute="dangKyKhoaHoc">
                    	<div>
	                    	<label>Sinh Viên</label>
	                    	<form:select path="studentId">
								<form:options items="${students}" itemLabel="name" itemValue="id"/>
							</form:select>
                    	</div>
                    	<div>
                    		<label>Khoá Học</label>
							<form:select path="maKhoa">
								<form:options items="${khoaHocs}" itemLabel="tenKhoa" itemValue="maKhoa"/>
							</form:select>
                    	</div>
                    	<div>
                    		<input type="reset" value="Reset">
							<form:button>Register</form:button>
                    	</div>
						
                    </form:form>
                </div>
            </div>
        </div>
    </section>

	<jsp:include page="/WEB-INF/views/layout/script.jsp" />
	<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
</body>
</html>