<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코로나 지역</title>

</head>
<body>

<br>

<div id="map" style="width: 100%; height: 400px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=432b24cffb05073443a6da4dbdb8c1c6"></script>

<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		// 지도에 마커를 생성하고 표시한다
		var marker = new kakao.maps.Marker({
		    position: new kakao.maps.LatLng(33.450701, 126.570667), // 마커의 좌표
		    map: map // 마커를 표시할 지도 객체
		});
		
		// 마커 위에 표시할 인포윈도우를 생성한다
		var infowindow = new kakao.maps.InfoWindow({
		    content : '<div style="padding:5px;">카카오</div>' // 인포윈도우에 표시할 내용
		});

		// 인포윈도우를 지도에 표시한다
		infowindow.open(map, marker);
		
		// 지도에 마커를 생성하고 표시한다
		var marker2 = new kakao.maps.Marker({
		    position: new kakao.maps.LatLng(33.451101, 126.570667), // 마커의 좌표
		    map: map // 마커를 표시할 지도 객체
		});
		
		// 마커 위에 표시할 인포윈도우를 생성한다
		var infowindow2 = new kakao.maps.InfoWindow({
		    content : '<div style="padding:5px;">지역</div>' // 인포윈도우에 표시할 내용
		});

		// 인포윈도우를 지도에 표시한다
		infowindow2.open(map, marker2);
</script>

</body>
</html>