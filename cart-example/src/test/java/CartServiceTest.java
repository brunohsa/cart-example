import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import br.com.cart.SpringConfiguration;

public class CartServiceTest {

	private static final String URL = "http://localhost:8080/cart";
	private ConfigurableApplicationContext springApp;

	@Before
	public void startServer() {
		springApp = SpringApplication.run(SpringConfiguration.class, new String[] {});
	}

	@Test
	public void testServiceFindCart() {
		try {
			String urlFind = URL + "/findcartbyid?cartid=2";
			ClientHttpResponse response = createSimpleRequest(urlFind, HttpMethod.GET);

			Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ClientHttpResponse createSimpleRequest(String url, HttpMethod method) {
		try {
			SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
			ClientHttpRequest request = requestFactory.createRequest(convertStringURltoURI(url), method);

			return request.execute();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private URI convertStringURltoURI(String url) {
		try {
			return new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	@After
	public void closeServer() {
		SpringApplication.exit(springApp);
	}
}
