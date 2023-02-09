<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="container">
	<!-- location_area -->
	<div class="location_area customer">
		<div class="box_inner">
			<h2 class="tit_page">
				TOURIST <span class="in">in</span> TOUR
			</h2>
			<p class="location">
				고객센터 <span class="path">/</span> 공지사항
			</p>
			<ul class="page_menu clear">
				<li><a href="#" class="on">공지사항</a></li>
				<li><a href="#">문의하기</a></li>
			</ul>
		</div>
	</div>
	<!-- //location_area -->

	<!-- bodytext_area -->
	<div class="bodytext_area box_inner">
		<form action="notice_list" class="minisrch_form" name="actionForm">

			<fieldset>
				<select id="handleAmount" style="height: 35px;">
					<option value="10" ${page.amount == 10 ? 'selected' : '' }>10개씩 보기</option>
					<option value="20" ${page.amount == 20 ? 'selected' : '' }>20개씩 보기</option>
					<option value="50" ${page.amount == 50 ? 'selected' : '' }>50개씩 보기</option>
					<option value="100" ${page.amount == 100 ? 'selected' : '' }>100개씩 보기</option>
				</select>
				
				 <select name="searchType" style="height: 35px;">
					<option value="title" ${page.cri.searchType == 'title' ? 'selected' : '' }>제목</option>
					<option value="content" ${page.cri.searchType == 'content' ? 'selected' : '' }>내용</option>
					<option value="writer" ${page.cri.searchType == 'writer' ? 'selected' : '' }>작성자</option>
					<option value="titlecont" ${page.cri.searchType == 'titlecont' ? 'selected' : '' }>제목+내용</option>
				</select>
				<legend>검색</legend>
				<input name="searchName" value="${page.cri.searchName }" type="text" class="tbox" title="검색어를 입력해주세요" placeholder="검색어를 입력해주세요">
				<input type="hidden" name="page" value="1"> 
				<input type="hidden" name="amount" value="${page.amount }"> 
				
				<input type="submit" class="btn_srch" value="검색" style="line-height:30px;">
				<!-- <a href="javascript:;" class="btn_srch">검색</a> -->
				
				<a href="notice_write" class="btn_srch">글작성</a>
			</fieldset>
		</form>
		<table class="bbsListTbl" summary="번호,제목,조회수,작성일 등을 제공하는 표">
			<caption class="hdd">공지사항 목록</caption>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">조회수</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list }" varStatus="num">
					<tr>
						<td>${num.count }</td>
						<td class="tit_notice"><a href="notice_view?tno=${vo.tno }">${vo.title }</a></td>
						<td>${vo.hit }</td>
						<td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<%-- 		<!-- pagination -->
		<div class="pagination">
			<!-- 맨 앞으로 -->
			<a href="notice_list?page=1 &amount=${page.amount}" class="firstpage  pbtn">
				<img src="${pageContext.request.contextPath }/resources/img/btn_firstpage.png" alt="첫 페이지로 이동">
			</a> 
			
			<!-- 이전페이지네이션 -->
			<c:if test="${page.prev }">
				<a href="notice_list?page=${page.start - 1 } &amount=${page.amount}" class="prevpage  pbtn">
				<img src="${pageContext.request.contextPath }/resources/img/btn_prevpage.png" alt="이전 페이지로 이동">
				</a>
			</c:if>
			
			<!-- 페이지네이션 -->
			<c:forEach var="num" begin="${page.start }" end="${page.end }">
				<a href="notice_list?page=${num }&amount=${page.amount }">
				<span class="pagenum ${page.page == num ? 'currentpage' : ''}">${num }</span>
				</a>
			</c:forEach>
			
			<!-- 다음페이지네이션 -->
			<c:if test="${page.next }">
				<a href="notice_list?page=${page.end + 1 } &amount=${page.amount}" class="nextpage  pbtn">
					<img src="${pageContext.request.contextPath }/resources/img/btn_nextpage.png" alt="다음 페이지로 이동">
				</a>
			</c:if>
			
			<!-- 맨끝으로 -->
			<a href="notice_list?page=${page.realEnd } &amount=${page.amount}" class="lastpage  pbtn">
				<img src="${pageContext.request.contextPath }/resources/img/btn_lastpage.png" alt="마지막 페이지로 이동">
			</a>
		</div>
		<!-- //pagination --> --%>
		
		<!-- pagination -->
		<div class="pagination">
			<!-- 맨 앞으로 -->
			<!-- criteria model로 넘겨주지 않아도 객체명의 소문자로 사용할 수 있다. (Spring의 특징) -->
			<!-- 
			컨트롤러에서 사용자 클래스를 매개변수로 지정을 하면 이름이 클래스명 소문자로 
			지정되서 자동으로 다음화면으로 전달됩니다. 
			${criteria } 
			-->
			<a href="notice_list?page=1&amount=${page.amount}&searchType=${page.cri.searchType}&searchName=${page.cri.searchName}" class="firstpage  pbtn">
				<img src="${pageContext.request.contextPath }/resources/img/btn_firstpage.png" alt="첫 페이지로 이동">
			</a> 
			
			<!-- 이전페이지네이션 -->
			<c:if test="${page.prev }">
				<a href="notice_list?page=${page.start - 1 }&amount=${page.amount}&searchType=${page.cri.searchType}&searchName=${page.cri.searchName}" class="prevpage  pbtn">
				<img src="${pageContext.request.contextPath }/resources/img/btn_prevpage.png" alt="이전 페이지로 이동">
				</a>
			</c:if>
			
			<!-- 페이지네이션 -->
			<c:forEach var="num" begin="${page.start }" end="${page.end }">
				<a href="notice_list?page=${num }&amount=${page.amount }&searchType=${page.cri.searchType}&searchName=${page.cri.searchName}">
				<span class="pagenum ${page.page == num ? 'currentpage' : ''}">${num }</span>
				</a>
			</c:forEach>
			
			<!-- 다음페이지네이션 -->
			<c:if test="${page.next }">
				<a href="notice_list?page=${page.end + 1 }&amount=${page.amount}&searchType=${page.cri.searchType}&searchName=${page.cri.searchName}" class="nextpage  pbtn">
					<img src="${pageContext.request.contextPath }/resources/img/btn_nextpage.png" alt="다음 페이지로 이동">
				</a>
			</c:if>
			
			<!-- 맨끝으로 -->
			<a href="notice_list?page=${page.realEnd }&amount=${page.amount}&searchType=${page.cri.searchType}&searchName=${page.cri.searchName}" class="lastpage  pbtn">
				<img src="${pageContext.request.contextPath }/resources/img/btn_lastpage.png" alt="마지막 페이지로 이동">
			</a>
		</div>
		<!-- //pagination -->

	</div>
	<!-- //bodytext_area -->

</div>
<!-- //container -->

<script>
	var msg = '${msg}';
	if (msg !== '') {
		alert(msg);
	}
</script>

<script>
	var handleAmount = document.getElementById("handleAmount");
	handleAmount.onchange = function() {
		//console.log( event.target.value );
		document.actionForm.amount.value = event.target.value;
		document.actionForm.submit();
	}
</script>






