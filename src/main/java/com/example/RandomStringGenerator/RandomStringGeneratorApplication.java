package com.example.RandomStringGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
@Controller
public class RandomStringGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomStringGeneratorApplication.class, args);
	}

	@GetMapping("/")
	public String index(Model model) {
		// model.addAttribute("generatedString", "");
		return "index";
	}

	@PostMapping("/generate")
	public String generateString(
			@RequestParam("length") int length,
			@RequestParam(value = "includeUppercase", defaultValue = "false") boolean includeUppercase,
			@RequestParam(value = "includeLowercase", defaultValue = "false") boolean includeLowercase,
			@RequestParam(value = "includeDigits", defaultValue = "false") boolean includeDigits,
			@RequestParam(value = "includeSpecial", defaultValue = "false") boolean includeSpecial,
			Model model) {

		if (length < 1 || length > 100) {
			model.addAttribute("error", "Length must be between 1 and 100...");
			// model.addAttribute("generatedString", "");
			return "index";
		}

		if (!includeUppercase && !includeLowercase && !includeDigits && !includeSpecial) {
			model.addAttribute("error", "At least one character type must be selected!");
			// model.addAttribute("generatedString", "");
			return "index";
		}

		String characters = "";
		if (includeUppercase) characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (includeLowercase) characters += "abcdefghijklmnopqrstuvwxyz";
		if (includeDigits) characters += "0123456789";
		if (includeSpecial) characters += "!@#$%^&*()-_=+[{]}|;:,.<>?";

		SecureRandom random = new SecureRandom();
		StringBuilder result = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			result.append(characters.charAt(random.nextInt(characters.length())));
		}

        model.addAttribute("generatedString", result.toString());
		model.addAttribute("length", length);
		model.addAttribute("includeUppercase", includeUppercase);
		model.addAttribute("includeLowercase", includeLowercase);
		model.addAttribute("includeDigits", includeDigits);
		model.addAttribute("includeSpecial", includeSpecial);
        return "index";
	}
}