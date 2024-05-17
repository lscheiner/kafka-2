package br.com.scheiner.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.scheiner.Employee;
import br.com.scheiner.EmployeeKey;
import br.com.scheiner.dto.EmployeeDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProducerService {

	private final KafkaTemplate<EmployeeKey, Employee> kafkaTemplate;

	private static final String TOPIC = "employee";

	public void send(EmployeeDTO employeeDTO) {

		Employee employee = new Employee();

		employee.setName(employeeDTO.getName());
		employee.setLastName(employeeDTO.getLastname());
		employee.setDocument(employeeDTO.getDocument());

		EmployeeKey employeeKey = new EmployeeKey();
		employeeKey.setDocument(employeeDTO.getDocument());

		this.kafkaTemplate.send(TOPIC, employeeKey, employee);

	}

}
