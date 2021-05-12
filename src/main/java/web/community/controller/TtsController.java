package web.community.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TtsController {

	@RequestMapping("/tts")
	public String tts() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.add("Authorization", "카카오앱키");

		RestTemplate restTemplate = new RestTemplate();

		String url = "https://kakaoi-newtone-openapi.kakao.com/v1/synthesize";

		String requestJson = "{\"data\":\"'<speak> 그는 그렇게 말했습니다. \r\n" + 
				"<voice name=\"MAN_DIALOG_BRIGHT\">잘 지냈어? 나도 잘 지냈어.</voice> \r\n" + 
				"<voice name=\"WOMAN_DIALOG_BRIGHT\" speechStyle=\"SS_ALT_FAST_1\">금요일이 좋아요.</voice> </speak>' > result.mp3\"}";
		
		System.out.println(requestJson);
		
		HttpEntity<String> entity = new HttpEntity<>(requestJson,headers);
		String answer = restTemplate.postForObject(url, entity, String.class);

		System.out.println(answer);
		return answer;
	}
}
