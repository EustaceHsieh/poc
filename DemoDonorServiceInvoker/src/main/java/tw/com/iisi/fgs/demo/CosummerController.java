package tw.com.iisi.fgs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CosummerController {

	@Autowired
	private RestTemplate restTemplate;
/*	
	@GetMapping("client")
	public String query() {
		String url = "http://fgs-donor-service/api/importDonations/";
//		String url = "http://fgs-donor-service/api/donors/";
//		String url = "http://fgs-donor-service/api/donors/?donorSN=PD40200070815000095";
		
		return restTemplate.getForEntity(url, String.class).getBody();
	}
*/	

	@GetMapping("client")
	public String query() {
		String url = "http://fgs-donor-service/api/donorinfos/?type=1&name=DD40100070101000001  ";
//		String url = "http://fgs-donor-service/api/donors/";
//		String url = "http://fgs-donor-service/api/donors/?donorSN=PD40200070815000095";
		
		return restTemplate.getForEntity(url, String.class).getBody();
	}
	
}