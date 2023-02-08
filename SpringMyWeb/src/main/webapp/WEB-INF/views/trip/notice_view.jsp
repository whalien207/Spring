<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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

	<!-- //bodytext_area -->

	<!--  
		삭제시는 post로 동작하는데
		hidden이용해서 삭제에 필요한 키값을 전달해줍니다.
		js를 이용해서 form을 전송
		-->

	<form action="deleteForm" method="post" name="actionForm">
		<input type="hidden" name="tno" value="${vo.tno }" />

		<div class="bodytext_area box_inner">
			<ul class="bbsview_list">
				<li class="bbs_title">${vo.title }</li>
				<li class="bbs_hit">작성일 : <span><fmt:formatDate
							value="${vo.regdate}" pattern="yyyy-MM-dd" /></span></li>
				<li class="bbs_date">작성자 : <span>${vo.writer }</span></li>
				<li class="bbs_content">
					<div class="editer_content">${vo.content }</div>
				</li>
			</ul>
			<p class="btn_line txt_right">
				<a href="notice_modify?tno=${vo.tno }" class="btn_bbs">글수정</a> <a
					href="javascript:;" class="btn_bbs" onclick="noticeDelete()">글삭제</a>
				<a href="notice_list" class="btn_bbs">목록</a>
			</p>
			<ul class="near_list mt20">
				<!--
				1. 글이 2개인 경우 - 이전글 < 현재글인 경우 이전글
				2. 글이 1개인 경우 
				3. 글이 0개인 경우
				 -->
				<c:forEach var="data" items="${list }">
				
					<c:if test="${fn:length(list) == 1 and data.tno < vo.tno }">
						<li><h4 class="prev">다음글</h4>다음글이 없습니다.</li>
					</c:if>
					
					<c:if test="${data.tno > vo.tno }">
						<li><h4 class="prev">다음글</h4><a href="notice_view?tno=${data.tno}">${data.title }</a></li>
					</c:if>
					
					<c:if test="${data.tno < vo.tno }">
						<li><h4 class="next">이전글</h4><a href="notice_view?tno=${data.tno}">${data.title }</a></li>
					</c:if>
					
					<c:if test="${fn:length(list) == 1 and data.tno > vo.tno }">
						<li><h4 class="next">이전글</h4>이전글이 없습니다.</li>
					</c:if>
					
				</c:forEach>
<%-- 
				<li><h4 class="prev">다음글</h4><a href="javascript:;">${list[1].title }</a></li>
				<li><h4 class="next">이전글</h4><a href="javascript:;">${list[0].title }</a></li>
				
 --%>
 			</ul>
		</div>
	</form>

</div>
<!-- //container -->

<script>
	//a링크 고유 이벤트 중지
	function noticeDelete(){
		event.preventDefault();
		//폼형식으로 삭제 - document.form 이름
		if(confirm("정말 삭제하시겠습니까?")){
			document.actionForm.submit();
		}
	}
	</script>
