    package com.claitonamaral.bookmanager.controller;

    import com.claitonamaral.bookmanager.dto.BookDTO;
    import com.claitonamaral.bookmanager.dto.MessageResponseDTO;
    import com.claitonamaral.bookmanager.exception.BookNotFoundException;
    import com.claitonamaral.bookmanager.service.BookService;
    import io.swagger.annotations.Api;
    import io.swagger.annotations.ApiOperation;
    import io.swagger.annotations.ApiResponse;
    import io.swagger.annotations.ApiResponses;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import javax.validation.Valid;

    @RestController
    @RequestMapping("/api/v1/books")
    @Api(value = "Livros")
    public class BookController {

        private final BookService bookService;

        @Autowired
        public BookController(BookService bookService) {
            this.bookService = bookService;
        }

        @PostMapping
        @ApiOperation(value = "Criação de livro",
                notes = "Este endpoint recebe dados para criar um novo livro.")
        public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
            return bookService.create(bookDTO);
        }

        @RequestMapping(path = "/{id}", method = RequestMethod.GET)
        @GetMapping("/{id}")
        @ApiOperation(value = "Exibição de um livro",
                notes = "Este endpoint recebe o ID de um livro " +
                        "e faz a busca na base dados, retornando os dados do livro e de seu autor.")
        @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = String.class)})
        public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
            return bookService.findById(id);
        }
    }
