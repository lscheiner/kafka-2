package br.com.scheiner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.scheiner.config.UrlUtils;
import br.com.scheiner.dto.EmployeeDTO;
import br.com.scheiner.producer.ProducerService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

	private ProducerService producerService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<String> producerAvroMessage(@RequestBody EmployeeDTO employeeDTO) {

		this.producerService.send(employeeDTO);
		return ResponseEntity.created(UrlUtils.createUrl("1")).build();
	}

}
