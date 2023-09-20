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
                User u1 = new User("Caroline88", "user1@mail.fr", "Paris");
                u1.setProfilePic("https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=600");
                User u2 = new User("François Durand", "user2@mail.fr", "Monaco");
                u2.setProfilePic("https://images.pexels.com/photos/5220075/pexels-photo-5220075.jpeg?auto=compress&cs=tinysrgb&w=600");
                User u3 = new User("Coco", "user3@mail.fr", "Madrid");
                u3.setProfilePic("https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&w=600");

                User u4 = new User();
                u4.setUsername("Laetitia");
                u4.setEmail("user4@gmail.fr");
                u4.setLocation("Amsterdam");
                u4.setProfilePic("https://images.pexels.com/photos/1024989/pexels-photo-1024989.jpeg?auto=compress&cs=tinysrgb&w=600");

                User u5 = new User();
                u5.setUsername("MarcMarc");
                u5.setEmail("user5@gmail.fr");
                u5.setLocation("Tokyo");
                u5.setProfilePic("https://images.pexels.com/photos/1267051/pexels-photo-1267051.jpeg?auto=compress&cs=tinysrgb&w=600");

                // Création posts
                Post p1 = new Post("Je me régale !", "https://images.pexels.com/photos/1640775/pexels-photo-1640775.jpeg?auto=compress&cs=tinysrgb&w=600", u1);
                Post p2 = new Post("Je suis ENFIN en vacances :-)", "https://images.pexels.com/photos/879010/pexels-photo-879010.jpeg?auto=compress&cs=tinysrgb&w=600", u2);
                Post p3 = new Post("Comment ça va ? Une journée stressante pour moi...", "https://images.pexels.com/photos/4226221/pexels-photo-4226221.jpeg?auto=compress&cs=tinysrgb&w=600", u3);
                Post p4 = new Post("Weekend à la plage", "https://images.pexels.com/photos/1142984/pexels-photo-1142984.jpeg?auto=compress&cs=tinysrgb&w=600", u4);
                Post p5 = new Post("Chat à donner", "https://images.pexels.com/photos/1170986/pexels-photo-1170986.jpeg?auto=compress&cs=tinysrgb&w=600", u5);

                userRepo.saveAll(List.of(u1,u2,u3,u4,u5));
                postRepo.saveAll(List.of(p1,p2,p3,p4,p5));

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
