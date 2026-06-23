package pl.prz.aip.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pl.prz.aip.service.DzialService;
import pl.prz.aip.web.dto.DzialRequest;
import pl.prz.aip.web.dto.DzialResponse;

@RestController
@RequestMapping("/dzialy")
public class DzialController {

	private final DzialService dzialService;

	public DzialController(DzialService dzialService) {
		this.dzialService = dzialService;
	}

	@GetMapping
	public List<DzialResponse> getAll() {
		return dzialService.findAll();
	}

	@GetMapping("/{id}")
	public DzialResponse getById(@PathVariable Integer id) {
		return dzialService.findById(id);
	}

	@PostMapping
	public ResponseEntity<DzialResponse> add(@Valid @RequestBody DzialRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dzialService.create(request));
	}
}
