<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
	<!--begin::Head-->
	<head>
<base href="../../../" />
		<title>그루베어</title>
		<meta charset="utf-8" />
		<meta name="description" content="The most advanced Bootstrap 5 Admin Theme with 40 unique prebuilt layouts on Themeforest trusted by 100,000 beginners and professionals. Multi-demo, Dark Mode, RTL support and complete React, Angular, Vue, Asp.Net Core, Rails, Spring, Blazor, Django, Express.js, Node.js, Flask, Symfony & Laravel versions. Grab your copy now and get life-time updates for free." />
		<meta name="keywords" content="metronic, bootstrap, bootstrap 5, angular, VueJs, React, Asp.Net Core, Rails, Spring, Blazor, Django, Express.js, Node.js, Flask, Symfony & Laravel starter kits, admin themes, web design, figma, web development, free templates, free admin themes, bootstrap theme, bootstrap template, bootstrap dashboard, bootstrap dak mode, bootstrap button, bootstrap datepicker, bootstrap timepicker, fullcalendar, datatables, flaticon" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta property="og:locale" content="en_US" />
		<meta property="og:type" content="article" />
		<meta property="og:title" content="Metronic - The World's #1 Selling Bootstrap Admin Template by KeenThemes" />
		<meta property="og:url" content="https://keenthemes.com/metronic" />
		<meta property="og:site_name" content="Metronic by Keenthemes" />
		<link rel="canonical" href="http://authentication/layouts/overlay/sign-in.html" />
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/demo1/assets/media/logos/favicon.ico" />
		<!--begin::Fonts(mandatory for all pages)-->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:300,400,500,600,700" />
		<!--end::Fonts-->
		<!--begin::Global Stylesheets Bundle(mandatory for all pages)-->
		<link href="${pageContext.request.contextPath}/resources/demo1/assets/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resources/demo1/assets/css/style.bundle.css" rel="stylesheet" type="text/css" />
		<!--end::Global Stylesheets Bundle-->
		<script>// Frame-busting to prevent site from being loaded within a frame without permission (click-jacking) if (window.top != window.self) { window.top.location.replace(window.self.location.href); }</script>
	<c:if test="${not empty message }">
		<script>
		Swal.fire({
            text: "${message}",
            icon: "error",
            confirmButtonText: "확인",
            customClass: {
                confirmButton: "btn btn-primary"
            }
		});
		</script>
	</c:if>  
	</head>
	<!--end::Head-->
	<!--begin::Body-->
	<body id="kt_body" class="app-blank bgi-size-cover bgi-attachment-fixed bgi-position-center">
		<!--begin::Theme mode setup on page load-->
		<script>var defaultThemeMode = "light"; var themeMode; if ( document.documentElement ) { if ( document.documentElement.hasAttribute("data-bs-theme-mode")) { themeMode = document.documentElement.getAttribute("data-bs-theme-mode"); } else { if ( localStorage.getItem("data-bs-theme") !== null ) { themeMode = localStorage.getItem("data-bs-theme"); } else { themeMode = defaultThemeMode; } } if (themeMode === "system") { themeMode = window.matchMedia("(prefers-color-scheme: dark)").matches ? "dark" : "light"; } document.documentElement.setAttribute("data-bs-theme", themeMode); }</script>
		<!--end::Theme mode setup on page load-->
		<!--begin::Root-->
		<div class="d-flex flex-column flex-root" id="kt_app_root">
			<!--begin::Page bg image-->
			<style>body { background-image: url('${pageContext.request.contextPath}/resources/demo1/assets/media/auth/bg10.jpeg'); } [data-bs-theme="dark"] body { background-image: url('assets/media/auth/bg10-dark.jpeg'); }</style>
			<!--end::Page bg image-->
			<!--begin::Authentication - Sign-in -->
			<div class="d-flex flex-column flex-lg-row flex-column-fluid">
				<!--begin::Aside-->
				<div class="d-flex flex-lg-row-fluid">
					<!--begin::Content-->
					<div class="d-flex flex-column flex-center pb-0 pb-lg-10 p-10 w-100">
						<!--begin::Image-->
						<img class="theme-light-show mx-auto mw-800 w-800px w-lg-800px mb-10 mb-lg-20" src="${pageContext.request.contextPath}/resources/demo1/assets/media/auth/login_background.gif" alt="" />
						<img class="theme-dark-show mx-auto mw-100 w-150px w-lg-300px mb-10 mb-lg-20" src="${pageContext.request.contextPath}/resources/demo1/assets/media/auth/login_background.gif" alt="" />
						<!--end::Image-->
						<!--begin::Title-->
						<h1 class="text-gray-600 fs-5qx fw-bold text-center mb-7">G R O O  B E A R</h1>
						<!--end::Title-->
						<!--begin::Text-->
						<!-- <div class="text-gray-600 fs-base text-center fw-semibold">In this kind of post, 
						<a href="#" class="opacity-75-hover text-primary me-1">the blogger</a>introduces a person they’ve interviewed 
						<br />and provides some background information about 
						<a href="#" class="opacity-75-hover text-primary me-1">the interviewee</a>and their 
						<br />work following this is a transcript of the interview.</div> -->
						<!--end::Text-->
					</div>
					<!--end::Content-->
				</div>
				<!--begin::Aside-->
				<!--begin::Body-->
				<div class="d-flex flex-column-fluid flex-lg-row-auto justify-content-center justify-content-lg-end p-12">
					<!--begin::Wrapper-->
					<div class="bg-body d-flex flex-column flex-center rounded-4 w-md-600px p-10">
						<!--begin::Content-->
						<div class="d-flex flex-center flex-column align-items-stretch h-lg-100 w-md-400px">
							<!--begin::Wrapper-->
							<div class="d-flex flex-center flex-column flex-column-fluid pb-15 pb-lg-20">
								<!--begin::Form-->
								<form class="form w-100" id="kt_sign_in_form" data-kt-redirect-url="/index" action="/loginProcess" method="post">
									<!--begin::Heading-->
									<div class="text-center mb-11">
										<!--begin::Title-->
										<h1 class="text-gray-900 fw-bolder mb-3">그루베어</h1>
										<!--end::Title-->
										<!--begin::Subtitle-->
										<div class="text-gray-500 fw-semibold fs-6">로그인</div>
										<!--end::Subtitle=-->
									</div>
									<!--begin::Heading-->
									<!--begin::Separator-->
									<div class="separator separator-content my-14">
										<span class="w-125px text-gray-500 fw-semibold fs-7"></span>
									</div><br><br>
									<!--end::Separator-->
									<!--begin::Input group=-->
									<div class="fv-row mb-8">
										<!--begin::ID-->
										<input type="text" placeholder="ID 입력" name="emplId" autocomplete="off" class="form-control bg-transparent" />
										<!--end::ID-->
									</div>
									<!--end::Input group=-->
									<div class="fv-row mb-3">
										<!--begin::Password-->
										<input type="password" placeholder="PASSWORD 입력" name="emplPW" autocomplete="off" class="form-control bg-transparent" />
										<!--end::Password-->
									</div><br><br><br><br>
									<!--end::Input group=-->
									<!--begin::Submit button-->
									<div class="d-grid mb-10">
										<button type="submit" id="kt_sign_in_submit" class="btn btn-dark">
											<!--begin::Indicator label-->
											<span class="indicator-label">로그인</span>
											<!--end::Indicator label-->
