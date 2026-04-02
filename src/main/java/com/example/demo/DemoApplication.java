package com.example.demo;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
@RestController // This tells Spring this class handles API requests
public class DemoApplication {

	private Queue<String> patients = new LinkedList<>();
	
	

	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    } 
	
	//get is to read
	//post is to create
	//put is to update
	//delete is to delete

	@GetMapping("/readPatientNumber")//Endpoint to add a patient to the queue
	public String getPatientNumber() {
		
		String patientList = "Patients in the queue: ";

		for (String patient : patients) {
			patientList += patient + ", ";
		}
		return patients.isEmpty() ? "No patients in the queue." : patientList.substring(0, patientList.length() - 2); // Remove the last comma and space
	}
	//task: create an endpoint to add a patient to the queue and an endpoint to delete a patient from the queue
	//add a patient to the queue
	//delete a patient from the queue

	@PostMapping("/Patient++")
	public String addPatient(@RequestBody String newP){
		patients.add(newP);
		return "added patient succusfully " + newP;  
	}

	@DeleteMapping("/Patient--")
	public String deletepatient(){
		String removedpatient = patients.peek();
		if(!patients.isEmpty()){
			patients.remove();
			return "removed patient succusfully " + removedpatient;  
		}
		return "there is no patient to remove";
	}
	
}
//cant i run it
