package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    /*public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }*/
    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        this.productRepository.deleteById(id);
    }

    //////////////////////////////
    /*public void  saveProductToDB(MultipartFile file, String name, String description, int quantity
            , Double price, String brand, String categories)
    {
        Product p = new Product();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a valid file");
        }
        try {
            p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()),400,400));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setDescription(description);

        p.setName(name);
        p.setPrice(price);
        p.setBrand(brand);
        p.setQuantity(quantity);
        Coupon c = new Coupon();
        c.setDiscount(0);
        p.setDiscount(c);
        p = addCategoriesToProduct(p,categories);
        productRepo.save(p);
    }*/

    public Product getProductById(Integer id) {

        return productRepository.findById(id).get();
    }

    public void changeProductName(Integer id ,String name)
    {
        Product p = new Product();
        p = productRepository.findById(id).get();
        p.setName(name);
        productRepository.save(p);
    }
    public void changeProductCaloric(Integer id , Double caloric)
    {
        Product p = new Product();
        p = productRepository.findById(id).get();
        p.setCaloric(caloric);
        productRepository.save(p);
    }
    public void changeProductProtein(Integer id, Double protein)
    {
        Product p = new Product();
        p = productRepository.findById(id).get();
        p.setProtein(protein);
        productRepository.save(p);
    }

    public void changeProductFat(Integer id, Double fat)
    {
        Product p = new Product();
        p = productRepository.findById(id).get();
        p.setFat(fat);
        productRepository.save(p);
    }

    public void changeProductCarbohydrates(Integer id, Double carbohydrates)
    {
        Product p = new Product();
        p = productRepository.findById(id).get();
        p.setCarbohydrates(carbohydrates);
        productRepository.save(p);
    }

    public void changeProductWeight(Integer id, Double weight) {
        Product p = new Product();
        p = productRepository.findById(id).get();
        p.setWeight(weight);
        productRepository.save(p);

    }

    /*public void addImageToProduct(MultipartFile file, Integer id) {

        Product p = productRepository.findById(id).get();
        Carousel carousel = new Carousel();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a valid file");
        }
        try {
            carousel.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()),400,400));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.getCarousel().add(carousel);
        productRepo.save(p);

    }

    private BufferedImage base64ToBufferedImage(String base64Img) {
        BufferedImage image = null;
        byte[] decodedBytes = Base64.getDecoder().decode(base64Img);

        try {
            image = ImageIO.read(new ByteArrayInputStream(decodedBytes));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return image;
    }

    private String bufferedImageTobase64(BufferedImage image ) throws UnsupportedEncodingException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "JPEG", Base64.getEncoder().wrap(out));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return out.toString(StandardCharsets.ISO_8859_1.name());
    }*/

}
