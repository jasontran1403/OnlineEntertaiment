<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Online Entertaiment</title>
<%@ include file="/common/head.jsp"%>
<!--

TemplateMo 552 Video Catalog

https://templatemo.com/tm-552-video-catalog

-->
</head>
<body>
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div id="content" class="mx-auto tm-content-container">
			<main>
				<div class="row">
					<div class="col-12">
						<h2 class="tm-page-title mb-4">My History</h2>
						<!-- <div class="tm-categories-container mb-5">
							<h3 class="tm-text-primary tm-categories-text">Categories:</h3>
							<ul class="nav tm-category-list">
								<li class="nav-item tm-category-item"><a href="#"
									class="nav-link tm-category-link active">All</a></li>
								<li class="nav-item tm-category-item"><a href="#"
									class="nav-link tm-category-link">Drone Shots</a></li>
								<li class="nav-item tm-category-item"><a href="#"
									class="nav-link tm-category-link">Nature</a></li>
								<li class="nav-item tm-category-item"><a href="#"
									class="nav-link tm-category-link">Actions</a></li>
								<li class="nav-item tm-category-item"><a href="#"
									class="nav-link tm-category-link">Featured</a></li>
							</ul>
						</div> -->
					</div>
				</div>

				<div class="row tm-catalog-item-list">
					<c:forEach var="video" items="${videos }">
						<div class="col-lg-4 col-md-6 col-sm-12 tm-catalog-item">
							<div class="position-relative tm-thumbnail-container">
								<img src="<c:url value='/templates/user/img/tn-01.jpg' />" alt="Image"
									class="img-fluid tm-catalog-item-img"> <a
									href="<c:url value='/video?action=watch&id=${video.href}' />" class="position-absolute tm-img-overlay">
									<i class="fas fa-play tm-overlay-icon"></i>
								</a>
							</div>
							<div class="p-4 tm-bg-gray tm-catalog-item-description">
								<h5 class="tm-text-primary mb-3 tm-catalog-item-title">
									${video.title}</h5>
								<div class="d-flex justify-content-between tm-text-gray">
									Views: ${video.views}</div>
								<div class="d-flex justify-content-between tm-text-gray">
									Shares:${video.shares}</div>
							</div>

						</div>
					</c:forEach>

				</div>

				<!-- Catalog Paging Buttons -->
				<div>
					<ul class="nav tm-paging-links">
						<li class="nav-item active"><a href="#"
							class="nav-link tm-paging-link">1</a></li>
						<li class="nav-item"><a href="#"
							class="nav-link tm-paging-link">2</a></li>
						<li class="nav-item"><a href="#"
							class="nav-link tm-paging-link">3</a></li>
						<li class="nav-item"><a href="#"
							class="nav-link tm-paging-link">4</a></li>
						<li class="nav-item"><a href="#"
							class="nav-link tm-paging-link">></a></li>
					</ul>
				</div>
			</main>

			<%@ include file="/common/footer.jsp"%>
</body>

</html>