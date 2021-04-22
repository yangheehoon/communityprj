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

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=432b24cffb05073443a6da4dbdb8c1c6&libraries=clusterer"></script>

<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.560701, 126.986667),
			level: 4
		};

		var map = new kakao.maps.Map(container, options);
		
		// 마커 클러스터러를 생성합니다 
	    var clusterer = new kakao.maps.MarkerClusterer({
	        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
	        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
	        minLevel: 10 // 클러스터 할 최소 지도 레벨 
	    });
		
		// 확진자 마커들의 집합(2차원배열)
		var marks = [
			[37.56148, 126.994079, '<div style="padding:5px;">확진자</div>'],
			[37.56096, 126.986325, '<div style="padding:5px;">확진자</div>'],
			[37.56601, 126.982622, '<div style="padding:5px;">확진자</div>']
		]
		
		//지도에 지역마다 표시될 마커갯수 변수
		var markers = [];
		
		// 마커들의 갯수만큼 반복문 반복
		for(var i=0; i<marks.length; i++){
		
			// 지도에 마커를 생성하고 표시한다
			var marker = new kakao.maps.Marker({
			    position: new kakao.maps.LatLng(marks[i][0], marks[i][1]), // 마커의 좌표
			    map: map // 마커를 표시할 지도 객체
			});
			
			// 마커 위에 표시할 인포윈도우를 생성한다
			var infowindow = new kakao.maps.InfoWindow({
			    content : marks[i][2] // 인포윈도우에 표시할 내용
			});
	
			// 인포윈도우를 지도에 표시한다
			infowindow.open(map, marker);
			
			//마커스변수에 마커담기
			markers.push(marker);
			// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
		    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
		    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
		    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
			
		}
		
		//클러스터에 마커들 카운트
		clusterer.addMarkers(markers);
		
		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
		    return function() {
		        infowindow.open(map, marker);
		    };
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
		    return function() {
		        infowindow.close();
		    };
		}
		
</script>

</body>
</html>