package com.sp.services;

import com.sp.entities.Product;
import com.sp.entities.User;
import com.sp.repo.ProductRepository;
import com.sp.repo.UserRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){ return  productRepository.getOne(id);}

    public Product getProductByTitle(String title){ return productRepository.findOneByTitle(title);}

    public void deleteProductById(Long id){ productRepository.deleteById(id);}

    public void addNewUsername(String username, String password){
        userRepository.addUser(username, password);
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

}
