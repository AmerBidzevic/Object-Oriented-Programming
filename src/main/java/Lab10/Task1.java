package Lab10;
import java.util.*;

import java.lang.annotation.*;
import java.lang.reflect.Method;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CanSendMessage{

}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface RequiresPermission {
    String level();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UserPermission{
    String level();
}

@UserPermission(level = "default")
    class RegularUser extends User{
        public RegularUser(String username){
            super(username);
        }
    }


@UserPermission(level = "admin")
    class AdminUser extends User{
    public AdminUser( String username){
        super(username);
    }
}

abstract class User{
    private String username;

    public User(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
    public String getPermissionLevel() {
        if (this.getClass().isAnnotationPresent(UserPermission.class)) {
            UserPermission annotation = this.getClass().getAnnotation(UserPermission.class);
            return annotation.level();
        }
        return "default";
    }

}

class MessagingSystem {

    @CanSendMessage
    @RequiresPermission(level = "admin")
    public void sendMessage(User user) {
        if ("admin".equals(user.getPermissionLevel())) {
            System.out.println("Admin " + user.getUsername() + " sent a message!");
        } else {
            System.out.println("User " + user.getUsername() + " is restricted from sending messages.");
        }
    }

    public static void main(String[] args) {
        User regularUser = new RegularUser("regularUser123");
        User adminUser = new AdminUser("adminUser456");

        MessagingSystem messagingSystem = new MessagingSystem();

        System.out.println("Attempting to send a message with a Regular User:");
        messagingSystem.sendMessage(regularUser);

        System.out.println("\nAttempting to send a message with an Admin User:");
        messagingSystem.sendMessage(adminUser);
    }
}