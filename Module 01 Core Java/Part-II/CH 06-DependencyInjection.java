/*
 * Dependency Injection
 * --------------------
 * 
 * DEFINITION:
 *   - Dependency Injection (DI) is a design pattern where objects receive their dependencies
 *     from external sources rather than creating them internally
 *   - It's a way to implement Inversion of Control (IoC)
 * 
 * TYPES OF DEPENDENCY INJECTION:
 *   a) Constructor Injection (RECOMMENDED):
 *      - Dependencies passed through constructor
 *      - Ensures dependencies are available when object is created
 *      - Makes dependencies immutable (final fields)
 *      - Enables fail-fast behavior
 * 
 *   b) Setter Injection:
 *      - Dependencies set through setter methods
 *      - Allows optional dependencies
 *      - Can change dependencies at runtime
 *      - Risk of incomplete initialization
 * 
 *   c) Interface Injection (RARE):
 *      - Dependencies injected through interface methods
 *      - Less common in modern frameworks
 */

// ==================== INTERFACES ====================

/**
 * Service interface for email operations
 */
interface EmailService {
    void sendEmail(String to, String subject, String body);
}

/**
 * Service interface for notification operations
 */
interface NotificationService {
    void sendNotification(String message);
}

/**
 * Repository interface for user operations
 */
interface UserRepository {
    void saveUser(String username);
    String findUser(String username);
}

// ==================== IMPLEMENTATIONS ====================

/**
 * Gmail implementation of EmailService
 */
class GmailService implements EmailService {
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email via Gmail:");
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}

/**
 * Outlook implementation of EmailService
 */
class OutlookService implements EmailService {
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email via Outlook:");
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}

/**
 * SMS implementation of NotificationService
 */
class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

/**
 * Push notification implementation
 */
class PushNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending push notification: " + message);
    }
}

/**
 * Database implementation of UserRepository
 */
class DatabaseUserRepository implements UserRepository {
    @Override
    public void saveUser(String username) {
        System.out.println("Saving user to database: " + username);
    }
    
    @Override
    public String findUser(String username) {
        System.out.println("Finding user in database: " + username);
        return "User: " + username + " (from database)";
    }
}

/**
 * In-memory implementation of UserRepository
 */
class InMemoryUserRepository implements UserRepository {
    @Override
    public void saveUser(String username) {
        System.out.println("Saving user to memory: " + username);
    }
    
    @Override
    public String findUser(String username) {
        System.out.println("Finding user in memory: " + username);
        return "User: " + username + " (from memory)";
    }
}

// ==================== DEPENDENCY INJECTION EXAMPLES ====================

/**
 * Example 1: CONSTRUCTOR INJECTION (Recommended approach)
 * Dependencies are injected through the class constructor
 */
class UserService {
    // Dependencies are declared as final to ensure immutability
    private final EmailService emailService;
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    
    // Constructor injection - all dependencies are provided during object creation
    public UserService(EmailService emailService, 
                      UserRepository userRepository, 
                      NotificationService notificationService) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        
        // Validation can be added here
        if (emailService == null || userRepository == null || notificationService == null) {
            throw new IllegalArgumentException("Dependencies cannot be null");
        }
    }
    
    public void createUser(String username, String email) {
        // Use injected dependencies
        userRepository.saveUser(username);
        emailService.sendEmail(email, "Welcome!", "Your account has been created.");
        notificationService.sendNotification("New user registered: " + username);
    }
    
    public void findAndNotifyUser(String username) {
        String user = userRepository.findUser(username);
        notificationService.sendNotification("User found: " + user);
    }
}

/**
 * Example 2: SETTER INJECTION
 * Dependencies are injected through setter methods
 */
class OrderService {
    private EmailService emailService;
    private NotificationService notificationService;
    
    // Setter methods for dependency injection
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
    
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    
    public void processOrder(String customerEmail, String orderDetails) {
        // Check if dependencies are properly injected
        if (emailService == null) {
            throw new IllegalStateException("EmailService not injected");
        }
        if (notificationService == null) {
            throw new IllegalStateException("NotificationService not injected");
        }
        
        System.out.println("Processing order: " + orderDetails);
        emailService.sendEmail(customerEmail, "Order Confirmation", orderDetails);
        notificationService.sendNotification("Order processed successfully");
    }
}

