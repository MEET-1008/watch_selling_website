package com.codeWithBrinda.controller;

import com.codeWithBrinda.Service.ImgService;
import com.codeWithBrinda.Service.ProductOrderService;
import com.codeWithBrinda.Service.ProductService;
import com.codeWithBrinda.Service.UserService;
import com.codeWithBrinda.entities.Product;
import com.codeWithBrinda.entities.ProductOrder;
import com.codeWithBrinda.entities.User;
import com.codeWithBrinda.forms.ProductForm;
import com.codeWithBrinda.helper.Helper;
import com.codeWithBrinda.helper.MessageHelper;
import com.codeWithBrinda.helper.MessageType;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/")
public class AdminController {


    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ImgService imgService;

    @Autowired
    ProductOrderService productOrderService;



    //    admin Dashboard page
    @PostMapping("/dashboard")
    public String adminDashboard(Model model, Authentication authentication) {
        System.out.println(" admin desboared her ");
        return "admin/dashboard";
    }

    //    user Dashboard page
    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }


    @GetMapping("product/add")
    public String addContactView(Model model, ProductForm productForm, BindingResult result, HttpSession session) {
        System.out.println("********* Get request in contact form ********");
        model.addAttribute("product", productForm);

        if (result.hasErrors()) {
            session.setAttribute("message", MessageHelper.builder().content("Please correct the following errors").type(MessageType.red).build());
            model.addAttribute("product", productForm);
        }

        return "admin/add_product";
    }

    @PostMapping("product/add")
    public String savecontact(@Valid ProductForm productForm, BindingResult result, Authentication authentication, Model model, HttpSession session) {
        System.out.println("********* post request in product form ********");


        if (result.hasErrors()) {
            session.setAttribute("message", MessageHelper.builder().content("Please correct the following errors").type(MessageType.red).build());
            System.out.println("data nathi malto ");
            model.addAttribute("product", productForm);
            return "admin/add_product";
        }


        String username = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(username);
        Product product = getProduct(productForm, user);


        System.out.println(" file name ::------ " + productForm.getProductImage().getOriginalFilename());

        if (productForm.getProductImage().getOriginalFilename() == null) {
            System.out.println("file j nathi aavti ");
        }

        String fileurl = imgService.UploadIMG(productForm.getProductImage());
        System.out.println(" file url " + fileurl);
        product.setProductImage(fileurl);
        productService.save(product);


        session.setAttribute("message", MessageHelper.builder().content("your product added successfully").type(MessageType.green).build());
        model.addAttribute("product", product);

        return "/admin/add_product";

    }

    private static Product getProduct(ProductForm productForm, User user) {
        Product product = new Product();


        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        product.setDescription(productForm.getDescription());
        product.setUser(user);


        return product;
    }

    @GetMapping("/all-order")
    public  String myorder(Authentication authentication, Model model) {

        String email = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(email);

        List<ProductOrder> allProductOrder = productOrderService.getAllProductOrder();

        model.addAttribute("order1", allProductOrder);

        return "admin/all-order";
    }

    @GetMapping("/listed-product")
    public  String Allproduct(Authentication authentication, Model model) {

        String email = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(email);

        List<Product> allProduct = productService.getAllProduct();

        model.addAttribute("product", allProduct);

        return "admin/listedproduct";
    }

    @GetMapping("/change-order-status")
    public String changeOrderStatus(Authentication authentication, Model model) {
        return "admin/change-order-status";
    }

    @GetMapping("/new-admin")
    public String newAdmin(Model model) {
        return "admin/new-admin";
    }

    @GetMapping("/delete/{id}")
    public  void deleteproduct(@PathVariable int id ) {

        productService.deleteProduct(id);

    }
}
