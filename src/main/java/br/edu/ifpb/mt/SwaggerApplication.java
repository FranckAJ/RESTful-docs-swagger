package br.edu.ifpb.mt;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

import br.edu.ifpb.mt.sdr.model.Author;
import br.edu.ifpb.mt.sdr.model.Book;
import br.edu.ifpb.mt.sdr.repository.AuthorRepository;
import br.edu.ifpb.mt.sdr.repository.BookRepository;
import br.edu.ifpb.mt.sdr.restController.AuthorRestController;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 */

@Configuration
@EnableAutoConfiguration
@EnableSwagger
@ComponentScan(basePackageClasses = { AuthorRestController.class })
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;
	
    @Autowired
    private SpringSwaggerConfig swaggerConfig;

	/**
	 * 
	 * @return
	 */
    @Bean
    public SwaggerSpringMvcPlugin groupOnePlugin() {
       return new SwaggerSpringMvcPlugin(swaggerConfig)
    		.apiVersion("1.0-RC")
    		.apiInfo(new ApiInfo("RESTful Books", "API example doc with Swagger", "", "fjunior.aragao@gmaillcom", "MIT", ""))
            .includePatterns("/authors.*?", "/books.*?")
            .swaggerGroup("admin");
    }
 

	/**
	 * create a new book in BD when start application
	 */
	@PostConstruct
	@Transactional
	public void onLoad() {

		Author joao = new Author();
		joao.setName("João");
		authorRepository.save(joao);

		Book book = new Book();
		book.setTitle("Spring MVC");
		book.setDescription("Description of book");
		book.setNumbeOfPages(320);

		book.addAuthor(joao);

		bookRepository.save(book);

	}
}
