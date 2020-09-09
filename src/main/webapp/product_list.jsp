<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共100种商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img src="${pageContext.request.contextPath }/images/productlist.gif" width="100%" height="38" />
								</div>

								<%-- <table cellspacing="0" class="booklist">
									<tr>
								<c:forEach items="${pb.books }" var="b">
										<td>

											<div class="divbookpic">
												<p>
													<a href="#"><img src="" width="115" height="129"
														border="0" /> </a>
												</p>
											</div>

											<div class="divlisttitle">
												<a href="${pageContext.request.contextPath }/servlet/findBookInfoServlet?id=${b.id}">书名:${b.name }<br />售价:${b.price } </a>
											</div>
										</td>
									</c:forEach>	
									</tr>
								</table> --%>
								
			<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt;  BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="15%">	商品编号</td>
								<td align="center" width="20%">商品名称</td>
								<td align="center" width="15%">商品价格</td>
								<td align="center" width="15%">商品数量</td>
								<td width="15%" align="center">商品类别</td>
								<td width="10%" align="center">编辑</td>
								<td width="10%" align="center">删除</td>
							</tr>

			<c:forEach items="${pb.books }" var="b">							
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td>${b.id }</td>
									<td>${b.name }</td>
									<td>${b.price }</td>
									<td>${b.pnum }</td>
									<td>${b.category }</td>
									<td><a
										href="${pageContext.request.contextPath}/servlet/findBookByIdServlet?id=${b.id }">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.png"
											border="0" style="CURSOR: hand"> </a>
									</td>

									<td ><a
										href="javascript:delBook('${b.id }','${b.name }')">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_del.png"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
									</td>
								</tr>
					</c:forEach>	
						</table>















								<div class="pagination">
									<ul>
										<li class="nextPage"><a href="${pageContext.request.contextPath  }/servlet/pageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}">&lt;&lt;上一页</a></li>
										
										<li>第${pb.currentPage }页/共${pb.totalPage }页</li>

										<li class="nextPage"><a href="${pageContext.request.contextPath  }/servlet/pageServlet?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}">下一页&gt;&gt;</a></li>
									</ul>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
