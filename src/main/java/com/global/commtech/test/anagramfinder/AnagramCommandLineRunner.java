package com.global.commtech.test.anagramfinder;

import com.global.commtech.test.anagramfinder.service.AnagramService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class AnagramCommandLineRunner implements CommandLineRunner {

    private final AnagramService anagramService;

    @Override
    public void run(final String... args) throws Exception {
        Assert.isTrue(args.length == 1, "Please ensure that the input file is provided");

        final File file = new File(args[0]);
        Assert.isTrue(file.exists(), args[0] + " Does not exist");
        try {
            anagramService.sortIntoAnagrams(Files.lines(file.toPath()));
        } catch (IOException e) {
            System.out.println("Error whilst reading file - " + e);
        }
    }
}
