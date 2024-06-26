/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.mines.address.api.controller;

import org.mines.address.api.model.People;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-17T16:23:07.491195900+02:00[Europe/Paris]")
@Validated
@Tag(name = "people", description = "the people API")
public interface PeopleApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /people : Create a people
     *
     * @param people  (required)
     * @return Null response (status code 201)
     */
    @Operation(
        operationId = "createPeople",
        summary = "Create a people",
        tags = { "people" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Null response", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = People.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/people",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<People> createPeople(
        @Parameter(name = "People", description = "", required = true) @Valid @RequestBody People people
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"name\" : \"name\", \"id\" : \"id\", \"age\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /people : List all people
     *
     * @return An array of people (status code 200)
     */
    @Operation(
        operationId = "listPeople",
        summary = "List all people",
        tags = { "people" },
        responses = {
            @ApiResponse(responseCode = "200", description = "An array of people", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = People.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/people",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<People>> listPeople(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"firstName\" : \"firstName\", \"name\" : \"name\", \"id\" : \"id\", \"age\" : 0 }, { \"firstName\" : \"firstName\", \"name\" : \"name\", \"id\" : \"id\", \"age\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
