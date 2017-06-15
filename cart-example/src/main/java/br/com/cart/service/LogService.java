package br.com.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cart.model.Log;
import br.com.cart.resource.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository repository;

	public void insert(Log log) {
		repository.save(log);
	}
}
