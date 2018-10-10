package com.hanfy.fizzbuzz.rest;


import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanfy.fizzbuzz.model.FizzbuzzRequest;
import com.hanfy.fizzbuzz.model.FizzbuzzResponse;
import com.hanfy.fizzbuzz.service.FizzbuzzService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * The Class FizzbuzzRestController.
 */
@Api(value = "Fizzbuzz game API")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fizzbuzz/")
public class FizzbuzzRestController {

	/** The fizzbuzz service. */
	private FizzbuzzService fizzbuzzService;
	
	/**
	 * Instantiates a new fizzbuzz rest controller.
	 *
	 * @param fizzbuzzService the fizzbuzz service
	 */
	public FizzbuzzRestController(FizzbuzzService fizzbuzzService) {
		this.fizzbuzzService = fizzbuzzService;
	}
	
    /**
     * Play.
     *
     * @param fizzbuzzRequest the fizzbuzz request
     * @return the fizzbuzz response
     */
    @ApiOperation(value = "Play fizzbuzz game")
	@ApiResponses(value = { 
			@ApiResponse(code = HttpStatus.SC_OK, message = "Graet fizzbuzz game!"),
			@ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = "You are not authorized to view the resource"),
			@ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = "The resource you were trying to reach is not found")})
    @PostMapping(name = "play", value = "play",
    	produces={ MediaType.APPLICATION_JSON_VALUE },
    	consumes={ MediaType.APPLICATION_JSON_VALUE })
    public FizzbuzzResponse play(
    		@ApiParam(required = true) @RequestBody @Valid final FizzbuzzRequest fizzbuzzRequest) {
    	
				return fizzbuzzService.play(fizzbuzzRequest);
    }
}
