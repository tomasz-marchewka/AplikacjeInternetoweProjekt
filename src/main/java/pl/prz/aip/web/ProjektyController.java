package pl.prz.aip.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pl.prz.aip.service.ProjektService;
import pl.prz.aip.web.dto.ProjektRequest;
import pl.prz.aip.web.dto.ProjektResponse;

@RestController
@RequestMapping("/projekty")
public class ProjektyController {

	private final ProjektService projektService;

	public ProjektyController(ProjektService projektService) {
		this.projektService = projektService;
	}

	@GetMapping
	public List<ProjektResponse> getAll() {
		return projektService.findAll();
	}

	@GetMapping("/{id}")
	public ProjektResponse getById(@PathVariable Integer id) {
		return projektService.findById(id);
	}

	@PostMapping
	public ResponseEntity<ProjektResponse> add(@Valid @RequestBody ProjektRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(projektService.create(request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		projektService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
