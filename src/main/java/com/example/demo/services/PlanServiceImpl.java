package com.example.demo.services;

import com.example.demo.entities.Exercise;
import com.example.demo.entities.Plan;
import com.example.demo.entities.Product;
import com.example.demo.repositories.PlanRepository;
import com.example.demo.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PlanServiceImpl implements PlanService{

    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Plan save(Plan pl) {
        return this.planRepository.save(pl);
    }

    //@Override
    //public Iterable<Plan> getAllPlan(Integer userId) {
    //    return this.plRepository.getAllPlan(userId);
    //}

    @Override
    public void deleteById(Integer id) {
        this.planRepository.deleteById(id);
    }

    public Plan addPlan( Double caloric){

        System.out.println("ijjjjjjjjjjjjjjjjjjjjjj");
        Plan plan = new Plan();
        plan.setPlusCaloric(caloric);
        plan.setId(160);
        return this.planRepository.save(plan);
    }

    public Plan addPlanFirstTime(Integer id, String sessionToken, Double caloric) {
        Plan plan = new Plan();
        //Product product = Product.builder()
        //        .id(id)
        //        .caloric(caloric)
        //        .build();
        //cartItem.setCa(caloric);
        //cartItem.setProduct(productService.getProductById(id));
        plan.setPlusCaloric(caloric);
        plan.setSessionToken(sessionToken);
        return this.planRepository.save(plan);

    }

    public Plan addToExistingPlan(Integer id, String sessionToken, Double caloric) {

        Plan plan = planRepository.findBySessionToken(sessionToken);
        Product p = productService.getProductById(id);
        Boolean productDoesExistInThePlan = false;
        if (plan != null) {
            Set<Product> items = plan.getProducts();
            for (Product item : items) {
                if (item.getId().equals(p)) {
                    productDoesExistInThePlan = true;
                    item.setCaloric(item.getCaloric() + caloric);
                    plan.setPlusCaloric(item.getCaloric());
                    return planRepository.save(plan);
                }

            }
        }
        if(!productDoesExistInThePlan && (plan != null))
        {
            plan.setPlusCaloric(caloric);
            plan.setSessionToken(sessionToken);
            return planRepository.save(plan);
        }

        return this.addPlanFirstTime(id, sessionToken, caloric);

    }

    public Plan getPlanBySessionTokent(String sessionToken) {

        return  this.planRepository.findBySessionToken(sessionToken);
    }

    /*public Plan updatePlanItem(Integer id, Double caloric) {
        Product prItem = productRepository.findById(id).get();
        prItem.setCaloric(caloric);
        return planRepository.save(prItem.getPlan());
    }*/

    public Plan removeFromPlan(Integer id, String sessionToken) {
        Plan plan = planRepository.findBySessionToken(sessionToken);
        Set<Product> items = plan.getProducts();
        Product prItem = null;
        for(Product item : items) {
            if(item.getId()==id) {
                prItem = item;
            }
        }
        items.remove(prItem);
        productRepository.delete(prItem);
        plan.setProducts(items);
        return planRepository.save(plan);
    }

    public void clearPlan(String sessionToken) {
        Plan plan = planRepository.findBySessionToken(sessionToken);
        this.planRepository.delete(plan);

    }

    public Plan getPlan(String planId) {

        return this.getPlan(planId);
    }

}
