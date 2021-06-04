package web.community.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TtsController {
		
	@RequestMapping("/tts")
	public String tts() {
		
		return "tts/tts";
	}
	
	@ResponseBody
	@RequestMapping("/tts/action")
	public String Action(@RequestParam("txt_content") String txt_content) {
		
		String path=null;
		
		try {
			URL url = new URL("https://kakaoi-newtone-openapi.kakao.com/v1/synthesize");					
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			System.out.println(conn);
			conn.setConnectTimeout(10000);
			conn.addRequestProperty("Authorization", "카카오 인증키");
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			
			String data = "<speak>" + txt_content + "</speak>";
					    
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(data);
            dos.flush();
            dos.close();
            
            int responseCode = conn.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = conn.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                
                System.out.println(is.read(bytes));
                // 랜덤한 이름으로 mp3 파일 생성
                String tempname = Long.valueOf(new Date().getTime()).toString()+".mp3";
                System.out.println(tempname);
                String realpath = new ClassPathResource("/static/mp3").getFile().getAbsolutePath();
                //String realpath = "/community/src/main/resources/static/mp3";
                System.out.println(realpath);
                realpath += File.separator+tempname;
                System.out.println(realpath);
                File f = new File(realpath);
                f.createNewFile();
                OutputStream os = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    os.write(bytes, 0, read);
                }
                is.close();
                path = "/mp3/"+tempname;
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return path;
	}
 			
/*		    OutputStreamWriter os = new OutputStreamWriter(conn.getOutputStream());
		    
		    os.write(data);
		    os.flush();
			
		    BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		   
		    System.out.println(buffer.readLine());
		    
 
		    System.out.println(conn.getResponseMessage());

			Object anser = conn.getResponseCode();
			System.out.println(anser);
*/			
			
		
		

		/*HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.add("Authorization", "KakaoAK c42219bb9d493d3c35b4dec24eee0137");

		RestTemplate restTemplate = new RestTemplate();

		String url = "https://kakaoi-newtone-openapi.kakao.com/v1/synthesize";

		String requestJson = "{\"data\":\"<speak> 그는 그렇게 말했습니다. \r\n" + 
				"<voice name=\"MAN_DIALOG_BRIGHT\">잘 지냈어? 나도 잘 지냈어.</voice> \r\n" + 
				"<voice name=\"WOMAN_DIALOG_BRIGHT\" speechStyle=\"SS_ALT_FAST_1\">금요일이 좋아요.</voice> </speak>}";
		
		System.out.println(requestJson);
		
		HttpEntity<String> entity = new HttpEntity<>(requestJson,headers);
		
		String answer ="d";
		System.out.println(answer);
		
		answer = restTemplate.postForObject(url, entity, String.class);

		System.out.println(answer);
		return answer;
*/
		
}
