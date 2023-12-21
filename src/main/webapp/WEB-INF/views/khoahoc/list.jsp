<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>List Lop hoc</title>
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
                                Danh sách các lớp học
                            </h2>
                        </div>
                        <div class="body table-responsive">
                            <table class="table table-striped" id="dataTable-listMember">
                                <thead>
                                    <tr>
                                        <th>Mã Khoá</th>
										<th>Tên Khoá</th>
										<th>Học Phí</th>
										<th>Button</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${not empty khoaHocs}">
                                    	<c:forEach items="${khoaHocs}" var="khoaHoc">
											<tr>
												<td>${khoaHoc.maKhoa }</td>
												<td>${khoaHoc.tenKhoa }</td>
												<td>${khoaHoc.hocPhi }</td>
												<td>
													<a href="${contextPath}/khoahoc/update?id=${lopHoc.maLop }">Update</a>
													<a href="${contextPath}/khoahoc/delete?id=${lopHoc.maLop }">Delete</a>
													<a href="${contextPath}/khoahoc/detail?id=${lopHoc.maLop }">Detail</a>
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