package com.example.instagram;

import com.example.instagram.model.Post;
import com.example.instagram.model.User;
import com.example.instagram.repository.PostRepository;
import com.example.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.instagram.service.UserNotFoundException;


import java.util.List;

@SpringBootApplication(scanBasePackages = "com.example.instagram")
public class InstagramApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstagramApplication.class, args);
    }

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;

    @Bean
    CommandLineRunner myCommandLineRunnerBean() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                // Création users

                User u1 = new User("user1", "user1@mail.fr", "Paris");
                User u2 = new User("user2", "user2@mail.fr", "Monaco");
                User u3 = new User("user3", "user3@mail.fr", "Madrid");

                User u4 = new User();
                u4.setName("user4");
                u4.setEmail("user4@gmail.fr");
                u4.setLocation("Amsterdam");
                //u4.setPost(p3);

                User u5 = new User();
                u5.setName("user5");
                u5.setEmail("user5@gmail.fr");
                u5.setLocation("Tokyo");
                //u5.setPost(p3);

                // Création posts
                Post p1 = new Post("Je me régale !", u1);
                Post p2 = new Post("Je suis en vacances :-)", u2);
                Post p3 = new Post("Une journée stressante...", u3);

                userRepo.saveAll(List.of(u1,u2,u3, u4, u5));
                postRepo.saveAll(List.of(p1,p2,p3));

                //Test :  une nouvelle instance de User & Post.
                /*User user = new User();
                user.setUsername("nom d'utilisateur");
                user.setPassword("mot de passe");

                Post post = new Post();
                post.setDescription("Description du post");
                post.setUser(user);

                // Test en bdd de la relation OneToOne :
                userRepo.save(user);
                postRepo.save(post);*/


            }
        };
    }
}
