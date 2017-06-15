package br.com.cart.webservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class RestExample {

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showMessage(@RequestParam("value") String value) {
		return "This is a simple example of a rest : ".concat(value);
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void postExample(@RequestParam("value") String value) {
		System.out.println(value);
	}

}