/**
 * Example 3: INTERFACE INJECTION (Less common)
 * Dependencies are injected through interface methods
 */
interface EmailServiceInjector {
    void injectEmailService(EmailService emailService);
}

class ReportService implements EmailServiceInjector {
    private EmailService emailService;
    
    @Override
    public void injectEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
    
    public void generateAndSendReport(String recipient) {
        if (emailService == null) {
            throw new IllegalStateException("EmailService not injected");
        }
        
        String report = "Monthly Report: Sales data...";
        emailService.sendEmail(recipient, "Monthly Report", report);
    }
}

/**
 * Example 4: DEPENDENCY INJECTION WITHOUT FRAMEWORK (Manual DI)
 * Simple factory pattern for manual dependency injection
 */
class ServiceFactory {
    
    public static UserService createUserService(String emailProvider, String repositoryType, String notificationType) {
        // Create email service based on provider
        EmailService emailService;
        switch (emailProvider.toLowerCase()) {
            case "gmail":
                emailService = new GmailService();
                break;
            case "outlook":
                emailService = new OutlookService();
                break;
            default:
                emailService = new GmailService();
        }
        
        // Create repository based on type
        UserRepository userRepository;
        switch (repositoryType.toLowerCase()) {
            case "database":
                userRepository = new DatabaseUserRepository();
                break;
            case "memory":
                userRepository = new InMemoryUserRepository();
                break;
            default:
                userRepository = new InMemoryUserRepository();
        }
        
        // Create notification service based on type
        NotificationService notificationService;
        switch (notificationType.toLowerCase()) {
            case "sms":
                notificationService = new SMSNotificationService();
                break;
            case "push":
                notificationService = new PushNotificationService();
                break;
            default:
                notificationService = new SMSNotificationService();
        }
        
        // Return configured UserService with all dependencies
        return new UserService(emailService, userRepository, notificationService);
    }
}

/**
 * Example 5: SPRING BOOT STYLE ANNOTATIONS (Simulation)
 * This shows how Spring Boot would handle DI with annotations
 */
// @Component - Would mark this as a Spring component
// @Service - Would mark this as a Spring service
class SpringStyleUserService {
    
    // @Autowired - Would automatically inject the dependency
    // @Qualifier("gmailService") - Would specify which implementation to inject
    private final EmailService emailService;
    private final UserRepository userRepository;
    
    // @Autowired - Constructor injection (preferred in Spring)
    public SpringStyleUserService(EmailService emailService, UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
    }
    
    // @Transactional - Would handle database transactions
    public void createUserWithTransaction(String username, String email) {
        userRepository.saveUser(username);
        emailService.sendEmail(email, "Welcome!", "Your account has been created with transaction support.");
    }
}

// ==================== MAIN CLASS FOR DEMONSTRATION ====================

public class DependencyInjectionExamples {
    
    public static void main(String[] args) {
        System.out.println("=== Dependency Injection Examples ===\n");
        
        // Example 1: Constructor Injection
        System.out.println("1. Constructor Injection Example:");
        UserService userService = new UserService(
            new GmailService(),
            new DatabaseUserRepository(),
            new SMSNotificationService()
        );
        userService.createUser("john_doe", "john@example.com");
        userService.findAndNotifyUser("john_doe");
        System.out.println();
        
        // Example 2: Setter Injection
        System.out.println("2. Setter Injection Example:");
        OrderService orderService = new OrderService();
        orderService.setEmailService(new OutlookService());
        orderService.setNotificationService(new PushNotificationService());
        orderService.processOrder("customer@example.com", "Order #12345: Laptop x1");
        System.out.println();
        
        // Example 3: Interface Injection
        System.out.println("3. Interface Injection Example:");
        ReportService reportService = new ReportService();
        reportService.injectEmailService(new GmailService());
        reportService.generateAndSendReport("manager@example.com");
        System.out.println();
        
        // Example 4: Factory Pattern (Manual DI)
        System.out.println("4. Factory Pattern Example:");
        UserService factoryUserService = ServiceFactory.createUserService("outlook", "memory", "push");
        factoryUserService.createUser("jane_doe", "jane@example.com");
        System.out.println();
        
        // Example 5: Different configurations
        System.out.println("5. Different Configuration Example:");
        UserService anotherUserService = ServiceFactory.createUserService("gmail", "database", "sms");
        anotherUserService.createUser("bob_smith", "bob@example.com");
        System.out.println();
        
        demonstrateBenefits();
    }
    
