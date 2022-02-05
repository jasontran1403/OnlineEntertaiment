<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="tm-page-wrap mx-auto">
	<div class="position-relative">
		<div class="position-absolute tm-site-header">
			<div class="container-fluid position-relative">
				<div class="row">
					<div class="col-2 col-md-2">
						<a href="index" class="text-center tm-logo-container">
							<i class="fas fa-video tm-site-logo mb-1"></i>
							<h1 class="tm-site-name" style="color: white">Home</h1>
						</a>
					</div>
					<div class="col-3 col-md-6 ml-auto mr-0">
						<div class="tm-site-nav">
							<nav class="navbar navbar-expand-lg mr-0 ml-auto"
								id="tm-main-nav">
								<button
									class="navbar-toggler tm-bg-black py-2 px-3 mr-0 ml-auto collapsed"
									type="button" data-toggle="collapse" data-target="#navbar-nav"
									aria-controls="navbar-nav" aria-expanded="false"
									aria-label="Toggle navigation">
									<span> <i class="fas fa-bars tm-menu-closed-icon"></i> <i
										class="fas fa-times tm-menu-opened-icon"></i>
									</span>
								</button>
								<div class="collapse navbar-collapse tm-nav" id="navbar-nav"
									style="font-size: 7px">
									<ul class="navbar-nav text-uppercase">
										<c:choose>
											<c:when test="${not empty sessionScope.currentUser}">
												<ul class="nav-item active">
													<a data-toggle="modal" data-target="#changePassModal" class="nav-link tm-nav-link">Welcome back,
														${sessionScope.currentUser.username}</a>
														

												</ul>

												<li class="nav-item"><a class="nav-link tm-nav-link"
													href="favorite">My Watch List</a></li>
													
													<li class="nav-item"><a class="nav-link tm-nav-link"
													href="history">My History</a></li>

												<li class="nav-item"><a class="nav-link tm-nav-link"
													href="logout">Logout</a></li>


											</c:when>

											<c:otherwise>
												<li class="nav-item active"><a
													class="nav-link tm-nav-link" href="index">Welcome back,
														GUEST <span class="sr-only">(current)</span>
												</a></li>
												<li class="nav-item"><a class="nav-link tm-nav-link"
													href="login">Login</a></li>

												<li class="nav-item"><a class="nav-link tm-nav-link"
													href="register">Register</a></li>
													<li class="nav-item"><a class="nav-link tm-nav-link"
													href="forgotPass">Forgot Password</a></li>
											</c:otherwise>
										</c:choose>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="tm-video-container">
			<video autoplay muted loop id="tm-video">
				<!-- <source src="video/sunset-timelapse-video.mp4" type="video/mp4"> -->
				<source
					src="<c:url value='/templates/user/video/wheat-field.mp4" type="video/mp4' />">
			</video>
		</div>

		<i id="tm-video-control-button" class="fas fa-pause"></i>
	</div>
	
	
<div class="modal fade" id="changePassModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Change Pass</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <input class="form-control rounded-0" type="password" name="currentPass" id="currentPass" placeholder="Enter your old password!" required/>
        <input class="form-control rounded-0" type="password" name="newPass" id="newPass" placeholder="Enter your new password!" required/>
        <input class="form-control rounded-0" type="password" name="confPass" placeholder="Confirm your new password!" required/>
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-warning pb-3" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-warning" id="changePassBtn">Update</button>
        <h5 style="color: orange" id="message" class="message"></h5>
      </div>
    </div>
  </div>
</div>