<!-- 											begin::Indicator progress -->
											<span class="indicator-progress">잠시만 기다려주세요... 
											<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
<!-- 											end::Indicator progress -->
										</button>
									</div><br><br>
									<!--end::Submit button-->
								</form>
								<!--end::Form-->
								<!--begin::Sign up-->
								<div class="justify-content-center text-gray-500 text-center fw-semibold fs-base gap-5">
								<button class="btn btn-secondary fw-bolder">사원</button>&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-secondary fw-bolder">팀장</button>&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-secondary fw-bolder">대표이사</button></div>
								<!--end::Sign up-->
							</div>
							<!--end::Wrapper-->
						</div>
						<!--end::Content-->
					</div>
					<!--end::Wrapper-->
				</div>
				<!--end::Body-->
			</div>
			<!--end::Authentication - Sign-in-->
		</div>
		<!--end::Root-->
		<!--begin::Javascript-->
		<script>
		// HTML 요소들을 가져옵니다.
		const emplIdInput = document.querySelector('input[name="emplId"]');
		const emplPWInput = document.querySelector('input[name="emplPW"]');

		// 각 버튼에 대한 이벤트 리스너를 추가합니다.
		document.querySelectorAll('.btn-secondary').forEach(button => {
		    button.addEventListener('click', function() {
		        // 각 버튼의 텍스트 값을 확인하여 ID와 PASSWORD를 설정합니다.
		        switch (this.textContent) {
		            case '사원':
		                emplIdInput.value = 'nara';
		                emplPWInput.value = 'nara';
		                break;
		            case '팀장':
		                emplIdInput.value = 'kbs';
		                emplPWInput.value = 'kbs';
		                break;
		            case '대표이사':
		                emplIdInput.value = 'psj';
		                emplPWInput.value = 'psj';
		                break;
		            default:
		                break;
		        }
		    });
		});
		</script>
		<script>var hostUrl = "assets/";</script>
		<!--begin::Global Javascript Bundle(mandatory for all pages)-->
		<script src="${pageContext.request.contextPath}/resources/demo1/assets/plugins/global/plugins.bundle.js"></script>
		<script src="${pageContext.request.contextPath}/resources/demo1/assets/js/scripts.bundle.js"></script>
		<!--end::Global Javascript Bundle-->
		<!--begin::Custom Javascript(used for this page only)-->
		<script src="${pageContext.request.contextPath}/resources/demo1/assets/js/custom/authentication/sign-in/general.js"></script>
		<!--end::Custom Javascript-->
		<!--end::Javascript-->
	</body>
	<!--end::Body-->
</html>