    /**
     * Method to demonstrate the benefits of dependency injection
     */
    private static void demonstrateBenefits() {
        System.out.println("=== Demonstrating DI Benefits ===");
        
        // Flexibility: Same service with different implementations
        System.out.println("\nFlexibility - Same UserService with different email providers:");
        
        UserService gmailUserService = new UserService(
            new GmailService(), 
            new InMemoryUserRepository(), 
            new SMSNotificationService()
        );
        
        UserService outlookUserService = new UserService(
            new OutlookService(), 
            new InMemoryUserRepository(), 
            new SMSNotificationService()
        );
        
        System.out.println("Using Gmail service:");
        gmailUserService.createUser("user1", "user1@test.com");
        
        System.out.println("\nUsing Outlook service:");
        outlookUserService.createUser("user2", "user2@test.com");
    }
}

/*
 * Key Points About Dependency Injection: 
 * 
 * BENEFITS OF DEPENDENCY INJECTION:
 *    - LOOSE COUPLING: Classes depend on abstractions, not concrete implementations
 *    - TESTABILITY: Easy to mock dependencies for unit testing
 *    - FLEXIBILITY: Easy to swap implementations
 *    - MAINTAINABILITY: Changes to dependencies don't affect dependent classes
 *    - REUSABILITY: Classes can work with different implementations
 *    - SEPARATION OF CONCERNS: Object creation separated from business logic
 * 
 * SPRING BOOT DEPENDENCY INJECTION:
 *    - @Autowired: Automatically injects dependencies
 *    - @Component, @Service, @Repository: Mark classes for auto-detection
 *    - @Qualifier: Specify which implementation to inject when multiple exist
 *    - @Primary: Mark preferred implementation when multiple exist
 *    - @Configuration: Define beans programmatically
 *    - @Bean: Create and configure beans manually
 * 
 * COMMON SPRING BOOT ANNOTATIONS:
 *    - @SpringBootApplication: Main application class
 *    - @RestController: REST API controller
 *    - @RequestMapping: Map HTTP requests
 *    - @Value: Inject values from properties
 *    - @ConfigurationProperties: Bind external properties to objects
 * 
 * BEST PRACTICES:
 *    - Prefer constructor injection over setter injection
 *    - Use interfaces for dependencies to enable loose coupling
 *    - Validate dependencies (null checks)
 *    - Keep constructors simple (just assignment)
 *    - Use @Qualifier when multiple implementations exist
 *    - Avoid circular dependencies
 *    - Use @Lazy for expensive-to-create beans when needed
 * 
 * COMMON PITFALLS:
 *    - Circular dependencies (A depends on B, B depends on A)
 *    - Over-injection (too many dependencies in one class)
 *    - Injecting concrete classes instead of interfaces
 *    - Not handling null dependencies properly
 *    - Creating dependencies inside the dependent class (defeats the purpose)
 * 
 * TESTING WITH DEPENDENCY INJECTION:
 *    - Easy to create mock implementations for testing
 *    - Can inject test-specific implementations
 *    - @MockBean in Spring Boot for mocking beans
 *    - @TestConfiguration for test-specific configurations
 * 
 * SPRING BOOT DI CONTAINER LIFECYCLE:
 *    - Component scanning finds classes with @Component, @Service, etc.
 *    - Bean definitions are created
 *    - Dependencies are resolved
 *    - Beans are instantiated in correct order
 *    - Dependencies are injected
 *    - Post-construction methods are called (@PostConstruct)
 * 
 * ADVANCED CONCEPTS:
 *     - Conditional beans (@ConditionalOnProperty, @ConditionalOnClass)
 *     - Profiles (@Profile) for environment-specific configurations
 *     - Scopes (@Scope) - singleton, prototype, request, session
 *     - Bean lifecycle callbacks (@PostConstruct, @PreDestroy)
 *     - Events and listeners (@EventListener)
 */