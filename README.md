# ValidateMe

![License](https://img.shields.io/github/license/aaronrojas32/validateMe)
![Version](https://img.shields.io/badge/version-1.0.0-blue)

ValidateMe is a data validation library for Java that provides robust and easy-to-use methods for validating a wide variety of data types.

## Features

- **String Validation**: Check for non-empty strings, valid lengths, numeric and alphanumeric characters.
- **Phone Number Validation**: Validate phone numbers using Google's libphonenumber library.
- **Email Address Validation**: Ensure email addresses are in a valid format.
- **Credit Card Validation**: Verify credit card numbers using the Luhn algorithm.
- **Date and Time Validation**: Validate dates and times to ensure they conform to specified formats.
- **DNI Validation**: Validate national identification numbers for various countries.
- **IP Address Validation**: Check for valid IPv4 and IPv6 addresses.
- **URL Validation**: Ensure URLs are correctly formatted and accessible.

## Installation

To use ValidateMe in your project, you can download the .jar file from the Releases section of this repository. Then, add the .jar file to your project's build path.

## Usage

Here is an example of how to validate an email address using ValidateMe:

```java
import validation.EmailValidation;
import exception.ValidationException;

public class Main {
    public static void main(String[] args) {
        try {
            boolean isValid = EmailValidation.validateEmailAddress("example@example.com");
            System.out.println("Email is valid: " + isValid);
        } catch (ValidationException e) {
            System.err.println("Validation error: " + e.getMessage());
        }
    }
}
```

## Documentation

Comprehensive documentation and usage examples are available in the [doc](doc) directory of this repository. The documentation is updated with each release.

## Contributions

We love receiving contributions from the community! Please report any issues or request new features on our [GitHub repository](http://github.com/aaronrojas32/validateMe). Contributions can be made via pull requests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

**Thank you for using ValidateMe!**
