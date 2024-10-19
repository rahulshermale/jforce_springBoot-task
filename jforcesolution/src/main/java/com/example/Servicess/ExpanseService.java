package com.example.Servicess;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Expanse;
import com.example.Repository.ExpanseRepository;


@Service
public class ExpanseService {

	@Autowired
	private ExpanseRepository expanseRepository;


	public void addExpanseByUserId(Expanse expanse) {

		expanseRepository.save(expanse);

	}

	public void deletExpanse(Long userid) {

		expanseRepository.deleteById(userid);

	}


	public Expanse saveExpanse(Expanse expanse) {
		return expanseRepository.save(expanse);
	}

	public List<Expanse> getAllExpanses() {
		return expanseRepository.findAll();
	}

	public Optional<Expanse> getExpanseById(Long id) {
		return expanseRepository.findById(id);
	}
	 public List<Expanse> getExpanseByUserId(Long collegeId) {
	        return expanseRepository.findByUserUserId(collegeId);
	    }

}
