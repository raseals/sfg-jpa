package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.domain.Sensor;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default", "local"})
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner
{
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception
    {
        bookRepository.deleteAll();

        Book bookDDD = Book.builder()
                .title("Domain Driven Design")
                .isbn("123")
                .publisher("RandomHouse")
//                .sensor(Sensor.builder()
//                        .type("Foo")
//                        .sensorPosX(35.7236F)
//                        .sensorPosY(79.2938F)
//                        .sensorPosZ(-109.5719F)
//                        .build())
                .build();

        log.info("ID: {}", bookDDD.getId());

        Book savedDDD = bookRepository.save(bookDDD);

        log.info("ID: {}", savedDDD.getId());

        Book bookSIA = Book.builder()
                .title("Spring In Action")
                .isbn("234234")
                .publisher("Manning")
//                .sensor(Sensor.builder()
//                        .type("Bar")
//                        .sensorPosX(35.7236F)
//                        .sensorPosY(79.2938F)
//                        .sensorPosZ(-109.5719F)
//                        .build())
                .build();

        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            log.info("Book: {}", book.toString());
        });
    }
}
