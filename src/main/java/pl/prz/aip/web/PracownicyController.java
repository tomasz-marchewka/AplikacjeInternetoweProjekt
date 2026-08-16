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
import pl.prz.aip.service.PracownikService;
import pl.prz.aip.web.dto.PracownikRequest;
import pl.prz.aip.web.dto.PracownikResponse;

@RestController
@RequestMapping("/pracownicy")
public class PracownicyController {

	private final PracownikService pracownikService;

	public PracownicyController(PracownikService pracownikService) {
		this.pracownikService = pracownikService;
	}

	@GetMapping
	public List<PracownikResponse> getAll() {
		return pracownikService.findAll();
	}

	@PostMapping
	public ResponseEntity<PracownikResponse> add(@Valid @RequestBody PracownikRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pracownikService.create(request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		pracownikService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
