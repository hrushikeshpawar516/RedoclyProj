package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Student;
import com.nt.service.StudentManagementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;






@Tag(name = "Student", description = "Operations related to Student")
@RestController("/student")
public class StudentController {
	
	@Autowired
	private StudentManagementService ser;
	
	@PostMapping("/registerStudent")
    @Operation(summary = "Register Student", description = "This method help in registering the student")
	@SecurityRequirement(name = "bearerAuth")
	  @ApiResponses(value = {
			  @ApiResponse(
					    responseCode = "200",
					    description = "User response example",
					    content = @Content(
					        mediaType = "application/json",
					        examples = @ExampleObject(
					            value = """
					            {
					              "id": "123",
					              "name": "John Doe",
					              "email": "john.doe@example.com"
					            }
					            """
					        )
					    )
					),
		        @ApiResponse(responseCode = "400", description = "Invalid user ID format"),
		        @ApiResponse(responseCode = "401", description = "Unauthorized"),
		        @ApiResponse(responseCode = "403", description = "Forbidden - not allowed"),
		        @ApiResponse(responseCode = "404", description = "User not found"),
		        @ApiResponse(responseCode = "500", description = "Internal server error")
		    })
	public ResponseEntity<Student> registerStudent(@RequestBody Student entity) {		
		return new ResponseEntity<Student>(ser.registerStudent(entity),HttpStatus.OK);
	}
	
	@GetMapping("/findAllStudentDetails")
    @Operation(summary = "Find All Student", description = "This method help in Finding all student details ")

	public ResponseEntity<List<Student>> findAllStudentDetails() {
		return new ResponseEntity<List<Student>>(ser.findAllStudentDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/findStudentById")
    @Operation(summary = "Find Student", description = "This method help in finding the student by using id")
    @ApiResponse(responseCode = "400", description = "Invalid user ID format")

	public ResponseEntity<?> findStudentById(  
        	@RequestParam(name = "sid") Long id) {
		Optional<Student> st=ser.findStudentbyId(id);
		if(st.isPresent())
		return new ResponseEntity<Student>(st.get(),HttpStatus.OK);
		else
		return	new ResponseEntity<String>("Student info is not Found with given Id"+id,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteStudentById") 
	@Operation(summary = "Delete Student", description = "This method help in Deleting the student data by using Id")

	public ResponseEntity<?> deleteStudentById(@RequestParam(name = "sid")  Long id) {
		Optional<Student> st=ser.findStudentbyId(id);
		if(st.isPresent()) {
			ser.deleteStudentbyId(id);
		return new ResponseEntity<String>("Student with given id "+id+" Info is deleted",HttpStatus.OK);
		}
		else
		return	new ResponseEntity<String>("Student info is not Found for Deletion with given Id"+id,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAllStudents")
	@Operation(summary = "Delete All Student", description = "This method help in Deleting All the student.")

	public ResponseEntity<String> deleteAllStudentBy() {		
		return new ResponseEntity<String>("ALL Student Info is deleted",HttpStatus.OK);
		
	}
	
	@PutMapping("/updateStudentById")
    @Operation(summary = "Register Student", description = "This method help in registering the student")

	public ResponseEntity<String> updateStudentInfoById(@RequestParam(name="sid") Long id, @RequestBody Student entity) {

		Optional<Student> st=ser.findStudentbyId(id);
		if(st.isPresent()) {
			ser.updateStudentDetails(entity);
			return new ResponseEntity<String>("Student with given id "+id+" Info is Updated",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Student with given id "+id+" Info is not found for Updated",HttpStatus.OK);
	}
	
	
	
}
