package in.ineuron.restcontroller;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.CustomerEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class CustomerRestController {
	
	/*
	 *   GET: http://localhost:9999/getEvent
	 */
	@GetMapping(value = "/getEvent",produces = "application/json")
	public ResponseEntity<Mono<CustomerEvent>> getCustomerEvent() {
		
		/* Creating Pojo object with data */
		CustomerEvent event = new CustomerEvent("SACHIN", new Date());
		
		/* Mono object which is used to send the response */
		Mono<CustomerEvent> customerMono = Mono.just(event);
		
		ResponseEntity<Mono<CustomerEvent>> responseEntity =
				new ResponseEntity<Mono<CustomerEvent>>(customerMono, HttpStatus.OK);
		
		return responseEntity;
	}	
	
	/*
	 * GET: http://localhost:9999/getEvents
	 */
	
	@GetMapping(value = "/getEvents", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<CustomerEvent>> getCustomerEvents() {

		/* Creating Pojo object with data */
		CustomerEvent event = new CustomerEvent("Smith", new Date());
	
		/* Creating Stream object to send data[Customer Data] */
		Stream<CustomerEvent> customerStream = Stream.generate(() -> event);

		/* Giving Stream object to Flux object */
		Flux<CustomerEvent> ceFlux = Flux.fromStream(customerStream);

		/* Setting Response Interval */
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(30));

		/* Combining IntervalFlux and CustomerEventFlux */
		Flux<Tuple2<Long, CustomerEvent>> zip = Flux.zip(interval, ceFlux);

		/* Getting Second Tuple value as Flux Obj */
		Flux<CustomerEvent> fluxMap = zip.map(Tuple2::getT2);
		
		
		/* Adding Flux Object to Response Body */
		ResponseEntity<Flux<CustomerEvent>> resEntity = 
				new ResponseEntity<Flux<CustomerEvent>>(fluxMap, HttpStatus.OK);

		/* Returning ResEntity with Flux */
		return resEntity;
	}

	
	
}
