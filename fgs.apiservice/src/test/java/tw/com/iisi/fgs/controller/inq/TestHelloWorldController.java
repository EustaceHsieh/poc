/**
 * 
 */
package tw.com.iisi.fgs.controller.inq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import tw.com.iisi.fgs.controller.AbstractTest;

class TestHelloWorldController extends AbstractTest {

	@Before
	public void setUp() {
		super.setUp();
	}

	// @Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void getHello() throws Exception {

		if (null == mvc) {
			log.info("MVC is NULL");
			super.setUp();
		}

		String uri = "/api/HelloWorld/sayHello";
		String inputJson = "";

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		log.info(content);
		assertEquals(content, "Hello");
	}

	@Test
	void getFgsUnit() throws Exception {

		if (null == mvc) {
			log.info("MVC is NULL");
			super.setUp();
		}

		String uri = "/api/HelloWorld/getFgsUnit";
		uri = uri + "?fgsUnitID=D40100";
		String inputJson = "";

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		log.info("=========getFgsUnit==============");
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString(Charset.defaultCharset());
		log.info(content);
		log.info("=========getFgsUnit==END============");
		// assertEquals(content, "Hello");
	}

	class QueryFgsUnitDto {
		private String fgsUnitID;

		public QueryFgsUnitDto(String fgsUnitID) {
			super();
			this.fgsUnitID = fgsUnitID;
		}

		public String getFgsUnitID() {
			return fgsUnitID;
		}

		public void setFgsUnitID(String fgsUnitID) {
			this.fgsUnitID = fgsUnitID;
		}
	}
}
