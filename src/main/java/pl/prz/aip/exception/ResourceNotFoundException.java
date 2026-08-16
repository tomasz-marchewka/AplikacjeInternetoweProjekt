package pl.prz.aip.exception;

/**
 * Zgłaszany, gdy żądany zasób (lub powiązana encja) nie istnieje.
 * Mapowany przez {@link GlobalExceptionHandler} na odpowiedź HTTP 404.
 */
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
