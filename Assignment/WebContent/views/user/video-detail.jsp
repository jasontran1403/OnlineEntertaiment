<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/common/head.jsp"%>
</head>
<body>
	<div class="tm-page-wrap mx-auto">
		<%@ include file="/common/header.jsp"%>

		<!-- Page content -->
		<div class="container-fluid">
			<div class="mx-auto tm-content-container">
				<main>
					<div class="row mb-12 pb-12">
						<div class="col-12">
							<iframe id="tm-video"
								src="https://www.youtube.com/embed/${video.href}"
								style="height: 768px;"> </iframe>
						</div>
					</div>
					<div class="row mb-5 pb-5">
						<div class="col-xl-8 col-lg-7">
							<!-- Video description -->
							<div class="tm-video-description-box">
								<h2 class="mb-5 tm-video-title">Description</h2>
								<p class="mb-4">${video.description}</p>

							</div>
						</div>
						<div class="col-xl-4 col-lg-5">
							<!-- Share box -->
							<div class="tm-bg-gray tm-share-box">
								<c:if test="${not empty sessionScope.currentUser}">
									<button id="likeOrUnlike"
										class="tm-bg-white px-5 mb-4 d-inline-block tm-text-primary tm-likes-box tm-liked">
										<c:choose>
											<c:when test="${flag == true}">
												Liked
											</c:when>
											<c:otherwise>
												Like
											</c:otherwise>
										</c:choose>
									</button>

									<a href="#" style="text-align: center"
										class="tm-bg-white px-5 mb-4 d-inline-block tm-text-primary tm-likes-box tm-liked">
										<span id="tm-likes-count">Share</span>
									</a>
								

								<div>
									<button
										class="btn w-50 d-flex btn-primary p-0 tm-btn-animate tm-btn-download tm-icon-download">
										<span>Download</span>
									</button>
								</div>
								</c:if>

							</div>
						</div>
					</div>
					<div class="row pt-4 pb-5">
						<div class="col-12">
							<h2 class="mb-5 tm-text-primary">Related Videos for You</h2>
							<div class="row tm-catalog-item-list">
								<div class="col-lg-4 col-md-6 col-sm-12 tm-catalog-item">
									<div class="position-relative tm-thumbnail-container">
										<img src="<c:url value='/templates/user/img/tn-01.jpg' />" alt="Image"
											class="img-fluid tm-catalog-item-img"> <a
											href="video-page.html"
											class="position-absolute tm-img-overlay"> <i
											class="fas fa-play tm-overlay-icon"></i>
										</a>
									</div>
									<div class="p-3 tm-catalog-item-description">
										<h3 class="tm-text-gray text-center tm-catalog-item-title">Nam
											tincidunt consectetur</h3>
									</div>
								</div>

							</div>
						</div>
					</div>
				</main>
			</div>
		</div>
	</div>
	<input id="videoId" type="hidden" value="${video.href}" />
</body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script>
	$('#likeOrUnlike').click(function() {
		var videoId = $('#videoId').val();
		$.ajax({
			url : 'video?action=like&id=' + videoId
		}).then(function(data) {
			var text = $('#likeOrUnlike').text();
			if (text.indexOf('Like') != -1) {
				$('#likeOrUnlike').text('Liked');
			} else {
				$('#likeOrUnlike').text('Like');
			}
		}).fail(function(error) {
		});
	});
</script>
</html>