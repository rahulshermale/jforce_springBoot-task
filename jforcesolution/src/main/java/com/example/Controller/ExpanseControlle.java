package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Expanse;
import com.example.Servicess.ExpanseService;



@RestController
@RequestMapping("/api/expanse")
public class ExpanseControlle {

	@Autowired
	private ExpanseService expanseService;

	@PostMapping
	public ResponseEntity<Expanse> createExpanse(@RequestBody Expanse expanse) {
		Expanse createdExpanse = expanseService.saveExpanse(expanse);
		
		
		System.err.println(createdExpanse.getDescription());
		return ResponseEntity.ok(createdExpanse);
	}

	@GetMapping
	public List<Expanse> getAllExpanse() {
		return expanseService.getAllExpanses();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Expanse> getExpanseById(@PathVariable Long id) {
		return expanseService.getExpanseById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	
	@GetMapping("/user/{userId}")
    public List<Expanse> getExpanseByUserId(@PathVariable Long userId) {
        return expanseService.getExpanseByUserId(userId);
    }
	

	 @PutMapping("/{id}")
	    public ResponseEntity<Expanse> updateExpanse(@PathVariable Long id, @RequestBody Expanse exapnseDetails) {
	        return expanseService.getExpanseById(id)
	                .map(ex -> {
	                	ex.setAmount(exapnseDetails.getAmount());
	                	ex.setDate(exapnseDetails.getDate());
	                	ex.setDescription(exapnseDetails.getDescription());
	                    Expanse updatedUser = expanseService.saveExpanse(ex);
	                    return ResponseEntity.ok(updatedUser);
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExpanse(@PathVariable Long id) {
		expanseService.deletExpanse(id);
		return ResponseEntity.ok().build();
	}
}
