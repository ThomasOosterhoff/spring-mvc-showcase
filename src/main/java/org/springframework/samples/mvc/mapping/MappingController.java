package org.springframework.samples.mvc.mapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

	@GetMapping("/mapping/path")
	public String byPath() {
		return "Mapped by path!";
	}

	@GetMapping("/mapping/path/*")
	public String byPathPattern(HttpServletRequest request) {
		return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}

	@GetMapping("/mapping/method")
	public String byMethod() {
		return "Mapped by path + method";
	}

	@GetMapping(path="/mapping/parameter", params="foo")
	public String byParameter() {
		return "Mapped by path + method + presence of query parameter!";
	}

	@GetMapping(path="/mapping/parameter", params="!foo")
	public String byParameterNegation() {
		return "Mapped by path + method + not presence of query parameter!";
	}

	@GetMapping(path="/mapping/header", headers="FooHeader=foo")
	public String byHeader() {
		return "Mapped by path + method + presence of header!";
	}

	@GetMapping(path="/mapping/header", headers="!FooHeader")
	public String byHeaderNegation() {
		return "Mapped by path + method + absence of header!";
	}

	@PostMapping(path="/mapping/consumes", consumes= MediaType.APPLICATION_JSON_VALUE)
	public String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}

	@GetMapping(path="/mapping/produces", produces=MediaType.APPLICATION_JSON_VALUE)
	public JavaBean byProducesJson() {
		return new JavaBean();
	}

	@GetMapping(path="/mapping/produces", produces=MediaType.APPLICATION_XML_VALUE)
	public JavaBean byProducesXml() {
		return new JavaBean();
	}

	@GetMapping(path="/mapping/produces.xml",  produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public JavaBean byProducesDotXml() {
		return new JavaBean();
	}
	@GetMapping(path="/mapping/produces.json", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JavaBean byProducesDotJson() {
		return new JavaBean();
	}
}
