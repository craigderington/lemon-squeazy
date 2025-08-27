### Lemon Squeazy
A Spring Boot application for generating secure random strings using Java's SecureRandom class.
Overview
Lemon Squeazy is a web-based random string generator built with Spring Boot. It uses Java's SecureRandom to create cryptographically secure strings with customizable length and character sets, accessible via a simple web interface.
Features

- Generates secure random strings with lengths between 1 and 100
- Customizable character sets: uppercase, lowercase, digits, and special characters
- Web interface for user input and result display
- Built with Spring Boot for easy setup and deployment
- Uses SecureRandom for cryptographically strong output

#### Getting Started
Prerequisites

- Java 17 or higher
- Maven 3.6+
- Spring Boot 3.x

#### Installation

Clone the repository:git clone https://github.com/craigderington/lemon-squeazy.git


Navigate to the project directory:
```
cd lemon-squeazy
```

Build the project:

```
mvn clean install
```

Run the application:
```
mvn spring-boot:run
```

#### Usage

Open your browser and navigate to http://localhost:8080/.
Enter the desired string length (1-100).
Select character types (uppercase, lowercase, digits, special characters).
Submit the form to generate a random string.
The generated string will be displayed on the page.

#### Code Details
The core logic in RandomStringGeneratorApplication.java includes:

- Spring Boot Application: 
- Configured with @SpringBootApplication and @Controller.
- Web Interface:
```
GET / renders the input form (index.html).
POST /generate processes user input and generates a random string.
```

#### String Generation: 
Uses SecureRandom to select characters from the specified character set.

#### Input Validation: Ensures length is 1-100 and at least one character type is selected.

#### Model Attributes: 
Passes the generated string and input parameters to the view.

#### Configuration
No additional configuration is required beyond the web interface inputs. The application dynamically builds the character set based on user selections.

#### Contributing
Contributions are welcome! To contribute:

#### Fork the repository.
Create a feature branch (git checkout -b feature/your-feature).
Commit your changes (git commit -m "Add your feature").
Push to the branch (git push origin feature/your-feature).
Open a pull request.

#### License
This project is licensed under the MIT License - see the LICENSE file for details.

#### Contact
For questions or feedback, contact Craig Derington.