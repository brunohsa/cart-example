package br.com.cart.resource;

import org.springframework.data.repository.CrudRepository;

import br.com.cart.model.Log;

public interface LogRepository extends CrudRepository<Log, Long> {

}
